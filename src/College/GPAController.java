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
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Vector;
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
public class GPAController implements Initializable {

    @FXML
    private Label c6;
    @FXML
    private Label c5;
    @FXML
    private Label c4;
    @FXML
    private Label c3;
    @FXML
    private Label c2;
    @FXML
    private Label c1;
    @FXML
    private TextField C5D;
    @FXML
    private TextField C4D;
    @FXML
    private TextField C3D;
    @FXML
    private TextField C2D;
    @FXML
    private TextField c1D;
    @FXML
    private TextField c6D;
    @FXML
    private Button gpa;
    @FXML
    private Label Wrong;
    @FXML
    private Label gp;
    @FXML
    private Button search;
    @FXML
    private TextField sId;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        c6.setVisible(false);
        Wrong.setVisible(false);
        c1D.setVisible(false);
        C2D.setVisible(false);
        C3D.setVisible(false);
        C4D.setVisible(false);
        C5D.setVisible(false);
        c6D.setVisible(false);
        gp.setVisible(false);
        gpa.setVisible(false);

    }

    @FXML
    private void GPA(ActionEvent event) {
        String s1, s2, s3, s4, s5, s6;
        s1 = c1D.getText();
        s2 = C2D.getText();
        s3 = C3D.getText();
        s4 = C4D.getText();
        s5 = C5D.getText();
        s6 = c6D.getText();
        
        Random rand = new Random();
        rand.nextInt(4);
        double t = rand.nextDouble();
        String d = String.valueOf(t);
        gp.setText(d);
        gp.setVisible(true);

    }

    @FXML
    private void Search(ActionEvent event) throws ClassNotFoundException, SQLException {
        String s = sId.getText();
        DataBase x = new DataBase();
        if (x.Valid(s, "student") == false) {
            Wrong.setText("Invalid Student Id!!");
            Wrong.setVisible(true);
        } else {
            Wrong.setVisible(false);
            c1.setVisible(true);
            c2.setVisible(true);
            c3.setVisible(true);
            c4.setVisible(true);
            c5.setVisible(true);
            c6.setVisible(true);
            //Wrong.setVisible(false);
            c1D.setVisible(true);
            C2D.setVisible(true);
            C3D.setVisible(true);
            C4D.setVisible(true);
            C5D.setVisible(true);
            c6D.setVisible(true);
            gp.setVisible(false);
            gpa.setVisible(true);
            x.GetM(s);
            Vector<String> M = new Vector<String>();
            Vector<String> W = new Vector<String>();

            M = x.M;
            if (M.size() == 0) {
                Wrong.setVisible(true);
                Wrong.setText("There are no Courses for this student!!");

            } else {
                Wrong.setVisible(false);

                for (int i = 0; i < 6; i++) {
                    ResultSet resultSet = x.Search(M.elementAt(i), "course");
                    while (resultSet.next()) {
                        if (resultSet.getString("id").equals(M.elementAt(i))) {
                            W.add(resultSet.getString("name"));
                        }
                    }

                }
                c1.setText(W.elementAt(0));
                c2.setText(W.elementAt(1));
                c3.setText(W.elementAt(2));
                c4.setText(W.elementAt(3));
                c5.setText(W.elementAt(4));
                c6.setText(W.elementAt(5));

            }

        }

    }

}
