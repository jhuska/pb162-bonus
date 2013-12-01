package cz.fi.muni.impl;

import java.util.concurrent.TimeUnit;

import cz.fi.muni.api.AutomaticPsychiatrist;

/**
 * @author Karel Vaculik
 * @author Juraj Huska
 */
public class AutomaticPsychiatristImpl implements AutomaticPsychiatrist {

	private long thinkingTimeout;
	
	/**
	 * Constructs a psychiatrist instance
	 * @param thinkingTimeoutInMilliseconds
	 */
	public AutomaticPsychiatristImpl(long thinkingTimeoutInMilliseconds) {
		this.thinkingTimeout = thinkingTimeoutInMilliseconds;
	}

	@Override
	public void thinkSomeTime() {
		System.out.println("hmmm, hmmm, interesting.");
		try {
			TimeUnit.MILLISECONDS.sleep(thinkingTimeout);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}