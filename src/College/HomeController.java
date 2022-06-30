/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MHAE
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    Pane veiw;
    @FXML
    private Pane viewPane;

    public void Students() throws IOException {
        viewPane.getChildren().add(getPane("Empty.fxml"));
          College c=new College();
          c.changeName("Students");
        viewPane.getChildren().add(getPane("Student.fxml"));
    }

    public void Course() throws IOException {
        viewPane.getChildren().add(getPane("Empty.fxml"));
           College c=new College();
          c.changeName("Course");
        viewPane.getChildren().add(getPane("Course.fxml"));
    }

    public void Setting() throws IOException {
        viewPane.getChildren().add(getPane("Empty.fxml"));
           College c=new College();
          c.changeName("Setting");
        viewPane.getChildren().add(getPane("Setting.fxml"));
    }
    public void LogOut() throws IOException{
          College c=new College();
          c.changeScene("Login.fxml", 600, 400);
          c.changeName("Login");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            College c = new College();
            c.changeName("Home");
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pane getPane(String FXMLname) {
        try {
            veiw = FXMLLoader.load(getClass().getResource(FXMLname));
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiw;
    }

}
