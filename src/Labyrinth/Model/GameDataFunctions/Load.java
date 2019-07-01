package Labyrinth.Model.GameDataFunctions;

import Labyrinth.Model.Game;
import Labyrinth.Model.Player.Player;
import Labyrinth.Model.Room.RoomData;
import Labyrinth.Model.Room.RoomStructure;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Load {

    public static void loadGame(){

        try {

            FileInputStream saveFile = new FileInputStream("SaveObj.sav");
            ObjectInputStream save = new ObjectInputStream(saveFile);

            Player.playerName =(String) save.readObject();
            Player.playerLocation =(String ) save.readObject();
            Player.inventory = (String[]) save.readObject();
            Player.playerMoves = (Integer) save.readObject();
            Time.secondsPassed = (Integer) save.readObject();
            RoomData.currentRoomStructure = (RoomStructure) save.readObject();
            Player.itemsPicked = (ArrayList<String>) save.readObject();
            Game.hardMode = (boolean) save.readObject();

            save.close();

        }
        catch (Exception exc) {

            exc.printStackTrace();

        }

    }


}