/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthproject;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;


/**
 *
 * @author lokamloka
 */
@Entity
@Table(name="Medicine")
public class Medicine implements java.io.Serializable {
    @Id
    @Column(name="id")
    private String id;
    
    @Column(name="medicine_name")
    private String medicine_name;
    
    @Column(name="priority")
    private String priority;
    
    @Column(name="date")
    private String date;
    
    @Column(name="time")
    private String time;
    
    @Column(name="note")
    private String note;
    
    public Medicine(String id,String medicine_name,String priority,String date,String time,String note){
        this.id=id;
        this.medicine_name=medicine_name;
        this.priority=priority;
        this.date=date;
        this.time=time;
        this.note=note;
    }
    
    public Medicine(){
    }
    
    //getter
    public String getMedicine_name(){
        return medicine_name;
    }
    public String getPriority(){
        return priority;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getNote(){
        return note;
    }
    public String getId(){
        return id;
    }
    
    
    //setter
    public void setMedicine_name(String medicine_name){
        this.medicine_name=medicine_name;
    }
    public void setPriority(String priority){
        this.priority=priority;
    }
    public void setDate(String date){
        this.date=date;
    }
    public void setTime(String time){
        this.time=time;
    }
    public void setNote(String note){
        this.note=note;
    }
    public void setId(String id){
        this.id=id;
    }
    
}
