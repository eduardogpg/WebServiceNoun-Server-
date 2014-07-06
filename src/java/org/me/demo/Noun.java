/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.demo;

import java.util.Date;

/**
 *
 * @author eduardo
 */
public class Noun {
    
    private String idNoun;
    private String currentlyDate;
    private String deadLine;
    
    public Noun(String idNoun,String currentlyDate, String deadLine){
        this.idNoun = idNoun;
        this.currentlyDate = currentlyDate;
        this.deadLine = deadLine;
        
    }
 
    public String getIdNoun(){
        return idNoun;
    }
    
    public String getCurrentlyDate(){
        return this.currentlyDate;
    }
    
    public String deadLine(){
        return this.deadLine;
    }
    
    public boolean stillTime(){
        java.util.Date today = new Date();
        String deadLinex = today.toString();
        String[] closters = deadLinex.split(" ");
        String[] HMS = closters[3].split(":");
        
        int second = Integer.parseInt(  HMS[2] );
        int minute = Integer.parseInt(  HMS[1] );
        int hour = Integer.parseInt(  HMS[0] );
        
         
        String[] closterstwo = this.deadLine.split(" ");
        String[] HMStwo = closters[3].split(":");
        
        int secondtwo = Integer.parseInt(  HMStwo[2] );
        int minutetwo = Integer.parseInt(  HMStwo[1] );
        int hourtwo = Integer.parseInt(  HMStwo[0] );
        
        if( ( minute<= minutetwo) && ( hour<= hourtwo) )
            return true;
        else
            return false;
    }
}
