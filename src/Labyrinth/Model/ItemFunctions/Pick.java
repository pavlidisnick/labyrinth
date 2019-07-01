package Labyrinth.Model.ItemFunctions;

import Labyrinth.Model.GameDataFunctions.Time;
import Labyrinth.Model.InputMechanism.Command;
import Labyrinth.Model.Player.Player;
import Labyrinth.Model.Room.RoomData;

import java.util.Objects;

import static Labyrinth.Model.Game.*;

public class Pick {

    public static void takeItem(Command command) {

        if (command.SecondWord()) {

            System.out.println("Pick what?");
            return;

        }

        if (RoomData.currentRoomStructure.getRoomItem() == null)

            System.out.println("There is no item to pick!");

        else if (!command.getSecondWord().equals(RoomData.currentRoomStructure.getRoomItem())) {

            System.out.println("You can't pick that!");

        } else {

            int meter = 0;
            for (int i = 0; i < 3; i++) {

                if (Player.inventory[i] != null)
                    meter++;
                else {

                    System.out.println("You picked a/an " + ANSI_RED + RoomData.currentRoomStructure.getRoomItem() + ANSI_RESET);
                    Player.inventory[i] = RoomData.currentRoomStructure.getRoomItem();
                    RoomData.currentRoomStructure.setRoomItem();

                    if (Objects.equals(Player.inventory[i], "crown")) {

                        System.out.println("Congratulations you find the " + ANSI_RED + "King's Crown." + ANSI_RESET + " You win!");
                        Player.showProfile();
                        System.exit(0);

                    } else if (Objects.equals(Player.inventory[i], "orange")) {

                        System.out.println("The orange was a " + ANSI_RED + "bomb." + ANSI_RESET + " You lost!");
                        System.out.println("You were playing for " + ANSI_GREEN + Time.secondsPassed + " seconds." + ANSI_RESET);
                        System.exit(0);
                        break;

                    }
                    break;
                }
                if (meter == 3)
                    System.out.println("Your inventory is " + ANSI_RED + "full" + ANSI_RESET);
            }

        }
    }


}
