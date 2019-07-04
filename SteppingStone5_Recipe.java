package SteppingStones;

/**
 *
 * @author Aaron_Guyett
 */

import java.util.Scanner;
import java.util.ArrayList;


public class SteppingStone5_Recipe {

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
    
    public void setServings (int servings) {
        this.servings = servings;
    }
    
    public int getServings() {
        return servings;
    }
    
    public void setRecipeIngredients (ArrayList<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    
    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }
    
    public void setTotalRecipeCalories(int totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }
     
    //Constructor creates new objects
    public SteppingStone5_Recipe() {
        this.recipeName = "";
        this.servings = 0; //Assigned with integer value
        this.recipeIngredients = new ArrayList<String>(); //Empty array list
        this.totalRecipeCalories = 0;
        
    }
    
    //Overloaded constructor
    public SteppingStone5_Recipe(String recipeName, int servings, 
    	ArrayList<String> recipeIngredients, int totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    //Print the recipe method
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
        
        //Print the amount of calories per serving
        System.out.println("Each serving has " + singleServingCalories + " calories.");
    }
    
    
    public static void main(String[] args) {
        
        //Define variables
        int totalRecipeCalories = 0;
        ArrayList <String> recipeIngredients = new ArrayList();
        boolean addMoreIngredients = true;
        
        Scanner scnr = new Scanner(System.in);
        
        //Request recipe name
        System.out.println("Please enter the recipe name: ");
        String recipeName = scnr.nextLine();
        
        //Request the number of servings
        System.out.println("Please enter the number of servings: ");
        int servings = scnr.nextInt(); 
        
        //Do-while loop used to add ingredients  
        do {
            System.out.println("Please enter the ingredient name or type \"end\" if you are finished entering ingredients: ");
            String ingredientName = scnr.next();
            
            //Stop the loop
            if (ingredientName.toLowerCase().equals("end")) {
                addMoreIngredients = false;
            } 
            //Add more ingredients to the recipe
            else {
                recipeIngredients.add(ingredientName);
                addMoreIngredients = true;
                
                //Request ingredient amount
                System.out.println("Please enter the ingredient amount: ");
                int ingredientAmount = scnr.nextInt();
                
                //Request the ccalories
                System.out.println("Please enter the ingredient calories: ");
                int ingredientCalories = scnr.nextInt();
                
                //Calculate total recipe calories
                totalRecipeCalories = (ingredientCalories * ingredientAmount);
            
            }
           
       } while (addMoreIngredients);
        
        //Print the recipe
        SteppingStone5_Recipe recipe1 = new SteppingStone5_Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);
        recipe1.printRecipe();
    }
}