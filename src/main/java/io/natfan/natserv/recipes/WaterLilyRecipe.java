package io.natfan.natserv.recipes;

import io.natfan.natserv.items.WaterLily;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WaterLilyRecipe extends Recipes {
    private static ItemStack lilypad = new ItemStack(Material.WATER_LILY);
    private static ItemStack emerald = new ItemStack(Material.EMERALD);
    private static ItemStack result = new ItemStack(WaterLily.item());
    private static ItemStack blank() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW.toString() + "");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        result.setAmount(1);
        Recipes.show(player);
        inventory.setItem(1, blank());
        inventory.setItem(2, emerald);
        inventory.setItem(3, blank());

        inventory.setItem(10, emerald);
        inventory.setItem(11, lilypad);
        inventory.setItem(12, emerald);

        inventory.setItem(15, result);

        inventory.setItem(19, blank());
        inventory.setItem(20, emerald);
        inventory.setItem(21, blank());
    }
}