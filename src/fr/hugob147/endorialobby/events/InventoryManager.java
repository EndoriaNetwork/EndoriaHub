package fr.hugob147.endorialobby.events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.bungee.BungeeReceiver;
import fr.hugob147.endorialobby.utils.InvBuilder;
import fr.hugob147.endorialobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class InventoryManager
{
	private Player player;

	public InventoryManager(Player player)
	{
		this.player = player;
	}
	public InventoryManager()
	{
		this.player = null;
	}

	public Inventory endoriaMenu()
	{
		InvBuilder inv = new InvBuilder("§5Endoria Menu", 45);

		ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE).setName("§5§lEndoria§f§lNetwork").setLore(new String[] { "" }).setWoolColor(DyeColor.PURPLE).toItemStack();
		ItemStack DIAMOND_PICKAXE = new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§bOp-Prison").setLore(new String[] { "§7Clique gauche pour rejoindre" }).toItemStack();
		ItemStack TNT = new ItemBuilder(Material.TNT).setName("§cFaction").setLore(new String[] { "§7Clique gauche pour rejoindre" }).toItemStack();
		ItemStack TAUPE = new ItemBuilder(Material.GOLDEN_APPLE).setName("§cTaupe Gun").setLore(new String[] { "§7Clique gauche pour rejoindre" }).toItemStack();
		ItemStack UHCRUN = new ItemBuilder(Material.APPLE).setName("§6Uhc-Run").setLore(new String[] { "§7Clique gauche pour rejoindre" }).toItemStack();
		ItemStack SKYWARS = new ItemBuilder(Material.EYE_OF_ENDER).setName("§bSkyWars").setLore(new String[] { "§7Clique gauche pour rejoindre" }).toItemStack();
		ItemStack BEDWARS = new ItemBuilder(Material.BED).setName("§6BedWars").setLore(new String[] { "§7Clique gauche pour rejoindre" }).toItemStack();

		inv.setItem(DIAMOND_PICKAXE,23);
		inv.setItem(TNT,21);
		inv.setItem(TAUPE,13);
		inv.setItem(UHCRUN,29);
		inv.setItem(SKYWARS,31);
		inv.setItem(BEDWARS,33);

		inv.fillEmptySlot(vitre);

		return inv.toInventory();
	}

	public Inventory uhcrunServers()
	{
		InvBuilder inv = new InvBuilder("§5§lServeurs §f§lUHCRun", 54);

		ItemStack online = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.GREEN).setLore(new String[] {"§aClique gauche pour rejoindre","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();
		ItemStack full = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.ORANGE).setLore(new String[] {"§6Ce serveur est complet","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();
		ItemStack close = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.RED).setLore(new String[] {"§cLa partie a déjà commencé","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();

		for(String s : BungeeReceiver.getServers())
		{
			if(s.contains("UHCRun"))
			{
				int nbPlayers = getPlayerCount(s);
				int nbMaxPlayers = getMaxPlayers(s);

				if (nbPlayers < nbMaxPlayers)
				{
					ItemStack serv = online.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§a" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				} else if (nbPlayers == nbMaxPlayers)
				{
					ItemStack serv = full.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§6" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				} else
				{
					ItemStack serv = close.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§c" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				}
			}
		}

		return inv.toInventory();
	}

	public Inventory bedWarsServers()
	{
		InvBuilder inv = new InvBuilder("§5§lServeurs §f§lBedWars", 54);

		ItemStack online = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.GREEN).setLore(new String[] {"§aClique gauche pour rejoindre","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();
		ItemStack full = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.ORANGE).setLore(new String[] {"§6Ce serveur est complet","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();
		ItemStack close = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.RED).setLore(new String[] {"§cLa partie a déjà commencé","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();

		for(String s : BungeeReceiver.getServers())
		{
			if(s.contains("BedWars"))
			{
				int nbPlayers = getPlayerCount(s);
				int nbMaxPlayers = getMaxPlayers(s);

				if (nbPlayers < nbMaxPlayers)
				{
					ItemStack serv = online.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§a" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				} else if (nbPlayers == nbMaxPlayers)
				{
					ItemStack serv = full.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§6" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				} else
				{
					ItemStack serv = close.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§c" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				}
			}
		}

		return inv.toInventory();
	}

	public Inventory skyWarsServers()
	{
		InvBuilder inv = new InvBuilder("§5§lServeurs §f§lSkyWars", 54);

		ItemStack online = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.GREEN).setLore(new String[] {"§aClique gauche pour rejoindre","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();
		ItemStack full = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.ORANGE).setLore(new String[] {"§6Ce serveur est complet","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();
		ItemStack close = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.RED).setLore(new String[] {"§cLa partie a déjà commencé","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();

		for(String s : BungeeReceiver.getServers())
		{
			if(s.contains("SkyWars"))
			{
				int nbPlayers = getPlayerCount(s);
				int nbMaxPlayers = getMaxPlayers(s);

				if (nbPlayers < nbMaxPlayers)
				{
					ItemStack serv = online.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§a" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				} else if (nbPlayers == nbMaxPlayers)
				{
					ItemStack serv = full.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§6" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				} else
				{
					ItemStack serv = close.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§c" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				}
			}
		}

		return inv.toInventory();
	}

	public Inventory taupeGunServers()
	{
		InvBuilder inv = new InvBuilder("§5§lServeurs §f§lTaupeGun", 54);

		ItemStack online = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.GREEN).setLore(new String[] {"§aClique gauche pour rejoindre","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();
		ItemStack full = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.ORANGE).setLore(new String[] {"§6Ce serveur est complet","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();
		ItemStack close = new ItemBuilder(Material.HARD_CLAY).setClayColor(DyeColor.RED).setLore(new String[] {"§cLa partie a déjà commencé","","§7Clique droit pour voir les joueurs connectés"}).toItemStack();

		for(String s : BungeeReceiver.getServers())
		{
			if(s.contains("TaupeGun"))
			{
				int nbPlayers = getPlayerCount(s);
				int nbMaxPlayers = getMaxPlayers(s);

				if (nbPlayers < nbMaxPlayers)
				{
					ItemStack serv = online.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§a" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				} else if (nbPlayers == nbMaxPlayers)
				{
					ItemStack serv = full.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§6" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				} else
				{
					ItemStack serv = close.clone();
					serv.setAmount(nbPlayers);
					ItemMeta meta = serv.getItemMeta();
					meta.setDisplayName("§c" + s);
					serv.setItemMeta(meta);

					inv.addItem(serv);
				}
			}
		}

		return inv.toInventory();
	}


	private Integer getPlayerCount(String server)
	{
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("PlayerCount");
		out.writeUTF(server);


		Player player = Bukkit.getPlayer(Bukkit.getOnlinePlayers().iterator().next().getPlayer().getName());

		player.sendPluginMessage(EndoriaLobby.getInstance(), "BungeeCord", out.toByteArray());
		return BungeeReceiver.getPlayerCount();
	}

	private Integer getMaxPlayers(String server)
	{
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("PlayerList");
		out.writeUTF(server);


		Player player = Bukkit.getPlayer(Bukkit.getOnlinePlayers().iterator().next().getPlayer().getName());

		player.sendPluginMessage(EndoriaLobby.getInstance(), "BungeeCord", out.toByteArray());
		return BungeeReceiver.getPlayerlist();
	}
}
