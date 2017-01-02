package me.ThePlayerElite.LevelingPickaxe.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.ThePlayerElite.LevelingPickaxe.LevelingPickaxe;

public class OnItemDrop implements Listener
{
	LevelingPickaxe plugin;
	
	public OnItemDrop(LevelingPickaxe instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e)
	{
		Player p = e.getPlayer();
		PlayerInventory pi = p.getInventory();
		for (ItemStack ac : pi.getContents())
		{
			// If the player is holding pickaxes, then do not let the player drop the pickaxes.
			if (ac == LevelingPickaxe.pickaxes(ac))
			{
				e.setCancelled(true);
			}
			else
			{
				e.setCancelled(false);
			}
		}
	}
}
