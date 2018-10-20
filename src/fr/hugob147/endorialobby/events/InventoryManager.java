package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.utils.InvBuilder;
import fr.hugob147.endorialobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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

	public Inventory endoriamenu()
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
}
