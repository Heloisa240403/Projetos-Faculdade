import java.util.ArrayList;
import java.util.List;

public class Investimento {

    double valorI;

    Investimento(){
    }

    Investimento(double valorI){
        this.valorI = valorI;
    }

    private static final List<Investimento> investimentos = new ArrayList<>();

    public void addInvestimento(double valorI){
        Investimento newValor = new Investimento();
        investimentos.add(newValor);
        System.out.println("Novo investimento cadastrado com sucesso!");
    }

    public static String somarInvestimentos(ArrayList<Integer> lista) {
        double soma = 0.0;
        for (double valor : lista) {
            soma += valor;
        }
        return "A soma dos investimentos é: " + soma;
    }

    public static void mostrarInvestimentos(ArrayList<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia.");
        }
        else {
            System.out.println("Valores da lista:");
            for (Integer valor : lista) {
                System.out.println(valor);
            }
        }
    }
}