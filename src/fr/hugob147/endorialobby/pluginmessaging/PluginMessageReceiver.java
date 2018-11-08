package fr.hugob147.endorialobby.pluginmessaging;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PluginMessageReceiver implements PluginMessageListener
{
	@Override public void onPluginMessageReceived(String channel, Player player, byte[] message)
	{
		if (!channel.equals("BungeeCord") && !channel.equals("Endoria"))
		{
			return;
		}
		ByteArrayDataInput in = ByteStreams.newDataInput(message);
		String subchannel = in.readUTF();

	}
}
