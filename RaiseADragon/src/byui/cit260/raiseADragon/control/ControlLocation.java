/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.raiseADragon.control;

import byui.cit260.raiseADragon.model.Location;

/**
 *
 * @author Chuy
 */
public class ControlLocation {
    
    /**
     *
     * @param locationNumber
     * @param positionInMap
     * @param name
     * @param newLocation
     * @return
     */

    
    public double moveToLocation(int locationNumber, int positionInMap, Location name, String newLocation) {
        
        //Find out if the selected location is null
        if(newLocation==null){
            return -1;
        }
        
        //Find out if the current location is the same as the destination input
        if(locationNumber==positionInMap){
            return -1;
        }
        
        //Find out if the location is within the parameters of places to go
        if(locationNumber < 0 || locationNumber > 25){
            return -1;
            
        }
        
        //Create a dependant variable to act as a return value.
        double newMapPosition;
        newMapPosition = locationNumber;
        
        return newMapPosition;
    }
    
    public Location setLocation (String name){
        
        Location location = new Location();
        location.setName(name);
        
        return location;
    }

    public void movetoHouse() {
        System.out.println("\nYou have been moved to Your House");
    }

    public void movetoStore() {
        System.out.println("\nYou have been moved to the Store");
    }

    public void movetoForest() {
        System.out.println("\nYou have been moved to the Forest");
    }

    public void movetoMountain() {
        System.out.println("\nYou have been moved to the Mountain");
    }

    public void movetoDesert() {
        System.out.println("\nYou have been moved to the Desert");
    }

    public void movetoCave() {
        System.out.println("\nYou have been moved to the Cave");
    }
    
}

