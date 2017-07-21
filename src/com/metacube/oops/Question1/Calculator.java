package com.metacube.oops.Question1;

import java.util.Scanner;

/**
 *
 * @author Gaurav
 */
public class Calculator implements Operations{
	
    /*
     * defination of addOperation
     * (non-Javadoc)
     * @see Question1.Operations#addOperation(double, double)
     */
    @Override
    public double addOperation(double firstOperand, double secondOperand) {
        double result = firstOperand + secondOperand;

        return result;
    }

    /*
     * defination of subtractOperation
     * (non-Javadoc)
     * @see Question1.Operations#subtractOperation(double, double)
     */
    @Override
    public double subtractOperation(double firstOperand, double secondOperand) {
        double result = firstOperand - secondOperand;

        return result;
    }

    /*
     * defination of multiplicationOperation
     * (non-Javadoc)
     * @see Question1.Operations#multiplicationOperation(double, double)
     */
    @Override
    public double multiplicationOperation(double firstOperand, double secondOperand) {
        double result = firstOperand * secondOperand;

        return result;
    }

    /*
     * defination of divisionOperation
     * (non-Javadoc)
     * @see Question1.Operations#divisionOperation(double, double)
     */
    @Override
    public double divisionOperation(double firstOperand, double secondOperand) {
        double result = firstOperand / secondOperand;

        return result;
    }

    /*
     * defination of modOperation
     * (non-Javadoc)
     * @see Question1.Operations#modOperation(double, double)
     */
    @Override
    public double modOperation(double firstOperand, double secondOperand) {
        double result = firstOperand % secondOperand;

        return result;
    }

    /*
     * defination of negation operation
     * (non-Javadoc)
     * @see Question1.Operations#negationOperation(double)
     */
    @Override
    public double negationOperation(double firstOperand) {
        double result = -firstOperand;

        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Display viewAnser = new Display();
        Buttons button = new Buttons();
        Scanner input = new Scanner(System.in);
        double firstOperand;
        double secondOperand;
        char choice;
        int userChoice;
        String currentAnswer = null;
        double answer = 0;

        do {
            System.out.println(button.showButton());
            System.out.println("Please Select Operation to Perform:");
            System.out.println("1-Addition");
            System.out.println("2-Subtraction");
            System.out.println("3-Division");
            System.out.println("4-Multiplication");
            System.out.println("5-Modulas");
            System.out.println("6-Negation");
            userChoice = input.nextInt();

            switch (userChoice){
            case 1:
                if(currentAnswer == null) {
                        // operation has no old answer
                    System.out.print("Please Enter The First Number: ");
                    firstOperand = input.nextDouble();
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.addOperation(firstOperand, secondOperand);
                } else {
                    // operation has old answer
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.addOperation(Double.parseDouble(currentAnswer), secondOperand);
                }
                break;

            case 2:
                if(currentAnswer == null) {
                    // operation has no old answer
                    System.out.print("Please Enter The First Number: ");
                    firstOperand = input.nextDouble();
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.subtractOperation(firstOperand, secondOperand);
                } else {
                    // operation has no old answer
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.subtractOperation(Double.parseDouble(currentAnswer), secondOperand);
                        }
                break;

            case 3:
                if(currentAnswer == null) {
                    // operation has no old answer
                    System.out.print("Please Enter The First Number: ");
                    firstOperand = input.nextDouble();
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.divisionOperation(firstOperand, secondOperand);
                } else {
                    // operation has no old answer
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.divisionOperation(Double.parseDouble(currentAnswer), secondOperand);
                }
                break;

            case 4:
                if(currentAnswer == null) {
                    // operation has no old answer
                    System.out.print("Please Enter The First Number: ");
                    firstOperand = input.nextDouble();
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.multiplicationOperation(firstOperand, secondOperand);
                } else {
                    // operation has no old answer
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.multiplicationOperation(Double.parseDouble(currentAnswer), secondOperand);
                }
                break;

            case 5:
                if(currentAnswer == null) {
                    // operation has no old answer
                    System.out.print("Please Enter The First Number: ");
                    firstOperand = input.nextDouble();
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.modOperation(firstOperand, secondOperand);
                } else {
                    // operation has no old answer
                    System.out.print("Please Enter The Second Number: ");
                    secondOperand = input.nextDouble();
                    answer = calculator.modOperation(Double.parseDouble(currentAnswer), secondOperand);
                }
                break;

            case 6:
                if(currentAnswer == null) {
                    // operation has no old answer
                    System.out.print("Please Enter The First Number: ");
                    firstOperand = input.nextDouble();
                    answer = calculator.negationOperation(firstOperand);
                } else {
                    // operation has no old answer
                    answer = calculator.negationOperation(Double.parseDouble(currentAnswer));
                }
                break;
            }

            currentAnswer = Double.toString(viewAnser.displayResult(answer));
            System.out.println(viewAnser.displayResult(answer));
            System.out.println("Want to continue with current Answer ? Y/N ");
            input.nextLine();
            choice = input.nextLine().charAt(0);

        } while(choice == 'y' || choice == 'Y');
        input.close();
    }
}
