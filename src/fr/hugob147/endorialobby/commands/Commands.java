package fr.hugob147.endorialobby.commands;

import fr.hugob147.endorialobby.rank.Rank;
import fr.hugob147.endorialobby.rank.RankUnit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (label.equalsIgnoreCase("rank"))
		{
			if (sender instanceof Player)
			{
				Player player = (Player) sender;
				if (new Rank().getRank(player).getPower() > RankUnit.Dev.getPower())
				{
					player.sendMessage("§cVous n'avez pas la permission d'éxecuter cette commande !");
					return false;
				}
			}
			if(args.length < 1)
			{
				sender.sendMessage("§cUtilisation : /rank <set/get/list>");
				return false;
			}else
			{
				if(args[0].equalsIgnoreCase("set"))
				{
					if(args.length == 3)
					{
						if(Bukkit.getPlayer(args[1]) != null)
						{
							Player target = Bukkit.getPlayer(args[1]);

							if(RankUnit.getFromName(args[2]) != null)
							{
								RankUnit rank = RankUnit.getFromName(args[2]);

								if (new Rank().getRank(target) == rank)
								{
									sender.sendMessage(ChatColor.YELLOW + "Ce joueur possède déjà ce grade !");
									return false;
								}else
								{
									new Rank().setRank(target, rank);
									sender.sendMessage("§aLe joueur " + target.getName() + " est désormais " + rank.getName());
									return true;
								}
							}else
							{
								sender.sendMessage(ChatColor.RED + "Ce grade n'existe pas !");
								sender.sendMessage(ChatColor.AQUA + "Liste des grades : ");
								for (RankUnit ranks : RankUnit.values())
								{
									sender.sendMessage("- " + ranks.getName());
								}
								return false;
							}
						}else
						{
							sender.sendMessage(ChatColor.RED + "Ce joueur n'est pas connecté !");
							return false;
						}
					}else
					{
						sender.sendMessage("§cUtilisation : /rank set <joueur> <grade>");
						return false;
					}
				}else if(args[0].equalsIgnoreCase("get"))
				{
					if(args.length == 2)
					{
						if(RankUnit.getFromName(args[1]) != null)
						{
							int nb = 0;
							RankUnit rank = RankUnit.getFromName(args[1]);
							sender.sendMessage("§bListe des joueurs dans §e" + rank.getName() + "§b.");
							for(Player p : Bukkit.getOnlinePlayers())
							{
								if(new Rank().getRank(p) == rank)
								{
									sender.sendMessage("- " + p.getPlayerListName());
									nb++;
								}
							}
							sender.sendMessage("§eIl y a §b" + nb + "§e §c" + rank.getName() + "§e !");
							return true;
						}else if(Bukkit.getPlayer(args[1]) != null)
						{
							Player target = Bukkit.getPlayer(args[1]);
							sender.sendMessage(target.getPlayerListName() + " §eest " + new Rank().getRank(target).getName());
						}else
						{
							sender.sendMessage("§cCe joueur ou ce garde n'existe pas.");
							return false;
						}
					}else
					{
						sender.sendMessage("§cUtilisation : /rank get <joueur/grade>");
						return false;
					}
				}else if(args[0].equalsIgnoreCase("list"))
				{
					sender.sendMessage(ChatColor.AQUA + "Liste des grades : ");
					for (RankUnit ranks : RankUnit.values())
					{
						sender.sendMessage("- " + ranks.getName());
					}
					return true;
				}else
				{
					sender.sendMessage("§cUtilisation : /rank <set/get/list>");
					return false;
				}
			}
		}
		return false;
	}
}
