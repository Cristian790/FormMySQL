<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <meta  charset="UTF-8"/>
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />

    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Ingrese sus datos</h1>
            </div>
            <div>
            <form:form  method="POST" commandName="persona">
                    <hr>
                    <table>
                    <tr>
                    <td><form:errors path="*" element="div" cssClass="alert alert-danger"/></td>
                    </tr>
                    </table>
                    <table>
                    	<tr>
                        <td><form:label path="id">ID</form:label></td>
                        <td><form:input path="id" cssClass="form-control"/></td>
                        </tr>
                        
                    
                    <tr>
                        <td><form:label path="nombre">Nombre</form:label></td>
                        <td><form:input path="nombre" cssClass="form-control"/></td>
                        <td>Test</td>
     				</tr>                   
                   <tr>
                        <td><form:label path="correo">E-Mail</form:label></td>
                        <td><form:input path="correo" cssClass="form-control"/></td>
                    </tr> 
                    
                    <tr>
                        <td><form:label path="edad">Edad</form:label></td>
                        <td><form:input path="edad" cssClass="form-control"/></td>
                    </tr>
                    
                    <tr>
                        <td><form:label path="pais">País</form:label>
                        <td><form:select path="pais" cssClass="form-control">
                            <form:option value="Seleccione">Seleccione......</form:option>
                            <form:options items="${paisLista}"/>
                        </form:select></td>
                    </tr>
                    
                    <tr>
                    	<td><hr>
                    	<td><hr>
                    </tr>
                    <tr>
                    	<td>
                    	
                    	<td><input type="submit" value="         Enviar          " class="btn btn-success" />
                	</table>
             </form:form>
            </div>
                
        </div>
    </body>
</html>
