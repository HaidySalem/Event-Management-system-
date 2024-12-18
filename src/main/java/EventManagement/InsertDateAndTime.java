/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package first.eventmangmentsystem;
import java.util.*;

/**
 *
 * @author ASUS
 */

public class InsertDateAndTime {
    Scanner date = new Scanner(System.in);

    int year = date.nextInt() ;
    int month = date.nextInt() ;
    int day = date.nextInt();

    public InsertDateAndTime(int day,int month,int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    //method that display the date in a formate (DD/MM/YYYY)
    public String displayTheDate(){
        return day + "/" + (month+1) +"/" + year ;
    }
}