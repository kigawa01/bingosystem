package net.kigawa.plugin.kyosaba.system.bingosystem.create;

import net.kigawa.plugin.kigawautillib.Command.SubCommand;
import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameTemplate;
import net.kigawa.plugin.kyosaba.system.bingosystem.sql.GameSql;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CreateGame extends SubCommand {
    BingoSystem plugin;
    GameTemplate template;
    public CreateGame(BingoSystem bingoSystem, GameTemplate template) {
        super("creategame", "creategame <name>");
        plugin=bingoSystem;
        this.template=template;
    }

    @Override
    public boolean onSubCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(template.canUse()) {
            template.name = strings[0];
            plugin.getGameList().createGame(template);
            GameSql gameSql=new GameSql(plugin);
            gameSql.setFromTemplate(template);
            KigawaUtilLib utilLib = (KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");
            utilLib.getConnect().setData(gameSql);
            return true;
        }
        return false;
    }
}
