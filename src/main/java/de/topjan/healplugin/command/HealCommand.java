package de.topjan.healplugin.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        //Command sender has not operator
        if (!commandSender.isOp()) {
            commandSender.sendMessage("§l[System] §cTut mir leid, aber leider kannst du den Befehl nicht benutzen.");
            commandSender.sendMessage("§l[System] §cRette dich irgendwie oder stirb!");
            return false;
        }
        if (strings.length == 1) {
            // command: /heal name
            //console or player
            Player target;
            if ((target = Bukkit.getPlayer(strings[0])) != null) {
                // target is online
                target.setHealth(20.00);
                target.setFoodLevel(20);
                target.setRemainingAir(300);
                target.sendMessage("§l[System] §aPuhhh, da hat dich aber " + "§f" + commandSender.getName() + " §anoch gerettet" + "... Glück gehabt :o !");
                return true;
            } else {
                // target offline
                commandSender.sendMessage("§l[System] §cTut mir leid mein Freund, aber leider ist der Spieler " + "§f" + strings[0] + "§c nicht online!");
                return false;
            }
        }
        if (commandSender instanceof Player player) {
            // executed by a player
            player.setHealth(20.00);
            player.setFoodLevel(20);
            player.setRemainingAir(300);
            player.sendMessage("§l[System] §aPuhhh, da hast du dich aber noch gerettet... Glück gehabt :o !");
            return true;
        } else {
            // executed by console without player
            commandSender.sendMessage("Du kannst den Befehl nur als Spieler benutzen!");
            return false;
        }
    }
}

