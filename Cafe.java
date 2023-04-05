/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    protected int activeFloor = 1;
    
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups; 
    }

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        // this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups; 
    }

    
    /**

    Creates a Cafe object with the specified name, address, number of floors, and initial inventory quantities.
    @param name the name of the cafe
    @param address the address of the cafe
    @param nFloors the number of floors in the building
    @param nCoffeeOunces the number of ounces of coffee initially in inventory
    @param nSugarPackets the number of sugar packets initially in inventory
    @param nCreams the number of "splashes" of cream initially in inventory
    @param nCups the number of cups initially in inventory
*/
    private void sellCoffee(int size, int sugar, int creams) {
        if (nCoffeeOunces < size || nSugarPackets < sugar || nCreams < creams || nCups < 1 || size > nCups) {
            restock(50, 100, 100, 50);
        }
        nCoffeeOunces -= size;
        nSugarPackets -= sugar;
        nCreams -= creams;
        nCups -= 1;
    }

    private void sellCoffee(double size, double sugar, double creams){
        if (nCoffeeOunces < size || nSugarPackets < sugar || nCreams < creams || nCups < 1 || size > nCups) {
            restock(50, 100, 100, 50);
        }
        nCoffeeOunces -= size;
        nSugarPackets -= sugar;
        nCreams -= creams;
        nCups -= 1;
    }

    private void restock (int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups; 
    }

    public void showOptions(){
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + restock()");
      }

     

    public void goToFloor(int floorNum) {
        try {
            if (this.activeFloor == -1) {
                throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
            }
            if (floorNum != 1) {
                throw new RuntimeException("Invalid floor number. This Cafe only accessible at the first floor.");
            }
            System.out.println("You are already on the first floor of " + this.name);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
       Cafe cc = new Cafe("CC", "100 Elm", 1, 20, 20, 20);
        System.out.println(cc);
        Cafe compass = new Cafe("Compass", "100 Neilson", 2, 20, 20, 20);
        System.out.println(compass);
        compass.sellCoffee(5.5, 5.5, 5.5);
        compass.goToFloor(1);
        compass.goToFloor(2); 
    }
    
}
