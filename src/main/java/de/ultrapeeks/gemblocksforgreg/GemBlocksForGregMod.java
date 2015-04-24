package de.ultrapeeks.gemblocksforgreg;

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
		dependencies = "required-after:gregtech")
public class GemBlocksForGregMod {
    public static final String MODID = "GemBlocksForGreg";
    public static final String NAME = "GemBlocksForGreg";
    public static final String VERSION = "1.4a";
    
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
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	
    	boolean change = config.get("features", "enableChangedUrnaniumByProducts", false, 
    			"If set to true: Replaces Plutonium 244 with Uranium 235 in the byproduct list of Uranium and Uraninite.").getBoolean(false);
    	
    	config.save();
    	
    	for (GemType type: GemType.values()) {
    		Block block = new BasicGemBlock(type);
        	GameRegistry.registerBlock(block, type.getName());
        	for(String oreName: type.getOreNames()) {
        		OreDictionary.registerOre(oreName, block);
        	}
        	GameRegistry.addRecipe(new ShapedOreRecipe(
        			new ItemStack(block), "xxx", "xxx", "xxx", Character.valueOf('x'), type.getGemOreName()));
    	}
    	
    	Block block = null;
    	for (int i = 0; i < MetalType.values().length; i++) {
    		MetalType type = MetalType.values()[i];
    		if (i % 16 == 0) {
    			block = new BasicMetalBlock(i / 16);
    			GameRegistry.registerBlock(block, MetalBlockItem.class, block.getUnlocalizedName(), block);
    		}
    		
    		ItemStack stack = new ItemStack(block, 1, i % 16);
    		for(String oreName: type.getOreNames()) {
        		OreDictionary.registerOre(oreName, stack.copy());
        	}

    		GameRegistry.addRecipe(new ShapedOreRecipe(
        			stack.copy(), "xxx", "xxx", "xxx", Character.valueOf('x'), type.getIngotOreName()));
    		
    		if (type == MetalType.LIGNITE) {
    			GameRegistry.registerFuelHandler(new BasicFuelHandler(stack.copy()));
    		}
    		
    	}
    	
    	
    	
    	if (change) {
	    	Materials.Uraninite.mOreByProducts.set(2, Materials.Uranium235);
	    	Materials.Uranium.mOreByProducts.set(1, Materials.Uranium235);
    	}
    }
    
    @EventHandler
    public void postInit(FMLInitializationEvent event) {
    	for(ItemStack item: OreDictionary.getOres("ironwood")) {
    		OreDictionary.registerOre("ingotIronWood", item);
    	}
    }
}
