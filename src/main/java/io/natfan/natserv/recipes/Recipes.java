package io.natfan.natserv.recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class Recipes {
    private static List<String> viewers;

    private static ItemStack blank() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW.toString() + "");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    private static ItemStack unblank() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "ERROR: Item not set.");
        itemMeta.setLore(Arrays.asList(ChatColor.GRAY + "Please see Natfan for further assistance."));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    static Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Recipe Viewer");

    static void show(Player player) {
        inventory.setItem(0, blank());
        inventory.setItem(1, unblank());
        inventory.setItem(2, unblank());
        inventory.setItem(3, unblank());
        inventory.setItem(4, blank());
        inventory.setItem(5, blank());
        inventory.setItem(6, blank());
        inventory.setItem(7, blank());
        inventory.setItem(8, blank());
        inventory.setItem(9, blank());
        inventory.setItem(10, unblank());
        inventory.setItem(11, unblank());
        inventory.setItem(12, unblank());
        inventory.setItem(13, blank());
        inventory.setItem(14, blank());
        inventory.setItem(15, unblank());
        inventory.setItem(16, blank());
        inventory.setItem(17, blank());
        inventory.setItem(18, blank());
        inventory.setItem(19, unblank());
        inventory.setItem(20, unblank());
        inventory.setItem(21, unblank());
        inventory.setItem(22, blank());
        inventory.setItem(23, blank());
        inventory.setItem(24, blank());
        inventory.setItem(25, blank());
        inventory.setItem(26, blank());
        player.openInventory(inventory);
    }
}