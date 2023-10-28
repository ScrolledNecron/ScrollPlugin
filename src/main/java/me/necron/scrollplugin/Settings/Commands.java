package me.necron.scrollplugin.Settings;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            if(command.getName().equalsIgnoreCase("fly")){
                if (args.length == 0){
                    p.sendMessage(ChatColor.RED + "Correct usage: /fly on or /fly off");
                }

                if (args.length >= 1){
                    String selection = args[0];
                    if (selection.equalsIgnoreCase("on")){
                        p.setAllowFlight(true);
                        p.sendMessage(ChatColor.GREEN + "You have been granted the ability to fly.");
                        p.sendTitle(ChatColor.GREEN + "Flight on" ,"",1,20,1);
                    }
                    if (selection.equalsIgnoreCase("off")){
                        p.setAllowFlight(false);
                        p.sendMessage(ChatColor.GREEN + "Your ability to fly is gone.");
                        p.sendTitle(ChatColor.RED + "Flight off" ,"",1,20,1);
                    }
                    if(selection.equals(null)){
                        return true;
                    }
                }
            }
        }else{
            System.out.println("You need to be a player with op to do this!");
        }
        return false;
    }
}

