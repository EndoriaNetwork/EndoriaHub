package fr.hugob147.endorialobby.commands;

import fr.hugob147.endorialobby.utils.Cooldowns;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ByPassCmd implements CommandExecutor
{
	@Override public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player p = (Player) sender;
			if(args.length == 0)
			{
				if(Cooldowns.byPass.contains(p.getUniqueId()))
				{
					Cooldowns.byPass.remove(p.getUniqueId());
					p.sendMessage("§cVous êtes de nouveau affecté par le temps de récupération !");
				}else
				{
					Cooldowns.byPass.add(p.getUniqueId());
					p.sendMessage("§aVous n'êtes plus affecté par le temps de récupération !");
				}
				return true;
			}else if(args.length == 1)
			{
				if(Bukkit.getPlayer(args[0]) != null)
				{
					Player v = Bukkit.getPlayer(args[0]);
					if(Cooldowns.byPass.contains(v.getUniqueId()))
					{
						Cooldowns.byPass.remove(v.getUniqueId());
						v.sendMessage("§cVous êtes de nouveau affecté par le temps de récupération !");
						p.sendMessage("§c" + v.getDisplayName() + " est de nouveau affecté par le temps de récupération !");
					}else
					{
						Cooldowns.byPass.add(v.getUniqueId());
						v.sendMessage("§aVous n'êtes plus affecté par le temps de récupération !");
						p.sendMessage("§a" + v.getDisplayName() + " n'est plus affecté par le temps de récupération !");
					}
					return true;
				}else
				{
					p.sendMessage("§cLe joueur n'est pas connecté !");
					return false;
				}
			}else
			{
				p.sendMessage("§cUtilisation : /bypass [joueur]");
				return false;
			}
		}else
		{
			sender.sendMessage("§cVous devez être un joueur !");
			return false;
		}
	}
}
