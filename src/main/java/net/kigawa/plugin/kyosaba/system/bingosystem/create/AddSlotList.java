package net.kigawa.plugin.kyosaba.system.bingosystem.create;

import net.kigawa.plugin.kigawautillib.Command.SubCommand;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameTemplate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class AddSlotList extends SubCommand {
    BingoSystem plugin;
    GameTemplate template;
    public AddSlotList(BingoSystem bingoSystem, GameTemplate gameTemplate) {
        super("addslotlist", "addslotlist <number>");
        plugin=bingoSystem;
        template=gameTemplate;
    }

    @Override
    public boolean onSubCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        template.slotUUIDList.set(Integer.parseInt(strings[0])-1,
                template.slotUUID);
        return false;
    }
}
