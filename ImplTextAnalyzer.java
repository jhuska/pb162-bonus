
/**
 * Implementation of the text input analyzer 
 * 
 * @author (Peter Koza 410214) 
 * @version (a version number or a date)
 */
public class ImplTextAnalyzer implements TextAnalyzer
{
    public String getBestAnswer(String input, String[] possibleInputsAndAnswers){
        if (input==null){
            return ("I am tired, bye for now.");
        }
        String answer = null;;
        for (int i = 0; i<possibleInputsAndAnswers.length; i++){
            if (possibleInputsAndAnswers[i].contains(input)){
                answer = possibleInputsAndAnswers[i].substring(possibleInputsAndAnswers[i].indexOf('-')+2);
            }
        }
        if (answer == null){
            return ("Sorry, I can't answer this question.");
        }
        return answer;
    }
}
