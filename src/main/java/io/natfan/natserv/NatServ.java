package io.natfan.natserv;

import io.natfan.natserv.booleans.*;
import io.natfan.natserv.commands.*;
import io.natfan.natserv.events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NatServ extends JavaPlugin implements Listener {
    private boolean debugger = false;
    public static int brewSpeedMultiplier = 2;
    public static int smeltSpeedMultiplier = 2;
    public static String prefix = ChatColor.GREEN + "[" + ChatColor.GOLD + "NatServ" + ChatColor.GREEN + "] " + ChatColor.YELLOW.toString();
    public static String consoleUUID = "CONSOLE";
    public static HashMap<String, String> lastMsgMap = new HashMap<>();
    public static ArrayList<String> soulboundToggle = new ArrayList<>();
    public static ArrayList<String> sleeping = new ArrayList<>();
    public static double sleepingNeeded = 50.0;

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(this, this);
        pluginManager.registerEvents(new AnvilEvents(this), this);
        pluginManager.registerEvents(new BrewEvents(this), this);
        //pluginManager.registerEvents(new BoatEvents(this), this);
        pluginManager.registerEvents(new CraftingEvents(this), this);
        pluginManager.registerEvents(new CompressedObsidianPlaceEvent(this), this);
        pluginManager.registerEvents(new CrowbarEvents(this), this);
        pluginManager.registerEvents(new DisenchantEvents(this), this);
        pluginManager.registerEvents(new DragonEvents(this), this);
        pluginManager.registerEvents(new InventoryViewing(this), this);
        pluginManager.registerEvents(new MobGrief(this), this);
        pluginManager.registerEvents(new Soulbound(this), this);
        pluginManager.registerEvents(new WaterLilyPlaceEvent(this), this);

        getCommand("announce").setExecutor(new AnnounceCommand());
        getCommand("citem").setExecutor(new ItemCommand());
        getCommand("coordinates").setExecutor(new CoordinatesCommand());
        getCommand("recipe").setExecutor(new RecipeCommand());
        getCommand("recipes").setExecutor(new RecipeCommand());
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("message").setExecutor(new MessageCommands());
        getCommand("reply").setExecutor(new MessageCommands());
        getCommand("soulbind").setExecutor(new SoulbindCommand());
        getCommand("uuid").setExecutor(new UUIDCommand());

        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            if (Bukkit.getOnlinePlayers().size() >= 1) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    isMining.get(player);
                    isSwiftness.get(player);
                    isSaturation.get(player);
                    isBreathing.get(player);
                    isResisting.get(player);
                }
            }
        }, 0L, 40L);

        getServer().addRecipe(CraftingEvents.MinersPickaxeRecipe());
        getServer().addRecipe(CraftingEvents.MinisPickaxeRecipe());
        getServer().addRecipe(CraftingEvents.BreathingHelmetRecipe());
        getServer().addRecipe(CraftingEvents.ResistanceChestplateRecipe());
        getServer().addRecipe(CraftingEvents.SaturationLeggings());
        getServer().addRecipe(CraftingEvents.SwiftnessBootsRecipe());
        getServer().addRecipe(CraftingEvents.CompressedObsidianRecipe());
        getServer().addRecipe(CraftingEvents.UncompressedObsidianRecipe());
        getServer().addRecipe(CraftingEvents.CrowbarRecipe());
        getServer().addRecipe(CraftingEvents.GodRodRecipe());
        getServer().addRecipe(CraftingEvents.WaterLilyRecipe());

        if (debugger) {
            Bukkit.broadcastMessage(prefix + "Enabled.");
            Iterator<Recipe> iterator = getServer().recipeIterator();
            while (iterator.hasNext()) {
                Recipe recipe = iterator.next();
                if (recipe.getResult().hasItemMeta()) {
                    if (recipe.getResult().getItemMeta().hasLore()) {
                        if (recipe.getResult().getItemMeta().getLore().contains(ChatColor.RED + "Custom Recipe")) {
                            iterator.remove();
                            Bukkit.broadcastMessage(ChatColor.YELLOW + "Added the " + recipe.getResult().getItemMeta().getDisplayName() + ChatColor.YELLOW + " recipe.");
                        }
                    }
                }
            }
        }

    }

    @Override
    public void onDisable() {
        if (debugger) {
            Bukkit.broadcastMessage(prefix + "Disabled.");
            Iterator<Recipe> iterator = getServer().recipeIterator();
            while (iterator.hasNext()) {
                Recipe recipe = iterator.next();
                if (recipe.getResult().hasItemMeta()) {
                    if (recipe.getResult().getItemMeta().hasLore()) {
                        if (recipe.getResult().getItemMeta().getLore().contains(ChatColor.RED + "Custom Recipe")) {
                            iterator.remove();
                            Bukkit.broadcastMessage(ChatColor.YELLOW + "Removed the " + recipe.getResult().getItemMeta().getDisplayName() + ChatColor.YELLOW + " recipe.");
                        }
                    }
                }
            }
        }
    }

    public static String cItemList() {
        return (ChatColor.YELLOW       + "The following are custom recipes that are in the game:\n" +
                ChatColor.GREEN        + " Miner's Pickaxe " + ChatColor.YELLOW + "(miner, minerspickaxe)\n" +
                ChatColor.GREEN        + " Mini's Pickaxe " + ChatColor.YELLOW + "(mini, minispickaxe)\n" +
                ChatColor.GREEN        + " Breathing Helmet " + ChatColor.YELLOW + "(breathing, helmet, breathinghelmet)\n" +
                ChatColor.GREEN        + " Resistance Chestplate " + ChatColor.YELLOW + "(resistance, chestplate, resistancechestplate)\n" +
                ChatColor.GREEN        + " Saturation Leggings " + ChatColor.YELLOW + "(saturation, leggings, saturationleggings)\n" +
                ChatColor.GREEN        + " Swiftness Boots " + ChatColor.YELLOW + "(boots, swiftness, swiftnessboots)\n" +
                ChatColor.DARK_PURPLE  + " Compressed Obsidian " + ChatColor.YELLOW + "(compressedobsidian, obsidian, obby)\n" +
                ChatColor.DARK_PURPLE  + " Uncompressed Obsidian " + ChatColor.YELLOW + "(uncompressedobsidian, unobsidian, unobby)\n" +
                ChatColor.RED          + " Crowbar " + ChatColor.YELLOW + "(crowbar, wrench)\n" +
                ChatColor.RED          + " WaterLily " + ChatColor.YELLOW + "(waterlily, lilypad, lily)\n" +
                ChatColor.GREEN        + " GodRod " + ChatColor.YELLOW + "(fishingrod, fishing, fish, rod)");
    }
}
