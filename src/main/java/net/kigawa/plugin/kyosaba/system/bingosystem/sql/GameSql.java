package net.kigawa.plugin.kyosaba.system.bingosystem.sql;

import net.kigawa.plugin.kigawautillib.sql.DataSql;
import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.GameTemplate;
import net.kigawa.plugin.kyosaba.system.bingosystem.data.YamlUUIDs;
import org.bukkit.Location;
import org.bukkit.World;
import org.yaml.snakeyaml.Yaml;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class GameSql implements DataSql {
    BingoSystem plugin;
    String table;
    String name=null;
    Location startLoc=null;
    org.bukkit.Location lotteryLoc=null;
    org.bukkit.Location lotteryLoc1=null;
    List<UUID[]> slotUUIDList=null;
    List<UUID> pigUuid=null;
    List<org.bukkit.Location[]> buttonLoc=null;
    public GameSql(BingoSystem bingoSystem){
        plugin=bingoSystem;
        table=plugin.getConfig().getString("game table name");
    }
    public GameTemplate toTemplate(){
        GameTemplate template=new GameTemplate();
        template.name=name;
        template.startLoc=startLoc;
        template.lotteryLoc=lotteryLoc;
        template.lotteryLoc1=lotteryLoc1;
        template.slotUUIDList=slotUUIDList;
        template.buttonLoc=buttonLoc;
        return template;
    }
    public void setFromTemplate(GameTemplate t){
        name=t.name;
        startLoc=t.startLoc;
        lotteryLoc=t.lotteryLoc;
        lotteryLoc1=t.lotteryLoc1;
        slotUUIDList=t.slotUUIDList;
        buttonLoc=t.buttonLoc;
    }
    @Override
    public String[] getColumns() {
        return new String[] {
                "name",

        };
    }

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public String[] getType() {
        return new String[]{

        };
    }

    @Override
    public String[] getWhere() {
        return new String[]{

        };
    }

    @Override
    public String[] getValue() {
        List<String> strUUID = null;
        for (UUID[] uuids:slotUUIDList){
            for (UUID temp:uuids){
                strUUID.add(temp.toString());
            }
        }
        String strSlotUUID;
        YamlUUIDs yamlUUIDs = new YamlUUIDs(strUUID);
        Yaml yaml=new Yaml();
        String yamlSlot=yaml.dumpAsMap(yamlUUIDs);
        return new String[]{
                name,
                String.valueOf(startLoc.getX()),
                String.valueOf(startLoc.getY()),
                String.valueOf(startLoc.getZ()),
                String.valueOf(lotteryLoc.getX()),
                String.valueOf(lotteryLoc.getY()),
                String.valueOf(lotteryLoc.getZ()),
                String.valueOf(lotteryLoc1.getX()),
                String.valueOf(lotteryLoc1.getY()),
                String.valueOf(lotteryLoc1.getZ()),
                yamlSlot,
                pigUuid.get(0).toString(),
                pigUuid.get(1).toString(),
                String.valueOf(buttonLoc.get(0)[0].getX()),
                String.valueOf(buttonLoc.get(0)[0].getY()),
                String.valueOf(buttonLoc.get(0)[0].getZ()),
                String.valueOf(buttonLoc.get(0)[1].getX()),
                String.valueOf(buttonLoc.get(0)[1].getY()),
                String.valueOf(buttonLoc.get(0)[1].getZ()),
                startLoc.getWorld().toString()
        };
    }

    @Override
    public void setValue(String[] s) {
        World world=plugin.getServer().getWorld(s[20]);
        name=s[0];
        startLoc=new Location(world,Double.parseDouble(s[1]),
                Double.parseDouble(s[2]),Double.parseDouble(s[3]));
        lotteryLoc=new Location(world,Double.parseDouble(s[4]),
                Double.parseDouble(s[5]),Double.parseDouble(s[6]));
        lotteryLoc1=new Location(world,Double.parseDouble(s[7]),
                Double.parseDouble(s[8]),Double.parseDouble(s[9]));
        List<String> strUUID=new Yaml().load(s[10]);
        pigUuid.set(0,UUID.fromString(s[11]));
        pigUuid.set(1,UUID.fromString(s[12]));
        Location[] location=new Location[] {
                new Location(world,Double.parseDouble(s[13]),
                        Double.parseDouble(s[14]),Double.parseDouble(s[15])),
                new Location(world,Double.parseDouble(s[16]),
                        Double.parseDouble(s[17]),Double.parseDouble(s[18]))
        };
        UUID[] uuids=null;
        int i2=0;
        for (int i=0;i<strUUID.size();i++){
            for (int i1=0;i1<9;i1++){
                i++;
                uuids[i1]=UUID.fromString(strUUID.get(i));
            }
            slotUUIDList.set(i2,uuids);
            buttonLoc.set(i2,location);
            i2++;
        }

    }

}
