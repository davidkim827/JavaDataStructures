package Homework.Week7_QueueGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class QueueGUI extends Application implements EventHandler<ActionEvent> {

    private Button startButton;
    private Button stopButton;

    private Label hoursLabel;
    private Label daysLabel;

    private TextField hoursTextField;
    private TextField daysTextField;
    private TextArea resultsTextArea;

    private Image deskImage;
    private ImageView deskImageView;

    private Image customer0;
    private ImageView customer0View;
    private Image customer1;
    private ImageView customer1View;
    private Image customer2;
    private ImageView customer2View;
    private Image customer3;
    private ImageView customer3View;
    private Image customer4;
    private ImageView customer4View;
    private Image customer5;
    private ImageView customer5View;
    private Image customer6;
    private ImageView customer6View;
    private Image customer7;
    private ImageView customer7View;
    private Image customer8;
    private ImageView customer8View;
    private Image customer9;
    private ImageView customer9View;
    private Image customer10;
    private ImageView customer10View;

    private Controller controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");

        startButton = new Button("Start");
        startButton.setPrefSize(120.0, 30.0);
        startButton.setLayoutX(500.0);
        startButton.setLayoutY(160.0);

        stopButton = new Button("Stop");
        stopButton.setPrefSize(120.0, 30.0);
        stopButton.setLayoutX(620.0);
        stopButton.setLayoutY(160.0);

        hoursLabel = new Label("Hours");
        hoursLabel.setLayoutX(500.0);
        hoursLabel.setLayoutY(105.0);

        daysLabel = new Label("Days");
        daysLabel.setLayoutX(500.0);
        daysLabel.setLayoutY(135.0);

        hoursTextField = new TextField("8");
        hoursTextField.setPrefWidth(120.0);
        hoursTextField.setLayoutX(620.0);
        hoursTextField.setLayoutY(100.0);

        daysTextField = new TextField("1");
        daysTextField.setPrefWidth(120.0);
        daysTextField.setLayoutX(620.0);
        daysTextField.setLayoutY(130.0);

        resultsTextArea = new TextArea("Results");
        resultsTextArea.setPrefRowCount(4);
        resultsTextArea.setPrefSize(240.0, 100.0);
        resultsTextArea.setLayoutX(500.0);
        resultsTextArea.setLayoutY(190.0);

        deskImage = new Image("file:desk.png", 450.0, 270.0, true, true);
        deskImageView = new ImageView(deskImage);
        deskImageView.setLayoutX(75.0);
        deskImageView.setLayoutY(20.0);

        customer0 = new Image("File:0.png", 50.0, 100.0, true, true);
        customer0View = new ImageView(customer0);
        customer0View.setLayoutX(235.0);
        customer0View.setLayoutY(395.0);

        customer1 = new Image("File:1.png", 50.0, 100.0, true, true);
        customer1View = new ImageView(customer1);
        customer1View.setLayoutX(270.0);
        customer1View.setLayoutY(395.0);

        customer2 = new Image("File:2.png", 50.0, 100.0, true, true);
        customer2View = new ImageView(customer2);
        customer2View.setLayoutX(305.0);
        customer2View.setLayoutY(395.0);

        customer3 = new Image("File:3.png", 50.0, 100.0, true, true);
        customer3View = new ImageView(customer3);
        customer3View.setLayoutX(340.0);
        customer3View.setLayoutY(395.0);

        customer4 = new Image("File:4.png", 50.0, 100.0, true, true);
        customer4View = new ImageView(customer4);
        customer4View.setLayoutX(375.0);
        customer4View.setLayoutY(395.0);

        customer5 = new Image("File:5.png", 50.0, 100.0, true, true);
        customer5View = new ImageView(customer5);
        customer5View.setLayoutX(410.0);
        customer5View.setLayoutY(395.0);

        customer6 = new Image("File:6.png", 50.0, 100.0, true, true);
        customer6View = new ImageView(customer6);
        customer6View.setLayoutX(445.0);
        customer6View.setLayoutY(395.0);

        customer7 = new Image("File:7.png", 50.0, 100.0, true, true);
        customer7View = new ImageView(customer7);
        customer7View.setLayoutX(480.0);
        customer7View.setLayoutY(395.0);

        customer8 = new Image("File:8.png", 50.0, 100.0, true, true);
        customer8View = new ImageView();
        customer8View.setLayoutX(515.0);
        customer8View.setLayoutY(395.0);

        customer9 = new Image("File:9.png", 50.0, 100.0, true, true);
        customer9View = new ImageView(customer9);
        customer9View.setLayoutX(550.0);
        customer9View.setLayoutY(395.0);

        customer10 = new Image("File:10.png", 50.0, 100.0, true, true);
        customer10View = new ImageView(customer10);
        customer10View.setLayoutX(400.0);
        customer10View.setLayoutY(150.0);

        AnchorPane layout = new AnchorPane();
        layout.getChildren().addAll(startButton, stopButton, hoursLabel, daysLabel, hoursTextField, daysTextField,
                resultsTextArea, deskImageView, customer0View, customer1View, customer2View, customer3View,
                customer4View, customer5View, customer6View, customer7View, customer8View, customer9View,
                customer10View);

        Scene scene = new Scene(layout, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        startButton.setOnAction(this);
        stopButton.setOnAction(this);
        this.controller = new Controller(resultsTextArea);
        controller.start();
    }


    public void handle(ActionEvent event) {
        if (event.getSource() == startButton) {
            controller.setStatus(1);
        }
        if (event.getSource() == stopButton) {
            controller.setStatus(2);
        }
    }
}
