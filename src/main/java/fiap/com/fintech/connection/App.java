package fiap.com.fintech.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class App
{
    public static void main(String[] args) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão realizada!");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
