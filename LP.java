package me.ThePlayerElite.LevelingPickaxe.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.ThePlayerElite.LevelingPickaxe.LevelingPickaxe;

public class LP implements CommandExecutor
{

	public static double version = 1.0;
	LevelingPickaxe plugin;
	
	public LP(LevelingPickaxe instance)
	{
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            PlayerInventory pi = p.getInventory();
            
            if (args.length == 0)
            {
            	if (cmd.getName().equalsIgnoreCase("lp")) 
            	{
					p.sendMessage(ChatColor.AQUA + "You are currently running version " + version + " of LevelingPickaxe");
                }
            }
            
            if (args.length > 0 && args[0].equalsIgnoreCase("level")) 
            {
                p.sendMessage(ChatColor.AQUA + "Your current pickaxe level is: " + ChatColor.YELLOW + LevelingPickaxe.level);
            }
            
            if (args.length > 0 && args[0].equalsIgnoreCase("levelup"))
            {
            	if (args[1].equalsIgnoreCase("stone"))
            	{
            		pi.removeItem(new ItemStack(Material.WOOD_PICKAXE));
                	pi.addItem(new ItemStack(Material.STONE_PICKAXE));
            	}
            	
            	else if (args[1].equalsIgnoreCase("iron"))
            	{
            		pi.removeItem(new ItemStack(Material.STONE_PICKAXE));
            		pi.addItem(new ItemStack(Material.IRON_PICKAXE));
            	}
            	
            	else if (args[1].equalsIgnoreCase("gold"))
            	{
            		pi.removeItem(new ItemStack(Material.IRON_PICKAXE));
            		pi.addItem(new ItemStack(Material.GOLD_PICKAXE));
            	}
            	
            	else if (args[1].equalsIgnoreCase("diamond"))
            	{
            		pi.removeItem(new ItemStack(Material.GOLD_PICKAXE));
            		pi.addItem(new ItemStack(Material.DIAMOND_PICKAXE));
            	}
            }
            
            if (args.length > 0 && args[0].equalsIgnoreCase("reload")) 
            {
            	plugin.reloadConfig();
            	p.sendMessage(ChatColor.AQUA + "[LevelingPickaxe] Configuration reloaded.");
            }
        }
        return false;
    }
	
}
