package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import io.natfan.natserv.items.Crowbar;
import io.natfan.natserv.utils.TitleCase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.MessageFormat;
import java.util.ArrayList;

public class CrowbarEvents implements Listener {
    public NatServ plugin;

    public CrowbarEvents(NatServ instance) {
        plugin = instance;
    }

    @EventHandler
    public void crowbaringEvent(final PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        Action action = event.getAction();
        Block block = event.getClickedBlock();

        if (action == Action.RIGHT_CLICK_BLOCK) {
            if (item != null) {
                if (item.getType() != Material.AIR) {
                    if (item.hasItemMeta()) {
                        if (item.getItemMeta().hasDisplayName()) {
                            if (item.getItemMeta().getDisplayName().toLowerCase().equalsIgnoreCase(Crowbar.item().getItemMeta().getDisplayName().toLowerCase())) {
                                if (block.getType().equals(Material.MOB_SPAWNER)) {
                                    if (block.getBiome().equals(Biome.HELL)) { event.getPlayer().sendMessage(ChatColor.YELLOW + "  You " + ChatColor.RED + "cannot " + ChatColor.YELLOW + "break " + ChatColor.GREEN + "Monster Spawners " + ChatColor.YELLOW + "in " + ChatColor.DARK_RED + "The Nether" + ChatColor.YELLOW + "."); return; }
                                    if (block.getBiome().equals(Biome.SKY)) { event.getPlayer().sendMessage(ChatColor.YELLOW + "  You " + ChatColor.RED + "cannot " + ChatColor.YELLOW + "break " + ChatColor.GREEN + "Monster Spawners " + ChatColor.YELLOW + "in " + ChatColor.DARK_PURPLE + "The End" + ChatColor.YELLOW + "."); return; }

                                    final ItemStack spawner = new ItemStack(block.getType());
                                    final ItemMeta spawnerMeta = spawner.getItemMeta();
                                    String type = ((CreatureSpawner) block.getState()).getCreatureTypeName().toUpperCase();
                                    String outputType = TitleCase.capitalizeFirstLetterOnly(type);
                                    spawnerMeta.setDisplayName(ChatColor.RED + "Monster Spawner");
                                    ArrayList<String> lore = new ArrayList<>();
                                    lore.add("");
                                    lore.add(ChatColor.DARK_AQUA + outputType);
                                    spawnerMeta.setLore(lore);
                                    spawner.setItemMeta(spawnerMeta);
                                    block.getWorld().dropItem(block.getLocation(), spawner);
                                    block.setType(Material.AIR);
                                    player.setItemInHand(null);
                                    player.updateInventory();
                                    player.sendMessage(ChatColor.YELLOW + "You just crowbar'd a " + ChatColor.RED + outputType + " Spawner" + ChatColor.YELLOW + ".");
                                    Bukkit.getLogger().info( MessageFormat.format("[CBAR] {0} grabbed a {1} Spawner", player.getName(), outputType));
                                }
                                event.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlace(final BlockPlaceEvent event) {
        Block placed = event.getBlock();
        ItemStack item = event.getItemInHand();
        Player player = event.getPlayer();
        if (placed.getType() == Material.MOB_SPAWNER &&
                item.hasItemMeta() &&
                item.getItemMeta().hasDisplayName() &&
                !item.getItemMeta().getLore().isEmpty()) {
            if (placed.getBiome().equals(Biome.HELL) || placed.getBiome().equals(Biome.SKY)) { event.getPlayer().sendMessage(ChatColor.YELLOW + "  You " + ChatColor.RED + "cannot " + ChatColor.YELLOW + "place " + ChatColor.GREEN + "Monster Spawners " + ChatColor.YELLOW + "in ths" + ChatColor.DARK_RED + "Dimension" + ChatColor.YELLOW + "."); event.setCancelled(true); return; }
            String lore = ChatColor.stripColor(item.getItemMeta().getLore().get(1).toUpperCase());
            String outputType = TitleCase.capitalizeFirstLetterOnly(lore);
            EntityType type = EntityType.valueOf(lore);
            try {
                CreatureSpawner spawner = (CreatureSpawner) placed.getState();
                spawner.setSpawnedType(type);
                spawner.update();
                player.sendMessage(ChatColor.YELLOW + "You just placed a " + ChatColor.RED + item.getItemMeta().getLore().get(1) + " Spawner" + ChatColor.YELLOW + ".");
                player.updateInventory();
                Bukkit.getLogger().info( MessageFormat.format("[CBAR] {0} placed a {1} Spawner", player.getName(), outputType));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @EventHandler
    public void onBreak(final BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location location = block.getLocation();
        if (block.getType() == Material.MOB_SPAWNER) {
            if (block.getBiome().equals(Biome.HELL) || event.getBlock().getBiome().equals(Biome.SKY)) {
                player.sendMessage(ChatColor.YELLOW + "  You " + ChatColor.RED + "cannot " + ChatColor.YELLOW + "break " + ChatColor.GREEN + "Monster Spawners " + ChatColor.YELLOW + "in this " + ChatColor.DARK_PURPLE + "Dimension" + ChatColor.YELLOW + ".");
                event.setCancelled(true);
                player.updateInventory();
                Bukkit.getLogger().info( MessageFormat.format("[CBAR] {0} tried to break a spawner but failed ({1}, {2}, {3} - {4})", player.getName(), location.getBlockX(), location.getBlockY(), location.getBlockZ(), location.getWorld()));
            }
        }
    }
}