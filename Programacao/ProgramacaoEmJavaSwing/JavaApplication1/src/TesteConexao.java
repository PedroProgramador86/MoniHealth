import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = ConexaoBancoDeDados.conectar()) {
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
