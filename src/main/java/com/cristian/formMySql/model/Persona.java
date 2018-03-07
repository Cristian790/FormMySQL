package com.cristian.formMySql.model;

public class Persona {
	
	private int id;
    private String nombre;
    private int edad;
    private String correo;
    private String pais;


    public Persona() {
    }

    public Persona(int id, String nombre,int edad, String correo, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.edad=edad;
        this.correo = correo;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
