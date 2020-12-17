/*
Name: Ashok Sasitharan 100745484, Jacky Yuan 100520106
Date: December 17 2020
OOP3200 Java Lab 5
Changes:N/A
 */
package ca.durhamcollege;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("BMI Calculator");

        // CONTROLS
        Label MyHeight = new Label ("My Height(Inches):");
        Label MyWeight = new Label ("My Weight(Pounds):");
        Label lblBMI = new Label ("BMI: ");
        Label errorLbl = new Label ("");
        Label outputBMI = new Label ("");
        TextField txtHeight = new TextField();
        TextField txtWeight = new TextField();
        Button calculate = new Button("Calculate BMI");

        //set up the path
        FileInputStream imagePath = new FileInputStream("src/ca/durhamcollege/bmiTable.PNG");
        //make the image
        Image bmiTable = new Image(imagePath);
        //make the imageview
        ImageView bmiTableView = new ImageView(bmiTable);
        bmiTableView.setFitWidth(250);
        bmiTableView.setPreserveRatio(true);

        //button click event that calculates BMI
        class ButtonClickerHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                double weight=0.0;
                double height=0.0;
                double BMI=0.0;
                try
                {
                    //parses the entries to see if they are numeric
                    weight = Double.parseDouble(txtWeight.getText());
                    height = Double.parseDouble(txtHeight.getText());

                    //Calculates the BMI with imperial units
                    BMI = Math.round((weight*703)/(height*height)*100.0)/100.0;

                    //output the BMI and clear the error label
                    outputBMI.setText(Double.toString(BMI));
                    errorLbl.setText("");
                }
                catch (NumberFormatException e)
                {
                    //Outputs error message in error label and clears inputs.
                   errorLbl.setText("Error: Weight and height must be numeric.");
                   txtHeight.setText("");
                   txtWeight.setText("");
                   outputBMI.setText("");
                }


            }
        }
        calculate.setOnAction(new ButtonClickerHandler());

        //HBOX DECLARATIONS
        HBox hbox =new HBox(10,bmiTableView);
        HBox heightLblBox = new HBox(10,MyHeight);
        HBox weightLblBox = new HBox(10,MyWeight);
        HBox buttonBox = new HBox(10,calculate);
        HBox heightEntry = new HBox(10,txtHeight);
        HBox weightEntry = new HBox(10,txtWeight);
        HBox outputBox = new HBox(10,lblBMI);
        HBox BMIBox = new HBox(10,outputBMI);
        HBox errorBox = new HBox(10,errorLbl);

        BMIBox.setStyle("-fx-border-color: #000000; -fx-alignment: center; ");

        //Populates GridPane with the HBox objects
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.add(hbox,0,0);
        gridPane.add(heightLblBox,0,1);
        gridPane.add(weightLblBox,0,2);
        gridPane.add(heightEntry,1,1);
        gridPane.add(weightEntry,1,2);
        gridPane.add(buttonBox,0,4);
        gridPane.add(outputBox,0,3);
        gridPane.add(BMIBox,1,3);
        gridPane.add(errorBox,0,5,3,1);
        //formats the grid pane to set the font size to 20
        gridPane.setStyle("-fx-font-size: 20px; -fx-font-family: 'Consolas'; -fx-cell-size: 60px;");

        Scene scene = new Scene(gridPane, 640, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
