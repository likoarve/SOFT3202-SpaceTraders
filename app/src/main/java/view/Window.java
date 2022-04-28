package view;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import model.Engine;

public class Window {
    private Engine engine;
    private Scene scene;
    private StackPane root;

    public Window(Engine engine) {
        this.engine = engine;

        this.root = new StackPane();
        root.setStyle("""
                -fx-background-image: url('bg2.png');
                -fx-background-repeat: no-repeat;\s
                -fx-background-size: 896 648;\s
                -fx-background-position: center center;""");
        openScreen1();

        this.scene = new Scene(this.root, 896, 648);
    }

    public void openScreen1() {
        root.getChildren().clear();

        Rectangle rect = new Rectangle();
        rect.setWidth(700);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label label1 = new Label("Welcome to");
        label1.setFont(Font.font("monospace",20));
        label1.setTranslateY(-100);
        label1.setTextFill(Color.rgb(212,212,212));
        label1.setMinWidth(500);
        label1.setTextAlignment(TextAlignment.LEFT);
        root.getChildren().add(label1);

        Label label2 = new Label("SpaceTraders");
        label2.setFont(Font.font("Lucida Sans",60));
        label2.setTextFill(Color.rgb(212,212,212));
        label2.setMinWidth(500);
        label2.setTextAlignment(TextAlignment.LEFT);
        label2.setTranslateY(-50);
        root.getChildren().add(label2);

        Line line = new Line();
        line.setStroke(Color.rgb(255,51,51));
        line.setStartX(100);
        line.setEndX(280);
        line.setTranslateY(10);
        line.setTranslateX(-155);
        root.getChildren().add(line);

        Button login = new Button("Login");
        login.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        login.setMinWidth(120);
        login.setMinHeight(45);
        login.setTranslateX(-184);
        login.setTranslateY(60);
        login.setOnAction(event -> openLoginScreen());
        login.setOnMouseEntered(event -> login.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        login.setOnMouseExited(event -> login.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        root.getChildren().add(login);

        Button signup = new Button("Sign Up");
        signup.setStyle("-fx-background-color: rgb(190,55,55); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        signup.setMinWidth(130);
        signup.setMinHeight(45);
        signup.setTranslateX(-40);
        signup.setTranslateY(60);
        signup.setOnAction(event -> openSignUpScreen());
        signup.setOnMouseEntered(event -> signup.setStyle("-fx-background-color: rgb(161,45,45); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        signup.setOnMouseExited(event -> signup.setStyle("-fx-background-color: rgb(190,55,55); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        root.getChildren().add(signup);

        Label status = new Label();
        status.setFont(Font.font("monospace",16));
        status.setTranslateY(300);
        status.setMinWidth(870);
        status.setTextAlignment(TextAlignment.LEFT);

        if (engine.serverIsOnline()) {
            status.setText("Server status: Online");
            status.setTextFill(Color.rgb(69,210,54));
        } else {
            status.setText("Server status: Offline");
            status.setTextFill(Color.rgb(227,58,58));
        }

        root.getChildren().add(status);
    }

    public void openLoginScreen() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-220);
        backButton.setTranslateY(-201);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openScreen1());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(380);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label signIn = new Label("Sign In");
        signIn.setFont(Font.font("Lucida Sans",30));
        signIn.setTextFill(Color.rgb(212,212,212));
        signIn.setTranslateY(-160);
        root.getChildren().add(signIn);

        Label username = new Label("Username");
        username.setFont(Font.font("monospace",18));
        username.setTranslateY(-90);
        username.setTextFill(Color.rgb(212,212,212));
        username.setMinWidth(290);
        username.setTextAlignment(TextAlignment.LEFT);
        root.getChildren().add(username);

        TextField usernameInput = new TextField();
        usernameInput.setMaxWidth(300);
        usernameInput.setPrefHeight(40);
        usernameInput.setTranslateY(-50);
        usernameInput.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:20;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        root.getChildren().add(usernameInput);

        Label token = new Label("Token");
        token.setFont(Font.font("monospace",18));
        token.setTranslateY(5);
        token.setTextFill(Color.rgb(212,212,212));
        token.setMinWidth(290);
        token.setTextAlignment(TextAlignment.LEFT);
        root.getChildren().add(token);

        TextField tokenInput = new TextField();
        tokenInput.setMaxWidth(300);
        tokenInput.setPrefHeight(40);
        tokenInput.setTranslateY(45);
        tokenInput.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:20;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        root.getChildren().add(tokenInput);

        Button login = new Button("Login");
        login.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        login.setMinWidth(290);
        login.setMinHeight(45);
        login.setTranslateY(130);
        login.setOnAction(event -> {
            if (!usernameInput.getText().matches("^[A-Za-z0-9]+$") || !tokenInput.getText().matches("^[-A-Za-z0-9]+$")) {
                Alert notify = new Alert(Alert.AlertType.ERROR);
                notify.setHeaderText("Login Failed");
                notify.setContentText("The combination you entered is invalid.");
                notify.showAndWait();
            } else if (engine.login(usernameInput.getText(), tokenInput.getText())) {
                openMainMenu();
            } else {
                Alert notify = new Alert(Alert.AlertType.ERROR);
                notify.setHeaderText("Login Failed");
                notify.setContentText("The combination you entered is invalid.");
                notify.showAndWait();
            }
        });
        login.setOnMouseEntered(event -> login.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        login.setOnMouseExited(event -> login.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        root.getChildren().add(login);
    }

    public void openSignUpScreen() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-327);
        backButton.setTranslateY(-180);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openScreen1());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);


        Rectangle rect = new Rectangle();
        rect.setWidth(700);
        rect.setHeight(300);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        TextField textField = new TextField();
        textField.setMaxWidth(500);
        textField.setPrefHeight(60);
        textField.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:20;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        root.getChildren().add(textField);

        Label label1 = new Label("Enter your Username: ");
        label1.setFont(Font.font("monospace", FontWeight.BOLD,24));
        label1.setTranslateY(-65);
        label1.setTextFill(Color.rgb(212,212,212));
        label1.setMinWidth(500);
        root.getChildren().add(label1);

        Button signup = new Button("Sign Up");
        signup.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        signup.setMinWidth(120);
        signup.setMinHeight(45);
        signup.setTranslateX(-187);
        signup.setTranslateY(75);
        signup.setOnAction(event -> {
            if (!textField.getText().matches("^[A-Za-z0-9]+$")) {
                Alert notify = new Alert(Alert.AlertType.ERROR);
                notify.setHeaderText("Invalid Username");
                notify.setContentText("Your username must not contain any spaces or special characters.");
                notify.showAndWait();
            } else if (engine.signup(textField.getText())) {
                openMainMenu();
            } else {
                Alert notify = new Alert(Alert.AlertType.ERROR);
                notify.setHeaderText("Invalid Username");
                notify.setContentText("This username is taken.");
                notify.showAndWait();
            }
        });
        signup.setOnMouseEntered(event -> signup.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        signup.setOnMouseExited(event -> signup.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        root.getChildren().add(signup);
    }

    public void openMainMenu() {
        root.getChildren().clear();

        Button account = new Button("Account");
        account.setOnAction(event -> openAccountPage());
        account.setTranslateY(140);
        account.setPrefSize(170,70);
        account.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-radius: 10px;" +
                "-fx-border-color:rgb(25,28,38);");
        account.setOnMouseEntered(event -> {
            account.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        account.setOnMouseExited(event -> {
            account.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        Button loan = new Button("Available\nLoans");
        loan.setTextAlignment(TextAlignment.CENTER);
        loan.setOnAction(event -> openAvailableLoansPage());
        loan.setTranslateY(-100);
        loan.setPrefSize(170,70);
        loan.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-border-color:rgb(25,28,38);"+
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;");
        loan.setOnMouseEntered(event -> {
            loan.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        loan.setOnMouseExited(event -> {
            loan.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        Button loan2 = new Button("Active Loans");
        loan2.setTextAlignment(TextAlignment.CENTER);
        loan2.setOnAction(event -> openActiveLoansPage());
        loan2.setPrefSize(170,70);
        loan2.setTranslateY(-20);
        loan2.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-border-color:rgb(25,28,38);"+
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;");
        loan2.setOnMouseEntered(event -> {
            loan2.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        loan2.setOnMouseExited(event -> {
            loan2.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        Button ships = new Button("Purchase\nShips");
        ships.setOnAction(event -> openAvailableShipsPage());
        ships.setTextAlignment(TextAlignment.CENTER);
        ships.setTranslateY(-100);
        ships.setTranslateX(-180);
        ships.setPrefSize(170,70);
        ships.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-border-color:rgb(25,28,38);"+
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;");
        ships.setOnMouseEntered(event -> {
            ships.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        ships.setOnMouseExited(event -> {
            ships.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        Button ships2 = new Button("Your Ships");
        ships2.setOnAction(event -> openUserShipsPage());
        ships2.setTextAlignment(TextAlignment.CENTER);
        ships2.setTranslateX(-180);
        ships2.setTranslateY(-20);
        ships2.setPrefSize(170,70);
        ships2.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-border-color:rgb(25,28,38);"+
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;");
        ships2.setOnMouseEntered(event -> {
            ships2.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        ships2.setOnMouseExited(event -> {
            ships2.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        Button travel = new Button("Plan\nTravel");
        travel.setOnAction(event -> openPlanFlightPage());
        travel.setTextAlignment(TextAlignment.CENTER);
        travel.setTranslateY(-100);
        travel.setTranslateX(180);
        travel.setPrefSize(170,70);
        travel.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-border-color:rgb(25,28,38);"+
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;");
        travel.setOnMouseEntered(event -> {
            travel.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        travel.setOnMouseExited(event -> {
            travel.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        Button travel2 = new Button("Current\nTravels");
        travel2.setOnAction(event -> openCurrentFlightsPage());
        travel2.setTranslateY(-20);
        travel2.setTextAlignment(TextAlignment.CENTER);
        travel2.setTranslateX(180);
        travel2.setPrefSize(170,70);
        travel2.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-border-color:rgb(25,28,38);"+
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;");
        travel2.setOnMouseEntered(event -> {
            travel2.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        travel2.setOnMouseExited(event -> {
            travel2.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        Button location = new Button("Nearby\nLocations");
        location.setOnAction(event -> openNearbyLocationsPage());
        location.setTranslateY(60);
        location.setTextAlignment(TextAlignment.CENTER);
        location.setTranslateX(180);
        location.setPrefSize(170,70);
        location.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-border-color:rgb(25,28,38);"+
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;");
        location.setOnMouseEntered(event -> {
            location.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        location.setOnMouseExited(event -> {
            location.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        Button marketplace = new Button("Marketplace\nBuy Items");
        marketplace.setOnAction(event -> openMarketplaceBuyPage());
        marketplace.setTranslateY(60);
        marketplace.setTextAlignment(TextAlignment.CENTER);
        marketplace.setPrefSize(170,70);
        marketplace.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-border-color:rgb(25,28,38);"+
                "-fx-border-radius: 10px;" +
                "-fx-background-radius: 10px;");
        marketplace.setOnMouseEntered(event -> {
            marketplace.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        marketplace.setOnMouseExited(event -> {
            marketplace.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        Button sell = new Button("Marketplace\nSell Items");
        sell.setOnAction(event -> openMarketplaceSellPage());
        sell.setTranslateY(60);
        sell.setTextAlignment(TextAlignment.CENTER);
        sell.setTranslateX(-180);
        sell.setPrefSize(170,70);
        sell.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: monospace;" +
                "-fx-background-radius: 10px;" +
                "-fx-border-color:rgb(25,28,38);"+
                "-fx-border-radius: 10px;");
        sell.setOnMouseEntered(event -> {
            sell.setStyle("-fx-background-color: rgba(0,0,0,0.8); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: hand;");
        });
        sell.setOnMouseExited(event -> {
            sell.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                    "-fx-font-size:16;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: rgb(212,212,212);" +
                    "-fx-font-family: monospace;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-border-color:rgb(25,28,38);" +
                    "-fx-cursor: cursor;");
        });

        root.getChildren().add(account);
        root.getChildren().add(loan2);
        root.getChildren().add(loan);
        root.getChildren().add(ships);
        root.getChildren().add(ships2);
        root.getChildren().add(location);
        root.getChildren().add(marketplace);
        root.getChildren().add(travel);
        root.getChildren().add(travel2);
        root.getChildren().add(sell);
    }

    public void openAccountPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-201);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Account Information");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-160);
        root.getChildren().add(header);

        Label info = new Label(engine.getUserInfo());
        info.setFont(Font.font("monospace",18));
        info.setTranslateY(0);
        info.setTextFill(Color.rgb(212,212,212));
        info.setMinWidth(400);
        info.setMaxWidth(400);
        info.setLineSpacing(1.5);
        info.setWrapText(true);
        info.setTextAlignment(TextAlignment.LEFT);
        root.getChildren().add(info);

        Button copy = new Button("Copy Token to Clipboard");
        copy.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        copy.setMinWidth(150);
        copy.setMinHeight(27);
        copy.setTranslateY(145);
        copy.setTranslateX(-100);
        copy.setOnMouseEntered(event -> copy.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        copy.setOnMouseExited(event -> copy.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        copy.setOnAction(event -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(engine.getToken());
            clipboard.setContent(clipboardContent);
        });
        root.getChildren().add(copy);
    }

    public void openAvailableLoansPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-201);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Available Loans");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-160);
        root.getChildren().add(header);

        Label info = new Label(engine.getAvailableLoans());
        info.setFont(Font.font("monospace",18));
        info.setTextFill(Color.rgb(212,212,212));
        info.setMinWidth(400);
        info.setMaxWidth(400);
        info.setLineSpacing(1.5);
        info.setWrapText(true);
        info.setTextAlignment(TextAlignment.LEFT);

        ScrollPane sp = new ScrollPane();
        sp.setMaxSize(400,300);
        sp.setStyle("-fx-background:transparent; -fx-background-color:transparent;");
        sp.setHmax(0);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setTranslateY(35);
        sp.setContent(info);

        root.getChildren().add(sp);

        Button getLoan = new Button("Take Loan");
        getLoan.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        getLoan.setMinWidth(150);
        getLoan.setMinHeight(27);
        getLoan.setTranslateY(115);
        getLoan.setTranslateX(-120);
        getLoan.setOnMouseEntered(event -> getLoan.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        getLoan.setOnMouseExited(event -> getLoan.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));

        getLoan.setOnAction(event -> {
            String response = engine.takeLoan();

            Alert notify = new Alert(Alert.AlertType.NONE);
            notify.setTitle("Your loan");
            if (response.equals("Success")) {
                notify.setAlertType(Alert.AlertType.INFORMATION);
                notify.setHeaderText("Loan Successful.");
                notify.setContentText("Go to 'Active Loans' to view the loan details.");
            } else {
                notify.setAlertType(Alert.AlertType.ERROR);
                notify.setHeaderText("Loan Failed.");
                notify.setContentText(response);
            }
            notify.showAndWait();
        });

        root.getChildren().add(getLoan);
    }

    public void openActiveLoansPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-201);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Your Active Loans");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-160);
        root.getChildren().add(header);

        Label info = new Label(engine.getActiveLoans());
        info.setFont(Font.font("monospace",18));
        info.setTextFill(Color.rgb(212,212,212));
        info.setMinWidth(400);
        info.setMaxWidth(400);
        info.setLineSpacing(1.5);
        info.setWrapText(true);
        info.setTextAlignment(TextAlignment.LEFT);

        ScrollPane sp = new ScrollPane();
        sp.setMaxSize(400,300);
        sp.setStyle("-fx-background:transparent; -fx-background-color:transparent;");
        sp.setHmax(0);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setTranslateY(35);
        sp.setContent(info);

        root.getChildren().add(sp);
    }

    public void openAvailableShipsPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-201);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Available Ships");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-160);
        root.getChildren().add(header);

        Label info = new Label(engine.getAvailableShips());
        info.setFont(Font.font("monospace",18));
        info.setTextFill(Color.rgb(212,212,212));
        info.setMinWidth(400);
        info.setMaxWidth(400);
        info.setLineSpacing(1.5);
        info.setWrapText(true);
        info.setTextAlignment(TextAlignment.LEFT);

        ScrollPane sp = new ScrollPane();
        sp.setMaxSize(400,240);
        sp.setStyle("-fx-background:transparent; -fx-background-color:transparent;");
        sp.setHmax(0);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setTranslateY(5);
        sp.setContent(info);
        root.getChildren().add(sp);

        ComboBox<String> box = new ComboBox<>();
        box.setItems(FXCollections.observableList(engine.getAvailableShipsDropdown()));
        box.getSelectionModel().selectFirst();
        box.setMaxWidth(300);
        box.setPrefHeight(40);
        box.setTranslateX(-50);
        box.setTranslateY(170);
        box.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:20;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");

        root.getChildren().add(box);

        Button buy = new Button("Buy");
        buy.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        buy.setMinWidth(80);
        buy.setMinHeight(40);
        buy.setTranslateY(170);
        buy.setTranslateX(160);
        buy.setOnMouseEntered(event -> buy.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        buy.setOnMouseExited(event -> buy.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        buy.setOnAction(event -> {
            String response = engine.buyShip(box.getValue());

            Alert notify = new Alert(Alert.AlertType.NONE);
            notify.setTitle("Ship Purchase");
            if (response.equals("Success")) {
                notify.setAlertType(Alert.AlertType.INFORMATION);
                notify.setHeaderText("Purchase Successful.");
                notify.setContentText("You can now view your ship and use it to travel!");
            } else {
                notify.setAlertType(Alert.AlertType.ERROR);
                notify.setHeaderText("Purchase Failed.");
                notify.setContentText(response);
            }
            notify.showAndWait();
        });

        root.getChildren().add(buy);
    }

    public void openUserShipsPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-201);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Your Ships");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-160);
        root.getChildren().add(header);

        Label info = new Label(engine.getUserShips());
        info.setFont(Font.font("monospace",16));
        info.setTextFill(Color.rgb(212,212,212));
        info.setMinWidth(400);
        info.setMaxWidth(400);
        info.setLineSpacing(1.5);
        info.setWrapText(true);
        info.setTextAlignment(TextAlignment.LEFT);

        ScrollPane sp = new ScrollPane();
        sp.setMaxSize(400,300);
        sp.setStyle("-fx-background:transparent; -fx-background-color:transparent;");
        sp.setHmax(0);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setTranslateY(35);
        sp.setContent(info);
        root.getChildren().add(sp);
    }

    public void openNearbyLocationsPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-201);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Nearby Locations");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-160);
        root.getChildren().add(header);

        Label info = new Label(engine.getNearbyLocations());
        info.setFont(Font.font("monospace",16));
        info.setTextFill(Color.rgb(212,212,212));
        info.setMinWidth(400);
        info.setMaxWidth(400);
        info.setLineSpacing(1.5);
        info.setWrapText(true);
        info.setTextAlignment(TextAlignment.LEFT);

        ScrollPane sp = new ScrollPane();
        sp.setMaxSize(400,300);
        sp.setStyle("-fx-background:transparent; -fx-background-color:transparent;");
        sp.setHmax(0);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setTranslateY(35);
        sp.setContent(info);
        root.getChildren().add(sp);
    }

    public void openMarketplaceBuyPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-251);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(550);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Marketplace (Buy)");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-210);
        root.getChildren().add(header);

        if (engine.getCurrentLocations().isEmpty()) {
            Label info = new Label("No ships docked in a marketplace.");
            info.setFont(Font.font("monospace",16));
            info.setTextFill(Color.rgb(212,212,212));
            info.setMinWidth(400);
            info.setMaxWidth(400);
            info.setLineSpacing(1.5);
            info.setTranslateY(-140);
            info.setWrapText(true);
            info.setTextAlignment(TextAlignment.LEFT);

            root.getChildren().add(info);
            return;
        }

        ComboBox<String> box = new ComboBox<>();
        box.setItems(FXCollections.observableList(engine.getCurrentLocations()));
        box.getSelectionModel().selectFirst();
        box.setMaxWidth(300);
        box.setPrefHeight(40);
        box.setTranslateX(-50);
        box.setTranslateY(-150);
        box.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");

        root.getChildren().add(box);

        Button search = new Button("Search");
        search.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        search.setMinWidth(80);
        search.setMinHeight(35);
        search.setTranslateY(-150);
        search.setTranslateX(160);
        search.setOnMouseEntered(event -> search.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        search.setOnMouseExited(event -> search.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        root.getChildren().add(search);

        Label info = new Label(engine.getMarketplace(box.getValue()));
        info.setFont(Font.font("monospace",16));
        info.setTextFill(Color.rgb(212,212,212));
        info.setMinWidth(400);
        info.setMaxWidth(400);
        info.setLineSpacing(1.5);
        info.setWrapText(true);
        info.setTextAlignment(TextAlignment.LEFT);

        ScrollPane sp = new ScrollPane();
        sp.setMaxSize(400,240);
        sp.setStyle("-fx-background:transparent; -fx-background-color:transparent;");
        sp.setHmax(0);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setTranslateY(8);
        sp.setContent(info);
        root.getChildren().add(sp);

        ComboBox<String> box2 = new ComboBox<>();
        box2.setItems(FXCollections.observableList(engine.getGoodsNames(box.getValue())));
        box2.getSelectionModel().selectFirst();
        box2.setMaxWidth(320);
        box2.setPrefHeight(30);
        box2.setTranslateX(-40);
        box2.setTranslateY(170);
        box2.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");

        root.getChildren().add(box2);

        ComboBox<String> box3 = new ComboBox<>();
        box3.setItems(FXCollections.observableList(engine.getShipsByLocation(box.getValue())));
        box3.getSelectionModel().selectFirst();
        box3.setMaxWidth(210);
        box3.setPrefHeight(30);
        box3.setTranslateX(-95);
        box3.setTranslateY(215);
        box3.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");

        root.getChildren().add(box3);

        search.setOnAction(event -> {
            info.setText(engine.getMarketplace(box.getValue()));
            box2.setItems(FXCollections.observableList(engine.getGoodsNames(box.getValue())));
            box2.getSelectionModel().selectFirst();
            box3.setItems(FXCollections.observableList(engine.getShipsByLocation(box.getValue())));
            box3.getSelectionModel().selectFirst();
        });

        TextField qty = new TextField();
        qty.setPromptText("Qty: ");
        qty.setMaxWidth(65);
        qty.setPrefHeight(38);
        qty.setTranslateX(168);
        qty.setTranslateY(170);
        qty.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        root.getChildren().add(qty);

        Button buy = new Button("Purchase");
        buy.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        buy.setMinWidth(80);
        buy.setMinHeight(27);
        buy.setTranslateY(215);
        buy.setTranslateX(70);
        buy.setOnMouseEntered(event -> buy.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        buy.setOnMouseExited(event -> buy.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        buy.setOnAction(event -> {
            String response;
            if (!qty.getText().matches("[0-9]+") || Integer.parseInt(qty.getText()) == 0) {
                response = "Invalid quantity entered.";
            } else {
                response = engine.buyGoods(box3.getValue(), box2.getValue(), qty.getText());
            }

            Alert notify = new Alert(Alert.AlertType.NONE);
            notify.setTitle("Marketplace");
            if (response.equals("Success")) {
                notify.setAlertType(Alert.AlertType.INFORMATION);
                notify.setHeaderText("Purchase Successful.");
                notify.setContentText("Your item has been added to your ship's cargo.");
            } else {
                notify.setAlertType(Alert.AlertType.ERROR);
                notify.setHeaderText("Purchase Failed.");
                notify.setContentText(response);
            }
            notify.showAndWait();
        });
        root.getChildren().add(buy);
    }

    public void openMarketplaceSellPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-251);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(550);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Marketplace - Sell");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-210);
        root.getChildren().add(header);

        if (engine.getCurrentLocations().isEmpty()) {
            Label info = new Label("No ships docked in a marketplace.");
            info.setFont(Font.font("monospace",16));
            info.setTextFill(Color.rgb(212,212,212));
            info.setMinWidth(400);
            info.setMaxWidth(400);
            info.setLineSpacing(1.5);
            info.setTranslateY(-140);
            info.setWrapText(true);
            info.setTextAlignment(TextAlignment.LEFT);

            root.getChildren().add(info);
            return;
        }

        ComboBox<String> box = new ComboBox<>();
        box.setItems(FXCollections.observableList(engine.getCurrentLocations()));
        box.getSelectionModel().selectFirst();
        box.setMaxWidth(300);
        box.setPrefHeight(40);
        box.setTranslateX(-50);
        box.setTranslateY(-150);
        box.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");

        root.getChildren().add(box);

        Button search = new Button("Search");
        search.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        search.setMinWidth(80);
        search.setMinHeight(35);
        search.setTranslateY(-150);
        search.setTranslateX(160);
        search.setOnMouseEntered(event -> search.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        search.setOnMouseExited(event -> search.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:16;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        root.getChildren().add(search);

        Label info = new Label(engine.getMarketplace(box.getValue()));
        info.setFont(Font.font("monospace",16));
        info.setTextFill(Color.rgb(212,212,212));
        info.setMinWidth(400);
        info.setMaxWidth(400);
        info.setLineSpacing(1.5);
        info.setWrapText(true);
        info.setTextAlignment(TextAlignment.LEFT);

        ScrollPane sp = new ScrollPane();
        sp.setMaxSize(400,240);
        sp.setStyle("-fx-background:transparent; -fx-background-color:transparent;");
        sp.setHmax(0);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setTranslateY(8);
        sp.setContent(info);
        root.getChildren().add(sp);

        ComboBox<String> box2 = new ComboBox<>();
        box2.setItems(FXCollections.observableList(engine.getGoodsNames(box.getValue())));
        box2.getSelectionModel().selectFirst();
        box2.setMaxWidth(320);
        box2.setPrefHeight(30);
        box2.setTranslateX(-40);
        box2.setTranslateY(170);
        box2.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");

        root.getChildren().add(box2);

        ComboBox<String> box3 = new ComboBox<>();
        box3.setItems(FXCollections.observableList(engine.getShipsByLocation(box.getValue())));
        box3.getSelectionModel().selectFirst();
        box3.setMaxWidth(210);
        box3.setPrefHeight(30);
        box3.setTranslateX(-95);
        box3.setTranslateY(215);
        box3.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");

        root.getChildren().add(box3);

        search.setOnAction(event -> {
            info.setText(engine.getMarketplace(box.getValue()));
            box2.setItems(FXCollections.observableList(engine.getGoodsNames(box.getValue())));
            box2.getSelectionModel().selectFirst();
            box3.setItems(FXCollections.observableList(engine.getShipsByLocation(box.getValue())));
            box3.getSelectionModel().selectFirst();
        });

        TextField qty = new TextField();
        qty.setPromptText("Qty: ");
        qty.setMaxWidth(65);
        qty.setPrefHeight(38);
        qty.setTranslateX(168);
        qty.setTranslateY(170);
        qty.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:16;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        root.getChildren().add(qty);

        Button sell = new Button("Sell");
        sell.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        sell.setMinWidth(80);
        sell.setMinHeight(27);
        sell.setTranslateY(215);
        sell.setTranslateX(70);
        sell.setOnMouseEntered(event -> sell.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        sell.setOnMouseExited(event -> sell.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:15;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));
        sell.setOnAction(event -> {
            String response;
            if (!qty.getText().matches("[0-9]+") || Integer.parseInt(qty.getText()) == 0) {
                response = "Invalid quantity entered.";
            } else {
                response = engine.sellGoods(box3.getValue(), box2.getValue(), qty.getText());
            }

            Alert notify = new Alert(Alert.AlertType.NONE);
            notify.setTitle("Marketplace");
            if (response.equals("Success")) {
                notify.setAlertType(Alert.AlertType.INFORMATION);
                notify.setHeaderText("Transaction Successful.");
                notify.setContentText("Your item is have been sold.");
            } else {
                notify.setAlertType(Alert.AlertType.ERROR);
                notify.setHeaderText("Transaction Failed.");
                notify.setContentText(response);
            }
            notify.showAndWait();
        });
        root.getChildren().add(sell);
    }

    public void openPlanFlightPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-201);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Plan a flight.");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-160);
        root.getChildren().add(header);

        if (engine.getCurrentLocations().isEmpty()) {
            Label info = new Label("No ships available to travel. Buy a new ship or wait for your ship to arrive in its destination.");
            info.setFont(Font.font("monospace",16));
            info.setTextFill(Color.rgb(212,212,212));
            info.setMinWidth(400);
            info.setMaxWidth(400);
            info.setLineSpacing(1.5);
            info.setTranslateY(-90);
            info.setWrapText(true);
            info.setTextAlignment(TextAlignment.LEFT);

            root.getChildren().add(info);
            return;
        }

        Label ship = new Label("Choose a ship.");
        ship.setFont(Font.font("monospace",16));
        ship.setTextFill(Color.rgb(212,212,212));
        ship.setMinWidth(400);
        ship.setMaxWidth(400);
        ship.setLineSpacing(1.5);
        ship.setTranslateY(-90);
        ship.setWrapText(true);
        ship.setTextAlignment(TextAlignment.LEFT);

        root.getChildren().add(ship);

        ComboBox<String> selectShip = new ComboBox<>();
        selectShip.setItems(FXCollections.observableList(engine.getShipID()));
        selectShip.getSelectionModel().selectFirst();
        selectShip.setMaxWidth(400);
        selectShip.setPrefHeight(40);
        selectShip.setTranslateY(-50);
        selectShip.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:20;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");

        root.getChildren().add(selectShip);

        Label dest = new Label("Choose a destination.");
        dest.setFont(Font.font("monospace",16));
        dest.setTextFill(Color.rgb(212,212,212));
        dest.setMinWidth(400);
        dest.setMaxWidth(400);
        dest.setLineSpacing(1.5);
        dest.setTranslateY(10);
        dest.setWrapText(true);
        dest.setTextAlignment(TextAlignment.LEFT);

        root.getChildren().add(dest);

        ComboBox<String> selectDest = new ComboBox<>();
        selectDest.setItems(FXCollections.observableList(engine.getNearbyLocationSymbols()));
        selectDest.getSelectionModel().selectFirst();
        selectDest.setMaxWidth(400);
        selectDest.setPrefHeight(40);
        selectDest.setTranslateY(50);
        selectDest.setStyle("-fx-background-color: rgba(0,0,0,0.4); " +
                "-fx-font-size:20;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        root.getChildren().add(selectDest);

        Button travel = new Button("Travel");
        travel.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:18;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;");
        travel.setMinWidth(110);
        travel.setMinHeight(35);
        travel.setTranslateY(115);
        travel.setTranslateX(-145);
        travel.setOnMouseEntered(event -> travel.setStyle("-fx-background-color: rgb(92,17,17); " +
                "-fx-font-size:18;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: hand;"));
        travel.setOnMouseExited(event -> travel.setStyle("-fx-background-color: rgb(110,20,20); " +
                "-fx-font-size:18;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 10px;" +
                "-fx-cursor: pointer;"));

        travel.setOnAction(event -> {
            String response = engine.travel(selectShip.getValue(), selectDest.getValue());

            Alert notify = new Alert(Alert.AlertType.NONE);
            notify.setTitle("Travel");
            if (response.equals("Success")) {
                notify.setAlertType(Alert.AlertType.INFORMATION);
                notify.setHeaderText("Travel Successful.");
                notify.setContentText("You're travel is underway! Go to 'Current Flights' for details.");
            } else {
                notify.setAlertType(Alert.AlertType.ERROR);
                notify.setHeaderText("Travel Failed.");
                notify.setContentText(response);
            }
            notify.showAndWait();
        });

        root.getChildren().add(travel);
    }

    public void openCurrentFlightsPage() {
        root.getChildren().clear();

        Button backButton = new Button("<");
        backButton.setPrefSize(45,40);
        backButton.setTranslateX(-280);
        backButton.setTranslateY(-201);
        backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                "-fx-font-size:20;" +
                "-fx-font-weight: 700;" +
                "-fx-text-fill: rgb(212,212,212);" +
                "-fx-font-family: Helvetica;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color:rgb(25,28,38);");
        backButton.setOnAction(event -> openMainMenu());
        backButton.setOnMouseEntered(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: hand;")
        );
        backButton.setOnMouseExited(event ->
                backButton.setStyle("-fx-background-color: rgba(0, 0, 0, 0.219); " +
                        "-fx-font-size:20;" +
                        "-fx-font-weight: 700;" +
                        "-fx-text-fill: rgb(212,212,212);" +
                        "-fx-font-family: Helvetica;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color:rgb(25,28,38);" +
                        "-fx-cursor: pointer;")
        );
        root.getChildren().add(backButton);

        Rectangle rect = new Rectangle();
        rect.setWidth(500);
        rect.setHeight(450);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0, 0, 0, 0.219));
        rect.setStroke(Color.rgb(25,28,38));
        rect.setStrokeWidth(1.00);
        root.getChildren().add(rect);

        Label header = new Label("Active Flights");
        header.setMinWidth(400);
        header.setTextAlignment(TextAlignment.LEFT);
        header.setFont(Font.font("Lucida Sans",30));
        header.setTextFill(Color.rgb(212,212,212));
        header.setTranslateY(-160);
        root.getChildren().add(header);

        Label info = new Label(engine.getCurrentFlightDetails());
        info.setFont(Font.font("monospace",16));
        info.setTextFill(Color.rgb(212,212,212));
        info.setMinWidth(400);
        info.setMaxWidth(400);
        info.setLineSpacing(1.5);
        info.setWrapText(true);
        info.setTextAlignment(TextAlignment.LEFT);

        ScrollPane sp = new ScrollPane();
        sp.setMaxSize(400,300);
        sp.setStyle("-fx-background:transparent; -fx-background-color:transparent;");
        sp.setHmax(0);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setTranslateY(35);
        sp.setContent(info);
        root.getChildren().add(sp);
    }

    public Scene getScene() {
        return this.scene;
    }
}
