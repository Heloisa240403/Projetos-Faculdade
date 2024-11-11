package fiap.com.fintech.model;

import java.util.Date;

public class Investimento {
    private Long idInvestimento;
    private double vlTotal;
    private double vlArrecadado;
    private Date dtInicial;
    private Date dtFinal;
    private String dsInvestimento;
    private Long idConta;

    public Investimento(Long idInvestimento, double vlTotal, double vlArrecadado, Date dtInicial, Date dtFinal, String dsInvestimento, Long idConta) {
        this.idInvestimento = idInvestimento;
        this.vlTotal = vlTotal;
        this.vlArrecadado = vlArrecadado;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        this.dsInvestimento = dsInvestimento;
        this.idConta = idConta;
    }

    public Long getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(Long idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public double getVlArrecadado() {
        return vlArrecadado;
    }

    public void setVlArrecadado(double vlArrecadado) {
        this.vlArrecadado = vlArrecadado;
    }

    public Date getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(Date dtInicial) {
        this.dtInicial = dtInicial;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    public String getDsInvestimento() {
        return dsInvestimento;
    }

    public void setDsInvestimento(String dsInvestimento) {
        this.dsInvestimento = dsInvestimento;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }
}
