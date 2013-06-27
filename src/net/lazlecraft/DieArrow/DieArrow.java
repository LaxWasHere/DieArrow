package net.lazlecraft.diearrow;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class DieArrow extends JavaPlugin implements Listener {
	
    public void onEnable() {
    	getServer().getPluginManager().registerEvents(this, this);
    }

    	@EventHandler
        public void onProjectileHit(ProjectileHitEvent ev) {
        	final Entity entity = ev.getEntity();	
        	if (entity.getType() == EntityType.ARROW) {
    	        new BukkitRunnable() {
    	            public void run() {
    	            	entity.remove();
    	            }
    	        }.runTaskLater(this, 20L);
        	}
    }
}