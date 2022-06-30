/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MHAE
 */
public class SettingController implements Initializable {

    @FXML
    private Pane View;
    @FXML
    private Pane Clear;
    @FXML
    private Button password;
    @FXML
    private Button admin;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Change(ActionEvent event) {
        Clear.setVisible(false);
        View.getChildren().add(getPane("ChangePassword.fxml"));
    }

    @FXML
    private void Add(ActionEvent event) {
        View.getChildren().add(getPane("NewAdmin.fxml"));
       Clear.setVisible(false);
    }
     public Pane getPane(String FXMLname) {
        try {
            View = FXMLLoader.load(getClass().getResource(FXMLname));
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return View;
    }
}
