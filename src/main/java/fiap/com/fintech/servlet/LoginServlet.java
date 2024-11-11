package fiap.com.fintech.servlet;

import fiap.com.fintech.dao.UsuarioDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //pegando os dados do formulário
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            //criando a instância do DAO
            UsuarioDao usuarioDao = new UsuarioDao();
            //verificando se o usuário está autenticado
            boolean autenticado = usuarioDao.login(email, senha);

            if (autenticado) {
                //redireciona para a página dashboard.jsp se o login for bem sucedido
                response.sendRedirect("dashboard.jsp");
            } else {
                //se o login falhar, redireciona de volta para o login.jsp com mensagem de erro
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (SQLException e) {

            //caso haja erro no banco de dados, redireciona para uma página de erro
            System.err.println("Erro ao realizar login: " + e.getMessage());
            response.sendRedirect("error.jsp");
        }
    }
}
