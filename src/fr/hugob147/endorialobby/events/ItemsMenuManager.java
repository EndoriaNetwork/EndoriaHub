package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.listeners.PlayerJoin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemsMenuManager
{
	EndoriaLobby main = EndoriaLobby.getInstance();
	public ItemsMenuManager(ItemStack item, Player player)
	{
		if(item == null)
		{
			return;
		}else
		{
			if (item.isSimilar(new PlayerJoin().getGold())){
				player.openInventory(new InventoryManager(player).menuboutique());
			}
			if (item.isSimilar(new PlayerJoin().getStar()))
			{
				player.openInventory(new InventoryManager(player).endoriaMenu());
			}else if(item.isSimilar(new InventoryManager(player).endoriaMenu().getItem(29)))
			{
				player.openInventory(main.uhcInv.toInventory());
			}else if(item.isSimilar(new InventoryManager(player).endoriaMenu().getItem(13)))
			{
				player.openInventory(main.tuapeInv.toInventory());
			}else if(item.isSimilar(new InventoryManager(player).endoriaMenu().getItem(31)))
			{
				player.openInventory(main.skywarsInv.toInventory());
			}else if(item.isSimilar(new InventoryManager(player).endoriaMenu().getItem(33)))
			{
				player.openInventory(main.bedwarsInv.toInventory());
			}
		}
	}

}
