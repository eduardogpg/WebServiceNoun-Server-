
package org.me.demo;

import javax.jws.WebService;

/**
 *
 * @author eduardo
 */
@WebService
public class SecondWebService {
    
    
    public boolean checkNouns(String user, String Nouns){
        
        SingletonNouns mySingletonNous = SingletonNouns.getInstance();
        
        if ( mySingletonNous.NounsUser(Nouns, user)  )
            return true;
        else{
            mySingletonNous.removeNoun(Nouns);
            return false;
            
        }
        
        
    }
    
    
    public int obtenerSize(){
        SingletonNouns mySingletonNous = SingletonNouns.getInstance();
        
        return mySingletonNous.getSize();
    }
}


