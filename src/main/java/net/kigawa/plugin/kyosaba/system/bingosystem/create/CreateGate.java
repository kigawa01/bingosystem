package net.kigawa.plugin.kyosaba.system.bingosystem.create;

import net.kigawa.plugin.kigawautillib.Command.SubCommand;
import net.kigawa.plugin.kigawautillib.gate.GateTimerSendCommand;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CreateGate extends SubCommand {
    BingoSystem plugin;

    public CreateGate(BingoSystem bingoSystem) {
        super("creategate","creategate <name> <world> <location> <Location>");
        plugin=bingoSystem;
    }

    @Override
    public boolean onSubCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length==6){
            double[] loc = new double[5];
            for (int i=2;i<strings.length;i++){
                loc[i]=Double.parseDouble(strings[i]);
                plugin.getGate().setGate(new GateTimerSendCommand(
                        plugin,
                        strings[0],
                        new Location(plugin.getServer().getWorld(strings[1]),loc[0],loc[1],loc[2]),
                        new Location(plugin.getServer().getWorld(strings[1]),loc[3],loc[4],loc[5]),
                        "sendbingo"
                ));
            }
        }
        return false;
    }
}
