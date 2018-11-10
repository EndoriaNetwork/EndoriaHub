package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.commands.ByPassCmd;
import fr.hugob147.endorialobby.commands.RankCmd;
import fr.hugob147.endorialobby.commands.SocialsCmd;

public class CommandsManager
{
	public void registers(EndoriaLobby main)
	{
		RankCmd rankCmd = new RankCmd();
		SocialsCmd socialsCmd = new SocialsCmd();
		ByPassCmd bypassCmd = new ByPassCmd();

		main.getCommand("rank").setExecutor(rankCmd);
		main.getCommand("ts").setExecutor(socialsCmd);
		main.getCommand("discord").setExecutor(socialsCmd);
		main.getCommand("web").setExecutor(socialsCmd);
		main.getCommand("socials").setExecutor(socialsCmd);
		main.getCommand("bypass").setExecutor(bypassCmd);
	}
}
