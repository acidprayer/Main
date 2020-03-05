/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

/**
 *
 * @author Ivan
 */
public class TableModel {
    
    String id, name, date, DS;

    public TableModel(String id, String name, String date, String DS) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.DS = DS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDS() {
        return DS;
    }

    public void setDS(String DS) {
        this.DS = DS;
    }
    
    
}
