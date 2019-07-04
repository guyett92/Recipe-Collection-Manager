package SteppingStones;

/**
 *
 * @author Aaron Guyett
 */

import java.util.Scanner;

public class SteppingStone3_Branches {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        int numberCups = -1;
        final int MAX_CUPS = 100;
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Please enter the number of cups (between 1 and 100): ");
        
        //The following "if branch" uses the scanner method hasNextInt() to
        //check to see if the input is an int.
        if (scnr.hasNextInt()) {
            numberCups = scnr.nextInt();
            
            //Check to see if input is between 1 and 100 and print statement if it is
            if ((numberCups >= 1) && (numberCups <= MAX_CUPS)) {
                System.out.println(numberCups + " is a valid number of cups!");
            }
            
            //If input is invalid (outside of range) print statement and ask for input again
            else {
                System.out.println(numberCups + " is not a valid number of cups!");
                System.out.println("Please enter another number of cups between 1 and 100: ");
                
                if (scnr.hasNextInt()) {
                    numberCups = scnr.nextInt();
                    
                    //If the number is in range
                    if ((numberCups >= 1) && (numberCups <= MAX_CUPS)) {
                    System.out.println(numberCups + " is a valid number of cups!");
                    }
                    
                    //If the number is negative
                    else if (numberCups < 1) {
                        System.out.println(numberCups + " is less than 1. Sorry, you are out of attempts.");
                    }
                    
                    //If the number is greater than 100
                    else {
                        System.out.println(numberCups + " is greater than 100. Sorry, you are out of attempts.");
                    }
                }
                
                //If the input is not a number
                else {
                    System.out.println("Error: That is not a number. Sorry, you are out of attempts.");
                }
            }
        }
        
        //Print that the input is not a number and exit the program
        else {
        System.out.println("Error: That is not a number. Try again.");
    }
}
}