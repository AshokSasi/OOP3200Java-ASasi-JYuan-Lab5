package ca.durhamcollege;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

        Label MyHeight = new Label ("My Height:");
        Label MyWeight = new Label ("My Weight:");

        //set up the path
        FileInputStream imagePath = new FileInputStream("src/ca/durhamcollege/bmiTable.PNG");
        //make the image
        Image bmiTable = new Image(imagePath);
        //make the imageview
        ImageView bmiTableView = new ImageView(bmiTable);
        bmiTableView.setFitWidth(200);
        bmiTableView.setPreserveRatio(true);

        HBox hbox =new HBox(10,bmiTableView);
        HBox heightLblBox = new HBox(10,MyHeight);
        HBox weightLblBox = new HBox(10,MyWeight);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.add(hbox,0,1);
        gridPane.add(heightLblBox,0,2);
        gridPane.add(weightLblBox,0,3);
        gridPane.setStyle("-fx-font-size: 20px; -fx-font-family: 'Consolas'; ");
        Scene scene = new Scene(gridPane, 640, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
