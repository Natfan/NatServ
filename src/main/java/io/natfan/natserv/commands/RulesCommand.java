package io.natfan.natserv.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RulesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rules")) {
            sender.sendMessage(ChatColor.BOLD + "RULES:\n" +
                    ChatColor.GOLD + " 1) " + ChatColor.YELLOW + "Don't be an asshole. If someone asks you to stop doing something, stop it.\n" +
                    ChatColor.GOLD + " 2) " + ChatColor.YELLOW + "You ARE allowed to raid others, but only if they are online and you can only break blocks if it gets you access to their base. No griefing.\n" +
                    ChatColor.GOLD + " 3) " + ChatColor.YELLOW + "No random killing. If you want to fight, and you're not doing it in self defense (raiding), then organise it.\n" +
                    ChatColor.GOLD + " 4) " + ChatColor.YELLOW + "No cheating.\n" +
                    ChatColor.GOLD + " 5) " + ChatColor.YELLOW + "No abusing bugs. If you find a bug, quietly report it to Natfan/4E6174. (https://natfan.io/discord/)\n" +
                    " \n" +
                    ChatColor.RED + "Breaking these rules " + ChatColor.DARK_RED + ChatColor.BOLD + "WILL " + ChatColor.RESET + ChatColor.RED + "result in a permanent ban from the Minecraft server and maybe the Discord.");
        }
        return false;
    }
}
