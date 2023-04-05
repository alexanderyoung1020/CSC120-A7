import java.util.ArrayList;
import java.util.Scanner; 

public class CampusMap extends Building {

    ArrayList<Building> buildings;
    Scanner scanner;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */

    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }


    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    
    
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Baldwin House", "15 Bedford Terrace", 4, false, false) );
        myMap.addBuilding(new House("Sessions House", "105 Elm Street", 3, false, false));
        myMap.addBuilding(new House("Tyler House", "150 Green Street", 4, true, false));
        myMap.addBuilding(new Library("Josten Library", "122 Green Street", 2, 5));
        myMap.addBuilding(new Building("Campus Center", "100 Elm Street", 3));
        myMap.addBuilding(new Cafe("Compass Cafe", "1 Neilson Drive", 100, 100, 100, 100, 100));
        myMap.addBuilding(new Building("College Hall", "10 Elm Street", 3));
        myMap.addBuilding(new Building("Smith College Museum of Art", "20 Elm Street", 4));
    
    }
    
}

