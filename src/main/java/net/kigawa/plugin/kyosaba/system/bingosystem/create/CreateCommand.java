package net.kigawa.plugin.kyosaba.system.bingosystem.create;

import net.kigawa.plugin.kigawautillib.Command.SubCommand;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameTemplate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CreateCommand extends net.kigawa.plugin.kigawautillib.Command.Command {
    BingoSystem plugin;
    GameTemplate template=new GameTemplate();
    public CreateCommand(BingoSystem bingoSystem){
        super(bingoSystem);
        plugin=bingoSystem;
        List<SubCommand> subCommands=super.getSubCommands();
        subCommands.add(new CreateGate(plugin));
        subCommands.add(new CreateGame(plugin,template));
        subCommands.add(new AddStartLoc(plugin,template));
        subCommands.add(new AddLotteryButton(plugin,template));
        subCommands.add(new AddLotteryLoc(plugin,template));
        subCommands.add(new AddPig(plugin,template));
        subCommands.add(new AddSlot(plugin,template));
        subCommands.add(new AddSlotList(plugin,template));

    }
    @Override
    public boolean onMainCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return true;
    }
}
