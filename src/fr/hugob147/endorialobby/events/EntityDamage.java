package fr.hugob147.endorialobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage
  implements Listener
{
	@EventHandler public void onEntityDamage(EntityDamageEvent e)
	{
		if(e.getCause() == EntityDamageEvent.DamageCause.VOID)
		{
			e.setCancelled(false);
		}else
		{
			e.setCancelled(true);
		}
	}
}
