/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab05;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author quent
 */
public class Lab0502 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(20);
        gridPane.setTranslateY(20);
        
            // Creating the menu
        Label beverageLabel = new Label("Beverages");
        Label appetizerLabel = new Label("Appetizers");
        Label mainCourseLabel = new Label("Main Course");
        Label dessertLabel = new Label("Desserts");    
        
        ComboBox<String> beverage = new ComboBox<>();
        beverage.getItems().addAll("None Selected", "Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice");
        beverage.getSelectionModel().select(0);
        
        ComboBox<String> appetizer = new ComboBox<>();
        appetizer.getItems().addAll("None Selected", "Soup", "Salad", "Spring Rolls", "Garlic Bread", "Chips and Salsa");
        appetizer.getSelectionModel().select(0);
        
        ComboBox<String> mainCourse = new ComboBox<>();
        mainCourse.getItems().addAll("None Selected", "Steak", "Grilled Chicken", "Chicken Alfredo", "Turkey Club", "Shrimp Scampi", "Pasta", "Fish and Chips");
        mainCourse.getSelectionModel().select(0);
        
        ComboBox<String> dessert = new ComboBox<>();
        dessert.getItems().addAll("None Selected", "Apple Pie", "Carrot Cake", "Mud Pie", "Pudding", "Apple Crisp");
        dessert.getSelectionModel().select(0);
        
        GridPane menu = new GridPane();
        menu.add(beverageLabel, 0, 0);
        menu.add(appetizerLabel, 1, 0);
        menu.add(mainCourseLabel, 2, 0);
        menu.add(dessertLabel, 3, 0);
        
        menu.add(beverage, 0, 1);
        menu.add(appetizer, 1, 1);
        menu.add(mainCourse, 2, 1);
        menu.add(dessert, 3, 1);
        
        menu.setHgap(10);
        menu.setVgap(10);
        menu.setAlignment(Pos.CENTER);
        
        for (Node node : menu.getChildren()) {
            GridPane.setHalignment(node, HPos.CENTER);
        }
        
        gridPane.add(menu, 0, 0);
        
            // Creating the tip slider
        Label tipLabel = new Label("Leave a Tip");
        
        Slider tip = new Slider(0, 20, 10);
        tip.setMajorTickUnit(5);
        tip.setMinorTickCount(20);
        tip.setShowTickLabels(true);
        tip.setShowTickMarks(true);
        tip.setPrefWidth(400);
        
        gridPane.add(tipLabel, 0, 1);
        gridPane.add(tip, 0, 2);
        
        GridPane tips = new GridPane();
        tips.add(tipLabel, 0, 0);
        tips.add(tip, 0, 1);
        
        tips.setHgap(10);
        tips.setVgap(10);
        tips.setAlignment(Pos.CENTER);
        
        for (Node node : tips.getChildren()) {
            GridPane.setHalignment(node, HPos.CENTER);
        }
        
        gridPane.add(tips, 0, 1);
        
            // Creating buttons
        Button calculate = new Button("Calculate");
        
        
        Button clear = new Button("Clear");
        clear.setOnMouseClicked(e -> {
            tip.setValue(10);
            beverage.getSelectionModel().select(0);
            appetizer.getSelectionModel().select(0);
            mainCourse.getSelectionModel().select(0);
            dessert.getSelectionModel().select(0);
        });
        
        Label total = new Label("Total Price: $0");
        
        GridPane buttons = new GridPane();
        buttons.add(calculate, 0, 0);
        buttons.add(clear, 1, 0);
        
        buttons.setAlignment(Pos.CENTER);
        buttons.setHgap(10);
        buttons.setVgap(10);
        
        gridPane.add(buttons, 0, 2);
        gridPane.add(total, 0, 3);
        
        for (Node node : gridPane.getChildren()) {
            GridPane.setHalignment(node, HPos.CENTER);
        }
        
        BorderPane root = new BorderPane(gridPane, null, null, null, null);
        Scene scene = new Scene(root, 600, 500);
        
        stage.setScene(scene);
        stage.setTitle("Restaurant Application");
        stage.setResizable(false);
        stage.show();
    }
    
}
