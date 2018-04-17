package io.natfan.natserv.recipes;

import io.natfan.natserv.items.SaturationLeggings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SaturationLeggingsRecipe extends Recipes {
    private static ItemStack diamond = new ItemStack(Material.DIAMOND);

    private static ItemStack emerald = new ItemStack(Material.EMERALD);

    private static ItemStack cookie = new ItemStack(Material.COOKIE);

    private static ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);

    private static ItemStack opple = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);

    private static ItemStack result = SaturationLeggings.item();

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        Recipes.show(player);
        inventory.setItem(1, diamond);
        inventory.setItem(2, cookie);
        inventory.setItem(3, diamond);

        inventory.setItem(10, emerald);
        inventory.setItem(11, leggings);
        inventory.setItem(12, emerald);

        inventory.setItem(15, result);

        inventory.setItem(19, diamond);
        inventory.setItem(20, opple);
        inventory.setItem(21, diamond);
    }
}