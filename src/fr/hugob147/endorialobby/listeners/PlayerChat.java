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

			if(lmsg.contains(a.getCustomName().toLowerCase()) || lmsg.contains(a.getDisplayName().toLowerCase()) || lmsg.contains(a.getName().toLowerCase()))
			{
				a.playSound(a.getLocation(), Sound.LEVEL_UP, 100,12);
				a.sendMessage("§eTu as été §cmentionné §epar : §a" + new Rank().getRank(p).getPrefix() + p.getDisplayName());
			}
			e.setMessage(msg.replace(a.getDisplayName(), "@"+a.getDisplayName()));
		}

		e.setFormat(new Rank().getRank(p).getPrefix() + "%1$s §7: §f%2$s");
	}
}
