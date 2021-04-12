package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kigawautillib.sql.Connect;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;

public class GameData {
    BingoSystem plugin;
    int seat;
    int maxSeat;
    KigawaUtilLib util;

    public GameData(BingoSystem bingoSystem, KigawaUtilLib kigawaUtilLib){
        plugin=bingoSystem;
        util=kigawaUtilLib;
    }
    public boolean isFree(){
        return seat < maxSeat;
    }
}
