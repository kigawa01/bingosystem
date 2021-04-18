package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import com.sun.tools.jdi.EventSetImpl;
import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameEquals;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.List;

public class GameData {
    BingoSystem plugin;
    KigawaUtilLib util;
    String name;
    Location startLoc;
    boolean isPlaying;
    List<GameBord> gameBords;
    GameLottery lottery;
    boolean isLottery=false;


    public GameData(BingoSystem bingoSystem, String name, Location startLoc, Location lotteryLoc1, Location lotteryLoc2, List<Location[]> gameBordLocations){
        plugin=bingoSystem;
        util=(KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");
        this.name=name;
        this.startLoc=startLoc;
        this.lottery=new GameLottery(lotteryLoc1,lotteryLoc2);
        Iterator<Location[]> it=gameBordLocations.iterator();
        for (int i=0;it.hasNext();i++){
            gameBords.add(new GameBord(plugin, it.next(),i ));
        }
    }
    public boolean isFree(){

        return gameBords.contains(null) &&isPlaying;
    }
    public boolean equals(Object o){
        boolean canUse=false;
        if(o==null)
        canUse= this.isFree();
        if(o instanceof GameEquals){
            canUse= ((GameEquals) o).name.equals(this.name);
        }
        if (o instanceof Location){
            canUse=lottery.equals(o);
        }
        return canUse;


    }
    public void setPlayer(Player player){
        gameBords.get(gameBords.indexOf(null)).setPlayer(player);
    }
    public boolean isLotteryEnd(){
        return !gameBords.contains(new GameEquals("isLotteryEnd"));
    }
    public GameBord getNextLottery(){
        return gameBords.get(gameBords.indexOf(new GameEquals("isLotteryEnd")));
    }
}
