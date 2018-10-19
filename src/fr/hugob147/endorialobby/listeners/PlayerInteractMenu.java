package fr.hugob147.endorialobby.listeners;

import fr.hugob147.endorialobby.events.InventoryManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractMenu implements Listener
{
	@EventHandler public void onMenuInteract(PlayerInteractEvent e)
	{
		if (e.getItem() == null)
			return;
		ItemStack i = e.getItem();
		Player p = e.getPlayer();
		InventoryManager invs = new InventoryManager(p);
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)
		{
			if (i == new PlayerJoin().getStar())
			{
				invs.endoriamenu();
				e.setCancelled(true);
			}
		}
	}
}
