import java.util.ArrayList;
import java.util.List;

public class Debito {

    double valorR;

    Debito(){
    }

    Debito(double valorR){
        this.valorR = valorR;
    }

    private static final List<Debito> debitos = new ArrayList<>();

    //Método para adicionar novo débito
    public void addDebito(double valorR){
        Debito newValor = new Debito();
        debitos.add(newValor);
        System.out.println("Novo recebimento cadastrado com sucesso!");
    }

    //Método para mostrar o valor total dos débitos
    public static String somarDebitos(ArrayList<Integer> lista) {
        double soma = 0.0;
        for (double valor : lista) {
            soma += valor;
        }
        return "A soma dos débitos é: " + soma;
    }

    //Método para mostrar a lista de débitos
    public static void mostrarDebitos(ArrayList<Integer> lista) {
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
