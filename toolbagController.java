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

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.GREEN;
import javafx.stage.Stage;


/**
 *
 * @author Afnan
 */
public class toolbagController implements Initializable {
    
    private Label label;
    @FXML
    private CheckBox ch1;
    @FXML
    private CheckBox ch2;
    @FXML
    private CheckBox ch3;
    @FXML
    private CheckBox ch4;
    @FXML
    private CheckBox ch5;
    @FXML
    private CheckBox ch6;
    @FXML
    private CheckBox ch7;
    @FXML
    private CheckBox ch8;
    @FXML
    private CheckBox ch9;
    @FXML
    private CheckBox ch10;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlech1(ActionEvent event) {
             if (ch1.isSelected()){
                ch1.setTextFill(GREEN);
    }
        
        else
          ch1.setTextFill(BLUE);
    
    
    }
    

    @FXML
    private void handlech2(ActionEvent event) {
        if (ch2.isSelected()){
                ch2.setTextFill(GREEN);
    }
        
        else
          ch2.setTextFill(BLUE);
    
    
    }

    @FXML
    private void handle3(ActionEvent event) {
            if (ch3.isSelected()){
                ch3.setTextFill(GREEN);
    }
        
        else
          ch3.setTextFill(BLUE);
    
    
    }
    

    @FXML
    private void handlech4(ActionEvent event) {
             if (ch4.isSelected()){
                ch4.setTextFill(GREEN);
    }
        
        else
          ch4.setTextFill(BLUE);
    
    
    }
    

    @FXML
    private void handlech5(ActionEvent event) {
             if (ch5.isSelected()){
                ch5.setTextFill(GREEN);
    }
        
        else
          ch5.setTextFill(BLUE);
    
    
    }
    

    @FXML
    private void handlech6(ActionEvent event) {
            if (ch6.isSelected()){
                ch6.setTextFill(GREEN);
    }
        
        else
          ch6.setTextFill(BLUE);
    
    
    }
    

    @FXML
    private void handlech7(ActionEvent event) {
            if (ch7.isSelected()){
                ch7.setTextFill(GREEN);
    }
        
        else
          ch7.setTextFill(BLUE);
    
    
    }
    

    @FXML
    private void handlech8(ActionEvent event) {
            if (ch8.isSelected()){
                ch8.setTextFill(GREEN);
    }
        
        else
          ch8.setTextFill(BLUE);
    
    
    }
    

    @FXML
    private void handlech9(ActionEvent event) {
             if (ch9.isSelected()){
                ch9.setTextFill(GREEN);
    }
        
        else
          ch9.setTextFill(BLUE);
    
    
    }
    

    @FXML
    private void handlech10(ActionEvent event) {
         
            if (ch10.isSelected()){
                ch10.setTextFill(GREEN);
    }
        
        else
          ch10.setTextFill(BLUE);
    
    
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
