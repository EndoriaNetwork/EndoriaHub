package fr.hugob147.endorialobby.shop;

import fr.hugob147.endorialobby.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public enum ShopItems
{

	MiniVIP(1, "§aMini-Vip", 50000, new ItemBuilder(Material.PRISMARINE_CRYSTALS).toItemStack(), ""),
	Test(2, "§c§l§kTEST", Integer.MAX_VALUE, new ItemBuilder(Material.TNT).toItemStack(), "");

	private int id;
	private String name;
	private int prix;
	private ItemStack icon;
	private String permission;

	ShopItems(int id, String name, int prix, ItemStack icon, String permission)
	{
		ItemMeta meta = icon.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList("","§ePrix : " + prix));
		icon.setItemMeta(meta);

		this.id = id;
		this.name = name;
		this.prix = prix;
		this.icon = icon;
		this.permission = permission;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public int getPrix()
	{
		return prix;
	}

	public ItemStack getIcon()
	{
		return icon;
	}

	public String getPermission()
	{
		return permission;
	}

	public boolean hasPermission()
	{
		return permission.length() > 0;
	}

}
