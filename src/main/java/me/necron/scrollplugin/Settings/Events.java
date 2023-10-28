package me.necron.scrollplugin.Settings;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        String name = p.getDisplayName();
        System.out.println("The player "+ name + " has logged in with ip " + p.getAddress());

        if (p.getDisplayName() != "NecronScroll"){

        }else{
            for(Player player : Bukkit.getOnlinePlayers()){
                player.sendMessage(ChatColor.RED + "/" + ChatColor.BLUE + "/" + ChatColor.GREEN + "/ " + ChatColor.DARK_RED + "The owner has logged in your server. " + ChatColor.GREEN + "/" + ChatColor.GOLD + "/" + ChatColor.RED + "/");
                Location loc = player.getLocation();
                player.playSound(loc, Sound.ENTITY_ENDERDRAGON_GROWL,10,20);
            }
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e){
        if(e.getEntityType() != EntityType.PLAYER) return;
        Player p = (Player) e.getEntity();
        p.setFoodLevel(20);
        e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(p.isOp()){
            e.setCancelled(false);
            return;
        }
        if(p.isOp() != true){
            e.setCancelled(true);
        }
    }
}
