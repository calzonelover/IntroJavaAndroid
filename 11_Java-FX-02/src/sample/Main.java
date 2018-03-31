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

        primaryStage.setTitle("Chat");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        FlowPane myFlowPane = new FlowPane();
        myFlowPane.setAlignment(Pos.CENTER);
        myFlowPane.setOrientation(Orientation.VERTICAL);

        Scene myScene = new Scene(myFlowPane);

        Label myLabel1 = new Label("Person 1");
        Label myLabel2 = new Label("Person 2");

        TextArea myReadArea1 = new TextArea();
        TextArea myTextArea1 = new TextArea();
        myTextArea1.setMaxSize(100,8);
        TextArea myReadArea2 = new TextArea();
        TextArea myTextArea2 = new TextArea();
        myTextArea2.setMaxSize(100,8);

        Button myButton1 = new Button("Send");
        myButton1.setOnAction(event -> {myReadArea2.appendText(myLabel1.getText()+" : "+myTextArea1.getText()+"\n");});
        Button myButton2 = new Button("Send");
        myButton2.setOnAction(event -> {myReadArea1.appendText(myLabel2.getText()+" : "+myTextArea2.getText()+"\n");});

        myFlowPane.getChildren().addAll(myLabel1, myReadArea1, myTextArea1, myButton1,
                myLabel2, myReadArea2, myTextArea2, myButton2);

        primaryStage.setScene(myScene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
