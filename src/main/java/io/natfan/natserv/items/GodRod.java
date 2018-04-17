package io.natfan.natserv.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GodRod {
    public static ItemStack item() {
        ItemStack itemStack = new ItemStack(Material.FISHING_ROD);
        itemStack.setDurability((short) 16);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "God Rod");
        itemMeta.addEnchant(Enchantment.LUCK, 100, true);
        itemMeta.addEnchant(Enchantment.LURE, 5, true);
        itemMeta.setLore(Arrays.asList("", ChatColor.DARK_PURPLE + "Unrepairable", "", ChatColor.RED + "Custom Recipe"));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
