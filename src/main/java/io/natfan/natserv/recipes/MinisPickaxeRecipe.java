package io.natfan.natserv.recipes;

import io.natfan.natserv.items.MinisPickaxe;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MinisPickaxeRecipe extends Recipes {
    private static ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK);

    private static ItemStack emerald = new ItemStack(Material.EMERALD_BLOCK);

    private static ItemStack stick = new ItemStack(Material.STICK);

    private static ItemStack air() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW.toString() + "");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    private static ItemStack result = MinisPickaxe.item();

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        Recipes.show(player);
        inventory.setItem(1, diamond);
        inventory.setItem(2, diamond);
        inventory.setItem(3, diamond);

        inventory.setItem(10, emerald);
        inventory.setItem(11, stick);
        inventory.setItem(12, emerald);

        inventory.setItem(15, result);

        inventory.setItem(19, air());
        inventory.setItem(20, stick);
        inventory.setItem(21, air());
    }
}