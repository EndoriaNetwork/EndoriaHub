package fr.hugob147.endorialobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class CommandsTabCompleter implements TabCompleter
{
	@Override public List<String> onTabComplete(CommandSender commandSender, Command command, String s,
			String[] strings)
	{
		return null;
	}
}