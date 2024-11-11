<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro de Usuário</title>
  <link rel="stylesheet" href="css/styles.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Open+Sans:ital,wght@0,300..800;1,300..800&family=Playpen+Sans:wght@100..800&family=SUSE&display=swap" rel="stylesheet">
</head>
<body>

<div class="login-box">
  <h2>Cadastro de Usuário</h2>
  <form action="cadastroUsuario" method="post">
    <div class="form-grid">

      <div class="left-column">
        <div>
          <label for="nome">Nome:</label>
          <input type="text" id="nome" name="nome" required>
        </div>

        <div>
          <label for="email">E-mail:</label>
          <input type="email" id="email" name="email" required>
        </div>

        <div>
          <label for="telefone">Telefone:</label>
          <input type="tel" id="telefone" name="telefone" required>
        </div>

        <div>
          <label for="endereco">Endereço:</label>
          <input type="text" id="endereco" name="endereco" required>
        </div>
      </div>

      <div class="right-column">
        <div>
          <label for="profissao">Profissão:</label>
          <input type="text" id="profissao" name="profissao" required>
        </div>

        <div>
          <label for="senha">Senha:</label>
          <input type="password" id="senha" name="senha" required>
        </div>

        <div>
          <label for="confirmacaoSenha">Confirmar Senha:</label>
          <input type="password" id="confirmacaoSenha" name="confirmacaoSenha" required>
        </div>
      </div>
    </div>

    <!-- Botão Cadastrar -->
    <div class="submit-btn">
      <input type="submit" value="Cadastrar">
    </div>

    <%
      String error = request.getParameter("error");
      if ("1".equals(error)) {
    %>
    <p style="color:red; text-align: center">Erro no cadastro! Verifique os dados informados.</p>
    <%
      }
    %>
  </form>
</div>

</body>
</html>