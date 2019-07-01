package Labyrinth.Model.Room;

import Labyrinth.Model.GameDataFunctions.Time;
import Labyrinth.Model.InputMechanism.Command;

import java.io.Serializable;
import java.util.HashMap;

import static Labyrinth.Model.Game.*;

public class RoomStructure implements Serializable {

    private String name;
    private String description;
    private String roomItem;
    private HashMap<String, RoomStructure> exits;

    RoomStructure(String name, String description, String roomItem) {

        this.name = name;
        this.description = description;
        this.roomItem = roomItem;
        exits = new HashMap<>();

    }

    void setExits(RoomStructure north, RoomStructure south, RoomStructure east, RoomStructure west) {

        if (north != null)
            exits.put("north", north);
        if (south != null)
            exits.put("south", south);
        if (east != null)
            exits.put("east", east);
        if (west != null)
            exits.put("west", west);

    }

    public String Description() {

        System.out.println("You are playing for " + ANSI_GREEN + Time.secondsPassed + " seconds." + ANSI_RESET);
        String Description = "You enter " + description + "\n";
        System.out.println();

        if (roomItem != null) {

            Description += "\nThe item you spot in this room is a/an: \n\n" + ANSI_RED + roomItem + ANSI_RESET;

        }
        return Description;

    }

    public String getRoomItem() {

        return roomItem;

    }

    public void setRoomItem() {

        this.roomItem = null;

    }

    public String getName() {

        return name;

    }

    private RoomStructure nextRoom(String direction) {

        return exits.get(direction);

    }

    public static void goRoom(Command command) {

        if (command.SecondWord()) {

            System.out.println("Go where?");
            return;

        }
        String direction = command.getSecondWord();
        RoomStructure nextRoom = RoomData.currentRoomStructure.nextRoom(direction);

        if (nextRoom == null)
            System.out.println("There is no door!");
        else {

            RoomData.currentRoomStructure = nextRoom;
            System.out.println(RoomData.currentRoomStructure.Description());

        }
    }

}
