
package ingredient;

/**
 *
 * @author Aaron Guyett
 * @date June 30, 2019
 */

import java.util.Scanner;

public class ingredient {
    
    public static void main(String[] args) {
    
    //Intialize variables
    String nameOfIngredient = ""; //Ingredient name
    float ingredientAmount = (float) 0.0; //Number of unit measurement units
    int numberCaloriesPerUnit= 0; //Number of calories per unit
    double totalCalories = 0.0; //Total calories in an ingredient
    String unitMeasurement = ""; //Unit of measurement
    Boolean sysContinue = false; //Boolean used to stop the program if needed
    
    Scanner scnr = new Scanner(System.in);
    
    //Prompt user for the name of the ingredient
    System.out.println("Please enter the name of the ingredient: ");
    nameOfIngredient = scnr.nextLine();
    
    //Prompt user for a unit of measure
    System.out.println("Please enter an appropriate unit of measurement. You may choose from the following options: Cups, Ounces, Teaspoons, Tablespoons, or Grams. Please enter one of the preceding below: ");
    if (scnr.hasNext()) {
        unitMeasurement = scnr.nextLine();
        
        //Check to see if the unit is not one of the choices and prompt the user again (case insensitive)
        if (!"Cups".equalsIgnoreCase(unitMeasurement) && !"Ounces".equalsIgnoreCase(unitMeasurement) && !"Teaspoons".equalsIgnoreCase(unitMeasurement) && !"Tablespoons".equalsIgnoreCase(unitMeasurement) && !"Grams".equalsIgnoreCase(unitMeasurement)) {
            System.out.println(unitMeasurement + " is not a valid unit of measurement. Please enter cups, ounces, teaspoons, tablespoons, or grams: ");
            
            //User is given a second attempt
            if (scnr.hasNext()) {
                unitMeasurement = scnr.nextLine();
                
                if (!"Cups".equalsIgnoreCase(unitMeasurement) && !"Ounces".equalsIgnoreCase(unitMeasurement) && !"Teaspoons".equalsIgnoreCase(unitMeasurement) && !"Tablespoons".equalsIgnoreCase(unitMeasurement) && !"Grams".equalsIgnoreCase(unitMeasurement)) {
                    System.out.println(unitMeasurement + " is not a valid unit of measurement. Sorry, you are out of attempts.");
                }
                else {
                    System.out.println(unitMeasurement + " is a valid unit of measurement.");
                    sysContinue = true;
                }
            }
        }
        //If it is a valid choice, add it to unit measurement and set the Boolean to true
        else {
            System.out.println(unitMeasurement + " is a valid unit of measurement.");
            sysContinue = true;
        }
    } else {
        System.out.print("");
    }
    //Prompt user for the number of calories per unit and set the Boolean to false
    if(sysContinue) {
        System.out.println("Please enter the number of " + unitMeasurement + " of " + nameOfIngredient + " needed (between 1 and 500): ");
        sysContinue = false;
    
        //Check to see if the input is a float
        if (scnr.hasNextFloat()) {
            ingredientAmount = scnr.nextFloat();
        
            //Check to see if input is between 1 and 500 and print statement if it is
            if ((ingredientAmount >= 1.0) && (ingredientAmount <= 500.0)) {
                System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + ".");
                sysContinue = true;
            }
        
            //If input is out of range, print statement and ask for input again
            else {
                System.out.println(ingredientAmount + " is not a valid number of " + unitMeasurement + ".\nPlease enter a valid number of " + unitMeasurement + " (between 1 and 500): ");
            
                if (scnr.hasNextFloat()) {
                    ingredientAmount = scnr.nextFloat();
                
                    //If the number is in range
                    if ((ingredientAmount >= 1.0) && (ingredientAmount <= 500.0)) {
                        System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + ".");
                        sysContinue = true;
                    }
                
                    //If the number is negative
                    else if (ingredientAmount < 1.0) {
                        System.out.println(ingredientAmount + " is less than 1. Sorry, you are out of attempts.");
                    }
                
                    //If the number is greater than 500
                    else {
                        System.out.println(ingredientAmount + " is greater than 500. Sorry, you are out of attempts.");
                    }
                }
            
                //If the input is not a number
                else {
                    System.out.println("Error: That is not a number. Sorry, you are out of attempts.");
                }
            
            }
        }
    
    //If the input is not a number
    else {
        System.out.println("Error: That is not a number. Try again.");
    }
    }
    
    //Prompt user for the number of calories per unit and set the Boolean to false
    if (sysContinue) {
        System.out.println("Please enter the number of calories per " + unitMeasurement + " of " + nameOfIngredient + ": ");
        sysContinue = false;
    
        //If user inputs an integer
        if (scnr.hasNextInt()) {
            numberCaloriesPerUnit = scnr.nextInt();
            
            //If the integer is positive, record the information and tell the system to continue
            if (numberCaloriesPerUnit > 0) {
                System.out.println(numberCaloriesPerUnit + " is a valid number of calories.");
                sysContinue = true;
            }
            
            //If the input is negative
            else {
                System.out.println(numberCaloriesPerUnit + " is not a valid number of calories. Please enter a positive integer: ");
                
                //User is given a second attempt
                if (scnr.hasNextInt()) {
                    numberCaloriesPerUnit = scnr.nextInt();
                    
                    if (numberCaloriesPerUnit > 0) {
                        System.out.println(numberCaloriesPerUnit + " is a valid number of calories.");
                        sysContinue = true;
                    }
                    else {
                        System.out.println(numberCaloriesPerUnit + " is not a valid number of calories. Sorry, you are out of attempts.");
                    }
                }
                
            }
        }
    
        //If user does not input an integer
        else {
            System.out.println("Error: That is not a number. Try again.");
        }
    } else {
        System.out.print("");
    }
    
    
    //Calculate the total calories
    totalCalories = ingredientAmount * numberCaloriesPerUnit;
    
    //Continue
    if (sysContinue) {
        
    //Inform user of the success of the added ingredient
    System.out.println(nameOfIngredient + " has been added to the recipe collection successfully.");
    
    //Inform user about the calculations and inputs
    System.out.println("A recipe that uses " + nameOfIngredient + " will use " + ingredientAmount + " " + unitMeasurement + " which contains " + totalCalories + " total calories." );
    
    } else {
        System.out.print("");
    }
}   
}
