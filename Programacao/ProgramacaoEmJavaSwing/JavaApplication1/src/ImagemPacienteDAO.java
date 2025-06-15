import java.sql.*;
import java.util.*;

public class ImagemPacienteDAO {

    public List<ImagemPaciente> listarPorPaciente(int pacienteId) {
        List<ImagemPaciente> lista = new ArrayList<>();

        try (Connection conn = ConexaoBancoDeDados.conectar()) {
            String sql = """
                SELECT ip.Id, ip.Descricao, ip.Imagem, e.Nome AS NomeEnfermeira
                FROM ImagensPaciente ip
                JOIN Enfermeiras e ON ip.EnfermeiraId = e.Id
                WHERE ip.PacienteId = ?
                ORDER BY ip.DataRegistro DESC
            """;

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pacienteId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ImagemPaciente img = new ImagemPaciente();
                img.setId(rs.getInt("Id"));
                img.setDescricao(rs.getString("Descricao"));
                img.setImagemBytes(rs.getBytes("Imagem"));
                img.setNomeEnfermeira(rs.getString("NomeEnfermeira"));
                lista.add(img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
