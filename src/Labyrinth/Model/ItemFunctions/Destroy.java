package Labyrinth.Model.ItemFunctions;

import Labyrinth.Model.InputMechanism.Command;
import Labyrinth.Model.Player.Player;

import static Labyrinth.Model.Game.*;

public class Destroy {

    public static void destroyItem(Command command) {

        if (command.SecondWord()) {

            System.out.println("Destroy what?");
            return;

        }

        int meter = 0;
        boolean itemExist = false;

        for (int i = 0; i < 3; i++) {

            if (Player.inventory[i] == null)

                meter++;

            else if (command.getSecondWord().equals(Player.inventory[i])) {

                itemExist = true;
                System.out.println("The " + ANSI_RED + Player.inventory[i] + ANSI_RESET + " destroyed from your inventory");
                Player.inventory[i] = null;

            }
        }

        if (!itemExist && meter != 3) {

            System.out.println("You don't have that item in your inventory");

        }
        if (meter == 3) {

            System.out.println("Your inventory is empty");

        }
    }


}