package com.example.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddLibrarianPagController {

    @FXML
    private TextField email;

    @FXML
    private Label errorMassageButton;

    @FXML
    private TextField mobile;

    @FXML
    private TextField nationalID;

    @FXML
    private TextField password;

    @FXML
    private TextField userName;

    @FXML
    void addButton(ActionEvent event) {
        String name = userName.getText();
        String em = email.getText();
        String mobileNum = mobile.getText();
        String pass = password.getText();
        String national = nationalID.getText();
        if(national.length() != 14) {
            errorMassageButton.setText("please enter a correct national ID");
        }else if(name != null && em != null  && mobileNum != null && pass != null){
            Librarian l2 = new Librarian(name,em,mobileNum,national,pass);
            l2.add();
            errorMassageButton.setText(l2.massage);
            errorMassageButton.setTextFill(Color.GREEN);
            remove();
        }else {
            errorMassageButton.setTextFill(Color.RED);
            errorMassageButton.setText("Missing data!!!");
            remove();
        }
    }

    public void remove(){
        userName.setText(null);
        email.setText(null);
        mobile.setText(null);
        password.setText(null);
        nationalID.setText(null);
    }

}
