<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8>
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/" />">Home</a></li>
                
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar</div>
                <div class="panel-body">
                   
                        <form:form method="POST" commandName="persona">
                    <hr>
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    
                    <p>
                        <form:label path="nombre">Nombre</form:label>
                        <form:input path="nombre" cssClass="form-control"/>
                    </p>
                    <p>
                        <form:label path="edad">Edad</form:label>
                        <form:input path="edad" cssClass="form-control"/>
                        
                    </p>
                    <p>
                        <form:label path="correo">E-Mail</form:label>
                        <form:input path="correo" cssClass="form-control"/>
                        
                    </p>
                    <p>
                        <form:label path="pais">País</form:label>
                        <form:select path="pais" cssClass="form-control">
                            <form:option value="Seleccione">Seleccione......</form:option>
                            <form:options items="${paisLista}"/>
                        </form:select>
                    </p>
                    <hr>
                    <input type="submit" value="Editar" class="btn btn-success"/>
                
                </form:form>
                </div>
            </div>
        </div>
    </body>
</html>


    