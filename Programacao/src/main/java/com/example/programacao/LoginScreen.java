package com.example.programacao;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Lado esquerdo com logo e nome
        VBox leftPane = new VBox(20);
        leftPane.setAlignment(Pos.CENTER);
        leftPane.setPadding(new Insets(40));
        leftPane.setStyle("-fx-background-color: #1E90FF;");

        Text title = new Text("MoniHealth");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        title.setFill(Color.web("#AEEFFF"));

        // Coração estilizado (texto como placeholder do logo)
        Label logo = new Label("❤");
        logo.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        logo.setTextFill(Color.WHITE);

        Label brand = new Label("TRYEASE");
        brand.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        brand.setTextFill(Color.WHITE);

        leftPane.getChildren().addAll(title, logo, brand);

        // Lado direito com campos de login
        VBox rightPane = new VBox(10);
        rightPane.setAlignment(Pos.CENTER_LEFT);
        rightPane.setPadding(new Insets(40));
        rightPane.setSpacing(10);

        Label loginLabel = new Label("Login");
        loginLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));

        Label emailLabel = new Label("E-mail:");
        TextField emailField = new TextField();
        emailField.setPrefWidth(250);

        Label passwordLabel = new Label("Senha:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefWidth(250);

        CheckBox rememberMe = new CheckBox("Lembre-me");

        Hyperlink forgotPassword = new Hyperlink("Esqueceu sua senha ?");
        forgotPassword.setTextFill(Color.DEEPSKYBLUE);

        Button loginButton = new Button("Entrar");
        loginButton.setPrefWidth(250);
        loginButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");

        HBox bottomLinks = new HBox(5);
        bottomLinks.setAlignment(Pos.CENTER_LEFT);
        Label noAccount = new Label("Não possui uma conta ?");
        Hyperlink register = new Hyperlink("Cadastrar-se");
        register.setTextFill(Color.DEEPSKYBLUE);
        bottomLinks.getChildren().addAll(noAccount, register);

        GridPane loginForm = new GridPane();
        loginForm.setVgap(10);
        loginForm.setHgap(5);
        loginForm.add(emailLabel, 0, 0);
        loginForm.add(emailField, 0, 1);
        loginForm.add(passwordLabel, 0, 2);
        loginForm.add(passwordField, 0, 3);
        loginForm.add(rememberMe, 0, 4);
        loginForm.add(forgotPassword, 0, 5);
        loginForm.add(loginButton, 0, 6);
        loginForm.add(bottomLinks, 0, 7);

        rightPane.getChildren().addAll(loginLabel, loginForm);

        // Layout principal
        HBox root = new HBox();
        root.getChildren().addAll(leftPane, rightPane);
        root.setStyle("-fx-background-color: linear-gradient(to right, #87CEFA, #FFFFFF);");

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setTitle("MoniHealth - Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
