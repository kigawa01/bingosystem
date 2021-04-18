package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameEquals;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class GameBord {
    BingoSystem plugin;
    boolean hasPlayer;
    public Player player;
    int number;
    int lotteryCount;
    public List<GameSlot> gameSlotList;
    public GameBord(BingoSystem bingoSystem, Location[] slotLocations, int number){
        this.number=number;
        plugin=bingoSystem;
        for(int i=0;i<slotLocations.length;i++){
            gameSlotList.add(new GameSlot(plugin,slotLocations[i],i));
        }

    }
    public boolean equals(Object o){
        boolean equals=false;
        if(o == null)
        equals=hasPlayer;
        if(o instanceof GameEquals){
            GameEquals gameEquals=(GameEquals)o;
            if(gameEquals.type.equals("isLotteryEnd")){
                equals=gameSlotList.contains(o);
            }
        }

        return equals;
    }
    public void setPlayer(Player player){
        this.player=player;
        hasPlayer=true;
    }

}
