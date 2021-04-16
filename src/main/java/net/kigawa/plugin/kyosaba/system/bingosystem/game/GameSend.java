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
        Server server=plugin.getServer();

        Location[] startLoc={
                new Location(plugin.getServer().getWorld(label),Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]) ),
                new Location(plugin.getServer().getWorld(label),Integer.parseInt(args[3]),Integer.parseInt(args[4]),Integer.parseInt(args[5]) )
        };
        World world=startLoc[0].getWorld();
        assert world != null;
        List<Player> players=world.getPlayers();
        Player player=null;
        Iterator<Player> it=players.iterator();
        boolean isGet=false;
        double[] HL={startLoc[0].getX(),startLoc[0].getY(),startLoc[0].getZ()};
        double[] LL={startLoc[1].getX(),startLoc[1].getY(),startLoc[1].getZ()};
        while (it.hasNext()&&!isGet){
            player=(Player) it.next();
            Location locationPlayer=player.getLocation();
            double[] PL={locationPlayer.getX(),locationPlayer.getY(),locationPlayer.getZ()};
            if(LL[0]<=PL[0]&&PL[0]<=HL[0]&&LL[1]<=PL[1]&&PL[1]<=HL[1]&&LL[2]<=PL[2]&&PL[2]<=HL[2]){
                isGet=true;
            }
        }
        if(isGet){
            GameData gameData=plugin.getGameList().getGameData();
            if(!(gameData ==null)){
                int price=plugin.getConfig().getInt("price");
                if(plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "money take "+sender.getName()+" "+price)){
                    player.teleport(gameData.startLoc);
                    List<GameBord> gameBords=gameData.gameBords;
                    GameBord gameBord=gameBords.get(gameBords.indexOf(null));
                    player.sendMessage(ChatColor.GOLD+"あなたの席は"+ChatColor.GREEN+gameBord.number+"番"+ChatColor.GOLD+"です");
                    gameData.setPlayer(player);
                }
            }else {
                player.sendMessage( ChatColor.DARK_RED+ "ビンゴの空きがありません");
            }
        }else {
            sender.sendMessage(ChatColor.DARK_RED+ "player is exit");
        }


        return false;
    }
}
