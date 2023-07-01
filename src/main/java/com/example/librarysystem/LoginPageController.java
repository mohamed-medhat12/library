package com.example.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPageController {

    @FXML
    private Label errormessage;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    private Stage stage;
    private Scene scene;

    @FXML
    void loginFun(ActionEvent event) throws IOException {
        String user = userName.getText();
        String pass = password.getText();

        if(CheckLibrarian(user) == true && CheckLibPass(pass) == true){
            Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (CheckAdmin(user) == true && CheckAdminPass(pass) == true) {
            Parent root = FXMLLoader.load(getClass().getResource("homeAdminPage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            errormessage.setText("User or password wrong");
        }
    }

    public Boolean CheckLibrarian (String email){
        boolean flag=false;
        Statement stmt = null;
        try {
            Connection conn =  connection.connect();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM librarian WHERE email like '"+email+"';");

            while ( rs.next() ) {
                String email_user = rs.getString("email");
                if(email_user==null)
                {
                    flag= false;
                } else
                {
                    flag= true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch ( SQLException e ) {
            System.out.println( e.getMessage() );

        }
        return flag;
    }

    public Boolean CheckAdmin (String email){
        boolean flag=false;
        Statement stmt = null;
        try {
            Connection conn =  connection.connect();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM admin WHERE email like '"+email+"';");

            while ( rs.next() ) {
                String email_user = rs.getString("email");
                if(email_user==null)
                {
                    flag= false;
                } else
                {
                    flag= true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch ( SQLException e ) {
            System.out.println( e.getMessage() );

        }
        return flag;
    }

    public Boolean CheckAdminPass (String pass){
        boolean flag=false;
        Statement stmt = null;
        try {
            Connection conn =  connection.connect();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM admin WHERE password like '"+pass+"';");

            while ( rs.next() ) {
                String email_user = rs.getString("email");
                if(email_user==null)
                {
                    flag= false;
                } else
                {
                    flag= true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch ( SQLException e ) {
            System.out.println( e.getMessage() );

        }
        return flag;
    }

    public Boolean CheckLibPass (String pass){
        boolean flag=false;
        Statement stmt = null;
        try {
            Connection conn =  connection.connect();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM librarian WHERE password like '"+pass+"';");

            while ( rs.next() ) {
                String email_user = rs.getString("email");
                if(email_user==null)
                {
                    flag= false;
                } else
                {
                    flag= true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch ( SQLException e ) {
            System.out.println( e.getMessage() );

        }
        return flag;
    }

}
