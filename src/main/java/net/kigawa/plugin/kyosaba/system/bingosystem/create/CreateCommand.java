package net.kigawa.plugin.kyosaba.system.bingosystem.create;

import net.kigawa.plugin.kigawautillib.Command.SubCommand;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CreateCommand extends net.kigawa.plugin.kigawautillib.Command.Command {
    BingoSystem plugin;
    public CreateCommand(BingoSystem bingoSystem){
        super(bingoSystem);
        plugin=bingoSystem;
        List<SubCommand> subCommands=super.getSubCommands();
        subCommands.add(new CreateGate(plugin));
    }
    @Override
    public boolean onMainCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return true;
    }
}
