package ca.durhamcollege;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Java Lab 5");

        //set up the path
        FileInputStream imagePath = new FileInputStream("src/ca/durhamcollege/bmiTable.PNG");
        //make the image
        Image bmiTable = new Image(imagePath);
        //make the imageview
        ImageView bmiTableView = new ImageView(bmiTable);
        bmiTableView.setFitWidth(200);
        bmiTableView.setPreserveRatio(true);

        HBox hbox =new HBox(10,bmiTableView);

        GridPane gridPane = new GridPane();
        gridPane.add(hbox,0,1);
        Scene scene = new Scene(gridPane, 640, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
