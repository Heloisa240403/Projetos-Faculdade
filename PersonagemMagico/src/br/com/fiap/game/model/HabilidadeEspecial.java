package br.com.fiap.game.model;

public class HabilidadeEspecial {

    private String nome;
    private int custoEnergia;
    private boolean habilitada;

    public HabilidadeEspecial(String nome, int custoEnergia, boolean habilitada) {
        this.nome = nome;
        this.custoEnergia = custoEnergia;
        this.habilitada = habilitada;
    }

    public void ativarHabilidade(){
        habilitada = true;
    }

    public String getNome() {
        return nome;
    }

    public int getCustoEnergia() {
        return custoEnergia;
    }

    public boolean getHabilitada() {
        return habilitada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCustoEnergia(int custoEnergia) {
        this.custoEnergia = custoEnergia;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }
}

