package edu.guilford;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Clothes> clothes = new ArrayList<Clothes>();
        
        // Instantiate at least three objects of each subclass with different values for the attributes
        clothes.add(new Shirt("Red", 6, "Cotton"));
        clothes.add(new Shirt("Blue", 8, "Polyester"));
        clothes.add(new Shirt("Green", 8, "Silk"));
        
        clothes.add(new Jacket("Black", 14, "Leather"));
        clothes.add(new Jacket("Brown", 16, "Denim"));
        clothes.add(new Jacket("Gray", 18, "Wool"));
        
        clothes.add(new Shorts("Yellow", 6, "Denim"));
        clothes.add(new Shorts("Orange", 8, "Cotton"));
        clothes.add(new Shorts("Purple", 10, "Linen"));
        
        clothes.add(new Pants("White", 12, "Jeans"));
        clothes.add(new Pants("Pink", 14, "Leggings"));
        clothes.add(new Pants("Beige", 16, "Cargo"));
        
        // Create labels to display the results
        Label washLabel = new Label("Washing:");
        Label wearLabel = new Label("Wearing:");
        Label sortedLabel = new Label("Sorted by size:");
        Label resultLabel = new Label();
        
        // Demonstrate the use of one inherited method by objects of each subclass
        for (Clothes c : clothes) {
            c.wash();
            washLabel.setText(washLabel.getText() + "\n" + c.getType() + " - " + c.getColor() + " - " + c.getSize());
        }
        
        // Demonstrate the use of one abstract method by objects of each subclass
        for (Clothes c : clothes) {
            c.wear();
            wearLabel.setText(wearLabel.getText() + "\n" + c.getType() + " - " + c.getColor() + " - " + c.getSize() + " - " + ((Wearable)c).getMaterial());
        }
        
        // Show that the Comparable interface has been implemented correctly by using compareTo to order the objects of each subclass
        Collections.sort(clothes);
        for (Clothes c : clothes) {
            sortedLabel.setText(sortedLabel.getText() + "\n" + c.getType() + " - " + c.getSize());
        }
        
        // Create a VBox to hold the labels
        VBox vbox = new VBox(washLabel, wearLabel, sortedLabel, resultLabel);
        
        // Create a Scene and add the VBox to it
        Scene scene = new Scene(vbox, 400, 400);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        for (Clothes c : clothes) {
            String output = c.wear();
            System.out.println(output);
            saveOutputToFile(output);
        }

        System.out.println("Outputs saved to output.txt");
    }

    private static void saveOutputToFile(String output) {
        try {
            FileWriter writer = new FileWriter("output.txt", true);
            writer.write(output + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}

