<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  <title>Clientes</title>
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
  <h1>Clientes</h1>
  <h3><a href="/Farmacia/cli/cadastrar">Cadastrar novos</a></h3>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>Nome: </th>
      <th>CPF: </th>
      <th>Opções: </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${clientes}">
      <tr>
        <th>${c.nomcli}</th>
        <th>${c.cpfcli}</th>
        <th><a href="/Farmacia/cli/editar?cpfcli=${c.cpfcli}">Editar </a><p> </p>
          <a href="/Farmacia/cli/excluir?codcli=${c.codcli}"> Excluir</a></th>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
