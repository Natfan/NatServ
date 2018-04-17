package io.natfan.natserv.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class WaterLily {
    public static ItemStack item() {
        ItemStack itemStack = new ItemStack(Material.WATER_LILY);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Water Lily");
        itemMeta.addEnchant(Enchantment.THORNS, 10, true);
        itemMeta.setLore(Arrays.asList("", ChatColor.DARK_PURPLE + "Unplaceable", "", ChatColor.RED + "Custom Recipe"));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
