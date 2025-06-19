import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendamentoPaciente extends javax.swing.JDialog {

    private Agenda agenda;

    public AgendamentoPaciente(java.awt.Frame parent, boolean modal, Agenda agenda) {
        super(parent, modal);
        this.agenda = agenda;  // Atribui a referência da Agenda
        initComponents();
        
        botaoCadastrarPaciente.addActionListener(e -> {
            // Cria e exibe a janela CadastroPaciente, passando o parent e true (modal)
            CadastroPaciente cadastroPaciente = new CadastroPaciente(parent, true); // 'this' passa o frame atual
            cadastroPaciente.setVisible(true);  // Torna a janela visível
            dispose();  // Fecha a janela atual (AgendamentoPaciente) após abrir a de cadastro
        });


        
        botaoCancelar.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar?", "Cancelar", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose(); // Fecha a janela se o usuário confirmar
            }
        });

        
        selecaoDePacientesCadastrados.addItemListener(evt -> {
            if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                String nomePacienteSelecionado = (String) selecaoDePacientesCadastrados.getSelectedItem();
                // Verifique se o item não é nulo e se não é o texto "Nenhum paciente encontrado"
                if (nomePacienteSelecionado != null && !nomePacienteSelecionado.trim().isEmpty() && !nomePacienteSelecionado.equals("Nenhum paciente encontrado")) {
                    carregarDadosPaciente(nomePacienteSelecionado); // Carrega os dados do paciente
                }
            }
       });


        carregarPacientesNoComboBox();  // Carrega os pacientes no ComboBox ao iniciar a tela
        botaoCancelar.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar?", "Cancelar", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose(); // Fecha a janela se o usuário confirmar
            }
        });
        
        botaoSairEsalvar.addActionListener(e -> {
            // Obter dados dos campos
            String tipoAgendamento = inserirTipoDeAgendamento.getText();
            String dataAgendamento = inserirData.getText();  // Data do agendamento

            // Conversão da data para o formato esperado pelo MySQL
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  // Formato de entrada
            String formattedDate = "";
            try {
                Date date = sdf.parse(dataAgendamento); // Converte a string para Date
                SimpleDateFormat mysqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Formato do MySQL
                formattedDate = mysqlDateFormat.format(date); // Converte para o formato esperado pelo MySQL
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao formatar a data. Certifique-se de que a data está no formato correto (dd/MM/yyyy).");
                return; // Caso a data esteja em um formato inválido
            }

            // Continuando com os outros dados
            String horaAgendamento = (String) selecaoHorarios.getSelectedItem();  // Hora do agendamento
            String statusAgendamento = "Pendente";  // Status padrão para o agendamento
            String observacoes = "";  // Se tiver algum campo de observações, você pode preencher aqui
            String nomePacienteSelecionado = (String) selecaoDePacientesCadastrados.getSelectedItem();
            String diaDaSemana = (String) selecaoDiasDaSemana.getSelectedItem();  // Obtém o valor do dia da semana

            // Verificar se os campos obrigatórios estão preenchidos
            if (tipoAgendamento.isEmpty() || formattedDate.isEmpty() || horaAgendamento == null || nomePacienteSelecionado == null || nomePacienteSelecionado.equals("Nenhum paciente encontrado") || diaDaSemana == null) {
                JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos.");
                return; // Não permite salvar se os campos estiverem vazios
            }

            // Aqui, ao invés de usar IDs, vamos pegar os nomes diretamente
            String nomePaciente = nomePacienteSelecionado; // O nome do paciente selecionado
            String nomeEnfermeira = enfermeiroDoPaciente.getText(); // Nome do enfermeiro (pode ser obtido de algum campo de texto)

            // Verificar se o nome do paciente e enfermeira foram encontrados
            if (nomePaciente != null && !nomePaciente.isEmpty() && nomeEnfermeira != null && !nomeEnfermeira.isEmpty()) {
                // Inserir dados no banco de dados, usando os nomes diretamente
                inserirAgendamento(nomePaciente, nomeEnfermeira, formattedDate, horaAgendamento, tipoAgendamento, statusAgendamento, observacoes, diaDaSemana);

                // Atualizar a tabela da agenda após inserção
                agenda.atualizarTabelaAgenda();
            } else {
                JOptionPane.showMessageDialog(null, "Paciente ou Enfermeira não encontrados.");
            }
        });





        
        
        
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelzinhoAzul = new javax.swing.JPanel();
        textoAgendarNovoPaciente = new javax.swing.JLabel();
        nomeDoPaciente = new javax.swing.JLabel();
        selecaoDePacientesCadastrados = new javax.swing.JComboBox<>();
        nomeDoPaciente1 = new javax.swing.JLabel();
        nomeDoConvenio = new javax.swing.JLabel();
        nomeDoPaciente3 = new javax.swing.JLabel();
        selecaoHorarios = new javax.swing.JComboBox<>();
        nomeDoPaciente4 = new javax.swing.JLabel();
        selecaoDiasDaSemana = new javax.swing.JComboBox<>();
        nomeDoPaciente5 = new javax.swing.JLabel();
        inserirTipoDeAgendamento = new javax.swing.JTextField();
        nomeDoPaciente6 = new javax.swing.JLabel();
        enfermeiroDoPaciente = new javax.swing.JLabel();
        botaoCadastrarPaciente = new javax.swing.JButton();
        botaoSairEsalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        nomeDoPaciente8 = new javax.swing.JLabel();
        inserirData = new javax.swing.JFormattedTextField();
        nomeDoPaciente9 = new javax.swing.JLabel();
        telefoneDoPaciente = new javax.swing.JLabel();
        nomeDoPaciente11 = new javax.swing.JLabel();
        emailDoPaciente = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelzinhoAzul.setBackground(new java.awt.Color(0, 255, 255));

        textoAgendarNovoPaciente.setFont(new java.awt.Font("sansserif", 0, 48)); // NOI18N
        textoAgendarNovoPaciente.setText("Agendar Novo Paciente");

        javax.swing.GroupLayout painelzinhoAzulLayout = new javax.swing.GroupLayout(painelzinhoAzul);
        painelzinhoAzul.setLayout(painelzinhoAzulLayout);
        painelzinhoAzulLayout.setHorizontalGroup(
            painelzinhoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelzinhoAzulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoAgendarNovoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelzinhoAzulLayout.setVerticalGroup(
            painelzinhoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelzinhoAzulLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoAgendarNovoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        nomeDoPaciente.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPaciente.setText("Paciente:");

        selecaoDePacientesCadastrados.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        selecaoDePacientesCadastrados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        nomeDoPaciente1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPaciente1.setText("Convênio:");

        nomeDoConvenio.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoConvenio.setForeground(new java.awt.Color(0, 153, 153));
        nomeDoConvenio.setText("convênio do paciente");

        nomeDoPaciente3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPaciente3.setText("Hórario:");

        selecaoHorarios.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        selecaoHorarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        nomeDoPaciente4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPaciente4.setText("Dia da semana:");

        selecaoDiasDaSemana.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        selecaoDiasDaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado" }));

        nomeDoPaciente5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPaciente5.setText("Tipo de Agendamento:");

        inserirTipoDeAgendamento.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        nomeDoPaciente6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPaciente6.setText("Enfermeiro:");

        enfermeiroDoPaciente.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        enfermeiroDoPaciente.setForeground(new java.awt.Color(0, 153, 153));
        enfermeiroDoPaciente.setText("enfermeiro do paciente");

        botaoCadastrarPaciente.setBackground(new java.awt.Color(102, 102, 255));
        botaoCadastrarPaciente.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        botaoCadastrarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        botaoCadastrarPaciente.setText("Cadastrar Paciente");

        botaoSairEsalvar.setBackground(new java.awt.Color(0, 255, 0));
        botaoSairEsalvar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        botaoSairEsalvar.setForeground(new java.awt.Color(255, 255, 255));
        botaoSairEsalvar.setText("Salvar e Sair");

        botaoCancelar.setBackground(new java.awt.Color(255, 51, 51));
        botaoCancelar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        botaoCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botaoCancelar.setText("Cancelar");

        nomeDoPaciente8.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPaciente8.setText("Data:");

        inserirData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        nomeDoPaciente9.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPaciente9.setText("E-mail:");

        telefoneDoPaciente.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        telefoneDoPaciente.setForeground(new java.awt.Color(0, 153, 153));
        telefoneDoPaciente.setText("convênio do paciente");

        nomeDoPaciente11.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nomeDoPaciente11.setText("Telefone:");

        emailDoPaciente.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        emailDoPaciente.setForeground(new java.awt.Color(0, 153, 153));
        emailDoPaciente.setText("convênio do paciente");

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/bazukart/NetBeansProjects/JavaApplication1/src/images/Logo_MoniHealth_TRYEASE_FundoTransparente.png")); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelzinhoAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoSairEsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoCadastrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nomeDoPaciente9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailDoPaciente))
                            .addComponent(nomeDoPaciente)
                            .addComponent(selecaoDePacientesCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nomeDoPaciente1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomeDoConvenio))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeDoPaciente4)
                                    .addComponent(nomeDoPaciente3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selecaoHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selecaoDiasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeDoPaciente5)
                            .addComponent(inserirTipoDeAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeDoPaciente6)
                            .addComponent(enfermeiroDoPaciente)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nomeDoPaciente8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inserirData, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nomeDoPaciente11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(telefoneDoPaciente)))))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelzinhoAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeDoPaciente)
                    .addComponent(nomeDoPaciente5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecaoDePacientesCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inserirTipoDeAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeDoPaciente6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeDoPaciente1)
                        .addComponent(nomeDoConvenio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enfermeiroDoPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeDoPaciente8)
                            .addComponent(inserirData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeDoPaciente11)
                            .addComponent(telefoneDoPaciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCadastrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSairEsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeDoPaciente4)
                            .addComponent(selecaoDiasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeDoPaciente3)
                            .addComponent(selecaoHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeDoPaciente9)
                            .addComponent(emailDoPaciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(10, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void carregarPacientesNoComboBox() {
        try (Connection conn = ConexaoBancoDeDados.conectar()) {
            String sql = "SELECT Nome FROM Pacientes ORDER BY Nome";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            selecaoDePacientesCadastrados.removeAllItems(); // Limpa o combo
            boolean encontrou = false;

            while (rs.next()) {
                String nome = rs.getString("Nome");
                selecaoDePacientesCadastrados.addItem(nome);
                encontrou = true;
            }

            if (!encontrou) {
                selecaoDePacientesCadastrados.addItem("Nenhum paciente encontrado");
            }

        } catch (Exception e) {
            e.printStackTrace();
            selecaoDePacientesCadastrados.removeAllItems();
            selecaoDePacientesCadastrados.addItem("Erro ao carregar pacientes");
        }
    }

    
    private void carregarDadosPaciente(String nomePaciente) {
        try (Connection conn = ConexaoBancoDeDados.conectar()) {
            String sql = "SELECT * FROM Pacientes WHERE Nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomePaciente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Preencher os campos com os dados do paciente
                nomeDoConvenio.setText(rs.getString("Convenio"));
                emailDoPaciente.setText(rs.getString("Email"));
                telefoneDoPaciente.setText(rs.getString("Telefone"));
                enfermeiroDoPaciente.setText(rs.getString("Enfermeira"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void inserirAgendamento(String nomePaciente, String nomeEnfermeira, String dataAgendamento, String horaAgendamento, 
                                 String tipoAgendamento, String statusAgendamento, String observacoes, String diaDaSemana) {
        try (Connection conn = ConexaoBancoDeDados.conectar()) {
            String sql = "INSERT INTO Agendamentos (NomePaciente, NomeEnfermeira, DataAgendamento, HoraAgendamento, " +
                         "TipoAgendamento, StatusAgendamento, Observacoes, DiaDaSemana) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nomePaciente);            // Nome do paciente
            stmt.setString(2, nomeEnfermeira);          // Nome da enfermeira
            stmt.setString(3, dataAgendamento);         // Data do agendamento
            stmt.setString(4, horaAgendamento);         // Hora do agendamento
            stmt.setString(5, tipoAgendamento);         // Tipo do agendamento
            stmt.setString(6, statusAgendamento);       // Status do agendamento
            stmt.setString(7, observacoes);             // Observações
            stmt.setString(8, diaDaSemana);             // Dia da semana

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso.");
            dispose(); // Fechar a tela de agendamento após salvar
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao realizar o agendamento.");
        }
    }



    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrarPaciente;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSairEsalvar;
    private javax.swing.JLabel emailDoPaciente;
    private javax.swing.JLabel enfermeiroDoPaciente;
    private javax.swing.JFormattedTextField inserirData;
    private javax.swing.JTextField inserirTipoDeAgendamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nomeDoConvenio;
    private javax.swing.JLabel nomeDoPaciente;
    private javax.swing.JLabel nomeDoPaciente1;
    private javax.swing.JLabel nomeDoPaciente11;
    private javax.swing.JLabel nomeDoPaciente3;
    private javax.swing.JLabel nomeDoPaciente4;
    private javax.swing.JLabel nomeDoPaciente5;
    private javax.swing.JLabel nomeDoPaciente6;
    private javax.swing.JLabel nomeDoPaciente8;
    private javax.swing.JLabel nomeDoPaciente9;
    private javax.swing.JPanel painelzinhoAzul;
    private javax.swing.JComboBox<String> selecaoDePacientesCadastrados;
    private javax.swing.JComboBox<String> selecaoDiasDaSemana;
    private javax.swing.JComboBox<String> selecaoHorarios;
    private javax.swing.JLabel telefoneDoPaciente;
    private javax.swing.JLabel textoAgendarNovoPaciente;
    // End of variables declaration//GEN-END:variables
}
