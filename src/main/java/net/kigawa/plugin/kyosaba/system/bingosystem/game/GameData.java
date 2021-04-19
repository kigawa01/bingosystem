package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameEquals;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.LootGenerateEvent;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class GameData {
    BingoSystem plugin;
    KigawaUtilLib util;
    String name;
    Location startLoc;
    boolean isPlaying;
    List<GameBord> gameBords;
    GameLottery lottery;
    boolean isLottery=false;
    public int turn;
    Piglin[] piglin;
    List<Material> piglinItem;
    boolean isPiglinLoot=false;
    int piglinLootNumber=0;
    boolean hasItemSet;

    public GameData(
            BingoSystem bingoSystem, String name, Location startLoc,
            Location lotteryLoc1, Location lotteryLoc2,
            List<UUID[]> slotUUID,
            List<UUID> uuid,
            List<Location[]> buttonLoc
    ){
        plugin=bingoSystem;
        util=(KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");
        this.name=name;
        this.startLoc=startLoc;
        this.lottery=new GameLottery(lotteryLoc1,lotteryLoc2);
        Iterator<UUID[]> it=slotUUID.iterator();
        for (int i=0;it.hasNext();i++){
            gameBords.add(new GameBord(plugin, it.next(),i ,buttonLoc.get(i)));
        }
        Iterator<UUID> uuidIterator= uuid.iterator();
        for (int i=0;uuidIterator.hasNext();i++){
            piglin[0]=(Piglin)plugin.getServer().getEntity(uuidIterator.next());
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
            GameEquals gameEquals=(GameEquals) o;
            if ("isMachName".equals(gameEquals.type)) {
                canUse = ((GameEquals) o).name.equals(this.name);
            }else {
                if ("hasSlotSet".equals(gameEquals.type)){
                    canUse=!isLottery;
                }
            }
        }
        if (o instanceof Location){
            if(lottery.equals(o)){
                canUse=true;
            }else {
                if(gameBords.contains(o)) {
                    canUse = true;
                }
            }
        }
        if(o instanceof UUID){
            if(piglin[0].getUniqueId().equals(o)){
                canUse=true;
            }else{
                if (piglin[1].getUniqueId().equals(o)){
                    canUse=true;
                }else{
                    canUse=gameBords.contains(o);
                }
            }

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
    public void checkBord(){

    }
    public List<GameBord> getFinishBord(){
        List<GameBord> bord = null;
        for (GameBord gameBord : gameBords) {
            if (gameBord.isFinish) {
                bord.add(gameBord);
            }
        }
        return bord;
    }
    public void setPiglinItem(EntityDropItemEvent event){
        piglinItem.add(event.getItemDrop().getItemStack().getType());
    }
    public void setLoot(LootGenerateEvent event){
        event.getLoot().removeAll(piglinItem);
    }
    public void sendMessage(Player player){

    }
}
