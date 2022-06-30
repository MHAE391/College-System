/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import DataBase.DataBase;
import java.sql.SQLException;
/**
 * FXML Controller class
 *
 * @author MHAE
 */
public class InsertCourseController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField phone;
    @FXML
    private TextField clss;
    @FXML
    private Button submit;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String Id=id.getText();
        String FName=fname.getText();
        String Lname=lname.getText();
        String Phone=phone.getText();
        String Class=clss.getText();
        String GPA="4";
        System.out.println(Id + FName+Lname+Phone+Class);
    }    

    @FXML
    private void Submit(ActionEvent event) throws SQLException, ClassNotFoundException {
        String Id=id.getText();
        String FName=fname.getText();
        String Lname=lname.getText();
        String Phone=phone.getText();
        String Class=clss.getText();
        String GPA="4";
        DataBase x=new DataBase();
        x.Insert("student",Id, FName, Lname, Phone, Class, GPA);
    }
    
}
