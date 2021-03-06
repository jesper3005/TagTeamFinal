package textadventuregame;

import java.io.File;
import static textadventuregame.Display.playSound;

public class Controller {

    Display display = new Display();
    Player player;

    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    private Room endRoom;
    Room nextRoom = null;

    File Door = new File("door.wav");
    File HeartBeat = new File("heartbeat.wav");
    File HountedHouse = new File("hauntedhouse.wav");
    
    public void start() throws InterruptedException {
        Room hall = createRooms();
        playSound(HeartBeat);
        playSound(HeartBeat);
        player = new Player(display.setName(), hall);
        String desc = hall.getDescription();
        playSound(HountedHouse);
        display.Welcome();
        display.getRoomDescription(desc);

        while (true) {
            playerControll();

            {
                player.setLocation(nextRoom);
                playSound(Door);
                desc = nextRoom.getDescription();
                display.getRoomDescription(desc);
            }

            if (player.getLocation().equals(endRoom)) {
                System.exit(0);
            }

        }
    }

    public void playerControll() {
        do {
            int svar = display.getDirections();

            switch (svar) {
                case NORTH:
                    nextRoom = player.getLocation().getNorth();
                    break;
                case EAST:
                    nextRoom = player.getLocation().getEast();
                    break;
                case SOUTH:
                    nextRoom = player.getLocation().getSouth();
                    break;
                case WEST:
                    nextRoom = player.getLocation().getWest();
                    break;
            }
            if (nextRoom == null) {
                System.out.println("Choose a diffrent direction!");
            }
        } while (nextRoom == null);
    }

    private Room createRooms() {
        Room hall = new Room("\nYou enter Arkham through a large metal door and stand in the grand hall of Arkham Asylum, where your adventure will take place, "
                + "\nyou are commitet to save Gotham from insanity. In front of you, you see a large staircase"
                + "\nwhat seems to be the only way into the Asylum.");

        Room livingRoom = new Room("\nYou entered through the only door, and see a quite uncanny livingroom."
                + "\nIt has everything a livingroom needs to have but covered in dust and spider web, "
                + "\nthe furnitures looks like something from hundres of years ago");

        Room library = new Room("\nYou step in to a tall but small room, the walls are giant bookshelfs, "
                + "\nwith no spot left open for new books. You look around and notice that all the books "
                + "\nare camouflaged in dust, with an exception of one shelf.");

        Room billiardRoom = new Room("\nYou arrive in what seems to be a cozy entertainment room, there is a billiard table "
                + "\nin the middle of the room. The walls has enormous paintings on them, the motives on the paintings are dark "
                + "\nand unsettleling, they seem like something only a mental person would have hanging.");

        Room playRoom = new Room("\nThis seems weird.. It appears to be a room for toddlers, it has everything a toddler would want."
                + "\nIt doesnt look like something for patients, perhabs Dr. Amadeus has children?");

        Room Laboratory = new Room("\nYou go through a rusty old metal door, thinking to yourself only the worst kind of asylums "
                + "\nwould have a metal door to keep their patients locked in. Then you realise, that this room is some kind of labatory, "
                + "\nand definetly not for patients. The fear lingers in your body just thinking about what kind of experiments "
                + "\nmight have happend to the patients. ");

        Room diningRoom = new Room("\nYou have entered a large room,  it seems to be looking like a giant livingroom. "
                + "\nThe dinner table could hold a feast for up to 20 people but there is only one chair, "
                + "\nright at the end of the table. It seems abandoned and there is no real sign of any life.");

        Room kitchen = new Room("\nThis is without a doubt the kitchen. There is a distinct smell of rot."
                + "\nThere may be something in here you could use.");

        Room bedroom = new Room("\nThis seems to be the bedroom, quite luxurius compared to the rest of the Asylum"
                + "\nit must have belonged to the creator of the Asylum.");

        Room ballRoom = new Room("\n This room is very big and long. Two chandeliers hang from the top of the ceiling. "
                + "\nThis must be the ball room");

        Room cell1 = new Room("\nYou have entered some sort of prison cell, it must be here he kept his patients locked up."
                + "\nIts small and dark with nothing but some hay in the corner and a skeleton.");

        Room cell2 = new Room("\nYou have entered some sort of prison cell, it must be here he kept his patients locked up."
                + "\nIts small and dark with nothing but some hay in the corner.");

        Room toilet = new Room("\nYou feel like your hand has gotten some sort of infection from just touching that doorhandle. "
                + "\nYou are disgusted by the smell of what seems to be a toilet that has never been cleaned.");

        Room cell3 = new Room("\nYou entered a small cell, with a small crack in the wall where the sunlight comes through."
                + "\nYou move the broken bricks to make a escape and are able to get out.");

        hall.setSouth(livingRoom);

        library.setEast(livingRoom);
        library.setSouth(Laboratory);

        livingRoom.setNorth(hall);
        livingRoom.setWest(library);
        livingRoom.setEast(billiardRoom);
        livingRoom.setSouth(diningRoom);

        billiardRoom.setEast(livingRoom);
        billiardRoom.setSouth(kitchen);

        playRoom.setSouth(bedroom);

        Laboratory.setNorth(library);
        Laboratory.setEast(diningRoom);

        diningRoom.setNorth(livingRoom);
        diningRoom.setSouth(cell1);
        diningRoom.setWest(Laboratory);

        kitchen.setNorth(billiardRoom);
        kitchen.setEast(bedroom);
        kitchen.setSouth(cell2);

        bedroom.setNorth(playRoom);
        bedroom.setWest(kitchen);

        ballRoom.setEast(cell1);

        cell1.setNorth(diningRoom);
        cell1.setWest(ballRoom);

        cell2.setNorth(kitchen);
        cell2.setEast(toilet);
        cell2.setSouth(cell3);

        toilet.setWest(cell2);

        cell3.setNorth(cell2);

        endRoom = cell3;

        return hall;
    }

}
