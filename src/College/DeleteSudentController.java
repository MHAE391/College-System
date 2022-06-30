/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import DataBase.DataBase;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.persistence.Id;

/**
 * FXML Controller class
 *
 * @author MHAE
 */
public class DeleteSudentController implements Initializable {

    @FXML
    private Label Sclass;
    @FXML
    private Label Sphone;
    @FXML
    private Label SName;
    @FXML
    private Label Sgpa;
    @FXML
    private Label NameR;
    @FXML
    private Label GpaR;
    @FXML
    private Label ClassR;
    @FXML
    private Label PhoneR;
    @FXML
    private Label Wrong;
    @FXML
    private Button search;
    @FXML
    private Button delete;
    @FXML
    private TextField Id;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Sclass.setVisible(false);
        Sphone.setVisible(false);
        SName.setVisible(false);
        Sgpa.setVisible(false);
        ClassR.setVisible(false);
        Wrong.setVisible(false);
        NameR.setVisible(false);
        PhoneR.setVisible(false);
        GpaR.setVisible(false);
        delete.setVisible(false);
    }    

    @FXML
    private void Search(ActionEvent event) throws ClassNotFoundException, SQLException {
        String ID = Id.getText();
        DataBase x = new DataBase();
        ResultSet RES = x.Search(ID, "student");
      
       String a = null,b = null,c = null,d = null,e = null; 
        while (RES.next()) {
             a = RES.getString("fname");
             b = RES.getString("lName");
             c = RES.getString("stdPhone");
             d = RES.getString("class");
             e = RES.getString("gpa");
            }
        if(a==null){
             Wrong.setVisible(true);
            Wrong.setText("No Data Avilable !!");
            Sclass.setVisible(false);
        Sphone.setVisible(false);
        SName.setVisible(false);
        Sgpa.setVisible(false);
        ClassR.setVisible(false);
       // Wrong.setVisible(false);
        NameR.setVisible(false);
        PhoneR.setVisible(false);
        GpaR.setVisible(false);
        delete.setVisible(false);
        }else {
        Sclass.setVisible(true);
        Sphone.setVisible(true);
        SName.setVisible(true);
        Sgpa.setVisible(true);
        ClassR.setVisible(true);
        Wrong.setVisible(false);
        NameR.setVisible(true);
        PhoneR.setVisible(true);
        GpaR.setVisible(true);
        ClassR.setText(d);
        NameR.setText(a+" "+b);
        PhoneR.setText(c);
        GpaR.setText(e);
        delete.setVisible(true);
       }
        
    }

    @FXML
    private void Delete(ActionEvent event) throws ClassNotFoundException, SQLException {
        DataBase x=new DataBase();
        x.Delete("student", Id.getText());
    }
    
}
    