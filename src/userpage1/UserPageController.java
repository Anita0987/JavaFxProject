/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userpage1;

import db.StudentDBUtils;
import entity.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pckgcommon.Common;

/**
 * FXML Controller class
 *
 * @author Najus
 */
public class UserPageController implements Initializable {
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtUsername;
     @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtContactNo;
    @FXML
    private TextField txtFee;
    @FXML
    private TextField txtRoll;
    @FXML
    private DatePicker dateDOB;

    Student student;
    StudentDBUtils studentDBUtils;
    Common common;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
         student = new Student();
        studentDBUtils = new StudentDBUtils();

        student.setName(txtName.getText());
        student.setUsername(txtUsername.getText());
        student.setPassword(txtPassword.getText());
        student.setRoll(Integer.parseInt(txtRoll.getText()));
        student.setContactno(Integer.parseInt(txtContactNo.getText()));
       // student.setDob(dateDOB.getEditor().getText());
       student.setFee(Integer.parseInt(txtFee.getText()));
       
        
//        admin.setDob(txtDOB.getEditor().getText());  //converting calendar value to string and setting in student object
        

        if (studentDBUtils.createStudent(student)) {
            System.out.println("Admin Created");
            clear();
            //common.alertMessage("INFORMATION", "Success", "Student Inserted", "Student Inserted into Database");
        }
        
    }

    @FXML
    private void handleUpdateButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleDeleteButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
    }
     public void clear(){
      txtName.clear();
      
      //txtDOB.clear();
      txtPassword.clear();
      txtUsername.clear();
      txtContactNo.clear();
      txtFee.clear();
      txtRoll.clear();
      //dateDOB.clearSelection();

    }
    
}
