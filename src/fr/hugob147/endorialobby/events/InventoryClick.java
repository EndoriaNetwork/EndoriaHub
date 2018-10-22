package fr.hugob147.endorialobby.events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.hugob147.endorialobby.EndoriaLobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener
{
	EndoriaLobby main;

	public InventoryClick(EndoriaLobby main)
	{
		this.main = main;
	}

	@EventHandler
    public void onClick(InventoryClickEvent e){
		if(e.getCurrentItem() == null) return;
        Player p = (Player) e.getWhoClicked();
		ItemStack i = e.getCurrentItem();
		Inventory inv = e.getClickedInventory();

		Inventory endoriaMenu = new InventoryManager(p).endoriaMenu();

		if(inv.getName().equals(endoriaMenu.getName()))
		{
			e.setCancelled(true);
			if(i.isSimilar(endoriaMenu.getItem(23)))
			{
				p.sendMessage("§aVous allez être connecté au serveur : §bOP-Prison");
				changeServer(p, "PrisonEndoria");
			}else if(i.isSimilar(endoriaMenu.getItem(33)))
			{
				new ItemsMenuManager(new InventoryManager(p).endoriaMenu().getItem(33), p);
			}else if(i.isSimilar(endoriaMenu.getItem(21)))
			{
				p.sendMessage("§aVous allez être connecté au serveur : §bFaction");
				changeServer(p, "FactionEndoria");
			}else if(i.isSimilar(endoriaMenu.getItem(13)))
			{
				new ItemsMenuManager(new InventoryManager(p).endoriaMenu().getItem(13), p);
			}else if(i.isSimilar(endoriaMenu.getItem(29)))
			{
				new ItemsMenuManager(new InventoryManager(p).endoriaMenu().getItem(29), p);
			}else if(i.isSimilar(endoriaMenu.getItem(31)))
			{
				new ItemsMenuManager(new InventoryManager(p).endoriaMenu().getItem(31), p);
			}
		}


    }

	public void changeServer(final Player p, final String serveur)
	{
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(serveur);
		p.sendPluginMessage(main, "BungeeCord", out.toByteArray());
	}

}
