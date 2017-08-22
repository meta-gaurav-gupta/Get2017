import java.util.Scanner;

import com.metacube.view.DisplayInput;

/**
 * The Class Main.
 *
 * @author Gaurav
 */

public class Main {

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * input object of Display Input Class
         */
        DisplayInput input = new DisplayInput();

        /**
         * Scanner Class Object to take input from console
         */
        Scanner scanner = new Scanner(System.in);

        /**Choice store user choice**/
        int choice=0;
        boolean flag;

        /**Logic for main application starts here**/
        while(true){

            /*Used to diplay menu*/
            input.displayMenu();
            flag = true;

            /*Taking input after showing menu*/
            while(flag){
                try{
                    choice = Integer.parseInt(scanner.nextLine());
                    if(choice>6 && choice<1){
                        /**If choice is not according to the menu**/
                        throw new IllegalArgumentException();
                    }
                    flag = false;
                } catch(IllegalArgumentException e) {
                    System.out.println("Enter a valid choice"+e);
                }
            }
            /*Perform action according to user choice*/
            switch(choice){
                case 1:{
                    input.printAllProducts();
                    break;
                }
                case 2:{
                    input.getInput();
                    break;
                }
                case 3:{
                    input.printCart();
                    break;
                }
                case 4:{
                    input.generateBill();
                    break;
                }
                case 5:{
                    input.deleteItem();
                    break;
                }
                case 6:{
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }
}
