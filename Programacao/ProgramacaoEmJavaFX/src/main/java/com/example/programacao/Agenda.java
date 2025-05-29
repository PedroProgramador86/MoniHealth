package com.example.programacao;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Agenda extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Layout principal
        BorderPane root = new BorderPane();

        // Topo com menus
        HBox topoMenu = criarTopoMenu();
        root.setTop(topoMenu);

        // Esquerda: Pacientes do Dia
        VBox painelPacientes = criarPainelPacientes();
        root.setLeft(painelPacientes);

        // Centro: Agenda
        VBox centroAgenda = criarPainelAgenda();
        root.setCenter(centroAgenda);

        Scene scene = new Scene(root, 700, 400);
        primaryStage.setTitle("MoniHealth - Agenda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox criarTopoMenu() {
        HBox menu = new HBox(10);
        menu.setStyle("-fx-padding: 10; -fx-background-color: #007fff;");

        Button btnAgenda = new Button("Agenda");
        Button btnPainel = new Button("Painel");
        Button btnProntuarios = new Button("Prontuários");

        menu.getChildren().addAll(new Label("🔷 MoniHealth"), btnAgenda, btnPainel, btnProntuarios);
        return menu;
    }

    private VBox criarPainelPacientes() {
        VBox painel = new VBox(10);
        painel.setStyle("-fx-background-color: #e0ffff; -fx-padding: 15;");

        Label titulo = new Label("Pacientes do Dia");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label data = new Label("25 Fevereiro 2025\n11:37");
        data.setStyle("-fx-font-size: 16px;");

        TableView<String> tabela = new TableView<>();
        tabela.setPlaceholder(new Label("Nenhum paciente"));

        painel.getChildren().addAll(titulo, data, tabela);
        return painel;
    }

    private VBox criarPainelAgenda() {
        VBox painel = new VBox(10);
        painel.setStyle("-fx-padding: 10;");

        HBox topo = new HBox(10);
        TextField campoBusca = new TextField();
        campoBusca.setPromptText("Buscar Paciente");
        Button novoAgendamento = new Button("+ Novo Agendamento");
        topo.getChildren().addAll(campoBusca, novoAgendamento);

        GridPane tabelaAgenda = new GridPane();
        tabelaAgenda.setGridLinesVisible(true);
        preencherTabelaAgenda(tabelaAgenda);

        painel.getChildren().addAll(topo, tabelaAgenda);
        return painel;
    }

    private void preencherTabelaAgenda(GridPane grid) {
        // Cabeçalhos de dias
        String[] dias = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        for (int i = 0; i < dias.length; i++) {
            grid.add(new Label(dias[i]), i + 1, 0);
        }

        // Horários
        int horaInicio = 9;
        int horaFim = 17;
        for (int i = horaInicio; i <= horaFim; i++) {
            grid.add(new Label(String.format("%02d:00", i)), 0, i - horaInicio + 1);
        }

        // Exemplo de agendamento
        Label exemplo = new Label("PAC: Beatriz\nENF: Lillian");
        exemplo.setStyle("-fx-background-color: lightblue; -fx-padding: 5;");
        grid.add(exemplo, 3, 4); // Terça às 11h
    }

    public static void main(String[] args) {
        launch(args);
    }
}
