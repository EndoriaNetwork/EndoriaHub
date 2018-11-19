package fr.hugob147.endorialobby.listeners;

import org.bukkit.Material;
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

			if(it.isSimilar(new PlayerJoin().getStar())|| it.isSimilar(new PlayerJoin().getGold()) || it.isSimilar(new PlayerJoin().getJumpOn())|| it.isSimilar(new PlayerJoin().getJumpOff()) || it.isSimilar(new PlayerJoin().getPlayersYesVisible()) || it.isSimilar(new PlayerJoin().getPlayersNoVisible()))
			{
				e.setCancelled(true);
			}
		}
	}
}
