package io.natfan.natserv.booleans;

import io.natfan.natserv.items.ResistanceChestplate;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class isResisting {
    public static boolean get(Player player) {
        if (player.getInventory().getChestplate() != null) {
            if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
                if (player.getInventory().getChestplate().hasItemMeta()) {
                    if (Objects.equals(player.getInventory().getChestplate().getItemMeta().getDisplayName(), ResistanceChestplate.item().getItemMeta().getDisplayName())) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 80, 0, true), true);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 80, 0, true), true);
                        return true;
                    }
                    return false;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
