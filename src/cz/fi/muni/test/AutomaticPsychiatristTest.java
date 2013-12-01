package cz.fi.muni.test;

import cz.fi.muni.impl.AutomaticPsychiatristImpl;

/**
 * 
 * @author Juraj Huska
 *
 */
public class AutomaticPsychiatristTest {

	public static void main(String[] args) {
		AutomaticPsychiatristImpl psychiatrist = new AutomaticPsychiatristImpl(5000);
		psychiatrist.thinkSomeTime();
		System.out.print("I am done!");
	}
}
