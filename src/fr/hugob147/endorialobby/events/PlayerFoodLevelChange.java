package fr.hugob147.endorialobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerFoodLevelChange implements Listener
{
	@EventHandler public void onFoodLevelChange(FoodLevelChangeEvent e)
	{
		e.setCancelled(true);
	}
}
