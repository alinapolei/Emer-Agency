package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.* ;

import java.io.IOException;

public class Main extends Application {


    public static User loggedUser;
    public static int EventId ;   //for show in addNotification sence
    private static Stage stage;


    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/LoginForm.fxml"));
        primaryStage.setTitle("Emer-Agency");
        primaryStage.setScene(new Scene(root, 550 , 300));
        stage = primaryStage;
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        //Query q = new Query();
        //q.search();
    }



    public static void switchScene(String fxmlFile, Stage stage, int width, int height) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(fxmlFile));
        Parent root;
        try {
            root = loader.load();
            loader.getController();
            Scene scene = new Scene(root, width, height);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.centerOnScreen();
        //stage.getScene().getStylesheets().add(Main.class.getResource("../View/Style.css").toExternalForm());

    }

}