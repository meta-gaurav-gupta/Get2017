
package com.metacube.oops;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaurav
 */
public class Survey {
    private Participant[] participants;
    
    /**
     * Start Survey
     * 1 - get questions 
     * 2 - display questions
     * 3 - get answers
     * 4 - store answers
     */
    public void startSurvey(){
        System.out.print("Enter Number Of Participants: ");
        Scanner in = new Scanner(System.in);
        Question questions = new Question();
        String path = "C:/Users/User/Documents/NetBeansProjects/OOPSAssignment2/src/com/metacube/oops/input.txt";
        ArrayList<String> listOfQuestions = questions.getQuestions(path);
        int numberOfParticipants = in.nextInt();
        try{
            if(numberOfParticipants <= 0){
                throw new Exception("Number of participants must be positive");
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
        in.nextLine();
        participants = new Participant[numberOfParticipants];
        for(int indexOfParticipants = 0 ; indexOfParticipants < numberOfParticipants ; indexOfParticipants++ ){
            participants[indexOfParticipants] = new Participant();
            System.out.println("Participant " + (indexOfParticipant + 1));
            String answer;
            for(String question : listOfQuestions){
                System.out.println(question);
                if(question.contains("Multi")){
                    System.out.println("Multiple Answer Must Be Separated With , (comma)");
                }
                answer = in.nextLine();
                boolean isValidAnswer;
                while(isValidAnswer = !Answer.validateAnswer(answer, listOfQuestions.indexOf(question), question)){
                    System.out.println("Enter Again: ");
                    answer = in.nextLine();
                }
                putAnswer(indexOfParticipants, answer, listOfQuestions.indexOf(question));
            }
        }
    }
    
    /**
     * Generate Report Type A
     * Display percentage distribution of participants’ choice for single select question
     */
    public void generateReportA(){
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Report A=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Overall Rating, Single Select, (1/2/3/4/5)");
        HashMap<Integer, Integer> answersFrequency = new HashMap<>();
        int sumOfAnswers = 0;
        for(Participant participant : participants){
            int ans = Integer.parseInt(participant.getSingleSelectAnswer());
            if(answersFrequency.containsKey(ans)){
                answersFrequency.put(ans, answersFrequency.get(ans) + 1);
            }
            else {
                answersFrequency.put(ans, 1);
            }
        }
        sumOfAnswers = answersFrequency.values().stream().map((value) -> value).reduce(sumOfAnswers, Integer::sum);
        for(int questionNumber = 1 ; questionNumber <= 5 ; questionNumber++ ){
            double percent = 0;
            if(answersFrequency.containsKey(questionNumber)){
                percent = (double)Math.round((double)answersFrequency.get(questionNumber)/sumOfAnswers*100);
            }
            System.out.println(questionNumber + " - " + percent + "%");
        }
    }
    
    /**
     * Generate Report Type B
     * Print all the questions and respective answer given by Participants
     */
    public void generateReportB(){
        System.out.println("\n\n");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Report B=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        int participantId = 0;
        for (Participant participant : participants){
            participant.putAnswersToFile(participant.getAnswersList(), participantId++);
        }
        ArrayList<String> answerFromFile = getAnswersFromFile();
        answerFromFile.forEach((output) -> {
            System.out.println(output);
        });
        
    }
    
    /**
     * Store the answers to the individual participant
     * @param participantId Integer
     * @param answer String
     * @param questionId Integer
     */
    private void putAnswer(int participantId, String answer, int questionId){
        Answer answers = new Answer();
        answers.setQuestionId(questionId);
        answers.setAnswer(answer);
        participants[participantId].putAnswer(answers);
    }
    
    /**
     * @return List of String containing the answers with the participants
     */
    private ArrayList<String> getAnswersFromFile(){
        ArrayList<String> Allanswers = new ArrayList<>();
        try {
            String path = "C:/Users/User/Documents/NetBeansProjects/OOPSAssignment2/src/com/metacube/oops/output.txt";
            FileInputStream IS = new FileInputStream(path);
            BufferedReader BR = new BufferedReader(new InputStreamReader(IS));
            String line;
            try {
                while((line = BR.readLine()) != null){
                    Allanswers.add(line);
                }   
            } catch (IOException ex) {
                Logger.getLogger(Question.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Question.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Allanswers;
    }
    
    
}
