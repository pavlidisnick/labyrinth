package Labyrinth.Model.Room;

import Labyrinth.Model.Player.Player;

import static Labyrinth.Model.Game.*;

public class RoomData {

    public static RoomStructure currentRoomStructure;

    public static void createRooms() {

        RoomStructure Entrance, Library, Armory, Grand_Hall, Bedroom, Kitchen, Balcony;

        Entrance = new RoomStructure("Entrance", ANSI_CYAN + "the Entrance Room." + ANSI_RESET + "There is a table here and a door ahead.", "key");
        Library = new RoomStructure("Library", ANSI_CYAN + "the Library Room." + ANSI_RESET + "This room is full of books. This room has four doors.", "book");
        Armory = new RoomStructure("Armory", ANSI_CYAN + "the Armory Room." + ANSI_RESET + "It almost empty. This room has" +
                " two doors.", "sword");
        Grand_Hall = new RoomStructure("Grand Hall", ANSI_CYAN + "the Grand Hall." + ANSI_RESET + " You see a long red carpet that leads to a throne." +
                " This room has two doors.", "crown");
        Bedroom = new RoomStructure("bedroom", ANSI_CYAN + "the Bedroom." + ANSI_RESET + " Next to bed there is a bedside table. This room has two doors.", "candle");
        Kitchen = new RoomStructure("Kitchen", ANSI_CYAN + "the Kitchen." + ANSI_RESET + " There are some rotten oranges on the table. This room has " +
                "two doors.", "orange");
        Balcony = new RoomStructure("Balcony", ANSI_CYAN + "the Balcony." + ANSI_RESET + " You can see the sea outside. This room has two doors.", null);

        Entrance.setExits(Library, null, null, null);
        Library.setExits(Grand_Hall, Entrance, Armory, Bedroom);
        Grand_Hall.setExits(null, Library, Balcony, Kitchen);
        Armory.setExits(Balcony, null, null, Library);
        Bedroom.setExits(Kitchen, null, Library, null);
        Balcony.setExits(null, Armory, null, Grand_Hall);
        Kitchen.setExits(null, Bedroom, Grand_Hall, null);

        currentRoomStructure = Entrance;
        Player.playerLocation = currentRoomStructure.getName();

    }

}