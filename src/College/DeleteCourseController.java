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

/**
 * FXML Controller class
 *
 * @author MHAE
 */
public class DeleteCourseController implements Initializable {

    @FXML
    private TextField Id;
    @FXML
    private Label CFinal;
    @FXML
    private Label Cmid;
    @FXML
    private Label SName;
    @FXML
    private Label Cproject;
    @FXML
    private Button search;
    @FXML
    private Label NameR;
    @FXML
    private Label Project;
    @FXML
    private Label Final;
    @FXML
    private Label Mid;
    @FXML
    private Label Wrong;
    @FXML
    private Label Ctotal;
    @FXML
    private Label Total;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         CFinal.setVisible(false);
        Cmid.setVisible(false);
        NameR.setVisible(false);
        SName.setVisible(false);
        Cproject.setVisible(false);
        Wrong.setVisible(false);
        Ctotal.setVisible(false);
        Total.setVisible(false);
        Mid.setVisible(false);
        Final.setVisible(false);
        Project.setVisible(false);
        delete.setVisible(false);

    }    

    @FXML
    private void Search(ActionEvent event) throws ClassNotFoundException, SQLException {
          String ID = Id.getText();
        DataBase x = new DataBase();
        ResultSet RES = x.Search(ID, "course");

        String a = null, b = null, c = null, d = null, e = null;
        while (RES.next()) {
            a = RES.getString("name");
            b = RES.getString("mid");
            c = RES.getString("project");
            d = RES.getString("final");
            e = RES.getString("total");
        }
        if (a == null) {
            Wrong.setVisible(true);
            Wrong.setText("No Data Avilable !!");
            CFinal.setVisible(false);
            Cmid.setVisible(false);
            NameR.setVisible(false);
            SName.setVisible(false);
            Cproject.setVisible(false);
            // Wrong.setVisible(false);
            Ctotal.setVisible(false);
            Total.setVisible(false);
            Mid.setVisible(false);
            Final.setVisible(false);
            Project.setVisible(false);
            delete.setVisible(false);
        } else {
            CFinal.setVisible(true);
            Cmid.setVisible(true);
            NameR.setVisible(true);
            SName.setVisible(true);
            Cproject.setVisible(true);
            Wrong.setVisible(false);
            Ctotal.setVisible(true);
            Total.setVisible(true);
            Mid.setVisible(true);
            Final.setVisible(true);
            Project.setVisible(true);
            NameR.setText(a);
            Mid.setText(b);
            Project.setText(c);
            Final.setText(d);
            Total.setText(e);
            delete.setVisible(true);
        }
    }

    @FXML
    private void Delete(ActionEvent event) throws ClassNotFoundException, SQLException {
        DataBase x= new DataBase();
        x.Delete("course", Id.getText());
    }
    
}
