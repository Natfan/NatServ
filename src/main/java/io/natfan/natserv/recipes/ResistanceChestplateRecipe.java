package io.natfan.natserv.recipes;

import io.natfan.natserv.items.CompressedObsidian;
import io.natfan.natserv.items.ResistanceChestplate;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ResistanceChestplateRecipe extends Recipes {
    private static ItemStack obsidian = new ItemStack(CompressedObsidian.item());

    private static ItemStack magmacream = new ItemStack(Material.MAGMA_CREAM);

    private static ItemStack diamondchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);

    private static ItemStack result = ResistanceChestplate.item();

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        Recipes.show(player);
        inventory.setItem(1, obsidian);
        inventory.setItem(2, magmacream);
        inventory.setItem(3, obsidian);

        inventory.setItem(10, obsidian);
        inventory.setItem(11, diamondchestplate);
        inventory.setItem(12, obsidian);

        inventory.setItem(15, result);

        inventory.setItem(19, obsidian);
        inventory.setItem(20, obsidian);
        inventory.setItem(21, obsidian);
    }
}