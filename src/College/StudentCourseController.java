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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MHAE
 */
public class StudentCourseController implements Initializable {

    @FXML
    private TextField stdId;
    @FXML
    private TextField c1Id;
    @FXML
    private TextField c2Id;
    @FXML
    private TextField c3ID;
    @FXML
    private TextField c4Id;
    @FXML
    private TextField c5Id;
    @FXML
    private TextField c6ID;
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
        String ID = null, c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null;
        ID = stdId.getText();
        c1 = c1Id.getText();
        c2 = c2Id.getText();
        c3 = c3ID.getText();
        c4 = c4Id.getText();
        c5 = c5Id.getText();
        c6 = c6ID.getText();
        DataBase x = new DataBase();
        if (x.Valid(ID, "student") == false) {
            label.setVisible(false);
            label.setText("Invalid Student Id");
            label.setVisible(true);
        } else if (x.Valid(c1, "course") == false) {
            label.setVisible(false);
            label.setText("Invalid First Course Id");
            label.setVisible(true);
        } else if (x.Valid(c2, "course") == false) {
            label.setVisible(false);
            label.setText("Invalid Second  Course Id");
            label.setVisible(true);
        } else if (x.Valid(c3, "course") == false) {
            label.setVisible(false);
            label.setText("Invalid Thrid Course Id");
            label.setVisible(true);
        } else if (x.Valid(c4, "course") == false) {
            label.setVisible(false);
            label.setText("Invalid Fourth Course Id");
            label.setVisible(true);
        } else if (x.Valid(c5, "course") == false) {
            label.setVisible(false);
            label.setText("Invalid Fifth Course Id");
            label.setVisible(true);
        } else if (x.Valid(c6, "course") == false) {
            label.setVisible(false);
            label.setText("Invalid Sixth Course Id");
            label.setVisible(true);
        } else {
            label.setVisible(false);
            x.InsertDegree(ID, c1);
            x.InsertDegree(ID, c2);
            x.InsertDegree(ID, c3);
            x.InsertDegree(ID, c4);
            x.InsertDegree(ID, c5);
            x.InsertDegree(ID, c6);
        }

    }

}
