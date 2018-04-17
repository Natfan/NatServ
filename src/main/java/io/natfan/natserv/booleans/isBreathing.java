package io.natfan.natserv.booleans;

import io.natfan.natserv.items.BreathingHelmet;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class isBreathing {
    public static boolean get(Player player) {
        if (player.getInventory().getHelmet() != null) {
            if (player.getInventory().getHelmet().getType().equals(Material.GOLD_HELMET)) {
                if (player.getInventory().getHelmet().hasItemMeta()) {
                    if (Objects.equals(player.getInventory().getHelmet().getItemMeta().getDisplayName(), BreathingHelmet.item().getItemMeta().getDisplayName())) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 80, 0, true), true);
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
