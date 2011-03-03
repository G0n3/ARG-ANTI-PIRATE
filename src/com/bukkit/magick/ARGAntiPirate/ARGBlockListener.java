package com.bukkit.magick.ARGAntiPirate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockInteractEvent;
import org.bukkit.event.block.BlockListener;

public class ARGBlockListener extends BlockListener {
	
	  public ARGBlockListener(AntiPirate plugin) {
	}
	

	// onBlockInteract Start
	public void onBlockInteract(BlockInteractEvent event) {
		// Get the block we are interacting with
		Block block = event.getBlock();
		// If the block is a CHEST
		if (block.getTypeId() == 54) {
			// Get the player and chest co-ords and log this access
			Player player = (Player) event.getEntity();
			int x = block.getX();
			int y = block.getY();
			int z = block.getZ();
			String s = "Chest access @ " + getDateTime() + "Location: X:" + x + " Y: " + y + " Z: " + z;
			chestLog.LogWrite(player, s, AntiPirate.ChestLog);
		}
	}

	// onBlockInteract End

	// onBlockBreak Start
	public void onBlockBreak(BlockDamageEvent event) {
		// Get the block we are interacting with
		Block damagedBlock = event.getBlock();
		// If it is not a chest, we dont care
		if (damagedBlock.getTypeId() == 54) {
			// Get the player and chest co-ords and log this access
			Player player = event.getPlayer();
			int x = damagedBlock.getX();
			int y = damagedBlock.getY();
			int z = damagedBlock.getZ();
			String s = "*Chest Destroy* @ " + getDateTime() + "Location: X:" + x + " Y: " + y + " Z: " + z;
			chestLog.LogWrite(player, s, AntiPirate.ChestLog);
		}
	}

	// onBlockBreak End

	// Function to return string for current date-time
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
