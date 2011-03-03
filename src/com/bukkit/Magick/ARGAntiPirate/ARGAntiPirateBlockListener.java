package com.bukkit.Magick.ARGAntiPirate;

import org.bukkit.block.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.*;
import org.bukkit.inventory.Inventory;

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
    
   
    
}
