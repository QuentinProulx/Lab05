/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab05;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author 6324569
 */
public class Lab05 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label label = new Label("Select Bag Style: ");

        ListView choices = new ListView();
        choices.setPrefWidth(100);
        choices.setPrefHeight(200);
        
        GridPane gridPane = new GridPane();
        gridPane.add(label, 0, 0);
        gridPane.add(choices, 1, 0);
        
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
        BorderPane root = new BorderPane(gridPane);
        Scene scene = new Scene(root, 500, 500);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
}
