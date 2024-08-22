public class Aluno {

    //criação das variáveis da classe
    int registroMatricula;
    String nome;
    Endereco endereco;
    Cidade cidade;

    //criação dos construtores
    public Aluno(int registroMatricula, String nome) {
        this.registroMatricula =registroMatricula;
        this.nome = nome;
    }
    public Aluno(){

    }
}
