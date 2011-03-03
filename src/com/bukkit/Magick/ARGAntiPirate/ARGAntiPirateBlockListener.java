package com.bukkit.Magick.ARGAntiPirate;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockInteractEvent;
import org.bukkit.event.block.BlockListener;


/**
 * ARGAntiPirate block listener
 * @author Magick
 */
public class ARGAntiPirateBlockListener extends BlockListener {
    private final ARGAntiPirate plugin;
    public String stuff ="";

    public ARGAntiPirateBlockListener(final ARGAntiPirate plugin) {
        this.plugin = plugin;
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
		//	String s = "Chest access @ " + getDateTime() + "Location: X:" + x + " Y: " + y + " Z: " + z;
		//	chestLog.LogWrite(player, s, MagickMod.ChestLog);
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
	//		String s = "*Chest Destroy* @ " + getDateTime() + "Location: X:" + x + " Y: " + y + " Z: " + z;
	//		chestLog.LogWrite(player, s, MagickMod.ChestLog);
		}
	}
    
}
