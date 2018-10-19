package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager
  implements Listener
{
	private Player player;

	public InventoryManager(Player player)
	{
		this.player = player;
	}

	public void endoriamenu()
	{
		Inventory inv = Bukkit.createInventory(null, 45, "§5Endoria Menu");

		ItemBuilder VitreV = new ItemBuilder(Material.STAINED_GLASS_PANE).setName("§5§lEndoria§f§lNetwork").setLore(new String[] { "" }).setWoolColor(DyeColor.PURPLE);
		ItemBuilder VitreB = new ItemBuilder(Material.STAINED_GLASS_PANE).setName("§5§lEndoria§f§lNetwork").setLore(new String[] { "" }).setWoolColor(DyeColor.WHITE);

		List<ItemStack> its = new ArrayList<>();

		its.add(VitreV.toItemStack());
		its.add(VitreB.toItemStack());

		fill(0,44, its, inv);


		ItemBuilder DIAMOND_PICKAXE = new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§bOp-Prison").setLore(new String[] { "§7Clique gauche pour rejoindre" });
		inv.setItem(23, DIAMOND_PICKAXE.toItemStack());

		ItemBuilder Tnt = new ItemBuilder(Material.TNT).setName("§cFaction").setLore(new String[] { "§7Clique gauche pour rejoindre" });
		inv.setItem(21, Tnt.toItemStack());

		ItemBuilder Taupe = new ItemBuilder(Material.GOLDEN_APPLE).setName("§cTaupe Gun").setLore(new String[] { "§7Clique gauche pour rejoindre" });
		inv.setItem(13, Taupe.toItemStack());

		ItemBuilder UhcRun = new ItemBuilder(Material.APPLE).setName("§6Uhc-Run").setLore(new String[] { "§7Clique gauche pour rejoindre" });
		inv.setItem(29, UhcRun.toItemStack());

		ItemBuilder SkyWars = new ItemBuilder(Material.EYE_OF_ENDER).setName("§bSkyWars").setLore(new String[] { "§7Clique gauche pour rejoindre" });
		inv.setItem(31, SkyWars.toItemStack());

		ItemBuilder BedWars = new ItemBuilder(Material.BED).setName("§6BedWars").setLore(new String[] { "§7Clique gauche pour rejoindre" });
		inv.setItem(33, BedWars.toItemStack());

		this.player.openInventory(inv);
	}

	private void fill(int to, int at, List<ItemStack> items, Inventory inv)
	{
		int pos = 0;
		for(int a = to; a == at; a++)
		{
			inv.setItem(a, items.get(pos));
			pos++;
			if(pos+1 >= items.size())
			{
				pos = 0;
			}
		}
	}
}
