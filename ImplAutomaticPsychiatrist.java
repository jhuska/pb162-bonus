
/**
 * Class that simulates psychiatrist
 * 
 * @author (Peter Koza 410214) 
 * @version (a version number or a date)
 */
public class ImplAutomaticPsychiatrist implements AutomaticPsychiatrist
{
    private long thinkingTimeout;
    
    public ImplAutomaticPsychiatrist(long thinkingTimeout){
        this.thinkingTimeout = thinkingTimeout;
    }
    
    public void thinkSomeTime(){
        try{
            Thread.sleep(thinkingTimeout);
        }catch(InterruptedException ex){
            System.out.println("waiting interrupted");
        }
    }
}
