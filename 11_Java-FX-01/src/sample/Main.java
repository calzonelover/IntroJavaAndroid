package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;


import javafx.event.*;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Title");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        FlowPane myFlowPane = new FlowPane();
        myFlowPane.setAlignment(Pos.CENTER);
        myFlowPane.setOrientation(Orientation.VERTICAL);

        Scene myScene = new Scene(myFlowPane);

        Label myLabel = new Label("My information");
        TextArea myTextArea = new TextArea("Java is a piece of shit");
        Button myButton = new Button("OK");
        Button myButton2 = new Button("Cancel");
        RadioButton myRadioButton1 = new RadioButton("Radio 1");
        CheckBox myCheckBox1 = new CheckBox("check");

        myFlowPane.getChildren().addAll(myLabel, myTextArea, myButton, myButton2, myCheckBox1, myRadioButton1);

        // Event generator
        myButton.setOnAction(event -> {myTextArea.appendText("Button Action \n");});
        myButton2.setOnAction(event -> {myTextArea.appendText("Fuck");});

        primaryStage.setScene(myScene);

        /// Oldway
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
