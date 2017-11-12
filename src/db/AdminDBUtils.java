/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Admin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDBUtils {

    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection connection = DatabaseConnector.databaseConnector();

    public boolean createAdmin(Admin admin) {
        if (connection != null) {
            String query = "INSERT INTO  Admin (Name, Password,SecurityQuestion,SecurityAnswer) VALUES (?,?,?,?)";
            try {

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, admin.getName());
                preparedStatement.setString(2, admin.getPassword());
                preparedStatement.setString(3, admin.getSecurityQuestion());
                preparedStatement.setString(4, admin.getSecurityAnswer());  

                preparedStatement.execute();
                connection.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

//    public void fetchData() {
//        try {
//            String query = "SELECT * FROM Student";
//            preparedStatement = connection.prepareStatement(query);
//
//            resultSet = preparedStatement.executeQuery(query);
//            while (resultSet.next()) {
//                System.out.println("ID : " + resultSet.getInt("Id"));
//                System.out.println("NAME : " + resultSet.getString("Name"));
//                System.out.println("Username :"+resultSet.getString("Username"));
//                System.out.println("Password :"+resultSet.getString("Password"));
//                System.out.println("Roll  : " + resultSet.getInt("Roll"));
//                System.out.println("ContactNo :"+resultSet.getInt("ContactNo"));
//                System.out.println("Date of birth :"+resultSet.getDate("DOB"));
//                System.out.println("Fee :"+resultSet.getInt("Fee"));
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

//    public void fetchById(int id) {
//        try {
//            if (connection != null) {
//                String query = "SELECT * FROM Student Where Id=?";
//                preparedStatement = connection.prepareStatement(query);
//                preparedStatement.setInt(1, id);
//
//                resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                     
//                    System.out.println("ID : " + resultSet.getInt("Id"));
//                System.out.println("NAME : " + resultSet.getString("Name"));
//                System.out.println("Username :"+resultSet.getString("Username"));
//                System.out.println("Password :"+resultSet.getString("Password"));
//                System.out.println("Roll  : " + resultSet.getInt("Roll"));
//                System.out.println("ContactNo :"+resultSet.getInt("ContactNo"));
//                System.out.println("Date of birth :"+resultSet.getDate("DOB"));
//                System.out.println("Fee :"+resultSet.getInt("Fee"));
//                    
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//    public boolean updateData(Student student) {
//        if (connection != null) {
//            String query = "UPDATE Student Set Name=?, Username=?, Password=?, Roll=?, ContactNo=?,DOB=?,Fee=? where Id = ?";
//            try {
//
//                preparedStatement = connection.prepareStatement(query);
//                  
//                preparedStatement.setString(1, student.getName());
//                preparedStatement.setString(2, student.getUsername());
//                preparedStatement.setString(3, student.getPassword());
//                preparedStatement.setInt(4, student.getRoll());
//                preparedStatement.setInt(5,student.getContactno());
//                preparedStatement.setDate(6, (Date) student.getDob());
//                preparedStatement.setInt(7,student.getFee()); 
//                preparedStatement.executeUpdate();
//                connection.close();
//                return true;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//    public Boolean loginValidation(String username, String password) {
//        if(connection!=null){
//            try {
//                
//                String query= "SELECT * FROM Student Where Username=? AND Password=? ";
//                preparedStatement=connection.prepareStatement(query);
//                preparedStatement.setString(1, username);
//                preparedStatement.setString(2, password);
//                resultSet = preparedStatement.executeQuery();
//                
//                while(resultSet.next()){
//                    return true;
//                }
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(StudentDBUtils.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
//        return false;
//        
//    }
     public Boolean loginValidation(String username, String password) {
        if(connection!=null){
            try {
                
                String query= "SELECT * FROM Admin Where Username=? AND Password=? ";
                preparedStatement=connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                
                while(resultSet.next()){
                    return true;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return false;
        
    }
}