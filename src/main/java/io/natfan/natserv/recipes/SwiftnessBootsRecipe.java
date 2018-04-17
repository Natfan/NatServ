package io.natfan.natserv.recipes;

import io.natfan.natserv.items.SwiftnessBoots;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SwiftnessBootsRecipe extends Recipes {
    private static ItemStack feather = new ItemStack(Material.FEATHER);

    private static ItemStack gold = new ItemStack(Material.GOLD_BLOCK);

    private static ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK);

    private static ItemStack air() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW.toString() + "");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    private static ItemStack result = SwiftnessBoots.item();

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        Recipes.show(player);
        inventory.setItem(1, feather);
        inventory.setItem(2, feather);
        inventory.setItem(3, feather);

        inventory.setItem(10, gold);
        inventory.setItem(11, diamond);
        inventory.setItem(12, gold);

        inventory.setItem(15, result);

        inventory.setItem(19, gold);
        inventory.setItem(20, air());
        inventory.setItem(21, gold);
    }
}