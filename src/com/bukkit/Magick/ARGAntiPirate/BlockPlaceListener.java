package com.bukkit.Magick.ARGAntiPirate;

import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener extends BlockListener {
	
	private final ARGAntiPirate	plugin;

	public BlockPlaceListener(final ARGAntiPirate plugin) {
		this.plugin = plugin;
	}
	
	
	public void onBlockPlace(BlockPlaceEvent event) {

		Block placedBlock = event.getBlock();
		// If the block is a CHEST
		if (placedBlock.getTypeId() == 54) {

			plugin.LockedChests.setProperty(placedBlock.getLocation().toString(), event.getPlayer().getName());
			try {
				plugin.LockedChests.store(new FileOutputStream(ARGAntiPirate.ChestData), null);

			} catch (IOException e) {

			}

		}

	}

}
