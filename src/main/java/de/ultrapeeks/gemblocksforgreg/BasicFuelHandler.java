package de.ultrapeeks.gemblocksforgreg;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.items.GT_MetaGenerated_Item;
import gregtech.api.objects.GT_ItemStack;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class BasicFuelHandler implements IFuelHandler {

	private ItemStack item;
	
	public BasicFuelHandler(ItemStack item) {
		this.item = item;
	}
	
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		if ((fuel == null) || (fuel.getItem() == null)) {
			return 0;
		}
		if (GT_Utility.areStacksEqual(fuel, item)) {
			return 300 * 9;
		}
		return 0;
	}

}
