package io.natfan.natserv.booleans;

import io.natfan.natserv.items.SaturationLeggings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class isSaturation {
    public static boolean get(Player player) {
        if (player.getInventory().getLeggings() != null) {
            if (player.getInventory().getLeggings().getType().equals(Material.GOLD_LEGGINGS)) {
                if (player.getInventory().getLeggings().hasItemMeta()) {
                    if (Objects.equals(player.getInventory().getLeggings().getItemMeta().getDisplayName(), SaturationLeggings.item().getItemMeta().getDisplayName())) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 80, 4, true), true);
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
