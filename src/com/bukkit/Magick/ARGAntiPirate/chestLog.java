package com.bukkit.Magick.ARGAntiPirate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.bukkit.entity.Player;

// this code is the beginning of the read/write for a chest protection system
public class chestLog {
	public static boolean containskey(Player p, File file) {
		Properties pro = new Properties();
		String player = p.getName();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			if (pro.containsKey(player)) {
				return true;
			}
		} catch (IOException e) {

		}
		return false;
	}

	public static void LogWrite(String LogText, File file) {

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(LogText);
			bw.newLine();
			bw.close();

			// FileOutputStream in = new FileOutputStream(file);

			// in.write(Logtext.getBytes());

			// in.flush();
			// in.close();
			// pro.load(in);
			// pro.setProperty(player, coords);
			// pro.store(new FileOutputStream(file), null);
		} catch (IOException e) {

		}
	}

}