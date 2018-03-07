package com.cristian.formMySql.controller;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cristian.formMySql.connection.Conexion;

@Controller
public class DataController {
	
	 private JdbcTemplate jdbcTemplate;
	    
	    public DataController()
	    {
	        Conexion con=new Conexion();
	        this.jdbcTemplate=new JdbcTemplate(con.conectar());
	    }
	    
	    @RequestMapping("/data")
	    public ModelAndView data()
	    {
	        ModelAndView mav=new ModelAndView();
	        String sql="Select * from usuarios order by id asc";
	        List datos=this.jdbcTemplate.queryForList(sql);
	        mav.addObject("datos", datos);
	        mav.setViewName("data");
	        return mav;
	    }
}
