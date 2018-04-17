package io.natfan.natserv.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Crowbar {
    public static ItemStack item() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "Crowbar");
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        itemMeta.setLore(Arrays.asList(ChatColor.GRAY + "Strong Arm I", "", ChatColor.YELLOW + "Usage: " + ChatColor.GREEN + "1" + ChatColor.YELLOW + "/" + ChatColor.GREEN + "1", "", ChatColor.DARK_PURPLE + "Unrepairable", "", ChatColor.RED + "Custom Recipe"));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
