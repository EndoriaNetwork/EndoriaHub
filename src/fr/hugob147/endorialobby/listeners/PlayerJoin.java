package fr.hugob147.endorialobby.listeners;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.rank.Rank;
import fr.hugob147.endorialobby.scoreboard.ScoreboardManager;
import fr.hugob147.endorialobby.utils.ItemBuilder;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.lang.reflect.Field;

public class PlayerJoin implements Listener
{
	private EndoriaLobby main = EndoriaLobby.getInstance();

	private ItemStack star = new ItemBuilder(Material.NETHER_STAR).setName("§5Endoria Menu").setLore(" ").toItemStack();
	private ItemStack gold = new ItemBuilder(Material.GOLD_INGOT).setName("§b§k!§a§k!§c§k!§r §eBoutique §c§k!§a§k!§b§k!").setLore(" ").toItemStack();
	private ItemStack jumpOn = new ItemBuilder(Material.INK_SACK).setDurability((short) 10).setName("§eSuper saut : §a§lOn").setLore(" ").toItemStack();
	private ItemStack jumpOff = new ItemBuilder(Material.INK_SACK).setDurability((short) 8).setName("§eSuper saut : §c§lOff").setLore(" ").toItemStack();
	private ItemStack playersNoVisible = new ItemBuilder(Material.SKULL_ITEM).setSkullUrl("http://textures.minecraft.net/texture/ba24a2b6b4b5a92d7a82a373fe5f6bb66872ead66c126f82e8864173cd783a").setLore(" ").setName("§dVisibilité des joueurs : §c§lNon").toItemStack();
	private ItemStack playersYesVisible = new ItemBuilder(Material.SKULL_ITEM).setSkullUrl("http://textures.minecraft.net/texture/9054d4164ea8bba02836bd513c420d04dd91b9fdbb3da17e69f9bf89ffd695").setLore(" ").setName("§dVisibilité des joueurs : §a§lOui").toItemStack();

	@EventHandler public void onJoin(PlayerJoinEvent e)
	{
		Player player = e.getPlayer();

		for(Player a : Bukkit.getOnlinePlayers())
		{
			if(a.getInventory().getItem(2) != null)
			{
				if (a.getInventory().getItem(2).isSimilar(playersNoVisible))
				{
					a.hidePlayer(player);
				} else if (a.getInventory().getItem(2).isSimilar(playersYesVisible))
				{
					a.showPlayer(player);
				}
			}
		}

		EndoriaLobby.getInstance().mysql.connect("localhost", "endoria", 3306, "Endoria", "hugo34");

		this.main.rank.createAccount(player);
		this.main.coins.createAccount(player, 0D);

		player.setGameMode(GameMode.ADVENTURE);
		player.teleport(((World) Bukkit.getWorlds().get(0)).getSpawnLocation().add(0.5,0.1,0.5));
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

		if(new Rank().init().getRank(player).getPower() <= 80)
		{
			EndoriaLobby.getInstance().canDoubleJump.add(player);
			player.getInventory().setItem(0, jumpOn);
			e.setJoinMessage(this.main.rank.init().getRank(player).getPrefix() + player.getName() + " §7a rejoint le §e§lHub§7 !");
		}else
		{
			e.setJoinMessage("");
		}
		//DEBUG player.sendMessage("§7[§aBanque§7] §6Votre solde est de : §e" + this.main.coins.getCoins(player) + "✪");

		ScoreboardManager sb = new ScoreboardManager(player);
		sb.init();

		player.getInventory().setItem(4, star);
		player.getInventory().setItem(8, gold);
		player.getInventory().setItem(2, playersYesVisible);

		ut(player);
	}

	public void ut(Player player){
		PlayerConnection con = ((CraftPlayer)player).getHandle().playerConnection;

		StringBuilder sb = new StringBuilder().append("\\").append("_'o'_").append("\\");

		IChatBaseComponent tabHeadler = IChatBaseComponent.ChatSerializer.a("{\"text\":\"§7$b_'o'_$b §fVous jouez sur §5§lEndoria§f§lNetwork §7 /_'o'_/ \n§f\"}".replace("$b","\\"));

        IChatBaseComponent tabFooter = IChatBaseComponent.ChatSerializer.a("{\"text\":\"§f\n §dSite:§fhttp://endorianetwork.eu/\"}");

		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(tabHeadler);

		try{
			Field f = packet.getClass().getDeclaredField("b");
			f.setAccessible(true);
			f.set(packet, tabFooter);

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			con.sendPacket(packet);
		}
	}

	public ItemStack getStar()
	{
		return star;
	}

	public ItemStack getGold()
	{
		return gold;
	}

	public ItemStack getJumpOn()
	{
		return jumpOn;
	}

	public ItemStack getJumpOff()
	{
		return jumpOff;
	}

	public ItemStack getPlayersNoVisible()
	{
		return playersNoVisible;
	}

	public ItemStack getPlayersYesVisible()
	{
		return playersYesVisible;
	}
}
