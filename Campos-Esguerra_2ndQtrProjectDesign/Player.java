import java.util.ArrayList;

public class Player {
  String customName;
  Room Location;
  ArrayList<Item> inventory;
  Scenario CurrentScenario;
  int progress = 0;

  public Player(String cn) {
    this.customName = cn;
    System.out.printf("Your name is %s.%n", cn);
    this.inventory = new ArrayList<Item>();
  }

  public Player(String cn, Room loc) {
    this.customName = cn;
    System.out.printf("Your name is %s.%n", cn);
    this.Location = loc;
    this.inventory = new ArrayList<Item>();
  }

  public void move(Room loc) throws LockedRoomException {
    if (loc.getIsLocked() == true) {
      throw new LockedRoomException("That room is locked. %n");
    } else if (loc.getNeighbors().contains(this.Location)) {
      this.Location = loc;
      System.out.printf("%s moved to %s. %n", this.customName, loc.getName());
    }
  }

  public void inspect(Item i) {
    if (inventory.contains(i)) {
      System.out.println(i.getDescription());
    } else {
      System.out.println("That isn't in your inventory.");
    }

  }

  public void collect(Item i) throws InventoryFullException, UncollectableItemException {
    if (this.inventory.size() < 5 && i.getLocation() == this.getLocation() && i.getLocation().getIsLocked() == false) {
      inventory.add(i);
      if (i.getTYPE() == true) {
        System.out.println("Congratulations! You have collected a major item." + "\n");
        System.out.println("You have collected " + this.progress + " major items so far." + "\n");
      } else {
        System.out.println("Collected " + i.getName() + ".");
      }
    } else if(this.inventory.size() >= 5){
      throw new InventoryFullException("Your inventory is full.");
    } else{
      throw new UncollectableItemException("You cannot collect that item.");
    }
  }

  public void use(Utility u) throws UnusableInRoomException{
    if(inventory.contains(u) && u.getAttachedRoom().getNeighbors().contains(this.Location)) {
      System.out.println("You used " + u.getName() + ".");

    if(u.getAttachedRoom().getIsLocked() == false){
      System.out.println("It's already unlocked.");
    } else if(u.getAttachedRoom().getIsLocked() == true){
      u.getAttachedRoom().unlock();
      System.out.println(u.getUseMsg()); 
    }
  
      
    } else if (!u.getAttachedRoom().getNeighbors().contains(this.Location)){
      throw new UnusableInRoomException("You can't use that in this room.");
    }

  }

  public void use(MajorItem i) throws UnusableItemException{
    throw new UnusableItemException("You cannot use this item.");
  }

  public void sleep() {
    System.out.println(this.customName + " goes to sleep." + "\n");
    System.exit(0); // will make this more elaborate later on but all sleep does kills the program
  }

  public Room getLocation(){
    return this.Location;
  }
}