package me.robomwm.HotFix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Robo on 2/12/2016.
 */
public class Main extends JavaPlugin implements Listener
{
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
    }

    // ProjectKorra hotfix: This code cancels Explosions from other plugins
    // https://github.com/ProjectKorra/ProjectKorra/issues/400
    @EventHandler (priority = EventPriority.LOWEST)
    public void onEntityDamageByBlock(EntityDamageByBlockEvent event)
    {
        if (!event.isCancelled())
            return;

        if (event.getCause().equals(DamageCause.BLOCK_EXPLOSION))
        {
            if (event.getDamager() == null)
            {
            	event.setCancelled(false);
            }
        }
    }
}
