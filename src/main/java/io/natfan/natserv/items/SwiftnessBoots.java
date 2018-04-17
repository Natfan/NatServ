package io.natfan.natserv.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SwiftnessBoots {
    public static ItemStack item() {
        ItemStack itemStack = new ItemStack(Material.GOLD_BOOTS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Swiftness Boots");
        //if (!Bukkit.getVersion().contains("1.8")) {
            //itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        //} else {
            itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        //}
        itemMeta.setLore(Arrays.asList(ChatColor.GRAY + "Swiftness II", "", ChatColor.DARK_PURPLE + "Unrepairable", "", ChatColor.RED + "Custom Recipe"));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
