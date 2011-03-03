package com.bukkit.Magick.ARGAntiPirate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockInteractEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * ARGAntiPirate block listener
 * 
 * @author Magick
 */
public class ARGAntiPirateBlockListener extends BlockListener {

	private final ARGAntiPirate	plugin;

	public ARGAntiPirateBlockListener(final ARGAntiPirate plugin) {
		this.plugin = plugin;
	}

	

	// onBlockInteract Start
	public void onBlockInteract(BlockInteractEvent event) {
		// Get the block we are interacting with
		Block block = event.getBlock();
		// If the block is a CHEST
		if (block.getTypeId() == 54) {
			// Get the player and chest coords and log this access
			Player player = (Player) event.getEntity();
			int x = block.getX();
			int y = block.getY();
			int z = block.getZ();
			String LogText = player.getName() + "Chest access @ " + getDateTime() + "Location: X:" + x + " Y: " + y + " Z: " + z;
			ChestWriter.LogWrite(LogText, ARGAntiPirate.ChestLogger);

		}
	}

	// onBlockInteract End

	// onBlockBreak Start
	public void onBlockBreak(BlockDamageEvent event) {
		// Get the block we are interacting with
		Block damagedBlock = event.getBlock();
		// If it is not a chest, we don't care
		if (damagedBlock.getTypeId() == 54) {
			// Get the player and chest co-ords and log this access

			Player player = event.getPlayer();
			int x = damagedBlock.getX();
			int y = damagedBlock.getY();
			int z = damagedBlock.getZ();
			String LogText = player.getName() + "*Chest Destroy* @ " + getDateTime() + "Location: X:" + x + " Y: " + y + " Z: " + z;
			ChestWriter.LogWrite(LogText, ARGAntiPirate.ChestLogger);

		}
	}

	// Function to return string for current date-time
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
