<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Vendas</title>
</head>
<body>
<div class="container">
    <h1>Vendas</h1>
    <form:form method="post" action="/Farmacia/vendas/seleciona" modelAttribute="login">
        <form:label path="cpf">CPF: </form:label>
        <form:input path="cpf" type="text"/>
        <input type="submit" value="Prosseguir">
    </form:form>
    <h3><a href="/Farmacia/vendas/cadcli">Cliente não possui cadastro!</a></h3>
    <h4><a href="/Farmacia/vendas/sair">Sair!</a> </h4>
</div>
</body>
</html>
