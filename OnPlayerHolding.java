package me.ThePlayerElite.LevelingPickaxe.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.ThePlayerElite.LevelingPickaxe.LevelingPickaxe;

public class OnPlayerHolding implements Listener
{
	LevelingPickaxe plugin;
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard board = manager.getNewScoreboard();
	Objective objective = board.registerNewObjective("test", "dummy");
	Score score = objective.getScore(ChatColor.AQUA + "Pickaxe Level:");
	
	public OnPlayerHolding(LevelingPickaxe instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerHolding(PlayerItemHeldEvent e)
	{
		Player p = e.getPlayer();
		PlayerInventory pi = p.getInventory();
		ItemStack inHand = pi.getItemInMainHand();
		
		if (inHand == LevelingPickaxe.pickaxes(inHand)) // Scoreboard does not work yet
		{
			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName("LevelingPickaxe");
			score.setScore(LevelingPickaxe.level);
		}
	}
}
