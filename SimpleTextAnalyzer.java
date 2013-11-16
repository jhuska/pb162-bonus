
public class SimpleTextAnalyzer implements TextAnalyzer {
	
	public String getBestAnswer(String input, String[] possibleInputsAndAnswers) {
		
		String[] inputAndAnswer = new String[2];
		String bestAnswer = "I am tired, bye for now";
		int bestAnswerIndex = 0; //Number of words of the question for the best answer
		
		for (int i = 0; i < possibleInputsAndAnswers.length; i++) {
			inputAndAnswer = possibleInputsAndAnswers[i].split(" - ", 2);
			
			int index = compareInputs(input, inputAndAnswer[0]);
			
			//If more then one question is similar, prefers a longer one
			//This is because a longer question is probably more specific and take more information
			if (index > bestAnswerIndex) {
				bestAnswerIndex = index;
				bestAnswer = inputAndAnswer[1];
			}
		}
		
		return bestAnswer;
	}
	
	/**
	 * Checks if a base input includes a searched question
	 * 
	 * @param baseInput			The base input
	 * @param searchedQuestion	The searched question
	 * @return					Number of words of searched question
	 */
	private int compareInputs(String baseInput, String searchedQuestion) {
		
		final String WORD_SEP_REGEX = "[^\\p{Alnum}]*";
		String[] baseInpWords = baseInput.split(WORD_SEP_REGEX);
		String[] searchedQstWords = searchedQuestion.split(WORD_SEP_REGEX);
		
		for (int i = 0; i <= (baseInpWords.length - searchedQstWords.length); i++) {
			if (baseInpWords[i].equalsIgnoreCase(searchedQstWords[0])) {
				boolean isSubseq = isSubsequence(baseInpWords, searchedQstWords, i);
				
				if (isSubseq) {
					return searchedQstWords.length;
				}
			}
		}
		
		return -1;
	}
	
	/**
	 * Finds out if a second sequence of words is subsequence of a first sequence of words
	 * from gived index
	 * 
	 * @param baseSeq		The first sequence of words
	 * @param subseq		The second sequence of words
	 * @param startingIdx	The starting index
	 * @return				True if is subsequence
	 */
	private boolean isSubsequence(String[] baseSeq, String[] subseq, int startingIdx) {
		
		if ((baseSeq.length - startingIdx) < subseq.length) {
			return false;
		}
		
		for (int i = 0; i < subseq.length; i++) {
			if ( !baseSeq[startingIdx + i].equalsIgnoreCase(subseq[i]) ) {
				return false;
			}
		}
		
		return true;
	}

}
