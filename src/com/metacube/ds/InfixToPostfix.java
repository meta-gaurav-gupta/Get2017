package com.metacube.ds;

import com.metacube.ds.stack.Stack;

/**
 *
 * @author Gaurav
 */
public class InfixToPostfix {
    
    private Stack operators = new Stack();
    
    /**
     * Return the postfix expression of the give infix expression
     * @param infix String
     * @return postfix expression String
     */
    public String toPostfix(String infix) {
        char symbol;
        String postfix = "";

        for(int index = 0; index < infix.length(); index++) {
            symbol = infix.charAt(index);
            
            if (isLetter(symbol)) {
                postfix = postfix + symbol;
            } else if (symbol=='(') {
                operators.push(symbol);
            } else if (symbol==')') {
                while (!operators.peek().equals('(')) {
                    postfix = postfix + operators.pop();
                }
                operators.pop();
            }
            else {
                while (!operators.isEmpty() && !(operators.peek().equals('(')) && precedence(symbol) <= precedence((char)operators.peek())) {
                    postfix = postfix + operators.pop();
                }
                
                operators.push(symbol);
            }
        }
        while (!operators.isEmpty()) {
            postfix = postfix + operators.pop();
        }
        return postfix;
    }
	
    /**
     * Return the precedence value of the give operator  
     * @param operator char 
     * @return integer 1 if the operator has lower precedence, 2 if the operator has higher precedence
     */
    private int precedence(char operator) {
        if (operator == '+' || operator == '-')
                return 1;
        if (operator == '*' || operator == '/' || operator == '%')
                return 2;
        return 0;
    }
    
    /**
     * Return true if the given symbol is letter
     * @param symbol char
     * @return true if the symbol is letter, else false
     */
    private boolean isLetter(char symbol) {
        return (symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z');
    }
    
}
