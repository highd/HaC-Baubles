package com.highd120.hacbaubels;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HacBaubles.MODID, version = HacBaubles.VERSION, dependencies = "required-after:dcs_lib")
public class HacBaubles {
	public static final String MODID = "hacbaubels";
	public static final String VERSION = "1.0";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}
}
