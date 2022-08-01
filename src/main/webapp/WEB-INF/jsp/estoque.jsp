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
    <h1>Produtos</h1>
    <h3><a href="/Farmacia/estoque/cadastrar">Cadastrar novos</a></h3>
    <h4><a href="/Farmacia/estoque/sair">Sair</a> </h4>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nome: </th>
            <th>Valor: </th>
            <th>Opções: </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${produtos}">
            <tr>
                <th>${p.nompro}</th>
                <th>${p.valor}</th>
                <th><a href="/Farmacia/estoque/editar?codpro=${p.codpro}">Editar </a><p> </p>
                    <a href="/Farmacia/estoque/excluir?codpro=${p.codpro}"> Excluir</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
