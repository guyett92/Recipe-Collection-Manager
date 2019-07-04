package SteppingStones;

/**
 *
 * @author Aaron Guyett
 */

import java.util.Scanner;

public class SteppingStone2_IngredientCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Variable initialization with defaults */
        
        String nameOfIngredient = ""; //Ingredient Name
        float numberCups = (float) 0.0; //Number of cups
        int numberCaloriesPerCup = 0; //Calories per cup
        double totalCalories = 0.0; //Total calories
        
        /*
        * Program will use this variable to store unit of measurement
        *
        * String unitMeasurement = ""; //Stores unit of measurement
        */
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Please enter the name of the ingredient: ");
        nameOfIngredient = scnr.next();
        
        System.out.println("Please enter the number of cups of " + nameOfIngredient + " we'll need: ");
        numberCups = scnr.nextFloat();
        
        /* Prompts the user to input the unit of measurement
        *
        * System.out.println("Please enter the unit of measurement to be used: ");
        * unitMeasurement = scnr.next();
        */
        
        System.out.println("Please enter the number of calories per cup: ");
        numberCaloriesPerCup = scnr.nextInt();
        
        scnr.close();
        
        /* Calculate total calories */
        
        totalCalories = numberCups * numberCaloriesPerCup;
        
        System.out.println(nameOfIngredient + " uses " + numberCups + " cups and has " + totalCalories + " calories.");
    
    }
    
}
