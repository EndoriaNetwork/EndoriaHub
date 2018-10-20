package fr.hugob147.endorialobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvBuilder
{
	private Inventory inv;

	public InvBuilder(String name)
	{
		this(name, 9);
	}

	public InvBuilder(String name, int size)
	{
		this.inv = Bukkit.createInventory(null, size, name);
	}

	public void setItem(ItemStack item, int slot)
	{
		inv.setItem(slot, item);
	}

	public int getSize()
	{
		return inv.getSize();
	}

	public ItemStack getItem(int slot)
	{
		return inv.getItem(slot);
	}

	public String getName()
	{
		return inv.getName();
	}

	public void fillEmptySlot(ItemStack filling)
	{
		int slot = 0;
		for (ItemStack i : inv.getContents())
		{
			if(i == null)
			{
				inv.setItem(slot, filling);
			}
			slot++;
		}
	}

	public void fillSlotToSlot(int start, int stop, ItemStack item)
	{
		int slot = start;
		while(slot != stop)
		{
			inv.setItem(slot, item);
			slot++;
		}
	}

	public Inventory toInventory()
	{
		return inv;
	}

}
