package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.Location;

import java.util.List;

public class GameData {
    BingoSystem plugin;
    KigawaUtilLib util;
    String name;
    Location startLoc;
    boolean isPlaying;
    List<BingoData> bingoData;

    public GameData(BingoSystem bingoSystem, String name,Location startLoc){
        plugin=bingoSystem;
        util=(KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");
        this.name=name;
        this.startLoc=startLoc;
    }
    public boolean isFree(){

        return bingoData.contains(null) &&isPlaying;
    }
    public boolean equals(Object o){
        return this.isFree();
    }
}
