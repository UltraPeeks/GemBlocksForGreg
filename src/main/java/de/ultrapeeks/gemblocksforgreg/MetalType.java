package de.ultrapeeks.gemblocksforgreg;

public enum MetalType {
	
	BERYLLIUM("Beryllium"),
	MAGNESIUM("Magnesium"),
	ALUMINIUM("Aluminium"),
	SILICON("Silicon"),
	SCANDIUM("Scandium"),
	TITANIUM("Titanium"),
	VANADIUM("Vanadium"),
	CHROME("Chrome"),
	MANGANESE("Manganese"),
	COBALT("Cobalt"),
	NICKEL("Nickel"),
	COPPER("Copper"),
	ZINC("Zinc"),
	GALLIUM("Gallium"),
	ARSENIC("Arsenic"),
	RUBIDIUM("Rubidium"),
	YTTRIUM("Yttrium"),
	NIOBIUM("Niobium"),
	MOLYBDENUM("Molybdenum"),
	PALLADIUM("Palladium"),
	SILVER("Silver"),
	INDIUM("Indium"),
	TIN("Tin"),
	ANTIMONY("Antimony"),
	TELLURIUM("Tellurium"),
	CAESIUM("Caesium"),
	LANTHANUM("Lanthanum"),
	CERIUM("Cerium"),
	PRASEODYMIUM("Praseodymium"),
	NEODYMIUM("Neodymium"),
	SAMARIUM("Samarium"),
	EUROPIUM("Europium"),
	GADOLINIUM("Gadolinium"),
	TERBIUM("Terbium"),
	DYSPROSIUM("Dysprosium"),
	HOLMIUM("Holmium"),
	ERBIUM("Erbium"),
	THULIUM("Thulium"),
	YTTERBIUM("Ytterbium"),
	LUTETIUM("Lutetium"),
	TANTALUM("Tantalum"),
	TUNGSTEN("Tungsten"),
	OSMIUM("Osmium"),
	IRIDIUM("Iridium"),
	PLATINUM("Platinum"),
	LEAD("Lead"),
	BISMUTH("Bismuth"),
	THORIUM("Thorium"),
	URANIUM235("Uranium235"),
	URANIUM("Uranium"),
	PLUTONIUM("Plutonium"),
	PLUTONIUM241("Plutonium241"),
	AMERICIUM("Americium"),
	NEUTRONIUM("Neutronium"),
	BRONZE("Bronze"),
	BRASS("Brass"),
	INVAR("Invar"),
	ELECTRUM("Electrum"),
	WROUGHT_IRON("WroughtIron"),
	STEEL("Steel"),
	STAINLESS_STEEL("StainlessSteel"),
	PIG_IRON("PigIron"),
	RED_ALLOY("RedAlloy"),
	BLUE_ALLOY("BlueAlloy"),
	CUPRONICKEL("Cupronickel"),
	NICHROME("Nichrome"),
	KANTHAL("Kanthal"),
	MAGNALIUM("Magnalium"),
	SOLDERING_ALLOY("SolderingAlloy"),
	BATTERY_ALLOY("BatteryAlloy"),
	TUNGSTEN_STEEL("TungstenSteel"),
	OSMIRIDIUM("Osmiridium"),
	SUNNARIUM("Sunnarium"),
	ADAMANTIUM("Adamantium"),
	FLUXED_ELECTRUM("ElectrumFlux"),
	ENDERIUM("Enderium"),
	HSLA_STEEL("HSLA"),
	INFUSED_GOLD("InfusedGold"),
	NAQUADAH("Naquadah"),
	NAQUADAH_ALLOY("NaquadahAlloy"),
	ENRICHED_NAQUADAH("NaquadahEnriched"),
	NAQUADRIA("Naquadria"),
	DURANIUM("Duranium"),
	TRITANIUM("Tritanium"),
	THAUMIUM("Thaumium"),
	MITHRIL("Mithril"),
	MIDASIUM("Midasium"),
	ASTRAL_SILVER("AstralSilver"),
	BLACK_STEEL("BlackSteel"),
	DAMASCUS_STEEL("DamascusSteel"),
	SHADOW_IRON("ShadowIron"),
	SHADOW_STEEL("ShadowSteel"),
	IRON_WOOD("IronWood"),
	METEORIC_IRON("MeteoricIron"),
	METEORIC_STEEL("MeteoricSteel"),
	DARK_IRON("DarkIron"),
	COBALT_BRASS("CobaltBrass"),
	ULTIMET("Ultimet"),
	ANNEALED_COPPER("AnnealedCopper"),
	FIERY_STEEL("FierySteel"),
	RED_STEEL("RedSteel"),
	BLUE_STEEL("BlueSteel"),
	STERLING_SILVER("SterlingSilver"),
	ROSE_GOLD("RoseGold"),
	BLACK_BRONZE("BlackBronze"),
	BISMUTH_BRONZE("BismuthBronze"),
	MAGNETIC_IRON("IronMagnetic"),
	MAGNETIC_STEEL("SteelMagnetic"),
	MAGNETIC_NEODYMIUM("NeodymiumMagnetic"),
	VANADIUM_GALLIUM("VanadiumGallium"),
	YTTRIUM_BARIUM_CUPRATE("YttriumBariumCuprate"),
	NIOBIUM_NITRIDE("NiobiumNitride"),
	NIOBIUM_TITANIUM("NiobiumTitanium"),
	CHROMIUM_DIOXIDE("ChromiumDioxide"),
	KNIGHTMETAL("Knightmetal"),
	TIN_ALLOY("TinAlloy"),
	DEEP_IRON("DeepIron"),
	DESH("Desh"),
	CERTUS_QUARTZ("CertusQuartz", "gem"),
	CHARGED_CERTUS_QUARTZ("ChargedCertusQuartz", "gem"),
	MONAZITE("Monazite", "gem"),
	QUARZITE("Quartzite", "gem"),
	LAZURITE("Lazurite", "gem"),
	SODALITE("Sodalite", "gem"),
	NITER("Niter", "gem"),
	PHOSPHORUS("Phosphorus", "gem"),
	LIGNITE("Lignite", "gem");
	
	private String prefix;
	private String name;
	private String ingotOreName;
	private String[] oreNames;
	
	private MetalType(String material) {
		this(material, "ingot");
	}
	
	private MetalType(String material, String prefix) {
		this.prefix = prefix;
		this.name = material.substring(0, 1).toLowerCase() + material.substring(1) + "Block";
		this.ingotOreName = prefix + material;
		this.oreNames = new String[]{"block" + material, "blockMetal" + material};
	}
	
	public String getName() {
		return name;
	}
	
	public String[] getOreNames() {
		return oreNames;
	}
	
	public String getIngotOreName() {
		return ingotOreName;
	}
	
	public String getPrefix() {
		return prefix;
	}
}