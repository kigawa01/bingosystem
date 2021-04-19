package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameEquals;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;

import java.util.List;
import java.util.UUID;


public class GameSlot {
    BingoSystem plugin;
    ItemFrame itemFrame;
    Material material;
    boolean endLottery;

    public GameSlot(BingoSystem bingoSystem,ItemFrame itemFrame,int number){
        plugin=bingoSystem;
        this.itemFrame=itemFrame;

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
        }else{
            if(o instanceof UUID){
                if (itemFrame.getUniqueId().equals(o)){
                    answer=true;
                }
            }
        }

        return answer;
    }
}
