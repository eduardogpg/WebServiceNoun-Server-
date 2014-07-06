/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.demo;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author eduardo
 */
    public class SingletonNouns {
    
    private SingletonNouns(){}
     
    private Hashtable<String,String> dictionarieNouns =new Hashtable<String,String>();
    
    private Hashtable<String,Noun> dictionarieNounsObjetcs =new Hashtable<String,Noun>();
    
    private static SingletonNouns Apuntador = null;
    
    public static SingletonNouns getInstance() {
        if(SingletonNouns.Apuntador ==null)
            Apuntador = new SingletonNouns();
        return Apuntador;
    }
    
    private String getCurrentlyDate(){
        java.util.Date today = new Date();
        return today.toString();
    }
    
    private String getDeadLine(){
        
        java.util.Date today = new Date();
        String deadLine = today.toString();
        String[] closters = deadLine.split(" ");
        String[] HMS = closters[3].split(":");
        
        int second = Integer.parseInt(  HMS[2] );
        int minute = Integer.parseInt(  HMS[1] );
        int hour = Integer.parseInt(  HMS[0] );
        
        minute ++;
        if (minute>=60){
            minute=1;
            hour++;
            if(hour>23){
                hour=0;
                   
            }
        }
        String x = Integer.toString(hour) +":"+Integer.toString(minute)+":"+Integer.toString(second);
        String finalDeadLine = closters[0]+ " "+ closters[1]+ " "+ closters[2] + " "+x+" "+closters[4]+ " "+closters[5];
        
        return finalDeadLine;
    }
    
    public boolean setNouns(String user, String Nouns){
         
        if ( this.dictionarieNouns.containsKey(Nouns) ){
            return false;
        }else{
            this.dictionarieNouns.put(Nouns, user);
            
            Noun newNouns = new Noun(Nouns, getCurrentlyDate(), getDeadLine() );
            this.dictionarieNounsObjetcs.put(Nouns, newNouns);
            
            return true;
        }  
        
    }
    private boolean stillTime(String Nouns){
        Noun myNoun = this.dictionarieNounsObjetcs.get(Nouns);
        return myNoun.stillTime();
        
        
        
    }
    public boolean NounsUser(String Nouns, String User){
        if(this.dictionarieNouns.containsKey(Nouns)){
            
            String userHash = this.dictionarieNouns.get(Nouns);
            if (userHash.equals(User))
                if(stillTime(Nouns))
                    return true;
                else
                    return false;
            else
                return false;
        }else
            return false;
    }
    
    public void removeNoun(String nouns){
        this.dictionarieNouns.remove(nouns);
    }
    
}
