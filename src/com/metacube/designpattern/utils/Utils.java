package com.metacube.designpattern.utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility Class
 */
public class Utils {
    /**
     * read the CSV file 
     * @param filepath
     * @return List of lines in file
     */
     public static ArrayList<String> readCsvFile(String filepath) {
        BufferedReader fileReader = null;
        ArrayList<String> productDetails = new ArrayList<>();
        String line;
        try {
            fileReader = new BufferedReader(new FileReader(filepath));
            
            while ((line = fileReader.readLine()) != null) {
                productDetails.add(line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, ex.getMessage());
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, ex.getMessage());
                }
            }
        }
        return productDetails;
    }
	
}
