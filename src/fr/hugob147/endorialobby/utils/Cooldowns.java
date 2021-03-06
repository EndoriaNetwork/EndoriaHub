package fr.hugob147.endorialobby.utils;

import org.bukkit.entity.Player;

import java.util.*;

public class Cooldowns
{
	public static List<UUID> byPass = new ArrayList<>();

	private static Map<UUID, Long> toggleDoubleJump = new HashMap<>();
	private static Map<UUID, Long> playersVisibility = new HashMap<>();
	private static Map<UUID, Long> playerChat = new HashMap<>();

	public static boolean toggleDoubleJump(Player p)
	{
		if(byPass.contains(p.getUniqueId()))
		{
			return true;
		}
		if(toggleDoubleJump.containsKey(p.getUniqueId()))
		{
			Long timeLeft = ((toggleDoubleJump.get(p.getUniqueId()) / 1000) + 2) - (System.currentTimeMillis() / 1000);
			if(timeLeft > 0)
			{
				p.sendMessage("§bVeuillez patienter entre deux actions !");
				return false;
			}
		}

		toggleDoubleJump.put(p.getUniqueId(), System.currentTimeMillis());
		return true;
	}

	public static boolean playersVisilility(Player p)
	{
		if(byPass.contains(p.getUniqueId()))
		{
			return true;
		}
		if (playersVisibility.containsKey(p.getUniqueId()))
		{
			Long timeLeft = ((playersVisibility.get(p.getUniqueId()) / 1000) + 1) - (System.currentTimeMillis() / 1000);
			if (timeLeft > 0)
			{
				p.sendMessage("§bVeuillez patienter entre deux actions !");
				return false;
			}
		}

		playersVisibility.put(p.getUniqueId(), System.currentTimeMillis());
		return true;
	}

	public static boolean playerChat(Player p)
	{
		if(byPass.contains(p.getUniqueId()))
		{
			return true;
		}
		if (playerChat.containsKey(p.getUniqueId()))
		{
			Long timeLeft = ((playerChat.get(p.getUniqueId()) / 1000) + 3) - (System.currentTimeMillis() / 1000);
			if (timeLeft > 0)
			{
				p.sendMessage("§bVeuillez patienter encore §e" + timeLeft + " secondes§b avant de parler !");
				return false;
			}
		}

		playerChat.put(p.getUniqueId(), System.currentTimeMillis());
		return true;
	}
}
