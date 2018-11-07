package fr.hugob147.endorialobby.listeners;

import fr.hugob147.endorialobby.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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
		String msg = e.getMessage();
		String lmsg = msg.toLowerCase();

		for(Player a : Bukkit.getOnlinePlayers())
		{
			String name = a.getDisplayName().toLowerCase();
			if(lmsg.contains(name))
			{
				a.playSound(a.getLocation(), Sound.LEVEL_UP, 100,12);
				a.sendMessage("§eTu as été §cmentionné §epar : §a" + new Rank().init().getRank(p).getPrefix() + p.getDisplayName());
			}
		}

		msg = msg.replace("&","§");
		msg = msg.replace("%", " ");
		e.setFormat(new Rank().init().getRank(p).getPrefix() + e.getPlayer().getName() + " §7: " + msg);
	}
}
