/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class sukarRateController implements Initializable {
    
    private Label label;
    @FXML
    private Label L1;
    @FXML
    private Label L2;
    @FXML
    private RadioButton R1;
    @FXML
    private RadioButton R2;
    private TextArea t1;
    @FXML
    private ToggleGroup tog;
    @FXML
    private Label L3;
    
    private void handleButtonAction(ActionEvent event) {
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Action(ActionEvent event) {
        
         if(R1.isArmed()){
       t1.appendText("1-Giving the patient an injection of insulin directly under\n the skin, or a sugar-lowering drug if the patient did not\n take his usual dose. \n"
            + "2-The patient had some sugar-free water or liquids. \nIt helps prevent dehydration and excessive amounts of \nsugar\n"
            +"3-The patient should not be given any foods or liquids\n that may contain sugar.\n"
            +"4-An ambulance should be called quickly, especially in\n the event of loss of consciousness");
    
         
         } }
     @FXML
    private void Action2(ActionEvent event) {
        
         if(R2.isArmed()){
    t1.appendText("1-Eat one of the simple carbohydrates that are easy \n to absorb. In general, 15 grams of simple carbohydrates \n are enough to raise the level of glucose in the body\n  within a period of 15 minutes \n "
              + "2-Rest the patient for 10-15 minutes and then check\n the blood sugar level if possible; Let's make sure your\n blood sugar level is over 70 mg / dL \n"
              + "3-If there is no improvement within 10-15 minutes or\n the blood sugar level is less than 70 mg / dL,\n an additional 10-15 grams of glucose should be taken,\n this can be repeated up to three times,\n the ambulance should be called immediately if the \n patient's condition does not improve.");
       
         }
    }
    @FXML
    private void Action3(ActionEvent event) {
        
         if(R1.isArmed()){
    L3.setText("1-Giving the patient an injection of insulin directly under\n the skin, or a sugar-lowering drug if the patient did not\n take his usual dose. \n"
            + "2-The patient had some sugar-free water or liquids. \nIt helps prevent dehydration and excessive amounts of \nsugar\n"
            +"3-The patient should not be given any foods or liquids\n that may contain sugar.\n"
            +"4-An ambulance should be called quickly, especially in\n the event of loss of consciousness");
    
         }
    }
@FXML
private void Action4(ActionEvent event) {
        
         if(R2.isArmed()){
    L3.setText("1-Eat one of the simple carbohydrates that are easy \n to absorb. In general, 15 grams of simple carbohydrates \n are enough to raise the level of glucose in the body\n  within a period of 15 minutes \n "
              + "2-Rest the patient for 10-15 minutes and then check\n the blood sugar level if possible; Let's make sure your\n blood sugar level is over 70 mg / dL \n"
              + "3-If there is no improvement within 10-15 minutes or\n the blood sugar level is less than 70 mg \ndLpatient's condition does not improve.");
       
         }
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

