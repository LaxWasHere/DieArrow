package net.lazlecraft.diearrow;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class DieArrow extends JavaPlugin implements Listener {
	
	public int delay;
	
    public void onEnable() {
    	getConfig().options().copyDefaults(true);
    	this.saveConfig();
    	getServer().getPluginManager().registerEvents(this, this);
    	delay = getConfig().getInt("seconds");
    }

    	@EventHandler
        public void onProjectileHit(ProjectileHitEvent ev) {
        	final Entity entity = ev.getEntity();	
        	if (entity.getType() == EntityType.ARROW) {
    	        new BukkitRunnable() {
    	            public void run() {
    	            	entity.remove();
    	            }
    	        }.runTaskLater(this, 20 * delay);
        	}
    }
}