package io.natfan.natserv.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SaturationLeggings {
    public static ItemStack item() {
        ItemStack itemStack = new ItemStack(Material.GOLD_LEGGINGS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Saturation Leggings");
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        itemMeta.setLore(Arrays.asList(ChatColor.GRAY + "Saturation V", "", ChatColor.DARK_PURPLE + "Unrepairable", "", ChatColor.RED + "Custom Recipe"));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
