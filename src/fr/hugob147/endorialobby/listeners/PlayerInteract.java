package fr.hugob147.endorialobby.listeners;

import fr.hugob147.endorialobby.events.ItemsMenuManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener
{
	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();

		if(p.getGameMode() == GameMode.CREATIVE)
		{
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
			{
				new ItemsMenuManager(e.getItem(), e.getPlayer());
			}
			return;
		}else
		{
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
			{
				new ItemsMenuManager(e.getItem(), e.getPlayer());
			}
			e.setCancelled(true);
		}

	}
}
