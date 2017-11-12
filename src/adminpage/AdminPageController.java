/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpage;

import db.AdminDBUtils;
import entity.Admin;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import pckgcommon.Common;

/**
 * FXML Controller class
 *
 * @author Najus
 */
public class AdminPageController implements Initializable {

    @FXML
    private Button btnSave;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnClear;
    Admin admin;
    AdminDBUtils adminDBUtils;
    Common common;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPassword;
    @FXML
    private ComboBox<String> cmbSecurityQuestion;
    @FXML
    private TextField txtSecurityAnswer;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("What is your favorite food ?", "What is your Favorite Sports ?");
        cmbSecurityQuestion.setItems(list);
        // TODO
    }    

    @FXML
    private void handleButtonSaveAction(ActionEvent event) {
        admin = new Admin();
        adminDBUtils = new AdminDBUtils();
        String securityQuestion=cmbSecurityQuestion.getSelectionModel().getSelectedItem();

        admin.setName(txtName.getText());
        admin.setPassword(txtPassword.getText());
//        admin.setDob(txtDOB.getEditor().getText());  //converting calendar value to string and setting in student object
        admin.setSecurityQuestion(securityQuestion);
        admin.setSecurityAnswer(txtSecurityAnswer.getText());

        if (adminDBUtils.createAdmin(admin)) {
            System.out.println("Admin Created");
            clear();
//            common.alertMessage("INFORMATION", "Success", "Student Inserted", "Student Inserted into Database");
        }
        
    }

    @FXML
    private void handleButtonDeleteAction(ActionEvent event) {
    }

    @FXML
    private void handleButtonUpdateAction(ActionEvent event) {
    }

    @FXML
    private void handleButtonClearAction(ActionEvent event) {
        clear();
    }
    
    public void clear(){
      txtName.clear();
      
      //txtDOB.clear();
      txtPassword.clear();
      txtSecurityAnswer.clear();
      cmbSecurityQuestion.getSelectionModel().clearSelection();

    }
    
}
