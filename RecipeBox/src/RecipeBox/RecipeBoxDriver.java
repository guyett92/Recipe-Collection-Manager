package RecipeBox;

import java.util.*;

/**
 *
 * @author Aaron_Guyett
 * date 7/26/19
 */

public class RecipeBoxDriver {
    
    /**
     *
     * @param args Drive Class
     */
    public static void main(String[] args) {
        
        //Initialize variables
        RecipeBox newRecipeBox = new RecipeBox();
        Scanner menuScnr = new Scanner(System.in);
        boolean menuOn = true;

        //Created menu
        do {
            //Menu options
            System.out.println("Aaron Guyett's Recipe Box\nMain Menu\n1. Add a recipe.\n2. Print recipe details.\n3. List all recipe names.\n4. Delete a recipe.\n5. Exit the program.\nPlease make a selection.");
            
            //Create an int to control user selection
            int menuNumber;

            //If user enters an integer
            if (menuScnr.hasNextInt()) {
                menuNumber = menuScnr.nextInt();

                //Switch uses cases as menu options
                switch (menuNumber) {
                    
                    //Add a new recipe
                    case 1:
                        newRecipeBox.addRecipe();
                        break;
                    
                    //Print details of a recipe
                    case 2:
                            
                        if (newRecipeBox.listOfRecipes.size() >= 1) {

                            System.out.println("Choose a recipe from the list.\n");
                                
                            //Prints the list of recipes using numbers
                            newRecipeBox.printAllRecipeNames();
                            
                            //clear menu selection
                            int subMenuNumber;

                            if (menuScnr.hasNextInt()) {
                                subMenuNumber = menuScnr.nextInt();
                                
                                //The input is checked to see if the list contains it
                                if (subMenuNumber <= newRecipeBox.listOfRecipes.size() && subMenuNumber > 0) {
                                    //Prints recipe details
                                    newRecipeBox.printAllRecipeDetails(newRecipeBox.listOfRecipes.get(subMenuNumber - 1));
                                } 
                                else {
                                    //Improper input
                                    System.out.println("Invalid input.\n");
                                }
                            } 
                            else {
                                //Improper input
                                System.out.println("Invalid input.\n");
                                menuScnr.next();
                            }
                        } 
                        else {
                            //If the list is empty
                            System.out.println("There are no recipes in the list.\n");
                            break;
                        }
                        break;
                        
                    //List all the names of the recipes
                    case 3:
                        
                        //Check to see if there are recipes
                        if (newRecipeBox.listOfRecipes.size() >= 1) {
                            newRecipeBox.printAllRecipeNames();
                        }
                        //If there are no recipes
                        else {
                            System.out.println("There are no recipes in the list.\n");
                            break;
                        }
                        break;
                        
                    //Delete a recipe
                    case 4:
                        
                        //Check to see if there are recipes and prompts the user
                        if (newRecipeBox.listOfRecipes.size() >= 1) {
                            System.out.println("Choose a recipe to delete.");
                            newRecipeBox.printAllRecipeNames();
                            
                            //Create an int for user choices on the menu
                            int deleteMenu;
                            
                            //If the user entered an integer
                            if (menuScnr.hasNextInt()) {
                                deleteMenu = menuScnr.nextInt();
                                
                                //If the user chose a number in the menu, the recipe will be deleted
                                if (deleteMenu<= newRecipeBox.listOfRecipes.size() && deleteMenu > 0) {
                                    
                                    newRecipeBox.deleteRecipe(newRecipeBox.listOfRecipes.get(deleteMenu - 1));
                                    break;
                                }
                                //Invalid input
                                else {
                                    System.out.println("Invalid input.\n");
                                    break;
                                }
                            } 
                            //Invalid input
                            else {
                                System.out.println("Invalid input.\n");
                                menuScnr.next();
                            }
                        }
                        //If there are no recipes in the list
                        else {
                            System.out.println("There are no recipes in the list.\n");
                            break;
                        }
                    //The program is exited
                    case 5:
                        System.exit(0);
                        break;
                    //Invalid input
                    default:
                        System.out.println("Invalid input.\n");  
                        break;
                }
            }
            //If a number is not input
            else {
                System.out.println("That is not a number.\n");
                menuScnr.next();
            }
        } while (menuOn);
    }
}