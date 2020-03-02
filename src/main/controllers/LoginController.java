
package main.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Main;


public class LoginController implements Initializable {

    @FXML
    private TextField loginTF;
    @FXML
    private PasswordField passPF;
    @FXML
    private Label lblMessage;
    @FXML
    private Button loginButton;
   
 
    

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void autorization(MouseEvent event) {
       
       String dbname = "Resto";
        String user = "";
        String pass = "";
        user = loginTF.getText();
        pass = passPF.getText();
        String connectionUrl =
                "jdbc:sqlserver://192.168.1.86;"
                        + "database=Resto;"
                        + "user="+user+";"
                        + "password="+pass+";";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            Connection conn = DriverManager.getConnection(connectionUrl);
        if (!conn.isClosed()){
                System.out.println("Connected");
                Main.switchScene("app");
           }else{
                System.out.println("NotConnected");
                   }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    // do what you have to do
//    stage.close();
   
    
   }
    
    
    
}
