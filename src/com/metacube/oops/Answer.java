package com.metacube.oops;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaurav
 */
public class Answer {
    private String answer;
    private int questionId;

    /**
     * Setter function for answer attribute
     * @param answer String
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Setter function for questionId attribute
     * @param questionId Integer
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    
    /**
     * Getter function for answer attribute
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Getter function for questionId attribute
     */
    public int getQuestionId() {
        return questionId;
    }
    
    /**
     * Validate the answer on the basis of give options
     * @param answer String
     * @param questionId Integer
     * @param question String
     * @return boolean true -> valid, false -> invalid
     */
    public static boolean validateAnswer(String answer, int questionId, String question){
        boolean result = true;
        try{
            switch (questionId) {
                case 0:
                    int ans1 = Integer.parseInt(answer);
                    if(ans1 <= 0){
                        throw new Exception("Must be a positive number");
                    }  
                    else if(!question.contains(answer)){
                        throw new Exception("Invalid option, Choose the appropriate option");
                    } break;
                case 3:
                    int ans3 = Integer.parseInt(answer);
                    if(ans3 <= 0){
                        throw new Exception("Must be a positive number");
                    } break;
                case 1:
                    if(answer.length() == 0){
                        throw new Exception("Answer Must Not Be Empty");
                    }
                    else {
                        for(String options : answer.split(",")){
                            if(!question.contains(options)){
                                throw new Exception("Invalid answer, Choose the appropriate answer");
                            }
                        }
                    }   break;
                default:
                    if(answer.length() == 0){
                        throw new Exception("Answer Must Not Be Empty");
                    }   break;
            }
        } catch(NumberFormatException ex){
            result = false;
            Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch(Exception ex){
            result = false;
            Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return result;
    }
    
    /**
     * Validate the answer if it's correct format or not
     * @param answer String
     * @param questionId Integer
     * @return boolean true -> valid, false -> invalid
     */
    public static boolean validateAnswer(String answer, int questionId){
        boolean result = true;
        try{
            switch (questionId) {
                case 0:
                    int ans1 = Integer.parseInt(answer);
                    if(ans1 <= 0){
                        throw new Exception("Must be a positive number");
                    } break;
                case 3:
                    int ans3 = Integer.parseInt(answer);
                    if(ans3 <= 0){
                        throw new Exception("Must be a positive number");
                    } break;
                case 1:
                    if(answer.length() == 0){
                        throw new Exception("Answer Must Not Be Empty");
                    }   break;
                default:
                    if(answer.length() == 0){
                        throw new Exception("Answer Must Not Be Empty");
                    }   break;
            }
        } catch(NumberFormatException ex){
            result = false;
            Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch(Exception ex){
            result = false;
            Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return result;
    }
}
