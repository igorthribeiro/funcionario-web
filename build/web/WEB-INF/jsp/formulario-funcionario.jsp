<%-- 
    Document   : formulario-funcionario
    Created on : 08/08/2018, 01:51:42
    Author     : igordev
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcion&aacute;rio</title>
    </head>
    <body>
        <form action="salvaFuncionario" method="POST">
            <h1>Funcion&aacute;rio</h1><hr />
            <table>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nome" value="${funcionario.nome}"/></td>
                </tr>
                <tr>
                    <td>Sexo:</td>
                    <td><input type="text" name="sexo" value="${funcionario.sexo}"/></td>
                </tr>
                <tr>
                    <td>Idade:</td>
                    <td><input type="text" name="idade" value="${funcionario.idade}"/></td>
                </tr>
                <tr>
                    <td>Cidade:</td>
                    <td><input type="text" name="cidade" value="${funcionario.cidade}"/></td>
                </tr>
                <tr>
                    <td>UF:</td>
                    <td><input type="text" name="estado" value="${funcionario.estado}"/></td>
                </tr>
                <tr>
                    <td>Sal&aacute;rio:</td>
                    <td><input type="text" name="salario" value="${funcionario.salario}"/></td>
                </tr>
            </table><br />
            <c:if test="${not empty funcionario.codigo}">
                <input type="hidden" name="codigo" value="${funcionario.codigo}" />
            </c:if>
            <input type="submit" value="Gravar" />
        </form><br /><br />
        <a href="/funcionario-web">voltar para o menu</a>
    </body>
</html>
