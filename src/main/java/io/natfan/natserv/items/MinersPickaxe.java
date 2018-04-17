package io.natfan.natserv.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MinersPickaxe {
    public static ItemStack item() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Miner's Pickaxe");
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        itemMeta.setLore(Arrays.asList(ChatColor.GRAY + "Haste II", ChatColor.GRAY + "Night Vision I", "", ChatColor.DARK_PURPLE + "Unrepairable", "", ChatColor.RED + "Custom Recipe"));
        itemMeta.spigot().setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
