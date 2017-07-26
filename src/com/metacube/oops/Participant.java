package com.metacube.oops;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaurav
 */
public class Participant {
    private ArrayList<Answer> answers;
    File file;
    FileWriter fw;
    BufferedWriter bw;
    
    /**
     * Constructor
     * Initialize the List of answers
     */
    public Participant() {
        answers = new ArrayList<>();
    }
    
    /**
     * Initialize the IO - get a single reference 
     * Writes to File
     */
    private void initFileWriter(){
        try {
            if(file == null  || bw ==  null || fw == null){
                file =new File("C:/Users/User/Documents/NetBeansProjects/OOPSAssignment2/src/com/metacube/oops/output.txt");
                if(!file.exists()){
                    file.createNewFile();
                }   fw = new FileWriter(file,true);
                bw = new BufferedWriter(fw);
            }
        } catch (IOException ex) {
            Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Put Answer in the List of answers
     * @param answer Answer(answer, questionId)
     */
    public void putAnswer(Answer answer){
        this.answers.add(answer);
    }
    
    /**
     * Get The Single Options Answer for the particular participant
     * @return String answer
     */
    public String getSingleSelectAnswer(){
        String result;
        try{
            if(answers.get(0).getQuestionId() != 0){
                throw new Exception();
            }
            result =  answers.get(0).getAnswer();
        } catch(IndexOutOfBoundsException ex){
            result = null;
            Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            result = null;
            Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /**
     * Store all the answer of the participant to file
     * @param listOfAnswers List of answers
     * @param participantId Id of participant
     */
    public void putAnswersToFile(ArrayList<Answer> listOfAnswers, int participantId){
        try {
            initFileWriter();
            String output = "Participant " + (participantId + 1) ;
            StringBuilder SB = new StringBuilder(output);
            listOfAnswers.forEach((answer) -> {
                SB.append(", ").append(answer.getAnswer());
            });
            SB.append(".\n");
            bw.write(SB.toString());
        } catch (IOException ex) {
                Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * @return List of all answer of the caller participant  
     */
    public ArrayList<Answer> getAnswersList(){
        return answers;
    }
}
