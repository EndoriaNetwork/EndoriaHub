package fr.hugob147.endorialobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SocialsCmd implements CommandExecutor
{
	@Override public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(args.length >=1)
		{
			sender.sendMessage("§cUtilisation : /" + label);
		}else
		{
			if(label.equalsIgnoreCase("ts") || label.equalsIgnoreCase("teamspeak"))
			{
				sender.sendMessage("");
				sender.sendMessage("§e§l[Socials] §bL'ip du serveur teamspeak d'§5§lEndoria§f§lNetwork est : §cmc.endorianetwork.eu");
				sender.sendMessage("");
			}
			if(label.equalsIgnoreCase("discord"))
			{
				sender.sendMessage("");
				sender.sendMessage("§e§l[Socials] §bL'URL d'invitation au discord d'§5§lEndoria§f§lNetwork est : §chttps://discord.gg/cGVPmrv");
				sender.sendMessage("");
			}
			if(label.equalsIgnoreCase("web") || label.equalsIgnoreCase("site"))
			{
				sender.sendMessage("");
				sender.sendMessage("§e§l[Socials] §bL'URL du site d'§5§lEndoria§f§lNetwork §best : §chttp://endorianetwork.eu/");
				sender.sendMessage("");
			}
			if(label.equalsIgnoreCase("socials"))
			{
				sender.sendMessage("");
				sender.sendMessage("§e§l[Socials] §bL'ip du serveur teamspeak d'§5§lEndoria§f§lNetwork est : §cmc.endorianetwork.eu");
				sender.sendMessage("§e§l[Socials] §bL'URL d'invitation au discord d'§5§lEndoria§f§lNetwork est : §chttps://discord.gg/cGVPmrv");
				sender.sendMessage("§e§l[Socials] §bL'URL du site d'§5§lEndoria§f§lNetwork §best : §chttp://endorianetwork.eu/");
				sender.sendMessage("");
			}
		}
		return false;
	}
}
