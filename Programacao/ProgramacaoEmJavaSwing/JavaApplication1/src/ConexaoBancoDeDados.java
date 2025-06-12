import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {
    
    private static final String url = "jdbc:mysql://acilab.com.br:3309/pedro_luna"; // URL do banco de dados
    private static final String usr = "root"; // Nome do Usuario
    private static final String senha = "admin"; // Senha do usuario

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, usr, senha);
    }
}