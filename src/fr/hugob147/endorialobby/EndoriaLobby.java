package fr.hugob147.endorialobby;

import fr.hugob147.endorialobby.coins.Coins;
import fr.hugob147.endorialobby.events.CommandsManager;
import fr.hugob147.endorialobby.events.EventsManager;
import fr.hugob147.endorialobby.mysql.MySQL;
import fr.hugob147.endorialobby.rank.Rank;
import fr.hugob147.endorialobby.scoreboard.ScoreboardManager;
import fr.hugob147.endorialobby.scoreboard.ScoreboardRunnable;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class EndoriaLobby
  extends JavaPlugin
{
	private static EndoriaLobby instance;
	public MySQL mysql = new MySQL();
	public Rank rank = new Rank();
	public Coins coins = new Coins();
	public HashMap<UUID, ScoreboardManager> scoreboard = new HashMap();

	public void onEnable()
	{
		instance = this;

		new EventsManager().registers(this);
		new CommandsManager().registers(this);

		this.mysql.connect("localhost", "endoria", 3306, "Endoria", "hugo34");
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

		new ScoreboardRunnable().runTaskTimer(this, 0L, 60L);
	}

	public void onDisable() {
		mysql.disconnect();
	}

	public static EndoriaLobby getInstance()
	{
		return instance;
	}
}
