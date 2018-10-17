package fr.hugob147.endorialobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDrop implements Listener
{
	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent e)
	{
		if(e.getItemDrop() != null)
		{
			ItemStack it = e.getItemDrop().getItemStack();

			if(it == new PlayerJoin().getStar().toItemStack() || it == new PlayerJoin().getGold().toItemStack())
			{
				e.setCancelled(true);

			}
		}
	}
}
