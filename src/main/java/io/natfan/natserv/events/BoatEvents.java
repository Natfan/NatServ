package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class BoatEvents implements Listener {
    public NatServ plugin;

    public BoatEvents(NatServ instance) { plugin = instance; }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            ItemStack boat = new ItemStack(Material.BOAT);
            Soulbound.soulbound(boat);
            player.getInventory().addItem(boat);
            player.sendMessage(ChatColor.YELLOW + "I gave you a boat as it's your first time playing!");
        }
        if (player.getUniqueId().equals(UUID.fromString("438c5af3-d9af-4f1a-ab9f-9e3017341b66"))) {
            player.kickPlayer("You cannot join this server\nas we are using your UUID for backend systems.\nEmail Natfan:\nnat@natfan.io");
            Bukkit.getLogger().severe("Kicked lazertester [438c5af3-d9af-4f1a-ab9f-9e3017341b66] as we are using his UUID for backend systems and I thought he quit.");
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        ItemStack boat = new ItemStack(Material.BOAT);
        Soulbound.soulbound(boat);
        event.getPlayer().getInventory().addItem(boat);
        event.getPlayer().sendMessage(ChatColor.YELLOW + "I gave you a boat as you died!");
    }
}
