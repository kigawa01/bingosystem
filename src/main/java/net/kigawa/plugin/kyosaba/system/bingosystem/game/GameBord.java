package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.config.BingoSystemConfigData;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameIsPossible;
import org.bukkit.entity.Player;

import java.util.List;

public class GameBord {
    BingoSystem plugin;
    boolean hasPlayer;
    Player player;
    int number;
    boolean isPossible;
    public GameBord(BingoSystem bingoSystem){
        plugin=bingoSystem;
    }
    public boolean equals(Object o){
        boolean equals=false;
        if(o == null)
        equals=hasPlayer;
        if(o instanceof GameIsPossible)
            equals=isPossible;
        return equals;
    }
    public void setPlayer(Player player){
        this.player=player;
        hasPlayer=true;
    }

}
