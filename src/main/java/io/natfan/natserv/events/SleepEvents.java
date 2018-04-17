package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class SleepEvents implements Listener {
    public NatServ plugin;

    public SleepEvents(NatServ instance) { plugin = instance; }

    @EventHandler
    public void onSleep(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();
        if (!NatServ.sleeping.contains(uuid))
            NatServ.sleeping.add(uuid);
    }

    @EventHandler
    public void onWake(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();
        if (NatServ.sleeping.contains(uuid))
            NatServ.sleeping.remove(uuid);
    }
}
