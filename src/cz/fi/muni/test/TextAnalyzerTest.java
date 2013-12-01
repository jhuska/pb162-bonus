package cz.fi.muni.test;

import cz.fi.muni.impl.TextAnalyzerImpl;

/**
 * 
 * @author Peter Koza
 *
 */
public class TextAnalyzerTest {

	public static void main(String[] args) {
		String[] somePossibilities = { "How are you ? - Great, thanks mate!",
				"How you been ? - Fine mate!",
				"How are you doing ? - I am fine." };
		TextAnalyzerImpl analyzer = new TextAnalyzerImpl();
		System.out.println(analyzer.getBestAnswer("How a been ?",
				somePossibilities));
	}
}
