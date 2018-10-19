package fr.hugob147.endorialobby.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener
{
	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();

		if(p.getGameMode() == GameMode.CREATIVE)
		{
			return;
		}else
		{
			e.setCancelled(true);
		}

	}
}
