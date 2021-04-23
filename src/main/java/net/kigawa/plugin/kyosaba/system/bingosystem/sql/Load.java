package net.kigawa.plugin.kyosaba.system.bingosystem.sql;

import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kigawautillib.gate.GateTimerSendCommand;
import net.kigawa.plugin.kigawautillib.sql.Connect;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameTemplate;
import net.kigawa.plugin.kyosaba.system.bingosystem.game.Game;
import net.kigawa.plugin.kyosaba.system.bingosystem.game.GameData;

public class Load {
    BingoSystem plugin;
    public Load(BingoSystem bingoSystem){
        plugin=bingoSystem;
        loadGate();
    }
    public void loadGate(){
        KigawaUtilLib utilLib= (KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");
        assert utilLib != null;
        Connect connect=utilLib.getConnect();
        GateSql[] gateSqls=(GateSql[]) connect.getDataSqlAll(new GateSql(plugin));
        for (GateSql gateSql : gateSqls) {
            plugin.getGate().setGate(new GateTimerSendCommand(plugin, gateSql.gateName,
                    gateSql.location, gateSql.location1, "sendbingo"));
        }
    }
    public void loadGame(){
        KigawaUtilLib utilLib= (KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");
        assert utilLib != null;
        Connect connect=utilLib.getConnect();
        GameSql[] gameSqls=(GameSql[]) connect.getDataSqlAll(new GameSql(plugin));
        for (GameSql gameSql : gameSqls) {
            plugin.getGameList().createGame(gameSql.toTemplate());
        }
    }
}
