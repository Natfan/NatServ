package io.natfan.natserv.events;

import io.natfan.natserv.NatServ;
import io.natfan.natserv.items.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftingEvents implements Listener {
    public NatServ plugin;

    public CraftingEvents(NatServ instance) {
        plugin = instance;
    }

    @EventHandler
    public void craftEvent(CraftItemEvent event) {
        if (event.getInventory() instanceof CraftingInventory) {
            HumanEntity humanEntity = event.getWhoClicked();
            if (humanEntity instanceof Player) {
                Player player = (Player) humanEntity;
                CraftingInventory inventory = (CraftingInventory) event.getInventory();
                if (inventory.getSize() == 10) {
                    // Resistance Chestplate
                    if (event.getRecipe().getResult().equals(ResistanceChestplateRecipe().getResult())) {
                        ItemStack obsidian0 = inventory.getMatrix()[0];
                        //magma
                        ItemStack obsidian2 = inventory.getMatrix()[2];
                        //newline
                        ItemStack obsidian3 = inventory.getMatrix()[3];
                        //chestplate
                        ItemStack obsidian5 = inventory.getMatrix()[5];
                        //newline
                        ItemStack obsidian6 = inventory.getMatrix()[6];
                        ItemStack obsidian7 = inventory.getMatrix()[7];
                        ItemStack obsidian8 = inventory.getMatrix()[8];

                        if (obsidian0.hasItemMeta() &&
                                obsidian2.hasItemMeta() &&
                                obsidian3.hasItemMeta() &&
                                obsidian5.hasItemMeta() &&
                                obsidian6.hasItemMeta() &&
                                obsidian7.hasItemMeta() &&
                                obsidian8.hasItemMeta()) {
                            String name = CompressedObsidian.item().getItemMeta().getDisplayName().toLowerCase();
                            String checkName0 = obsidian0.getItemMeta().getDisplayName().toLowerCase();
                            String checkName2 = obsidian2.getItemMeta().getDisplayName().toLowerCase();
                            String checkName3 = obsidian3.getItemMeta().getDisplayName().toLowerCase();
                            String checkName5 = obsidian5.getItemMeta().getDisplayName().toLowerCase();
                            String checkName6 = obsidian6.getItemMeta().getDisplayName().toLowerCase();
                            String checkName7 = obsidian7.getItemMeta().getDisplayName().toLowerCase();
                            String checkName8 = obsidian8.getItemMeta().getDisplayName().toLowerCase();
                            if (checkName0.equalsIgnoreCase(name) &&
                                    checkName2.equalsIgnoreCase(name) &&
                                    checkName3.equalsIgnoreCase(name) &&
                                    checkName5.equalsIgnoreCase(name) &&
                                    checkName6.equalsIgnoreCase(name) &&
                                    checkName7.equalsIgnoreCase(name) &&
                                    checkName8.equalsIgnoreCase(name)) {
                                event.setCancelled(false);
                                return;
                            }
                        }
                        player.sendMessage(ChatColor.YELLOW + "You need to use " + CompressedObsidian.item().getItemMeta().getDisplayName() + ChatColor.YELLOW + ".");
                        event.setCancelled(true);
                    }

                    // God Rod
                    if (event.getRecipe().getResult().equals(GodRodRecipe().getResult())) {
                        ItemStack one = inventory.getMatrix()[0]; //lily
                        ItemStack two = inventory.getMatrix()[1]; //obby
                        ItemStack three = inventory.getMatrix()[2]; //lily
                        //newline
                        ItemStack four = inventory.getMatrix()[3]; //obby
                        //rod
                        ItemStack six = inventory.getMatrix()[5]; //obby
                        //newline
                        ItemStack seven = inventory.getMatrix()[6]; //lily
                        ItemStack eight = inventory.getMatrix()[7]; //obby
                        ItemStack nine = inventory.getMatrix()[8]; //lily

                        if (one.hasItemMeta() &&
                                two.hasItemMeta() &&
                                three.hasItemMeta() &&
                                four.hasItemMeta() &&
                                six.hasItemMeta() &&
                                seven.hasItemMeta() &&
                                eight.hasItemMeta() &&
                                nine.hasItemMeta()) {
                            String obbyname = CompressedObsidian.item().getItemMeta().getDisplayName().toLowerCase();
                            String lilyname = WaterLily.item().getItemMeta().getDisplayName().toLowerCase();

                            String checkName1 = one.getItemMeta().getDisplayName().toLowerCase();
                            String checkName2 = two.getItemMeta().getDisplayName().toLowerCase();
                            String checkName3 = three.getItemMeta().getDisplayName().toLowerCase();
                            String checkName4 = four.getItemMeta().getDisplayName().toLowerCase();
                            String checkName6 = six.getItemMeta().getDisplayName().toLowerCase();
                            String checkName7 = seven.getItemMeta().getDisplayName().toLowerCase();
                            String checkName8 = eight.getItemMeta().getDisplayName().toLowerCase();
                            String checkName9 = nine.getItemMeta().getDisplayName().toLowerCase();
                            if (checkName1.equalsIgnoreCase(lilyname) &&
                                    checkName2.equalsIgnoreCase(obbyname) &&
                                    checkName3.equalsIgnoreCase(lilyname) &&
                                    checkName4.equalsIgnoreCase(obbyname) &&
                                    checkName6.equalsIgnoreCase(obbyname) &&
                                    checkName7.equalsIgnoreCase(lilyname) &&
                                    checkName8.equalsIgnoreCase(obbyname) &&
                                    checkName9.equalsIgnoreCase(lilyname)) {
                                event.setCancelled(false);
                                return;
                            }
                        }
                        player.sendMessage(ChatColor.YELLOW + "You need to use " + CompressedObsidian.item().getItemMeta().getDisplayName() + ChatColor.YELLOW + " and " + WaterLily.item().getItemMeta().getDisplayName() + ChatColor.YELLOW + ".");
                        event.setCancelled(true);
                    }
                }
                if (event.getRecipe().getResult().equals(UncompressedObsidianRecipe().getResult())) {
                    for (int i = 0; i < inventory.getMatrix().length; i++) {
                        ItemStack obsidian = inventory.getMatrix()[i];
                        if (obsidian != null) {
                            if (obsidian.hasItemMeta()) {
                                String name = CompressedObsidian.item().getItemMeta().getDisplayName().toLowerCase();
                                String checkName = obsidian.getItemMeta().getDisplayName().toLowerCase();
                                if (checkName.equalsIgnoreCase(name)) {
                                    event.setCancelled(false);
                                    return;
                                }
                            }
                        }
                    }
                    player.sendMessage(ChatColor.YELLOW + "You need to use " + CompressedObsidian.item().getItemMeta().getDisplayName() + ChatColor.YELLOW + ".");
                    event.setCancelled(true);
                }
                if (event.getRecipe().getResult().equals(CrowbarRecipe().getResult())) {
                    ItemStack obsidian = inventory.getMatrix()[7];
                    if (obsidian != null) {
                        if (obsidian.hasItemMeta()) {
                            String name = CompressedObsidian.item().getItemMeta().getDisplayName().toLowerCase();
                            String checkName = obsidian.getItemMeta().getDisplayName().toLowerCase();
                            if (!checkName.equalsIgnoreCase(name)) {
                                player.sendMessage(ChatColor.YELLOW + "You need to use " + CompressedObsidian.item().getItemMeta().getDisplayName() + ChatColor.YELLOW + ".");
                                event.setCancelled(true);
                                return;
                            }
                        }
                    }
                }
                if (event.getRecipe().getResult().equals(MinersPickaxeRecipe().getResult())) {
                    Bukkit.broadcastMessage(NatServ.prefix + player.getName() + " has just crafted the " + event.getRecipe().getResult().getItemMeta().getDisplayName() + ChatColor.YELLOW + "!");
                }
            }
        }
    }

    public static ShapedRecipe MinisPickaxeRecipe() {
        ShapedRecipe item = new ShapedRecipe(MinisPickaxe.item());
        item.shape("DDD", "ESE", " S ");
        item.setIngredient('D', Material.DIAMOND_BLOCK);
        item.setIngredient('E', Material.EMERALD_BLOCK);
        item.setIngredient('S', Material.STICK);

        return item;
    }

    public static ShapedRecipe MinersPickaxeRecipe() {
        ShapedRecipe item = new ShapedRecipe(MinersPickaxe.item());
        item.shape("DBD", "ESE", " S ");
        item.setIngredient('D', Material.DIAMOND_BLOCK);
        item.setIngredient('B', Material.BEACON);
        item.setIngredient('E', Material.EMERALD_BLOCK);
        item.setIngredient('S', Material.BLAZE_ROD);

        return item;
    }

    public static ShapedRecipe BreathingHelmetRecipe() {
        ShapedRecipe item = new ShapedRecipe(BreathingHelmet.item());
        item.shape("CGC", "EHE", "SWS");
        item.setIngredient('C', Material.PRISMARINE_CRYSTALS);
        item.setIngredient('G', Material.STAINED_GLASS_PANE);
        item.setIngredient('E', Material.EMERALD_ORE);
        item.setIngredient('H', Material.DIAMOND_HELMET);
        item.setIngredient('S', Material.PRISMARINE_SHARD);
        item.setIngredient('W', Material.WATER_BUCKET);

        return item;
    }

    public static ShapedRecipe ResistanceChestplateRecipe() {
        ShapedRecipe item = new ShapedRecipe(ResistanceChestplate.item());
        item.shape("OCO", "ODO", "OOO");
        item.setIngredient('O', CompressedObsidian.item().getType());
        item.setIngredient('C', Material.MAGMA_CREAM);
        item.setIngredient('D', Material.DIAMOND_CHESTPLATE);

        return item;
    }

    public static ShapedRecipe SaturationLeggings() {
        ShapedRecipe item = new ShapedRecipe(SaturationLeggings.item());
        item.shape("DCD", "ELE", "DGD");
        item.setIngredient('D', Material.DIAMOND);
        item.setIngredient('C', Material.COOKIE);
        item.setIngredient('E', Material.EMERALD);
        item.setIngredient('L', Material.DIAMOND_LEGGINGS);
        item.setIngredient('G', Material.GOLDEN_APPLE, 1);

        return item;
    }

    public static ShapedRecipe SwiftnessBootsRecipe() {
        ShapedRecipe item = new ShapedRecipe(SwiftnessBoots.item());
        item.shape("FFF", "GDG", "G G");
        item.setIngredient('F', Material.FEATHER);
        item.setIngredient('G', Material.GOLD_BLOCK);
        item.setIngredient('D', Material.DIAMOND_BLOCK);

        return item;
    }

    public static ShapelessRecipe CompressedObsidianRecipe() {
        ShapelessRecipe item = new ShapelessRecipe(CompressedObsidian.item());
        item.addIngredient(9, Material.OBSIDIAN);

        return item;
    }

    public static ShapelessRecipe UncompressedObsidianRecipe() {
        ShapelessRecipe item = new ShapelessRecipe(new ItemStack(Material.OBSIDIAN, 9));
        item.addIngredient(CompressedObsidian.item().getType());

        return item;
    }

    public static ShapedRecipe CrowbarRecipe() {
        ShapedRecipe item = new ShapedRecipe(Crowbar.item());
        item.shape("REB", "GDX", "ZCP");
        item.setIngredient('R', Material.ROTTEN_FLESH);
        item.setIngredient('E', Material.EMERALD_BLOCK);
        item.setIngredient('B', Material.BONE);
        item.setIngredient('G', Material.SULPHUR);
        item.setIngredient('D', Material.DIAMOND_BLOCK);
        item.setIngredient('X', Material.FERMENTED_SPIDER_EYE);
        item.setIngredient('Z', Material.BLAZE_ROD);
        item.setIngredient('C', Material.OBSIDIAN);
        item.setIngredient('P', Material.ENDER_PEARL);

        return item;
    }

    public static ShapedRecipe WaterLilyRecipe() {
        ShapedRecipe item = new ShapedRecipe(WaterLily.item());
        item.shape(" E ", "ELE", " E ");
        item.setIngredient('E', Material.EMERALD);
        item.setIngredient('L', Material.WATER_LILY);

        return item;
    }

    public static ShapedRecipe GodRodRecipe() {
        ShapedRecipe item = new ShapedRecipe(GodRod.item());
        item.shape("LOL", "ORO", "LOL");
        item.setIngredient('L', Material.WATER_LILY);
        item.setIngredient('O', Material.OBSIDIAN);
        item.setIngredient('R', Material.FISHING_ROD);

        return item;
    }
}
