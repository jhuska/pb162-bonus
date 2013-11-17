
/**
 * Class implements a sipmle virtual psychiatrist.
 * 
 * @author Matej Sipka
 * @version 16.11.2013
 */

public class Psychiatrist implements AutomaticPsychiatrist,TextAnalyzer{

    long thinkingTime;
    private static final int DELAY = 90000000;
    
    /**
     * Constructor of class Psychiatrist.
     * 
     * @param thinkingTime time set for another method 
     */
    public Psychiatrist(long thinkingTime){
        
        if (thinkingTime >= 0) this.thinkingTime = thinkingTime;
        else throw new IllegalArgumentException("Wrong parameter.");
        
    }
    
    /**
     * Method waits some time, the delay is established to print the message
     * on standart output after few seconds.     * 
     */
    @Override
    public void thinkSomeTime() {
        
        long currentSystemTime = System.currentTimeMillis();
        int seconds = 0;
        
        if (currentSystemTime > 0) System.out.println("hmmm, hmmm, interesting.");
     
        while (System.currentTimeMillis() - currentSystemTime < thinkingTime){            
            seconds++;
            
            if (seconds - DELAY == 0){
                System.out.println("hmmm, hmmm, interesting.");
                seconds = 0;               
            }
        }
    }

    /**
     * Method analyzes input and chooses the best answer to be printed 
     * on standart output.
     * 
     * @param input represents the asked question.
     * @param possibleInputsAndAnswers represents array of acceptable answers  
     *        on questions.
     * @return the best choosen answer
     */
    @Override
    public String getBestAnswer(String input, String[] possibleInputsAndAnswers){
        
        if (input == null) return "I am tired, bye for now.";
        
        String[] questions = new String[possibleInputsAndAnswers.length];
        String[] answers = new String[possibleInputsAndAnswers.length];
        int comparation = Integer.MAX_VALUE;
        int toWriteAnswer = 0;
        
        for (int i = 0; i < possibleInputsAndAnswers.length; i++){
            
            String[] parts = possibleInputsAndAnswers[i].split("-");
            
            questions[i] = parts[0].trim();
            answers[i] = parts[1].trim();
        }
        
        for (int i = 0; i < questions.length; i++){
            
            int result = input.compareToIgnoreCase(questions[i]);
            
            if (Math.abs(result) < comparation){
                comparation = Math.abs(result);
                toWriteAnswer = i;
            }
            
            if (result == 0){
                toWriteAnswer = i;
                break;
            }
        }
        
        return answers[toWriteAnswer];
    }
    
}
