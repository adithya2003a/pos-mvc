/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;


import pos.mvc.module.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import pos.mvc.db.DBConnection;

/**
 *
 * @author ADITH
 */
public class CustomerController {
    
    public String saveCustomer(CustomerModel customerModel) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customerModel.getCustID());
        statement.setString(2, customerModel.getTitle());
        statement.setString(3, customerModel.getName());
        statement.setString(4, customerModel.getDob());
        statement.setDouble(5, customerModel.getSalary());
        statement.setString(6, customerModel.getAddress());
        statement.setString(7, customerModel.getCity());
        statement.setString(8, customerModel.getProvince());
        statement.setString(9, customerModel.getZip());
        
        if(statement.executeUpdate() > 0){
            return "Success";
        } else{
            return "Fail";
        }
    }
    
    public ArrayList<CustomerModel> getAllCustomer() throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM Customer";
        PreparedStatement statement = connection.prepareStatement(query);
        
        ArrayList<CustomerModel> customerModels = new ArrayList<>();
        
        ResultSet rst = statement.executeQuery();
        while (rst.next()) {            
            CustomerModel cm = new CustomerModel(rst.getString(1),
                    rst.getString(2), 
                    rst.getString(3), 
                    rst.getString(4), 
                    rst.getDouble(5),
                    rst.getString(6), 
                    rst.getString(7), 
                    rst.getString(8), 
                    rst.getString(9));
            
            customerModels.add(cm);
        }
        
        return customerModels;
    }
}
        
    

   
    


