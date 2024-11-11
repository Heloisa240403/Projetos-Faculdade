<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/dashboard.css">
</head>
<body>
<div class="container">
    <!-- Sidebar -->
    <div class="sidebar">
        <h2>GESTORIAPP</h2>
        <img src="imagem/user.png" alt="Foto de Usuário" class="user-photo">
        <ul>
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Movimentação Bancária</a></li>
            <li><a href="#">Investimentos</a></li>
            <li><a href="#">Relatórios</a></li>
            <li><a href="#">Configurações</a></li>
            <li><a href="#">Sair</a></li>
        </ul>
    </div>

    <!-- Conteúdo principal -->
    <div class="main-content">
        <h1>Dashboard</h1>

        <div class="cards">
            <!-- Card de Saldo -->
            <div class="card">
                <h3>Saldo</h3>
                <p>R$ 10.000,00</p>
            </div>

            <!-- Card de Recebimentos -->
            <div class="card">
                <h3>Total de Recebimentos</h3>
                <p>R$ 15.000,00</p>
            </div>

            <!-- Card de Gastos -->
            <div class="card">
                <h3>Total de Gastos</h3>
                <p>R$ 5.000,00</p>
            </div>

            <!-- Card de Investimentos -->
            <div class="card">
                <h3>Total de Investimentos</h3>
                <p>R$ 8.000,00</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
