package fiap.com.fintech.dao;

import fiap.com.fintech.dao.UsuarioDao;
import fiap.com.fintech.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioDaoTest {

    public static void main(String[] args) {
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();

            // Cadastrar manualmente alguns usuários
            Usuario usuario1 = new Usuario("Bia Costa", "bia.costa@gmail.com", "(11) 98277-7440", "Rua das Flores, 123", "Engenheira", "senha123");
            Usuario usuario2 = new Usuario("Maria Clara", "maria.clara@gmail.com", "(13) 98828-7780", "Av. Martin Afonso, 456", "Médica", "senha456");
            Usuario usuario3= new Usuario("Julia Lima", "julia.lima@gmail.com", "(13) 99412-7010", "Av. Paulista, 1604", "Cozinheira", "senha168");
            Usuario usuario4 = new Usuario("Daniel Alves", "daniel.alves@gmail.com", "(12) 99912-6470", "Rua Alvares, 167", "Jornalista", "senha864");
            Usuario usuario5 = new Usuario("Matheus Castro", "matheus.castro@gmail.com", "(12) 99821-2243", "Alemeda Joaquim, 1025", "Mecânico", "senha331");

            dao.cadastrar(usuario1);
            dao.cadastrar(usuario2);
            dao.cadastrar(usuario3);
            dao.cadastrar(usuario4);
            dao.cadastrar(usuario5);

            System.out.println("Usuários cadastrados com sucesso!");

            // Recuperar todos os usuários do banco e listar
            List<Usuario> usuarios = dao.getAll();

            System.out.println("Lista de Usuários Cadastrados:");
            for (Usuario usuario : usuarios) {
                System.out.println("----------------------------");
                System.out.println("ID: " + usuario.getCodigo());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Email: " + usuario.getEmail());
                System.out.println("Telefone: " + usuario.getTelefone());
                System.out.println("Endereço: " + usuario.getEndereco());
                System.out.println("Profissão: " + usuario.getProfissao());
                System.out.println("----------------------------");
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou manipular o banco de dados: " + e.getMessage());
        }
    }
}
