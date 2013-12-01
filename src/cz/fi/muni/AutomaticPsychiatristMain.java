package cz.fi.muni;

import cz.fi.muni.impl.*;

import exception.AutomaticPsychiatristException;

/**
 * Class runs and tests the implementation of second iteration.
 * 
 * @author Matej Šípka
 * @version 30.11.2013
 */
public class AutomaticPsychiatristMain{
    
    private static TextAnalyzerImpl textAna;
    
     public static void main(String[] args) throws AutomaticPsychiatristException{
         
         if (args.length == 0 || args[0] == null){
             throw new AutomaticPsychiatristException("No name given. You should"
                     + " give the name to psychiatrist in first parameter.");
         }
         
         AutomaticPsychiatristImpl autPsy = AutomaticPsychiatristImpl.getInstance();
         
         autPsy.introduceMyself(args[0]);     
         
         try{
             autPsy.thinkSomeTime();
         } catch (Exception e){
             System.err.println("I am sick and tired. Come later!");
             throw new AutomaticPsychiatristException ("Some error occured"
                     + " theres not any or not correct parameter in getProperty method", e);
         }
     }
    
}
