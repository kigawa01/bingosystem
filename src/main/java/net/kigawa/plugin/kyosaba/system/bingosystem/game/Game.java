package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kigawautillib.data.DataTask;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class Game extends BukkitRunnable {
    BingoSystem plugin;
    public Game(BingoSystem bingoSystem, List<DataTask> tasks,String name){
        plugin=bingoSystem;
        DataTask dataTask=new DataTask(name);
        dataTask.id=getTaskId();
        tasks.add(new DataTask(name));

    }

    @Override
    public void run() {

    }
}
