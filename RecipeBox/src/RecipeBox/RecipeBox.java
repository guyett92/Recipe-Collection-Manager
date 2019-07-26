package RecipeBox;

import java.util.*;

/**
 *
 * @author Aaron_Guyett
 * date 7/26/19
 */
public class RecipeBox {

        //Instance variable for the array list
        public ArrayList<Recipe> listOfRecipes = new ArrayList<>();

        /**
         * @return the listOfRecipes
         */
        public ArrayList<Recipe> getListOfRecipes() {
            return listOfRecipes;
        }

        /**
         * @param listOfRecipes the listOfRecipes to set
         */
        public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
            this.listOfRecipes = listOfRecipes;
        }

        //Initialize constructor
        public RecipeBox() {
            this.listOfRecipes = new ArrayList<>();
        }

        //Overloaded constructor
        public RecipeBox(ArrayList<Recipe> listOfRecipes) {
            this.listOfRecipes = listOfRecipes;
        }
        
        //Print a selected recipe details
        public void printAllRecipeDetails(Recipe selectedRecipe) {

            //Loops through all elements in the list
            for (Recipe recipe : listOfRecipes) {
                
                //If the recipe is equal to the selected recipe, printRecipe()
                if (recipe.equals(selectedRecipe)) {
                    recipe.printRecipe();
                    return;
                }
            }
        }

        //Print the names of all the recipes
        public void printAllRecipeNames() {
            
            //Loops through the list of recipes
            for (int i = 0; i < listOfRecipes.size(); i++) {
            //Adds a number to each to organize the data
                int recipeNumber = i + 1;
                System.out.println(recipeNumber + ". " + listOfRecipes.get(i).getRecipeName());
            }
        }
        
        //Add a new recipe to the collection
        public void addRecipe() {
            Recipe newRecipe = new Recipe();
            listOfRecipes.add(newRecipe.addNewRecipe());
        }

        //Delete a recipe from the collection
        public void deleteRecipe(Recipe selectedRecipe) {
            
            //Value used to select a recipe to delete
            int delete = 0;
            
            //Loop through the list of recipes and takes the corresponding recipe and removes it
            for (Recipe recipe : listOfRecipes) {
                if (recipe.equals(selectedRecipe)) {
                    delete = listOfRecipes.indexOf(selectedRecipe);
                }
            }
            //Deletes Recipe
            listOfRecipes.remove(delete);
        }
}