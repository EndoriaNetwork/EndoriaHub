package fr.hugob147.endorialobby.events;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.shop.ShopItems;
import fr.hugob147.endorialobby.utils.InvBuilder;
import fr.hugob147.endorialobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InventoryManager
{
	private static Player player;
	private static String[] servers;
	public static int playerCount = 0;
	public static int playerList = 1;
	private int i = 0;

	public InventoryManager(Player player)
	{
		InventoryManager.player = player;
	}

	public Inventory endoriaMenu()
	{
		InvBuilder inv = new InvBuilder("§5Endoria Menu", 45);

		ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE).setName("§5§lEndoria§f§lNetwork").setLore("").setGlassPaneColor(DyeColor.PURPLE).toItemStack();
		ItemStack DIAMOND_PICKAXE = new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§bOp-Prison").setLore(
				"§7Clique gauche pour rejoindre").toItemStack();
		ItemStack SHEEPWARS = new ItemBuilder(Material.WOOL).setWoolColor(DyeColor.GREEN).setName("§aSheepWars").setLore("§7Clique gauche pour rejoindre").toItemStack();
		ItemStack TAUPE = new ItemBuilder(Material.GOLDEN_APPLE).setName("§cTaupe Gun").setLore(
				"§7Clique gauche pour rejoindre").toItemStack();
		ItemStack UHCRUN = new ItemBuilder(Material.APPLE).setName("§6Uhc-Run").setLore(
				"§7Clique gauche pour rejoindre").toItemStack();
		ItemStack SKYWARS = new ItemBuilder(Material.EYE_OF_ENDER).setName("§bSkyWars").setLore(
				"§7Clique gauche pour rejoindre").toItemStack();
		ItemStack BEDWARS = new ItemBuilder(Material.BED).setName("§6BedWars").setLore("§7Clique gauche pour rejoindre").toItemStack();

		inv.setItem(DIAMOND_PICKAXE,23);
		inv.setItem(SHEEPWARS,21);
		inv.setItem(TAUPE,13);
		inv.setItem(UHCRUN,29);
		inv.setItem(SKYWARS,31);
		inv.setItem(BEDWARS,33);

		inv.fillEmptySlot(vitre);

		return inv.toInventory();
	}

	public Inventory menuboutique(){
		InvBuilder inv = new InvBuilder("§b§k!§a§k!§c§k!§r §eBoutique §c§k!§a§k!§b§k!", 45);
		ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE).setName("§5§lEndoria§f§lNetwork").setLore("").setGlassPaneColor(DyeColor.PURPLE).toItemStack();
		ItemStack Diamond = new ItemBuilder(Material.DIAMOND).setName("§bGrade").setLore("").toItemStack();
		ItemStack Gold = new ItemBuilder(Material.GOLD_INGOT).setName("§eParticule").setLore("").toItemStack();

		inv.setItem(Diamond, 21);
		inv.setItem(Gold, 23);

		inv.fillEmptySlot(vitre);

		return inv.toInventory();
	}

	public Inventory menuboutiquegrade(){
		InvBuilder inv = new InvBuilder("§b§k!§a§k!§c§k!§r §eBoutique §c§k!§a§k!§b§k!", 27);
		ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE).setName("§5§lEndoria§f§lNetwork").setLore("").setGlassPaneColor(DyeColor.PURPLE).toItemStack();

		inv.fillSlotToSlot(0,10,vitre);

		for(ShopItems shop : ShopItems.values())
		{
			inv.addItem(shop.getIcon());
		}

		inv.fillEmptySlot(vitre);

		return inv.toInventory();
	}

	public InvBuilder serverInvInit(String server, InvBuilder inv)
	{

		ItemStack online = new ItemBuilder(Material.STAINED_CLAY).setClayColor(DyeColor.GREEN).setLore(
				"§aClique gauche pour rejoindre","","§7Clique droit pour voir les joueurs connectés").toItemStack();
		ItemStack full = new ItemBuilder(Material.STAINED_CLAY).setClayColor(DyeColor.ORANGE).setLore(
				"§6Ce serveur est complet","","§7Clique droit pour voir les joueurs connectés").toItemStack();
		ItemStack close = new ItemBuilder(Material.STAINED_CLAY).setClayColor(DyeColor.RED).setLore(
				"§cLa partie a déjà commencé","","§7Clique droit pour voir les joueurs connectés").toItemStack();

		//getServers(player);

		Bukkit.getScheduler().scheduleSyncDelayedTask(EndoriaLobby.getInstance(), new Runnable()
		{
			@Override public void run()
			{
				i = 0;
				for(String s : servers)
				{
					if(s.contains(server))
					{
						//getMaxPlayers(s, player);
						//getPlayerCount(s, player);
						Bukkit.getScheduler().scheduleSyncDelayedTask(EndoriaLobby.getInstance(), new Runnable()
						{
							@Override public void run()
							{
								if (playerCount < playerList)
								{
									ItemStack serv = online.clone();
									serv.setAmount(playerCount);
									ItemMeta meta = serv.getItemMeta();
									meta.setDisplayName("§a" + s);
									serv.setItemMeta(meta);

									inv.setItem(serv,i);
								} else if (playerCount == playerList)
								{
									ItemStack serv = full.clone();
									serv.setAmount(playerCount);
									ItemMeta meta = serv.getItemMeta();
									meta.setDisplayName("§6" + s);
									serv.setItemMeta(meta);

									inv.setItem(serv,i);
								} else
								{
									ItemStack serv = close.clone();
									serv.setAmount(playerCount);
									ItemMeta meta = serv.getItemMeta();
									meta.setDisplayName("§c" + s);
									serv.setItemMeta(meta);

									inv.setItem(serv,i);
								}
								i++;
							}
						},2L);

					}
				}


			}
		},2L);
		return inv;
	}
}
