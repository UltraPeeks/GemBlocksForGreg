package de.ultrapeeks.gemblocksforgreg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasicMetalBlock extends Block{
	
	private static final String TEXTURE_PREFIX = "gemblocksforgreg:";
	
	private final int offset;
	
	private IIcon[] iconBuffer;
	
	
	@Override
	public int damageDropped(int damage) {
		return damage;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		int enumLength = MetalType.values().length;
		for (int i = 0; i < 16 && i + this.offset * 16 < enumLength; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icons) {
		int enumLength = MetalType.values().length;
		int offset = this.offset * 16;
		this.iconBuffer = new IIcon[Math.min(enumLength - offset, 16)];
		IIcon defaultIcon = icons.registerIcon(TEXTURE_PREFIX + "defaultBlock"); 
		
		for(int i = 0; i < this.iconBuffer.length; i++) {
			MetalType type = MetalType.values()[i + offset];
			
			this.iconBuffer[i] = icons.registerIcon(TEXTURE_PREFIX + type.getPrefix() + "/" + type.getName());
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (meta >= this.iconBuffer.length) {
			System.out.println("Warning: unknown meta data " + meta + " for block " + getUnlocalizedName() + ". Prevented Overflow.");
			return this.iconBuffer[0];
		}
		return this.iconBuffer[meta];
	}
	
	public int getOffset() {
		return offset;
	}

	protected BasicMetalBlock(int offset) {
		super(Material.iron);
		this.offset = offset;
		
		setBlockName("metalBlock" + offset);
		setHardness(3.0f);
		setStepSound(Block.soundTypeMetal);
		setCreativeTab(GemBlocksForGregMod.tabCustom);
		setHarvestLevel("pickaxe", 2);
	}

}
