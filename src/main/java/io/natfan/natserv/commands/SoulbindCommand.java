package io.natfan.natserv.commands;

import io.natfan.natserv.NatServ;
import io.natfan.natserv.booleans.isSoulbound;
import io.natfan.natserv.events.Soulbound;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SoulbindCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("soulbind")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (player.isOp()) {
                        if (player.getItemInHand() != null) {
                            ItemStack item = player.getItemInHand();
                            if (item.getType() != Material.AIR) {
                                if (isSoulbound.isSoulbound(item)) {
                                    Soulbound.removeSoulbind(item);
                                    player.sendMessage(ChatColor.YELLOW + "Your " + ChatColor.LIGHT_PURPLE + item.getType() + ChatColor.YELLOW + " is no longer imbued with the magical force of " + ChatColor.GOLD + "Soulbounding" + ChatColor.YELLOW + ".");
                                    player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1, 1);
                                    return true;
                                } else {
                                    Soulbound.soulbound(item);
                                    player.sendMessage(ChatColor.YELLOW + "Your " + ChatColor.LIGHT_PURPLE + item.getType() + ChatColor.YELLOW + " has been imbued with a magical force and is now " + ChatColor.GOLD + "Soulbinded" + ChatColor.YELLOW + ".");
                                    player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
                                    return true;
                                }
                            } else {
                                player.sendMessage(ChatColor.YELLOW + "You need to hold an item to use this command.");
                                return true;
                            }
                        } else {
                            player.sendMessage(ChatColor.YELLOW + "You need to hold an item to use this command.");
                            return true;
                        }
                    }
                } else {
                    if (args[0].equalsIgnoreCase("toggle")) {
                        if (!NatServ.soulboundToggle.contains(player.getUniqueId().toString())) {
                            NatServ.soulboundToggle.add(player.getUniqueId().toString());
                            player.sendMessage(ChatColor.YELLOW + "You can now drop " + ChatColor.GOLD + "Soulbound " + ChatColor.YELLOW + "items, but they will be lost to the void.");
                            return true;
                        } else {
                            NatServ.soulboundToggle.remove(player.getUniqueId().toString());
                            player.sendMessage(ChatColor.YELLOW + "You can no longer drop " + ChatColor.GOLD + "Soulbound " + ChatColor.YELLOW + "items, they will remain in your possession until you die.");
                            return true;
                        }
                    } else {
                        player.sendMessage(ChatColor.YELLOW + "Unknown command, try " + ChatColor.GOLD + "/" + label + " toggle");
                        return true;
                    }
                }
            } else {
                sender.sendMessage(ChatColor.DARK_RED + "This command is for players only, hoss.");
                return true;
            }
        }
        return false;
    }
}
