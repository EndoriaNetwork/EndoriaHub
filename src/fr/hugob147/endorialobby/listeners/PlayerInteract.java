package fr.hugob147.endorialobby.listeners;

import fr.hugob147.endorialobby.events.InventoryManager;
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
		InventoryManager invs = new InventoryManager(p);

		if(p.getGameMode() == GameMode.CREATIVE)
		{
			return;
		}else
		{
			if(e.getItem() != null)
			{
				switch (e.getItem().getType())
				{
					case NETHER_STAR:
						if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Endoria Menu")){
							invs.endoriamenu();
						}
				default:
					e.setCancelled(true);
					break;
				}
			}else
			{
				e.setCancelled(true);
			}

		}

	}
}
