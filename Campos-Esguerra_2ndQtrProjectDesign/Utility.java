public class Utility extends Item {
  final boolean TYPE = false;
  private Room attachedRoom;
  private String useMsg;

  public Utility(String n, String desc, Room loc, Room ar, String u) {
    super(n, desc, loc);
    this.attachedRoom = ar;
    this.useMsg = u;
  }

  // GETTERS ＼(＾▽＾)／

  public boolean getTYPE() {
    return this.TYPE;
  }

  public Room getAttachedRoom() {
    return this.attachedRoom;
  }

  public String getUseMsg() {
    return this.useMsg;
  }

}