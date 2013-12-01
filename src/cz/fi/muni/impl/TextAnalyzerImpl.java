/*package cz.fi.muni.impl;

import cz.fi.muni.api.TextAnalyzer;*/

package pb162bonus2;
import api.TextAnalyzer;

/**
 * @author Lukas Budac
 */
public class TextAnalyzerImpl implements TextAnalyzer {

@Override
	public String getBestAnswer(String input, String[] possibleInputsAndAnswers) {
		String inputLwcs = input.toLowerCase();
		String[] possibleInputsAndAnswersLwcs = new String[possibleInputsAndAnswers.length];

		for (int i = 0; i < possibleInputsAndAnswers.length; i++) {
			possibleInputsAndAnswersLwcs[i] = possibleInputsAndAnswers[i]
					.toLowerCase();
		}

		String[] splittedInput = inputLwcs.split("\\s+");

		int[] match = findMatch(possibleInputsAndAnswersLwcs, splittedInput);

		int maxMatchingWords = 0;
		int maxMatchingWordsIndex = -1;

		for (int i = 0; i < match.length; i++) {
			if (match[i] > maxMatchingWords) {
				maxMatchingWords = match[i];
			}
		}

		for (int i = 0; i < match.length; i++) {
			if (match[i] == maxMatchingWords) {
				maxMatchingWordsIndex = i;
			}
		}

		int biggestMatchIndex = getIndexOfBiggestMatch(match,
				possibleInputsAndAnswersLwcs, inputLwcs, maxMatchingWords);

		String ret = "I am tired, bye for now";

		if (biggestMatchIndex >= 0) {
			int indexOfDash = possibleInputsAndAnswers[biggestMatchIndex]
					.indexOf("-");
			ret = possibleInputsAndAnswers[biggestMatchIndex]
					.substring(indexOfDash + 2);
		} else if (maxMatchingWords > 0) {
			int indexOfDash = possibleInputsAndAnswers[maxMatchingWordsIndex]
					.indexOf("-");
			ret = possibleInputsAndAnswers[maxMatchingWordsIndex]
					.substring(indexOfDash + 2);
		}

		return ret;
	}

	/**
	 * Finds number of words, which are the same in asked question and each of
	 * possible answer, and represent them in an array.
	 * 
	 * @param possibleInputs
	 *            array with possible questions and answers
	 * @param splittedInput
	 *            the question which was asked splitted by spaces into array
	 * @return an array of numbers of words, which are the same in asked
	 *         question and each of possible answer
	 */
	private int[] findMatch(String[] possibleInputs, String[] splittedInput) {
		int[] match = new int[possibleInputs.length];
		int occurenceOfWords = 0;

		for (int i = 0; i < possibleInputs.length; i++) {
			int questionMarkIndex = possibleInputs[i].indexOf("?");
			String[] splittedPossibleQuestion = possibleInputs[i].substring(0,
					questionMarkIndex).split("\\s+");

			for (int j = 0; j < splittedInput.length; j++) {
				for (int k = 0; k < splittedPossibleQuestion.length; k++) {
					if (splittedPossibleQuestion[k].equals(splittedInput[j])) {
						occurenceOfWords += 1;
					}
				}
			}

			match[i] = occurenceOfWords;
			occurenceOfWords = 0;
		}
		return match;
	}

	/**
	 * Finds index of possible answer with the most matching characters with
	 * question, which was asked
	 * 
	 * @param match
	 *            an array of numbers of words, which are the same in asked
	 *            question and each of possible answer
	 * @param possibleInputsAndAnswersLwcs
	 *            array with possible questions and answers (in lowercase)
	 * @param inputLwcs
	 *            the question which was asked (in lowecase)
	 * @param maxMatchingWords
	 *            number of maximal matching words
	 * @return index of possible answer with the most matching characters with
	 *         question, which was asked
	 */
	private int getIndexOfBiggestMatch(int[] match,
			String[] possibleInputsAndAnswersLwcs, String inputLwcs,
			int maxMatchingWords) {
		int matchingChars = 0;
		int biggestMatch = 0;
		int biggestMatchIndex = -1;

		for (int i = 0; i < match.length; i++) {
			if (match[i] == maxMatchingWords) {
				if (inputLwcs.equals(possibleInputsAndAnswersLwcs[i]))
					break;

				int index = 0;
				while (inputLwcs.charAt(index) == possibleInputsAndAnswersLwcs[i]
						.charAt(index)) {
					matchingChars += 1;
					index++;
					if (index == inputLwcs.length()) {
						break;
					}
				}

				if (matchingChars > biggestMatch) {
					biggestMatch = matchingChars;
					biggestMatchIndex = i;
				}

			}
			matchingChars = 0;
		}
		return biggestMatchIndex;
	}
}