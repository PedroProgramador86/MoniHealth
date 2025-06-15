import javax.swing.*;
import java.awt.*;

public class ModeloCadastrarImagem extends JFrame {
    
    private JLabel lblTitulo;
    private JTextField campoDescricao;
    private JButton botaoSelecionarImagem;
    private JLabel imagemPreview;
    private JButton botaoSalvar;
    private JButton botaoCancelar;

    public ModeloCadastrarImagem() {
        setTitle("Cadastrar Nova Imagem do Paciente");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título
        lblTitulo = new JLabel("Cadastrar Imagem Clínica", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo, BorderLayout.NORTH);

        // Centro da tela (formulário)
        JPanel painelFormulario = new JPanel(new GridLayout(4, 1, 10, 10));
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoDescricao = new JTextField();
        painelFormulario.add(new JLabel("Descrição da Imagem:"));
        painelFormulario.add(campoDescricao);

        botaoSelecionarImagem = new JButton("Selecionar Imagem...");
        painelFormulario.add(botaoSelecionarImagem);

        imagemPreview = new JLabel("Pré-visualização", JLabel.CENTER);
        imagemPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        painelFormulario.add(imagemPreview);

        add(painelFormulario, BorderLayout.CENTER);

        // Rodapé com botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");
        painelBotoes.add(botaoCancelar);
        painelBotoes.add(botaoSalvar);

        add(painelBotoes, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ModeloCadastrarImagem());
    }
}
