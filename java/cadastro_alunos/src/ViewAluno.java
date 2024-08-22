// importando o Scanner para leitura de dados
import java.util.Scanner;

public class ViewAluno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //instanciando as classes que serão utilizadas
        Aluno aluno = new Aluno();
        Endereco endereco = new Endereco();
        Cidade cidade = new Cidade();

        //criando variável para armazenar a opção escolhida pelo usuário
        int op;

        //criação do laço de repetição
        do {
            System.out.println("Escolha uma opção: \n1-Cadastrar Aluno \n2-Exibir Aluno \n0-Sair");
            op = sc.nextInt();

            switch (op){
                case 1:
                    //pedindo as informações para o usuário
                    System.out.println("Digite o registro de matrícula:");
                    //armazenando por meio da variável "sc" e os métodos do Scanner, aquilo dito pelo usuário
                    int registroMatricula = sc.nextInt();
                    System.out.println("Digite o nome do aluno:");
                    String nome = sc.next() + sc.nextLine();
                    //colocando as informações dentro do objeto
                    aluno.registroMatricula = registroMatricula;
                    aluno.nome = nome;

                    System.out.println("Digite o logradouro:");
                    String logradouro = sc.next() + sc.nextLine();
                    System.out.println("Digite o número:");
                    int numero = sc.nextInt();
                    System.out.println("Digite o CEP:");
                    String cep = sc.next() + sc.nextLine();
                    endereco.logradouro = logradouro;
                    endereco.numero = numero;
                    endereco.cep = cep;

                    System.out.println("Digite a cidade:");
                    String nomeCidade = sc.next() + sc.nextLine();
                    System.out.println("Digite o Estado:");
                    String estado = sc.next() + sc.nextLine();
                    cidade.nomeCidade = nomeCidade;
                    cidade.estado = estado;
                    //finalizando o case 1, para que não execute os seguintes
                    break;
                case 2:
                    System.out.println("Registro de Matrícula: " + aluno.registroMatricula + "\nNome: " + aluno.nome + "\nEndereço:" + endereco.logradouro + "," + endereco.numero + "," + endereco.cep + "\nCidade: " + cidade.nomeCidade + "," + cidade.estado);
                    break;
                case 0:
                    System.out.println("Finalizando o programa");
                    break;
                //para caso o usuário escolha outra opção que não seja válida
                default:
                    System.out.println("Opção Inválida!");
            }
        // fim do laço de repetição, que se da quando o usuário escolhe a opção 0
        }while (op != 0);

        //finalizando o Scanner
        sc.close();
    }

}

