package Recipe;

/**
 *
 * @author Aaron_Guyett
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Recipe {
    
    //Define variables
    private String recipeName;
    private int servings;
    private ArrayList<String> recipeIngredients;
    private int totalRecipeCalories;
    
    //Setters and Getters
    
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    public String getRecipeName() {
        return recipeName;
    }
    
    public void setServings(int servings) {
        this.servings = servings;
    }
    
    public int getServings() {
        return servings;
    }
    
    public void setRecipeIngredients(ArrayList<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    
    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }
    
    public void setTotalRecipeCalories(int totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    public int getTotalRecipeCalories() {
        return totalRecipeCalories;
    }
    
    //Initialize Recipe constructor
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<String>();
        this.totalRecipeCalories = 0;
    }
    
    //Overloaded constructor
    public Recipe(String recipeName, int servings,
        ArrayList<String> recipeIngredients, int totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    //Method to print the recipe
    public void printRecipe() {
        
        //Define the number of single serving calories
        int singleServingCalories = (totalRecipeCalories / servings);
        
        //Print the recipe name, servings, and ingredients
        System.out.println("Recipe: " + recipeName);
        System.out.println("Serves: " + servings);
        System.out.println("Ingredients: ");
        
        //Loop used to iterate through the ingredients
        for (int i = 0; i < recipeIngredients.size(); i++) {
            String getIngredient = recipeIngredients.get(i);
            System.out.println(getIngredient);
        }
        
        //Print the number of calories per serving
        System.out.println("Each serving has " + singleServingCalories + " calories.");
    }
    
    //Method used to create a new recipe
    public Recipe createNewRecipe() {
        
        //Define variables
        int totalRecipeCalories = 0;
        ArrayList <String> recipeIngredients = new ArrayList();
        boolean addMoreIngredients = true;
        
        Scanner scnr = new Scanner(System.in);
        
        //Request the recipe name
        System.out.println("Please enter the recipe name: ");
        String recipeName = scnr.nextLine();
        
        //Request the number of servings
        System.out.println("Please enter the number of servings: ");
        int servings = scnr.nextInt();
        
        //Do-while loop used to add ingredients to the recipe
        do {
            System.out.println("Please enter the ingredient name or type \"end\" if you are finished entering ingredients: ");
            String ingredientName = scnr.next();
            
            //Will stop the loop if user inputs 'end'
            if (ingredientName.toLowerCase().equals("end")) {
                addMoreIngredients = false;
            }
            
            //Ingredients will otherwise be added to the recipe
            else {
                recipeIngredients.add(ingredientName);
                addMoreIngredients = true;
                
                //Request the ingredient amount
                System.out.println("Please enter the ingredient amount: ");
                int ingredientAmount = scnr.nextInt();
                
                //Request the number of calories
                System.out.println("Please enter the ingredient calories: ");
                int ingredientCalories = scnr.nextInt();
                
                //Calculate the total number of recipe calories
                totalRecipeCalories = (ingredientCalories * ingredientAmount);
            }
            
        } while (addMoreIngredients);
        
        //Print the recipe
        Recipe recipe1 = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);
        recipe1.printRecipe();
        return recipe1;
        
    }
}

/*
* Pseudocode needed to calculate recipe cost (Custom Method):
* DEFINE ingredientCost
* WHILE user is adding ingredients
*   PROMPT user for ingredient cost
* CALCULATE totalCost sum = ingredientCost * ingredientAmount
* PRINT totalCost to screen
*
* ingredientCost() will be a method but be accessed by printRecipe() to print
* the total cost of the recipe
*
*/

