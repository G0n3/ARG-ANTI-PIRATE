package com.bukkit.magick.ARGAntiPirate;

// this file loads plugin settings
public class LoadSettings {
	

	public static void loadMain() {
		String propertiesFile = AntiPirate.maindirectory + "ARGAntiPirate.conf";
		PluginProperties properties = new PluginProperties(propertiesFile);
		properties.load();
	

	
		properties.save("***ARGAntiPirate Config***");
		
	}
}
