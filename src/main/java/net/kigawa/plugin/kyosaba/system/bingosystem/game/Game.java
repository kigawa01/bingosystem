package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kigawautillib.data.DataTask;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class Game extends BukkitRunnable {
    BingoSystem plugin;
    boolean canStart=false;
    GameData gameData;
    Iterator<GameBord> iterator;
    boolean isGameEnd=false;
    public Game(BingoSystem bingoSystem, List<DataTask> tasks,GameData gameData){
        String name= gameData.name;
        plugin=bingoSystem;
        DataTask dataTask=new DataTask(name);
        dataTask.id=getTaskId();
        tasks.add(new DataTask(name));
        this.gameData=gameData;
        iterator=gameData.gameBords.iterator();
    }

    @Override
    public void run() {
        if(canStart=false){
            if(!gameData.isLottery){
                GameBord gameBord=gameData.getNextLottery();
                GameLottery lottery= gameData.lottery;
                lottery.reset();
                gameBord.lotteryCount=0;
                gameBord.player.sendTitle(Color.GREEN+"くじを引いてください","",20,50,20);
            }
            if(gameData.isLotteryEnd()){
                while (iterator.hasNext()){
                    iterator.next().player.sendTitle(Color.GREEN+"ゲームスタート","",20,50,20);
                    canStart=true;
                }
            }
        }else {
            if (isGameEnd=false){

            }

        }
    }
}
