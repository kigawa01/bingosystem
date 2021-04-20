package net.kigawa.plugin.kyosaba.system.bingosystem.sql;

import net.kigawa.plugin.kigawautillib.KigawaUtilLib;
import net.kigawa.plugin.kigawautillib.gate.GateTimerSendCommand;
import net.kigawa.plugin.kigawautillib.sql.Connect;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;

public class Load {
    BingoSystem plugin;
    public Load(BingoSystem bingoSystem){
        plugin=bingoSystem;
        KigawaUtilLib utilLib= (KigawaUtilLib) plugin.getServer().getPluginManager().getPlugin("KigawaUtilLib");
        assert utilLib != null;
        Connect connect=utilLib.getConnect();
        GateSql[] gateSqls=(GateSql[]) connect.getDataSqlAll(new GateSql(plugin));
        for (int i=0;i< gateSqls.length;i++){
            plugin.getGate().setGate(new GateTimerSendCommand(plugin,gateSqls[i].gateName,
                    gateSqls[i].location,gateSqls[i].location1,"sendbingo"));
        }
    }
}
