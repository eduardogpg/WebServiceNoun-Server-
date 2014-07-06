
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
        else
            return false;
        
    }
}


