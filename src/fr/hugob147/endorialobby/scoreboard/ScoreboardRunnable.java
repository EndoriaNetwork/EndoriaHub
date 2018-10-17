package fr.hugob147.endorialobby.scoreboard;

import fr.hugob147.endorialobby.EndoriaLobby;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardRunnable
  extends BukkitRunnable
{
  private EndoriaLobby main = EndoriaLobby.getInstance();
  
  public void run()
  {
    for (ScoreboardManager sb : this.main.scoreboard.values()) {
      sb.refresh();
    }
  }
}
