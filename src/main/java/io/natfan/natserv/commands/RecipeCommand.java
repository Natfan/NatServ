package io.natfan.natserv.commands;

import io.natfan.natserv.NatServ;
import io.natfan.natserv.recipes.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RecipeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("recipes")) {
            sender.sendMessage(NatServ.cItemList());
            return true;

        }

        if (cmd.getName().equalsIgnoreCase("recipe")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    player.sendMessage(ChatColor.YELLOW + "The following arguments can be used with this command:");
                    player.sendMessage(ChatColor.GOLD + "/recipe <recipe> " + ChatColor.YELLOW + "Displays a crafting window with the crafting recipe.");
                    player.sendMessage(ChatColor.GOLD + "/recipe info <recipe> " + ChatColor.YELLOW + "Gives a small explanation about the recipe.");
                    player.sendMessage(ChatColor.GOLD + "/recipe list " + ChatColor.YELLOW + "Lists all custom recipes that can be crafted.");
                    return true;
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("miner") || args[0].equalsIgnoreCase("minerspickaxe")) {
                        MinersPickaxeRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("mini") || args[0].equalsIgnoreCase("minispickaxe")) {
                        MinisPickaxeRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("breathing") || args[0].equalsIgnoreCase("helmet") || args[0].equalsIgnoreCase("breathinghelmet") || args[0].equalsIgnoreCase("helm")) {
                        BreathingHelmetRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("resistance") || args[0].equalsIgnoreCase("chestplate") || args[0].equalsIgnoreCase("resistancechestplate") || args[0].equalsIgnoreCase("chest")) {
                        ResistanceChestplateRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("saturation") || args[0].equalsIgnoreCase("leggings") || args[0].equalsIgnoreCase("saturationleggings") || args[0].equalsIgnoreCase("legs") || args[0].equalsIgnoreCase("leg")) {
                        SaturationLeggingsRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("swiftness") || args[0].equalsIgnoreCase("boots") || args[0].equalsIgnoreCase("swiftnessboots")) {
                        SwiftnessBootsRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("compressedobsidian") || args[0].equalsIgnoreCase("obsidian") || args[0].equalsIgnoreCase("obby")) {
                        CompressedObsidianRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("uncompressedobsidian") || args[0].equalsIgnoreCase("unobsidian") || args[0].equalsIgnoreCase("unobby")) {
                        UncompressedObsidianRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("crowbar") || args[0].equalsIgnoreCase("wrench")) {
                        CrowbarRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("waterlily") || args[0].equalsIgnoreCase("lilypad") || args[0].equalsIgnoreCase("lily")) {
                        WaterLilyRecipe.show(player);
                        return true;
                    } else if (args[0].equalsIgnoreCase("godrod") || args[0].equalsIgnoreCase("fishingrod") || args[0].equalsIgnoreCase("fishing") || args[0].equalsIgnoreCase("fish") || args[0].equalsIgnoreCase("rod")) {
                        GodRodRecipe.show(player);
                        return true;


                    } else if (args[0].equalsIgnoreCase("info")) {
                        player.sendMessage(NatServ.cItemList());
                        return true;
                    } else if (args[0].equalsIgnoreCase("list")) {
                        player.sendMessage(NatServ.cItemList());
                        return true;
                    } else {
                        player.sendMessage(ChatColor.GOLD + "/recipe <recipe> " + ChatColor.YELLOW + "Displays a crafting window with the crafting recipe.");
                        player.sendMessage(ChatColor.GOLD + "/recipe info <recipe> " + ChatColor.YELLOW + "Gives a small explanation about the recipe.");
                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("info")) {
                        if (args[1].equalsIgnoreCase("miner") || args[1].equalsIgnoreCase("minerspickaxe")) {
                            player.sendMessage(ChatColor.GREEN + " Miner's Pickaxe " + ChatColor.YELLOW + "An unbreakable" + ChatColor.GRAY + "Efficiency V" + ChatColor.YELLOW + ", " + ChatColor.GRAY + "Unbreaking III " + ChatColor.GOLD + "Diamond Pickaxe " + ChatColor.YELLOW + "that gives you " + ChatColor.AQUA + "Haste II " + ChatColor.YELLOW + "and " + ChatColor.AQUA + "Night Vision I " + ChatColor.YELLOW + "for as long as you hold it.");
                            return true;
                        } else if (args[1].equalsIgnoreCase("mini") || args[1].equalsIgnoreCase("minispickaxe")) {
                            player.sendMessage(ChatColor.GREEN + " Mini's Pickaxe " + ChatColor.YELLOW + "An " + ChatColor.GRAY + "Efficiency V" + ChatColor.YELLOW + ", " + ChatColor.GRAY + "Unbreaking III " + ChatColor.GOLD + "Diamond Pickaxe " + ChatColor.YELLOW + "that gives you " + ChatColor.AQUA + "Haste II " + ChatColor.YELLOW + "and " + ChatColor.AQUA + "Night Vision I " + ChatColor.YELLOW + "for as long as you hold it.");
                            return true;
                        } else if (args[1].equalsIgnoreCase("breathing") || args[1].equalsIgnoreCase("helmet") || args[1].equalsIgnoreCase("breathinghelmet") || args[1].equalsIgnoreCase("helm")) {
                            player.sendMessage(ChatColor.GREEN + " Breathing Helmet " + ChatColor.YELLOW + "An " + ChatColor.GRAY + "Aqua Affinity I " + ChatColor.YELLOW + ", " + ChatColor.GRAY + "Depth Strider III " + ChatColor.GOLD + "Golden Helmet " + ChatColor.YELLOW + "that gives you " + ChatColor.AQUA + "Water Breathing " + ChatColor.YELLOW + "when you wear it.");
                            return true;
                        } else if (args[1].equalsIgnoreCase("resistance") || args[1].equalsIgnoreCase("chestplate") || args[1].equalsIgnoreCase("resistancechestplate") || args[1].equalsIgnoreCase("chest")) {
                            player.sendMessage(ChatColor.GREEN + " Resistance Chestplate " + ChatColor.YELLOW + "A " + ChatColor.GRAY + "Fire Protection X" + ChatColor.GOLD + "Iron Chestplate " + ChatColor.YELLOW +"that gives you " + ChatColor.AQUA + "Damage Resistance " + ChatColor.YELLOW + "and " + ChatColor.AQUA + "Fire Resistance I " + ChatColor.YELLOW + "when you wear it.");
                            return true;
                        } else if (args[1].equalsIgnoreCase("saturation") || args[1].equalsIgnoreCase("leggings") || args[1].equalsIgnoreCase("saturationleggings") || args[1].equalsIgnoreCase("legs") || args[1].equalsIgnoreCase("leg")) {
                            player.sendMessage(ChatColor.GREEN + " Saturation Leggings " + ChatColor.YELLOW + "A pair of " + ChatColor.GOLD + "Golden Leggings " + ChatColor.YELLOW + "that gives you " + ChatColor.AQUA + "Saturation V " + ChatColor.YELLOW + "when you wear them.");
                            return true;
                        } else if (args[1].equalsIgnoreCase("swiftness") || args[1].equalsIgnoreCase("boots") || args[1].equalsIgnoreCase("swiftnessboots")) {
                            player.sendMessage(ChatColor.GREEN + " Swiftness Boots " + ChatColor.YELLOW + "A pair of " + ChatColor.GRAY + "Depth Strider III " + ChatColor.GOLD + "Golden Boots " + ChatColor.YELLOW + "that gives you " + ChatColor.AQUA + "Swiftness II " + ChatColor.YELLOW + "when you wear them.");
                            return true;
                        } else if (args[1].equalsIgnoreCase("compressedobsidian") || args[1].equalsIgnoreCase("obsidian") || args[1].equalsIgnoreCase("obby")) {
                            player.sendMessage(ChatColor.RED + " Compressed Obsidian " + ChatColor.YELLOW + "A crafting component made out of " + ChatColor.DARK_PURPLE + "9 Obsidian" + ChatColor.YELLOW + ". " + ChatColor.RED + ChatColor.BOLD + "Unplaceable.");
                            return true;
                        } else if (args[1].equalsIgnoreCase("uncompressedobsidian") || args[1].equalsIgnoreCase("unobsidian") || args[1].equalsIgnoreCase("unobby")) {
                            player.sendMessage(ChatColor.RED + " Unompressed Obsidian " + ChatColor.YELLOW + "A crafting component that gives you back your " + ChatColor.DARK_PURPLE + "9 Obsidian" + ChatColor.YELLOW + ".");
                            return true;
                        } else if (args[1].equalsIgnoreCase("crowbar") || args[1].equalsIgnoreCase("wrench")) {
                            player.sendMessage(ChatColor.GREEN + " Crowbar " + ChatColor.YELLOW + "A " + ChatColor.RED + "one use tool " + ChatColor.YELLOW + "which allows you to pick up " + ChatColor.RED + "Spawners" + ChatColor.YELLOW + "." + ChatColor.RED + "Unavailable in " + ChatColor.DARK_RED + "The Nether " + ChatColor.RED + "or " + ChatColor.DARK_PURPLE + "The End" + ChatColor.YELLOW + ".");
                            return true;
                        } else if (args[1].equalsIgnoreCase("waterlily") || args[1].equalsIgnoreCase("lilypad") || args[1].equalsIgnoreCase("lily")) {
                            player.sendMessage(ChatColor.RED + " WaterLily " + ChatColor.YELLOW + "A crafting component made out of " + ChatColor.DARK_GREEN + "Lilypads " + ChatColor.YELLOW + "and " + ChatColor.GREEN + "Emeralds" + ChatColor.YELLOW + ". " + ChatColor.RED + ChatColor.BOLD + "Unplaceable.");
                            return true;
                        } else if (args[1].equalsIgnoreCase("godrod") || args[1].equalsIgnoreCase("fishingrod") || args[1].equalsIgnoreCase("fishing") || args[1].equalsIgnoreCase("fish") || args[1].equalsIgnoreCase("rod")) {
                            player.sendMessage(ChatColor.GREEN + " GodRod " + ChatColor.YELLOW + "A tool used for catching lots of goodies from fishing.");
                            return true;
                        } else {
                            player.sendMessage(ChatColor.YELLOW + "Argument not recognised, try " + ChatColor.GOLD + "/recipes");
                            return true;
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.YELLOW + "The following arguments can be used with this command:");
                    player.sendMessage(ChatColor.GOLD + "/recipe <recipe> " + ChatColor.YELLOW + "Displays a crafting window with the crafting recipe.");
                    player.sendMessage(ChatColor.GOLD + "/recipe info <recipe> " + ChatColor.YELLOW + "Gives a small explanation about the recipe.");
                    player.sendMessage(ChatColor.GOLD + "/recipe list " + ChatColor.YELLOW + "Lists all custom recipes that can be crafted.");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.DARK_RED + "This command is for players only, hoss.");
                return true;
            }
        }
        return false;
    }
}
