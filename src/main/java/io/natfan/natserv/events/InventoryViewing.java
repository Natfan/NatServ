package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InventoryViewing implements Listener {
    public NatServ plugin;

    public InventoryViewing(NatServ instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerClickInInventory(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();
        InventoryType.SlotType slotType = event.getSlotType();
        //if (inventory.getName() == null) return;
        if (slotType == InventoryType.SlotType.CONTAINER) {
            if (inventory.getName().equalsIgnoreCase(ChatColor.GREEN + "Recipe Viewer")) {
                if (event.getCurrentItem() == null) return;
                if (event.getCurrentItem().getType() == Material.AIR) return;
                event.setCancelled(true);
            }
        }
    }
}