package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;

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
}
