package Labyrinth.Model.GameDataFunctions;

import Labyrinth.Model.Game;
import Labyrinth.Model.Player.Player;
import Labyrinth.Model.Room.RoomData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Save {

    public static void saveGame() {
        try {

            FileOutputStream saveFile = new FileOutputStream("SaveObj.sav");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            save.writeObject(Player.playerName);
            save.writeObject(Player.playerLocation);
            save.writeObject(Player.inventory);
            save.writeObject(Player.playerMoves);
            save.writeObject(Time.secondsPassed);
            save.writeObject(RoomData.currentRoomStructure);
            save.writeObject(Player.itemsPicked);
            save.writeObject(Game.hardMode);

            save.close();

        } catch (IOException exc) {

            exc.printStackTrace();

        }

    }


}