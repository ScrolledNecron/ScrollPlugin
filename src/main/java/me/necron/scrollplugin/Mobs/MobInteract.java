package me.necron.scrollplugin.Mobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class MobInteract implements Listener{

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        Location pLoc = p.getLocation();
        Entity entity = e.getRightClicked();
        String customName = entity.getCustomName();

        //Helper Wither Message List
        if (customName != null && customName.contains("Helper")){
            //Message List
            MobActivityGen.delayMsgMob(p, customName, "Greetings " + ChatColor.RED + p.getDisplayName() + ChatColor.YELLOW + " I have been here for a long time...",40);
            System.out.println("Msg one success");
            MobActivityGen.delayMsgMob(p, customName, "You might have come here to get challenges, but beware I warn you this place is no joke for irregular peoples.",40);
            System.out.println("Msg two success");
            MobActivityGen.delayMsgMob(p, customName, "Well, if you really want to be " + ChatColor.RED + "challenged " + ChatColor.YELLOW + "then speak to the guard he will guide you.",20);
            System.out.println("Msg three sucess");
            MobActivityGen.delaySound(p, pLoc,20,Sound.ENTITY_WITHER_SHOOT,1,20);

            System.out.println("Tasks success!");
        }else {
            return;
        }

    }
}
