package com.metacube.ds.assignment1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gaurav
 */
public class UniqueCharacters {
    
    private Map<String,Integer> cache;

    public UniqueCharacters() {
        cache = new HashMap<>();
    }
    
    /**
     * Count the unique characters in the string 
     * @param str String
     * @return count number of the unique characters in string
     */
    private int countCharacters(String str) {
        str = str.replaceAll("\\s+", "");
        int counter = 0;
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) <= 0) {
                counter++;
            }
            checker |= (1 << val);
        }
        return counter;
    }
    
    /**
     * Get the unique number of character in the string with the feature of caching 
     * If the same string is passed which was supplied earlier didn't have to calculated again.
     * Use of cache
     * @param string String
     * @return Number of unique characters
     */
    public int getUniqueCharacters(String string){
        int count = 0;
        string = string.trim().toLowerCase();
        
        if(string.length()>0) {
            if(cache.containsKey(string)) {
                count = cache.get(string);
            } else {
                count = countCharacters(string);
                cache.put(string,count);
            }
        }
        
        return count;
    }
}
