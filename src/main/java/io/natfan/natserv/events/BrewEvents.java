package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockState;
import org.bukkit.block.BrewingStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BrewEvents implements Listener {
    public NatServ plugin;

    public BrewEvents(NatServ instance) { plugin = instance; }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock().getBiome().equals(Biome.HELL)) {
                BlockState state = event.getClickedBlock().getState();
                if (state instanceof BrewingStand) {
                    BrewingStand brewingStand = (BrewingStand) state;
                    brewingStand.setBrewingTime(brewingStand.getBrewingTime() * NatServ.brewSpeedMultiplier);
                }
            }
        }
    }

    @EventHandler
    public void brewingEvent(BrewEvent event) {
        final BlockState state = event.getBlock().getState();
        if (state instanceof BrewingStand) {
            final BrewingStand brewingStand = (BrewingStand) state;
            if (NatServ.brewSpeedMultiplier > 1) {
                new BrewingStandUpdateTask(brewingStand).runTaskTimer(plugin, 1L, 1L);
            }
        }
    }

    public class BrewingStandUpdateTask extends BukkitRunnable {
        private BrewingStand brewingStand;

        public BrewingStandUpdateTask(BrewingStand brewingStand) { this.brewingStand = brewingStand; }

        public void run() {
            if (this.brewingStand.getBlock().getBiome().equals(Biome.HELL)) {
                this.brewingStand.setBrewingTime(this.brewingStand.getBrewingTime() * NatServ.brewSpeedMultiplier);
                this.brewingStand.update();
                if (this.brewingStand.getBrewingTime() <= 1) {
                    this.cancel();
                }
            }
        }
    }
}
