package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameEquals;
import org.bukkit.Location;

import java.util.Iterator;
import java.util.List;


public class GameList {
    BingoSystem plugin;
    List<GameData> gameDataList;
    public GameList(BingoSystem bingoSystem){
        plugin=bingoSystem;
    }
    public GameData getGameData(){
        Iterator<GameData> it=gameDataList.iterator();
        GameData gameData = null;
        while (it.hasNext()&&!it.next().isFree()){
            gameData= it.next();
        }
        assert gameData != null;
        if(gameData.isFree()){
            return gameData;
        }else {
            return null;
        }

    }
    public GameData getGameData(String name){
        GameEquals gameEquals=new GameEquals("");
        gameEquals.name=name;
        return gameDataList.get(gameDataList.indexOf(gameEquals));
    }
    public GameData getGameData(Location location){
        int index=gameDataList.indexOf(location);
        if(index>=0) {
            return gameDataList.get(index);
        }else {
            return null;
        }
    }

}
