package net.kigawa.plugin.kyosaba.system.bingosystem.pigrin;

import net.kigawa.plugin.kyosaba.system.bingosystem.BingoSystem;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Piglin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;

public class PiglinListener implements Listener {
    BingoSystem plugin;
    public PiglinListener(BingoSystem plugin){
        this.plugin=plugin;
    }


    @EventHandler
    public void tradeEvent(LootGenerateEvent event){
        Entity entity=event.getEntity();
        EntityType entityType=entity.getType();
        if(entityType.equals(EntityType.PIGLIN)&&entity.removeScoreboardTag("casino")){
            entity.addScoreboardTag("bingo");
            Piglin piglin=(Piglin) entity;

        }else {
            entity.addScoreboardTag("bingo");
        }
    }
}
