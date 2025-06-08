/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bazukart
 */
    
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ModeloDePainel extends JFrame {

    public ModeloDePainel() {
        setTitle("MoniHealth - Painel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 750);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Topo com logo e navegação
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(3, 169, 244));
        topPanel.setPreferredSize(new Dimension(getWidth(), 40));

        JLabel logo = new JLabel("  💛 MoniHealth");
        logo.setFont(new Font("Arial", Font.BOLD, 16));
        logo.setForeground(Color.WHITE);
        topPanel.add(logo, BorderLayout.WEST);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navPanel.setOpaque(false);
        navPanel.add(new JLabel("Agenda"));
        navPanel.add(new JLabel("Painel"));
        navPanel.add(new JLabel("Prontuários"));
        for (Component c : navPanel.getComponents()) {
            c.setForeground(Color.WHITE);
            c.setFont(new Font("Arial", Font.BOLD, 14));
        }
        topPanel.add(navPanel, BorderLayout.CENTER);

        // Painel principal dividido
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Esquerda - Pacientes do Dia
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.LIGHT_GRAY);

        JLabel pacientesLabel = new JLabel("Pacientes do Dia", SwingConstants.CENTER);
        pacientesLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pacientesLabel.setOpaque(true);
        pacientesLabel.setBackground(Color.CYAN);
        leftPanel.add(pacientesLabel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel data = new JLabel("25 Fevereiro 2025", SwingConstants.CENTER);
        data.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel hora = new JLabel("11:37", SwingConstants.CENTER);
        hora.setFont(new Font("Arial", Font.BOLD, 24));
        infoPanel.add(data);
        infoPanel.add(hora);
        leftPanel.add(infoPanel, BorderLayout.CENTER);

        // Tabela horários
        String[] colunas = {"Horário", "Paciente"};
        Object[][] dados = {
                {"09:30", ""},
                {"10:00", ""},
                {"11:30", ""},
                {"12:30", ""},
                {"16:25", ""},
                {"17:00", ""},
        };
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollTabela = new JScrollPane(tabela);
        leftPanel.add(scrollTabela, BorderLayout.SOUTH);

        // Direita - Painel com filtros e histórico
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel painelLabel = new JLabel("Painel");
        painelLabel.setFont(new Font("Arial", Font.BOLD, 24));
        painelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(painelLabel);

        JPanel filtrosPanel = new JPanel();
        filtrosPanel.add(new JLabel("Período: Últimos 30 dias"));
        filtrosPanel.add(new JLabel("Convênio: Todos"));
        filtrosPanel.add(new JLabel("Enfermeiro(a): Todos"));
        rightPanel.add(filtrosPanel);

        JPanel statusPanel = new JPanel();
        statusPanel.add(new JLabel("12 ATENDIDOS"));
        statusPanel.add(new JLabel("23 AGENDADOS"));
        statusPanel.add(new JLabel("6 FALTANTES"));
        statusPanel.add(new JLabel("5 CONFIRMADOS"));
        rightPanel.add(statusPanel);

        JLabel historicoLabel = new JLabel("Histórico de Consultas:");
        historicoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(historicoLabel);

        String[] colunasHistorico = {"Nome", "Foto e Relatório", "Data", "Convênio", "Enfermeiro"};
        Object[][] historico = new Object[10][5]; // Dados fictícios
        JTable tabelaHistorico = new JTable(historico, colunasHistorico);
        JScrollPane scrollHistorico = new JScrollPane(tabelaHistorico);
        rightPanel.add(scrollHistorico);

        // Adiciona painéis ao main
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // Adiciona ao JFrame
        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ModeloDePainel());
    }
} 
