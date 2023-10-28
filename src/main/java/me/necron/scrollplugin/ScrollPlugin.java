package me.necron.scrollplugin;

import me.necron.scrollplugin.Mobs.MobInteract;
import me.necron.scrollplugin.Mobs.MobSpawn;
import me.necron.scrollplugin.Settings.Commands;
import me.necron.scrollplugin.Settings.Events;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScrollPlugin extends JavaPlugin {

    static ScrollPlugin instance;
    @Override
    public void onEnable() {

        System.out.println("The plugin has been initialized");

        //Listeners
        getServer().getPluginManager().registerEvents(new Events(),this);
        getServer().getPluginManager().registerEvents(new MobInteract(),this);

        //Commands
        getCommand("spawn").setExecutor(new MobSpawn());
        getCommand("fly").setExecutor(new Commands());

        instance = this;
    }

    public static ScrollPlugin getInstance(){
        return instance;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
