package net.lazlecraft.DieArrow;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class DieArrow extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
    	getServer().getPluginManager().registerEvents(this, this);
        PluginDescriptionFile plugin = getDescription();
        System.out.println(plugin.getName() + " version " + plugin.getVersion() + " by LaxWasHere enabled.");
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile plugin = getDescription();
        System.out.println(plugin.getName() + " version " + plugin.getVersion() + " by LaxWasHere disabled.");
    }
    @EventHandler(priority = EventPriority.NORMAL)
        public void onProjectileHit(ProjectileHitEvent event) {
        	Entity entity = event.getEntity();
        	
        	if (entity.getType() == EntityType.ARROW) {
        		Bukkit.shutdown();
        	}
        }
}


