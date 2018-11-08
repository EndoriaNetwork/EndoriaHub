package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.listeners.PlayerJoin;
import fr.hugob147.endorialobby.rank.Rank;
import fr.hugob147.endorialobby.utils.Cooldowns;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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
			if (item.isSimilar(new PlayerJoin().getGold()))
			{
				player.openInventory(new InventoryManager(player).menuboutique());
			}else if(item.isSimilar(new InventoryManager(player).menuboutique().getItem(21)))
			{
				player.openInventory(main.grade.toInventory());
			}else if(item.isSimilar(new InventoryManager(player).menuboutique().getItem(23)))
			{
				//player.openInventory(main.particule.toInventory());
				player.closeInventory();
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 100,0.20F);
				player.sendMessage("§cCette fonctionnalité n'est pas disponible !");
			}else if (item.isSimilar(new PlayerJoin().getStar()))
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
			}else if(item.isSimilar(new PlayerJoin().getJumpOn()))
			{
				if(Cooldowns.toggleDoubleJump(player))
				{
					EndoriaLobby.getInstance().canDoubleJump.remove(player);
					player.setAllowFlight(false);
					player.setFlying(false);
					player.getInventory().setItem(0, new PlayerJoin().getJumpOff());
				}
			}else if(item.isSimilar(new PlayerJoin().getJumpOff()))
			{
				if(Cooldowns.toggleDoubleJump(player))
				{
					EndoriaLobby.getInstance().canDoubleJump.add(player);
					if (new Rank().init().getRank(player).getPower() < 25)
					{
						player.setAllowFlight(true);
					}
					player.getInventory().setItem(0, new PlayerJoin().getJumpOn());
				}
			}else if(item.isSimilar(new PlayerJoin().getPlayersYesVisible()))
			{
				if(Cooldowns.playersVisilility(player))
				{
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 100,0.20F);
					player.sendMessage("§cCette fonctionnalité n'est pas disponible !");
					//TODO: trasp player
					for(Player a : Bukkit.getOnlinePlayers())
					{

					}
					player.getInventory().setItem(2, new PlayerJoin().getPlayersTrasnpVisible());
				}
			}else if(item.isSimilar(new PlayerJoin().getPlayersTrasnpVisible()))
			{
				if(Cooldowns.playersVisilility(player))
				{
					for(Player a : Bukkit.getOnlinePlayers())
					{
						player.hidePlayer(a);
					}
					player.getInventory().setItem(2, new PlayerJoin().getPlayersNoVisible());
				}
			}else if(item.isSimilar(new PlayerJoin().getPlayersNoVisible()))
			{
				if(Cooldowns.playersVisilility(player))
				{
					for(Player a : Bukkit.getOnlinePlayers())
					{
						player.showPlayer(a);
					}
					player.getInventory().setItem(2, new PlayerJoin().getPlayersYesVisible());
				}
			}
		}
	}

}
