<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Cadastro Funcionarios</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/Farmacia/admin/inicio">Farmacia</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/Farmacia/admin/funcionarios">Funcionarios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Farmacia/admin/produtos">Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Farmacia/admin/clientes">Clientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Farmacia/admin/vendas">Vendas</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <form:form method="post" action="cadastrar" modelAttribute="func">
        <form:label path="nomfun">Nome: </form:label>
        <form:input path="nomfun" type="text" />

        <form:label path="cpffun">CPF: </form:label>
        <form:input path="cpffun" type="text" />

        <form:label path="senha">Senha: </form:label>
        <form:input path="senha" type="password" />

        <form:select path="permissao.id">
            <c:forEach var="p" items="${perms}">
                <form:option value="${p.id}">${p.nome}</form:option>
            </c:forEach>
        </form:select>
        <input type="submit" value="Cadastrar">
    </form:form>
</div>
</body>
</html>