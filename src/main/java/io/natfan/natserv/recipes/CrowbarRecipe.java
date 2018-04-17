package io.natfan.natserv.recipes;

import io.natfan.natserv.items.CompressedObsidian;
import io.natfan.natserv.items.Crowbar;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CrowbarRecipe extends Recipes {
    private static ItemStack flesh = new ItemStack(Material.ROTTEN_FLESH);
    private static ItemStack emerald = new ItemStack(Material.EMERALD_BLOCK);
    private static ItemStack bone = new ItemStack(Material.BONE);
    private static ItemStack gunpowder = new ItemStack(Material.SULPHUR);
    private static ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK);
    private static ItemStack spidereye = new ItemStack(Material.FERMENTED_SPIDER_EYE);
    private static ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
    private static ItemStack obsidian = CompressedObsidian.item();
    private static ItemStack pearl = new ItemStack(Material.ENDER_PEARL);

    private static ItemStack result = Crowbar.item();

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        Recipes.show(player);
        inventory.setItem(1, flesh);
        inventory.setItem(2, emerald);
        inventory.setItem(3, bone);

        inventory.setItem(10, gunpowder);
        inventory.setItem(11, diamond);
        inventory.setItem(12, spidereye);

        inventory.setItem(15, result);

        inventory.setItem(19, blaze);
        inventory.setItem(20, obsidian);
        inventory.setItem(21, pearl);
    }
}