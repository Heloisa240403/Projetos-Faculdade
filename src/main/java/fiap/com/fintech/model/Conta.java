package fiap.com.fintech.model;

public class Conta {
    private Long idConta;
    private String nomeBanco;
    private String tipoConta;
    private Long idUsuario;

    public Conta(Long idConta, String nomeBanco, String tipoConta, Long idUsuario) {
        this.idConta = idConta;
        this.nomeBanco = nomeBanco;
        this.tipoConta = tipoConta;
        this.idUsuario = idUsuario;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
