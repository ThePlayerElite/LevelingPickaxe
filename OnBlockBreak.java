package me.ThePlayerElite.LevelingPickaxe.Events;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ThePlayerElite.LevelingPickaxe.LevelingPickaxe;

public class OnBlockBreak implements Listener
{
	LevelingPickaxe plugin;
	
	public OnBlockBreak(LevelingPickaxe instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e)
	{
		Player p = e.getPlayer();
		PlayerInventory pi = p.getInventory();
		Block b = (Block) e.getBlock();
		//Random r = new Random();
		int stoneLevel = plugin.getConfig().getInt("Levels.Stone Pickaxe");
		int ironLevel = plugin.getConfig().getInt("Levels.Iron Pickaxe");
		int diamondLevel = plugin.getConfig().getInt("Levels.Diamond Pickaxe");
		//double chance = plugin.getConfig().getDouble("Ores.Extra Drop Percentage")/100;
		//int amountExtra = plugin.getConfig().getInt("Ores.Amount of Extra Ores to Drop");
		int efficiency5Level = plugin.getConfig().getInt("Levels.Diamond Pickaxe.Efficiency 5");
		int efficiency6Level = plugin.getConfig().getInt("Levels.Diamond Pickaxe.Efficiency 6");
		int efficiency7Level = plugin.getConfig().getInt("Levels.Diamond Pickaxe.Efficiency 7");
		int efficiency8Level = plugin.getConfig().getInt("Levels.Diamond Pickaxe.Efficiency 8");
		int miningFatigueLevel = plugin.getConfig().getInt("Levels.Diamond Pickaxe.Mining Fatigue 1");
		ItemStack inHand = pi.getItemInMainHand();
		List<String> woodList = plugin.getConfig().getStringList("Pickaxes.Ores.Wood Pickaxe");
		List<String> stoneList = plugin.getConfig().getStringList("Pickaxes.Ores.Stone Pickaxe");
		List<String> ironList = plugin.getConfig().getStringList("Pickaxes.Ores.Iron Pickaxe");
		List<String> diamondList = plugin.getConfig().getStringList("Pickaxes.Ores.Diamond Pickaxe");
		
		// If the player mines an ore block, add 1 level to their pickaxe level.
		if (b.getType().toString().contains("ORE"))
		{
			// do some code
		}
		
		// If the player is holding a pickaxe and reaches the certain level to rank up, switch that pickaxe to the next tier.
		if (inHand == LevelingPickaxe.pickaxes(inHand))
		{
			if (stoneLevel == LevelingPickaxe.level)
			{
				pi.remove(Material.WOOD_PICKAXE);
				ItemStack item = new ItemStack(Material.STONE_PICKAXE);
				item.addEnchantment(Enchantment.DIG_SPEED, 2);
				pi.addItem(item);
			}
			else if (ironLevel == LevelingPickaxe.level)
			{
				pi.remove(Material.STONE_PICKAXE);
				ItemStack item = new ItemStack(Material.IRON_PICKAXE);
				item.addEnchantment(Enchantment.DIG_SPEED, 3);
				pi.addItem(item);
			}
			
			else if (diamondLevel == LevelingPickaxe.level)
			{
				pi.remove(Material.IRON_PICKAXE);
				ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
				item.addEnchantment(Enchantment.DIG_SPEED, 4);
				pi.addItem(item);
			}
			else if (pi.getItemInMainHand().getType() == Material.DIAMOND_PICKAXE && LevelingPickaxe.level == efficiency5Level)
			{
				pi.remove(Material.DIAMOND_PICKAXE);
				ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
				item.addEnchantment(Enchantment.DIG_SPEED, 5);
				pi.addItem(item);
			}
			else if (pi.getItemInMainHand().getType() == Material.DIAMOND_PICKAXE && LevelingPickaxe.level == efficiency6Level)
			{
				pi.remove(Material.DIAMOND_PICKAXE);
				ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
				item.addEnchantment(Enchantment.DIG_SPEED, 6);
				pi.addItem(item);
			}
			else if (pi.getItemInMainHand().getType() == Material.DIAMOND_PICKAXE && LevelingPickaxe.level == efficiency7Level)
			{
				pi.remove(Material.DIAMOND_PICKAXE);
				ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
				item.addEnchantment(Enchantment.DIG_SPEED, 7);
				pi.addItem(item);
			}
			else if (pi.getItemInMainHand().getType() == Material.DIAMOND_PICKAXE && LevelingPickaxe.level == efficiency8Level)
			{
				pi.remove(Material.DIAMOND_PICKAXE);
				ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
				item.addEnchantment(Enchantment.DIG_SPEED, 8);
				pi.addItem(item);
			}
			else if (LevelingPickaxe.level == miningFatigueLevel)
			{
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 0));
			}
		}
		
		if (!LevelingPickaxe.listOfOres.contains(woodList))
		{
			e.setCancelled(true);
			p.sendMessage("Your pickaxe cannot mine this type of ore!");
		}
		else if (!LevelingPickaxe.listOfOres.contains(stoneList))
		{
			e.setCancelled(true);
			p.sendMessage("Your pickaxe cannot mine this type of ore!");
		}
		else if (!LevelingPickaxe.listOfOres.contains(ironList))
		{
			e.setCancelled(true);
			p.sendMessage("Your pickaxe cannot mine this type of ore!");
		}
		else if (!LevelingPickaxe.listOfOres.contains(diamondList))
		{
			e.setCancelled(true);
			p.sendMessage("Your pickaxe cannot mine this type of ore!");
		}
		else
		{
			LevelingPickaxe.level += 1;
			e.setCancelled(false);
		}
	}
}
