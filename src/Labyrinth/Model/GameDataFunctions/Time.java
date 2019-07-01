package Labyrinth.Model.GameDataFunctions;

import java.util.Timer;
import java.util.TimerTask;

import static Labyrinth.Model.Game.*;

public class Time {

    public static int secondsPassed =0;
    private static Timer timer = new Timer();

    private static TimerTask task = new TimerTask() {
        public void run() {
            if (hardMode){
                if (secondsPassed ==20){

                    System.out.println("\nYou reach time limit\n");
                    System.out.println(ANSI_PURPLE+"You lost\n"+ANSI_RESET);
                    System.exit(0);

                }
            }
            secondsPassed++;
        }
    };
    public static void start(){

        timer.scheduleAtFixedRate(task,1000,1000);

    }
}
