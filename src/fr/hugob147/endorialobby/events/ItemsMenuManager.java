package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.listeners.PlayerJoin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemsMenuManager
{
	public ItemsMenuManager(ItemStack item, Player player)
	{
		if(item == null)
		{
			return;
		}else
		{
			if (item.isSimilar(new PlayerJoin().getStar()))
			{
				player.openInventory(new InventoryManager(player).endoriaMenu());
			}else if(item.isSimilar(new InventoryManager().endoriaMenu().getItem(29)))
			{
				player.openInventory(new InventoryManager(player).uhcrunServers());
			}else if(item.isSimilar(new InventoryManager().endoriaMenu().getItem(13)))
			{
				player.openInventory(new InventoryManager(player).taupeGunServers());
			}else if(item.isSimilar(new InventoryManager().endoriaMenu().getItem(31)))
			{
				player.openInventory(new InventoryManager(player).skyWarsServers());
			}else if(item.isSimilar(new InventoryManager().endoriaMenu().getItem(33)))
			{
				player.openInventory(new InventoryManager(player).bedWarsServers());
			}
		}
	}

}
