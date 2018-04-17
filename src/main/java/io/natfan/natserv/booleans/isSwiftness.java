package io.natfan.natserv.booleans;

import io.natfan.natserv.items.SwiftnessBoots;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class isSwiftness {
    public static boolean get(Player player) {
        if (player.getInventory().getBoots() != null) {
            if (player.getInventory().getBoots().getType().equals(Material.GOLD_BOOTS)) {
                if (player.getInventory().getBoots().hasItemMeta()) {
                    if (Objects.equals(player.getInventory().getBoots().getItemMeta().getDisplayName(), SwiftnessBoots.item().getItemMeta().getDisplayName())) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 1, true), true);
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
