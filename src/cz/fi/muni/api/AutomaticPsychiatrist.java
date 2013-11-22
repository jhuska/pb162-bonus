package cz.fi.muni.api;
/**
 * Represents a new way of curing mental illnesses.
 * 
 * @author <a href="359345@mail.muni.cz">Juraj Huska</a>
 */
public interface AutomaticPsychiatrist
{
    /**
     * Method will wait for some time. During waiting, it prints on the standard output string - "hmmm, hmmm, interesting."
     * 
     * The waiting period is determined by the constructor parameter <code>long thinkingTimeout</code> in miliseconds.
     */
    void thinkSomeTime();
}