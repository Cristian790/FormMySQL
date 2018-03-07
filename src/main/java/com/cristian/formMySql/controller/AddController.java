package com.cristian.formMySql.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
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
public class AddController {

	private PersonaValidar personaValidar;
    private JdbcTemplate jdbcTemplate;

    public  AddController()  
    {
    	Conexion conexion=new Conexion();
        this.personaValidar=new PersonaValidar();
        this.jdbcTemplate=new JdbcTemplate(conexion.conectar());
    }    
    
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public ModelAndView add()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add");
        mav.addObject("persona", new Persona());
        return mav;
    }
    
    //Recibir y validar los datos del formulario
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public ModelAndView add(
                                        @ModelAttribute("persona") Persona p,
                                        BindingResult result,
                                        SessionStatus status)
    {
        this.personaValidar.validate(p, result);
        if(result.hasErrors())
        {
            //acá volvemos al formulario porque los datos
            //ingresados no son correctos, es decir, se ejecutó la validación
            ModelAndView mav=new ModelAndView();
            mav.setViewName("add");
            mav.addObject("persona");
            return mav;
        }
        else
        {
            //el usuario ingresó bien los datos
        	 this.jdbcTemplate.update
             ("Insert into usuarios values(?,?,?,?,?)",
              p.getId(),p.getNombre(),p.getEdad(),p.getCorreo(),p.getPais());
        	 return new ModelAndView("redirect:/data");
        }
    }
    // metodo para poblar el select
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
	
}
