package com.example.nfcreader2;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class LogModel extends RealmObject {
     private int locationID;
     private String dateIn;
     private String timeIn;
     private String dateOut;
     private String timeOut;
     private int customerId;


    public void setLocationID(int id){this.locationID = id;}
    public int getLocationID(){return this.locationID;}
    public void setDateIn(String date){this.dateIn = date;}
    public String getDateIn(){return this.dateIn;}
    public void setTimeIn(String time){this.timeIn = time;}
    public String getTimeIn(){return this.timeIn;}
    public void setDateOut(String date){this.dateOut = date;}
    public String getDateOut(){return this.dateOut;}
    public void setTimeOut(String time){this.timeOut = time;}
    public String getTimeOut(){return this.timeOut;}
    public void setCustomerId(int id){this.customerId = id;}
    public int getCustomerId(){return this.customerId;}
    public LogModel(){}


}
