
package com.metacube.oops;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaurav
 */
public class Question {
    /**
     * Get all questions from a file at once
     * @param path String path of file
     * @return List of String containing the questions
     */
    public ArrayList<String> getQuestions(String path){
        ArrayList<String> questions = new ArrayList<>();
        try {
            FileInputStream IS = new FileInputStream(path);
            BufferedReader BR = new BufferedReader(new InputStreamReader(IS));
            String line;
            while((line = BR.readLine()) != null){
                questions.add(line); 
            } 
        } catch (IOException ex) {
                Logger.getLogger(Question.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
    
}
