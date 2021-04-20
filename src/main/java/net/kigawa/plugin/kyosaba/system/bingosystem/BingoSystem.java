package net.kigawa.plugin.kyosaba.system.bingosystem;

import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kigawautillib.data.DataTask;
import net.kigawa.plugin.kigawautillib.gate.Gate;
import net.kigawa.plugin.kyosaba.system.bingosystem.config.BingoSystemConfigData;
import net.kigawa.plugin.kyosaba.system.bingosystem.create.CreateCommand;
import net.kigawa.plugin.kyosaba.system.bingosystem.game.GameList;
import net.kigawa.plugin.kyosaba.system.bingosystem.game.GameListener;
import net.kigawa.plugin.kyosaba.system.bingosystem.game.GameSend;
import net.kigawa.plugin.kyosaba.system.bingosystem.game.GameStart;
import net.kigawa.plugin.kyosaba.system.bingosystem.listener.PiglinListener;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class BingoSystem extends JavaPlugin {
    BingoSystem plugin=this;
    KigawaUtilLib util;
    GameList gameList;
    List<DataTask> task;
    Gate gate;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Server server=getServer();
        PluginManager pluginManager=server.getPluginManager();
        util=(KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");

        new BingoSystemConfigData(plugin).getConfig();
        gate=new Gate(plugin);

        pluginManager.registerEvents(new PiglinListener(plugin),plugin);
        plugin.getCommand("sendbingo").setExecutor(new GameSend(plugin));
        plugin.getCommand("startbingo").setExecutor(new GameStart(plugin));
        plugin.getCommand("GameCreate").setExecutor(new CreateCommand(plugin));
        pluginManager.registerEvents(new GameListener(plugin),plugin);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public GameList getGameList(){
        return gameList;
    }
    public List<DataTask> getTask(){
        return task;
    }
    public Gate getGate(){
        return gate;
    }
}
