<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Open+Sans:ital,wght@0,300..800;1,300..800&family=Playpen+Sans:wght@100..800&family=SUSE&display=swap" rel="stylesheet">
</head>
<body>

 <div class="login-box">
     <h2>Login</h2>
<form action="login" method="post">

    <label for="email">E-mail:</label>
    <input type="text" id="email" name="email"><br>


    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha"><br>

    <input type="submit" value="Entrar">
<%
    String error = request.getParameter("error");
    if ("1".equals(error)) {
%>
    <p style="color:red; text-align: center">Email ou senha inválidos!</p>
<%
    }
%>

</form>
 </div>

</body>
</html>
