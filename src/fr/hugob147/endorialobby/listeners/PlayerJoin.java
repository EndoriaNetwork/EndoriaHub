package fr.hugob147.endorialobby.listeners;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.scoreboard.ScoreboardManager;
import fr.hugob147.endorialobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;

public class PlayerJoin implements Listener
{
	private EndoriaLobby main = EndoriaLobby.getInstance();

	private ItemBuilder star = new ItemBuilder(Material.NETHER_STAR).setName("§5Endoria Menu").setLore(new String[] { "" });
	private ItemBuilder gold = new ItemBuilder(Material.GOLD_INGOT).setName("§b§k!§a§k!§c§k!§r §eBoutique §c§k!§a§k!§b§k!").setLore(new String[] { "" });

	@EventHandler public void onJoin(PlayerJoinEvent e)
	{
		Player player = e.getPlayer();

		this.main.rank.createAccount(player);
		this.main.coins.createAccount(player, 10L);

		e.setJoinMessage("§7[§a+§7] " + this.main.rank.getRank(player).getPrefix() + player.getName());
		player.setGameMode(GameMode.ADVENTURE);
		player.teleport(((World) Bukkit.getWorlds().get(0)).getSpawnLocation());
		player.getInventory().clear();
		player.getInventory().setHelmet(null);
		player.getInventory().setChestplate(null);
		player.getInventory().setLeggings(null);
		player.getInventory().setBoots(null);
		player.setHealth(20.0D);
		player.setFoodLevel(20);
		player.setLevel(0);
		player.setExp(0.0F);
		for (PotionEffect pe : player.getActivePotionEffects())
		{
			player.removePotionEffect(pe.getType());
		}
		//DEBUG player.sendMessage("§7[§aBanque§7] §6Votre solde est de : §e" + this.main.coins.getCoins(player) + "✪");

		ScoreboardManager sb = new ScoreboardManager(player);
		sb.init();

		player.getInventory().setItem(4, star.toItemStack());
		player.getInventory().setItem(8, gold.toItemStack());
	}

	public ItemBuilder getStar()
	{
		return star;
	}

	public ItemBuilder getGold()
	{
		return gold;
	}
}
