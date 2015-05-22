package de.ultrapeeks.gemblocksforgreg;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	private static final String KEY_ENABLE_CHANGED_URANIUM_BYPRODUCTS = "enableChangedUrnaniumByProducts";
	private static final boolean DEFAULT_ENABLE_CHANGED_URANIUM_BYPRODUCTS = false;
	
	private static final String KEY_BLOCK_BLACKLIST = "blockBlacklist";
	private static final String[] DEFAULT_BLOCK_BLACKLIST = {"thaumium", "copper", "tin", "bronze", "lead"};
	
	private static final String KEY_HIDE_BLACKLISTED_BLOCKS = "hideBlacklistedBlocks";
	private static final boolean DEFAULT_HIDE_BLACKLISTED_BLOCK = true;
	
	private static final String KEY_OREDICT_THAUMCRAFT_THAUMIUM_BLOCK = "oredictThaumcraftThaumiumBlock";
	private static final boolean DEFAULT_OREDICT_THAUMCRAFT_THAUMIUM_BLOCK = true;
	
	private static final String KEY_OREDICT_IRONWOOD = "oredictIronwood";
	private static final boolean DEFAULT_OREDICT_IRONWOOD = true;
	
	private boolean enableChangedUrnaniumByProducts;

	private String[] blockBlackList;
	
	private boolean hideBlacklistedBlocks;
	
	private boolean oredictThaumcraftThaumiumBlock;
	
	private boolean oredictIronwood;
	
	
	public void init(File configFile) {
		Configuration config = new Configuration(configFile);
    	config.load();
    	
    	enableChangedUrnaniumByProducts = config.get(Category.FEATURES.getKey(), 
    			KEY_ENABLE_CHANGED_URANIUM_BYPRODUCTS, 
    			DEFAULT_ENABLE_CHANGED_URANIUM_BYPRODUCTS, 
    			"Replaces Plutonium 244 with Uranium 235 in the byproduct list of Uranium and Uraninite.")
    			.getBoolean();
    	
    	blockBlackList = config.get(Category.FEATURES.getKey(),
    			KEY_BLOCK_BLACKLIST,
    			DEFAULT_BLOCK_BLACKLIST,
    			"Materials in this list don't get their blocks oredicted and get no recipes. They can be hidden in NEI (see below) but they still exist.\n"
    			+ "Names without spaces. Case is ignored. E.g.: thaumium, blueTopaz, REDGaRnEt")
    			.getStringList();
    	
    	hideBlacklistedBlocks = config.get(Category.FEATURES.getKey(),
    			KEY_HIDE_BLACKLISTED_BLOCKS,
    			DEFAULT_HIDE_BLACKLISTED_BLOCK,
    			"Hides blacklisted blocks in NEI.")
    			.getBoolean();
    	
    	oredictThaumcraftThaumiumBlock = config.get(Category.FEATURES.getKey(),
    			KEY_OREDICT_THAUMCRAFT_THAUMIUM_BLOCK,
    			DEFAULT_OREDICT_THAUMCRAFT_THAUMIUM_BLOCK,
    			"Oredicts Thaumcraft's Thaumium Block as 'blockThaumium' so GregTech can add its recipes. Thaumium Block is just crafted from ingots if set to false.")
    			.getBoolean();
    	
    	oredictIronwood = config.get(Category.FEATURES.getKey(),
    			KEY_OREDICT_IRONWOOD,
    			DEFAULT_OREDICT_IRONWOOD,
    			"Oredicts Ironwood items as 'ingotIronwood' so GregTech can add its recipes. Ironwood Block is not craftable if set to false.")
    			.getBoolean();
    	
    	
    	config.save();
	}
	
	
	
	public boolean isEnableChangedUrnaniumByProducts() {
		return enableChangedUrnaniumByProducts;
	}


	public String[] getBlockBlackList() {
		return blockBlackList;
	}


	public boolean isHideBlacklistedBlocks() {
		return hideBlacklistedBlocks;
	}


	public boolean isOredictThaumcraftThaumiumBlock() {
		return oredictThaumcraftThaumiumBlock;
	}

	public boolean isOredictIronwood() {
		return oredictIronwood;
	}
	
	
	private enum Category {
		FEATURES("features"); 
		
		
		private String key;
		
		private Category(String key) {
			this.key = key;
		}
		
		public String getKey() {
			return key;
		}
	}
	

}
