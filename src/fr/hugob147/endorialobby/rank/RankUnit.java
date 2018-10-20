package fr.hugob147.endorialobby.rank;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public enum RankUnit
{
	Joueur(100, "Joueur", "§7Joueur ", ChatColor.GRAY),
	VIP(90, "VIP", "§eVIP ", ChatColor.YELLOW),
	VIP_PLUS(80, "VIP+", "§9VIP+ ", ChatColor.BLUE),
	AMI(70, "Ami", "§dFriends ", ChatColor.LIGHT_PURPLE),
	Builder(60, "Builder", "§aBuilder ", ChatColor.GREEN),
	Resp_Build(50, "Resp.Build", "§aResp.Builder ", ChatColor.GREEN),
	Helpeur(40, "Helpeur", "§bHelpeur ", ChatColor.AQUA),
	Moderateur(30, "Mod", "§6Moderateur ", ChatColor.GOLD),
	Resp_Moderateur(20, "Resp.Mod", "§6Resp.Mod ", ChatColor.GOLD),
	Dev(10, "Développeur", "§cDéveloppeur ", ChatColor.RED),
	Admin(0, "Admin", "§4Admin ", ChatColor.DARK_RED);

	private int power;
	private String name;
	private String prefix;
	private ChatColor color;
	private static Map<Integer, RankUnit> fromPower;
	private static Map<String, RankUnit> fromName;

	private RankUnit(int power, String name, String prefix, ChatColor color)
	{
		this.power = power;
		this.name = name;
		this.prefix = prefix;
		this.color = color;
	}

	static
	{
		fromPower = new HashMap();
		fromName = new HashMap();
		for (RankUnit rank : values())
		{
			fromPower.put(Integer.valueOf(rank.power), rank);
			fromName.put(rank.name, rank);
		}
	}

	public static RankUnit getFromPower(int power)
	{
		return (RankUnit) fromPower.get(power);
	}

	public static RankUnit getFromName(String name)
	{
		for (RankUnit rank : RankUnit.getRanks())
		{
			if (rank.getName().equalsIgnoreCase(name))
			{
				return rank;
			}
		}
		return null;
	}

	public static RankUnit[] getRanks()
	{
		return values();
	}

	public int getPower()
	{
		return this.power;
	}

	public String getName()
	{
		return this.name;
	}

	public String getPrefix()
	{
		return this.prefix;
	}

	public ChatColor getColor()
	{
		return this.color;
	}
}
