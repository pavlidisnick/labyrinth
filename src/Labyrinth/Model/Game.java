package Labyrinth.Model;

import Labyrinth.Model.GameDataFunctions.Load;
import Labyrinth.Model.GameDataFunctions.Time;
import Labyrinth.Model.InputMechanism.Command;
import Labyrinth.Model.InputMechanism.Parser;
import Labyrinth.Model.Player.Player;
import Labyrinth.Model.Room.RoomData;

import java.util.Scanner;


public class Game {


    private Parser parser;
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static boolean hardMode = false;


    Game() {

        RoomData.createRooms();
        parser = new Parser();

    }


    void play() {
        System.out.println("You want to load your last game?");

        label1:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String askLoad = scanner.nextLine();
            switch (askLoad) {
                case "yes":
                    System.out.println(ANSI_RED + "Successful Load\n" + ANSI_RESET);
                    Load.loadGame();
                    System.out.println(RoomData.currentRoomStructure.Description());
                    Time.start();
                    break label1;
                case "no":
                    System.out.println(ANSI_RED + "New Game\n" + ANSI_RESET);
                    System.out.println("You want to play on Hard Mode?");
                    label2:
                    while (true) {
                        Scanner scanner2 = new Scanner(System.in);
                        String askMode = scanner2.nextLine();
                        switch (askMode) {
                            case "yes":
                                hardMode = true;
                                System.out.println("Hard Mode " + ANSI_RED + "enabled\n" + ANSI_RESET);
                                break label2;
                            case "no":
                                System.out.println("Hard Mode " + ANSI_RED + "disabled\n" + ANSI_RESET);
                                break label2;
                            default:
                                System.out.println("Type again");
                                break;
                        }
                    }
                    printWelcome();

                    break label1;
                default:
                    System.out.println("Type again");
                    break;
            }

        }


        boolean finished = false;
        while (!finished) {

            Command command = parser.getCommand();
            finished = Command.processCommand(command);

        }

        System.out.println("See you again.");
        System.exit(0);

    }

    private void printWelcome() {

        System.out.println("Write your profile name : ");
        Scanner on = new Scanner(System.in);
        Player.playerName = on.nextLine();
        System.out.println();
        System.out.println("Welcome to Labyrinth " + ANSI_BLUE + Player.playerName + ANSI_RESET + " !");
//        System.out.println("This is a text-based game for the class of " + ANSI_PURPLE + "Dr. Theodoros Lantzos." + ANSI_RESET);
        System.out.println("You are trapped in a labyrinth of rooms searching an item in order to win." +
                " One item is a bomb.");
        System.out.println(ANSI_PURPLE + "\nGood Luck\n" + ANSI_RESET);
        System.out.println();
        System.out.println(RoomData.currentRoomStructure.Description());
        Time.start();

    }

}