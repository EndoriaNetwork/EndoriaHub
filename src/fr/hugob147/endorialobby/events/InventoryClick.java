package fr.hugob147.endorialobby.events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.listeners.PlayerJoin;
import fr.hugob147.endorialobby.utils.Cooldowns;
import org.bukkit.Material;
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

		if(i.isSimilar(new PlayerJoin().getStar()) || i.isSimilar(new PlayerJoin().getGold()) || i.isSimilar(new PlayerJoin().getJumpOff()) || i.isSimilar(new PlayerJoin().getJumpOn()) || i.isSimilar(new PlayerJoin().getPlayersYesVisible()) || i.isSimilar(new PlayerJoin().getPlayersNoVisible()))
		{
			if(!Cooldowns.byPass.contains(p.getUniqueId()))
			{
				e.setCancelled(true);
			}
		}

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
				new ItemsMenuManager(new InventoryManager(p).endoriaMenu().getItem(21), p);
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

		Inventory menuBoutique = new InventoryManager(p).menuboutique();
		if(inv.getName().equals(menuBoutique.getName())){
			e.setCancelled(true);
			if(i.isSimilar(menuBoutique.getItem(21)))
			{
				new ItemsMenuManager(new InventoryManager(p).menuboutique().getItem(21), p);
			}else if(i.isSimilar(menuBoutique.getItem(23)))
			{
				new ItemsMenuManager(new InventoryManager(p).menuboutique().getItem(23), p);
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
