package me.robomwm.HotFix;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("hotfix"))
        {
            if (args.length < 2)
                return false;

            Player player = Bukkit.getPlayer(args[0]);
            player.setPlayerListName(args[1]);
            return true;
        }
        return false;
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
