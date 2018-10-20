package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.listeners.PlayerJoin;
import org.bukkit.Bukkit;
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
				new InventoryManager(player).endoriamenu();
			}
		}
	}

}
