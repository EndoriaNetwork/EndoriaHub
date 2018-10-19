package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.commands.RankCmd;

public class CommandsManager
{
	public void registers(EndoriaLobby main)
	{
		RankCmd rankCmd = new RankCmd();
		main.getCommand("rank").setExecutor(rankCmd);
	}
}
