package net.kigawa.plugin.kyosaba.system.bingosystem.config;

import net.kigawa.plugin.kigawautillib.config.ConfigData;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BingoSystemConfigData extends ConfigData {
    BingoSystem plugin;
    FileConfiguration config;
    public BingoSystemConfigData(BingoSystem plugin){
        super(plugin);
        this.plugin=plugin;
        config=super.getConfig();
    }@Override
    public void addDefault(){
        config.addDefault("version",1);
        config.addDefault("price",500);
        config.addDefault("gate table name","gate");

        plugin.saveConfig();
    }
}
