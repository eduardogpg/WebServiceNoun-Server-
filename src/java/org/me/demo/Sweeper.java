/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.demo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class Sweeper extends Thread{
    
    SingletonNouns mySingleton;
    private boolean life = true;
    
    public Sweeper(){
        
    }
    
    public void run(){
        this.mySingleton = SingletonNouns.getInstance();
        
        while(this.life){
            System.out.println( this.mySingleton.getSize() );
            try {
                Thread.sleep(1000);
                
                
                
                

            } catch (InterruptedException ex) {
                Logger.getLogger(Sweeper.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
}
