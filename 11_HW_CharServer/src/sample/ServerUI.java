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
import java.util.LinkedList;

public class ServerUI extends Application {

    private static TextArea myReadArea = new TextArea();
    private static TextArea myTextArea = new TextArea();

    private ListenerServer myListenerServer;
    // linklist that store all the text
    private LinkedList<String> chatRoomText = new LinkedList<String>();

    @Override
    public void start(Stage primaryStage)throws Exception{

        primaryStage.setTitle("Server Monitor");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        FlowPane myFlowPane = new FlowPane();
        myFlowPane.setAlignment(Pos.CENTER);
        myFlowPane.setOrientation(Orientation.VERTICAL);

        Scene myScene = new Scene(myFlowPane);

        Label myLabel = new Label("Chat room");

        myTextArea.setMaxSize(100,8);

        Button buttonSend = new Button("Send");

        // thread for update message
        Thread threadUpdateMessage = new Thread(() -> {
            try{
                System.out.println("a");
            }catch (Exception e){System.out.println(e.getMessage());}
        });
        threadUpdateMessage.setDaemon(true);
        threadUpdateMessage.start();
        // end thread update message


        myFlowPane.getChildren().addAll(myLabel, myReadArea, myTextArea);
        primaryStage.setScene(myScene);
        primaryStage.show();

    }

    public void AppendText(String newMessage){
        myReadArea.appendText(newMessage);
    }
    public String getTypedText(){
        return myTextArea.getText();
    }
    /// update message from server
//    public void updateMessage(){
//
//    }

    public static void initUI(){
        launch();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
