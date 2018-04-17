package io.natfan.natserv.recipes;

import io.natfan.natserv.items.CompressedObsidian;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CompressedObsidianRecipe extends Recipes {
    private static ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
    private static ItemStack result = new ItemStack(CompressedObsidian.item());

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        Recipes.show(player);
        inventory.setItem(1, obsidian);
        inventory.setItem(2, obsidian);
        inventory.setItem(3, obsidian);

        inventory.setItem(10, obsidian);
        inventory.setItem(11, obsidian);
        inventory.setItem(12, obsidian);

        inventory.setItem(15, result);

        inventory.setItem(19, obsidian);
        inventory.setItem(20, obsidian);
        inventory.setItem(21, obsidian);
    }
}