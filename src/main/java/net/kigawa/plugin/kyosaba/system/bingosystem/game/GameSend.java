package net.kigawa.plugin.kyosaba.system.bingosystem.game;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.List;

public class GameSend implements CommandExecutor {
    BingoSystem plugin;

    public GameSend(BingoSystem bingoSystem){
        plugin=bingoSystem;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player=(Player) sender;
            GameData gameData=plugin.getGameList().getGameData();
            if(!(gameData ==null)){
                int price=plugin.getConfig().getInt("price");
                if(plugin.getServer().dispatchCommand(sender, "money take "+sender.getName()+" "+price)){
                    player.teleport(gameData.startLoc);
                    List<GameBord> gameBords=gameData.gameBords;
                    GameBord gameBord=gameBords.get(gameBords.indexOf(null));
                    player.sendMessage(ChatColor.GOLD+"あなたの席は"+ChatColor.GREEN+gameBord.number+"番"+ChatColor.GOLD+"です");
                    gameData.setPlayer(player);
                }
            }else {
                player.sendMessage( ChatColor.DARK_RED+ "ビンゴの空きがありません");
            }


        return true;
    }
}
