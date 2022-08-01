<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container">
    <form:form method="post" action="/Farmacia/vendas/cadcli" modelAttribute="cli">
        <form:label path="nomcli">Nome: </form:label>
        <form:input path="nomcli" type="text" />

        <form:label path="cpfcli">CPF: </form:label>
        <form:input path="cpfcli" type="text" />
        <input type="submit" value="Cadastrar">
    </form:form>
</div>
</body>
</html>
