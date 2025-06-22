import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;  // Adicione esta linha para corrigir o erro de SQL Exception
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Agenda extends javax.swing.JFrame {
    private String nomeEnfermeira;
    
    String dataAtual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    
    public Agenda(String nomeEnfermeira) {
        
        this.nomeEnfermeira = nomeEnfermeira;
        initComponents();
        
        tabelaDaAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Id", "Hora", "Paciente", "Dia", "Data", "Enfermeira", "Motivo", "Status"
            }
        ));

        nomeDaEnfermeira.setText(nomeEnfermeira);

        botaoAgenda.setSelected(true);
        botaoPainel.setSelected(false);
        botaoProntuarios.setSelected(false);

        botaoPainel.addActionListener(e -> {
            new Painel(nomeEnfermeira).setVisible(true);
            dispose();
        });

        botaoProntuarios.addActionListener(e -> {
            new Prontuarios(nomeEnfermeira).setVisible(true);
            dispose();
        });
        
        botaoDelogarConta.addActionListener(e -> {
            new Login().setVisible(true); // abre a tela de login
            dispose(); // fecha a tela atual
        });
        
        novoAgendamento.addActionListener(e -> {
            AgendamentoPaciente dialog = new AgendamentoPaciente(this, true, this); // Passa a referência de `Agenda` como parâmetro
            dialog.setLocationRelativeTo(this); // Centraliza a janela
            dialog.setVisible(true);
        });
        
        tabelaDaAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaDaAgenda.getSelectedRow();  // Obtém a linha selecionada
                if (row >= 0) {
                    // Obtendo os dados da linha selecionada
                    String horarioAgendamento = (String) tabelaDaAgenda.getValueAt(row, 1); // Hora agendada (formato string)
                    String nomePaciente = (String) tabelaDaAgenda.getValueAt(row, 2); // Nome do paciente
                    String diaDaSemana = (String) tabelaDaAgenda.getValueAt(row, 3); // Dia
                    String dataAgendamento = (String) tabelaDaAgenda.getValueAt(row, 4); // Data
                    String nomeEnfermeira = (String) tabelaDaAgenda.getValueAt(row, 5); // Enfermeira
                    String motivoAgendamento = (String) tabelaDaAgenda.getValueAt(row, 6); // Motivo
                    String statusAgendamento = (String) tabelaDaAgenda.getValueAt(row, 7); // Status

                    // Obtenha o convenioPaciente (exemplo fictício, você deve buscar o valor real)
                    String convenioPaciente = obterConvenioPaciente(nomePaciente);  // Lógica para obter o convênio do paciente

                    // Garantindo que o ID do agendamento seja tratado como int
                    int idAgendamento = Integer.parseInt(tabelaDaAgenda.getValueAt(row, 0).toString()); // Converte para int a coluna correta com o ID

                    // Criar a instância do InfoAgenda e passar os dados
                    InfoAgenda infoAgendaDialog = new InfoAgenda(
                        Agenda.this, true, nomePaciente, convenioPaciente, nomeEnfermeira, motivoAgendamento, idAgendamento, Agenda.this // Passa 'this' de 'Agenda'
                    );
                    infoAgendaDialog.setLocationRelativeTo(Agenda.this); // Centraliza o JDialog
                    infoAgendaDialog.setVisible(true); // Exibe o JDialog
                }
            }
        });

        atualizarTabelaAgenda(); 
        atualizarTabelaPacientesDoDia();

              
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botaoAgenda = new javax.swing.JToggleButton();
        botaoPainel = new javax.swing.JToggleButton();
        botaoProntuarios = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        nomeDaEnfermeira = new javax.swing.JLabel();
        botaoDelogarConta = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPacientesDoDia = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDaAgenda = new javax.swing.JTable();
        button4 = new java.awt.Button();
        novoAgendamento = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MoniHealth");

        botaoAgenda.setBackground(new java.awt.Color(0, 204, 255));
        botaoAgenda.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        botaoAgenda.setText("Agenda");

        botaoPainel.setBackground(new java.awt.Color(0, 204, 255));
        botaoPainel.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        botaoPainel.setText("Painel");

        botaoProntuarios.setBackground(new java.awt.Color(0, 204, 255));
        botaoProntuarios.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        botaoProntuarios.setText("Prontuarios");

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 30)); // NOI18N
        jLabel2.setText("Pacientes do Dia");
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        button1.setBackground(new java.awt.Color(153, 153, 153));
        button1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button1.setLabel("Observações");

        button2.setBackground(new java.awt.Color(153, 153, 153));
        button2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button2.setLabel("Lista de Espera");

        button3.setBackground(new java.awt.Color(153, 153, 153));
        button3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button3.setLabel("Imprimir Agenda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        nomeDaEnfermeira.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        nomeDaEnfermeira.setForeground(new java.awt.Color(51, 51, 51));
        nomeDaEnfermeira.setText("Nome da Enfermeira");

        botaoDelogarConta.setBackground(new java.awt.Color(102, 102, 102));
        botaoDelogarConta.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        botaoDelogarConta.setText("Sair");
        botaoDelogarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDelogarContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(botaoAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoPainel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoProntuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeDaEnfermeira)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(botaoDelogarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoPainel, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(botaoAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoProntuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoDelogarConta)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nomeDaEnfermeira, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setDividerLocation(300);

        tabelaPacientesDoDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Horario", "Paciente"
            }
        ));
        tabelaPacientesDoDia.setShowGrid(true);
        jScrollPane1.setViewportView(tabelaPacientesDoDia);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        tabelaDaAgenda.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tabelaDaAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null, null, null, null},
                {null, "", null, null, null, null, null, null},
                {null, "", null, null, null, null, null, null},
                {null, "", null, null, null, null, null, null},
                {null, "", null, null, null, null, null, null},
                {null, "", null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id ", "Horario", "Paciente", "Dia", "Data", "Enfermeira", "Motivo", "Status"
            }
        ));
        tabelaDaAgenda.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tabelaDaAgenda.setShowGrid(true);
        jScrollPane2.setViewportView(tabelaDaAgenda);

        jSplitPane1.setRightComponent(jScrollPane2);

        button4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button4.setLabel("Novo Paciente");

        novoAgendamento.setBackground(new java.awt.Color(102, 255, 255));
        novoAgendamento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        novoAgendamento.setLabel("+ Novo Agendamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(novoAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(novoAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoDelogarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDelogarContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDelogarContaActionPerformed


    
    public void atualizarTabelaAgenda() {
        try (Connection conn = ConexaoBancoDeDados.conectar()) {
            String sql = "SELECT Id, HoraAgendamento, DiaDaSemana, NomePaciente, DataAgendamento, NomeEnfermeira, TipoAgendamento, StatusAgendamento FROM Agendamentos ORDER BY HoraAgendamento";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabelaDaAgenda.getModel();
            model.setRowCount(0);  // Limpa a tabela antes de preenchê-la

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("Id"),
                    rs.getString("HoraAgendamento"),
                    rs.getString("NomePaciente"),
                    rs.getString("DiaDaSemana"),
                    rs.getString("DataAgendamento"),
                    rs.getString("NomeEnfermeira"),
                    rs.getString("TipoAgendamento"),
                    rs.getString("StatusAgendamento")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar os agendamentos.");
        }
    }
    
     public void atualizarTabelaPacientesDoDia() {
        String dataAtual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        try (Connection conn = ConexaoBancoDeDados.conectar()) {
            String sql = "SELECT Id, HoraAgendamento, NomePaciente, DiaDaSemana, DataAgendamento, NomeEnfermeira, TipoAgendamento, StatusAgendamento " +
                         "FROM Agendamentos " +
                         "WHERE DataAgendamento = ? " + 
                         "ORDER BY HoraAgendamento";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dataAtual); 

            ResultSet rs = stmt.executeQuery();

            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabelaPacientesDoDia.getModel();
            model.setRowCount(0);  // Limpa a tabela antes de preenchê-la

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("HoraAgendamento"), 
                    rs.getString("NomePaciente")      
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar os agendamentos.");
        }
    }





    private String obterConvenioPaciente(String nomePaciente) {
        // Lógica para obter o convênio do paciente (aqui você pode fazer uma consulta ao banco de dados)
        return "Convênio do paciente"; // Exemplo estático
    }

    private String obterEnfermeiroPaciente(String nomePaciente) {
        // Lógica para obter o enfermeiro do paciente (aqui você pode fazer uma consulta ao banco de dados)
        return "Enfermeiro do paciente"; // Exemplo estático
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botaoAgenda;
    private javax.swing.JButton botaoDelogarConta;
    private javax.swing.JToggleButton botaoPainel;
    private javax.swing.JToggleButton botaoProntuarios;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel nomeDaEnfermeira;
    private java.awt.Button novoAgendamento;
    private javax.swing.JTable tabelaDaAgenda;
    private javax.swing.JTable tabelaPacientesDoDia;
    // End of variables declaration//GEN-END:variables
}
