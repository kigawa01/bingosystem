package net.kigawa.plugin.kyosaba.system.bingosystem.create;

import net.kigawa.plugin.kigawautillib.Command.SubCommand;
import net.kigawa.plugin.kigawautillib.entity.GetEntity;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameTemplate;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.List;

public class AddSlot extends SubCommand {
    BingoSystem plugin;
    GameTemplate template;
    public AddSlot(BingoSystem bingoSystem, GameTemplate gameTemplate) {
        super("addslot", "addslot <number> <location>");
        plugin=bingoSystem;
        template=gameTemplate;
    }

    @Override
    public boolean onSubCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        World world=((Player)commandSender).getWorld();
        Location location=new Location(world,Double.parseDouble(strings[1]),Double.parseDouble(strings[2]),Double.parseDouble(strings[3]));
        Entity nearest=new GetEntity().getNearest(location);
        template.slotUUID[Integer.parseInt(strings[0])-1]=nearest.getUniqueId();
        return true;
    }
}
