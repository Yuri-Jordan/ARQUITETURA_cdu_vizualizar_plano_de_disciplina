<%-- 
    Document   : showEmenta
    Created on : 28/06/2017, 23:19:01
    Author     : pablo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="br.ifrn.sigma.dominio.Matriz, br.ifrn.sigma.dominio.Componente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIGMA</title>
    </head>
    <body>
        <%
            Componente comp = (Componente) request.getAttribute("componente");
        %>
        <h2><%= comp.getEmenta()%></h2>
        

        <h3>Componentes Curriculares por Semestres</h3>
        <table border="1">
            <tr>
                <th>Nome do componente curricular</th>
                <th>Créditos</th>
                <th>Hora-aula</th>
                <th>Hora</th>
            </tr>
            <%	
                        out.println("<th colspan=\"4\">EMENTA</th>");
                
            %>
            <tr>
                <td><%= comp.getEmenta()%></td>
<!--                <td><= comp.getCreditos()%></td>
                <td><= comp.getHoraAula()%></td>
                <td>%= comp.getHora()%></td>-->
            </tr>
            
        </table>
    </body>
</html>