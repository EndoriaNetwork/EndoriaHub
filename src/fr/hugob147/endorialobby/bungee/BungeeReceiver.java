package fr.hugob147.endorialobby.bungee;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.hugob147.endorialobby.EndoriaLobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.ArrayList;
import java.util.List;

public class BungeeReceiver implements PluginMessageListener
{
	static String[] servers = null;
	static Integer playerCount = null;
	static Integer playerList = null;
	@Override public void onPluginMessageReceived(String channel, Player player, byte[] message)
	{
		if (!channel.equals("BungeeCord")) {
			return;
		}
		ByteArrayDataInput in = ByteStreams.newDataInput(message);
		String subchannel = in.readUTF();
		if (subchannel.equals("GetServers")) {

			this.servers = in.readUTF().split(", ");
		}
		if (subchannel.equals("PlayerCount")) {

			playerCount = in.readInt();
		}
		if (subchannel.equals("PlayerList")) {

			playerList = in.readInt();
		}
	}

	public void init()
	{
		Bukkit.getScheduler().runTaskTimer(EndoriaLobby.getInstance(), new Runnable()
		{
			@Override public void run()
			{

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("GetServers");

				Player player = Bukkit.getPlayer(Bukkit.getOnlinePlayers().iterator().next().getPlayer().getName());

				player.sendPluginMessage(EndoriaLobby.getInstance(), "BungeeCord", out.toByteArray());
			}
		}, 0,20);
	}

	public static List<String> getServers()
	{
		List<String> servs = new ArrayList<>();

		for(String s : servers)
		{
			servs.add(s);
		}
		return servs;
	}

	public static Integer getPlayerCount()
	{
		return playerCount;
	}

	public static Integer getPlayerlist()
	{
		return playerList;
	}
}
