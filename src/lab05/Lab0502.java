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
 * github.com/QuentinProulx/Lab05
 * @author Quentin Proulx 6324569
 */
public class Lab0502 extends Application {
    double price = 0;
    double subPrice = 0;
    double tipGiven = 0;
    double tax = 0;
    
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
        double[] beveragePrices = {0, 2.50, 2.00, 1.75, 2.95, 1.5, 2.5};
        double[] appetizerPrices = {0, 4.50, 3.75, 5.25, 3.00, 6.95};    
        double[] mainCoursePrices = {0, 15.00, 13.50, 13.95, 11.90, 18.99, 11.75, 12.25};
        double[] dessertPrices = {0, 5.95, 4.50, 4.75, 3.25, 5.98};
        
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
        tip.setMinorTickCount(10);
        tip.setShowTickLabels(true);
        tip.setShowTickMarks(true);
        tip.setSnapToTicks(true);
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
        GridPane finalPrices = new GridPane();
        Label finalTax = new Label("Tax: $0.0");
        Label finalTip = new Label("Tip: $0.0");
        Label subTotal = new Label("Subtotal: $0.0");
        Label total = new Label("Total Price: $0.0");
        
        finalPrices.add(finalTax, 0, 0);
        finalPrices.add(finalTip, 0, 1);
        finalPrices.add(subTotal, 0, 2);
        finalPrices.add(total, 0, 3);
        
        finalPrices.setVgap(10);
        finalPrices.setAlignment(Pos.CENTER);
        
        for (Node node : finalPrices.getChildren()) {
            GridPane.setHalignment(node, HPos.CENTER);
        }
        
        Button calculate = new Button("Calculate");
        beverage.setOnAction(e -> {
            subPrice = beveragePrices[beverage.getSelectionModel().getSelectedIndex()]
                    + appetizerPrices[appetizer.getSelectionModel().getSelectedIndex()]
                    + mainCoursePrices[mainCourse.getSelectionModel().getSelectedIndex()]
                    + dessertPrices[dessert.getSelectionModel().getSelectedIndex()];
            update(subPrice, tip, finalTax, finalTip, subTotal, total);
        });
        appetizer.setOnAction(e -> {
            subPrice = beveragePrices[beverage.getSelectionModel().getSelectedIndex()]
                    + appetizerPrices[appetizer.getSelectionModel().getSelectedIndex()]
                    + mainCoursePrices[mainCourse.getSelectionModel().getSelectedIndex()]
                    + dessertPrices[dessert.getSelectionModel().getSelectedIndex()];
            update(subPrice, tip, finalTax, finalTip, subTotal, total);
        });
        mainCourse.setOnAction(e -> {
            subPrice = beveragePrices[beverage.getSelectionModel().getSelectedIndex()]
                    + appetizerPrices[appetizer.getSelectionModel().getSelectedIndex()]
                    + mainCoursePrices[mainCourse.getSelectionModel().getSelectedIndex()]
                    + dessertPrices[dessert.getSelectionModel().getSelectedIndex()];
            update(subPrice, tip, finalTax, finalTip, subTotal, total);
        });
        dessert.setOnAction(e -> {
            subPrice = beveragePrices[beverage.getSelectionModel().getSelectedIndex()]
                    + appetizerPrices[appetizer.getSelectionModel().getSelectedIndex()]
                    + mainCoursePrices[mainCourse.getSelectionModel().getSelectedIndex()]
                    + dessertPrices[dessert.getSelectionModel().getSelectedIndex()];
            update(subPrice, tip, finalTax, finalTip, subTotal, total);
        });
        tip.valueProperty().addListener((obs, oldVal, newVal) -> {
            subPrice = beveragePrices[beverage.getSelectionModel().getSelectedIndex()]
                    + appetizerPrices[appetizer.getSelectionModel().getSelectedIndex()]
                    + mainCoursePrices[mainCourse.getSelectionModel().getSelectedIndex()]
                    + dessertPrices[dessert.getSelectionModel().getSelectedIndex()];
            update(subPrice, tip, finalTax, finalTip, subTotal, total);
        });
        
        Button clear = new Button("Clear");
        clear.setOnMouseClicked(e -> {
            price = 0;
            total.setText("Total Price: $0.0");
            subTotal.setText("Subtotal: $0.0");
            finalTip.setText("Tip: $0.0");
            finalTax.setText("Tax: $0.0");
            tip.setValue(10);
            beverage.getSelectionModel().select(0);
            appetizer.getSelectionModel().select(0);
            mainCourse.getSelectionModel().select(0);
            dessert.getSelectionModel().select(0);
        });
        
        gridPane.add(clear, 0, 2);
        gridPane.add(finalPrices, 0, 3);
        
        for (Node node : gridPane.getChildren()) {
            GridPane.setHalignment(node, HPos.CENTER);
        }
        
        BorderPane root = new BorderPane(gridPane, null, null, null, null);
        Scene scene = new Scene(root, 600, 350);
        
        stage.setScene(scene);
        stage.setTitle("Restaurant Application");
        stage.setResizable(false);
        stage.show();
    }
    
    private void update(double subPrice, Slider tip, Label finalTax, Label finalTip, Label subTotal, Label total) {
            tax = subPrice * 0.14975;
            tipGiven = subPrice * (tip.getValue() / 100);
            price = subPrice + tipGiven + tax;
            
            finalTax.setText("Tax: $" + (double) (Math.round(tax * 100)) / 100);
            finalTip.setText("Tip: $" + (double) (Math.round(tipGiven * 100)) / 100);
            subTotal.setText("Subtotal: $" + (double) (Math.round(subPrice * 100)) / 100);
            total.setText("Total Price: $" + (double)(Math.round(price * 100)) / 100);
    }
}
