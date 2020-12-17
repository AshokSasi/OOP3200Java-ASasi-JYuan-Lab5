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
        primaryStage.setTitle("Java Lab 5");

        Label MyHeight = new Label ("My Height(Inches):");
        Label MyWeight = new Label ("My Weight(Pounds):");
        Label lblBMI = new Label ("BMI: ");
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
        bmiTableView.setFitWidth(200);
        bmiTableView.setPreserveRatio(true);

        class ButtonClickerHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                double weight=0.0;
                double height=0.0;
                double BMI=0.0;
                try {
                    weight = Integer.parseInt(txtWeight.getText());
                    height = Integer.parseInt(txtHeight.getText());
                    BMI = (weight*703)/(height*height);
                    outputBMI.setText(Double.toString(BMI));
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Error: " + e + " Weight and height must be numeric.");
                }


            }
        }
        calculate.setOnAction(new ButtonClickerHandler());

        HBox hbox =new HBox(10,bmiTableView);
        HBox heightLblBox = new HBox(10,MyHeight);
        HBox weightLblBox = new HBox(10,MyWeight);
        HBox buttonBox = new HBox(10,calculate);
        HBox heightEntry = new HBox(10,txtHeight);
        HBox weightEntry = new HBox(10,txtWeight);
        HBox outputBox = new HBox(10,lblBMI);
        HBox BMIBox = new HBox(10,outputBMI);
        BMIBox.setStyle("-fx-border-color: #000000; -fx-alignment: center; ");
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
        gridPane.setStyle("-fx-font-size: 20px; -fx-font-family: 'Consolas'; ");
        Scene scene = new Scene(gridPane, 640, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
