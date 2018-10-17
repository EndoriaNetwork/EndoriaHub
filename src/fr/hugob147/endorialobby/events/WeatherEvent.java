package fr.hugob147.endorialobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherEvent implements Listener
{
	@EventHandler public void weather(WeatherChangeEvent e)
	{
		e.setCancelled(true);
	}
}
