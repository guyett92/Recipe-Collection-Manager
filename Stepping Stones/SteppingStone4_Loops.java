package SteppingStones;

/**
 *
 * @author Aaron_Guyett
 */

import java.util.Scanner;
import java.util.ArrayList;


public class SteppingStone4_Loops {

    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        String recipeName = "";
        ArrayList<String> ingredientList = new ArrayList();
        String newIngredient = "";
        boolean addMoreIngredients = true;
        
        System.out.println("Please enter the recipe name: ");
        recipeName = scnr.nextLine();
        
        do {
            
            System.out.println("Would you like to enter an ingredient: (y or n)");
            String reply = scnr.next().toLowerCase();
             
            //Create condition for user entering "y" or "Y"
             if(reply.equals("y")) {
                 
                 //Prompt user to add ingredient
                 System.out.print("Please enter ingredient name: ");
                 
                 //Take ingredient from user and add it to new ingredient
                 newIngredient = scnr.nextLine();
                 
                 //Add ingredient to array list
                 ingredientList.add(newIngredient);
                 
               //If user enters "n" or "N"
             } else if(reply.equals("n")) {
                 
                 //Exit loop by changing boolean
                 addMoreIngredients = false;
                 
               //If user enters any other value 
             } else {
                 
                 //Tell user value is incorrect
                 System.out.println("Sorry, you entered an incorrect value.");
                 
             }
             
             
        } while (addMoreIngredients);
        
        for (int i = 0; i < ingredientList.size(); i ++) {
        
            //Get item i from the ingredient list and assign it to a string
            String ingredient = ingredientList.get(i);
            System.out.println(ingredient);
            
        }
    }
    
}
