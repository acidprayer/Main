
package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
//    ///////
//    @Override
//            public void start (Stage stage) throws Exception {
//    Parent root = FXMLLoader.load(getClass()).getResourse(""));
//    

          
    public static void main(String[] args) {
     launch(args);
 
        
    } 

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("login");
        stage.show();
               
    }
    
}
