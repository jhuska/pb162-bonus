package cz.fi.muni.api;
/**
 * Class for giving the best answer for a question.
 * 
 * @author <a href="359345@mail.muni.cz">Juraj Huska</a>
 */
public interface TextAnalyzer
{
   /**
    * Gets the best answer according to the given input.
    * 
    * It will choose the answer from the given param <code>possibleInputsAndAnswers</code>.
    * Each entry in that array is in following format: "question - answer".
    * It should choose the answer for the most similar question.
    * 
    * An example call of this method would be:
    * 
    * <pre>
    * String[] somePossibilities = {"How are you ? - Great, thanks mate!", "How you been ? - Fine mate!", "How are you doing ? - I am fine."}
    * TextAnalyzer analyzer = new TextAnalyzerImpl();
    * analyzer.getBestAnswer("How are you dude ?", somePossibilities); //would return "I am fine."
    * </pre>
    * 
    * @param input                     the question which was asked
    * @parem possibleInputsAndAnswers  array with possible questions and answers
    * @return                          the answer for the most similar question as <code>input</code>. If there is no such question, the string "I am tired, bye for now" is returned.
    *                                  if there is more the first one is returned
    */
   String getBestAnswer(String input, String[] possibleInputsAndAnswers);
}