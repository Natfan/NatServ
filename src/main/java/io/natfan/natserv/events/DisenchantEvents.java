package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class DisenchantEvents implements Listener {
    public NatServ plugin;

    public DisenchantEvents(NatServ instance) {
        plugin = instance;
    }

    @EventHandler
    public void onHitEnchantmentTable(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_BLOCK && event.hasItem()) {
            Player player = event.getPlayer();
            if (event.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE && (player.getGameMode() != GameMode.CREATIVE || player.getGameMode() != GameMode.SPECTATOR)) {
                ItemStack itemStack = event.getItem();
                if (itemStack != null && itemStack.getType() == Material.ENCHANTED_BOOK) {
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    if (itemMeta instanceof EnchantmentStorageMeta) {
                        EnchantmentStorageMeta storageMeta = (EnchantmentStorageMeta) itemMeta;
                        for (Enchantment enchantment : storageMeta.getStoredEnchants().keySet()) {
                            storageMeta.removeStoredEnchant(enchantment);
                        }
                        itemStack.setItemMeta(storageMeta);
                        event.setCancelled(true);
                        player.setItemInHand(new ItemStack(Material.BOOK, 1));
                        player.sendMessage(ChatColor.YELLOW + "You have just removed all enchantments from that book.");
                    }
                }
            }
        }

    }
}
