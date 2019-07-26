package RecipeBox;

import java.util.*;

/**
 *
 * @author Aaron_Guyett
 * date 7/26/19
 * @version 3.0
 */

public class Recipe {
    
    //Initialize variables
    private String recipeName;
    private int servings;
    private ArrayList<Ingredient> recipeIngredients = new ArrayList();
    private int totalRecipeCalories;
    private ArrayList<String> recipeInstructions;
    
    /**
     * @return recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * @return the servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * @param servings the servings to set
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * @return the recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * @return the totalRecipeCalories
     */
    public int getTotalRecipeCalories() {

        return totalRecipeCalories;
    }

    /**
     * @param totalRecipeCalories the totalRecipeCalories to set
     */
    public void setTotalRecipeCalories(int totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    /**
    * @return the recipeInstructions
    */
    public ArrayList<String> getRecipeInstructions() {
        return recipeInstructions;
    }
    
    /**
     * @param recipeInstructions the recipeInstructions to set
     */
    
    public void setRecipeInstructions(ArrayList<String> recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }
    
    //Initialize constructor
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<>();
        this.totalRecipeCalories = 0;
        this.recipeInstructions = new ArrayList<>();
    }

    //Overloaded constructor
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients, int totalRecipeCalories, ArrayList<String> recipeInstructions){
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
        this.recipeInstructions = recipeInstructions;
    }
    
    //Custom method that prompts users to add instructions to the recipe
    public void addInstructions() {
        
        //Declare variables
        String instructions = "";
        boolean addMore = true;
        
        Scanner scnr = new Scanner(System.in);
        
        do {
            System.out.println("Please enter instructions or type 'end' to stop entering instructions.");
            instructions = scnr.nextLine();
            
            if (instructions.toLowerCase().equals("end")) {
                addMore = false;
            }
            else {
                recipeInstructions.add(instructions);
                addMore = true;
            }
        } while (addMore);
        
    }
    //Prints the recipe to the user
    public void printRecipe() {

        //Calculate single serving calories and cast to totalRecipeCalories to int
        int singleServingCalories = ((int)(getTotalRecipeCalories()) / getServings());

        //Print recipe information
        System.out.println("Recipe: " + getRecipeName() + "\nServes: " + getServings() + "\nIngredients: ");

        //For loop used to print ingredients and add them to a list
        for (int i = 0; i < getRecipeIngredients().size(); i++) {

            Ingredient ingredientList = getRecipeIngredients().get(i);
            
            //Formatted listing of ingredients, uses tabs to organize
            String list = ingredientList.nameOfIngredient + "\t" + ingredientList.ingredientAmount +
                   " " + ingredientList.unitMeasurement + "\t" + ingredientList.numberCaloriesPerUnit +
                   " calories \t" + ingredientList.totalCalories + " total calories";
            System.out.println("The instructions are as followed: ");
            //Use for loop to iterate through the instruction list
             for (int k = 0; k < recipeInstructions.size(); k++) {
            String instructions = recipeInstructions.get(k);
            System.out.println((k + 1) + ". " + instructions);
        }
            

            System.out.println(list);
        }
        System.out.println("Each serving has " + singleServingCalories + 
        " Calories for a total of " + (int)getTotalRecipeCalories() + " Calories.");

        
    }

    //Add a recipe to the collection manager
    public Recipe addNewRecipe() {
        
        //Define local variables
        ArrayList <Ingredient> recipeIngredients = new ArrayList();
        int servings;
        boolean addMoreIngredients = true;

        Scanner scnr = new Scanner(System.in);

        //Create a new object
        Ingredient newIngredient = new Ingredient();

        //Prompt user for the recipe name
        System.out.println("Please enter the recipe name: ");
        setRecipeName(scnr.nextLine());

        //Prompt user for the number of servings
        System.out.println("Please enter the number of servings: ");

        //Verify the input is an integer
        if (scnr.hasNextInt()) {
            servings = scnr.nextInt();
            
            //Give a second chance
            if (servings < 1 || servings > 100) {
                System.out.println(servings + " is not a valid number of servings. Please enter a positive integer: ");
                if(scnr.hasNextInt()) {
                     if (servings < 1 || servings > 100) {
                         System.out.println("That is not a valid number of servings. You are out of attempts.");
                     }
                     else {
                         setServings(servings);
                     }
                }
            }
            else {
                setServings(servings);
            }
        }
        //Prompt users to add instructions
        addInstructions();
        
        //Loop used to enter ingredients
        do {
            System.out.println("Would you like to enter an ingredient? (y for 'yes' or n for 'no')");
            
            //Take user input, case insensitive
            String yesOrNo = scnr.next().toLowerCase();
            
            //Switch used to add an ingredient based on user responses
            //Uses mutators to set
            switch (yesOrNo) {
                //When user responds with "y"
                case "y":
                    recipeIngredients.add(newIngredient.addIngredient());
                    //Sets total recipe calories
                    setTotalRecipeCalories(getTotalRecipeCalories() + newIngredient.totalCalories);
                    //Sets recipe ingredients
                    setRecipeIngredients(recipeIngredients);
                    break;
                //When user responds with "n"
                case "n":
                    addMoreIngredients = false;
                    break;
                //Whe input is invalid
                default:
                    System.out.println("Please enter 'y' for 'yes' or 'n' for 'no'.");
                    break;
            }
        } while (addMoreIngredients);
        
        //Create an instance of the object
        Recipe newRecipe = new Recipe(getRecipeName(), getServings(), recipeIngredients, getTotalRecipeCalories(), getRecipeInstructions());

        /**
         * @return newRecipe
        */
        return newRecipe;
    }
}