/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiotest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Zachary Hinote
 */
public class RadioTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField tfTextField = new TextField();
        TextField tfPrefColumnSize = new TextField();
        
        tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
        tfPrefColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
        
        tfTextField.setPrefColumnCount(13);
        tfPrefColumnSize.setPrefColumnCount(3);
        
        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(new Label("Text Field"), tfTextField);
        
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");
        
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbRight.setToggleGroup(group);
        
        
        HBox hBox2 = new HBox(5);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(rbLeft, rbCenter, rbRight);
        
        HBox hBox3 = new HBox(5);
        hBox3.getChildren().addAll(new Label("Column Size"), tfPrefColumnSize);
        
        HBox hBox4 = new HBox(15);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().addAll(hBox2, hBox3);
        
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox1, hBox4);
        
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Radio Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        tfPrefColumnSize.setOnAction(e -> {
            tfTextField.setPrefColumnCount(
                Integer.parseInt(tfPrefColumnSize.getText())
                );
        });
        
        rbLeft.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_LEFT));
        rbCenter.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_CENTER));
        rbRight.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_RIGHT));

        
    }   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
