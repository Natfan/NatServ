package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class AnvilEvents implements Listener {
    public NatServ plugin;

    public AnvilEvents(NatServ instance) {
        plugin = instance;
    }

    @EventHandler
    public void onAnvil(InventoryClickEvent event) {
        HumanEntity humanEntity = event.getWhoClicked();
        if (humanEntity instanceof Player) {
            Player player = (Player) humanEntity;
            if (event.getView().getType() == InventoryType.ANVIL) {
                if (event.getRawSlot() == 2) {
                    ItemStack input = event.getInventory().getItem(0);
                    ItemStack output = event.getInventory().getItem(2);
                    if (input != null && input.getType() != Material.AIR && output != null && output.getType() != Material.AIR) {
                        if (input.hasItemMeta() && output.hasItemMeta()) {
                            if (input.getItemMeta().hasLore() && output.getItemMeta().hasLore()) {
                                if (input.getItemMeta().getLore().contains(ChatColor.RED + "Custom Recipe") ||
                                        output.getItemMeta().getLore().contains(ChatColor.RED + "Custom Recipe") ||
                                        input.getType() == Material.MOB_SPAWNER ||
                                        output.getType() == Material.MOB_SPAWNER) {
                                    event.setCancelled(true);
                                    player.sendMessage(ChatColor.RED + "You cannot use this item in an Anvil.");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
