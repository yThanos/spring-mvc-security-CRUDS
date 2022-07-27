<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
<div class="container">
    <h1>Login</h1>
    <form:form method="post" action="/Farmacia/login" modelAttribute="login">
        <form:label path="cpf">CPF: </form:label>
        <form:input path="cpf" type="text"/>

        <form:label path="senha">Senha: </form:label>
        <form:input path="senha" type="password"/>

        <input type="submit" value="Login">
    </form:form>
</div>
</body>
</html>