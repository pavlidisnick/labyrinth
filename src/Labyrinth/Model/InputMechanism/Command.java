package Labyrinth.Model.InputMechanism;


import Labyrinth.Model.GameDataFunctions.Load;
import Labyrinth.Model.GameDataFunctions.Save;
import Labyrinth.Model.ItemFunctions.Destroy;
import Labyrinth.Model.ItemFunctions.Pick;
import Labyrinth.Model.Player.Player;
import Labyrinth.Model.Room.RoomData;
import Labyrinth.Model.Room.RoomStructure;

import static Labyrinth.Model.Game.*;

public class Command {

    private String commandWord;
    private String secondWord;


    Command(String firstWord, String secondWord) {

        commandWord = firstWord;
        this.secondWord = secondWord;

    }


    private String getCommandWord() {

        return commandWord;

    }


    public String getSecondWord() {

        return secondWord;

    }


    private boolean isUnknown() {

        return (commandWord == null);

    }


    public boolean SecondWord() {

        return (secondWord == null);

    }

    public static boolean processCommand(Command command) {

        if (command.isUnknown()) {

            System.out.println("Wrong command");
            return false;

        }

        String commandWord = command.getCommandWord();
        switch (commandWord) {

            case "go":
                Player.moveLimit();
                RoomStructure.goRoom(command);
                Player.playerMoves++;
                Player.playerLocation = RoomData.currentRoomStructure.getName();
                break;

            case "pick":
                Pick.takeItem(command);
                break;

            case "destroy":
                Destroy.destroyItem(command);
                break;

            case "quit":
                return true;

            case "profile":
                Player.showProfile();
                break;

            case "help":
                Words.showAll();
                break;

            case "save":
                Save.saveGame();
                System.out.println(ANSI_RED + "Successful Save\n" + ANSI_RESET);
                break;

            case "load":
                Load.loadGame();
                System.out.println(ANSI_RED + "Successful Load\n" + ANSI_RESET);
                System.out.println(RoomData.currentRoomStructure.Description());
                break;

        }

        return false;

    }
}
