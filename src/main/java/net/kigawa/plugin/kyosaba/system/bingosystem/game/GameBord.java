package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameEquals;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class GameBord {
    BingoSystem plugin;
    boolean hasPlayer;
    public Player player;
    int number;
    public List<GameSlot> gameSlotList;
    public boolean isFinish;
    Location[] buttonLoc;
    boolean isLottery;

    public GameBord(BingoSystem bingoSystem, UUID[] slotUUID, int number, Location[] buttonLoc){
        this.number=number;
        this.buttonLoc=buttonLoc;
        plugin=bingoSystem;
        for(int i=0;i<slotUUID.length;i++){
            ItemFrame itemFrame=(ItemFrame) plugin.getServer().getEntity(slotUUID[i]);
            gameSlotList.add(new GameSlot(plugin,itemFrame,i));
        }

    }
    public boolean equals(Object o){
        boolean equals=false;
        if(o == null)
        equals=hasPlayer;
        if(o instanceof GameEquals){
            GameEquals gameEquals=(GameEquals)o;
            if(gameEquals.type.equals("isLotteryEnd")){
                equals=gameSlotList.contains(o)&&isLottery;
                isLottery=true;
            }
        }
        if(o instanceof Player){
            if (player.equals(o)){
                equals=true;
            }
        }
        if (o instanceof Location){
            if (((Location)o).equals(buttonLoc[0])){
                equals=true;
            }else {
                if (((Location)o).equals(buttonLoc[1])){
                    equals=true;
                }
            }
        }
        if(o instanceof UUID){
            if (gameSlotList.contains(o)){
                equals= true;
            }
        }

        return equals;
    }
    public void setPlayer(Player player){
        this.player=player;
        hasPlayer=true;
    }
    public void isFinishCheck(){
        GameSlot a=gameSlotList.get(0);
        GameSlot b=gameSlotList.get(1);
        GameSlot c=gameSlotList.get(2);

        GameSlot d=gameSlotList.get(3);
        GameSlot e=gameSlotList.get(4);
        GameSlot f=gameSlotList.get(5);

        GameSlot g=gameSlotList.get(6);
        GameSlot h=gameSlotList.get(7);
        GameSlot i=gameSlotList.get(8);
        if(e.itemFrame.isEmpty()){
            if(a.itemFrame.isEmpty()&&i.itemFrame.isEmpty())isFinish=true;
            if(c.itemFrame.isEmpty()&&g.itemFrame.isEmpty())isFinish=true;
            if(b.itemFrame.isEmpty()&&h.itemFrame.isEmpty())isFinish=true;
            if(d.itemFrame.isEmpty()&&f.itemFrame.isEmpty())isFinish=true;
        }else {
            if (a.itemFrame.isEmpty()){
                if(b.itemFrame.isEmpty()&&c.itemFrame.isEmpty())isFinish=true;
                if(d.itemFrame.isEmpty()&&g.itemFrame.isEmpty())isFinish=true;
            }else{
                if (i.itemFrame.isEmpty()){
                    if(g.itemFrame.isEmpty()&&h.itemFrame.isEmpty())isFinish=true;
                    if (c.itemFrame.isEmpty()&&f.itemFrame.isEmpty())isFinish=true;
                }
            }
        }

    }

}
