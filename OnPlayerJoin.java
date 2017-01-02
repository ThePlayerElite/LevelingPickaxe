package me.ThePlayerElite.LevelingPickaxe.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.ThePlayerElite.LevelingPickaxe.LevelingPickaxe;

public class OnPlayerJoin implements Listener
{
	
	LevelingPickaxe plugin;
	
	public OnPlayerJoin(LevelingPickaxe instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		PlayerInventory pi = p.getInventory();
		
		//Check to see if player already has a wooden pickaxe
		if (!pi.contains(Material.WOOD_PICKAXE))
		{
			p.sendMessage(ChatColor.AQUA + "Here's a pickaxe to get started!");
			ItemStack item = new ItemStack(Material.WOOD_PICKAXE);
			item.addEnchantment(Enchantment.DIG_SPEED, 1);
			pi.addItem(item);
		}
	}
}
