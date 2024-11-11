package fiap.com.fintech.servlet;

import fiap.com.fintech.dao.UsuarioDao;
import fiap.com.fintech.model.Usuario;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/cadastroUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CadastroUsuarioServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String profissao = request.getParameter("profissao");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario(nome, email, telefone, endereco, profissao, senha);

        UsuarioDao usuarioDao;
        try {
            usuarioDao = new UsuarioDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            usuarioDao.cadastrar(usuario);
            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao cadastrar usuário", e);
            response.sendRedirect("error.jsp");
        }
    }
}
