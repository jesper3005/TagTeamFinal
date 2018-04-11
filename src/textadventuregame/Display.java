package textadventuregame;

import java.util.Scanner;
import static textadventuregame.Controller.*;

public class Display {
    Scanner sc = new Scanner(System.in);
    String name;
    
    public void Welcome(){
        System.out.println("\nnLocated in Gothem Citys, in a dark and mystery neighborhood."
                + "\nYou start your adventure in the main hall where your journey of madness will begin"
                + "\nSlinder throug the rooms of the historcial landmark of Gotham and fight against the creatures, "
                + "\ncreated by the late desiesed Dr. Amadeus Arkham, the founder of the Asylum"
                + "\nLet's play!");
    }
    
    public String setName() {
        System.out.print("Enter your name: ");
        name = sc.next();
        System.out.println("Welcome to the Arkham Asylum " + name + ".");
        return name;
    }
    
    public void getRoomDescription(String desc){
        System.out.println(desc);
    }
    
    
     public int getDirections() {
        System.out.println("\nWhere do you want to go from here? (North, East, South, West)");
        String input = sc.next();
        if("north".equalsIgnoreCase(input)) return NORTH;
        if("south".equalsIgnoreCase(input)) return SOUTH;
        if("east".equalsIgnoreCase(input)) return EAST;
        if("west".equalsIgnoreCase(input)) return WEST;
        System.out.println("Error");
        return getDirections();
        
     } 
     
             
    }
     
     
  

