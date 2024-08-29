import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String name;
    String password;

    // Criando construtores
    Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }

    Usuario(){
    }

    // Verificando se o nome e senha estão corretos
    boolean isMatch(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }

    //Criação de lista de usuários
    private static final List<Usuario> usuarios = new ArrayList<>();

    //Método para adicionar novo usuário
    public void addUsuario(String name, String password){
        Usuario newCliente = new Usuario(name, password);
        usuarios.add(newCliente);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    //Método para verificação do login
    public static boolean validarUsuario(String name, String password){
        for (Usuario usuario : usuarios) {
            if (usuario.isMatch(name, password)) {
                return true;
            }
        }return false;
    }

    //Fazer Login
    public void Login(String name, String password){
        if (Usuario.validarUsuario(name, password)){
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Nome ou senha incorretos!");
        }
    }
}
