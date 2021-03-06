package fr.hugob147.endorialobby;

import com.google.common.collect.Iterables;
import fr.hugob147.endorialobby.coins.Coins;
import fr.hugob147.endorialobby.events.CommandsManager;
import fr.hugob147.endorialobby.events.EventsManager;
import fr.hugob147.endorialobby.events.InventoryManager;
import fr.hugob147.endorialobby.mysql.MySQL;
import fr.hugob147.endorialobby.pluginmessaging.PluginMessageReceiver;
import fr.hugob147.endorialobby.rank.Rank;
import fr.hugob147.endorialobby.scoreboard.ScoreboardManager;
import fr.hugob147.endorialobby.scoreboard.ScoreboardRunnable;
import fr.hugob147.endorialobby.utils.FileConfig;
import fr.hugob147.endorialobby.utils.InvBuilder;
import fr.hugob147.endorialobby.utils.ServersListsUpdateRunnable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class EndoriaLobby
  extends JavaPlugin
{
	private static EndoriaLobby instance;
	public MySQL mysql = new MySQL();
	public Rank rank = new Rank();
	public Coins coins = new Coins();
	public HashMap<UUID, ScoreboardManager> scoreboard = new HashMap();
	public InvBuilder uhcInv = new InvBuilder("§5§lServeurs §f§lUHCRun", 54);
	public InvBuilder bedwarsInv = new InvBuilder("§5§lServeurs §f§lBedWars", 54);
	public InvBuilder skywarsInv = new InvBuilder("§5§lServeurs §f§lSkyWars", 54);
	public InvBuilder sheepwarsInv = new InvBuilder("§5§lServeurs §f§lSheepWars", 54);
	public InvBuilder tuapeInv = new InvBuilder("§5§lServeurs §f§lTaupeGun", 54);
	public List<Player> canDoubleJump = new ArrayList<>();

	public void onEnable()
	{
		instance = this;

		new EventsManager().registers(this);
		new CommandsManager().registers(this);

		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		getServer().getMessenger().registerOutgoingPluginChannel(this, "Endoria");
		getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PluginMessageReceiver());
		getServer().getMessenger().registerIncomingPluginChannel(this, "Endoria", new PluginMessageReceiver());

		new ScoreboardRunnable().runTaskTimer(this, 0L, 60L);
		new ServersListsUpdateRunnable().runTaskTimer(this, 0L, 20L);
	}

	public void onDisable() {
		mysql.disconnect();
	}

	public static EndoriaLobby getInstance()
	{
		return instance;
	}

	public void updateServersList()
	{
		FileConfig.createFile(new File("path") , "servers", "yml");
		if (Bukkit.getOnlinePlayers().size() > 0)
		{
			Player p = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);

			File servers = FileConfig.getFile(new File("path") , "servers", "yml");

			this.uhcInv = new InventoryManager(p.getPlayer()).serverInvInit("UHCRun", this.uhcInv);
			this.bedwarsInv = new InventoryManager(p.getPlayer()).serverInvInit("BedWars", this.bedwarsInv);
			this.skywarsInv = new InventoryManager(p.getPlayer()).serverInvInit("SkyWars", this.skywarsInv);
			this.sheepwarsInv = new InventoryManager(p.getPlayer()).serverInvInit("SheepWars", this.sheepwarsInv);
			this.tuapeInv = new InventoryManager(p.getPlayer()).serverInvInit("TaupeGun", this.tuapeInv);
		}
	}
}
