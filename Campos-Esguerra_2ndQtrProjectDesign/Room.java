import java.util.List;

public class Room {
  private String name;
  private List<Room> neighbors;
  private boolean isLocked;

  public Room(String n) {
    this.name = n;
  }

  public Room(String n, boolean l){
    this.name = n;
    this.isLocked = l;
  }

  public void unlock() {
    if (this.getIsLocked() == true) {
      this.isLocked = false;
      System.out.println("Unlocked " + this.getName());
    } else {
      System.out.println("This door is already unlocked." + "\n");
    }
  }

  public void lock() {
    if (this.getIsLocked() == false) {
        this.isLocked = true;
      System.out.println("Locked " + this.getName());
    } else {
      System.out.println("This door is already unlocked." + "\n");
    }
  }

  // GETTERS ＼(＾▽＾)／

  public String getName() {
    return this.name;
  }

  public List<Room> getNeighbors() {
    return this.neighbors;
  }

  public void setNeighbors(List<Room> newneighbors) {
    this.neighbors = newneighbors;
  }

  public boolean getIsLocked() {
    return this.isLocked;
  }
}