/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab05;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

            // Creating the listview
        ListView<String> choices = new ListView<>();
        choices.setPrefWidth(300);
        choices.setPrefHeight(225);
        choices.getItems().addAll("Full Decorative", "Beaded", "Pirate Design", "Fringed", "Leather", "Plain");
        choices.getSelectionModel().select(0);
        
            // Creating the RadioButtons
        ToggleGroup sizes = new ToggleGroup();
        
        Label smallText = new Label("Small");
        Label mediumText = new Label("Medium");
        Label largeText = new Label("Large");
        
        RadioButton small = new RadioButton();
        small.setUserData("Small");
        
        RadioButton medium = new RadioButton();
        medium.setUserData("Medium");
        
        RadioButton large = new RadioButton();
        large.setUserData("Large");
        
        small.setToggleGroup(sizes);
        medium.setToggleGroup(sizes);
        large.setToggleGroup(sizes);
        
        sizes.selectToggle(small);
        
        GridPane buttons = new GridPane();
        buttons.add(smallText, 0, 0);
        buttons.add(mediumText, 1, 0);
        buttons.add(largeText, 2, 0);
        
        buttons.add(small, 0, 1);
        buttons.add(medium, 1, 1);
        buttons.add(large, 2, 1);
        
        buttons.setHgap(10);
        buttons.setVgap(5);
        buttons.setAlignment(Pos.CENTER);
        
        for (Node node : buttons.getChildren()) {
            GridPane.setHalignment(node, HPos.CENTER);
        }
        
            // Creating the rest of the objects
        
        Label select = new Label ("Select Quantity:");
        
        ComboBox<Integer> quantity = new ComboBox<>();
        quantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        quantity.setValue(1);
        
        Label result = new Label();
        Button order = new Button("Place Order");
        order.setOnMouseClicked(e -> {
            result.setText("You ordered " + quantity.getSelectionModel().getSelectedItem() + " " + sizes.getSelectedToggle().getUserData() + " " + choices.getSelectionModel().getSelectedItem() + " Bag(s).");
        });
        
        Button clear = new Button("Clear Selections");
        clear.setOnMouseClicked(e -> {
            sizes.selectToggle(small);
            quantity.getSelectionModel().select(0);
            choices.getSelectionModel().select(0);
        });
        
        GridPane gridPane = new GridPane();
        gridPane.add(label, 0, 0);
        gridPane.add(choices, 1, 0);
        gridPane.add(select, 2, 0);
        gridPane.add(quantity, 3, 0);
        
        gridPane.add(buttons, 1, 1);
        gridPane.add(order, 2, 1);
        gridPane.add(clear, 3, 1);
        
        gridPane.add(result, 1, 2);
        GridPane.setHalignment(result, HPos.CENTER);
        
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        
        BorderPane root = new BorderPane(gridPane);
        Scene scene = new Scene(root, 650, 400);
        
        gridPane.setTranslateX(20);
        gridPane.setTranslateY(20);
        
        stage.setScene(scene);
        stage.setTitle("Bag Order Form");
        stage.setResizable(false);
        stage.show();
    }
    
}
