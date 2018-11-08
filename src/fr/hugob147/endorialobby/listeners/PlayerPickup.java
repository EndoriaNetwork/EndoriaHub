package fr.hugob147.endorialobby.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickup implements Listener
{
	@EventHandler
	public void playerPickup(PlayerPickupItemEvent e)
	{
		Player p = e.getPlayer();

		if(p.getGameMode() != GameMode.CREATIVE)
		{
			e.setCancelled(true);
		}
	}
}
