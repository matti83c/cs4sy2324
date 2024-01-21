public class MajorItem extends Item {
  final boolean TYPE = true;
  private Scenario attachedScenario;

  public MajorItem(String n, String desc, Room loc, Scenario s) {
    super(n, desc, loc);
    this.attachedScenario = s;
  }

  public MajorItem(String n, String desc, Room loc) {
    super(n, desc, loc);
  }

  // GETTERS ＼(＾▽＾)／

  public Scenario getattachedScenario() {
    return this.attachedScenario;
  }
}