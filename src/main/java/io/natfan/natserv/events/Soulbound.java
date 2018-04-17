package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static io.natfan.natserv.booleans.isSoulbound.isSoulbound;

public class Soulbound implements Listener {
    public NatServ plugin;

    public Soulbound(NatServ instance) {
        plugin = instance;
    }

    public static ItemStack soulbound(ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.hasLore()) {
            if (itemMeta.getLore().isEmpty()) {
                itemMeta.setLore(Arrays.asList(ChatColor.GOLD + "Soulbound"));
            } else {
                List<String> temp = itemMeta.getLore();
                temp.add(ChatColor.GOLD + "Soulbound");
                itemMeta.setLore(temp);
            }
        } else {
            itemMeta.setLore(Arrays.asList(ChatColor.GOLD + "Soulbound"));
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static void removeSoulbind(ItemStack itemStack) {
        if (itemStack.hasItemMeta()) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta.hasLore()) {
                if (!itemMeta.getLore().isEmpty()) {
                    List<String> lore = itemMeta.getLore();
                    while (lore.remove(ChatColor.GOLD + "Soulbound")){}
                    itemMeta.setLore(lore);
                }
            }
            itemStack.setItemMeta(itemMeta);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (isSoulbound(event.getItemDrop().getItemStack())) {
            if (!NatServ.soulboundToggle.contains(event.getPlayer().getUniqueId().toString())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "As that item was " + ChatColor.GOLD + "Soulbound" + ChatColor.RED + ", you cannot drop it.");
                event.getPlayer().sendMessage(ChatColor.RED + "Your " + ChatColor.RESET + ChatColor.LIGHT_PURPLE + event.getItemDrop().getItemStack().getType() + ChatColor.RED + " is " + ChatColor.GOLD + "Soulbound " + ChatColor.RED + "and cannot be dropped.");
                event.getPlayer().sendMessage(ChatColor.RED + "Use " + ChatColor.YELLOW + "/soulbound toggle " + ChatColor.RED + "to be able to drop " + ChatColor.GOLD + "Soulbound " + ChatColor.RED + "items.");
                event.getPlayer().playNote(event.getPlayer().getLocation(), Instrument.BASS_DRUM, Note.flat(0, Note.Tone.A));
            } else {
                event.getPlayer().sendMessage(ChatColor.RED + "Your " + ChatColor.RESET + ChatColor.LIGHT_PURPLE + event.getItemDrop().getItemStack().getType() + ChatColor.RED + " is " + ChatColor.GOLD + "Soulbound " + ChatColor.RED + "and it was lost to the " + ChatColor.DARK_PURPLE + "void" + ChatColor.RED + ".");
                event.getItemDrop().remove();
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.PORTAL_TRIGGER, 1, 1);
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Iterator<ItemStack> iterator = event.getDrops().iterator();
        while (iterator.hasNext()) {
            ItemStack stack = iterator.next();
            if (isSoulbound(stack)) {
                iterator.remove();
                break;
            }
        }

        event.getEntity().sendMessage(ChatColor.RED + "An item that you had was " + ChatColor.GOLD + "Soulbound" + ChatColor.RED + ". It has been lost to the void as you have died!");
        event.getEntity().playSound(event.getEntity().getLocation(), Sound.PORTAL_TRIGGER, 1, 1);
    }
}
