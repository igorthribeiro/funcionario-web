<%-- 
    Document   : formulario-funcionario
    Created on : 08/08/2018, 01:51:42
    Author     : igordev
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcion&aacute;rio</title>
    </head>
    <body>
        <form action="salvaFuncionario" method="post">
            <h1>Funcion&aacute;rio</h1><hr />
            <table>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nome" /></td>
                </tr>
                <tr>
                    <td>Sexo:</td>
                    <td><input type="text" name="sexo" /></td>
                </tr>
                <tr>
                    <td>Idade:</td>
                    <td><input type="text" name="idade" /></td>
                </tr>
                <tr>
                    <td>Cidade:</td>
                    <td><input type="text" name="cidade" /></td>
                </tr>
                <tr>
                    <td>UF:</td>
                    <td><input type="text" name="estado" /></td>
                </tr>
                <tr>
                    <td>Sal&aacute;rio:</td>
                    <td><input type="text" name="salario" /></td>
                </tr>
            </table><br />
            <input type="submit" value="Gravar" />
        </form><br /><br />
        <a href="/funcionario-web">voltar para o menu</a>
    </body>
</html>
