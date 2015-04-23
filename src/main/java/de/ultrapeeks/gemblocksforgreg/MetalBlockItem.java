package de.ultrapeeks.gemblocksforgreg;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MetalBlockItem extends ItemBlock{

	private BasicMetalBlock block;
	
	public MetalBlockItem(Block block, BasicMetalBlock metalBlock) {
		super(block);
		this.block = metalBlock;
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		MetalType type = MetalType.values()[block.getOffset() * 16 + itemStack.getItemDamage()];
		return "tile." + type.getName();
	}
}
