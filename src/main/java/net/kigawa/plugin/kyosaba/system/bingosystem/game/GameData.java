package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;

public class GameData {
    BingoSystem plugin;
    int seat;
    int maxSeat;

    public GameData(BingoSystem bingoSystem){
        plugin=bingoSystem;
    }
    public boolean isFree(){
        return seat < maxSeat;
    }
}
