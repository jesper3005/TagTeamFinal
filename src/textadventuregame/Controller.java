package textadventuregame;

public class Controller {

    Display display = new Display();
    Player player;

    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    public void start() {
        Room hall = new Room("\nLocated in Gothem Citys, in a dark and mystery neighborhood."
                + "\nYou start your adventure in the main hall where your journey of madness will begin"
                + "\nSlinder through the rooms of the historcial landmark of Gotham and fight against the creatures, "
                + "\ncreated by the late desiesed Dr. Amadeus Arkham, the founder of the Asylum"
                + "\nLet's play!");

        Room livingRoom = new Room("\nYou entered through the only door, and see a quite uncanny livingroom."
                + "\nIt has everything a livingroom needs to have but covered in dust and spider web, "
                + "the furnitures looks like something from hundres of years ago");

        Room library = new Room("\nYou step in to a tall but small room, the walls are giant bookshelfs, "
                + "\nwith no spot left open for new books. You look around and notice that all the books "
                + "\nare camouflaged in dust, with an exception of one shelf.");

        Room billiardRoom = new Room("\nYou arrive in what seems to be a cozy entertainment room, there is a billiard table "
                + "\nin the middle of the room. The walls has enormous paintings on them, the motives on the paintings are dark "
                + "\nand unsettleling, they seem like something only a mental person would have hanging.");

        Room playRoom = new Room("Playroom");

        Room Laboratory = new Room("\nYou go through a rusty old metal door, thinking to yourself only the worst kind of asylums "
                + "\nwould have a metal door to keep their patients locked in. Then you realise, that this room is some kind of labatory, "
                + "\nand definetly not for patients. The fear lingers in your body just thinking about what kind of experiments "
                + "\nmight have happend to the patients. ");

        Room diningRoom = new Room("Dining Room");

        Room kitchen = new Room("Kitchen");

        Room bedroom = new Room("Bedroom");

        Room ballRoom = new Room("Ball Room");

        Room cell1 = new Room("Cell 1");

        Room cell2 = new Room("Cell 2");

        Room toilet = new Room("You feel like your hand has gotten some sort of infection from just touching that doorhandle. You are  ");

        Room cell3 = new Room("Cell 3");

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
        cell1.setSouth(cell3);
        cell1.setWest(ballRoom);

        cell2.setNorth(kitchen);
        cell2.setEast(toilet);

        toilet.setWest(cell2);

        cell3.setEast(cell2);
        cell3.setWest(cell1);

        player = new Player(display.setName(), hall);
        String desc = hall.getDescription();
        display.getRoomDescription(desc);

        
//        while(true) {
//            playerControl().;
//        }
        while (true) {
            Room nextRoom = null;
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
            } while (nextRoom == null);
            {
                player.setLocation(nextRoom);
                desc = nextRoom.getDescription();
                display.getRoomDescription(desc);
            }

        }
    }

    public int playerControl() {
        Room nextRoom = null;
        switch (display.playerInput()) {
            case "north":
                nextRoom = player.getLocation().getNorth();
                return NORTH;
            case "east":
                return EAST;
            case "south":
                nextRoom = player.getLocation().getSouth();
                return SOUTH;
            case "west":
                return WEST;
            default:
                System.out.println("Invalid Input");
        }
        return -1;
    }

}
