package fr.hugob147.endorialobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class PlayerDoAchivement implements Listener
{
	@EventHandler
	public void onPlayerDoAchivement(PlayerAchievementAwardedEvent e)
	{
		e.setCancelled(true);
	}
}
