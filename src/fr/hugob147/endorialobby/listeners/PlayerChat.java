package fr.hugob147.endorialobby.listeners;

import fr.hugob147.endorialobby.rank.Rank;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat
  implements Listener
{
	@EventHandler public void onChat(AsyncPlayerChatEvent e)
	{
		Player p = e.getPlayer();
		e.setFormat(new Rank().getRank(p).getPrefix() + "%1$s §7: §f%2$s");
	}
}
