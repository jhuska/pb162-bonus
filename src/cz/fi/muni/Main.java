package cz.fi.muni;

import cz.fi.muni.exception.AutomaticPsychiatristException;
import cz.fi.muni.impl.AutomaticPsychiatristImpl;

/**
 * 
 * @author Lukas Budac
 * 
 */
public class Main {

	/**
	 * @param args
	 * @throws AutomaticPsychiatristException
	 */
	public static void main(String[] args)
			throws AutomaticPsychiatristException {
		if (args.length != 1 || args[0] == null) {
			throw new AutomaticPsychiatristException(
					"Wrong number of arguments. "
							+ "Try to run using exactly one argument, which represents "
							+ "name of the psychiatrist.");
		}

		String psychiatristsName = args[0];

		AutomaticPsychiatristImpl automaticPsychiatrist = AutomaticPsychiatristImpl
				.getInstance();
		automaticPsychiatrist.introduceMyself(psychiatristsName);

		try {
			automaticPsychiatrist.thinkSomeTime();
		} catch (Exception e) {
			System.err.println("I am sick and tired. Come later!");
			throw new AutomaticPsychiatristException(
					"Error while trying to think.", e);
		}
	}
}