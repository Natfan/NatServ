package io.natfan.natserv.commands;

import io.natfan.natserv.NatServ;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SleepCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sleep")) {
            if (sender instanceof ConsoleCommandSender) {
                Player player = (Player) sender;
                int currentlyOnline = Bukkit.getOnlinePlayers().size();
                int currentlySleeping = NatServ.sleeping.size();
                int currentlyAwake = currentlyOnline - currentlySleeping;
                double currentPercentAsleep = currentlyOnline / currentlySleeping;

                double neededPercent = NatServ.sleepingNeeded;

                String msgCurrentlySleeping = ChatColor.YELLOW + "Currently, " + ChatColor.GOLD + currentPercentAsleep + "% " + ChatColor.YELLOW + "of the server is asleep.";
                String msgNeededPercentage = ChatColor.YELLOW + "There needs to be more than " + ChatColor.GOLD + neededPercent  + "% " + ChatColor.YELLOW + "of players asleep to reset the day.";

                player.sendMessage(msgCurrentlySleeping);
                player.sendMessage(msgNeededPercentage);

                if (player.isOp()) {
                    // do things with management
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
