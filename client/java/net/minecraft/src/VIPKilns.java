package net.minecraft.src;


import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;


import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class VIPKilns extends FCAddOn{
	
	public static VIPKilns instance;
	public static final String kilnVersion = "0.3";


	public static Block pkBlockBrickYellow;
	public static Block pkBlockBrickYellowSlab;
	public static Block pkBlockBrickYellowLoose;
	public static Block pkBlockBrickYellowLooseSlab;
	public static Block pkBlockBrickYellowSidingAndCorner;
	public static Block pkBlockBrickYellowMouldingAndDecorative;

	public static Block pkBlockBrickDry;
	public static Block pkBlockBrickStack;
	public static Block pkBlockBrickStackDry;
	public static Block pkBlockBrickStackCooked;

	public static Block pkBlockKiln;
	public static Block pkBlockKilnLit;
	public static Block pkBlockDropsCharcoal;

	public static Block pkBlockTandoori;
	public static Block pkBlockTandooriCooked;

	public static Block pkBlockDonner;
	public static Block pkBlockDonnerCooked;


	public static Block pkBlockBreech;

	public static Block pkBlockUnfiredBrickGold;
	public static Block pkBlockUnfiredBrickIron;
	public static Block pkBlockUnfiredBrickDiamond;

	public static Block pkBlockCookedBrickGold;
	public static Block pkBlockCookedBrickIron;
	public static Block pkBlockCookedBrickDiamond;

	public static Block pkBlockUnfiredBrickStackGold;
	public static Block pkBlockUnfiredBrickStackIron;
	public static Block pkBlockUnfiredBrickStackDiamond;

	public static Block pkBlockCookedBrickStackGold;
	public static Block pkBlockCookedBrickStackIron;
	public static Block pkBlockCookedBrickStackDiamond;


	public static Block pkBlockBrickGold;
	public static Block pkBlockBrickIron;
	public static Block pkBlockBrickDiamond;
	public static Block pkBlockBrickGoldLoose;
	public static Block pkBlockBrickIronLoose;
	public static Block pkBlockBrickDiamondLoose;

	public static Block pkBlockAdobeBrickYellow;
	public static Block pkBlockAdobeBrickIron;
	public static Block pkBlockAdobeBrickGold;
	public static Block pkBlockAdobeBrickDiamond;
	public static Block pkBlockAdobeBrickYellowCooked;
	public static Block pkBlockAdobeBrickIronCooked;
	public static Block pkBlockAdobeBrickGoldCooked;
	public static Block pkBlockAdobeBrickDiamondCooked;

	public static Block pkBlockAdobeBrick;
	public static Block pkBlockAdobeBrickCooked;


	public static Item pkItemBrickDry;
	public static Item pkItemBlockBrickYellowSidingAndCorner;
	public static Item pkItemBlockBrickYellowMouldingAndDecorative;

	public static Item pkItemTandooriChicken;
	public static Item pkItemTandooriBeef;
	public static Item pkItemTandooriMutton;
	public static Item pkItemTandooriPorkchop;
	public static Item pkItemTandooriFish;
	public static Item pkItemTandooriLiver;

	public static Item pkItemPotteryShards;

	public static Item pkItemDonner;
	public static Item pkItemDonnerSandwich;

	public static Item pkItemUnfiredBrickGold;
	public static Item pkItemUnfiredBrickIron;
	public static Item pkItemUnfiredBrickDiamond;
	public static Item pkItemBrickGold;
	public static Item pkItemBrickIron;
	public static Item pkItemBrickDiamond;



	private Map<String, String> confprop;

	public
	VIPKilns(){
		super("Primitive Kilning", kilnVersion , "KLN");
		instance = this;
	}
	void
	registerProperty(String st, int in){
		registerProperty(st, Integer.toString(in));
	}
	public void
	PreInitialize(){
		registerProperty("pkBlockBrickYellow.blockID", 1700);
		registerProperty("pkBlockBrickYellowSlab.blockID", 1701);
		registerProperty("pkBlockBrickYellowLoose.blockID", 1702);
		registerProperty("pkBlockBrickYellowLooseSlab.blockID", 1703);
		registerProperty("pkBlockBrickYellowSidingAndCorner.blockID", 1704);
		registerProperty("pkBlockBrickYellowMouldingAndDecorative.blockID", 1705);
		registerProperty("pkBlockBrickDry.blockID", 1706);
		registerProperty("pkBlockBrickStack.blockID", 1707);
		registerProperty("pkBlockBrickStackDry.blockID", 1708);
		registerProperty("pkBlockBrickStackCooked.blockID", 1709);
		registerProperty("pkBlockKiln.blockID", 1710);
		registerProperty("pkBlockKilnLit.blockID", 1711);
		registerProperty("pkBlockDropsCharcoal.blockID", 1712);
		registerProperty("pkBlockTandoori.blockID", 1713);
		registerProperty("pkBlockTandooriCooked.blockID", 1714);

		registerProperty("pkBlockDonner.blockID", 1715);
		registerProperty("pkBlockDonnerCooked.blockID", 1716);
		registerProperty("pkBlockBreech.blockID", 1717);

		registerProperty("pkBlockUnfiredBrickGold.blockID", 1718);
		registerProperty("pkBlockUnfiredBrickIron.blockID", 1719);
		registerProperty("pkBlockUnfiredBrickDiamond.blockID", 1720);

		registerProperty("pkBlockCookedBrickGold.blockID", 1721);
		registerProperty("pkBlockCookedBrickIron.blockID", 1722);
		registerProperty("pkBlockCookedBrickDiamond.blockID", 1723);


		registerProperty("pkBlockBrickGold.blockID", 1724);
		registerProperty("pkBlockBrickIron.blockID", 1725);
		registerProperty("pkBlockBrickDiamond.blockID", 1726);
		registerProperty("pkBlockBrickGoldLoose.blockID", 1727);
		registerProperty("pkBlockBrickIronLoose.blockID", 1728);
		registerProperty("pkBlockBrickDiamondLoose.blockID", 1729);
		registerProperty("pkBlockAdobeBrickYellow.blockID", 1730);
		registerProperty("pkBlockAdobeBrickIron.blockID", 1731);
		registerProperty("pkBlockAdobeBrickGold.blockID", 1732);
		registerProperty("pkBlockAdobeBrickDiamond.blockID", 1733);
		registerProperty("pkBlockAdobeBrickYellowCooked.blockID", 1734);
		registerProperty("pkBlockAdobeBrickIronCooked.blockID", 1735);
		registerProperty("pkBlockAdobeBrickGoldCooked.blockID", 1736);
		registerProperty("pkBlockAdobeBrickDiamondCooked.blockID", 1737);


		registerProperty("pkBlockAdobeBrick.blockID", 1738);
		registerProperty("pkBlockAdobeBrickCooked.blockID", 1739);

		registerProperty("pkBlockUnfiredBrickStackGold.blockID", 1740);
		registerProperty("pkBlockUnfiredBrickStackIron.blockID", 1741);
		registerProperty("pkBlockUnfiredBrickStackDiamond.blockID", 1742);

		registerProperty("pkBlockCookedBrickStackGold.blockID", 1743);
		registerProperty("pkBlockCookedBrickStackIron.blockID", 1744);
		registerProperty("pkBlockCookedBrickStackDiamond.blockID", 1745);


		registerProperty("pkItemBrickDry.itemID", 24000);
		registerProperty("pkItemBlockBrickYellowSidingAndCorner.itemID", 24001);
		registerProperty("pkItemBlockBrickYellowMouldingAndDecorative.itemID", 24002);


		registerProperty("pkItemTandooriChicken.itemID", 24003);
		registerProperty("pkItemTandooriBeef.itemID", 24004);
		registerProperty("pkItemTandooriMutton.itemID", 24005);
		registerProperty("pkItemTandooriPorkchop.itemID", 24006);
		registerProperty("pkItemTandooriFish.itemID", 24007);
		registerProperty("pkItemTandooriLiver.itemID", 24008);

		registerProperty("pkItemPotteryShards.itemID", 24009);

		registerProperty("pkItemDonner.itemID", 24010);
		registerProperty("pkItemDonnerSandwich.itemID", 24011);

		registerProperty("pkItemUnfiredBrickGold.itemID", 24017);
		registerProperty("pkItemUnfiredBrickIron.itemID", 24012);
		registerProperty("pkItemUnfiredBrickDiamond.itemID", 24013);
		registerProperty("pkItemBrickGold.itemID", 24014);
		registerProperty("pkItemBrickIron.itemID", 24015);
		registerProperty("pkItemBrickDiamond.itemID", 24016);


		registerProperty("EarlyCharcoalRecipe","true");
		registerProperty("EarlyCeramicRecipe", "true");	
		registerProperty("TandooriCooking", "true");
		registerProperty("UnRemoveKebab", "true");
		registerProperty("PrimitiveKilnEfficiency", "30");
		registerProperty("CustomDecorativeBlocksEnabled", "true");

	}
	public void
	Initialize(){
		FCAddOnHandler.LogMessage("Primitive Kilning v" + kilnVersion + " initializing");
		confprop = loadConfigProperties();
		this.SanitizeConfigMap();

		this.InitializeItems();
		this.InitializeBlocks();
		this.InitializeItemBlocks();



		this.InitializeTileEntities();
		this.InitializeIndBlocks();
		this.InitializeIndBlockItems();

		VIPKilnRecipes.addAllRecipes();

		if(confprop.get("EarlyCharcoalRecipe").toLowerCase().equals("true")){
			VIPKilnRecipes.addCharcoalRecipe();
		}
		if(confprop.get("TandooriCooking").toLowerCase().equals("true")){
			VIPKilnRecipes.addTandooriRecipes();
		}
		if(confprop.get("UnRemoveKebab").toLowerCase().equals("true")){
			VIPKilnRecipes.addKebabRecipes();
		}
		if(confprop.get("EarlyCeramicRecipe").toLowerCase().equals("true")){
			VIPKilnRecipes.addCeramicRecipes();
		}
		if(confprop.get("CustomDecorativeBlocksEnabled").toLowerCase().equals("true")){
			this.InitializeDeco();
			VIPKilnRecipes.addDecoRecipes();
		}
		FCAddOnHandler.LogMessage("Primitive Kilning initialization complete");
	}
	void
	normalizeProperty(String prop, int def){
		if(confprop.get(prop) == null){
			confprop.put(prop, Integer.toString(def));
		}
		try { 
			Integer.parseInt(confprop.get(prop));
		} catch (NumberFormatException e){
			confprop.put(prop, Integer.toString(def));
		}
	}
	int
	getIdFromProp(String prop){
		if(confprop == null)
			throw new InvalidConfigException("Config map is null after sanitization");
		if(confprop.get(prop) == null)
			throw new InvalidConfigException("Config property: " + prop +" is called but not defined");
		return Integer.parseInt(confprop.get(prop)); /*We would actually want this to crash if it throws NFE*/
	}
	void
	SanitizeConfigMap(){
		if(confprop == null){
			confprop = new HashMap<String, String>();
		}
		normalizeProperty("pkBlockBrickYellow.blockID", 1700);
		normalizeProperty("pkBlockBrickYellowSlab.blockID", 1701);
		normalizeProperty("pkBlockBrickYellowLoose.blockID", 1702);
		normalizeProperty("pkBlockBrickYellowLooseSlab.blockID", 1703);
		normalizeProperty("pkBlockBrickYellowSidingAndCorner.blockID", 1704);
		normalizeProperty("pkBlockBrickYellowMouldingAndDecorative.blockID", 1705);
		normalizeProperty("pkBlockBrickDry.blockID", 1706);
		normalizeProperty("pkBlockBrickStack.blockID", 1707);
		normalizeProperty("pkBlockBrickStackDry.blockID", 1708);
		normalizeProperty("pkBlockBrickStackCooked.blockID", 1709);
		normalizeProperty("pkBlockKiln.blockID", 1710);
		normalizeProperty("pkBlockKilnLit.blockID", 1711);
		normalizeProperty("pkBlockDropsCharcoal.blockID", 1712);
		normalizeProperty("pkBlockTandoori.blockID", 1713);
		normalizeProperty("pkBlockTandooriCooked.blockID", 1714);
		normalizeProperty("pkBlockDonner.blockID", 1715);
		normalizeProperty("pkBlockDonnerCooked.blockID", 1716);
		normalizeProperty("pkBlockBreech.blockID", 1717);
		normalizeProperty("pkBlockUnfiredBrickGold.blockID", 1718);
		normalizeProperty("pkBlockUnfiredBrickIron.blockID", 1719);
		normalizeProperty("pkBlockUnfiredBrickDiamond.blockID", 1720);

		normalizeProperty("pkBlockBrickGold.blockID", 1724);
		normalizeProperty("pkBlockBrickIron.blockID", 1725);
		normalizeProperty("pkBlockBrickDiamond.blockID", 1726);
		normalizeProperty("pkBlockBrickGoldLoose.blockID", 1727);
		normalizeProperty("pkBlockBrickIronLoose.blockID", 1728);
		normalizeProperty("pkBlockBrickDiamondLoose.blockID", 1729);
		normalizeProperty("pkBlockAdobeBrickYellow.blockID", 1730);
		normalizeProperty("pkBlockAdobeBrickIron.blockID", 1731);
		normalizeProperty("pkBlockAdobeBrickGold.blockID", 1732);
		normalizeProperty("pkBlockAdobeBrickDiamond.blockID", 1733);
		normalizeProperty("pkBlockAdobeBrickYellowCooked.blockID", 1734);
		normalizeProperty("pkBlockAdobeBrickIronCooked.blockID", 1735);
		normalizeProperty("pkBlockAdobeBrickGoldCooked.blockID", 1736);
		normalizeProperty("pkBlockAdobeBrickDiamondCooked.blockID", 1737);


		normalizeProperty("pkBlockAdobeBrick.blockID", 1738);
		normalizeProperty("pkBlockAdobeBrickCooked.blockID", 1739);

		normalizeProperty("pkBlockUnfiredBrickStackGold.blockID", 1740);
		normalizeProperty("pkBlockUnfiredBrickStackIron.blockID", 1741);
		normalizeProperty("pkBlockUnfiredBrickStackDiamond.blockID", 1742);

		normalizeProperty("pkBlockCookedBrickStackGold.blockID", 1743);
		normalizeProperty("pkBlockCookedBrickStackIron.blockID", 1744);
		normalizeProperty("pkBlockCookedBrickStackDiamond.blockID", 1745);

		normalizeProperty("pkItemBrickDry.itemID", 24000);
		normalizeProperty("pkItemBlockBrickYellowSidingAndCorner.itemID", 24001);
		normalizeProperty("pkItemBlockBrickYellowMouldingAndDecorative.itemID", 24002);

		normalizeProperty("pkItemTandooriMutton.itemID", 24003);
		normalizeProperty("pkItemTandooriBeef.itemID", 24004);
		normalizeProperty("pkItemTandooriChicken.itemID", 24005);
		normalizeProperty("pkItemTandooriPorkchop.itemID", 24006);
		normalizeProperty("pkItemTandooriFish.itemID", 24007);
		normalizeProperty("pkItemTandooriLiver.itemID", 24008);
		normalizeProperty("pkItemPotteryShards.itemID", 24009);
		normalizeProperty("pkItemDonner.itemID", 24010);
		normalizeProperty("pkItemDonnerSandwich.itemID", 24011);
		normalizeProperty("pkItemUnfiredBrickGold.itemID", 24017);
		normalizeProperty("pkItemUnfiredBrickIron.itemID", 24012);
		normalizeProperty("pkItemUnfiredBrickDiamond.itemID", 24013);
		normalizeProperty("pkItemBrickGold.itemID", 24014);
		normalizeProperty("pkItemBrickIron.itemID", 24015);
		normalizeProperty("pkItemBrickDiamond.itemID", 24016);
		normalizeProperty("PrimitiveKilnEfficiency", 30);
	}
	void 
	InitializeBlocks(){

		pkBlockBrickYellow = new VIPBlockBrick(getIdFromProp("pkBlockBrickYellow.blockID")).setHardness(0.7F).setResistance(3.5F).setUnlocalizedName("pkBlockBrickYellow");
		pkBlockBrickYellowSlab = new VIPBlockBrickSlab(getIdFromProp("pkBlockBrickYellowSlab.blockID"), getIdFromProp("pkBlockBrickYellow.blockID")).setHardness(0.7F).setResistance(3.5F).setUnlocalizedName("pkBlockBrickYellowSlab");
		pkBlockBrickYellowLoose = new VIPBlockBrickLoose(getIdFromProp("pkBlockBrickYellowLoose.blockID"), getIdFromProp("pkBlockBrickYellow.blockID")).setHardness(0.7F).setResistance(3.5F).setUnlocalizedName("pkBlockBrickYellowLoose");
		pkBlockBrickYellowLooseSlab = (new VIPBlockBrickLooseSlab(getIdFromProp("pkBlockBrickYellowLooseSlab.blockID"),getIdFromProp("pkBlockBrickYellowLoose.blockID"), getIdFromProp("pkBlockBrickYellowSlab.blockID"), "pkBlockBrickYellowLooseSlab")).setHardness(0.7F).setResistance(3.5F).setUnlocalizedName("pkBlockBrickYellowLooseSlab");

		((VIPBlockBrick)pkBlockBrickYellow).setdrop(getIdFromProp("pkBlockBrickYellowLoose.blockID"));
		((VIPBlockBrickSlab)pkBlockBrickYellowSlab).setdrop(getIdFromProp("pkBlockBrickYellowLooseSlab.blockID"));

		pkBlockBrickDry = new VIPBlockBrickDry(getIdFromProp("pkBlockBrickDry.blockID"), pkItemBrickDry.itemID).setHardness(0F).setResistance(0F).setUnlocalizedName("pkBlockBrickDry");


		pkBlockBrickStack = new VIPBlockBrickStackWithTileEntity(getIdFromProp("pkBlockBrickStack.blockID"), "fcBlockUnfiredBrick", FCBetterThanWolves.fcItemBrickUnfired.itemID).setUnlocalizedName("pkBlockBrickStack").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockBrickStackCooked = new VIPBlockBrickStack(getIdFromProp("pkBlockBrickStackCooked.blockID"), "fcBlockCookedBrick", Item.brick.itemID).setUnlocalizedName("fcBlockCookedBrick").setCreativeTab(CreativeTabs.tabBlock);

		pkBlockKiln = new VIPBlockKiln(getIdFromProp("pkBlockKiln.blockID"), "pkBlockBrickYellow", "pkBlockBrickYellow", false, getIdFromProp("PrimitiveKilnEfficiency"), 8000).setUnlocalizedName("pkBlockKiln").setCreativeTab(CreativeTabs.tabDecorations);
		pkBlockKilnLit = new VIPBlockKiln(getIdFromProp("pkBlockKilnLit.blockID"), "pkBlockBrickYellow", "pkBlockBrickYellow", true, getIdFromProp("PrimitiveKilnEfficiency"), 8000).setUnlocalizedName("pkBlockKilnLit");


		pkBlockBrickStackDry = new VIPBlockBrickStack(getIdFromProp("pkBlockBrickStackDry.blockID"), "pkBlockBrickDry", pkItemBrickDry.itemID).setUnlocalizedName("pkBlockBrickStackDry").setCreativeTab(CreativeTabs.tabBlock);

		((VIPBlockKiln)pkBlockKiln).setUnlitBid(getIdFromProp("pkBlockKiln.blockID"));
		((VIPBlockKiln)pkBlockKilnLit).setUnlitBid(getIdFromProp("pkBlockKiln.blockID"));
		((VIPBlockKiln)pkBlockKiln).setLitBid(getIdFromProp("pkBlockKilnLit.blockID"));
		((VIPBlockKiln)pkBlockKilnLit).setLitBid(getIdFromProp("pkBlockKilnLit.blockID"));

		pkBlockDropsCharcoal = new VIPBlockDropsCharcoal(getIdFromProp("pkBlockDropsCharcoal.blockID"), "pkBlockDropsCharcoal_top", "pkBlockDropsCharcoal_side").setUnlocalizedName("pkBlockDropsCharcoal");
		pkBlockTandoori = new VIPBlockTandoori(getIdFromProp("pkBlockTandoori.blockID"), "fcBlockUnfiredBrick", false,
			new int[]{
				FCBetterThanWolves.fcItemMuttonRaw.itemID,
				Item.beefRaw.itemID,
				Item.chickenRaw.itemID,
				Item.porkRaw.itemID,
				Item.fishRaw.itemID,
				FCBetterThanWolves.fcItemBeastLiverRaw.itemID,
				Item.rottenFlesh.itemID,
				Item.carrot.itemID,
				Item.potato.itemID,
				FCBetterThanWolves.fcItemRawMysteryMeat.itemID,
				FCBetterThanWolves.fcItemWolfRaw.itemID
			} 
		).setUnlocalizedName("pkBlockTandoori").setCreativeTab(CreativeTabs.tabDecorations);
		pkBlockTandooriCooked =	new VIPBlockTandoori(getIdFromProp("pkBlockTandooriCooked.blockID"), "fcBlockCookedBrick", true,
			new int[]{
				pkItemTandooriMutton.itemID,
				pkItemTandooriBeef.itemID,
				pkItemTandooriChicken.itemID,
				pkItemTandooriPorkchop.itemID,
				pkItemTandooriFish.itemID,
				pkItemTandooriLiver.itemID,
				FCBetterThanWolves.fcItemFoulFood.itemID,
				FCBetterThanWolves.fcItemCookedCarrot.itemID,
				Item.bakedPotato.itemID,
				FCBetterThanWolves.fcItemCookedMysteryMeat.itemID,
				FCBetterThanWolves.fcItemWolfCooked.itemID
			}  
		).setUnlocalizedName("pkBlockTandooriCooked").setCreativeTab(CreativeTabs.tabDecorations);

		pkBlockDonner = new VIPBlockKebab(getIdFromProp("pkBlockDonner.blockID"), 0).setUnlocalizedName("pkBlockDonner").setCreativeTab(CreativeTabs.tabDecorations);
		pkBlockDonnerCooked = new VIPBlockKebab(getIdFromProp("pkBlockDonnerCooked.blockID"), 1).setUnlocalizedName("pkBlockDonnerCooked").setCreativeTab(CreativeTabs.tabDecorations);
		pkBlockBreech = new VIPBlockBreech(getIdFromProp("pkBlockBreech.blockID")).setUnlocalizedName("pkBlockBreech").setCreativeTab(CreativeTabs.tabDecorations).setLightValue(0.3F);

	}
	void
	InitializeItems(){
		pkItemBrickDry = new VIPItemDryBrick(getIdFromProp("pkItemBrickDry.itemID"), getIdFromProp("pkBlockBrickDry.blockID"), 0, "pkItemBrickDry", 8, getIdFromProp("pkBlockBrickYellowLoose.blockID"));

		pkItemTandooriChicken = new FCItemFood(getIdFromProp("pkItemTandooriChicken.itemID"), FCItemFood.m_iChickenCookedHungerHealed, FCItemFood.m_fChickenSaturationModifier * 2F, true, "pkItemTandooriChicken");
		pkItemTandooriBeef = new FCItemFood(getIdFromProp("pkItemTandooriBeef.itemID"), FCItemFood.m_iBeefCookedHungerHealed, FCItemFood.m_fBeefSaturationModifier * 2F, true, "pkItemTandooriBeef");
		pkItemTandooriMutton = new FCItemFood(getIdFromProp("pkItemTandooriMutton.itemID"), FCItemFood.m_iMuttonCookedHungerHealed, FCItemFood.m_fMuttonSaturationModifier * 2F, true, "pkItemTandooriMutton");
		pkItemTandooriPorkchop = new FCItemFood(getIdFromProp("pkItemTandooriPorkchop.itemID"), FCItemFood.m_iPorkChopCookedHungerHealed, FCItemFood.m_fPorkChopSaturationModifier * 2F, true, "pkItemTandooriPorkchop");
		pkItemTandooriFish =new FCItemFood(getIdFromProp("pkItemTandooriFish.itemID"), FCItemFood.m_iFishCookedHungerHealed, FCItemFood.m_fFishSaturationModifier * 2F, true, "pkItemTandooriFish");
		pkItemTandooriLiver = new FCItemFood(getIdFromProp("pkItemTandooriLiver.itemID"), FCItemFood.m_iBeastLiverCookedHungerHealed, FCItemFood.m_fBeastLiverSaturationModifier * 2F, true, "pkItemTandooriLiver");
		pkItemPotteryShards = new Item(getIdFromProp("pkItemPotteryShards.itemID")).setUnlocalizedName("pkItemPotteryShards").setCreativeTab(CreativeTabs.tabMisc);
		pkItemDonner = new FCItemFood(getIdFromProp("pkItemDonner.itemID"), 3, 1F, true, "pkItemDonner",true).setCreativeTab(CreativeTabs.tabFood);;
		pkItemDonnerSandwich = new VIPItemFoodDamageable(getIdFromProp("pkItemDonnerSandwich.itemID"),2, .5F, true, "pkItemDonnerSandwich", true, 15 ).setCreativeTab(CreativeTabs.tabFood);

	}

	void
	InitializeTileEntities(){
		TileEntity.addMapping(VIPTileEntityUnfiredBrick.class, "Brick Stack");
		TileEntity.addMapping(VIPTileEntityKiln.class, "Kiln");

	}
	void
	InitializeItemBlocks(){


		new ItemBlock(getIdFromProp("pkBlockBrickYellow.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockBrickYellowSlab.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockBrickYellowLoose.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockBrickYellowLooseSlab.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockBrickDry.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockBrickStack.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockBrickStackCooked.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockKiln.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockKilnLit.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockBrickStackDry.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockDropsCharcoal.blockID") - 256 );
		new ItemBlock(getIdFromProp("pkBlockBreech.blockID") - 256);

		new VIPItemBlockTandoori(getIdFromProp("pkBlockTandoori.blockID") - 256);
		new VIPItemBlockTandoori(getIdFromProp("pkBlockTandooriCooked.blockID") - 256);
		new VIPItemBlockTandoori(getIdFromProp("pkBlockDonner.blockID") - 256);
		new VIPItemBlockTandoori(getIdFromProp("pkBlockDonnerCooked.blockID") - 256);
	}

	void
	InitializeIndBlocks(){
		pkBlockBrickYellowSidingAndCorner = (new FCBlockSidingAndCornerAndDecorative(getIdFromProp("pkBlockBrickYellowSidingAndCorner.blockID"), Material.rock, "pkBlockBrickYellow", 0.7F, 3.5F, Block.soundStoneFootstep, "pkBlockBrickYellowSidingAndCorner")).SetPicksEffectiveOn();
		pkBlockBrickYellowMouldingAndDecorative = (new FCBlockMouldingAndDecorative(getIdFromProp("pkBlockBrickYellowMouldingAndDecorative.blockID"), Material.rock, "pkBlockBrickYellow", "pkBlockBrickYellow", pkBlockBrickYellowSidingAndCorner.blockID, 0.7F, 3.5F, Block.soundStoneFootstep, "pkBlockBrickYellowMouldingAndDecorative")).SetPicksEffectiveOn();
	}

	void
	InitializeDeco(){



		pkItemUnfiredBrickGold = new FCItemPlacesAsBlock(getIdFromProp("pkItemUnfiredBrickGold.itemID"), getIdFromProp("pkBlockUnfiredBrickGold.blockID")).setUnlocalizedName("pkItemUnfiredBrickGold");
		pkItemUnfiredBrickIron = new FCItemPlacesAsBlock(getIdFromProp("pkItemUnfiredBrickIron.itemID"), getIdFromProp("pkBlockUnfiredBrickIron.blockID")).setUnlocalizedName("pkItemUnfiredBrickIron");
		pkItemUnfiredBrickDiamond = new FCItemPlacesAsBlock(getIdFromProp("pkItemUnfiredBrickDiamond.itemID"), getIdFromProp("pkBlockUnfiredBrickDiamond.blockID")).setUnlocalizedName("pkItemUnfiredBrickDiamond");

		pkItemBrickGold = new VIPItemDryBrick(getIdFromProp("pkItemBrickGold.itemID"), getIdFromProp("pkBlockCookedBrickGold.blockID"), 0, "pkItemBrickGold", 8, getIdFromProp("pkBlockBrickGold.blockID"));
		pkItemBrickIron = new VIPItemDryBrick(getIdFromProp("pkItemBrickIron.itemID"), getIdFromProp("pkBlockCookedBrickIron.blockID"), 0, "pkItemBrickIron", 8, getIdFromProp("pkBlockBrickIron.blockID"));
		pkItemBrickDiamond = new VIPItemDryBrick(getIdFromProp("pkItemBrickDiamond.itemID"), getIdFromProp("pkBlockCookedBrickDiamond.blockID"), 0, "pkItemBrickDiamond", 8, getIdFromProp("pkBlockBrickDiamond.blockID"));




		pkBlockUnfiredBrickGold = new VIPBlockBrickDry(getIdFromProp("pkBlockUnfiredBrickGold.blockID"), pkItemUnfiredBrickGold.itemID).setUnlocalizedName("pkBlockUnfiredBrickGold").setHardness(0F).setResistance(0F);
		pkBlockUnfiredBrickIron = new VIPBlockBrickDry(getIdFromProp("pkBlockUnfiredBrickIron.blockID"),  pkItemUnfiredBrickIron.itemID).setUnlocalizedName("pkBlockUnfiredBrickIron").setHardness(0F).setResistance(0F);
		pkBlockUnfiredBrickDiamond = new VIPBlockBrickDry(getIdFromProp("pkBlockUnfiredBrickDiamond.blockID"), pkItemUnfiredBrickDiamond.itemID).setUnlocalizedName("pkBlockUnfiredBrickDiamond").setHardness(0F).setResistance(0F);

		pkBlockCookedBrickGold = new VIPBlockBrickDry(getIdFromProp("pkBlockCookedBrickGold.blockID"), pkItemBrickGold.itemID).setUnlocalizedName("pkBlockCookedBrickGold").setHardness(0F).setResistance(0F);
		pkBlockCookedBrickIron = new VIPBlockBrickDry(getIdFromProp("pkBlockCookedBrickIron.blockID"), pkItemBrickIron.itemID).setUnlocalizedName("pkBlockCookedBrickIron").setHardness(0F).setResistance(0F);
		pkBlockCookedBrickDiamond = new VIPBlockBrickDry(getIdFromProp("pkBlockCookedBrickDiamond.blockID"), pkItemBrickDiamond.itemID).setUnlocalizedName("pkBlockCookedBrickDiamond").setHardness(0F).setResistance(0F);

		pkBlockBrickGold = new VIPBlockBrick(getIdFromProp("pkBlockBrickGold.blockID")).setHardness(2.5F).setResistance(10.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockBrickGold").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockBrickIron = new VIPBlockBrick(getIdFromProp("pkBlockBrickIron.blockID")).setHardness(3.5F).setResistance(13F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockBrickIron").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockBrickDiamond = new VIPBlockBrick(getIdFromProp("pkBlockBrickDiamond.blockID")).setHardness(1.5F).setResistance(5.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockBrickDiamond").setCreativeTab(CreativeTabs.tabBlock);
		((VIPBlockBrick)pkBlockBrickGold).setdrop(getIdFromProp("pkItemBrickGold.itemID"));
		((VIPBlockBrick)pkBlockBrickIron).setdrop(getIdFromProp("pkItemBrickIron.itemID"));
		((VIPBlockBrick)pkBlockBrickDiamond).setdrop(getIdFromProp("pkItemBrickDiamond.itemID"));


		pkBlockBrickGoldLoose = new VIPBlockBrickLoose(getIdFromProp("pkBlockBrickGoldLoose.blockID"), getIdFromProp("pkBlockBrickGold.blockID")).setHardness(1.5F).setResistance(6.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockBrickGoldLoose").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockBrickIronLoose = new VIPBlockBrickLoose(getIdFromProp("pkBlockBrickIronLoose.blockID"), getIdFromProp("pkBlockBrickIron.blockID")).setHardness(2F).setResistance(8F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockBrickIronLoose").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockBrickDiamondLoose = new VIPBlockBrickLoose(getIdFromProp("pkBlockBrickDiamondLoose.blockID"), getIdFromProp("pkBlockBrickDiamond.blockID")).setHardness(1F).setResistance(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockBrickDiamondLoose").setCreativeTab(CreativeTabs.tabBlock);

		pkBlockAdobeBrickYellow = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrickYellow.blockID"), Material.rock).setHardness(0F).setResistance(0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrickYellow").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockAdobeBrickIron = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrickIron.blockID"), Material.rock).setHardness(0F).setResistance(0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrickIron").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockAdobeBrickGold = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrickGold.blockID"), Material.rock).setHardness(0F).setResistance(0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrickGold").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockAdobeBrickDiamond = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrickDiamond.blockID"), Material.rock).setHardness(0F).setResistance(0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrickDiamond").setCreativeTab(CreativeTabs.tabBlock);

		pkBlockAdobeBrickYellowCooked = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrickYellowCooked.blockID"), Material.rock).setHardness(0.7F).setResistance(3F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrickYellowCooked").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockAdobeBrickIronCooked = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrickIronCooked.blockID"), Material.rock).setHardness(3F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrickIronCooked").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockAdobeBrickGoldCooked = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrickGoldCooked.blockID"), Material.rock).setHardness(2F).setResistance(8F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrickGoldCooked").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockAdobeBrickDiamondCooked = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrickDiamondCooked.blockID"), Material.rock).setHardness(1F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrickDiamondCooked").setCreativeTab(CreativeTabs.tabBlock);

		pkBlockAdobeBrick = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrick.blockID"), Material.rock).setHardness(0F).setResistance(0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrick").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockAdobeBrickCooked = new FCBlockFallingFullBlock(getIdFromProp("pkBlockAdobeBrickCooked.blockID"), Material.rock).setHardness(1F).setResistance(8F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("pkBlockAdobeBrickCooked").setCreativeTab(CreativeTabs.tabBlock);

		pkBlockUnfiredBrickStackGold = new VIPBlockBrickStack(getIdFromProp("pkBlockUnfiredBrickStackGold.blockID"), "pkBlockUnfiredBrickGold", pkItemUnfiredBrickGold.itemID).setUnlocalizedName("pkBlockUnfiredBrickStackGold").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockUnfiredBrickStackIron = new VIPBlockBrickStack(getIdFromProp("pkBlockUnfiredBrickStackIron.blockID"), "pkBlockUnfiredBrickIron", pkItemUnfiredBrickIron.itemID).setUnlocalizedName("pkBlockUnfiredBrickStackIron").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockUnfiredBrickStackDiamond = new VIPBlockBrickStack(getIdFromProp("pkBlockUnfiredBrickStackDiamond.blockID"), "pkBlockUnfiredBrickDiamond", pkItemUnfiredBrickDiamond.itemID).setUnlocalizedName("pkBlockUnfiredBrickStackDiamond").setCreativeTab(CreativeTabs.tabBlock);

		pkBlockCookedBrickStackGold = new VIPBlockBrickStack(getIdFromProp("pkBlockCookedBrickStackGold.blockID"), "pkBlockCookedBrickGold", pkItemBrickGold.itemID).setUnlocalizedName("pkBlockCookedBrickStackGold").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockCookedBrickStackIron = new VIPBlockBrickStack(getIdFromProp("pkBlockCookedBrickStackIron.blockID"), "pkBlockCookedBrickIron", pkItemBrickIron.itemID).setUnlocalizedName("pkBlockCookedBrickStackIron").setCreativeTab(CreativeTabs.tabBlock);
		pkBlockCookedBrickStackDiamond = new VIPBlockBrickStack(getIdFromProp("pkBlockCookedBrickStackDiamond.blockID"), "pkBlockCookedBrickDiamond", pkItemBrickDiamond.itemID).setUnlocalizedName("pkBlockCookedBrickStackDiamond").setCreativeTab(CreativeTabs.tabBlock);

		new ItemBlock(getIdFromProp("pkBlockUnfiredBrickGold.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockUnfiredBrickIron.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockUnfiredBrickDiamond.blockID") - 256);

		new ItemBlock(getIdFromProp("pkBlockCookedBrickGold.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockCookedBrickIron.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockCookedBrickDiamond.blockID") - 256);

		new ItemBlock(getIdFromProp("pkBlockBrickGold.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockBrickIron.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockBrickDiamond.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockBrickGoldLoose.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockBrickIronLoose.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockBrickDiamondLoose.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrickYellow.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrickIron.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrickGold.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrickDiamond.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrickYellowCooked.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrickIronCooked.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrickGoldCooked.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrickDiamondCooked.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrick.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockAdobeBrickCooked.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockUnfiredBrickStackGold.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockUnfiredBrickStackIron.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockUnfiredBrickStackDiamond.blockID") - 256);

		new ItemBlock(getIdFromProp("pkBlockCookedBrickStackGold.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockCookedBrickStackIron.blockID") - 256);
		new ItemBlock(getIdFromProp("pkBlockCookedBrickStackDiamond.blockID") - 256);



	}
	void
	InitializeIndBlockItems(){
		pkItemBlockBrickYellowSidingAndCorner = new FCItemBlockSidingAndCorner(pkBlockBrickYellowSidingAndCorner.blockID -256);
		pkItemBlockBrickYellowMouldingAndDecorative = new FCItemBlockMouldingAndDecorative(pkBlockBrickYellowMouldingAndDecorative.blockID - 256);
	}

	public void OnLanguageLoaded(StringTranslate st){
		
		Properties t = st.GetTranslateTable();

		t.put(pkItemBrickDry.getUnlocalizedName() + ".name", "Dry Brick");

		t.put(pkBlockBrickYellow.getUnlocalizedName() + ".name", "Dry Bricks");
		t.put(pkBlockBrickYellowSlab.getUnlocalizedName() + ".name", "Dry Brick Slab");
		t.put(pkBlockBrickYellowLoose.getUnlocalizedName() + ".name", "Loose Dry Bricks");
		t.put(pkBlockBrickYellowLooseSlab.getUnlocalizedName() + ".name", "Loose Dry Brick Slab");

		t.put(pkBlockBrickDry.getUnlocalizedName() + ".name", "Dry Brick");
		
		t.put(pkBlockBrickStack.getUnlocalizedName() + ".name", "Brick Pile");
		t.put(pkBlockBrickStackDry.getUnlocalizedName() + ".name", "Dry Brick Pile");
		t.put(pkBlockBrickStackCooked.getUnlocalizedName() + ".name", "Cooked Brick Pile");

		t.put(pkBlockKiln.getUnlocalizedName() + ".name", "Dry Brick Kiln");
		t.put(pkBlockKilnLit.getUnlocalizedName() + ".name", "Dry Brick Kiln");

		t.put(pkBlockTandoori.getUnlocalizedName() + ".name", "Tandoori");
		t.put(pkBlockTandooriCooked.getUnlocalizedName() + ".name", "Fired Tandoori");

		t.put("tile.pkBlockBrickYellowSidingAndCorner.siding.name", "Dry Brick Siding");
		t.put("tile.pkBlockBrickYellowSidingAndCorner.corner.name", "Dry Brick Corner");
		t.put("tile.pkBlockBrickYellowMouldingAndDecorative.moulding.name", "Dry Brick Moulding");
		t.put("tile.pkBlockBrickYellowMouldingAndDecorative.column.name", "Dry Brick Column");
		t.put("tile.pkBlockBrickYellowMouldingAndDecorative.pedestal.name", "Dry Brick Pedastal");
		t.put("tile.pkBlockBrickYellowMouldingAndDecorative.table.name", "Dry Brick Table");
	
		t.put(pkBlockDropsCharcoal.getUnlocalizedName() + ".name", "Charcoal Bearing Block");
		t.put(pkItemTandooriChicken.getUnlocalizedName() + ".name", "Tandoori Chicken");
		t.put(pkItemTandooriBeef.getUnlocalizedName() + ".name", "Tandoori Beef");
		t.put(pkItemTandooriMutton.getUnlocalizedName() + ".name", "Tandoori Mutton");
		t.put(pkItemTandooriPorkchop.getUnlocalizedName() + ".name", "Tandoori Pork");
		t.put(pkItemTandooriFish.getUnlocalizedName() + ".name", "Tandoori Fish");
		t.put(pkItemTandooriLiver.getUnlocalizedName() + ".name", "Tandoori Liver");
		t.put(pkItemPotteryShards.getUnlocalizedName() + ".name", "Pottery Shards");
		t.put(pkItemDonner.getUnlocalizedName() + ".name", "Donner");
		t.put(pkItemDonnerSandwich.getUnlocalizedName() + ".name", "Donner Sandwich");

		t.put(pkBlockDonner.getUnlocalizedName() + ".name", "Uncooked Donner");
		t.put(pkBlockDonnerCooked.getUnlocalizedName() + ".name", "Donner");
		t.put(pkBlockBreech.getUnlocalizedName() + ".name", "Kiln Breach");

		if(confprop.get("CustomDecorativeBlocksEnabled").equals("true")){
			t.put(pkBlockBrickGold.getUnlocalizedName() + ".name", "Gold Brick");
			t.put(pkBlockBrickIron.getUnlocalizedName() + ".name", "Iron Brick");
			t.put(pkBlockBrickDiamond.getUnlocalizedName() + ".name", "Diamond Brick");
			t.put(pkBlockBrickGoldLoose.getUnlocalizedName() + ".name", "Loose Gold Brick");
			t.put(pkBlockBrickIronLoose.getUnlocalizedName() + ".name", "Loose Iron Brick");
			t.put(pkBlockBrickDiamondLoose.getUnlocalizedName() + ".name", "Loose Diamond Brick");
			t.put(pkBlockAdobeBrickYellow.getUnlocalizedName() + ".name", "Uncooked Yellow Brick Adobe");
			t.put(pkBlockAdobeBrickIron.getUnlocalizedName() + ".name", "Uncooked Iron Brick Adobe");
			t.put(pkBlockAdobeBrickGold.getUnlocalizedName() + ".name", "Uncooked Gold Brick Adobe");
			t.put(pkBlockAdobeBrickDiamond.getUnlocalizedName() + ".name", "Uncooked Diamond Brick Adobe");
			t.put(pkBlockAdobeBrickYellowCooked.getUnlocalizedName() + ".name", "Yellow Brick Adobe");
			t.put(pkBlockAdobeBrickIronCooked.getUnlocalizedName() + ".name", "Iron Brick Adobe");
			t.put(pkBlockAdobeBrickGoldCooked.getUnlocalizedName() + ".name", "Gold Brick Adobe");
			t.put(pkBlockAdobeBrickDiamondCooked.getUnlocalizedName() + ".name", "Diamond Brick Adobe");
			t.put(pkBlockAdobeBrick.getUnlocalizedName() + ".name", "Uncooked Adobe Brick");
			t.put(pkBlockAdobeBrickCooked.getUnlocalizedName() + ".name", "Adobe Brick");
			t.put(pkItemUnfiredBrickGold.getUnlocalizedName() + ".name", "Unfired Gold Refactory Brick");
			t.put(pkItemUnfiredBrickIron.getUnlocalizedName() + ".name", "Unfired Iron Refactory Brick");
			t.put(pkItemUnfiredBrickDiamond.getUnlocalizedName() + ".name", "Unfired Diamond Refactory Brick");
			t.put(pkItemBrickGold.getUnlocalizedName() + ".name", "Gold Refactory Brick");
			t.put(pkItemBrickIron.getUnlocalizedName() + ".name", "Iron Refactory Brick");
			t.put(pkItemBrickDiamond.getUnlocalizedName() + ".name", "Diamond Refactory Brick");
			t.put(pkBlockUnfiredBrickStackGold.getUnlocalizedName() + ".name", "Unfired Gold Brick Stack");
			t.put(pkBlockUnfiredBrickStackIron.getUnlocalizedName() + ".name", "Unfired Iron Brick Stack");
			t.put(pkBlockUnfiredBrickStackDiamond.getUnlocalizedName() + ".name", "Unfired Diamond Brick Stack");

			t.put(pkBlockCookedBrickStackGold.getUnlocalizedName() + ".name", "Gold Brick Stack");
			t.put(pkBlockCookedBrickStackIron.getUnlocalizedName() + ".name", "Iron Brick Stack");
			t.put(pkBlockCookedBrickStackDiamond.getUnlocalizedName() + ".name", "Diamond Brick Stack");



		}

	}
}
