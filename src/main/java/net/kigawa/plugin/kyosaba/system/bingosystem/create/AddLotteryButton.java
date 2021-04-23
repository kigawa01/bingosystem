package net.kigawa.plugin.kyosaba.system.bingosystem.create;

import net.kigawa.plugin.kigawautillib.Command.SubCommand;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameTemplate;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddLotteryButton extends SubCommand {
    BingoSystem plugin;
    GameTemplate template;
    public AddLotteryButton(BingoSystem bingoSystem, GameTemplate gameTemplate) {
        super("addlotterybutton","addlotterybutton <location> <location>");
        plugin=bingoSystem;
        template=gameTemplate;
    }

    @Override
    public boolean onSubCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        World world=((Player) commandSender).getWorld();
        template.buttonLoc.set(0,
                new Location[] {
                        new Location(world,Double.parseDouble(strings[0]),Double.parseDouble(strings[1]),Double.parseDouble(strings[2])),
                        new Location(world,Double.parseDouble(strings[3]),Double.parseDouble(strings[4]),Double.parseDouble(strings[5]))
                });
        return false;
    }
}
