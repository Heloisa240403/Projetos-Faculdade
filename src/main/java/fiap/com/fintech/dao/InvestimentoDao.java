package fiap.com.fintech.dao;

import fiap.com.fintech.connection.ConnectionFactory;
import fiap.com.fintech.model.Investimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvestimentoDao {
    private Connection conexao;

    public InvestimentoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrarInvestimento(Investimento investimento) throws SQLException {
        String sql = "INSERT INTO T_SIP_INVESTIMENTO (vl_total, vl_arrecadado, dt_inicial, dt_final, ds_investimento, id_conta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setDouble(1, investimento.getVlTotal());
            stm.setDouble(2, investimento.getVlArrecadado());
            stm.setDate(3, new java.sql.Date(investimento.getDtInicial().getTime()));
            stm.setDate(4, new java.sql.Date(investimento.getDtFinal().getTime()));
            stm.setString(5, investimento.getDsInvestimento());
            stm.setLong(6, investimento.getIdConta());
            stm.executeUpdate();
        }
    }

    public void registrarArrecadacao(Long idInvestimento, double valorArrecadado) throws SQLException {
        String sql = "UPDATE T_SIP_INVESTIMENTO SET vl_arrecadado = vl_arrecadado + ? WHERE id_investimento = ?";
        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setDouble(1, valorArrecadado);
            stm.setLong(2, idInvestimento);
            stm.executeUpdate();
        }
    }

    public double obterArrecadacao(Long idInvestimento) throws SQLException {
        String sql = "SELECT vl_arrecadado FROM T_SIP_INVESTIMENTO WHERE id_investimento = ?";
        try (PreparedStatement stm = conexao.prepareStatement(sql)) {
            stm.setLong(1, idInvestimento);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getDouble("vl_arrecadado");
            }
            return 0.0;
        }
    }
}