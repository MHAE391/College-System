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
public class CourseController implements Initializable {

    @FXML
    private Pane Clear;
    @FXML
    private Button insert;
    @FXML
    private Button update;
    @FXML
    private Button search;
    @FXML
    private Button delete;
    @FXML
    private Pane View;
    @FXML
    private Button Assign;
    @FXML
    private Button StudentCourse;

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
    private void Insert(ActionEvent event) {
        Clear.setVisible(false);

        View.getChildren().add(getPane("InsertStudent.fxml"));
    }

    @FXML
    private void Update(ActionEvent event) {
        Clear.setVisible(false);
        View.getChildren().add(getPane("UpdateCourse.fxml"));
    }

    @FXML
    private void Search(ActionEvent event) {
        Clear.setVisible(false);
        View.getChildren().add(getPane("SearchCourse.fxml"));
    }

    @FXML
    private void Delete(ActionEvent event) {
        Clear.setVisible(false);
        View.getChildren().add(getPane("DeleteCourse.fxml"));
    }

    public Pane getPane(String FXMLname) {
        try {
            View = FXMLLoader.load(getClass().getResource(FXMLname));
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return View;
    }

    @FXML
    private void GPA(ActionEvent event) {
        Clear.setVisible(false);
        View.getChildren().add(getPane("GPA.fxml"));

    }

    @FXML
    private void Student(ActionEvent event) {

        Clear.setVisible(false);
        View.getChildren().add(getPane("StudentCourse.fxml"));
    }

}
