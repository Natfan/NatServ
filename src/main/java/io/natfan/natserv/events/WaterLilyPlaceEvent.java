package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import io.natfan.natserv.items.WaterLily;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class WaterLilyPlaceEvent implements Listener {
    public NatServ plugin;

    public WaterLilyPlaceEvent(NatServ instance) {
        plugin = instance;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        if (event.getBlockAgainst().getType() == Material.WATER) {
            if (item == null) return;
            if (item.getType() == Material.AIR) return;
            if (!item.hasItemMeta()) return;
            if (item.getItemMeta().hasDisplayName()) {
                String name = item.getItemMeta().getDisplayName();
                if (name.equalsIgnoreCase(WaterLily.item().getItemMeta().getDisplayName())) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(ChatColor.YELLOW + "You " + ChatColor.RED + "cannot " + ChatColor.YELLOW + "place that " + WaterLily.item().getItemMeta().getDisplayName() + ChatColor.YELLOW + ".");
                }
            }
        }
    }
}
