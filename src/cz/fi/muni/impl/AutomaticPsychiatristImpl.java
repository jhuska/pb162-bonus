package cz.fi.muni.impl;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PRIVATE_MEMBER;

import cz.fi.muni.api.AutomaticPsychiatrist;
import cz.fi.muni.exception.AutomaticPsychiatristException;

/**
 * @author Karel Vaculik
 * @author Lukas Budac
 * @author Juraj Huska
 */
public class AutomaticPsychiatristImpl implements AutomaticPsychiatrist {

	private static AutomaticPsychiatristImpl instance = null;
	private long thinkingTimeout;
	
	protected AutomaticPsychiatristImpl(){
	}
	
	public static AutomaticPsychiatristImpl getInstance(){
		if(instance == null){
			instance = new AutomaticPsychiatristImpl();
		}
		return instance;
	}

	@Override
	public void thinkSomeTime() throws AutomaticPsychiatristException {
		try{
			String timeoutProperty = System.getProperty("thinkingTimeoutInMilliseconds");
			thinkingTimeout = Long.parseLong(timeoutProperty);
		}catch(NumberFormatException nfe){
			throw new AutomaticPsychiatristException("Wrong format of number.", nfe);
		}
		
		System.out.println("hmmm, hmmm, interesting.");
		
		try {
			TimeUnit.MILLISECONDS.sleep(thinkingTimeout);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public void introduceMyself(String name) {
		System.out.println("Hello! My name is "+ name+". What is your name please ?");		
	}
	
}