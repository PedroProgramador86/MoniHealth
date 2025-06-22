import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InfoPacienteProntuarios extends javax.swing.JFrame {

    private String nomeEnfermeira;
    
    private String nomePaciente;
    private String dataNascimento;
    private String convenio;

    /**
     * Creates new form InfoPacientePront
     */
    public InfoPacienteProntuarios(String nomeEnfermeira, String nomePaciente, String dataNascimento, String convenio){
        
        this.nomeEnfermeira = nomeEnfermeira;    
        
        initComponents();
        
        adicionarImagem.addActionListener(e -> {
            AdicionarImagem dialog = new AdicionarImagem(this, true);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        });
                
        setPacienteInfo(nomePaciente, dataNascimento, convenio, nomeEnfermeira);



        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
                
        botaoMostrarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DadosPacienteProntuarios tela = new DadosPacienteProntuarios(
                    nomeEnfermeira,
                    nomeDoPacienteSelecionado.getText(),
                    dataDeNascimentoDoPaciente.getText(),
                    convenioDoPaciente.getText()
                );
                tela.setVisible(true);
                dispose(); // Fecha a tela atual
            }
        });
        
    }
    
        



    
    private String getTextoCheckboxFator() {
        if (jCheckBox1.isSelected()) return "Trauma";
        if (jCheckBox2.isSelected()) return "Espontâneo";
        if (jCheckBox3.isSelected()) return "Outros";
        return "";
    }

    private String getTextoCheckboxEtiologia() {
        if (jCheckBox4.isSelected()) return "Pressão";
        if (jCheckBox5.isSelected()) return "Mista";
        if (jCheckBox6.isSelected()) return "Cirúrgica";
        if (jCheckBox7.isSelected()) return "Oncológica";
        if (jCheckBox8.isSelected()) return "Venenosa";
        if (jCheckBox9.isSelected()) return "Arterial";
        if (jCheckBox10.isSelected()) return "Neuropática";
        if (jCheckBox11.isSelected()) return "Outra";
        return "";
    }

    private String getTextoCheckboxPerdaTecido() {
        if (jCheckBox13.isSelected()) return "Superficial";
        if (jCheckBox14.isSelected()) return "Profunda Total";
        if (jCheckBox15.isSelected()) return "Profunda Parcial";
        return "";
    }

    private String getTextoCheckboxLesao() {
        if (jCheckBox16.isSelected()) return "Estágio I";
        if (jCheckBox19.isSelected()) return "Estágio II";
        if (jCheckBox20.isSelected()) return "Estágio III";
        if (jCheckBox21.isSelected()) return "Estágio IV";
        if (jCheckBox22.isSelected()) return "Não Classificável";
        if (jCheckBox23.isSelected()) return "Em Membrana Mucosa";
        return "";
    }

    
    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        Prontuarios tela = new Prontuarios(nomeEnfermeira);
        tela.setVisible(true);
        this.dispose();
    }



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
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        nomeDoPacienteSelecionado2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dataDeNascimentoDoPaciente = new javax.swing.JLabel();
        convenioDoPaciente = new javax.swing.JLabel();
        textoImagensCadastradas1 = new javax.swing.JLabel();
        nomeDaEnfermeiraQueRegistrouAImagem = new javax.swing.JLabel();
        textoImagensCadastradas2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoDeObservacoes = new javax.swing.JTextArea();
        botaoSalvar = new javax.swing.JButton();
        campoAlterarDataDeAlteracao = new javax.swing.JFormattedTextField();
        textoDataDeAlteracao = new javax.swing.JLabel();
        botaoMostrarInfo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        alteraStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        adicionarImagem = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fundoAzul.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MoniHealth");

        jSplitPane1.setDividerLocation(390);

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

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setText("Fator Desencadente:");

        jCheckBox1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox1.setText("Trauma");

        jCheckBox2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox2.setText("Expontâneo");

        jCheckBox3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox3.setText("Outros");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel4.setText("Etiologia:");

        jCheckBox4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox4.setText("Pressão");

        jCheckBox5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox5.setText("Mista");

        jCheckBox6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox6.setText("Cirúrgica");

        jCheckBox7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox7.setText("Oncológica");

        jCheckBox8.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox8.setText("Venenosa");

        jCheckBox9.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox9.setText("Arterial");

        jCheckBox10.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox10.setText("Neuropática");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        jCheckBox11.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox11.setText("Outra");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel5.setText("Perda Tecidual:");

        jCheckBox13.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox13.setText("Superficial");

        jCheckBox14.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox14.setText("Profunda Total");

        jCheckBox15.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox15.setText("Profunda Parcial");
        jCheckBox15.setActionCommand("");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel6.setText("Lesão por Pressão:");

        jCheckBox16.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox16.setText("Estagio I");

        jCheckBox19.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox19.setText("Estagio II");

        jCheckBox20.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox20.setText("Estagio III");

        jCheckBox21.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox21.setText("Estagio IV");

        jCheckBox22.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox22.setText("Não Classificavel");

        jCheckBox23.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jCheckBox23.setText("Em membrana mucosa");
        jCheckBox23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox11)
                            .addComponent(jCheckBox10)
                            .addComponent(jCheckBox9)
                            .addComponent(jCheckBox8))
                        .addGap(73, 73, 73))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox3)
                            .addComponent(jLabel5)
                            .addComponent(jCheckBox13)
                            .addComponent(jCheckBox14)
                            .addComponent(jCheckBox15)
                            .addComponent(jCheckBox20)
                            .addComponent(jCheckBox21))
                        .addGap(0, 172, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox16)
                            .addComponent(jCheckBox19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox22)
                            .addComponent(jCheckBox23))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox19)
                    .addComponent(jCheckBox22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox21)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel2);

        jSplitPane1.setLeftComponent(jSplitPane2);

        nomeDoPacienteSelecionado2.setFont(new java.awt.Font("sansserif", 0, 30)); // NOI18N
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

        textoImagensCadastradas1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        textoImagensCadastradas1.setText("Registrado por Enfermeiro(a):");

        nomeDaEnfermeiraQueRegistrouAImagem.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        nomeDaEnfermeiraQueRegistrouAImagem.setForeground(new java.awt.Color(0, 153, 153));
        nomeDaEnfermeiraQueRegistrouAImagem.setText("Nome do Enfermeiro(a)");

        textoImagensCadastradas2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        textoImagensCadastradas2.setText("Informações Registradas:");

        descricaoDeObservacoes.setColumns(20);
        descricaoDeObservacoes.setRows(5);
        jScrollPane1.setViewportView(descricaoDeObservacoes);

        botaoSalvar.setBackground(new java.awt.Color(0, 255, 0));
        botaoSalvar.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        botaoSalvar.setForeground(new java.awt.Color(255, 255, 255));
        botaoSalvar.setText("Salvar");

        campoAlterarDataDeAlteracao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        textoDataDeAlteracao.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        textoDataDeAlteracao.setText("Data de Alteração:");

        botaoMostrarInfo.setBackground(new java.awt.Color(0, 102, 204));
        botaoMostrarInfo.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        botaoMostrarInfo.setForeground(new java.awt.Color(255, 255, 255));
        botaoMostrarInfo.setText("Mostrar Info");

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel10.setText("Status:");

        alteraStatus.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        alteraStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Pagamento Pendente", "Internado", "Desativado", "Obito" }));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setText("Progresso de Imagens:");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setText("03/04/2025");

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel11.setText("17/04/2025");

        jLabel12.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel12.setText("01/04/2025");

        jLabel13.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel13.setText("15/04/2025");

        jPanel6.setBackground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        adicionarImagem.setBackground(new java.awt.Color(0, 255, 204));
        adicionarImagem.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        adicionarImagem.setText("Adicionar Imagem");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImagemIlustrativaDeFerida.png"))); // NOI18N
        jLabel15.setText("jLabel15");

        jLabel14.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel14.setText("15/04/2025");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImagemIlustrativaDeFerida.png"))); // NOI18N
        jLabel21.setText("jLabel15");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImagemIlustrativaDeFerida.png"))); // NOI18N
        jLabel22.setText("jLabel15");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImagemIlustrativaDeFerida.png"))); // NOI18N
        jLabel23.setText("jLabel15");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImagemIlustrativaDeFerida.png"))); // NOI18N
        jLabel24.setText("jLabel15");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(convenioDoPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(dataDeNascimentoDoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(alteraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nomeDoPacienteSelecionado2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adicionarImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoMostrarInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(787, 787, 787)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(152, 152, 152)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(205, 205, 205)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(textoImagensCadastradas2)
                                .addGap(328, 328, 328))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(46, 46, 46))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(textoDataDeAlteracao)
                        .addGap(18, 18, 18)
                        .addComponent(campoAlterarDataDeAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(514, 514, 514))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(textoImagensCadastradas1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeDaEnfermeiraQueRegistrouAImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(nomeDoPacienteSelecionado2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dataDeNascimentoDoPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(convenioDoPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(alteraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adicionarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(botaoMostrarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoImagensCadastradas1)
                            .addComponent(nomeDaEnfermeiraQueRegistrouAImagem))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoDataDeAlteracao)
                            .addComponent(campoAlterarDataDeAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoImagensCadastradas2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundoAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fundoAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox23ActionPerformed


    
    
    
    public void setPacienteInfo(String nome, String dataNascimento, String convenio, String nomeEnfermeira) {
        nomeDoPacienteSelecionado.setText(nome);
        nomeDoPacienteSelecionado2.setText(nome);
        dataDeNascimentoDoPaciente.setText(dataNascimento);
        convenioDoPaciente.setText(convenio);
        nomeDaEnfermeiraQueRegistrouAImagem.setText(nomeEnfermeira);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String nomePaciente = nomeDoPacienteSelecionado.getText();
        if (nomePaciente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um paciente antes de salvar.");
            return;
        }
        String fator = getTextoCheckboxFator();
        String etiologia = getTextoCheckboxEtiologia();
        String perdaTecido = getTextoCheckboxPerdaTecido();
        String lesao = getTextoCheckboxLesao();

        try (Connection conn = ConexaoBancoDeDados.conectar()) {
            String sql = "INSERT INTO ProntuariosPaciente (NomePaciente, FatorDesencadeante, Etiologia, PerdaTecidual, LesaoPressao, StatusPaciente, DataDeAlteracao, Descricao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomePaciente);
            stmt.setString(2, fator);
            stmt.setString(3, etiologia);
            stmt.setString(4, perdaTecido);
            stmt.setString(5, lesao);
            stmt.setString(6, alteraStatus.getSelectedItem().toString());
            

            // Convertendo data do campo para java.sql.Date
            java.sql.Date dataSql = null;
            try {
                java.util.Date utilDate = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(campoAlterarDataDeAlteracao.getText());
                dataSql = new java.sql.Date(utilDate.getTime());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy.");
                return;
            }

            stmt.setDate(7, dataSql);
            
            stmt.setString(8, descricaoDeObservacoes.getText());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Prontuário salvo com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar prontuário.");
        }

    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarImagem;
    private javax.swing.JComboBox<String> alteraStatus;
    private javax.swing.JButton botaoMostrarInfo;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JFormattedTextField campoAlterarDataDeAlteracao;
    private javax.swing.JLabel convenioDoPaciente;
    private javax.swing.JLabel dataDeNascimentoDoPaciente;
    private javax.swing.JTextArea descricaoDeObservacoes;
    private javax.swing.JPanel fundoAzul;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel nomeDaEnfermeiraQueRegistrouAImagem;
    private javax.swing.JLabel nomeDoPacienteSelecionado;
    private javax.swing.JLabel nomeDoPacienteSelecionado2;
    private javax.swing.JLabel textoDataDeAlteracao;
    private javax.swing.JLabel textoImagensCadastradas1;
    private javax.swing.JLabel textoImagensCadastradas2;
    // End of variables declaration//GEN-END:variables
}
