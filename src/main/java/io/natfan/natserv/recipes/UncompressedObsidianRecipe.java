package io.natfan.natserv.recipes;

import io.natfan.natserv.items.CompressedObsidian;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UncompressedObsidianRecipe extends Recipes {
    private static ItemStack obsidian = new ItemStack(CompressedObsidian.item());
    private static ItemStack result = new ItemStack(CompressedObsidian.item());
    private static ItemStack blank() {
        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW.toString() + "");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static void show(Player player) {
        Inventory inventory = Recipes.inventory;
        result.setAmount(9);
        Recipes.show(player);
        inventory.setItem(1, obsidian);
        inventory.setItem(2, blank());
        inventory.setItem(3, blank());

        inventory.setItem(10, blank());
        inventory.setItem(11, blank());
        inventory.setItem(12, blank());

        inventory.setItem(15, result);

        inventory.setItem(19, blank());
        inventory.setItem(20, blank());
        inventory.setItem(21, blank());
    }
}