/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 *
 * @author eduardo
 */

@WebService
public class FirstWebService {
    
    private String makeNouns(){
       Random random = new Random();
        
       String[] myStringArray = {"1","2","3","4","5","6","7","7","9","0"};
       String result="";
       
       for (int x=0; x < 12; x++){
           result = result + myStringArray[random.nextInt(myStringArray.length )];
       }
       return result;
        
    }
    
    public String getNouns(String name, String password, int time){
        try {
            
            DataBaseConnection myConnection = new  DataBaseConnection();
            ResultSet myResultSet =  myConnection.searchUser(name);
            
            if (myResultSet == null)//No Existe el usuario
                return "0";
            else{
                String DBPassword =myResultSet.getString("password");
                if(DBPassword.equals(password)){
                
                    SingletonNouns mySingletonNous =SingletonNouns.getInstance();

                    String noundGenerated = makeNouns();

                    if( mySingletonNous.setNouns(name, noundGenerated , time) == false){ //El nouns ya se repitio
                        boolean myFlag = false;

                        while (myFlag == false){
                            noundGenerated = makeNouns();
                            if( mySingletonNous.setNouns(name, noundGenerated, time ))
                                myFlag = true;
                        }

                    }
                    
                    return noundGenerated;
                
                }else //El usuario no tiene esa password
                    return "0";
            }

            
          
        } catch (SQLException ex) {
            Logger.getLogger(FirstWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Algo salio mal";
    
    }
}
