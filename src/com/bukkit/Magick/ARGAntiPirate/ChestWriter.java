package com.bukkit.Magick.ARGAntiPirate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// this code is the beginning of the read/write for a chest protection system
public class ChestWriter {
	

	public static void LogWrite(String LogText, File file) {

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(LogText);
			bw.newLine();
			bw.close();
		} catch (IOException e) {

		}
	}

}