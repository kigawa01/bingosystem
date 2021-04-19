package net.kigawa.plugin.kyosaba.system.bingosystem.game;


import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameEquals;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.world.LootGenerateEvent;

import java.awt.*;
import java.io.IOException;

public class GameListener implements Listener {
    BingoSystem plugin;
    GameList gameList;
    public GameListener(BingoSystem bingoSystem){
        plugin=bingoSystem;
        gameList= plugin.getGameList();
    }
    public void onLottery(BlockDispenseEvent event){
        Block block=event.getBlock();
        Location location=block.getLocation();
        GameData gameData= gameList.getGameData(location);
        if(gameData!=null){
            GameBord bord=gameData.getNextLottery();
            bord.gameSlotList.get(bord.gameSlotList.indexOf(new GameEquals("isLotteryEnd"))).material=event.getItem().getType();
            bord.gameSlotList.get(bord.gameSlotList.indexOf(new GameEquals("isLotteryEnd"))).endLottery=true;
        }
    }
    public void onPig(LootGenerateEvent event){
        GameData gameData=gameList.getGameData(event.getEntity().getUniqueId());
        if(gameData!=null){
            gameData.setLoot(event);
        }
    }
    public void onPigDrop(EntityDropItemEvent event){
        GameData gameData=gameList.getGameData(event.getEntity().getUniqueId());
        if(gameData!=null){
            gameData.setPiglinItem(event);
            gameData.isPiglinLoot=true;
            gameData.piglinLootNumber++;
        }
    }
    public void onPushButton(PlayerInteractEvent event){
        if(event.getClickedBlock().getType().equals(Material.STONE_BUTTON)){
            GameData gameData=gameList.getGameData(event.getClickedBlock().getLocation());
            if(gameData!=null){
                if (!gameData.gameBords.contains(event.getPlayer())){
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(Color.RED+"次は"+gameData.gameBords.get(gameData.piglinLootNumber).player.getDisplayName()+"さんです");
                }
            }
        }
    }
    public void onClickFrame(PlayerShearEntityEvent event){
        if (event.getEntity().getType().equals(Material.ITEM_FRAME)){
            GameSlot slot= gameList.getSlot(event.getEntity().getUniqueId());
            if (slot!=null){
                if (!gameList.getGameData(event.getEntity().getUniqueId()).piglinItem.equals(((ItemFrame)event.getEntity()).getItem().getType())){
                    event.setCancelled(true);
                }
            }
        }
    }
    public void onItemSetSlot(PlayerInteractEntityEvent event){
        Entity entity=event.getRightClicked();
        if (entity.getType().equals(Material.ITEM_FRAME)){
            GameSlot slot= gameList.getSlot(entity.getUniqueId());
            if (slot!=null){
                if (!slot.material.equals(event.getPlayer().getInventory().getItemInMainHand().getType())){
                    event.setCancelled(true);
                }
                if (gameList.hasSlotSet()){
                    gameList.getGameData(entity.getUniqueId()).hasItemSet=true;
                }
            }
        }
    }
}
