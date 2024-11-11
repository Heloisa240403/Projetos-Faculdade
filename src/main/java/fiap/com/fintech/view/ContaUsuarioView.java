package fiap.com.fintech.view;

import fiap.com.fintech.dao.ContaDao;
import fiap.com.fintech.model.Conta;

import java.sql.SQLException;
import java.util.Scanner;

public class ContaUsuarioView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaDao contaDao;

        try {
            contaDao = new ContaDao();
            int escolha;

            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Criar nova conta");
                System.out.println("2 - Atualizar conta existente");
                System.out.println("0 - Sair");
                escolha = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                switch (escolha) {
                    case 1:
                        criarConta(scanner, contaDao);
                        break;
                    case 2:
                        atualizarConta(scanner, contaDao);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (escolha != 0);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void criarConta(Scanner scanner, ContaDao contaDao) {
        System.out.println("Digite o nome do banco:");
        String nomeBanco = scanner.nextLine();
        System.out.println("Digite o tipo da conta (A - Conta Corrente, P - Poupança):");
        String tipoConta = scanner.nextLine();
        System.out.println("Digite o ID do usuário:");
        Long idUsuario = scanner.nextLong();

        Conta novaConta = new Conta(null, nomeBanco, tipoConta, idUsuario); // ID será gerado automaticamente
        try {
            contaDao.criarConta(novaConta);
            System.out.println("Conta criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar conta: " + e.getMessage());
        }
    }

    private static void atualizarConta(Scanner scanner, ContaDao contaDao) {
        System.out.println("Digite o ID da conta a ser atualizada:");
        Long idConta = scanner.nextLong();
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.println("Digite o novo nome do banco:");
        String nomeBanco = scanner.nextLine();
        System.out.println("Digite o novo tipo da conta (A - Conta Corrente, P - Poupança):");
        String tipoConta = scanner.nextLine();

        Conta contaAtualizada = new Conta(idConta, nomeBanco, tipoConta, null); // O id_usuario não é atualizado
        try {
            contaDao.atualizarConta(contaAtualizada);
            System.out.println("Conta atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar conta: " + e.getMessage());
        }
    }
}
