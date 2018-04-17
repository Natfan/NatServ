package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DragonEvents implements Listener {
    public NatServ plugin;

    public DragonEvents(NatServ instance) {
        plugin = instance;
    }

    @EventHandler
    public void onEntityDamage(final EntityDamageEvent event) {
        if (event.getEntity() instanceof EnderDragon && event.getEntity().getWorld().getEnvironment() == World.Environment.THE_END) {
            event.getEntity().setCustomName(ChatColor.DARK_PURPLE + "Ender Dragon " + ChatColor.YELLOW.toString() + ChatColor.BOLD + Math.round(((EnderDragon) event.getEntity()).getHealth() / ((EnderDragon) event.getEntity()).getMaxHealth() * 100.0) + "% Health");
        }
    }
}
