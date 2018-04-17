package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import org.bukkit.block.BlockState;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FurnaceEvents implements Listener {
    public NatServ plugin;

    public FurnaceEvents(NatServ instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock().getWorld().getName().contains("_the_end")) {
                BlockState state = event.getClickedBlock().getState();
                if (state instanceof Furnace) {
                    Furnace furnace = (Furnace) state;
                    furnace.setBurnTime((short) (furnace.getCookTime() * NatServ.smeltSpeedMultiplier));
                }
            }
        }
    }

    @EventHandler
    public void burningEvent(FurnaceBurnEvent event) {
        final BlockState state = event.getBlock().getState();
        if (state instanceof Furnace) {
            final Furnace furnace = (Furnace) state;
            if (NatServ.smeltSpeedMultiplier > 1) {
                new FurnaceUpdateTask(furnace).runTaskTimer(plugin, 1L, 1L);
            }
        }
    }

    public class FurnaceUpdateTask extends BukkitRunnable {
        private Furnace furnace;

        public FurnaceUpdateTask(Furnace furnace) { this.furnace = furnace; }

        public void run() {
            if (this.furnace.getBlock().getWorld().getName().contains("_the_end")) {
                this.furnace.setCookTime((short) (this.furnace.getCookTime() * NatServ.smeltSpeedMultiplier));
                this.furnace.update();
                if (this.furnace.getBurnTime() <= 1) {
                    this.cancel();
                }
            }
        }
    }
}
