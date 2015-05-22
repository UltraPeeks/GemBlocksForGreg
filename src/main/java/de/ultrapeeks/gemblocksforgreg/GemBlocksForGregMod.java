package de.ultrapeeks.gemblocksforgreg;

import java.util.HashSet;
import java.util.Set;

import codechicken.nei.api.API;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.ultrapeeks.gemblocksforgreg.BasicGemBlock.GemType;

@Mod(modid = GemBlocksForGregMod.MODID, name = GemBlocksForGregMod.NAME, version = GemBlocksForGregMod.VERSION, 
		dependencies = "required-after:gregtech; required-after:NotEnoughItems; after:Thaumcraft")
public class GemBlocksForGregMod {
    public static final String MODID = "GemBlocksForGreg";
    public static final String NAME = "GemBlocksForGreg";
    public static final String VERSION = "1.5.0";
    
    private ConfigHandler config;
    
    @Instance(value = MODID)
    public static GemBlocksForGregMod instance;
    
    public static CreativeTabs tabCustom = new CreativeTabs(MODID) {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(GameRegistry.findBlock(MODID, "rubyBlock"));
        }
    };
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    	config = new ConfigHandler();
    	config.init(event.getSuggestedConfigurationFile());
    	
    	Set<String> blackList = new HashSet<String>();
    	for (String mat: config.getBlockBlackList()) {
    		blackList.add(mat.toLowerCase() + "block"); // the name always ends with "Block"
    	}

    	// Register old gems
    	for (GemType type: GemType.values()) {
    		Block block = new BasicGemBlock(type);
        	GameRegistry.registerBlock(block, type.getName());
        	if (!blackList.contains(type.getName().toLowerCase())) {
	        	for(String oreName: type.getOreNames()) {
	        		OreDictionary.registerOre(oreName, block);
	        	}
	        	GameRegistry.addRecipe(new ShapedOreRecipe(
	        			new ItemStack(block), "xxx", "xxx", "xxx", Character.valueOf('x'), type.getGemOreName()));
        	} else if (config.isHideBlacklistedBlocks()) {
        		API.hideItem(new ItemStack(block));
        	}
    	}

    	// Register all materials
    	Block block = null;
    	for (int i = 0; i < MetalType.values().length; i++) {
    		MetalType type = MetalType.values()[i];
    		if (i % 16 == 0) {
    			block = new BasicMetalBlock(i / 16);
    			GameRegistry.registerBlock(block, MetalBlockItem.class, block.getUnlocalizedName(), block);
    		}
    		
    		ItemStack stack = new ItemStack(block, 1, i % 16);
    		
    		if (!blackList.contains(type.getName().toLowerCase())) {
				for(String oreName: type.getOreNames()) {
	        		OreDictionary.registerOre(oreName, stack.copy());
	        	}
	    		GameRegistry.addRecipe(new ShapedOreRecipe(
	        			stack.copy(), "xxx", "xxx", "xxx", Character.valueOf('x'), type.getIngotOreName()));
	    		
	    		if (type == MetalType.LIGNITE) {
	    			GameRegistry.registerFuelHandler(new BasicFuelHandler(stack.copy(), 300 * 9));
	    		}
	    		
	    	} else if (config.isHideBlacklistedBlocks()) {
	    		API.hideItem(stack);
	    	}
    		
    	}
   	
    	
    	if (config.isEnableChangedUrnaniumByProducts()) {
        	Materials.Uraninite.mOreByProducts.set(2, Materials.Uranium235);
        	Materials.Uranium.mOreByProducts.set(1, Materials.Uranium235);
    	}
    }
    
    
    @EventHandler
    public void postInit(FMLInitializationEvent event) {
    	
    	if (config.isOredictIronwood()) {
	    	for(ItemStack item: OreDictionary.getOres("ironwood")) {
	    		OreDictionary.registerOre("ingotIronWood", item);
	    	}
    	}
    	
    	if (config.isOredictThaumcraftThaumiumBlock()) {
    	// Thaumcraft:blockCosmeticSolid:4
	    	Block thaumBlock = GameRegistry.findBlock("Thaumcraft", "blockCosmeticSolid");
	    	if (thaumBlock != null) {
		    	ItemStack thaumiumBlock = new ItemStack(thaumBlock, 1, 4);
		    	OreDictionary.registerOre("blockThaumium", thaumiumBlock);
	    	}
    	}
    }
}
