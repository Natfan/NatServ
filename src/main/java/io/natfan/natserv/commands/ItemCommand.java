package io.natfan.natserv.commands;

import io.natfan.natserv.NatServ;
import io.natfan.natserv.items.*;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("citem")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.isOp() || player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.YELLOW + "The following arguments can be used with this command:");
                        player.sendMessage(ChatColor.GOLD + "/citem <item> " + ChatColor.YELLOW + "Gives you the requested item.");
                        player.sendMessage(ChatColor.GOLD + "/citem list " + ChatColor.YELLOW + "Lists all custom items that can be given.");
                        return true;
                    } else if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("miner") || args[0].equalsIgnoreCase("minerspickaxe")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + MinersPickaxe.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(MinersPickaxe.item());
                            return true;
                        } else if (args[0].equalsIgnoreCase("mini") || args[0].equalsIgnoreCase("minispickaxe")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + MinisPickaxe.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(MinisPickaxe.item());
                            return true;
                        } else if (args[0].equalsIgnoreCase("breathing") || args[0].equalsIgnoreCase("helmet") || args[0].equalsIgnoreCase("breathinghelmet") || args[0].equalsIgnoreCase("helm")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + BreathingHelmet.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(BreathingHelmet.item());
                            return true;
                        } else if (args[0].equalsIgnoreCase("resistance") || args[0].equalsIgnoreCase("chestplate") || args[0].equalsIgnoreCase("resistancechestplate") || args[0].equalsIgnoreCase("chest")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + ResistanceChestplate.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(ResistanceChestplate.item());
                            return true;
                        } else if (args[0].equalsIgnoreCase("saturation") || args[0].equalsIgnoreCase("leggings") || args[0].equalsIgnoreCase("saturationleggings") || args[0].equalsIgnoreCase("legs") || args[0].equalsIgnoreCase("leg")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + SaturationLeggings.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(SaturationLeggings.item());
                            return true;
                        } else if (args[0].equalsIgnoreCase("swiftness") || args[0].equalsIgnoreCase("boots") || args[0].equalsIgnoreCase("swiftnessboots")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + SwiftnessBoots.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(SwiftnessBoots.item());
                            return true;
                        } else if (args[0].equalsIgnoreCase("compressedobsidian") || args[0].equalsIgnoreCase("obsidian") || args[0].equalsIgnoreCase("obby")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + CompressedObsidian.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(CompressedObsidian.item());
                            return true;
                        } else if (args[0].equalsIgnoreCase("crowbar") || args[0].equalsIgnoreCase("wrench")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + Crowbar.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(Crowbar.item());
                            return true;
                        } else if (args[0].equalsIgnoreCase("godrod") || args[0].equalsIgnoreCase("rod")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + GodRod.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(GodRod.item());
                            return true;
                        } else if (args[0].equalsIgnoreCase("waterlily") || args[0].equalsIgnoreCase("lilypad") || args[0].equalsIgnoreCase("lily")) {
                            player.sendMessage(ChatColor.YELLOW + "You have acquired the " + WaterLily.item().getItemMeta().getDisplayName());
                            player.getInventory().addItem(WaterLily.item());
                            return true;

                        } else if (args[0].equalsIgnoreCase("list")) {
                            player.sendMessage(NatServ.cItemList());
                            return true;
                        } else {
                            player.sendMessage(ChatColor.GOLD + "/citem <item> " + ChatColor.YELLOW + "Gives you the requested item.");
                            player.sendMessage(ChatColor.GOLD + "/citem list " + ChatColor.YELLOW + "Lists all custom items that can be given.");
                        }
                    } else {
                        player.sendMessage(ChatColor.YELLOW + "The following arguments can be used with this command:");
                        player.sendMessage(ChatColor.GOLD + "/citem <item> " + ChatColor.YELLOW + "Gives you the requested item.");
                        player.sendMessage(ChatColor.GOLD + "/citem list " + ChatColor.YELLOW + "Lists all custom items that can be given.");
                        return true;
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot perform this command, you must either be in " + ChatColor.DARK_RED + "Creative" + ChatColor.RED + " or " + ChatColor.DARK_RED + "Spectator" + ChatColor.RED + ", or be an " + ChatColor.DARK_RED + "OP" + ChatColor.RED + ".");
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
