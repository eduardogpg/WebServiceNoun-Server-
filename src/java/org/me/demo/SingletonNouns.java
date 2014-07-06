/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.demo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author eduardo
 */
    public class SingletonNouns {
    
    private SingletonNouns(){}
     
    private Hashtable<String,String> dictionarieNouns =new Hashtable<String,String>();
    private Hashtable<String,String> dictionarieNounsDeadLines =new Hashtable<String,String>();
    
    
    
    private static SingletonNouns Apuntador = null;
    
    public static SingletonNouns getInstance() {
        if(SingletonNouns.Apuntador ==null)
            Apuntador = new SingletonNouns();
        return Apuntador;
    }
    private String getDeadLine(){
        Calendar calendario = Calendar.getInstance();
        int hora =calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        
        minutos++;
        if (minutos>59){
            minutos=0;
            hora++;
            if (hora==23)
                hora=0;
        }
        String deadLine =  Integer.toString(hora) + ":"+Integer.toString(minutos)+":"+Integer.toString(segundos);
        return deadLine;
       
    }
    
    public boolean isCurrent(String Nouns){
        String DeadLine = this.dictionarieNounsDeadLines.get(Nouns);
        boolean bandera = true;
        
        Calendar calendario = Calendar.getInstance();
        int hora =calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        
        String[] HMS = DeadLine.split(":");
        
        int second = Integer.parseInt(  HMS[2] );
        int minute = Integer.parseInt(  HMS[1] );
        int hour = Integer.parseInt(  HMS[0] );
        
        
        if( segundos > second ){
            if ( minutos >= minute )
                bandera=false;
        }
       
        return bandera;
    }
    
    public boolean setNouns(String user, String Nouns, int time){
         
        if ( this.dictionarieNouns.containsKey(Nouns) ){
            return false;
        }else{
            this.dictionarieNouns.put(Nouns, user);
            this.dictionarieNounsDeadLines.put(Nouns, this.getDeadLine() );
            //Noun myNoun = new Noun(time,Nouns);
            return true;
        }  
        
    }
    
    public boolean NounsUser(String Nouns, String User){
        if(this.dictionarieNouns.containsKey(Nouns)){
            
            String userHash = this.dictionarieNouns.get(Nouns);
            if ( (userHash.equals(User))  && (this.isCurrent(Nouns)== true)  )
                return true;
            else
                return false;
        }else
            return false;
    }
    
    
    
    public void removeNoun(String nouns){
        this.dictionarieNouns.remove(nouns);
        this.dictionarieNounsDeadLines.remove(nouns);
    }
    
    public int getSize(){
        return this.dictionarieNouns.size();
    }
}
