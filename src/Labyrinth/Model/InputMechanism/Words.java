package Labyrinth.Model.InputMechanism;

import static Labyrinth.Model.Game.*;

class Words {

    private static final String validWords[] = {

            "go", "quit", "pick", "destroy", "profile", "save", "load", "help"

    };


    boolean isCommand(String aString) {

        for (String validWord : validWords) {

            if (validWord.equals(aString))
                return true;
        }
        return false;
    }


    static void showAll() {

        System.out.print(ANSI_RED + "You can use the following words\n\n" + ANSI_RESET);
        for (String validWord : validWords) {

            System.out.print(validWord + "  ");

        }

        System.out.println();

    }


}