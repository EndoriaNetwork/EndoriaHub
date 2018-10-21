package fr.hugob147.endorialobby.scoreboard;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.rank.RankUnit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.Random;

public class ScoreboardManager implements org.bukkit.scoreboard.ScoreboardManager {

	private EndoriaLobby main = EndoriaLobby.getInstance();
	private Scoreboard sb;
	private Objective right;
	private String name = "right";
	private Player player;

	public ScoreboardManager(Player player) {
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		this.player = player;
	}

	public void refresh(){
		Objective obj;
		try{
			obj = sb.getObjective(name);
			obj.setDisplaySlot(null);
			obj.unregister();
		}catch(Exception e){}

		name = "right" + new Random().nextInt(10000000);
		obj = sb.registerNewObjective(name, "dummy");
		obj = sb.getObjective(name);
		right = obj;

		right.setDisplayName("§5§lEndoria§f§lNetwork");
		right.setDisplaySlot(DisplaySlot.SIDEBAR);
		right.getScore("§1").setScore(10);
		right.getScore("§6Serveur : §bLobby").setScore(9);
		right.getScore("§1§2").setScore(8);
		right.getScore("§6Pseudo : §e" + player.getName()).setScore(7);
		right.getScore("§1§2§3").setScore(6);
		right.getScore("§6Argent : §d" + main.coins.getCoins(player) + " ✪").setScore(5);
		right.getScore("§1§2§3§4").setScore(4);
		right.getScore("§6Rank: " + main.rank.getRank(player).getPrefix()).setScore(3);
		right.getScore("§l§2§3§4§5").setScore(2);
		right.getScore("§emc.endorianetwork.eu").setScore(1);
	}

	@SuppressWarnings("deprecation")
	public void init(){
		refresh();
		player.setScoreboard(sb);
		main.scoreboard.put(player.getUniqueId(), this);

		for(RankUnit rank : RankUnit.values()){
			if(sb.getTeam(""+rank.getPower()) == null){
				Team team = sb.registerNewTeam(""+rank.getPower());
				team.setPrefix(rank.getPrefix());
				team.setNameTagVisibility(NameTagVisibility.ALWAYS);
			}
		}

		for(ScoreboardManager sbList : main.scoreboard.values()){
			for(Player all : Bukkit.getOnlinePlayers()){
				Team team = sbList.sb.getTeam(""+main.rank.getRank(all).getPower());
				team.addPlayer(all);
			}
		}
	}

	public Objective getRight(){
		return right;
	}

	@Override
	public Scoreboard getMainScoreboard() {
		return sb;
	}

	@Override
	public Scoreboard getNewScoreboard() {
		return Bukkit.getScoreboardManager().getNewScoreboard();
	}

}