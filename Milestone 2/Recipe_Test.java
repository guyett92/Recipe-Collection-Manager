package Recipe;

/**
 *
 * @author Aaron_Guyett
 */
public class Recipe_Test {

    public static void main(String[] args) {
        
        //Initialize Constructor
        final Recipe newRecipe = new Recipe();
        
        //Invoke createNewRecipe method to prompt the user for input
        Recipe createNewRecipe = newRecipe.createNewRecipe();
        
        //Invoke printRecipe to print the recipe
        newRecipe.printRecipe();
    }
    
}
