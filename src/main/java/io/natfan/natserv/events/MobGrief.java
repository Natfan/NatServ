package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class MobGrief implements Listener {

    private final NatServ plugin;

    public MobGrief(NatServ plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void zombiesBreakingDoors(EntityBreakDoorEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void mobExplosion(EntityExplodeEvent event) {
        if (event.getEntityType() == EntityType.CREEPER ||
                event.getEntityType() == EntityType.WITHER ||
                event.getEntityType() == EntityType.WITHER_SKULL ||
                event.getEntityType() == EntityType.ENDER_DRAGON) {
            event.blockList().clear();
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void enermanBlockGrab(EntityChangeBlockEvent event) {
        if (event.getEntityType() == EntityType.ENDERMAN) {
            event.setCancelled(true);
        }
    }
}
