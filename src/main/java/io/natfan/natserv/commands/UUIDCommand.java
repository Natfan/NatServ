package io.natfan.natserv.commands;

import io.natfan.natserv.NatServ;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UUIDCommand implements CommandExecutor {
    private String consoleUUID = NatServ.consoleUUID;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("uuid")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("Your UUID is : " + player.getUniqueId());
            } else {
                sender.sendMessage("Your UUID is: " + consoleUUID);
            }
            return true;
        }
        return false;
    }
}
