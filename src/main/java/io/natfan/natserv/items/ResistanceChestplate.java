package io.natfan.natserv.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ResistanceChestplate {
    public static ItemStack item() {
        ItemStack itemStack = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Resistance Chestplate");
        itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
        itemMeta.setLore(Arrays.asList(ChatColor.GRAY + "Resistance I", ChatColor.GRAY + "Fire Resistance I", "", ChatColor.DARK_PURPLE + "Unrepairable", "", ChatColor.RED + "Custom Recipe"));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
