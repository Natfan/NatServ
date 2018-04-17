package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import io.natfan.natserv.items.CompressedObsidian;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class CompressedObsidianPlaceEvent implements Listener {
    public NatServ plugin;

    public CompressedObsidianPlaceEvent(NatServ instance) {
        plugin = instance;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        if (item == null) return;
        if (item.getType() == Material.AIR) return;
        if (!item.hasItemMeta()) return;
        if (item.getItemMeta().hasDisplayName()) {
            String name = item.getItemMeta().getDisplayName();
            if (name.equalsIgnoreCase(CompressedObsidian.item().getItemMeta().getDisplayName())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.YELLOW + "You " + ChatColor.RED + "cannot " + ChatColor.YELLOW + "place that " + CompressedObsidian.item().getItemMeta().getDisplayName() + ChatColor.YELLOW + ".");
            }
        }
    }
}
