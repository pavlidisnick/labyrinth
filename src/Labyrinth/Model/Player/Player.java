package Labyrinth.Model.Player;

import Labyrinth.Model.GameDataFunctions.Time;

import java.io.Serializable;
import java.util.ArrayList;

import static Labyrinth.Model.Game.*;

public class Player implements Serializable {
    public static String playerName;
    public static int playerMoves = 0;
    public static String[] inventory = {null, null, null};
    public static ArrayList<String> itemsPicked = new ArrayList<>();
    public static String playerLocation = "";

    public static void showProfile() {
        System.out.println(ANSI_GREEN + "\nPlayer Info\n" + ANSI_RESET);
        System.out.println("Player: " + ANSI_BLUE + playerName + ANSI_RESET);
        System.out.println("Current Location: " + ANSI_BLUE + playerLocation + ANSI_RESET);
        int inventorySize = 0;
        for (String anInventory : inventory)
            if (anInventory == null) {
                inventorySize++;
            } else
                System.out.println("Item in your inventory: " + ANSI_BLUE + anInventory + ANSI_RESET);
        if (inventorySize == 3) {
            System.out.println("Your inventory is " + ANSI_BLUE + "empty" + ANSI_RESET);
        }
        System.out.println("Moves in game: " + ANSI_BLUE + playerMoves + ANSI_RESET);
        System.out.println("Time in game: " + ANSI_BLUE + Time.secondsPassed + ANSI_RESET + " seconds\n");
    }

    public static void moveLimit() {
        if (hardMode) {
            if (playerMoves == 5) {
                System.out.println("\nYou reach moves limit\n");
                System.out.println(ANSI_PURPLE + "\nYou lost\n" + ANSI_RESET);
                System.exit(0);
            }
        }
    }
}