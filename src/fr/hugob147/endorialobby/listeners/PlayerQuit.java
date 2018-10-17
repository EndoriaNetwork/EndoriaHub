package fr.hugob147.endorialobby.listeners;

import fr.hugob147.endorialobby.EndoriaLobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit
  implements Listener
{
  private EndoriaLobby main = EndoriaLobby.getInstance();
  
  @EventHandler
  public void onLeave(PlayerQuitEvent e)
  {
    Player player = e.getPlayer();
    e.setQuitMessage("§7[§c-§7] " + player.getName());
    this.main.scoreboard.remove(player.getUniqueId());
  }
}
