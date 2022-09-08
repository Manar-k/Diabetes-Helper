/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthproject;

//import static healthproject.PillsNotificationController.showAlert;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import javafx.util.Duration;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.animation.Animation;//using animation for clock;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lokamloka
 */
public class FXMLDocumentController implements Initializable {
/*----------------------------------------column names--------------------------------------*/
    @FXML
    private TableView <Medicine> table1;
    @FXML
    private TableColumn<Medicine,String> col_id;
    @FXML
    private TableColumn<Medicine,String> col_name;
    @FXML
    private TableColumn<Medicine,String> col_priority;
    @FXML
    private TableColumn<Medicine,String> col_date;
    @FXML
    private TableColumn<Medicine,String> col_time;
    @FXML
    private TableColumn<Medicine,String> col_note;
/*----------------------------------------column names--------------------------------------*/
    
/*----------------------------------------current time--------------------------------------*/
   @FXML 
   private Label time; //current time to compare it with colum time to get notification
/*----------------------------------------current time--------------------------------------*/
   
/*-----------------------------------observiblelist of medicine------------------------------*/
     ObservableList <Medicine> Medicineol= FXCollections.observableArrayList();
     
     @FXML
     private Button ringButton;//for alret notificstion
/*-----------------------------------observiblelist of medicine------------------------------*/
     
/*---------------------------------------retrive Medicine list-------------------------------*/     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<Medicine> medicinelist = null;
        String queryStr = "from Medicine";
        Query query = session1.createQuery(queryStr);
        medicinelist = query.list();
        session1.close();
        System.out.println("Medicine list size: "+medicinelist.size());
        for(Medicine mm: medicinelist)
        { 
              Medicineol.add(mm);
        }//retrive from database to project
    
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("medicine_name"));
        col_priority.setCellValueFactory(new PropertyValueFactory<>("priority"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        col_note.setCellValueFactory(new PropertyValueFactory<>("note"));
        
        table1.setItems(Medicineol);
        table1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        initializeTime();//current time 
        
        for(Medicine m : table1.getItems()) { //for alarm sound
            compareDates(col_time.getCellData(m));
        }

    }
/*---------------------------------------retrive Medicine list-------------------------------*/ 
    
/*-------------------------------------passing info to add to table--------------------------*/     
    public void addT(Medicine m){
        table1.getItems().add(m);
        //Medicineol.addAll(m);
    }
/*-------------------------------------passing info to add to table--------------------------*/ 
     
/*---------------------------------------delete row------------------------------------------*/
    @FXML
    private void deleteRow(ActionEvent event){//for delete selected row
       Medicine m = table1.getSelectionModel().getSelectedItem();//get the selected 
       //Delete Medicine
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx2 = null;
       tx2 = session.beginTransaction();
       System.out.println("deleted Medicine: "+m.getId()+"\n"+m.getMedicine_name()+"\n"+m.getPriority()+"\n"+m.getDate()+"\n"+m.getTime()+"\n"+m.getNote());
       session.delete(m);
       tx2.commit();
       session.close();
       table1.getItems().removeAll(table1.getSelectionModel().getSelectedItems());//delete from table
    }
/*---------------------------------------delete row------------------------------------------*/
    
/*--------------------------------------------update row-------------------------------------*/
    @FXML
    private void updateRow(ActionEvent event)throws IOException{//update selected row
        FXMLLoader loader=new FXMLLoader(getClass().getResource("PillsNotification.fxml"));
        Parent PillsNotification_page_parent=(Parent) loader.load();
        
        PillsNotificationController p =loader.getController();
        
        Medicine selected=table1.getSelectionModel().getSelectedItem();
/*----------------------using passing info to set value in pillnotification page--------------*/        
        p.setItid(selected.getId());
        p.setItname(selected.getMedicine_name());
        p.setIttogglegroup(selected.getPriority());
        
        p.setIttime(LocalTime.parse(selected.getTime()));
        p.setItnote(selected.getNote());
/*----------------------using passing info to set value in pillnotification page--------------*/
        System.out.println("Updated Medicine is:"+selected.getId()+"\n"+selected.getMedicine_name());
        
        Scene PillsNotification_page_scene=new Scene(PillsNotification_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(PillsNotification_page_scene);
        stage1.show();
    }
/*--------------------------------------------update row-------------------------------------*/
    
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
    
/*-----------------------------------------go to pillsNotification page-----------------------*/ 
    @FXML
    private void pillsNotificationpage(ActionEvent event) throws IOException{//changes scene to pillsNotification scene
        Parent pillsNotification_page_parent=FXMLLoader.load(getClass().getResource("PillsNotification.fxml"));
        Scene pillsNotification_page_scene=new Scene(pillsNotification_page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(pillsNotification_page_scene);
        stage1.show();
    }
/*-----------------------------------------go to pillsNotification page-----------------------*/ 
 
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
 
/*-----------------------------------------live time-------------------------------------------*/ 
    /*https://stackoverflow.com/questions/42383857/javafx-live-time-and-date/42384436
    *live clock that set in label
    *change every second setCycleCount()
    */
    @FXML
    public void initializeTime() { //animation time 

    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
        LocalTime currentTime = LocalTime.now();
        time.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
    }),
         new KeyFrame(Duration.seconds(1))
    );
    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();
    
    }
/*-----------------------------------------live time-------------------------------------------*/  

/*--------------------------------------compare time-------------------------------------------*/    
public static final String inputFormat = "HH:mm";
private Date date;
private Date dateCompareTwo;
SimpleDateFormat inputParser = new SimpleDateFormat(inputFormat, Locale.getDefault());
/* https://stackoverflow.com/questions/6377278/how-to-compare-current-time-with-time-range
* there are many changes i did in code 1)compare curent time with time of medicene in 
* in time column in tableview, add alarm music, make the button red.
*/
private void compareDates(String time){//compare date time to get a notification music
    Calendar now = Calendar.getInstance();

    int hour = now.get(Calendar.HOUR);
    int minute = now.get(Calendar.MINUTE);

    date = parseDate(hour + ":" + minute); //convert string time to date

    dateCompareTwo = parseDate(time);
    
    if ( date.equals(dateCompareTwo) ){
        playAlarm();//play the music
        ringButton.setStyle("-fx-background-color:RED;");//make the notification button red to click it
        System.out.println("it is same date time");
        System.out.println("please take you Medicine");
    }    
}

private Date parseDate(String date) {

    try {
        return inputParser.parse(date);
    } catch (java.text.ParseException e) {
        return new Date(0);
    }
}
/*--------------------------------------compare time-------------------------------------------*/  

/*--------------------------------------sound notification-------------------------------------*/  
private MediaPlayer mediaPlayer;
    
    public void playAlarm()//decleare a media player & make it play
    {
        Media media = new Media(getClass().getResource("/Creepy-clock-chiming.mp3").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    
    public void stopAlarm() //decleare a media player & make it stop
    {
        this.mediaPlayer.stop();
    }
/*--------------------------------------sound notification-------------------------------------*/  
    
/*--------------------------------------show notification-------------------------------------*/ 
/*
*in this code in to send notification at specific time that is in time column with Medicine data 
*/
private Date date2;
private Date dateCompareTwo2;
    @FXML
    private void ringNotification(ActionEvent event){//for alarm massege
        for(Medicine m : table1.getItems()){ //get time column to comapre it
            Calendar now = Calendar.getInstance();
            int hour = now.get(Calendar.HOUR);
            int minute = now.get(Calendar.MINUTE);
            
            date2 = parseDate(hour + ":" + minute); //convert string time to date

            dateCompareTwo2 = parseDate(col_time.getCellData(m));
            
            if(date2.equals(dateCompareTwo2)){//compare it with current time
                System.out.println(date2+"\n"+dateCompareTwo2);
                //stopAlarm();
                Image img=new Image("/pills.png");
                Notifications timeNotification= Notifications.create()
                .title("Medicine Time")//the massege
                .text("Please Take Your Medicine ! \n"+"Medicine Name : "+m.getMedicine_name()
                +"\nMedicine Priority:  "+m.getPriority()+"\nMedicine Time: "
                        +m.getTime()+"\nMedicine Note:  "+m.getNote())
                
                .graphic(new ImageView(img))
                .hideAfter(Duration.minutes(1))//sty for mintu
                .position(Pos.TOP_RIGHT);
                //.onAction(); 
                timeNotification.show();
            }
        }
    }
/*--------------------------------------show notification-------------------------------------*/ 
}
