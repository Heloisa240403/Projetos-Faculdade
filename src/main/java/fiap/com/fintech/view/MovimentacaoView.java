package fiap.com.fintech.view;

import fiap.com.fintech.dao.MovimentacaoDao;
import fiap.com.fintech.model.Movimentacao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MovimentacaoView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovimentacaoDao movimentacaoDao;

        try {
            movimentacaoDao = new MovimentacaoDao();
            int escolha;
            do {
                System.out.println("Escolha uma opção:\n1 - Registrar Movimentação \n2 - Visualizar Saldo \n3 - Listar todas as Movimentações \n0 - Sair");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        registrarMovimentacao(scanner, movimentacaoDao);
                        break;
                    case 2:
                        visualizarSaldo(scanner, movimentacaoDao);
                        break;
                    case 3:
                        listarMovimentacoes(movimentacaoDao);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                }
            } while (escolha != 0);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void registrarMovimentacao(Scanner scanner, MovimentacaoDao movimentacaoDao) {
        System.out.println("Digite o ID da conta:");
        Long idConta = scanner.nextLong();
        System.out.println("Digite o valor da movimentação:");
        double valorMovimentacao = scanner.nextDouble();
        System.out.println("Digite o tipo da movimentação (E - Entrada, S - Saída):");
        String tipoMovimentacao = scanner.next() + scanner.nextLine();
        Date dataMovimentacao = new Date(); // Pega a data atual

        try {
            double saldoAtual = movimentacaoDao.calcularSaldo(idConta);
            double novoSaldo;

            if (tipoMovimentacao.equals("E")) {
                novoSaldo = saldoAtual + valorMovimentacao;
            } else if (tipoMovimentacao.equals("S")) {
                novoSaldo = saldoAtual - valorMovimentacao;
            } else {
                System.out.println("Tipo de movimentação inválido! Somente 'E' para entrada ou 'S' para saída.");
                return;
            }

            if (novoSaldo < 0) {
                System.out.println("Saldo insuficiente para esta movimentação.");
                return;
            }

            Movimentacao novaMovimentacao = new Movimentacao(null, valorMovimentacao, novoSaldo, dataMovimentacao, tipoMovimentacao, idConta);
            movimentacaoDao.registrarMovimentacao(novaMovimentacao);
            System.out.println("Movimentação registrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao registrar movimentação: " + e.getMessage());
        }
    }

    private static void visualizarSaldo(Scanner scanner, MovimentacaoDao movimentacaoDao) {
        System.out.println("Digite o ID da conta para visualizar o saldo:");
        Long idConta = scanner.nextLong();
        try {
            double saldo = movimentacaoDao.calcularSaldo(idConta);
            System.out.println("O saldo atual da conta " + idConta + " é: " + saldo);
        } catch (SQLException e) {
            System.err.println("Erro ao visualizar saldo: " + e.getMessage());
        }
    }

    private static void listarMovimentacoes(MovimentacaoDao movimentacaoDao) {
        try {
            List<Movimentacao> movimentacoes = movimentacaoDao.getAll();
            for (Movimentacao mov : movimentacoes) {
                System.out.println("ID: " + mov.getIdMovimentacao());
                System.out.println("Valor Movimentação: " + mov.getValorMovimentacao());
                System.out.println("Saldo: " + mov.getVlSaldo());
                System.out.println("Data Movimentação: " + mov.getDtMovimentacao());
                System.out.println("Tipo: " + mov.getSgMovimentacao());
                System.out.println("ID Conta: " + mov.getIdConta());
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar movimentações: " + e.getMessage());
        }
    }
}

