public abstract class Item {
  private String name, description;
  private Room itemLocation;
  private boolean status;
  private boolean TYPE;

  public Item(String n, String desc, Room loc) {
    this.name = n;
    this.description = desc;
    this.itemLocation = loc;
    this.status = false; // not collected
  }

  // GETTERS ＼(＾▽＾)／

  public String getDescription() {
    return this.description;
  }

  public String getName() {
    return this.name;
  }

  public Room getLocation() {
    return this.itemLocation;
  }

  public boolean getStatus() {
    return this.status;
  }

  public boolean getTYPE() {
    return this.TYPE;
  }
}