/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class foodController implements Initializable {
    
    private Label label;
    @FXML
    private Label L1;
    private RadioButton R1;
    private RadioButton R2;
    private TextArea t1;
    @FXML
    private Label L3;
    @FXML
    private ImageView IM2;
    @FXML
    private ImageView IM1;
    @FXML
    private ComboBox<String> CMO;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CMO.getItems().setAll("UNuseful Food", "Useful Food");
        assert IM1 != null : "fx:id=\"IM1\" was not injected: check your FXML file 'fruitcombo.fxml'.";
    assert IM2 != null : "fx:id=\"IM1\" was not injected: check your FXML file 'fruitcombo.fxml'.";
    }    

     String[] greetings = {"1- Sweet breakfast cereals.\n 2- Sweetened yogurt\n 3- White bread. \n 4- incomplete grain pasta. \n 5-white rice.\n 6- Dried fruits of all kinds.\n "
            + "7- Fruit juice, both natural \n  and processed.", " 1- Fatty fish\n 2- eggs.\n 3- Broccoli.\n 4- garlic\n 5- Strawberries \n 6- Nuts  \n 7- Leafy vegetables"};
    ImageView[] m=new ImageView[]{IM1,IM2};
     @FXML
    private void Action3(ActionEvent event) {
        
       // comboBox هنا قمنا بتحديد ماذا سيحدث عند تغيير القيمة المختارة في الـ
        CMO.getSelectionModel().selectedIndexProperty().addListener(
            // يمثل القيمة القديمة old_val يمثل القيمة الجديدة و كائن الـ new_val كائن الـ
            (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            // label كنص للكائن new_val هنا وضعنا القيمة الجديدة المخزنة في الكائن
            L3.setText(greetings[new_val.intValue()]);
            
              CMO.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
      @Override public void changed(ObservableValue<? extends String> selected, String oldSELECT, String newSELECT) {
        if (oldSELECT != null) {
          switch(oldSELECT) {
            case "UNuseful Food": IM1.setVisible(false); break;
            case "Useful Food": IM2.setVisible(false); break;
           
          }
        }
        if (newSELECT != null) {
          switch(newSELECT) {
            case "UNuseful Food": IM1.setVisible(true); break;
            case "Useful Food": IM2.setVisible(true); break;
          
          }
        }
      }
    });
        });
    }
private void Action4(ActionEvent event) {
        
         if(R2.isArmed()){
    L3.setText(" 1- Fatty fish\n 2- eggs.\n 3- Broccoli.\n 4- garlic\n 5- Strawberries \n 6- Nuts  \n 7- Leafy vegetables");
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

