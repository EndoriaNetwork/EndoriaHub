package fr.hugob147.endorialobby.utils;

import fr.hugob147.endorialobby.EndoriaLobby;
import org.bukkit.scheduler.BukkitRunnable;

public class ServersListsUpdateRunnable extends BukkitRunnable
{
	@Override public void run()
	{
		EndoriaLobby.getInstance().updateServersList();
	}
}
