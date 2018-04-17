package io.natfan.natserv.commands;

import io.natfan.natserv.NatServ;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.UUID;

public class MessageCommands implements CommandExecutor, Listener {
    private String consoleUUID = NatServ.consoleUUID;

    private String standardMessageSent            = ChatColor.GOLD + "[" + ChatColor.YELLOW + "me"       + ChatColor.GOLD + " -> " + ChatColor.YELLOW + "$player$" + ChatColor.GOLD + "] " + ChatColor.WHITE + "$message$";
    private String standardMessageRecieved        = ChatColor.GOLD + "[" + ChatColor.YELLOW + "$player$" + ChatColor.GOLD + " -> " + ChatColor.YELLOW + "me"       + ChatColor.GOLD + "] " + ChatColor.WHITE + "$message$";
    private String standardMessageRecievedConsole = "[$target$ -> me] $message$";
    private String standardMessageConsole         = "[$player$ -> $target$] $message$";
    private boolean messageDebug                  = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("message")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0 || args.length == 1) {
                    player.sendMessage(ChatColor.YELLOW + "Too little arguments, try " + ChatColor.GOLD + "/msg <player> <message>");
                    return true;
                } else {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        if (i > 1) {
                            builder.append(" ");
                        }
                        builder.append(args[i]);
                    }
                    String msg = builder.toString();
                    if (args[0].equalsIgnoreCase("server") || args[0].equalsIgnoreCase("console")) {
                        sendConsoleMessage(player, msg);
                        return true;
                    } else if (args[0].equalsIgnoreCase("all") || args[0].equalsIgnoreCase("online")) {
                        sendMassMessage(player, msg);
                        return true;
                    } else {
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        sendPrivateMessage(player, target, msg);
                        return true;
                    }
                }
            }
        }

        if (cmd.getName().equalsIgnoreCase("reply")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    player.sendMessage(ChatColor.YELLOW + "Too little arguments, try " + ChatColor.GOLD + "/reply <message>");
                    return true;
                } else {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < args.length; i++) {
                        if (i > 1) {
                            builder.append(" ");
                        }
                        builder.append(args[i]);
                    }
                    String msg = builder.toString();

                    sendReply(player, msg);
                }
            }
        }
        return false;
    }

    private void sendPrivateMessage(Player player, Player target, String message) {
        if (target != null) {
            NatServ.lastMsgMap.put(player.getUniqueId().toString(), target.getUniqueId().toString());

            String messageSent = standardMessageSent.replace("$player$", target.getName())
                    .replace("$message$", message);
            String messageReceived = standardMessageRecieved.replace("$player$", player.getName())
                    .replace("$message$", message);
            String messageSpy = standardMessageConsole.replace("$player", player.getName())
                    .replace("$target$", target.getName()).replace("$message$", message);

            if (messageDebug) {
                Bukkit.getLogger().info(messageSpy);
            }

            target.sendMessage(messageReceived);
            player.sendMessage(messageSent);
        } else {
            player.sendMessage(ChatColor.YELLOW + "That " + ChatColor.GOLD + "player " + ChatColor.YELLOW + "is not online.");
        }
    }

    private void sendMassMessage(Player player, String message) {
        if (Bukkit.getOnlinePlayers().size() >= 3) {
            String messageSent = standardMessageSent.replace("$player$", "ALL PLAYERS").replace("$message$", message);
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (!target.getName().equalsIgnoreCase(player.getName())) {
                    String messageReceived = standardMessageRecieved.replace("$player$", player.getName())
                            .replace("$message$", message);
                    target.sendMessage(messageReceived);
                }
            }
            String messageSpy = standardMessageConsole.replace("$player", player.getName())
                    .replace("$target$", "ALL PLAYERS")
                    .replace("$message$", message);
            if (messageDebug) {
                Bukkit.getLogger().info(messageSpy);
            }
            player.sendMessage(messageSent);
        } else {
            player.sendMessage(ChatColor.YELLOW + "The online player count must be >= " + ChatColor.GOLD + "three" + ChatColor.YELLOW + ".");
        }
    }

    private void sendConsoleMessage(Player player, String message) {
        NatServ.lastMsgMap.put(player.getUniqueId().toString(), consoleUUID.toString());

        String messageSent = standardMessageSent.replace("$player$", "CONSOLE")
                .replace("$message$", message);
        String messageReceived = standardMessageRecievedConsole.replace("$target$", player.getName())
                .replace("$message$", message);
        String messageSpy = standardMessageConsole.replace("$player", player.getName())
                .replace("$target$", "CONSOLE").replace("$message$", message);

        if (messageDebug) {
            Bukkit.getLogger().info(messageSpy);
        }

        Bukkit.getLogger().info(messageReceived);
        player.sendMessage(messageSent);
    }

    private void sendReply(Player player, String message) {
        if (!NatServ.lastMsgMap.containsKey(player.getUniqueId().toString())) {
            player.sendMessage(ChatColor.YELLOW + "You do not have anyone to reply to.");
        } else {
            String targetUUID = NatServ.lastMsgMap.get(player.getUniqueId().toString());
            if (targetUUID.equalsIgnoreCase(consoleUUID.toString())) {
                String messageSent = standardMessageSent.replace("$player$", "CONSOLE")
                        .replace("$message$", message);
                String messageReceivedConsole = standardMessageRecievedConsole.replace("$target$", player.getName())
                        .replace("$message$", message);

                Bukkit.getLogger().info(messageReceivedConsole);
                player.sendMessage(messageSent);
            } else {
                Player target = Bukkit.getServer().getPlayer(UUID.fromString(targetUUID));
                if (target != null) {
                    String messageSent = standardMessageSent.replace("$player$", target.getName())
                            .replace("$message$", message);
                    String messageReceived = standardMessageRecieved.replace("$player$", player.getName())
                            .replace("$message$", message);
                    String messageSpy = standardMessageConsole.replace("$player", player.getName())
                            .replace("$target$", target.getName()).replace("$message$", message);

                    if (messageDebug) {
                        Bukkit.getLogger().info(messageSpy);
                    }

                    target.sendMessage(messageReceived);
                    player.sendMessage(messageSent);
                } else {
                    player.sendMessage(ChatColor.YELLOW + "The target cannot be " + ChatColor.RED + "null" + ChatColor.YELLOW + ".");
                    Bukkit.getLogger().severe(player.getName() + " tried to message " + targetUUID + ", who is nulled. (target)");
                }
            }
        }
    }
}
