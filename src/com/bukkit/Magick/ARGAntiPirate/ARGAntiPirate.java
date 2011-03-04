package com.bukkit.Magick.ARGAntiPirate;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * ARGAntiPirate for Bukkit
 * 
 * @author Magick
 */
public class ARGAntiPirate extends JavaPlugin {
	// private final ARGAntiPiratePlayerListener playerListener = new ARGAntiPiratePlayerListener(this);
	private final ARGAntiPirateBlockListener	blockListener	= new ARGAntiPirateBlockListener(this);
	private final BlockPlaceListener	blockPlaceListener	= new BlockPlaceListener(this);
	private final HashMap<Player, Boolean>		debugees		= new HashMap<Player, Boolean>();
	static String								maindirectory	= "argantipirate/";
	static File									ChestLogger		= new File(maindirectory + "Chest.log");
	static File									ChestData		= new File(maindirectory + "Chest.dat");
	public Properties LockedChests = new Properties();
	
	

	public void onEnable() {
		// initialization code here
		// NOTE: Event registration should be done in onEnable not here
		// all events are unregistered when a plugin is disabled

		// check to see if the ChestLogger file exists, if not, create it.
		if (!ChestLogger.exists()) {
			try {
				new File(maindirectory).mkdir();
				ChestLogger.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// check to see if the Chest Data file exists, if not, create it.
		if (!ChestData.exists()) {
			try {
				new File(maindirectory).mkdir();
				ChestData.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// load chest data file
		try {
			FileInputStream in = new FileInputStream(ChestData);
			LockedChests.load(in);
		}
		catch (IOException e) {

		}
		
		// Register our events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_PLACED,this.blockPlaceListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_INTERACT, this.blockListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_DAMAGED, this.blockListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACED, this.blockListener, Priority.Normal, this);
		// other crap
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
	}

	public void onDisable() {
		// custom disable code here
		// All registered events are automatically unregistered when a plugin is
		// disabled
		System.out.println("ARGAntiPirate Disabeled.");
	}

	public boolean isDebugging(final Player player) {
		if (debugees.containsKey(player)) {
			return debugees.get(player);
		} else {
			return false;
		}
	}

	public void setDebugging(final Player player, final boolean value) {
		debugees.put(player, value);
	}
}
