package net.kigawa.plugin.kyosaba.system.bingosystem.sql;

import net.kigawa.plugin.kigawautillib.gate.Gate;
import net.kigawa.plugin.kigawautillib.sql.DataSql;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.Location;


public class GateSql implements DataSql {
    BingoSystem plugin;
    String tableName;
    String gateName;
    String world;
    Location location;
    Location location1;
    public GateSql(BingoSystem bingoSystem){
        plugin=bingoSystem;
        tableName=plugin.getConfig().getString("gate table name");
    }
    @Override
    public String[] getColumns() {
        return new String[]{
                "gateName",
                "world",
                "locX",
                "locY",
                "locZ",
                "1locX",
                "1locY",
                "1locZ"
        };
    }

    @Override
    public String getTable() {
        return tableName;
    }

    @Override
    public String[] getType() {
        return new String[]{
                "varchar(10)",
                "varchar(10)",
                "double",
                "double",
                "double",
                "double",
                "double",
                "double"
        };
    }

    @Override
    public String[] getWhere() {
        return new String[]{
                "gateName",
                gateName
        };
    }

    @Override
    public String[] getValue() {
        return new String[]{
                gateName,
                location.getWorld().toString(),
                String.valueOf(location.getBlockX()),
                String.valueOf(location.getBlockY()),
                String.valueOf(location.getBlockZ()),

                String.valueOf(location1.getBlockX()),
                String.valueOf(location1.getBlockY()),
                String.valueOf(location1.getBlockZ())
        };
    }

    @Override
    public void setValue(String[] strings) {
        gateName=strings[0];
        location=new Location(
                plugin.getServer().getWorld(strings[1]),
                Double.parseDouble(strings[2]),
                Double.parseDouble(strings[3]),
                Double.parseDouble(strings[4])
        );
        location1=new Location(
                plugin.getServer().getWorld(strings[1]),
                Double.parseDouble(strings[5]),
                Double.parseDouble(strings[6]),
                Double.parseDouble(strings[7])
        );
    }
    public void setTableName(String tableName){
        this.tableName=tableName;
    }
    public void setLocation(Location location){
        this.location=location;
    }
    public void setLocation1(Location location){
        this.location1=location;
    }
}
