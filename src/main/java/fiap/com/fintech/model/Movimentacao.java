package fiap.com.fintech.model;

import java.util.Date;

public class Movimentacao {
    private Long idMovimentacao;
    private double valorMovimentacao;
    private double vlSaldo;
    private Date dtMovimentacao;
    private String  sgMovimentacao; // 'E' para entrada, 'S' para saída
    private Long idConta;

    public Movimentacao(Long idMovimentacao, double valorMovimentacao, double vlSaldo, Date dtMovimentacao, String sgMovimentacao, Long idConta) {
        this.idMovimentacao = idMovimentacao;
        this.valorMovimentacao = valorMovimentacao;
        this.vlSaldo = vlSaldo;
        this.dtMovimentacao = dtMovimentacao;
        this.sgMovimentacao = sgMovimentacao;
        this.idConta = idConta;
    }

    public Movimentacao( double valorMovimentacao, double vlSaldo, Date dtMovimentacao, String sgMovimentacao, Long idConta) {
        this.valorMovimentacao = valorMovimentacao;
        this.vlSaldo = vlSaldo;
        this.dtMovimentacao = dtMovimentacao;
        this.sgMovimentacao = sgMovimentacao;
        this.idConta = idConta;
    }

    // Getters e Setters
    public Long getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Long idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public double getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(double valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public double getVlSaldo() {
        return vlSaldo;
    }

    public void setVlSaldo(double vlSaldo) {
        this.vlSaldo = vlSaldo;
    }

    public Date getDtMovimentacao() {
        return dtMovimentacao;
    }

    public void setDtMovimentacao(Date dtMovimentacao) {
        this.dtMovimentacao = dtMovimentacao;
    }

    public String getSgMovimentacao() {
        return sgMovimentacao;
    }

    public void setSgMovimentacao(String sgMovimentacao) {
        this.sgMovimentacao = sgMovimentacao;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }
}
