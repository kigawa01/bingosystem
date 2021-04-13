package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.config.BingoSystemConfigData;

public class BingoData {
    BingoSystem plugin;
    int number;
    boolean isPlayer=false;

    public BingoData(BingoSystem bingoSystem,int number){
        plugin=bingoSystem;
        this.number=number;
    }
    public boolean equals(Object o){
        return !isPlayer;
    }

}
