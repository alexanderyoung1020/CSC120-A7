/* This is a stub for the Library class */
import java.util.Hashtable; 

public class Library extends Building {
  private Hashtable<String, Boolean> collection; 
  private int nStudySpaces;
  private String specialCollection; 

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
    }

    public Library(String name, String address, int nFloors, int nStudySpaces){
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.nStudySpaces = nStudySpaces;
    }

    public Library(String name, String address, int nFloors, String specialCollection){
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.specialCollection = specialCollection;
    }


    
    public void addTitle(String title){
      this.collection.put(title, true);
    }
    public String removeTitle(String title){
      Boolean removed = this.collection.remove(title);
      if (removed == null){
        return null; 
      } else {
        return title; 
      }
    }
    public void checkOut(String title){
      this.collection.replace(title,false);

    }

    public void returnBook(String title){
      this.collection.replace(title, true);
    }

    public boolean containsTitle(String title){
      return collection.containsKey(title); 
    }

    public boolean isAvailable(String title){
      if (containsTitle(title)){
        return collection.get(title);
      } else {
        return false;
      }
    }
    
    public void printCollection(){
      for(String title: collection.keySet()){
        String status = collection.get(title) ? "Available" : "Checked out";
        System.out.println(title + ": " + status);
      }
    }
    public void showOptions(){
      super.showOptions();
      System.out.println("Available options at " + this.name + ":\n + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + containsTitle() \n + isAvailable(title) \n + printCollection()");
    }

    public void goToFloor(int floorNum) {
      try {
          if (floorNum < 1 || floorNum > this.nFloors) {
              throw new RuntimeException("Invalid floor number. Valid range for this Library is 1-" + this.nFloors + ".");
          }
          System.out.println("You are now on floor #" + floorNum + " of " + this.name);
          this.activeFloor = floorNum;
      } catch (RuntimeException e) {
          System.out.println("Error: " + e.getMessage());
      }
  }
    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "Neilson Drive", 4, 20);
      System.out.println(neilson);
      Library hillyer = new Library("Hillyer", "Elm Street", 2, "History of Smith");
      System.out.println(hillyer);
      neilson.goToFloor(4);
      hillyer.goToFloor(3);
    }
  
  }