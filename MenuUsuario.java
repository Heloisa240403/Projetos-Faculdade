import java.util.ArrayList;
import java.util.Scanner;

public class MenuUsuario {
    public static void main(String[] args) {
        boolean shouldRedirect = false;
        Scanner sc = new Scanner(System.in);
        Usuario user = new Usuario();
        int op;
        do {
            System.out.println("Seja Bem-vindo!");
            // Criando menu de login
            System.out.println("1- Fazer Login \n2- Cadastrar");
            // Criando variável para armazenar a opção
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o nome e a senha para login:");
                    System.out.println("Nome: ");
                    String nome = sc.next() + sc.nextLine();
                    System.out.println("Senha: ");
                    String senha = sc.next() + sc.nextLine();
                    user.Login(nome, senha);
                    shouldRedirect = true;
                    break;
                case 2:
                    System.out.println("Preencha os dados para criar sua conta!");
                    System.out.println("Nome: ");
                    String name = sc.next() + sc.nextLine();
                    System.out.println("Senha: ");
                    String password = sc.next() + sc.nextLine();
                    user.addUsuario(name, password);
                    //Realizando o redirecionamento para a próxima etapa
                    shouldRedirect = false;
            }
        } while (shouldRedirect);

        if (!shouldRedirect) {
            System.out.println("\nRedirecionando...");
        }
        System.out.println("\nMenu do Usuário");
        //criando novo menu
        int opMP;

        do {
            //System.out.println("1- Fazer Login \n2- Cadastrar");
            System.out.println("\n 1- Recebimentos \n 2- Gastos \n 3- Investimentos \n 4- Saldo Atual \n 5- Sair");
            opMP = sc.nextInt();

            switch (opMP) {
                case 1:
                    recebimentos(sc);
                    break;
                case 2:
                    despesa(sc);
                    break;
                case 3:
                    investimentos(sc);
                    break;
                case 4:
                    saldoAtual(sc);
                case 5:
                    System.out.println("Saindo...");
            }
        } while (opMP !=5);

    }

    //criação de métodos para utilização do segundo menu
    private static void recebimentos(Scanner sc) {
        Debito debito = new Debito();
        //trazendo a lista da classe Debito
        ArrayList<Integer> listaDeDebitos = new ArrayList<>();
        int opRecebimento;
        do {
            System.out.println("Escolha uma opção: \n 1- Mostrar Recebimentos \n 2- Adicionar novo Recebimento \n 3- Total Recebido \n 4- Retornar ao Menu Principal");
            opRecebimento = sc.nextInt();

            switch (opRecebimento) {
                case 1:
                    Debito.mostrarDebitos(listaDeDebitos);
                    break;
                case 2:
                    System.out.println("Digite o valor recebido: R$");
                    double valor = sc.nextDouble();
                    debito.addDebito(valor);
                    break;
                case 3:
                    Debito.somarDebitos(listaDeDebitos);
                    break;
                case 4:
                    System.out.println("Retornando ao menu...");
                    break;
            }
        } while (opRecebimento != 4);
    }

    private static void despesa(Scanner sc){
        ArrayList<Integer> listaDeDespesas = new ArrayList<>();
        Despesa despesa = new Despesa();
        int opDespesa;

        do {
            System.out.println("Escolha uma opção: \n 1- Mostrar Gastos \n 2- Adicionar novo Gasto \n 3- Total Gasto \n 4- Retornar ao Menu Principal");
            opDespesa = sc.nextInt();

            switch (opDespesa) {
                case 1:
                    Despesa.mostrarDespesas(listaDeDespesas);
                    break;
                case 2:
                    System.out.println(" Digite o valor gasto: R$");
                    double valor = sc.nextDouble();
                    despesa.addDespesa(valor);
                    break;
                case 3:
                    Despesa.somarDespesas(listaDeDespesas);
                    break;
                case 4:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
            }
        } while (opDespesa != 4);
    }

    private static void investimentos(Scanner sc){
        ArrayList<Integer> listaDeInvestimentos = new ArrayList<>();
        Investimento invest = new Investimento();
        int opInvest;

        do {
            System.out.println("Escolha uma opção: \n 1- Mostras Investimentos \n 2- Adicionar novo Investimento \n 3- Total Investido \n 4- Retornar ao Menu Principal");
            opInvest = sc.nextInt();

            switch (opInvest) {
                case 1:
                    Investimento.mostrarInvestimentos(listaDeInvestimentos);
                    break;
                case 2:
                    System.out.println(" Digite o valor investido: R$");
                    double valor = sc.nextDouble();
                    invest.addInvestimento(valor);
                    break;
                case 3:
                    Investimento.somarInvestimentos(listaDeInvestimentos);
                    break;
                case 4:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                 }
            } while (opInvest != 4);
        }

    private static void saldoAtual(Scanner sc){
        System.out.println("Saldo Atual");
    }
}

