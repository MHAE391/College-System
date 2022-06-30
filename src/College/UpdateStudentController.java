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
public class UpdateStudentController implements Initializable {

    @FXML
    private TextField Id;
    @FXML
    private Label Sclass;
    @FXML
    private Label Sphone;
    @FXML
    private Label SName;
    @FXML
    private Label Sgpa;
    @FXML
    private Button search;
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
    private Label Ngpa;
    @FXML
    private Label NClass;
    @FXML
    private Label Nphone;
    @FXML
    private TextField GPAN;
    @FXML
    private TextField ClassN;
    @FXML
    private TextField PhonN;
    @FXML
    private Button submit;
    @FXML
    private Button update;

    /**
     * Initializes the controller class.
     *
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
        NClass.setVisible(false);
        Ngpa.setVisible(false);
        Nphone.setVisible(false);
        ClassN.setVisible(false);
        PhonN.setVisible(false);
        GPAN.setVisible(false);
        submit.setVisible(false);
        update.setVisible(false);

    }

    @FXML
    private void Search(ActionEvent event) throws ClassNotFoundException, SQLException {
        String ID = Id.getText();
        DataBase x = new DataBase();
        ResultSet RES = x.Search(ID, "student");

        String a = null, b = null, c = null, d = null, e = null;
        while (RES.next()) {
            a = RES.getString("fname");
            b = RES.getString("lName");
            c = RES.getString("stdPhone");
            d = RES.getString("class");
            e = RES.getString("gpa");
        }
        if (a == null) {
            Wrong.setVisible(true);
            Wrong.setText("No Data Avilable !!");
            Sclass.setVisible(false);
            Sphone.setVisible(false);
            SName.setVisible(false);
            Sgpa.setVisible(false);
            ClassR.setVisible(false);
            //Wrong.setVisible(false);
            NameR.setVisible(false);
            PhoneR.setVisible(false);
            GpaR.setVisible(false);
            NClass.setVisible(false);
            Ngpa.setVisible(false);
            Nphone.setVisible(false);
            ClassN.setVisible(false);
            PhonN.setVisible(false);
            GPAN.setVisible(false);
            submit.setVisible(false);
            update.setVisible(false);

        } else {
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
            NameR.setText(a + " " + b);
            PhoneR.setText(c);
            GpaR.setText(e);
            submit.setVisible(false);
            update.setVisible(true);
            NClass.setVisible(false);
            Ngpa.setVisible(false);
            Nphone.setVisible(false);
            ClassN.setVisible(false);
            PhonN.setVisible(false);
            GPAN.setVisible(false);

        }

    }

    @FXML
    private void Submit(ActionEvent event) throws ClassNotFoundException, SQLException {
        String a = null, b = null, c = null;
        a = PhonN.getText();
        b = ClassN.getText();
        c = GPAN.getText();
        String d = Id.getText();
        DataBase x=new DataBase();
        x.Update("student", a, b, c,d);

    }

    @FXML
    private void Update(ActionEvent event) {
        NClass.setVisible(true);
        Ngpa.setVisible(true);
        Nphone.setVisible(true);
        ClassN.setVisible(true);
        PhonN.setVisible(true);
        GPAN.setVisible(true);
        Wrong.setVisible(false);
        submit.setVisible(true);
    }

}
