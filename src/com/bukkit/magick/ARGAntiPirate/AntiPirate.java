package com.bukkit.magick.ARGAntiPirate;

import java.io.File;
import java.io.IOException;
import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiPirate extends JavaPlugin {
	static String						maindirectory	= "ARGAntiPirate/";
	static File							ChestLog		= new File(maindirectory + "Chest.Log");
	private final ARGBlockListener	blockListener	= new ARGBlockListener(this);

	public AntiPirate(PluginLoader pluginLoader, Server instance, PluginDescriptionFile desc, File folder, File plugin, ClassLoader cLoader) {
		super(pluginLoader, instance, desc, folder, plugin, cLoader);
	}
	
	
	
	/*public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
  //      String commandName = command.getName().toLowerCase();
     
       /* if (commandName.equals("store")) {
            return this.playerlistener.storeCommand(sender);
        }else if (commandName.equals("buy")){
        	return this.playerlistener.buyCommand(sender, args);     	
        }
        return false;
    }
*/
	

	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled!");

	}

	// When the plugin is enabled this method is called.

	public void onEnable() {
		// this if-then-else structure checks to make sure the files that are
		// needed exist and all that crap
		if (!ChestLog.exists()) {
			try {
				new File(maindirectory).mkdir();
				ChestLog.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();

			}
		} else {
			LoadSettings.loadMain();
			PluginManager pm = getServer().getPluginManager();
		//Registering Events
			pm.registerEvent(Event.Type.BLOCK_INTERACT, this.blockListener, Priority.Normal, this);
			pm.registerEvent(Event.Type.BLOCK_DAMAGED, this.blockListener, Priority.Normal, this);
			pm.registerEvent(Event.Type.BLOCK_PLACED, this.blockListener, Priority.Normal, this);
		//this does some shit with that *.yml file i think -- its needed
			PluginDescriptionFile pdfFile = this.getDescription();
			System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
		}
	}
}
