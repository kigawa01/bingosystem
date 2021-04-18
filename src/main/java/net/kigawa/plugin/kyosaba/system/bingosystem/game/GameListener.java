package net.kigawa.plugin.kyosaba.system.bingosystem.game;


import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameEquals;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

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
}
