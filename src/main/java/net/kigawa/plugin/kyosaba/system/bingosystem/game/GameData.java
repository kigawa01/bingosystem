package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class GameData {
    BingoSystem plugin;
    KigawaUtilLib util;
    String name;
    Location startLoc;
    boolean isPlaying;
    List<GameBord> gameBords;

    public GameData(BingoSystem bingoSystem, String name, Location startLoc){
        plugin=bingoSystem;
        util=(KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");
        this.name=name;
        this.startLoc=startLoc;

    }
    public boolean isFree(){

        return gameBords.contains(null) &&isPlaying;
    }
    public boolean equals(Object o){
        return this.isFree();
    }
    public void setPlayer(Player player){
        gameBords.get(gameBords.indexOf(null)).setPlayer(player);
    }
}
