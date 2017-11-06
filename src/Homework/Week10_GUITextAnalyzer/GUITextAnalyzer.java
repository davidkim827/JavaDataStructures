package Homework.Week10_GUITextAnalyzer;

/**
 * Created by dk on 11/5/2017.
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class GUITextAnalyzer extends Application implements EventHandler<ActionEvent> {

    private Button lengthButton; //button to call the length method in TextAnalyzer class if clicked
    private Button vowelsButton; //button to call the numberOfVowels method in TextAnalyzer class if clicked
    private Button upperCaseButton; //button to call the numberOfUppercase method in TextAnalyzer class if clicked
    private Button latinAlphabetButton; //button to call the numberOfLatinAlphabetic method in TextAnalyzer class if clicked

    private TextArea userInputArea; //textarea for user input
    private Label analysisResultLabel; //label to be updated with the results from the calculations

    private TextAnalyzer logic; //connects the GUI to the background logic class, TextAnalyzer

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Analyzer");

        lengthButton = new Button("Length");
        lengthButton.setPrefSize(70.0,25.0);
        lengthButton.setLayoutX(10.0);
        lengthButton.setLayoutY(90.0);

        vowelsButton = new Button("Vowels");
        vowelsButton.setPrefSize(70.0, 25.0);
        vowelsButton.setLayoutX(90.0);
        vowelsButton.setLayoutY(90.0);

        upperCaseButton = new Button("Uppercase");
        upperCaseButton.setPrefSize(100.0, 25.0);
        upperCaseButton.setLayoutX(170.0);
        upperCaseButton.setLayoutY(90.0);

        latinAlphabetButton = new Button("Latin Alphabet");
        latinAlphabetButton.setPrefSize(110.0, 25.0);
        latinAlphabetButton.setLayoutX(280.0);
        latinAlphabetButton.setLayoutY(90.0);

        userInputArea = new TextArea();
        userInputArea.setPromptText("Type Text Here");
        userInputArea.setPrefSize(275.0, 5.0);
        userInputArea.setLayoutX(60);
        userInputArea.setLayoutY(10.0);

        analysisResultLabel = new Label("Analysis Result");
        analysisResultLabel.setLayoutX(60.0);
        analysisResultLabel.setLayoutY(52.0);

        AnchorPane layout = new AnchorPane();
        layout.getChildren().addAll(lengthButton, vowelsButton, upperCaseButton, latinAlphabetButton, userInputArea, analysisResultLabel);

        Scene scene = new Scene(layout, 400, 125);
        primaryStage.setScene(scene);
        primaryStage.show();

        lengthButton.setOnAction(this);
        vowelsButton.setOnAction(this);
        upperCaseButton.setOnAction(this);
        latinAlphabetButton.setOnAction(this);
    }

    //event handler method
    public void handle(ActionEvent event){
        logic = new TextAnalyzer(userInputArea.getText()); //passes the user input string to the TextAnalyzer class

        //if the length button is clicked, it returns the results of the length method from TextAnalyzer class
        if(event.getSource() == lengthButton){
            analysisResultLabel.setText("The length of the text is " + logic.length());
        }

        //if the length button is clicked, it returns the results of the numberOfVowels method from TextAnalyzer class
        if(event.getSource() == vowelsButton){
            analysisResultLabel.setText("There are " + logic.numberOfVowels() + " vowels in the text.");
        }

        //if the length button is clicked, it returns the results of the numberOfUppercase method from TextAnalyzer class
        if(event.getSource() == upperCaseButton){
            analysisResultLabel.setText("There are " + logic.numberOfUppercase() + " uppercase letters in the text.");
        }

        //if the length button is clicked, it returns the results of the numberOfLatinAlphabetic method from TextAnalyzer class
        if(event.getSource() == latinAlphabetButton){
            analysisResultLabel.setText("There are " + logic.numberOfLatinAlphabetic() + " Latin Alphabetic letters.");
        }
    }
}
