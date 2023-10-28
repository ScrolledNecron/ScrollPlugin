package me.necron.scrollplugin.Mobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;

public class MobSpawn implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            World w = p.getWorld();
            Location hWitherLoc = new Location(w,191,69,270);

            if(p.isOp()){
                if(cmd.getName().equalsIgnoreCase("spawn")){
                    if(strings.length == 0){
                        p.sendMessage(ChatColor.RED + "Correct usage: /spawn <entityname>");
                    }
                    if (strings.length >= 1){
                        String mob = strings[0];
                        if(mob.equalsIgnoreCase("hWither")){
                            //Wither giving tips!!
                            Wither wither = (Wither) w.spawnEntity(hWitherLoc,EntityType.WITHER);
                            wither.setCustomName(ChatColor.RED + "[۞] " + ChatColor.GREEN + "Helper " + ChatColor.RED + "[۞]");
                            wither.setCustomNameVisible(true);
                            wither.setAI(false);
                            wither.setInvulnerable(true);
                            p.sendTitle(ChatColor.GREEN + "Helper wither spawned!","",1,20,1);
                        }
                    }
                }
            }else{
                p.sendMessage(ChatColor.RED + "This is a admin command!");
            }

        }else{
            System.out.println("You need to be a player with op to do this.");
        }
        return false;
    }
}