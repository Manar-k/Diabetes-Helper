/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthproject;

import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MacBook
 */
public class Controller {

    static User loggeduser;

    @FXML
    private TextField usertxt;

    @FXML
    private TextField passtxt;

    @FXML
    private Button loginBTN;
    

    @FXML
    protected void handleLoginButtonAction(ActionEvent event) throws IOException {
        Window owner = loginBTN.getScene().getWindow();
        if (usertxt.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your user name");
            return;
        }
        if (passtxt.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
            return;
        }

        List<User> allusers = null;

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Query query = session1.createQuery("from User");
        allusers = query.list();
        session1.close();
        loggeduser = null;

        for (User s : allusers) {
            if (usertxt.getText().equals( s.getUsername()) && passtxt.getText().equals( s.getPassword())) {
                loggeduser = s;
            }

        }
        if (loggeduser != null) {
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", "Welcome " + loggeduser.getName());
            Parent pillsNotification_page_parent=FXMLLoader.load(getClass().getResource("FXMLhealthl.fxml"));
        Scene pillsNotification_page_scene=new Scene(pillsNotification_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(pillsNotification_page_scene);
        stage1.show();
        } else {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Wrong username or password");
            
            //////
        }

    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
        /*-----------------------------------------go to login page-----------------------------------*/   
    @FXML
    private void loginpage(ActionEvent event) throws IOException{//changes scene to login scene
        Parent login_page_parent=FXMLLoader.load(getClass().getResource("View.fxml"));
        Scene login_page_scene=new Scene(login_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(login_page_scene);
        stage1.show();
    }
/*-----------------------------------------go to login page-----------------------------------*/ 
    
/*-----------------------------------------go to FXMLhealthl page-----------------------*/ 
    @FXML
    private void FXMLhealthlpage(ActionEvent event) throws IOException{//changes scene to pillsNotification scene
        Parent pillsNotification_page_parent=FXMLLoader.load(getClass().getResource("FXMLhealthl.fxml"));
        Scene pillsNotification_page_scene=new Scene(pillsNotification_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(pillsNotification_page_scene);
        stage1.show();
    }
/*-----------------------------------------go to FXMLhealthl page-----------------------*/ 
 
/*-----------------------------------------go to toolbag page----------------------------------*/
    @FXML
    private void toolbagpage(ActionEvent event) throws IOException{//changes scene to toolbag scene
        Parent pillsNotification_page_parent=FXMLLoader.load(getClass().getResource("aa.fxml"));
        Scene pillsNotification_page_scene=new Scene(pillsNotification_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(pillsNotification_page_scene);
        stage1.show();
    }
/*-----------------------------------------go to toolbag page----------------------------------*/ 
 
/*-----------------------------------------go to sukarRate page--------------------------------*/
    @FXML
    private void sukarRatepage(ActionEvent event) throws IOException{//changes scene to toolbag scene
        Parent pillsNotification_page_parent=FXMLLoader.load(getClass().getResource("sukarRate.fxml"));
        Scene pillsNotification_page_scene=new Scene(pillsNotification_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(pillsNotification_page_scene);
        stage1.show();
    }
/*-----------------------------------------go to sukarRate page--------------------------------*/
    
/*-----------------------------------------go to health food page--------------------------------*/
    @FXML
    private void healthfoodpage(ActionEvent event) throws IOException{//changes scene to toolbag scene
        Parent pillsNotification_page_parent=FXMLLoader.load(getClass().getResource("food.fxml"));
        Scene pillsNotification_page_scene=new Scene(pillsNotification_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(pillsNotification_page_scene);
        stage1.show();
    }
/*----------------------------------------go to health food page-------------------------------*/

}
