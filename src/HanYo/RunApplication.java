package HanYo;

import Database.mySQL_DBconnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class RunApplication extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        //connector
        Connection conn = mySQL_DBconnector.connect();



        Parent root = FXMLLoader.load(getClass().getResource("../GUI/GuiTil.fxml"));//Henter vores gui fra sample.fxml        primaryStage.setTitle("Panteren!");
        primaryStage.setTitle("Panteren!");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }
}
