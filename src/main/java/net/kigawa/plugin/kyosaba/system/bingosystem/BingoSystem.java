package net.kigawa.plugin.kyosaba.system.bingosystem;

import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kyosaba.system.bingosystem.config.BingoSystemConfigData;
import net.kigawa.plugin.kyosaba.system.bingosystem.game.Game;
import net.kigawa.plugin.kyosaba.system.bingosystem.pigrin.PiglinListener;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BingoSystem extends JavaPlugin {
    BingoSystem plugin=this;
    KigawaUtilLib util;
    @Override
    public void onEnable() {
        // Plugin startup logic
        Server server=getServer();
        PluginManager pluginManager=server.getPluginManager();
        util=(KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");

        new BingoSystemConfigData(plugin).getConfig();

        pluginManager.registerEvents(new PiglinListener(plugin),plugin);
        plugin.getCommand("startbingo").setExecutor(new Game(plugin));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
