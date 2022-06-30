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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MHAE
 */
public class InsertStudentController implements Initializable {

    @FXML
    private TextField ID;
    @FXML
    private TextField Name;
    @FXML
    private TextField Mid;
    @FXML
    private TextField Project;
    @FXML
    private TextField Final;
    @FXML
    private Button submit;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Submit(ActionEvent event) throws ClassNotFoundException, SQLException {
        String Id = ID.getText();
        String NAme = Name.getText();
        String mid = Mid.getText();
        String project = Project.getText();
        String fnal = Final.getText();
        DataBase x = new DataBase();
        x.Insert("course", Id, NAme, mid, project, fnal, fnal);
    }

}
