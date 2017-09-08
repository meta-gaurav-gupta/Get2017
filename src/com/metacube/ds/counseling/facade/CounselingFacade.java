/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.counseling.facade;

import com.metacube.ds.counseling.dao.FileDao;
import com.metacube.ds.counseling.entity.Colleges;
import com.metacube.ds.counseling.entity.Student;
import com.metacube.ds.queue.Queue;
import com.metacube.ds.utils.Utility;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaurav
 */
public class CounselingFacade {

    private static CounselingFacade instance;

    private FileDao fDao;

    /**
     * Instantiates a new counseling facade.
     */
    private CounselingFacade() {
        fDao = new FileDao();
    }
    /**
     * Gets the single instance of CounselingFacade.
     *
     * @return single instance of CounselingFacade
     */
    public static CounselingFacade getInstance(){
        /**Double locking mechanism to make a singleton object**/
        if(instance==null){
            synchronized(CounselingFacade.class){
                if(instance==null){
                    instance = new CounselingFacade();
                }
            }
        }
        return instance;
    }

    /**
     * Gets the all student.
     *
     * @return the all student
     */
    public Queue<Student> getAllStudent(){
        Queue<Student> students = fDao.getAllStudent();
        Utility.sort(students);
        return students;
    }

    /**
     * Gets the all college.
     *
     * @return the all college
     */
    public Queue<Colleges> getAllCollege(){
        Queue<Colleges> colleges = null;
        try {
            colleges = fDao.getAllColleges();
        } catch (IOException ex) {
            Logger.getLogger(CounselingFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return colleges;
    }

    /**
     * This function store all the college details in a map corresponding to its rank as a key
     * @return 
     */
    public Map<Integer,Colleges> getCollegeDetails(){
        Queue<Colleges> colleges = getAllCollege();
        Colleges college; 
        Map<Integer,Colleges> collegeDetails = new HashMap<>();
        while(colleges.size()>0){
            college = colleges.dequeue();
            collegeDetails.put(college.getRank(),college);
        }
        
        return collegeDetails;
    }

    /**
     * Allot seats.
     *
     * @return the queue containing allotment details
     */
    public Queue<String> allotSeats(){
        Queue<String> result = new Queue<>();
        int totalSeats = Colleges.getTotal();
        int totalStudents = Student.getTotal();
        int[] choice;
        int seats = 0 , key = 0;
        getCollegeDetails();
        Queue<Student> students = getAllStudent();
        /*This loop runs till the seats or number of students is greater than zero*/
        while((students.size()>0) && (totalStudents>0) && (totalSeats>0)){
            Student student = students.dequeue();
            choice = student.getChoice();
            String allotment = null;
            Colleges college; 
            Map<Integer,Colleges> collegeDetails = getCollegeDetails();
            /*This loop will allot the seats according to the user choice*/
            for(int index = 0 ; index<choice.length ; index++){
                key = choice[index];
                if(collegeDetails.containsKey(key)){
                    college = collegeDetails.get(key);
                    seats = college.getSeats();
                    /*If number of seats in college is greater than the zero than allot one seat to student*/
                    if(seats>0){
                        /*allotment result*/
                        allotment = "Student Name = " + student.getName() + "\t Alloted College = ";
                        allotment += college.getName() +"\n";
                        seats = seats - 1;
                        college.setSeats(seats);
                        result.enqueue(allotment);
                        /*break the loop and give seat to another user*/
                        break;
                    }
                }
            }
        }
        return result;

    }
}
