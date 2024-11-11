package fiap.com.fintech.dao;

import fiap.com.fintech.connection.ConnectionFactory;
import fiap.com.fintech.model.Movimentacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimentacaoDao {
    private Connection conexao;

    public MovimentacaoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    //Método para obter todas as movimentações
    public List<Movimentacao> getAll() throws SQLException {
        List<Movimentacao> listaMovimentacoes = new ArrayList<>();

        String sql = "SELECT * FROM T_SIP_MOVIMENTACAO";
        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                Long idMovimentacao = resultSet.getLong("id_movimentacao");
                double valorMovimentacao = resultSet.getDouble("vl_movimentacao");
                double vlSaldo = resultSet.getDouble("vl_saldo");
                Date dtMovimentacao = resultSet.getDate("dt_movimentacao");
                String sgMovimentacao = resultSet.getString("sg_movimentacao");
                Long idConta = resultSet.getLong("id_conta");
                Movimentacao movimentacao = new Movimentacao(idMovimentacao, valorMovimentacao, vlSaldo, dtMovimentacao, sgMovimentacao, idConta);
                listaMovimentacoes.add(movimentacao);
            }
        }
        return listaMovimentacoes;
    }


    public void registrarMovimentacao(Movimentacao movimentacao) throws SQLException {
        String sql = "INSERT INTO T_SIP_MOVIMENTACAO (vl_movimentacao, vl_saldo, dt_movimentacao, sg_movimentacao, id_conta) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setDouble(1, movimentacao.getValorMovimentacao());
            stm.setDouble(2, movimentacao.getVlSaldo());
            stm.setDate(3, new java.sql.Date(movimentacao.getDtMovimentacao().getTime()));
            stm.setString(4, String.valueOf(movimentacao.getSgMovimentacao()));
            stm.setLong(5, movimentacao.getIdConta());
            stm.executeUpdate();
        }
    }

    public double calcularSaldo(Long idConta) throws SQLException {
        String sql = "SELECT SUM(CASE WHEN sg_movimentacao = 'E' THEN vl_movimentacao ELSE -vl_movimentacao END) AS saldo FROM T_SIP_MOVIMENTACAO WHERE id_conta = ?";
        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setLong(1, idConta);
            ResultSet rs = stm.executeQuery();
            return rs.next() ? rs.getDouble("saldo") : 0; // Retorna 0 se não houver movimentações
        }
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
