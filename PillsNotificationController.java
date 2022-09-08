/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthproject;

import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lokamloka
 */
public class PillsNotificationController implements Initializable {
    @FXML
    private TextField tfid;//col_id
    @FXML
    private TextField tfname;//col_name
    @FXML
    private DatePicker dp_date;//col_date
    @FXML
    private JFXTimePicker tp_time;//col_time 
    @FXML
    private TextArea tfnote;//col_note
    @FXML
    private ToggleGroup togglegroup;//col_priority
    @FXML
    private RadioButton low;
    @FXML
    private RadioButton mediam;
    @FXML
    private RadioButton high;
    @FXML
    private Button AddButton;//for alret notificstion
/*-------------------------------------textfield of add page above------------------------------*/
    private String str=""; //to write the text priority in the table
    String mid=null; // to get the id for update
/*---------------------------------------add to tableview & mysql-------------------------------*/
/*---------------------------------------add to tableview & mysql--------------------------------*/
    @FXML
    public void addCell(ActionEvent event)throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLhealthl.fxml"));
        Parent medicine_page_parent=loader.load();
        Scene medicine_page_scene=new Scene(medicine_page_parent);
       
        FXMLDocumentController firstC=loader.getController();
/*--------------------------------------to set the string periority to table---------------------*/
        if(low.isSelected()){
        str=low.getText();}
        else if(mediam.isSelected()){
            str=mediam.getText();
        }
        else{
            str=high.getText();
        }
/*--------------------------------------to set the string periority to table---------------------*/
/*--------------------------------------using alret & enter data to table------------------------*/
        Medicine m=new Medicine();
        Window owner = AddButton.getScene().getWindow();
        
        if(tfid.getText().isEmpty()){
            showAlert(Alert.AlertType.INFORMATION, owner, "Form Error!", "Please enter Medicine Id");
            return;
        }
        m.setId(tfid.getText());
        
        if(tfname.getText().isEmpty()){
            showAlert(Alert.AlertType.INFORMATION, owner, "Form Error!", "Please enter Medicine Name");
            return;
        }
        m.setMedicine_name(tfname.getText());
        
        m.setPriority(str);
        
        if(dp_date.getValue() == null){
            showAlert(Alert.AlertType.INFORMATION, owner, "Form Error!", "Please enter Medicine Date");
            return;
        }
        String date = dp_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        m.setDate(date);//string date
        
        if(tp_time.getValue() == null){
            showAlert(Alert.AlertType.INFORMATION, owner, "Form Error!", "Please enter Medicine Time");
            return;
        }
        String time= tp_time.getValue().format(DateTimeFormatter.ofPattern("hh:mm"));
        m.setTime(time);//string time
        
        if(tfnote.getText().isEmpty()){
            showAlert(Alert.AlertType.INFORMATION, owner, "Form Error!", "Please enter Medicine Note");
            return;
        }
        m.setNote(tfnote.getText());
        
        firstC.addT(m); //connecting between controller to add to table
/*--------------------------------------using alret & enter data to table------------------------*/
/*--------------------------------------insert data to mysql-------------------------------------*/
        Session session = HibernateUtil.getSessionFactory().openSession();//INSERT medicine 
        Transaction tx = session.beginTransaction();
        String cId1 = (String) session.save(m);
        tx.commit();
        session.close();
        System.out.println("inserted Medicine: \n"+m.getId()+"\n"+m.getMedicine_name()+"\n"+m.getPriority()+"\n"+m.getDate()+"\n"+m.getTime()+"\n"+m.getNote());
/*--------------------------------------insert data to mysql--------------------------------------*/
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(medicine_page_scene);
        stage1.show();      
    }
/*---------------------------------------add to tableview & mysql---------------------------------*/
    
/*-------------------------------------go back to tableview page----------------------------------*/
    @FXML
    public void goback(ActionEvent event) throws IOException{
        Parent Healthproject_page_parent=FXMLLoader.load(getClass().getResource("FXMLhealthl.fxml"));
        Scene Healthproject_page_scene=new Scene(Healthproject_page_parent);
        
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(Healthproject_page_scene);
        stage1.show();
    }
/*-------------------------------------go back to tableview page---------------------------------*/
    
/*--------------this method for passing info between controller of update method-----------------*/
    public void setItid(String x){
        tfid.setText(x);

        mid=tfid.getText();//to get the id of update
    }
    public void setItname(String x){
        tfname.setText(x);
    }
    public void setItdate(LocalDate x){
        dp_date.setValue(x);
    }
    public void setIttogglegroup(String x){
        if(low.getText().equals(x)){ 
            togglegroup.selectToggle(low);
        }
        else if(mediam.getText().equals(x)){
             togglegroup.selectToggle(mediam);
        }
        else{
             togglegroup.selectToggle(high);
        }
    }
    public void setItnote(String x){
        tfnote.setText(x);
    }
    public void setIttime(LocalTime x){
        tp_time.setValue(x);
    }
/*--------------this for passing info between controller of update method--------------------------*/
    
/*--------------------------------------to update row--------------------------------------------*/
    @FXML
    private void updateRow2(ActionEvent event)throws IOException{//update selected row
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLhealthl.fxml"));
        Parent medicine_page_parent=loader.load();
        Scene medicine_page_scene=new Scene(medicine_page_parent);
          

        FXMLDocumentController p=loader.getController();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Medicine selected=null;
        
        selected= (Medicine)session.get(Medicine.class,mid);//get the id of update
        
        selected.setId(tfid.getText());
        selected.setMedicine_name(tfname.getText());
        
        if(low.isSelected()){
        str=low.getText();}
        else if(mediam.isSelected()){
            str=mediam.getText();
        }
        else{
            str=high.getText();
        }
        
        selected.setPriority(str);
        Window owner = AddButton.getScene().getWindow();
        if(dp_date.getValue() == null){
            showAlert(Alert.AlertType.INFORMATION, owner, "Form Error!", "Please enter Medicine Date");
            return;
        }
        String date = dp_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        selected.setDate(date);
        
        String time= tp_time.getValue().format(DateTimeFormatter.ofPattern("hh:mm"));
        selected.setTime(time);
        
        selected.setNote(tfnote.getText());
        
        session.update(selected);
        session.getTransaction().commit();
        session.close();
        
        System.out.println("Updated Medicine is:"+selected.getId()+"\n"+selected.getMedicine_name());
        
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(medicine_page_scene);
        stage1.show();
    }
/*--------------------------------------to update row--------------------------------------------*/
    
/*-------------------------------------------showAlert if there error----------------------------*/
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message){
        Alert alert = new Alert(alertType); alert.setTitle(title); 
        alert.setHeaderText(null); 
        alert.setContentText(message); 
        alert.initOwner(owner); 
        alert.show();
    }
/*-------------------------------------------showAlert if there error----------------------------*/

/*-----------------------------------------------------------------------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
