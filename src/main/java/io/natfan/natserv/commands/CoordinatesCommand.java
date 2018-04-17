package io.natfan.natserv.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoordinatesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("coordinates")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location location = player.getLocation();
                player.chat("My coordinates are: " + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ());
                return true;
            } else {
                sender.sendMessage(ChatColor.DARK_RED + "This command is for players only, hoss.");
                return true;
            }
        }
        return false;
    }
}
