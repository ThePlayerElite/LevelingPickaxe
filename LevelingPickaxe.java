package me.ThePlayerElite.LevelingPickaxe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.ThePlayerElite.LevelingPickaxe.Commands.LP;
import me.ThePlayerElite.LevelingPickaxe.Events.OnBlockBreak;
import me.ThePlayerElite.LevelingPickaxe.Events.OnItemDrop;
import me.ThePlayerElite.LevelingPickaxe.Events.OnPlayerHolding;
import me.ThePlayerElite.LevelingPickaxe.Events.OnPlayerInteractEvent;
import me.ThePlayerElite.LevelingPickaxe.Events.OnPlayerJoin;

public class LevelingPickaxe extends JavaPlugin
{
	private static final Logger log = Logger.getLogger("Minecraft");
	public static int level;
	LevelingPickaxe plugin;
	FileConfiguration config = this.getConfig();
	FileConfigurationOptions configOptions = config.options();
	public static List<String> listOfOres = Arrays.asList("Coal", "Iron", "Lapis", "Gold", "Diamond", "Redstone", "Emerald", "Nether Quartz");
	
	public void onEnable() 
	{
		registerEvents();
		registerCommands();
		loadConfig();
		log.info("[LevelingPickaxe] has been enabled!");
	}
	
	public void registerEvents()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new OnPlayerJoin(this), this);
		pm.registerEvents(new OnBlockBreak(this), this);
		pm.registerEvents(new OnPlayerInteractEvent(this), this);
		pm.registerEvents(new OnItemDrop(this), this);
		pm.registerEvents(new OnPlayerHolding(this), this);
	}
	
	public void registerCommands()
	{
		getCommand("lp").setExecutor(new LP(this));
	}
	
	public void loadConfig()
	{
		addDefaults();
		saveConfig();
	}
	
	public void addDefaults()
	{
		List<String> woodList = Arrays.asList("Coal");
		List<String> stoneList = Arrays.asList("Coal", "Iron");
		List<String> ironList = Arrays.asList("Coal", "Iron", "Lapis", "Gold", "Redstone");
		List<String> diamondList = Arrays.asList("Coal", "Iron", "Lapis", "Gold", "Redstone", "Emerald", "Diamond", "Nether Quartz");
		configOptions.header("Config file for LevelingPickaxe");
		config.addDefault("Ores.Extra Drop Percentage", 25.0);
		config.addDefault("Ores.Amount of Extra Ores to Drop", 2);
		config.addDefault("Levels.Stone Pickaxe", 5);
		config.addDefault("Levels.Iron Pickaxe", 10);
		config.addDefault("Levels.Diamond Pickaxe", 20);
		config.addDefault("Levels.Diamond Pickaxe.Efficiency 5", 30);
		config.addDefault("Levels.Diamond Pickaxe.Efficiency 6", 40);
		config.addDefault("Levels.Diamond Pickaxe.Efficiency 7", 50);
		config.addDefault("Levels.Diamond Pickaxe.Efficiency 8", 60);
		config.addDefault("Levels.Mining Fatigue 1", 65);
		config.addDefault("Pickaxes.Ores.Wood Pickaxe", woodList);
		config.addDefault("Pickaxes.Ores.Stone Pickaxe", stoneList);
		config.addDefault("Pickaxes.Ores.Iron Pickaxe", ironList);
		config.addDefault("Pickaxes.Ores.Diamond Pickaxe", diamondList);
		//config.addDefault("Messages.", "");
		//config.addDefault("Scoreboard.Display Name", "LevelingPickaxe");
		config.options().copyDefaults(true);
		configOptions.copyHeader(true);
	}
	
	public static ItemStack pickaxes(ItemStack is)
	{
		ArrayList<Material> items = new ArrayList<Material>();
		items.add(Material.WOOD_PICKAXE);
		items.add(Material.STONE_PICKAXE);
		items.add(Material.IRON_PICKAXE);
		items.add(Material.GOLD_PICKAXE);
		items.add(Material.DIAMOND_PICKAXE);
		return is;
	}
}
