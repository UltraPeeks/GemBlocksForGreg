package de.ultrapeeks.gemblocksforgreg;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicGemBlock extends Block {
	
	public enum GemType {
		
		RUBY("rubyBlock", "gemRuby", "blockRuby", "blockGemRuby"),
		SAPPHIRE("sapphireBlock", "gemSapphire", "blockSapphire", "blockGemSapphire"),
		GREEN_SAPPHIRE("greenSapphireBlock", "gemGreenSapphire", "blockGreenSapphire", "blockGemGreenSapphire"),
		OLIVINE("olivineBlock", "gemOlivine", "blockOlivine", "blockGemOlivine"),
		TOPAZ("topazBlock", "gemTopaz", "blockTopaz", "blockGemTopaz"),
		TANZANITE("tanzaniteBlock", "gemTanzanite", "blockTanzanite", "blockGemTanzanite"),
		AMETHYST("amethystBlock", "gemAmethyst", "blockAmethyst", "blockGemAmethyst"),
		OPAL("opalBlock", "gemOpal", "blockOpal", "blockGemOpal"),
		JASPER("jasperBlock", "gemJasper", "blockJasper", "blockGemJasper"),
		BLUE_TOPAZ("blueTopazBlock", "gemBlueTopaz", "blockBlueTopaz", "blockGemBlueTopaz"),
		FOOLS_RUBY("foolsRubyBlock", "gemFoolsRuby", "blockFoolsRuby", "blockGemFoolsRuby"),
		AMBER("amberBlock", "gemAmber", "blockAmber", "blockGemAmber"),
		DILITHIUM("dilithiumBlock", "gemDilithium", "blockDilithium", "blockGemDilithium"),
		FORCICIUM("forciciumBlock", "gemForcicium", "blockForcicium", "blockGemForcicium"),
		FORCILLIUM("forcilliumBlock", "gemForcillium", "blockForcillium", "blockGemForcillium"),
		FORCE("forceBlock", "gemForce", "blockForce", "blockGemForce"),
		RED_GARNET("redGarnetBlock", "gemGarnetRed", "blockGarnetRed", "blockGemGarnetRed"),
		YELLOW_GARNET("yellowGarnetBlock", "gemGarnetYellow", "blockGarnetYellow", "blockGemGarnetYellow"),
		VINTEUM("vinteumBlock", "gemVinteum", "blockVinteum", "blockGemVinteum"),
		ENDERPEARL("enderPearlBlock", "gemEnderPearl", "blockEnderPearl", "blockGemEnderPearl"),
		ENDEREYE("enderEyeBlock", "gemEnderEye", "blockEnderEye", "blockGemEnderEye"),
		AER("aerCrystalBlock", "gemInfusedAir", "blockInfusedAir", "blockGemInfusedAir"),
		IGNIS("ignisCrystalBlock", "gemInfusedFire", "blockInfusedFire", "blockGemInfusedFire"),
		TERRA("terraCrystalBlock", "gemInfusedEarth", "blockInfusedEarth", "blockGemInfusedEarth"),
		AQUA("aquaCrystalBlock", "gemInfusedWater", "blockInfusedWater", "blockGemInfusedWater"),
		PERDITIO("perditioCrystalBlock", "gemInfusedEntropy", "blockInfusedEntropy", "blockGemInfusedEntropy"),
		ORDO("ordoCrystalBlock", "gemInfusedOrder", "blockInfusedOrder", "blockGemInfusedOrder");

		private String name;
		private String gemOreName;
		private String[] oreNames;
		
		private GemType(String name, String gemOreName, String... oreNames) {
			this.name = name;
			this.gemOreName = gemOreName;
			this.oreNames = oreNames;
		}
		
		public String getName() {
			return name;
		}
		
		public String[] getOreNames() {
			return oreNames;
		}
		
		public String getGemOreName() {
			return gemOreName;
		}
	}
	
	private static final String TEXTURE_PREFIX = "gemblocksforgreg:gem/";
	
	private GemType type;

	protected BasicGemBlock(GemType type) {
		super(Material.iron);
		this.type = type;
		setBlockName(type.getName());
		setHardness(3.0f);
		setStepSound(Block.soundTypeMetal);
		setCreativeTab(GemBlocksForGregMod.tabCustom);
		setHarvestLevel("pickaxe", 2);
		setBlockTextureName(TEXTURE_PREFIX + type.getName());
	}
}
