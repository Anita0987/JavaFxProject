/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Najus
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static Connection databaseConnector()  {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaremanagementsystem","root","system");
            System.out.println("Connection Established");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}