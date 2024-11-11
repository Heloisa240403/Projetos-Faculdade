package fiap.com.fintech.model;

public class Usuario {

    private Long codigo;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String profissao;
    private String senha;

    public Usuario(){
    }

    public Usuario(Long codigo, String nome, String email, String telefone, String endereco, String profissao, String senha){
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.profissao = profissao;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String telefone, String endereco, String profissao, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.profissao = profissao;
        this.senha = senha;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public Long getCodigo(){
        return codigo;
    }
    public void setCodigo(Long codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}