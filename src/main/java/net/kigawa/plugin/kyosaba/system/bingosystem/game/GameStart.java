package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GameStart implements CommandExecutor {
    BingoSystem plugin;
    GameList gameList;
    public GameStart(BingoSystem bingoSystem){
        plugin=bingoSystem;
        gameList=plugin.getGameList();

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        GameData gameData=gameList.getGameData();
        new Game(plugin,plugin.getTask(),gameData.name).runTaskTimer(plugin,0,1);
        return true;
    }
}
