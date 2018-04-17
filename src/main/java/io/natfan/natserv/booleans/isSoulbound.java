package io.natfan.natserv.booleans;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public class isSoulbound {
    public static boolean isSoulbound(ItemStack itemStack) {
        if (itemStack.hasItemMeta()) {
            if (itemStack.getItemMeta().hasLore()) {
                if (!itemStack.getItemMeta().getLore().isEmpty()) {
                    if (itemStack.getItemMeta().getLore().contains(ChatColor.GOLD + "Soulbound")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
