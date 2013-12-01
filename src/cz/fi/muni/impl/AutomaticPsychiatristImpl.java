package cz.fi.muni.impl;

import java.util.concurrent.TimeUnit;
import cz.fi.muni.api.AutomaticPsychiatrist;

/**
 * @author Karel Vaculik
 * @author Juraj Huska
 * @author Matej Šípka
 */
public class AutomaticPsychiatristImpl implements AutomaticPsychiatrist {

    private long thinkingTimeout;        
    private static volatile AutomaticPsychiatristImpl instance = null;
                
    protected AutomaticPsychiatristImpl() {
    }
        
    /**
     * Lazy Singleton method. Only one instance of this class can exist during
     * program run.
     * 
     * @return the only instance created.
     */
    public static AutomaticPsychiatristImpl getInstance() {
            if(instance == null) {
            instance = new AutomaticPsychiatristImpl();
       }
       return instance;
    }
        
    @Override
    public void thinkSomeTime(){
            
        String thinkTimeProperty = System.getProperty("thinkingTimeoutInMilliseconds");
        thinkingTimeout = Long.parseLong(thinkTimeProperty);
 
        System.out.println("hmmm, hmmm, interesting.");
        try {
            TimeUnit.MILLISECONDS.sleep(thinkingTimeout);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }         
    }

    @Override
    public void introduceMyself(String name) {
        System.out.println("Hello! My name is " + name + ". What is your name please ?");
    }
}
