package fiap.com.fintech.dao;


import fiap.com.fintech.connection.ConnectionFactory;
import fiap.com.fintech.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDao {
    private Connection conexao;

    public ContaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    // Método para criar uma nova conta
    public void criarConta(Conta conta) throws SQLException {
        String sql = "INSERT INTO T_SIP_CONTA (nm_banco, sg_tipo_conta, id_usuario) VALUES (?, ?, ?)";
        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, conta.getNomeBanco());
            stm.setString(2, conta.getTipoConta());
            stm.setLong(3, conta.getIdUsuario());
            stm.executeUpdate();
        }
    }

    // Método para atualizar uma conta existente
    public void atualizarConta(Conta conta) throws SQLException {
        String sql = "UPDATE T_SIP_CONTA SET nm_banco = ?, sg_tipo_conta = ? WHERE id_conta = ?";
        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setString(1, conta.getNomeBanco());
            stm.setString(2, conta.getTipoConta());
            stm.setLong(3, conta.getIdConta());
            stm.executeUpdate();
        }
    }

    public void fecharConexao() throws SQLException {
        if (conexao != null) {
            conexao.close();
        }
    }
}
