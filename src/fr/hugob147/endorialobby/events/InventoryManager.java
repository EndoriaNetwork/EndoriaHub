package fr.hugob147.endorialobby.events;

import fr.hugob147.endorialobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class InventoryManager
  implements Listener
{
  private Player player;
  
  public InventoryManager(Player player)
  {
    this.player = player;
  }
  
  public void endoriamenu()
  {
    Inventory inv = Bukkit.createInventory(null, 45, "§5Endoria Menu");
    
    ItemBuilder DIAMOND_PICKAXE = new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§bOp-Prison").setLore(new String[] { "§7Clic gauche pour rejoindre" });
    inv.setItem(23, DIAMOND_PICKAXE.toItemStack());
    
    ItemBuilder Tnt = new ItemBuilder(Material.TNT).setName("§cFaction").setLore(new String[] { "§7Clic gauche pour rejoindre" });
    inv.setItem(21, Tnt.toItemStack());
    
    ItemBuilder Taupe = new ItemBuilder(Material.GOLDEN_APPLE).setName("§cTaupe Gun").setLore(new String[] { "§7Click gauche pour rejoindre" });
    inv.setItem(13, Taupe.toItemStack());
    
    ItemBuilder UhcRun = new ItemBuilder(Material.APPLE).setName("§6Uhc-Run").setLore(new String[] { "§7Click gauche pour rejoindre" });
    inv.setItem(29, UhcRun.toItemStack());
    
    ItemBuilder SkyWars = new ItemBuilder(Material.EYE_OF_ENDER).setName("§bSkyWars").setLore(new String[] { "§7Click gauche pour rejoindre" });
    inv.setItem(31, SkyWars.toItemStack());
    
    ItemBuilder BedWars = new ItemBuilder(Material.BED).setName("§6BedWars").setLore(new String[] { "§7Click gauche pour rejoindre" });
    inv.setItem(33, BedWars.toItemStack());
    
    ItemBuilder VitreV = new ItemBuilder(Material.STAINED_GLASS_PANE).setName("§5§lEndoria§f§lNetwork").setLore(new String[] { "" }).setWoolColor(DyeColor.PURPLE);
    ItemBuilder VitreB = new ItemBuilder(Material.STAINED_GLASS_PANE).setName("§5§lEndoria§f§lNetwork").setLore(new String[] { "" }).setWoolColor(DyeColor.WHITE);
    
    inv.setItem(0, VitreV.toItemStack());
    inv.setItem(1, VitreB.toItemStack());
    inv.setItem(2, VitreV.toItemStack());
    inv.setItem(3, VitreB.toItemStack());
    inv.setItem(4, VitreV.toItemStack());
    inv.setItem(5, VitreB.toItemStack());
    inv.setItem(6, VitreV.toItemStack());
    inv.setItem(7, VitreB.toItemStack());
    inv.setItem(8, VitreV.toItemStack());
    
    this.player.openInventory(inv);
  }
}
