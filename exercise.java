package q1.exercise1;

public class exercise {
    public static void main(String[] args) {

      String telemodel = "SX Telecaster";
      int teleprice = 8000;
      int telemonths = 9;

      String ampmodel = "Orange Crush 20RT";
      int ampprice = 12000;
      int ampmonths = 9;
       
      String cansmodel = "Philips SHP9500";
      int cansprice = 2500;
      int cansmonths = 14;

      int totalprice = cansprice + ampprice + teleprice;

      System.out.println("Guitar");
      System.out.println("Model: " + telemodel);
      System.out.println("Price: " + teleprice);
      System.out.println("Months owned: " + telemonths + "\n");

      System.out.println("Amplifier");
      System.out.println("Model: " + ampmodel);
      System.out.println("Price: " + ampprice);
      System.out.println("Months owned: " + ampmonths + "\n");

      System.out.println("Headphones");
      System.out.println("Model: " + cansmodel);
      System.out.println("Price: " + cansprice);
      System.out.println("Months owned: " + cansmonths + "\n");

      System.out.println("Combined price: " + totalprice);
      System.out.println("Is the guitar cheaper than the amplifier? " + (teleprice < ampprice));
      System.out.println("Have I owned the headphones longer than the amplifier? " + (cansmonths > ampmonths));

      }
}
