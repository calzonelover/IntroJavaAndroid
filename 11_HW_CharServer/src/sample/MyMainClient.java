//package sample;

//public class MyMainClient {
//    public static void main(String[] args) throws Exception {
//        AppClient myAppClient = new AppClient();
//        myAppClient.CommunicateToServer();
//    }
//}

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

public class MyMainClient extends Application {

    private TextArea myReadArea = new TextArea();
    private TextArea myTextArea = new TextArea();

    private AppClient myAppClient;
    // linklist that store all the text
    private LinkedList<String> chatRoomText = new LinkedList<String>();

    @Override
    public void start(Stage primaryStage)throws Exception{
        myAppClient = new AppClient();

        primaryStage.setTitle("ClientChat");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        FlowPane myFlowPane = new FlowPane();
        myFlowPane.setAlignment(Pos.CENTER);
        myFlowPane.setOrientation(Orientation.VERTICAL);

        Scene myScene = new Scene(myFlowPane);

        Label myLabel = new Label("Chat room");

        myTextArea.setMaxSize(100,8);

        Button buttonSend = new Button("Send");
        buttonSend.setOnAction(event -> {myAppClient.sendServer(myTextArea.getText());
                                myTextArea.clear();});

        // thread for update message
        Thread threadUpdateMessage = new Thread(() -> {
            try{
                System.out.println("a");
            }catch (Exception e){System.out.println(e.getMessage());}
        });
        threadUpdateMessage.setDaemon(true);
        threadUpdateMessage.start();
        // end thread update message


        myFlowPane.getChildren().addAll(myLabel, myReadArea, myTextArea, buttonSend);
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


    public static void main(String[] args) {
        launch(args);
    }
}
