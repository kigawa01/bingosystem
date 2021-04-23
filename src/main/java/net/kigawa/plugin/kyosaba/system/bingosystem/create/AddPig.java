package net.kigawa.plugin.kyosaba.system.bingosystem.create;

import net.kigawa.plugin.kigawautillib.Command.SubCommand;
import net.kigawa.plugin.kigawautillib.entity.GetEntity;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameTemplate;
import net.kigawa.plugin.kyosaba.system.bingosystem.game.Game;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddPig extends SubCommand {
    BingoSystem plugin;
    GameTemplate template;
    public AddPig(BingoSystem bingoSystem, GameTemplate gameTemplate) {
        super("addpig", "addpig <location> <location>");
        plugin=bingoSystem;
        template=gameTemplate;
    }

    @Override
    public boolean onSubCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        World world=((Player) commandSender).getWorld();
        template.pigUuid.set(0,
                new GetEntity().getNearest(
                        new Location(world,Double.parseDouble(strings[0]),
                                Double.parseDouble(strings[1]),Double.parseDouble(strings[2]))
                ).getUniqueId());
        template.pigUuid.set(1,
                new GetEntity().getNearest(
                        new Location(world,Double.parseDouble(strings[3]),
                                Double.parseDouble(strings[4]),Double.parseDouble(strings[5]))
                ).getUniqueId());

        return false;
    }
}
