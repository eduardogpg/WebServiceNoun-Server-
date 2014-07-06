/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.demo;
import java.util.Hashtable;

/**
 *
 * @author eduardo
 */
    public class SingletonNouns {
    
    private SingletonNouns(){}
     
    private Hashtable<String,String> dictionarieNouns =new Hashtable<String,String>();
    
    private static SingletonNouns Apuntador = null;
    
    public static SingletonNouns getInstance() {
        if(SingletonNouns.Apuntador ==null)
            Apuntador = new SingletonNouns();
        return Apuntador;
    }
    
    public boolean setNouns(String user, String Nouns){
         
        if ( this.dictionarieNouns.containsKey(Nouns) ){
            return false;
        }else{
            this.dictionarieNouns.put(Nouns, user);
            return true;
        }  
        
    }
    
    public boolean NounsUser(String Nouns, String User){
        if(this.dictionarieNouns.containsKey(Nouns)){
            
            String userHash = this.dictionarieNouns.get(Nouns);
            if (userHash.equals(User))
                return true;
            else
                return false;
        }else
            return false;
    }
    
    public void removeNoun(String nouns){
        this.dictionarieNouns.remove(nouns);
    }
    
}
