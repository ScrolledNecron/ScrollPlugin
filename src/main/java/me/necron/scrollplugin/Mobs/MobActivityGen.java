package me.necron.scrollplugin.Mobs;

import me.necron.scrollplugin.ScrollPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MobActivityGen {
    public static void delayMsgMob(Player player, String customName, String message, int ticks){
        new BukkitRunnable(){
            @Override
            public void run() {
                player.sendMessage(ChatColor.GREEN + " " + customName + ChatColor.DARK_GRAY + ": " + ChatColor.YELLOW + message );
            }
        }.runTaskLater(ScrollPlugin.getInstance(),ticks);
    }
    public static void delaySound(Player player, Location loc, int ticks,Sound sound,int dSound, int dSound1){
        new BukkitRunnable(){
            @Override
            public void run() {
                if(player != null && player.isOnline() && loc != null){
                    player.playSound(loc,sound,dSound,dSound1);
                }
            }
        }.runTaskLater(ScrollPlugin.getInstance(),ticks);

    }
}
