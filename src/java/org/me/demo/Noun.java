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
    
    private String Noun= "";
    private int countCurrently = 0;
    private int deadLine = 0;
    
    
    public Noun(int deadLine, String Noun){
        
        this.deadLine = deadLine;
        this.Noun = Noun;
    }
    
    public boolean isCurrent(){
        if(this.countCurrently <= this.deadLine)
            return true;
        else
            return false;
        
    }
   
    public void oneSecondMore(){
        this.countCurrently++;
    }
    
    public String getNouns(){
        return this.Noun;
    }
}
