package fiap.com.fintech.view;

import fiap.com.fintech.dao.UsuarioDao;
import fiap.com.fintech.model.Usuario;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroUsuarioView {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UsuarioDao dao;
        System.out.println("Bem vindo a Fintech!");
        dao = new UsuarioDao();
        int escolha = -1;

        do {
            try {
                System.out.println("Escolha uma opção:\n1-Cadastrar novo Usuário \n2-Efetuar Login \n0-Sair");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        cadastrar(scanner, dao);
                        break;
                    case 2:
                        login(scanner, dao);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção Inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.nextLine();
            }
        } while (escolha != 0);
    }

    private static void cadastrar(Scanner scanner, UsuarioDao dao){
        System.out.println("Digite seu nome:");
        String nome = scanner.next() + scanner.nextLine();
        System.out.println("Digite seu E-mail:");
        String email = scanner.next() + scanner.nextLine();
        System.out.println("Digite seu telefone:");
        String telefone = scanner.next() + scanner.nextLine();
        System.out.println("Digite seu endereço:");
        String endereco = scanner.next() + scanner.nextLine();
        System.out.println("Digite sua profissão:");
        String profissao = scanner.next() + scanner.nextLine();
        System.out.println("Crie sua senha:");
        String senha = scanner.next() + scanner.nextLine();
        Usuario novoUsuario = new Usuario(nome, email, telefone, endereco, profissao, senha);
        try {
            dao.cadastrar(novoUsuario);
            System.out.println("Usuário Cadastrado com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }

    }

    private static void login(Scanner scanner, UsuarioDao dao){
        System.out.println("Digite o e-mail:");
        String email = scanner.next() + scanner.nextLine();
        System.out.println("Digite a senha:");
        String senha = scanner.next() + scanner.nextLine();

        try {
            boolean autenticado = dao.login(email, senha);
            if (autenticado) {
                System.out.println("Login realizado com sucesso!");
            } else {
                System.out.println("Email ou senha inválidos.");
            }
        } catch (SQLException e) {
            System.err.println("Erro no login: " + e.getMessage());
        }
    }
}
