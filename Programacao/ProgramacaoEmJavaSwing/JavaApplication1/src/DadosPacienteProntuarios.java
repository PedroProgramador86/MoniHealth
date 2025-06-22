import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DadosPacienteProntuarios extends javax.swing.JFrame {

    private String nomeEnfermeira;
    
    public DadosPacienteProntuarios(String nomeEnfermeira, String nomePaciente, String dataNascimento, String convenio) {
        this.nomeEnfermeira = nomeEnfermeira;
        initComponents();
        
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoPacienteProntuarios tela = new InfoPacienteProntuarios(
                    nomeEnfermeira,
                    nomeDoPacienteSelecionado2.getText(),
                    dataDeNascimentoDoPaciente.getText(),
                    convenioDoPaciente.getText()
                );
                tela.setVisible(true);
                dispose();
            }
        });

        
        nomeDoPacienteSelecionado.setText(nomePaciente);
        nomeDoPacienteSelecionado2.setText(nomePaciente);
        dataDeNascimentoDoPaciente.setText(dataNascimento);
        convenioDoPaciente.setText(convenio);
        
        // Carregar as datas de alteração do prontuário para o paciente atual no JComboBox
        try (Connection conn = ConexaoBancoDeDados.conectar()) {
            String sql = "SELECT DataDeAlteracao FROM ProntuariosPaciente WHERE NomePaciente = ? ORDER BY DataDeAlteracao DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomePaciente); // Usa o nome do paciente passado ao construtor
            ResultSet rs = stmt.executeQuery();

            selecaoDeData.removeAllItems(); // Limpa itens anteriores, se houver

            boolean encontrou = false;
            while (rs.next()) {
                Date data = rs.getDate("DataDeAlteracao");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                selecaoDeData.addItem(sdf.format(data));
                encontrou = true;
            }

            if (!encontrou) {
                selecaoDeData.addItem("Nenhuma data registrada");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            selecaoDeData.addItem("Erro ao carregar datas");
        }
        

        // Adiciona ação quando o usuário seleciona uma data no combo
        selecaoDeData.addActionListener(e -> {
            String dataSelecionada = (String) selecaoDeData.getSelectedItem();
            if (dataSelecionada == null || dataSelecionada.equals("Nenhuma data registrada") || dataSelecionada.equals("Erro ao carregar datas")) {
                fatorDesencadenteCorrespondente.setText("-");
                etiologiaCorrespondente.setText("-");
                perdaTecidualCorrespondente.setText("-");
                lesaoPorPressaoCorrespondente.setText("-");
                statusCorrespondente.setText("-");
                descricaoCorrespondente.setText("-");
                return;
            }

            try (Connection conn = ConexaoBancoDeDados.conectar()) {
                String sql = """
                    SELECT FatorDesencadeante, Etiologia, PerdaTecidual, LesaoPressao, StatusPaciente, Descricao
                    FROM ProntuariosPaciente
                    WHERE NomePaciente = ? AND DataDeAlteracao = STR_TO_DATE(?, '%d/%m/%Y')
                """;
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nomeDoPacienteSelecionado2.getText());
                stmt.setString(2, dataSelecionada);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    fatorDesencadenteCorrespondente.setText(rs.getString("FatorDesencadeante"));
                    etiologiaCorrespondente.setText(rs.getString("Etiologia"));
                    perdaTecidualCorrespondente.setText(rs.getString("PerdaTecidual"));
                    lesaoPorPressaoCorrespondente.setText(rs.getString("LesaoPressao"));
                    statusCorrespondente.setText(rs.getString("StatusPaciente"));
                    descricaoCorrespondente.setText(rs.getString("Descricao"));
                } else {
                    fatorDesencadenteCorrespondente.setText("Sem dados");
                    etiologiaCorrespondente.setText("Sem dados");
                    perdaTecidualCorrespondente.setText("Sem dados");
                    lesaoPorPressaoCorrespondente.setText("Sem dados");
                    statusCorrespondente.setText("Sem dados");
                    descricaoCorrespondente.setText("Sem dados");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundoAzul = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        botaoVoltar = new javax.swing.JButton();
        nomeDoPacienteSelecionado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fatorDesencadenteCorrespondente = new javax.swing.JLabel();
        etiologiaCorrespondente = new javax.swing.JLabel();
        perdaTecidualCorrespondente = new javax.swing.JLabel();
        lesaoPorPressaoCorrespondente = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        statusCorrespondente = new javax.swing.JLabel();
        status1 = new javax.swing.JLabel();
        descricaoCorrespondente = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nomeDoPacienteSelecionado2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dataDeNascimentoDoPaciente = new javax.swing.JLabel();
        convenioDoPaciente = new javax.swing.JLabel();
        textoSelecionarData = new javax.swing.JLabel();
        selecaoDeData = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fundoAzul.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MoniHealth");

        jSplitPane1.setDividerLocation(450);

        jSplitPane2.setDividerLocation(46);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        botaoVoltar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        botaoVoltar.setText("<- Voltar");

        nomeDoPacienteSelecionado.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPacienteSelecionado.setText("Nome do Paciente Selecionado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomeDoPacienteSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(nomeDoPacienteSelecionado))
                .addContainerGap())
        );

        jSplitPane2.setTopComponent(jPanel1);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setText("Fator Desencadente:");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setText("Etiologia:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel4.setText("Lesão por Pressão:");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel5.setText("Perda Tecidual:");

        fatorDesencadenteCorrespondente.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        fatorDesencadenteCorrespondente.setForeground(new java.awt.Color(0, 102, 102));
        fatorDesencadenteCorrespondente.setText("fatorDesencadenteCorrespondente");

        etiologiaCorrespondente.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        etiologiaCorrespondente.setForeground(new java.awt.Color(0, 102, 102));
        etiologiaCorrespondente.setText("etiologiaCorrespondente");

        perdaTecidualCorrespondente.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        perdaTecidualCorrespondente.setForeground(new java.awt.Color(0, 102, 102));
        perdaTecidualCorrespondente.setText("perdaTecidualCorrespondente");

        lesaoPorPressaoCorrespondente.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        lesaoPorPressaoCorrespondente.setForeground(new java.awt.Color(0, 102, 102));
        lesaoPorPressaoCorrespondente.setText("lesaoPorPressaoCorrespondente");

        status.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        status.setText("Status:");

        statusCorrespondente.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        statusCorrespondente.setForeground(new java.awt.Color(0, 102, 102));
        statusCorrespondente.setText("lesaoPorPressaoCorrespondente");

        status1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        status1.setText("Descrição:");

        descricaoCorrespondente.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        descricaoCorrespondente.setForeground(new java.awt.Color(0, 102, 102));
        descricaoCorrespondente.setText("descricaoCorrespondente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descricaoCorrespondente, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(status1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(fatorDesencadenteCorrespondente)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiologiaCorrespondente)
                    .addComponent(perdaTecidualCorrespondente)
                    .addComponent(lesaoPorPressaoCorrespondente)
                    .addComponent(statusCorrespondente))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fatorDesencadenteCorrespondente)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiologiaCorrespondente)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(perdaTecidualCorrespondente)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lesaoPorPressaoCorrespondente)
                .addGap(18, 18, 18)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusCorrespondente)
                .addGap(18, 18, 18)
                .addComponent(status1)
                .addGap(18, 18, 18)
                .addComponent(descricaoCorrespondente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel2);

        jSplitPane1.setLeftComponent(jSplitPane2);

        nomeDoPacienteSelecionado2.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        nomeDoPacienteSelecionado2.setText("Nome do Paciente Selecionado");

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel8.setText("Data de nascimento:");

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel9.setText("Convênio:");

        dataDeNascimentoDoPaciente.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        dataDeNascimentoDoPaciente.setForeground(new java.awt.Color(0, 153, 153));
        dataDeNascimentoDoPaciente.setText("Data de Nasciemento");

        convenioDoPaciente.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        convenioDoPaciente.setForeground(new java.awt.Color(0, 153, 153));
        convenioDoPaciente.setText("Convênio do paciente Selecionado");

        textoSelecionarData.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        textoSelecionarData.setText("Data:");

        selecaoDeData.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        selecaoDeData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imagemFeridaMao.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nomeDoPacienteSelecionado2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataDeNascimentoDoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSelecionarData, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(convenioDoPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(selecaoDeData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(nomeDoPacienteSelecionado2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dataDeNascimentoDoPaciente))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(convenioDoPaciente))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoSelecionarData)
                    .addComponent(selecaoDeData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel4);

        javax.swing.GroupLayout fundoAzulLayout = new javax.swing.GroupLayout(fundoAzul);
        fundoAzul.setLayout(fundoAzulLayout);
        fundoAzulLayout.setHorizontalGroup(
            fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoAzulLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSplitPane1)
        );
        fundoAzulLayout.setVerticalGroup(
            fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoAzulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundoAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundoAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DadosPacienteProntuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DadosPacienteProntuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DadosPacienteProntuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DadosPacienteProntuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DadosPacienteProntuarios().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel convenioDoPaciente;
    private javax.swing.JLabel dataDeNascimentoDoPaciente;
    private javax.swing.JLabel descricaoCorrespondente;
    private javax.swing.JLabel etiologiaCorrespondente;
    private javax.swing.JLabel fatorDesencadenteCorrespondente;
    private javax.swing.JPanel fundoAzul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lesaoPorPressaoCorrespondente;
    private javax.swing.JLabel nomeDoPacienteSelecionado;
    private javax.swing.JLabel nomeDoPacienteSelecionado2;
    private javax.swing.JLabel perdaTecidualCorrespondente;
    private javax.swing.JComboBox<String> selecaoDeData;
    private javax.swing.JLabel status;
    private javax.swing.JLabel status1;
    private javax.swing.JLabel statusCorrespondente;
    private javax.swing.JLabel textoSelecionarData;
    // End of variables declaration//GEN-END:variables
}
