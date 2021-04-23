package net.kigawa.plugin.kyosaba.system.bingosystem.create;

import net.kigawa.plugin.kigawautillib.Command.SubCommand;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameTemplate;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddStartLoc extends SubCommand {
    BingoSystem plugin;
    GameTemplate template;
    public AddStartLoc(BingoSystem bingoSystem, GameTemplate gameTemplate) {
        super("addstartloc", "addstartloc <location>");
        plugin=bingoSystem;
        template=gameTemplate;
    }

    @Override
    public boolean onSubCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        template.startLoc = new Location(((Player) commandSender).getWorld(), Double.parseDouble(strings[0]),
                Double.parseDouble(strings[1]), Double.parseDouble(strings[2]));
        return true;
    }
}
