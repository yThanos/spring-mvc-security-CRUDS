<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
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