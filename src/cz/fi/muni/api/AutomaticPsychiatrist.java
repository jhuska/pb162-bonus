package cz.fi.muni.api;

/**
 * Represents a new way of curing mental illnesses.
 * 
 * @author <a href="359345@mail.muni.cz">Juraj Huska</a>
 */
public interface AutomaticPsychiatrist
{
    /**
     * Method will wait for some time. 
     * During waiting, it prints on the standard output string - 
     * "hmmm, hmmm, interesting."
     * 
     * The waiting period is determined by the system property
     * <code>thinkingTimeoutInMilliseconds</code> in milliseconds.
     */
    void thinkSomeTime();
    
    /**
     * Prints a standard introduction of this psychiatrist. The introduction has following 
     * format: "Hello! My name is [name]. What is your name please ?"
     * 
     * @param name
     */
    void introduceMyself(String name);
}