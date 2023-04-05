/* This is a stub for the House class */
import java.util.ArrayList;
public class House extends Building {
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;
  protected boolean hasElevator;


  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;

    System.out.println("You have built a house: 🏠");
  }

  public House(String name, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, "Smith College", nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;

    System.out.println("You have built a house: 🏠");
  }

  public House(String name, String address, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, 2);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = false;

    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  public int nResidents() {
    return residents.size();
  }

  public void moveIn(String name) {
    residents.add(name);
  }

public String moveOut(String name) {
    residents.remove(name);
    return name;
  }

public boolean isResident(String person) {
    return residents.contains(person);
  }

public void showOptions(){
  super.showOptions();
  System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn(name) \n + moveOut(name)\n + isResident(person)");
}

public void goToFloor(int floorNum) {
  try {
      if (this.hasElevator = false) {
          throw new RuntimeException("You cannot move between non-adjacent floors without an elevator.");
      } else if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this House is 1-" + this.nFloors + ".");
      } else {
          System.out.println("You are now on floor #" + floorNum + " of " + this.name);
          this.activeFloor = floorNum;
      }
  } catch (RuntimeException ex) {
      System.out.println("An error occurred: " + ex.getMessage());
  }
}

  public static void main(String[] args) {
    House king = new House("King", "elm street", true, true);
    System.out.println(king);
    king.goToFloor(2);
    House chapin = new House("Chapin", 2, true, false);
    System.out.println(chapin);
    chapin.goToFloor(3);
  }

}