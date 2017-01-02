package me.ThePlayerElite.LevelingPickaxe.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.ThePlayerElite.LevelingPickaxe.LevelingPickaxe;

public class OnPlayerInteractEvent implements Listener
{
	LevelingPickaxe plugin;
	
	public OnPlayerInteractEvent(LevelingPickaxe instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		PlayerInventory pi = p.getInventory();
		
		for (ItemStack ac : pi.getContents())
		{
			if (ac == LevelingPickaxe.pickaxes(ac))
			{
				pi.getItemInMainHand().setDurability((short) + 1);
			}
		}
	}
}
