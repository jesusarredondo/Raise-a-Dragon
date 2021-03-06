/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.raiseADragon.view;

import byui.cit260.raiseADragon.control.ControlLocation;
import byui.cit260.raiseADragon.model.Location;
import java.util.Scanner;
/**
 *
 * @author John
 */
public class MapView extends View {
            
    public MapView(){
                super("\n"
                    + "\n-------------------------------------------------------------"
                    + "\n| Map Menu                                                |"
                    + "\n-------------------------------------------------------------"
                    + "\nV - View Map"
                    + "\nG - Get Information on Current Location"
                    + "\nM - Move to New Location"
                    + "\nE - Exit"
                    + "\n-------------------------------------------------------------");
    }
            
            public boolean doAction(String value, int[] controlCurrentLocation) {
                switch (value.charAt(0)) {
                    case 'V': // View the world map
                            this.displayMap();
                            break;
                    case 'G': // View information on current location
                            this.getLocationInfo(controlCurrentLocation);
                            break;
                    case 'M': // Move to New Location
                            this.getMove();
                            break;
                    case 'E': //Exit the menu
                            return true;
                    default:
                            console.println("\n*** Invalid Selection *** Try again");
                            break;
                }
                return false;
            }

    private void displayMap() {
        MapFullView map = new MapFullView();
        map.viewFullMap();
    }

    private void getLocationInfo(int[] controlCurrentLocation) {
        LocationDetailView locationInfo = new LocationDetailView();
        locationInfo.locationDetails(controlCurrentLocation);
    }

    private void getMove() {
        NewLocationView move = new NewLocationView();
        move.display();
    }

    @Override
    public boolean doAction(String Value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
