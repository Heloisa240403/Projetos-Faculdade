package fiap.com.fintech.dao;

import fiap.com.fintech.connection.ConnectionFactory;
import fiap.com.fintech.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    //Definindo atributo para armazenar a conexão com o banco
    private Connection conexao;

    public UsuarioDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    //Criação do construtor para instanciar a conexão criada pela Factory
    public void cadastrar(Usuario usuario) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_SIP_USUARIO (id_usuario, nm_usuario, tx_email, nr_telefone, tx_endereco, nm_profissao, tx_senha) VALUES (seq_usuario.NEXTVAL, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, usuario.getNome());
        stm.setString(2, usuario.getEmail());
        stm.setString(3, usuario.getTelefone());
        stm.setString(4, usuario.getEndereco());
        stm.setString(5, usuario.getProfissao());
        stm.setString(6, usuario.getSenha());
        stm.executeUpdate();
    }

    // Método para autenticar o usuário (login)
    public boolean login(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM t_sip_usuario WHERE tx_email = ? AND tx_senha = ?";
        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, email);
            stm.setString(2, senha);
            ResultSet rs = stm.executeQuery();
            return rs.next(); // Se retornar um registro, a autenticação foi bem-sucedida
        }
    }

    // Método para obter todos os usuários cadastrados
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id_usuario, nm_usuario, tx_email, nr_telefone, tx_endereco, nm_profissao, tx_senha FROM T_SIP_USUARIO";

        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id_usuario");
                String nome = rs.getString("nm_usuario");
                String email = rs.getString("tx_email");
                String telefone = rs.getString("nr_telefone");
                String endereco = rs.getString("tx_endereco");
                String profissao = rs.getString("nm_profissao");
                String senha = rs.getString("tx_senha");

                Usuario usuario = new Usuario(id, nome, email, telefone, endereco, profissao, senha);
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}