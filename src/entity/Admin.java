/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Najus
 */
public class Admin {
    private int id;
    private String name;
    private String password;
    private String securityQuestion;

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public Admin(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }
    private String securityAnswer;

    public Admin(int id, String name, String password, String securityAnswer) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.securityAnswer = securityAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
    
    
public Admin(){
    
}

  
}
