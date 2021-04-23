package net.kigawa.plugin.kyosaba.system.bingosystem.data;

import org.bukkit.Location;

import java.util.List;
import java.util.UUID;

public class GameTemplate {
    public String name;
    public Location startLoc;
    public Location lotteryLoc;
    public Location lotteryLoc1;
    public List<UUID[]> slotUUIDList;
    public List<UUID> pigUuid;
    public List<Location[]> buttonLoc;

    public UUID[] slotUUID;
    public boolean canUse(){
        return name!=null&&startLoc!=null&&lotteryLoc!=null&&lotteryLoc1!=null&&slotUUIDList!=null&&
                pigUuid!=null&&buttonLoc!=null;
    }
}
