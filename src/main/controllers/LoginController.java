
package main.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class LoginController implements Initializable {

    @FXML
    private TextField loginTF;
    @FXML
    private PasswordField passPF;
    @FXML
    private Label lblMessage;
   
 
    

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    

    @FXML
    private void autorization(MouseEvent event) {
       if(loginTF.getText().equals("test") && passPF.getText().equals("test")) {
           lblMessage.setText("Welcome, " + loginTF.getText()); 
       }           
       else {
           lblMessage.setText("Username or Password invalid");
           
       }
       String dbname = "Resto";
        String user = "ricam";
        String pass = "RE8sto13";
        String connectionUrl =
                "jdbc:sqlserver://192.168.1.86;"
                        + "database=Resto;"
                        + "user=ricam;"
                        + "password=RE8sto13;";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            Connection conn = DriverManager.getConnection(connectionUrl);
        if (!conn.isClosed()){
                System.out.println("Connected");
           }else{
                System.out.println("NotConnected");
                   }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
}
