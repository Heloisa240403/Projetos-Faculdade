import java.util.ArrayList;
import java.util.List;

public class Despesa {

    double valorD;

    Despesa(){
    }

    Despesa(double valorR){
        this.valorD = valorD;
    }

    private static final List<Despesa> despesas = new ArrayList<>();

    //Método para adicionar nova despesa
    public void addDespesa(double valorR){
        Despesa newValor = new Despesa();
        despesas.add(newValor);
        System.out.println("Nova gasto cadastrado com sucesso!");
    }

    //Método para mostrar o valor total das despesas
    public static String somarDespesas(ArrayList<Integer> lista) {
        double soma = 0.0;
        for (double valor : lista) {
            soma += valor;
        }
        return "A soma dos gastos é: " + soma;
    }

    //Método para mostrar a lista de despesas
    public static void mostrarDespesas(ArrayList<Integer> lista) {
        // Verificando se a lista esta vazia
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia.");
        }
        else {
            // Vê todos os elementos da lista e mostra eles
            System.out.println("Valores da lista:");
            for (Integer valor : lista) {
                System.out.println(valor);
            }
        }
    }
}