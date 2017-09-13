package com.metacube.ds.assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Program which create a concordance of characters occurring in a string 
 * (i.e which characters occur where in a string)
 * @author Gaurav
 */
public class CharacterOccurrence {
    
    /**
     * Get Occurrence of characters in string at specific position
     * @param string String argument
     * @return Map containing the character and there occurrences with position in list 
     */
    public Map<Character,List<Integer>> getOccurrence(String string){
        Map<Character,List<Integer>> map = new HashMap<>();
        string = string.replace(" ", "");
        List<Integer> list;
        for(int index = 0; index < string.length(); index++){
            list = new ArrayList<>();
            char c = string.charAt(index);
            if(map.containsKey(c)){
                map.get(c).add(index);
                list.addAll(map.get(c));
                map.put(c, list);
            } else {
                list.add(index);
                map.put(c, list);
            }
        }
        
        return map;
    }
    
    public static void main(String[] args) {
        CharacterOccurrence obj = new CharacterOccurrence();
        String string = "Hello World";
        for(int index = 0; index < args.length; index++) { 
            string += args[index];
        }
        System.out.println(obj.getOccurrence(string));
    }
}
