package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.Material;

import javax.xml.stream.Location;

public class GameSlot {
    BingoSystem plugin;
    Location location;
    Material material;
    public GameSlot(BingoSystem bingoSystem,Location location,Material material){
        plugin=bingoSystem;
        this.location=location;
        this.material=material;
    }
}
