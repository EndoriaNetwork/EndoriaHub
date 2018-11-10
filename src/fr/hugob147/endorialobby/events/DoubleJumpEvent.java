package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.EndoriaLobby;
import fr.hugob147.endorialobby.utils.Cooldowns;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.*;
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
			p.getLocation().getWorld().playSound(loc, Sound.WITHER_SHOOT, 1, 1f);
			p.getWorld().playEffect(p.getLocation().add(-1.0D, 0.0D, 0.0D).setDirection(new Vector(0.2,0.2,2)), Effect.SMOKE, 50);
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
		}else if(Cooldowns.byPass.contains(p.getUniqueId()))
		{
			if(!p.getAllowFlight() && EndoriaLobby.getInstance().canDoubleJump.contains(p))
			{
				p.setAllowFlight(true);
			}
		}
	}
}
