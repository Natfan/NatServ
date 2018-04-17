package io.natfan.natserv.recipes;

import io.natfan.natserv.items.BreathingHelmet;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BreathingHelmetRecipe extends Recipes {
    private static ItemStack crystal = new ItemStack(Material.PRISMARINE_CRYSTALS);

    private static ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE);

    private static ItemStack shard = new ItemStack(Material.PRISMARINE_SHARD);

    private static ItemStack emerald = new ItemStack(Material.EMERALD_ORE);

    private static ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);

    private static ItemStack bucket = new ItemStack(Material.WATER_BUCKET);

    private static ItemStack result = BreathingHelmet.item();

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        Recipes.show(player);
        inventory.setItem(1, crystal);
        inventory.setItem(2, pane);
        inventory.setItem(3, crystal);

        inventory.setItem(10, emerald);
        inventory.setItem(11, helmet);
        inventory.setItem(12, emerald);

        inventory.setItem(15, result);

        inventory.setItem(19, shard);
        inventory.setItem(20, bucket);
        inventory.setItem(21, shard);
    }
}