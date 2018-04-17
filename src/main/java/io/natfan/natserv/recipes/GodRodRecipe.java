package io.natfan.natserv.recipes;

import io.natfan.natserv.items.CompressedObsidian;
import io.natfan.natserv.items.GodRod;
import io.natfan.natserv.items.WaterLily;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GodRodRecipe extends Recipes {
    private static ItemStack obsidian = CompressedObsidian.item();
    private static ItemStack rod = new ItemStack(Material.FISHING_ROD);
    private static ItemStack waterlily = WaterLily.item();

    private static ItemStack result = GodRod.item();

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        Recipes.show(player);
        inventory.setItem(1, waterlily);
        inventory.setItem(2, obsidian);
        inventory.setItem(3, waterlily);

        inventory.setItem(10, obsidian);
        inventory.setItem(11, rod);
        inventory.setItem(12, obsidian);

        inventory.setItem(15, result);

        inventory.setItem(19, waterlily);
        inventory.setItem(20, obsidian);
        inventory.setItem(21, waterlily);
    }
}