package fr.hugob147.endorialobby.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        InventoryManager invs = new InventoryManager(p);

        if(p.getGameMode() == GameMode.CREATIVE){
            e.setCancelled(false);
        }else

        e.setCancelled(true);

        switch (e.getCurrentItem().getType()){

            case NETHER_STAR:
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Endoria Menu")){
                    invs.endoriamenu();
                }
                break;

                default:break;
        }

    }

}
