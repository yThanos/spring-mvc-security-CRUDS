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
<h2>Cliente: ${cliente_selecionado.nomcli}</h2>
<form:form method="post" action="/Farmacia/vendas/cadven" modelAttribute="car">
    <form:input path="clicar.codcli" type="hidden" value="${cliente_selecionado.codcli}"/>

    <form:label path="procar.codpro">Produto: </form:label>
    <form:select path="procar.codpro">
        <c:forEach var="p" items="${prods}">
            <form:option value="${p.codpro}">${p.nompro}</form:option>
        </c:forEach>
    </form:select>

    <form:label path="qnt">qtd: </form:label>
    <form:input path="qnt" type="text" />
    <input type="submit" value="Adicionar">
</form:form>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Produto: </th>
        <th>Qtd: </th>
        <th>Opção: </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="v" items="${vendas}">
        <tr>
            <th>${v.procar.nompro}</th>
            <th>${v.qnt}</th>
            <th><a href="/Farmacia/vendas/delven?codcar=${v.codcar}">Remover</a> </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/Farmacia/vendas/fim">Comfirmar compra!</a>
<a href="/Farmacia/vendas/fim">Cancelar!</a>
</div>
</body>
</html>
