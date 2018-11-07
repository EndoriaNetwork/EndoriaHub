package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsManager
{
	public void registers(EndoriaLobby main)
	{
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerInteract(), main);
		pm.registerEvents(new PlayerJoin(), main);
		pm.registerEvents(new PlayerQuit(), main);
		pm.registerEvents(new PlayerChat(), main);
		pm.registerEvents(new PlayerDoAchivement(), main);
		pm.registerEvents(new PlayerDrop(), main);
		pm.registerEvents(new EntityDamage(), main);
		pm.registerEvents(new PlayerFoodLevelChange(), main);
		pm.registerEvents(new WeatherEvent(), main);
		pm.registerEvents(new InventoryClick(main), main);
		pm.registerEvents(new PlayerDeath(), main);
		pm.registerEvents(new DoubleJumpEvent(), main);
	}
}
