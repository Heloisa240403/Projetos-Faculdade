<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movimentação Bancária</title>
    <link rel="stylesheet" href="css/movimentacao.css">
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
        <h1>Movimentação Bancária</h1>

        <div class="columns">
            <!-- Coluna de Despesas -->
            <div class="column despesas">
                <h2>Despesas</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Descrição</th>
                        <th>Data</th>
                        <th>Valor</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Compra de Material</td>
                        <td>10/11/2024</td>
                        <td>R$ 200,00</td>
                    </tr>
                    <tr>
                        <td>Pagamento de Conta</td>
                        <td>05/11/2024</td>
                        <td>R$ 150,00</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <!-- Coluna de Recebimentos -->
            <div class="column recebimentos">
                <h2>Recebimentos</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Descrição</th>
                        <th>Data</th>
                        <th>Valor</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Pagamento Cliente A</td>
                        <td>09/11/2024</td>
                        <td>R$ 500,00</td>
                    </tr>
                    <tr>
                        <td>Pagamento Cliente B</td>
                        <td>08/11/2024</td>
                        <td>R$ 300,00</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
