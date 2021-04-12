package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import jp.jyn.jecon.Jecon;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class GameStart implements CommandExecutor {
    BingoSystem plugin;
    public GameStart(BingoSystem bingoSystem){
        plugin=bingoSystem;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int price=plugin.getConfig().getInt("price");
        if(plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "money take "+sender.getName()+" "+price)){

        }else {
            sender.sendMessage("need $"+price);
        }
        return false;
    }
}
