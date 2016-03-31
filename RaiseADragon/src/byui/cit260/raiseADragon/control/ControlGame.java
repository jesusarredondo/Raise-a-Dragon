/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.raiseADragon.control;

import byui.cit260.exceptions.BodyPartControlException;
import byui.cit260.exceptions.ControlGameException;
import byui.cit260.exceptions.InventoryControlException;
import byui.cit260.raiseADragon.model.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import raiseadragon.RaiseADragon;

/**
 *
 * @author Chuy
 */
public class ControlGame {

    public static void getSavedGame(String filePath) throws ControlGameException {
        Game game = null;
        
        try( FileInputStream fips = new FileInputStream (filePath)) {
            ObjectInputStream output = new ObjectInputStream(fips);
            
            game = (Game) output.readObject();
        }
        catch(FileNotFoundException fnfe) {
            throw new ControlGameException(fnfe.getMessage());
        }
        catch(Exception e) {
            throw new ControlGameException(e.getMessage());
        }
        
        RaiseADragon.setCurrentGame(game);
    }

    public void createNewGame(Player player) throws BodyPartControlException {
            
        Game game = new Game(); // create new game
        RaiseADragon.setCurrentGame(game); // save in Raise a Dragon
        
        game.setPlayer(player); // save player in game
        
        //create the inventory list and save in the game
        //Inventory[] inventoryList = ControlGame.createInventoryList();
        ArrayList<Inventory> inventoryList = ControlGame.createInventoryList();
        game.setInventory(inventoryList);
        
        this.initilizeSituations();
        
        Dragon dragon = new Dragon(); // create new dragon
        dragon=ControlDragon.initializeDragon(dragon);
        game.setDragon(dragon);
        game.getDragon().setName("Fonky");
        game.getDragon().setColor("Black");
        
        Map map = ControlMap.createMap(); // create and initialize new map
        game.setMap(map);
        
        
        RaiseADragon.setCurrentGame(game);
        //Move actors to starting point in the map
        //ControlMap.moveActorsToLocaiton();
        
    }
    
    public static ArrayList createInventoryList(){
        
        // created array(list) of inventory items
        ArrayList<Inventory> inventory =
                new ArrayList<Inventory>();
        
        Inventory food = new Inventory();
        food.setDescription("Gives Food");
        food.setAmountOfMoney(11.0);
        food.setQuantity(1);
        food.setName("food");
        inventory.add(food);
        
        Inventory ball = new Inventory();
        ball.setDescription("Dragon Loves Ball.");
        ball.setAmountOfMoney(3.0);
        ball.setQuantity(1);
        ball.setName("Ball");
        inventory.add(ball);
        
        Inventory medicine = new Inventory();
        medicine.setDescription("Cure Dragon of Pain or Ailment.");
        medicine.setAmountOfMoney(30.0);
        medicine.setQuantity(1);
        medicine.setName("Medicine");
        inventory.add(medicine);

        return inventory;
    }

    public static ArrayList getSortedInventoryList() {
        //System.out.println("THIS IS A WORK IN PROGRESS AND I WILL DESTROY ALL MANKIND.");
        ArrayList<Inventory> inventory = ControlGame.createInventoryList();
        //Inventory[] inventory = ControlGame.createInventoryList();
        return inventory;
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes){
        Location[][] locations = map.getLocations();
        
        //start point
        locations[0][0].setScene(scenes[SceneType.desert.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.forest.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.start.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.mountain.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.cave.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.store.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.house.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.river.ordinal()]);
    }
    
    public void initilizeSituations(){
        Situation[] situations = new Situation[10];
        
        situations[0]= this.setSituation("Fall", "Your Dragon has follen into a deep whole and "
                + "is now injured", 2, "negative");
        situations[1]= this.setSituation("", "Description 2", 0, "");
        situations[2]= this.setSituation("", "Description 3", 0, "");
        situations[3]= this.setSituation("", "Description 4", 0, "");
        situations[4]= this.setSituation("", "Description 5", 0, "");
        situations[5]= this.setSituation("", "Description 6", 0, "");
        situations[6]= this.setSituation("", "Description 7", 0, "");
        situations[7]= this.setSituation("", "Description 8", 0, "");
        situations[8]= this.setSituation("", "Description 9", 0, "");
        situations[9]= this.setSituation("", "Description 10", 0, "");
        
        RaiseADragon.getCurrentGame().setSituations(situations);
        
    }
    
    public Situation setSituation(String name, String description,
            int points, String type){
            
        Situation situation = new Situation();
        situation.setName(name);
        situation.setDescription(description);
        situation.setPoint(points);
        situation.setType(type);
        
        return situation;
    }

    public static void saveGame(Game currentGame, String filePath) throws ControlGameException {
        try(FileOutputStream fops = new FileOutputStream(filePath)){
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            Game game = new Game(); // create new game
        RaiseADragon.setCurrentGame(game); // save in Raise a Dragon
            
            output.writeObject(game);
            
        }catch(IOException e){
            throw new ControlGameException(e.getMessage());
        }
    }
}