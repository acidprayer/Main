/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class SalesController implements Initializable {

    @FXML
    private Label lblMessage;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> dish;
    @FXML
    private DatePicker dateSelection;
    @FXML
    private DatePicker toDP;
    String SQL = "SELECT p.dishinfo AS id, p.dishDiscountSum AS saleSum, CAST(p.date AS Date) AS date, "
                    + "CAST(e.xml AS XML).value('(/r/name/customValue)[1]', 'varchar(50)') AS name "
                    + "FROM ItemSaleEvent AS p "
                    + "INNER JOIN entity e ON e.id = p.dishInfo "
                    + "and date >= '"+dateSelection+"' and date <='"+toDP+"'";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
