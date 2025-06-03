import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ModeloDeAgenda extends JFrame {

    private JTable pacientesTable;
    private JTable agendaTable;
    private DefaultTableModel pacientesModel;
    private DefaultTableModel agendaModel;

    public ModeloDeAgenda() {
        setTitle("MoniHealth");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Menu Superior
        JPanel menuSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuSuperior.setBackground(new Color(20, 122, 255));

        JLabel logo = new JLabel("🩺 MoniHealth");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Arial", Font.BOLD, 18));
        menuSuperior.add(logo);

        menuSuperior.add(criarBotaoMenu("Agenda"));
        menuSuperior.add(criarBotaoMenu("Painel"));
        menuSuperior.add(criarBotaoMenu("Prontuários"));

        add(menuSuperior, BorderLayout.NORTH);

        // Painel principal dividido
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(300);

        // Painel esquerdo - Pacientes do Dia
        JPanel painelEsquerdo = new JPanel(new BorderLayout());
        painelEsquerdo.setBackground(Color.WHITE);

        JLabel pacientesLabel = new JLabel("Pacientes do Dia", SwingConstants.CENTER);
        pacientesLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pacientesLabel.setOpaque(true);
        pacientesLabel.setBackground(new Color(0, 204, 255));
        pacientesLabel.setForeground(Color.BLACK);
        painelEsquerdo.add(pacientesLabel, BorderLayout.NORTH);

        String[] colunasPacientes = {"Horário", "Paciente"};
        pacientesModel = new DefaultTableModel(colunasPacientes, 0);
        pacientesTable = new JTable(pacientesModel);
        JScrollPane scrollPacientes = new JScrollPane(pacientesTable);

        painelEsquerdo.add(scrollPacientes, BorderLayout.CENTER);

        JButton btnAdicionarPaciente = new JButton("Novo Paciente");
        btnAdicionarPaciente.addActionListener(this::adicionarPaciente);
        painelEsquerdo.add(btnAdicionarPaciente, BorderLayout.SOUTH);

        splitPane.setLeftComponent(painelEsquerdo);

        // Painel direito - Agenda
        JPanel painelDireito = new JPanel(new BorderLayout());
        painelDireito.setBackground(Color.WHITE);

        // Topo da Agenda
        JPanel topoAgenda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topoAgenda.setBackground(Color.CYAN);

        topoAgenda.add(new JButton("Observações"));
        topoAgenda.add(new JButton("Lista de Espera"));
        topoAgenda.add(new JButton("Imprimir Agenda"));
        topoAgenda.add(new JButton("Agendamento Online"));

        painelDireito.add(topoAgenda, BorderLayout.NORTH);

        // Tabela da Agenda
        String[] colunasAgenda = {"Horário", "Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        agendaModel = new DefaultTableModel(colunasAgenda, 0);
        agendaTable = new JTable(agendaModel);

        // Preencher horários básicos
        String[] horarios = {"09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "16:25", "17:00"};
        for (String h : horarios) {
            agendaModel.addRow(new Object[]{h, "", "", "", "", "", "", ""});
        }

        JScrollPane scrollAgenda = new JScrollPane(agendaTable);
        painelDireito.add(scrollAgenda, BorderLayout.CENTER);

        // Botão de novo agendamento
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnNovoAgendamento = new JButton("+ Novo Agendamento");
        painelInferior.add(btnNovoAgendamento);

        painelDireito.add(painelInferior, BorderLayout.SOUTH);

        splitPane.setRightComponent(painelDireito);

        add(splitPane, BorderLayout.CENTER);
    }

    private JButton criarBotaoMenu(String texto) {
        JButton btn = new JButton(texto);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(20, 122, 255));
        btn.setFocusPainted(false);
        return btn;
    }

    private void adicionarPaciente(ActionEvent e) {
        String horario = JOptionPane.showInputDialog(this, "Digite o horário:");
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do paciente:");

        if (horario != null && nome != null && !horario.isEmpty() && !nome.isEmpty()) {
            pacientesModel.addRow(new Object[]{horario, nome});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ModeloDeAgenda().setVisible(true);
        });
    }
}
