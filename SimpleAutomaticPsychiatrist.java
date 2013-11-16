
public class SimpleAutomaticPsychiatrist implements AutomaticPsychiatrist {
	
	private long thinkingTimeout;
	
	public SimpleAutomaticPsychiatrist(long thinkingTimeout) {
		this.thinkingTimeout = thinkingTimeout;
	}

	public void thinkSomeTime() {
		try {
			Thread.sleep(thinkingTimeout / 2);
		} catch (InterruptedException ex) {
		}
		
		System.out.println("hmmm, hmmm, interesting.");
		
		try {
			Thread.sleep(thinkingTimeout / 2);
		} catch (InterruptedException ex) {
		}
	}
}
