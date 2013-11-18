import java.lang.System;


public class AutomaticPsychiatristImpl implements AutomaticPsychiatrist{

	private long thinkingTimeout;
	
	/**
	 * Constructor of AutomaticPsychiatristImpl. 
	 * 
	 * @param thinkingTimeout	timeout to think
	 */
	public AutomaticPsychiatristImpl(long thinkingTimeout){
		this.thinkingTimeout = thinkingTimeout;
	}
	
	/**
	 * Thinks for a thinkingTimeout time and every 5 second prints "hmm, hmm interesting"
	 * 
	 */
	@Override
	public void thinkSomeTime() {
		final int DELAY_OF_MSG = 5000;
		double estimates = thinkingTimeout;
		 
		while(estimates > 0) {
		    //long millis = System.currentTimeMillis();		
		    
		    try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
		    if(estimates % DELAY_OF_MSG == 0  ){
		    	System.out.println("hmmm, hmmm, interesting.");
		    }
		   
		    estimates-= 1;
		}
	}
}
