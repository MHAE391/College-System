/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import DataBase.DataBase;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MHAE
 */
public class NewAdminController implements Initializable {

    @FXML
    private PasswordField Pass;
    @FXML
    private PasswordField CPass;
    @FXML
    private TextField Email;
    @FXML
    private TextField Lname;
    @FXML
    private TextField Fname;
    @FXML
    private TextField Id;
    @FXML
    private Button submit;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setVisible(false);
    }

    @FXML
    private void Submit(ActionEvent event) throws ClassNotFoundException, SQLException {
        String a, b, c, d, e, f;
        a = Pass.getText();
        b = CPass.getText();
        c = Email.getText();
        d = Fname.getText();
        e = Lname.getText();
        f = Id.getText();
        if (a.equals(b) == false ) {
           label.setVisible(true);
           label.setText("Passwod Doesn't Match the Confairm!!");
        }else {
            DataBase x=new DataBase();
            x.Insert(f,c,a,d+" "+e);
                   
        }
        
    }

}
