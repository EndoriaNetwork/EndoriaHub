package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.utils.Cooldowns;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DoubleJumpEvent implements Listener
{
	@EventHandler public void doubleJump(PlayerToggleFlightEvent e)
	{
		Player p = e.getPlayer();
		if (p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR)
		{
			return;
		}
		if (EndoriaLobby.getInstance().canDoubleJump.contains(p))
		{
			e.setCancelled(true);
			p.setFlying(false);
			p.setAllowFlight(false);
			Location loc = p.getLocation();
			Vector v = loc.getDirection().multiply(1.5f).setY(1.5);
			p.setVelocity(v);
			loc.getWorld().playSound(loc, Sound.EXPLODE, 1, 0.2f);
			loc.setDirection(new Vector(1,2,1));
			loc.getWorld().playEffect(loc, Effect.SMOKE, 60);
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e)
	{
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR)
		{
			return;
		}

		if(p.isOnGround())
		{
			if(!p.getAllowFlight() && EndoriaLobby.getInstance().canDoubleJump.contains(p))
			{
				p.setAllowFlight(true);
			}
		}
	}
}
