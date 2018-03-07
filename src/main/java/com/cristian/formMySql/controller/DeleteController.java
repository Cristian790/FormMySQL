package com.cristian.formMySql.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cristian.formMySql.connection.Conexion;

@Controller

public class DeleteController {
	
private JdbcTemplate jdbcTemplate;
    
    public DeleteController()
    {
        Conexion con=new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update("delete from usuarios where id=?",id);
        return new ModelAndView("redirect:/data");
    }
}
