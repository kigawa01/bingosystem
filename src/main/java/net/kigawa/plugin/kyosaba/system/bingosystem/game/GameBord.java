package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.config.BingoSystemConfigData;
import org.bukkit.entity.Player;

import java.util.List;

public class GameBord {
    BingoSystem plugin;
    boolean hasPlayer;
    Player player;
    int number;

    public GameBord(BingoSystem bingoSystem){
        plugin=bingoSystem;
    }
    public boolean equals(Object o){
        return hasPlayer;
    }
    public void setPlayer(Player player){
        this.player=player;
        hasPlayer=true;
    }

}
