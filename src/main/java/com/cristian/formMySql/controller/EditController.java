package com.cristian.formMySql.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cristian.formMySql.connection.Conexion;
import com.cristian.formMySql.model.Persona;
import com.cristian.formMySql.model.PersonaValidar;

@Controller
@RequestMapping("/edit")
public class EditController {
	
	private PersonaValidar personaValidar;
    private JdbcTemplate jdbcTemplate;
    
    public EditController()
    {
        this.personaValidar=new PersonaValidar();
        Conexion con =new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        Persona datos=this.selectPersona(id);
        mav.setViewName("edit");
        mav.addObject("persona", new Persona(datos.getId(),datos.getNombre(),
                             datos.getEdad(),datos.getCorreo(),datos.getPais()));
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView edit
                                 (@ModelAttribute("persona") Persona p,
                                  BindingResult result,
                                  SessionStatus status,
                                  HttpServletRequest request)
    {
        this.personaValidar.validate(p, result);
        if(result.hasErrors())
        {
          ModelAndView mav=new ModelAndView();  
          int id=Integer.parseInt(request.getParameter("id"));
          Persona datos=this.selectPersona(id);
          mav.setViewName("edit");
          mav.addObject("persona");
          return mav;
        }
        else
        {
            int id=Integer.parseInt(request.getParameter("id"));
            this.jdbcTemplate.update
                                        ("UPDATE usuarios set nombre=?,edad=?,correo=?,telefono=? WHERE id=?",
                                          p.getNombre(),p.getEdad(),p.getCorreo(),p.getPais(),id);
            return new ModelAndView("redirect:/data");
        }
        
        
    }
    
    @ModelAttribute("paisLista")
    public Map<String,String> listadoPaises()
    {
        Map<String,String> pais=new LinkedHashMap<String, String>();
        pais.put("Chile", "Chile");
        pais.put("Brasil", "Brasil");
        pais.put("México", "México");
        pais.put("España", "España");
        pais.put("Argentina", "Argentina");
        pais.put("Ecuador", "Ecuador");
        pais.put("Bolivia", "Bolivia");
        pais.put("Venezuela", "Venezuela");

        
        return pais;

    }
    
    public Persona selectPersona(int id)
    {
        final Persona persona=new Persona();
        String sql="Select * from usuarios where id='"+id+"'";
        return (Persona) jdbcTemplate.query(sql, new ResultSetExtractor<Persona>()
        {
            public Persona extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    persona.setId(rs.getInt("id"));
                    persona.setNombre(rs.getString("nombre"));
                    persona.setEdad(rs.getInt("edad"));
                    persona.setCorreo(rs.getString("correo"));
                    persona.setPais(rs.getString("telefono"));
                }
                return persona;
            }
        });
    }
}
	