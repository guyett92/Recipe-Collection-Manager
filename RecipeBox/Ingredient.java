package RecipeBox;

import java.util.*;

/**
 *
 * @author Aaron_Guyett
 * date 6/7/20
 * @version 3.2
 */

public class Ingredient {
      
    //Initialize variables
    String nameOfIngredient;
    String unitMeasurement;
    double ingredientAmount;
    int numberCaloriesPerUnit;
    int totalCalories;
    public final double MIN_INGREDIENT_AMOUNT = 1.0;
    public final double MAX_INGREDIENT_AMOUNT = 500.0;
    public final int MIN_NUMBER_CALORIES_PER_UNIT = 1;
    boolean sysContinue = false;

    //Initialize constructor
    public Ingredient() {
        this.nameOfIngredient = "";
        this.ingredientAmount = 0;
        this.numberCaloriesPerUnit = 0;
        this.totalCalories = 0;
        this.unitMeasurement = "";
    }

    //Overloaded constructor
    public Ingredient(String nameOfIngredient, double ingredientAmount, 
            int numberCaloriesPerUnit, int totalCalories, String unitMeasurement) {
        this.nameOfIngredient = nameOfIngredient;
        this.ingredientAmount = ingredientAmount;
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
        this.totalCalories = totalCalories;
        this.unitMeasurement = unitMeasurement;
    }


    /**
     * @return nameOfIngredient name of the ingredient
     */
    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    /**
     * @param nameOfIngredient the nameOfIngredient to set
     * @return the name of the ingredient
     */
    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    /**
     * @return ingredientAmount
     */
    public double getIngredientAmount() {
        return ingredientAmount;
    }

    /**
     * @param ingredientAmount the ingredientAmount to set
     */
    public void setIngredientAmount(double ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    /**
     * @return numberCaloriesPerUnit 
     */
    public int getNumberCaloriesPerUnit() {
        return numberCaloriesPerUnit;
    }

    /**
     * @param numberCaloriesPerUnit the numerCaloriesPerUnitMeasurement to set
     */
    public void setNumberCaloriesPerUnit(int numberCaloriesPerUnit) {
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
    }

    /**
     * @return totalCalories
     */
    public double getTotalCalories() {
        return totalCalories;
    }

    /**
     * @param totalCalories the totalCalories to set
     */
    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    /**
     * @return unitMeasurement
     */
    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    /**
     * @param unitMeasurement the unitMeasurement to set
     */
    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    //Ingredient object used to create an ingredient
    public Ingredient addIngredient() {
        
        Scanner scnr = new Scanner(System.in);
        
        //Prompt user for the name of the ingredient
        System.out.print("Please enter the name of the ingredient.\n> ");
        nameOfIngredient =  scnr.next();
        setNameOfIngredient(nameOfIngredient);        
        
           //Do-while loop used to check if the options the user inputs are valid
            do{ System.out.print("Please enter the unit of measurement for " + nameOfIngredient + ". You may choose from the following options: Cups, Ounces, Teaspoons, Tablespoons, or Grams. Please enter one of the preceding below.\n> ");
                if (scnr.hasNext()) {
                    unitMeasurement = scnr.nextLine();
                    //If it is invalid
                    if (!"Cups".equalsIgnoreCase(unitMeasurement) && !"Ounces".equalsIgnoreCase(unitMeasurement) && !"Teaspoons".equalsIgnoreCase(unitMeasurement) && !"Tablespoons".equalsIgnoreCase(unitMeasurement) && !"Grams".equalsIgnoreCase(unitMeasurement)) {
                        sysContinue = false;                
                    }
                    //If input is valid
                    else {
                        setUnitMeasurement(unitMeasurement);
                        sysContinue = true;
                    }
                }
            } while (sysContinue == false);
            
        //Prompt user for the ingredient amount
        if(sysContinue) {
        System.out.print("Please enter the number of " + unitMeasurement + " of " + nameOfIngredient + " needed (between 1 and 500).\n> ");
        sysContinue = false;
    
        //Check to see if the input is a double
        if (scnr.hasNextDouble()) {
            ingredientAmount = scnr.nextDouble();
        
            //Check to see if input is between 1 and 500 and print statement if it is
            if ((ingredientAmount >= MIN_INGREDIENT_AMOUNT) && (ingredientAmount <= MAX_INGREDIENT_AMOUNT)) {
                System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + ".");
                setIngredientAmount(ingredientAmount);
                sysContinue = true;
            }
        
            //If input is out of range, print statement and ask for input again
            else {
                System.out.print(ingredientAmount + " is not a valid number of " + unitMeasurement + ".\nPlease enter a valid number of " + unitMeasurement + " (between 1 and 500).\n> ");
            
                if (scnr.hasNextDouble()) {
                    ingredientAmount = scnr.nextDouble();
                
                    //If the number is in range
                    if ((ingredientAmount >= MIN_INGREDIENT_AMOUNT) && (ingredientAmount <= MAX_INGREDIENT_AMOUNT)) {
                        System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + ".");
                        setIngredientAmount(ingredientAmount);
                        sysContinue = true;                        
                    }
                
                    //If the number is negative
                    else if (ingredientAmount < MIN_INGREDIENT_AMOUNT) {
                        System.out.println(ingredientAmount + " is less than 1. Sorry, you are out of attempts.");
                    }
                
                    //If the number is greater than 500
                    else {
                        System.out.println(ingredientAmount + " is greater than 500. Sorry, you are out of attempts.");
                        System.exit(0);
                    }
                }
            
                //If the input is not a number
                else {
                    System.out.println("Error: That is not a number. Sorry, you are out of attempts.");
                    System.exit(0);
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
        System.out.print("Please enter the number of calories per " + unitMeasurement + " of " + nameOfIngredient + " as a positive whole number.\n> ");
        sysContinue = false;
    
        //If user inputs an integer
        if (scnr.hasNextInt()) {
            numberCaloriesPerUnit = scnr.nextInt();
            
            //If the integer is positive, record the information and tell the system to continue
            if (numberCaloriesPerUnit > MIN_NUMBER_CALORIES_PER_UNIT) {
                System.out.println(numberCaloriesPerUnit + " is a valid number of calories.");
                setNumberCaloriesPerUnit(numberCaloriesPerUnit);
                sysContinue = true;
            }
            
            //If the input is negative
            else {
                System.out.print(numberCaloriesPerUnit + " is not a valid number of calories. Please enter a positive integer.\n> ");
                
                //User is given a second attempt
                if (scnr.hasNextInt()) {
                    numberCaloriesPerUnit = scnr.nextInt();
                    
                    if (numberCaloriesPerUnit > MIN_NUMBER_CALORIES_PER_UNIT) {
                        System.out.println(numberCaloriesPerUnit + " is a valid number of calories.");
                        setNumberCaloriesPerUnit(numberCaloriesPerUnit);
                        sysContinue = true;
                    }
                    else {
                        System.out.println(numberCaloriesPerUnit + " is not a valid number of calories. Sorry, you are out of attempts.");
                        System.exit(0);
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
    
    //Calculate total calories
    setTotalCalories((int) (getIngredientAmount() * getNumberCaloriesPerUnit()));
    
    //Inform about the calculations and inputs
    System.out.println("A recipe that uses " + getNameOfIngredient() + " will use " + getIngredientAmount() + " " + getUnitMeasurement() + " and adds " + getTotalCalories() + " total calories.");
    
    //Create instance of this object 
    Ingredient newIngredient = new Ingredient(getNameOfIngredient(), getIngredientAmount(), getNumberCaloriesPerUnit(), (int) getTotalCalories(), getUnitMeasurement());
    scnr.close();
        /**
         * @return the newIngrient object
         */
    return newIngredient;
    }
}

