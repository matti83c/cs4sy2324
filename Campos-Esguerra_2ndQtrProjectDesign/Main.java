import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // will focus on hardcoding first to accomplish the three scenarios

    int chosenScenario = 1;

    // creating instances
    Scanner sc = new Scanner(System.in);

    Room Bedroom = new Room("bedroom");
    Room BedroomCloset = new Room("closet");
    Room Hallway = new Room("hallway");
    Room Kitchen = new Room("kitchen");
    Room Livingroom = new Room("living room");
    Room LivingroomSofa = new Room("sofa");
    Room LivingroomLockbox = new Room("lockbox", true);

    Bedroom.setNeighbors(Arrays.asList(BedroomCloset, Hallway));
    BedroomCloset.setNeighbors(Arrays.asList(Bedroom));
    Hallway.setNeighbors(Arrays.asList(Bedroom, Kitchen, Livingroom));
    Kitchen.setNeighbors(Arrays.asList(Hallway));
    Livingroom.setNeighbors(Arrays.asList(Hallway, LivingroomSofa, LivingroomLockbox));
    LivingroomSofa.setNeighbors(Arrays.asList(Livingroom));
    LivingroomLockbox.setNeighbors(Arrays.asList(Livingroom, LivingroomSofa));

    // wasnt able to figure out how to do this with ArrayLists without taking up
    // multiple lines per initialization
    // (which is messy and probably wont work for the final project)
    // so Lists are used instead of ArrayLists to allow for single-line
    // initialization

    // Note: You cant just declare the neighbors in the constructor cuz then you'd
    // be referencing
    // variables that do not yet exist (no idea how to get around this)

    Utility Glass = new Utility("glass", "This is a glass! Named after what it’s made out of. You drink from it.",
        Kitchen, Kitchen, "You took a drink.");
    MajorItem Cellphone = new MajorItem("cellphone",
        "This is a cellphone. It's an old Nokia, with number pads and everything.", LivingroomLockbox);
    MajorItem Hairpin = new MajorItem("hairpin", "This is a hairpin! It’s used to keep your hair out of your face.",
        BedroomCloset);
    Utility LivingroomKey = new Utility("key", "It's a key.", LivingroomSofa, LivingroomLockbox,
        "You opened the lockbox in the living room!");

    // actual scenarioing
    System.out.print("Which scenario would you like to play? (1, 2, or 3): ");
    chosenScenario = Integer.parseInt(sc.nextLine());

    if (chosenScenario == 1) {
      Player p1 = new Player("JERRY", Bedroom);

      try {
        p1.move(Hallway);
        p1.move(Kitchen);
        p1.collect(Glass);
        p1.inspect(Glass);
        p1.move(Hallway);
        p1.move(Bedroom);
        p1.sleep();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

    } else if (chosenScenario == 2) {
      Player p2 = new Player("FREDDY", Livingroom);

      try {
        p2.move(LivingroomSofa);
        p2.collect(LivingroomKey);
        p2.move(Livingroom);
        p2.use(LivingroomKey);
        p2.move(LivingroomLockbox);
        p2.collect(Cellphone);
        p2.sleep();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

    } else if (chosenScenario == 3) {
      Player p3 = new Player("THOM", BedroomCloset);

      try {
        p3.collect(Hairpin);
        p3.inspect(Hairpin);
        p3.use(Hairpin);
      } catch (Exception e) { //we need 2 t/c blocks for this since we intentionally throw an exception by using the hairpin
        System.out.println(e.getMessage());
      } try{
        p3.move(Bedroom);
        p3.sleep();
      } catch (Exception e){ 
        System.out.println(e.getMessage());
      }

    } else {
      System.out.println("Please input a 1, 2, or 3.");
    }

  }

}