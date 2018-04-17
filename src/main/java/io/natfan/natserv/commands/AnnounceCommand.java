package io.natfan.natserv.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnnounceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("announce") || cmd.getName().equalsIgnoreCase("an")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    player.sendMessage(ChatColor.YELLOW + "The following arguments can be used with this command:");
                    player.sendMessage(ChatColor.GOLD + "/announce <color> <type> " + ChatColor.YELLOW + "Announces the selected type to all online players.");
                    player.sendMessage(ChatColor.GOLD + "/announce <color> <type> <argument> " + ChatColor.YELLOW + "Announces the selected type to all online players, if it requires argument(s) with it.");
                    player.sendMessage(ChatColor.GOLD + "/announce list " + ChatColor.YELLOW + "Lists all types, along with their arguments (if any).");
                    player.sendMessage(ChatColor.GOLD + "/announce color " + ChatColor.YELLOW + "Lists a help message on how to use colors.");
                    return true;
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("list")) {
                        player.sendMessage(list());
                    }
                    if (args[0].equalsIgnoreCase("color") || args[0].equalsIgnoreCase("colour")) {
                        player.sendMessage(color());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /*private char[] colorStrip(String input) {
        char[] inputChars = input.toCharArray();

    }*/

    private String list() {
        return (ChatColor.YELLOW + "The following are announcement types that can be used:\n" +
                ChatColor.GREEN  + " Power " + ChatColor.YELLOW + "(power, off)\n" +
                ChatColor.GREEN  + " Attention <message> " + ChatColor.YELLOW + "(attention, attn)\n" +
                ChatColor.GREEN  + " Dragon <killer> " + ChatColor.YELLOW + "(dragon, ender)\n" +
                ChatColor.GREEN  + " A <message> " + ChatColor.YELLOW + "(a)");
    }

    private String color() {
        return (ChatColor.YELLOW  + "The way that colors work is as follows:\n" +
                ChatColor.YELLOW  + " The first color is the background, the second is the foreground.\n" +
                ChatColor.YELLOW  + " For instance, F6 would be a " + ChatColor.WHITE + "white " + ChatColor.YELLOW + "background with " + ChatColor.GOLD + "gold " + ChatColor.YELLOW + " text.");
    }

    //                  dark_red,           white
    String power(ChatColor first, ChatColor second) {
        return (first + "████████████████\n" +
                first + "███████" + second + "██" + first + "███████\n" +
                first + "███████" + second + "██" + first + "███████\n" +
                first + "████" + second + "██" + first + "█" + second + "██" + first + "█" + second + "██" + first + "████\n" +
                first + "███" + second + "███" + first + "█" + second + "██" + first + "█" + second + "███" + first + "███\n" +
                first + "██" + second + "███" + first + "██" + second + "██" + first + "██" + second + "███" + first + "██\n" +
                first + "██" + second + "██" + first + "███" + second + "██" + first + "███" + second + "██" + first + "██\n" +
                first + "██" + second + "██" + first + "███" + second + "██" + first + "███" + second + "██" + first + "██" + ChatColor.RED + "     Server Rebooting...\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██" + ChatColor.RED + "     We'll be back soon!\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "███" + first + "██████" + second + "███" + first + "██\n" +
                first + "███" + second + "██████████" + first + "███\n" +
                first + "████" + second + "████████" + first + "████\n" +
                first + "████████████████\n" +
                first + "████████████████");
    }

    String attention(ChatColor first, ChatColor second, String message) {
        return (first + "████████████████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████" + ChatColor.DARK_AQUA + message + "\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "████████████████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "██████" + second + "████" + first + "██████\n" +
                first + "████████████████");
    }

    String dragon(String killer) {
        return ("\n\n" +
                ChatColor.BLACK + "████████████████\n" +
                ChatColor.BLACK + "████████████████\n" +
                ChatColor.BLACK + "█" + ChatColor.DARK_GRAY + "███" + ChatColor.BLACK + "████████" + ChatColor.DARK_GRAY + "███" + ChatColor.BLACK + "█" + ChatColor.DARK_PURPLE +
                ChatColor.BLACK + "████" + ChatColor.DARK_GRAY + "██" + ChatColor.BLACK + "████" + ChatColor.DARK_GRAY + "██" + ChatColor.BLACK + "████" + ChatColor.YELLOW +
                ChatColor.BLACK + "█" + ChatColor.DARK_GRAY + "██" + ChatColor.BLACK + "██" + ChatColor.DARK_GRAY + "█" + ChatColor.BLACK + "████" + ChatColor.DARK_GRAY + "█" + ChatColor.BLACK + "██" + ChatColor.DARK_GRAY + "██" + ChatColor.BLACK + "█\n" +
                ChatColor.BLACK + "█" + ChatColor.DARK_GRAY + "█" + ChatColor.LIGHT_PURPLE + "█" + ChatColor.DARK_PURPLE + "█" + ChatColor.LIGHT_PURPLE + "█" + ChatColor.BLACK + "█" + ChatColor.DARK_GRAY + "█" + ChatColor.BLACK + "██" + ChatColor.DARK_GRAY + "█" + ChatColor.BLACK + "█" + ChatColor.LIGHT_PURPLE + "█" + ChatColor.DARK_PURPLE + "█" + ChatColor.LIGHT_PURPLE + "█" + ChatColor.DARK_GRAY + "█" + ChatColor.BLACK + "█\n" +
                ChatColor.BLACK + "█" + ChatColor.DARK_GRAY + "█" + ChatColor.LIGHT_PURPLE + "█" + ChatColor.DARK_PURPLE + "██" + ChatColor.LIGHT_PURPLE + "█" + ChatColor.BLACK + "████" + ChatColor.LIGHT_PURPLE + "█" + ChatColor.DARK_PURPLE + "██" + ChatColor.LIGHT_PURPLE + "█" + ChatColor.DARK_GRAY + "█" + ChatColor.BLACK + "█\n" +
                ChatColor.BLACK + "█" + ChatColor.DARK_GRAY + "█████" + ChatColor.BLACK + "████" + ChatColor.DARK_GRAY + "█████" + ChatColor.BLACK + "█" + ChatColor.DARK_PURPLE + "     Ender Dragon " + ChatColor.YELLOW + "Slain By:" +
                ChatColor.BLACK + "████████████████" + "     " + ChatColor.GREEN + killer +
                ChatColor.BLACK + "████████████████\n" +
                ChatColor.BLACK + "████████████████\n" +
                ChatColor.BLACK + "████████████████\n" +
                ChatColor.BLACK + "███" + ChatColor.DARK_GRAY + "█" + ChatColor.DARK_PURPLE + "█" + ChatColor.LIGHT_PURPLE + "██████" + ChatColor.DARK_PURPLE + "█" + ChatColor.DARK_GRAY + "█" + ChatColor.BLACK + "███\n" +
                ChatColor.BLACK + "███" + ChatColor.DARK_GRAY + "█" + ChatColor.DARK_PURPLE + "█" + ChatColor.LIGHT_PURPLE + "██████" + ChatColor.DARK_PURPLE + "█" + ChatColor.DARK_GRAY + "█" + ChatColor.BLACK + "███\n" +
                ChatColor.BLACK + "████████████████\n" +
                ChatColor.BLACK + "████████████████\n" +
                "\n\n");
    }

    String a(ChatColor first, ChatColor second, String message) {
        return (first + "████████████████\n" +
                first + "███" + second + "██████████" + first + "███\n" +
                first + "██" + second + "████████████" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "████████████" + first + "██" + ChatColor.RED + message + "\n" +
                first + "██" + second + "████████████" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "██" + second + "██" + first + "████████" + second + "██" + first + "██\n" +
                first + "████████████████");
    }
}