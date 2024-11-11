package fiap.com.fintech.view;

import fiap.com.fintech.dao.InvestimentoDao;
import fiap.com.fintech.model.Investimento;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InvestimentoView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvestimentoDao investimentoDao;

        try {
            investimentoDao = new InvestimentoDao();
            int escolha;
            do {
                System.out.println("Escolha uma opção:\n1 - Cadastrar Investimento \n2 - Registrar Arrecadação \n3 - Ver Arrecadação \n0 - Sair");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        cadastrarInvestimento(scanner, investimentoDao);
                        break;
                    case 2:
                        registrarArrecadacao(scanner, investimentoDao);
                        break;
                    case 3:
                        verArrecadacao(scanner, investimentoDao);
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

    private static void cadastrarInvestimento(Scanner scanner, InvestimentoDao investimentoDao) {
        System.out.println("Digite o valor total do investimento:");
        double vlTotal = scanner.nextDouble();
        System.out.println("Digite a descrição do investimento:");
        String dsInvestimento = scanner.next();

        // Define o formato da data
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dtInicial = null;
        Date dtFinal = null;

        // Lê a data inicial
        while (dtInicial == null) {
            System.out.println("Digite a data inicial (YYYY-MM-DD):");
            String dtInicialStr = scanner.next();
            try {
                dtInicial = dateFormat.parse(dtInicialStr);
            } catch (ParseException e) {
                System.out.println("Data inválida. Por favor, tente novamente.");
            }
        }

        // Lê a data final
        while (dtFinal == null) {
            System.out.println("Digite a data final (YYYY-MM-DD):");
            String dtFinalStr = scanner.next();
            try {
                dtFinal = dateFormat.parse(dtFinalStr);
            } catch (ParseException e) {
                System.out.println("Data inválida. Por favor, tente novamente.");
            }
        }

        System.out.println("Digite o ID da conta associada ao investimento:");
        Long idConta = scanner.nextLong();

        Investimento novoInvestimento = new Investimento(null, vlTotal, 0.0, dtInicial, dtFinal, dsInvestimento, idConta);
        try {
            investimentoDao.cadastrarInvestimento(novoInvestimento);
            System.out.println("Investimento cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar investimento: " + e.getMessage());
        }
    }

    private static void registrarArrecadacao(Scanner scanner, InvestimentoDao investimentoDao) {
        System.out.println("Digite o ID do investimento:");
        Long idInvestimento = scanner.nextLong();
        System.out.println("Digite o valor arrecadado:");
        double valorArrecadado = scanner.nextDouble();

        try {
            investimentoDao.registrarArrecadacao(idInvestimento, valorArrecadado);
            System.out.println("Arrecadação registrada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao registrar arrecadação: " + e.getMessage());
        }
    }

    private static void verArrecadacao(Scanner scanner, InvestimentoDao investimentoDao) {
        System.out.println("Digite o ID do investimento:");
        Long idInvestimento = scanner.nextLong();

        try {
            double totalArrecadado = investimentoDao.obterArrecadacao(idInvestimento);
            System.out.println("Total arrecadado para o investimento: R$ " + totalArrecadado);
        } catch (SQLException e) {
            System.err.println("Erro ao obter arrecadação: " + e.getMessage());
        }
    }
}
