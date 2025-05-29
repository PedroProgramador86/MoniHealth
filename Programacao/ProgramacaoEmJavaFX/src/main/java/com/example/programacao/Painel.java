package com.example.programacao;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Painel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Título do App
        Label tituloPacientes = new Label("Pacientes do Dia");
        tituloPacientes.setFont(new Font("Arial", 24));
        tituloPacientes.setStyle("-fx-background-color: #00e0ff; -fx-text-fill: black;");
        tituloPacientes.setMaxWidth(Double.MAX_VALUE);
        tituloPacientes.setAlignment(Pos.CENTER);

        // Data e hora simuladas
        Label data = new Label("25  Fevereiro  2025");
        data.setFont(new Font(16));
        Label hora = new Label("11:37");
        hora.setFont(new Font(32));
        VBox dataHoraBox = new VBox(data, hora);
        dataHoraBox.setAlignment(Pos.CENTER);

        // Tabela lateral com pacientes
        VBox tabelaPacientes = new VBox(10);
        tabelaPacientes.setPadding(new Insets(10));
        tabelaPacientes.getChildren().addAll(
                criarLinhaPaciente("09:30", "Pedro Enzo Lima Luna"),
                criarLinhaPaciente("10:00", "Levi Miranda Gomes"),
                criarLinhaPaciente("11:30", "Beatriz Dybowski"),
                criarLinhaPaciente("12:30", "João Kalvin Fontenele"),
                criarLinhaPaciente("16:25", "Amanda Araujo"),
                criarLinhaPaciente("17:00", "Julio Cezar Pereira")
        );

        VBox painelEsquerdo = new VBox(tituloPacientes, dataHoraBox, tabelaPacientes);
        painelEsquerdo.setPadding(new Insets(10));
        painelEsquerdo.setSpacing(15);
        painelEsquerdo.setStyle("-fx-background-color: #e0e0e0;");
        painelEsquerdo.setPrefWidth(250);

        // Painel de estatísticas
        Label tituloPainel = new Label("Painel");
        tituloPainel.setFont(new Font("Arial", 24));

        HBox estatisticas = new HBox(30,
                criarEstatistica("12", "ATENDIDOS", "green"),
                criarEstatistica("23", "AGENDADOS", "black"),
                criarEstatistica("6", "FALTANTES", "red"),
                criarEstatistica("5", "CONFIRMADOS", "deepskyblue")
        );
        estatisticas.setAlignment(Pos.CENTER);

        // Histórico de consultas (tabela simplificada)
        TableView<String> historicoConsultas = new TableView<>();
        historicoConsultas.setPlaceholder(new Label("Histórico de consultas será adicionado aqui."));

        VBox painelDireito = new VBox(10, tituloPainel, estatisticas, new Label("Histórico de Consultas:"), historicoConsultas);
        painelDireito.setPadding(new Insets(15));
        painelDireito.setPrefWidth(600);

        // Painel principal
        HBox root = new HBox(painelEsquerdo, painelDireito);
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MoniHealth Painel");
        primaryStage.show();
    }

    private HBox criarLinhaPaciente(String hora, String nome) {
        Label horaLabel = new Label(hora);
        Label nomeLabel = new Label(nome);
        Button calendario = new Button("📅");
        HBox linha = new HBox(10, horaLabel, nomeLabel, calendario);
        linha.setAlignment(Pos.CENTER_LEFT);
        return linha;
    }

    private VBox criarEstatistica(String valor, String titulo, String cor) {
        Label valorLabel = new Label(valor);
        valorLabel.setFont(new Font(24));
        valorLabel.setStyle("-fx-text-fill: " + cor + ";");
        Label tituloLabel = new Label(titulo);
        tituloLabel.setStyle("-fx-text-fill: " + cor + ";");
        VBox box = new VBox(valorLabel, tituloLabel);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
