package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameEquals;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.List;


public class GameSlot {
    BingoSystem plugin;
    Location location;
    Material material;
    boolean endLottery;
    public GameSlot(BingoSystem bingoSystem,Location location,int number){
        plugin=bingoSystem;
        this.location=location;
        this.material=material;
    }

    public void setMaterial(Material material){
        this.material=material;
    }
    public boolean equals(Object o){
        boolean answer=false;
        if(o instanceof GameEquals){
            if(((GameEquals) o).name.equals("isLotteryEnd")){
                answer=!endLottery;
            }
        }
        return answer;
    }
}
