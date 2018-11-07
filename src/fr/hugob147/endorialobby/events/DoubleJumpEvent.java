package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.rank.Rank;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;


import java.util.ArrayList;

public class DoubleJumpEvent implements Listener {

    public ArrayList<Player> jump = new ArrayList<Player>();

    @EventHandler
    public void doubleJump(PlayerToggleFlightEvent e){
        Player p = e.getPlayer();
        Location loc = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());

        if(new Rank().getRank(p).getPower() <= 80){
            if(!jump.contains(p)){
                if(p.getGameMode() != GameMode.CREATIVE){
                    if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR){
                        e.setCancelled(true);
                        p.setFlying(false);
                        p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
                        jump.add(p);
                        p.getLocation().getWorld().playEffect(loc, Effect.BLAZE_SHOOT, 2);

                    }

                }
            }
        }

    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        Material dessous = p.getLocation().subtract(0, 1 , 0).getBlock().getType();
        if(p.getGameMode() != GameMode.CREATIVE && (dessous != Material.AIR) && (!p.isFlying())){
            jump.remove(p);
            p.setAllowFlight(false);
        }else{
            p.setAllowFlight(true);
        }
    }


}
