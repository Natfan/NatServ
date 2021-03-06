package io.natfan.natserv.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BreathingHelmet {
    public static ItemStack item() {
        ItemStack itemStack = new ItemStack(Material.GOLD_HELMET);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Breathing Helmet");
        itemMeta.addEnchant(Enchantment.WATER_WORKER, 1, true);
        itemMeta.addEnchant(Enchantment.OXYGEN, 3, true);
        itemMeta.setLore(Arrays.asList(ChatColor.GRAY + "Water Breathing I", "", ChatColor.DARK_PURPLE + "Unrepairable", "", ChatColor.RED + "Custom Recipe"));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
