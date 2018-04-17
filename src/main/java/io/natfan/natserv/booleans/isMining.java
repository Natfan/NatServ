package io.natfan.natserv.booleans;

import io.natfan.natserv.items.MinersPickaxe;
import io.natfan.natserv.items.MinisPickaxe;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class isMining {
    public static boolean get(Player player) {
        if (player.getItemInHand() != null) {
            if (player.getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)) {
                if (player.getItemInHand().hasItemMeta()) {
                    if (Objects.equals(player.getItemInHand().getItemMeta().getDisplayName(), MinersPickaxe.item().getItemMeta().getDisplayName())) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 1, true), true);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400, 0, true), true);
                        return true;
                    }
                    if (Objects.equals(player.getItemInHand().getItemMeta().getDisplayName(), MinisPickaxe.item().getItemMeta().getDisplayName())) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 1, true), true);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400, 0, true), true);
                        return true;
                    } else {
                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        player.removePotionEffect(PotionEffectType.FAST_DIGGING);
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