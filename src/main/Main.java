
package main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
//    ///////
//    @Override
//            public void start (Stage stage) throws Exception {
//    Parent root = FXMLLoader.load(getClass()).getResourse(""));
//    
    private static Stage stage;
   //stage = anchorpane со всеми
    //static = 
          
    public static void main(String[] args)  {
     launch(args);
       
        
    } 

    @Override
    public void start(Stage stage)  throws Exception {
        this.stage = stage;
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("login");
        stage.show();
    }   
   
//             AnchorPane panee;
//        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("fxml/app.fxml"));
//        Scene scenee = new Scene(pane);
//        stage.setScene(scenee);
//        stage.setTitle("logine"); 
//        stage.show();
     public static void switchScene(String location){   
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(Main.class.getResource("fxml/"+location+".fxml"));
            stage.setTitle("table");
            stage.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
