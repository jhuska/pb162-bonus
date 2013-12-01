package cz.fi.muni.exception;

/**
 * Class represents the new made exception.
 * 
 * @author Matej Šípka
 * @version 30.11.2013
 */

public class AutomaticPsychiatristException extends Exception {
    
    public AutomaticPsychiatristException(){
        super();
    }
    
    public AutomaticPsychiatristException(String msg){
        super(msg);
    }
        
    public AutomaticPsychiatristException(String msg, Throwable cause){
        super(msg,cause);
    }
}
