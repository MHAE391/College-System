/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import DataBase.DataBase;
import com.sun.javaws.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;

//import DataBase.DataBase;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
/**
 *
 * @author MHAE
 */
public class LoginControl implements Initializable {

    @FXML
    private Button Log;
    @FXML
    private Label Wrong;
    @FXML
    public TextField UserName;
    @FXML
    private PasswordField Password;

    public void UserLog(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        Check();
    }

    private void Check() throws IOException, SQLException, ClassNotFoundException {
        College c=new College();
        String Id = UserName.getText();
        String Pass = Password.getText();
        DataBase DB=new DataBase();
        if (UserName.getText().isEmpty() || Password.getText().isEmpty() ) {
            Wrong.setText("Please Enter Your Data!!");
        }
        else if(DB.Login(Id, Pass)=="Admin"){
             Wrong.setText("Connected");
             c.changeScene("Home.fxml",800,700);
             
         }else {
             Wrong.setText("Wrong Password or Id!!");
         }
       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
