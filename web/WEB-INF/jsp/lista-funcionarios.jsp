<%-- 
    Document   : lista-funcionarios
    Created on : 08/08/2018, 02:33:06
    Author     : igordev
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
    </head>
    <body>
        <h1>Lista de funcion&aacute;rios</h1><hr />
        <table>
            <thead>
                <tr>
                    <th>C&oacute;digo</th>
                    <th>Nome</th>
                    <th>Sexo</th>
                    <th>Idade</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                    <th>Sal&aacute;rio</th>
                </tr>
            </thead>
            <c:forEach items="${funcionarios}" var="f" varStatus="id">
                <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
                    <td>${f.codigo}</th>
                    <td>${f.nome}</td>
                    <td>${f.sexo}</td>
                    <td>${f.idade}</td>
                    <td>${f.cidade}</td>
                    <td>${f.estado}</td>
                    <td align="right"><fmt:formatNumber type="currency" value="${f.salario}" /></td>
                    <td><a href="removeFuncionario?codigo=${f.codigo}">Remover</a></td>
                    <td><a href="mostraFuncionario?codigo=${f.codigo}">Alterar</a></td>
                </tr>
            </c:forEach>
        </table><hr />
        <a href="/funcionario-web">voltar para o menu</a>
    </body>
</html>
