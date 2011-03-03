package com.bukkit.Magick.ARGAntiPirate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.bukkit.Location;

public class ChestReader {

	public static boolean isLocked(Location chestLocation, File file) {
		Properties pro = new Properties();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			if (pro.containsKey(chestLocation.toString())) {
				return true;
			}
		} catch (IOException e) {

		}
		return false;
	}

}