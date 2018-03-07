<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8>
        <title>Registros DB</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
    </head>
    
    <body>
        <div class="container">
            <div class="row">
                <h1>Jdbc Template</h1>
            </div>
            <div class="row">
                <p>
                    <a href="<c:url value="/add" />" class="btn btn-success">Agregar</a>
                </p>
                <table class="table table-bordered table striped table-hover">
                    <thread>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Edad</th>
                            <th>E-Mail</th>
                            <th>País</th>
                            <th>Acciones</th>
                        </tr>
                    </thread>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}"/></td>
                                <td><c:out value="${dato.nombre}"/></td>
                                <td><c:out value="${dato.edad}"/></td>
                                <td><c:out value="${dato.correo}"/></td>
                                <td><c:out value="${dato.telefono}"/></td>
                                <td>
                                    <a href="<c:url value="/edit?id=${dato.id}"/>" class="btn-success">Editar</a>
                                    <a href="<c:url value="/delete?id=${dato.id}"/>" class="btn-success">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>