/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxapp.TableModel;
import main.DBConnection;

public class SalesController implements Initializable {

    @FXML
    private Label lblMessage;
    private TableView<TableModel> table;
    @FXML
    private TableColumn<TableModel, String> col_id;
    @FXML
    private TableColumn<TableModel, String> col_name;
    @FXML
    private TableColumn<TableModel, String> col_date;
    @FXML
    private TableColumn<TableModel, String> col_DS;
    @FXML
    private DatePicker dateSelection;
    @FXML
    private DatePicker toDP;
    
    ObservableList<TableModel> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//         String SQL = "SELECT p.dishinfo AS id, p.dishDiscountSum AS saleSum, CAST(p.date AS Date) AS date, "
//                    + "CAST(e.xml AS XML).value('(/r/name/customValue)[1]', 'varchar(50)') AS name "
//                    + "FROM ItemSaleEvent AS p "
//                    + "INNER JOIN entity e ON e.id = p.dishInfo "
//                    + "and date >= '"+dateSelection+"' and date <='"+toDP+"'"
        try {
            Connection conn = DBConnection.getConnection();

            String SQL = "SELECT p.dishinfo AS id, p.dishDiscountSum AS saleSum, CAST(p.date AS Date) AS date, "
                    + "CAST(e.xml AS XML).value('(/r/name/customValue)[1]', 'varchar(50)') AS name "
                    + "FROM ItemSaleEvent AS p "
                    + "INNER JOIN entity e ON e.id = p.dishInfo "
                    + "and date >= '" + dateSelection.getValue() + "' and date <='" + toDP.getValue() + "'";
            
            
            ResultSet rs = conn.createStatement().executeQuery(SQL);

                while (rs.next()) {
                oblist.add(new TableModel(rs.getString("id"), rs.getString("name"), rs.getString("date"), rs.getString("DS")));
            }


        } catch (SQLException ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_DS.setCellValueFactory(new PropertyValueFactory<>("DS"));
        
        table.setItems(oblist);

    }

}
