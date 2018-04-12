package textadventuregame;

import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static textadventuregame.Controller.*;

public class Display {
    
    Scanner sc = new Scanner(System.in);
    String name;
    
    
    public void Welcome() {
        System.out.println("\nLocated in Gothem Citys, in a dark and mystery neighborhood."
                + "\nYou start your adventure in front of the grand Asylum where your journey of madness will begin."
                + "\nSlinder throug the rooms of the historcial landmark of Gotham and fight against evil creatures, "
                + "\ncreated by the late desiesed Dr. Amadeus Arkham, the founder of the Asylum"
                + "\nLet's play!");
    }
    
    public String setName() throws InterruptedException {
        slowPrint("Enter your name: ");
       // System.out.print("Enter your name: ");
        name = sc.next();
        slowPrint("Welcome to the Arkham Asylum " + name + ".");
        //System.out.println("Welcome to the Arkham Asylum " + name + ".");
        return name;
    }
    
    public void getRoomDescription(String desc) {
        System.out.println(desc);
    }
    
    public int getDirections() {
        System.out.println("\nWhere do you want to go from here? (North, East, South, West)");
        String input = sc.next();
        if ("north".equalsIgnoreCase(input)) {
            return NORTH;
        }
        if ("south".equalsIgnoreCase(input)) {
            return SOUTH;
        }
        if ("east".equalsIgnoreCase(input)) {
            return EAST;
        }
        if ("west".equalsIgnoreCase(input)) {
            return WEST;
        } else {
            System.out.println("Invalid Input");
        }
        // 
        return getDirections();
        
    }
    
     public static void slowPrint(String text) throws InterruptedException{
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(250);
        }
    }
     static void playSound(File Sound) {

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength()/1000);
        } catch (Exception e)
        {
        }

    }
    
}
