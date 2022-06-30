/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import DataBase.DataBase;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import java.sql.SQLException;
import org.eclipse.persistence.internal.sessions.factories.XMLSessionConfigProject;
/**
 * FXML Controller class
 *
 * @author MHAE
 */
public class ChangePasswordController implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private PasswordField OPass;
    @FXML
    private PasswordField NPass;
    @FXML
    private PasswordField CPass;
    @FXML
    private Label lable;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lable.setVisible(false);
    }    

    @FXML
    private void Submit(ActionEvent event) throws ClassNotFoundException, SQLException {
        DataBase x=new DataBase();
        String pass=x.GetPass(DataBase.ID);
        System.out.println(pass);
        String a=OPass.getText(),b=NPass.getText(),c=CPass.getText();
        System.out.println(a);
        if(a.equals(pass)==false){
            lable.setText("Wrong Old Password !!");
            lable.setVisible(true);
        }else {
            if(b.equals(c)==false){
                 lable.setText("New Password and Confirm Password Doesn't match!!!!");
                 lable.setVisible(true);
            }else {
                x.Update(b,DataBase.ID);
                lable.setText("Chanched !!");
                lable.setVisible(true);
            }
        }
        
    }
    
}
