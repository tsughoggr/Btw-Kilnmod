package net.minecraft.src;

import java.util.Random;

public abstract class VIPKilnRecipes{
	public static void
	addAllRecipes(){
		addShapedCraftingRecipes();
		addShapelessCraftingRecipes();
		addSubblockRecipes();
		addHopperRecipes();
	}
	private static void
	addShapedCraftingRecipes(){
		CraftingManager.getInstance().addRecipe(new ItemStack(VIPKilns.pkBlockBrickYellowSlab, 6), new Object[]{"XXX", 'X', new ItemStack(VIPKilns.pkBlockBrickYellow)});
		CraftingManager.getInstance().addRecipe(new ItemStack(VIPKilns.pkBlockBrickYellowLooseSlab, 6), new Object[]{"XXX", 'X', new ItemStack(VIPKilns.pkBlockBrickYellowLoose)});
		CraftingManager.getInstance().addRecipe(new ItemStack(VIPKilns.pkItemDonnerSandwich), new Object[]{
			"BMM", "MMM", "MMB", 'B', new ItemStack(Item.bread), 'M', new ItemStack(VIPKilns.pkItemDonner)
		});


	}
	private static void
	addShapelessCraftingRecipes(){
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockBrickYellowLooseSlab), new Object[]{ new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockBrickYellowLoose), new Object[]{ new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry)});


		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockBrickStack), new Object[] { new ItemStack(FCBetterThanWolves.fcItemBrickUnfired), new ItemStack(FCBetterThanWolves.fcItemBrickUnfired), new ItemStack(FCBetterThanWolves.fcItemBrickUnfired), new ItemStack(FCBetterThanWolves.fcItemBrickUnfired), new ItemStack(FCBetterThanWolves.fcItemBrickUnfired), new ItemStack(FCBetterThanWolves.fcItemBrickUnfired), new ItemStack(FCBetterThanWolves.fcItemBrickUnfired), new ItemStack(FCBetterThanWolves.fcItemBrickUnfired),  new ItemStack(Item.silk)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockBrickStack), new Object[] {new ItemStack(FCBetterThanWolves.fcBlockUnfiredClay),  new ItemStack(Item.silk)});

		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockBrickStackDry), new Object[] { new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry), new ItemStack(VIPKilns.pkItemBrickDry),  new ItemStack(Item.silk)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockBrickStackCooked), new Object[] { new ItemStack(Item.brick), new ItemStack(Item.brick), new ItemStack(Item.brick), new ItemStack(Item.brick), new ItemStack(Item.brick), new ItemStack(Item.brick), new ItemStack(Item.brick), new ItemStack(Item.brick),  new ItemStack(Item.silk)});

		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(FCBetterThanWolves.fcItemBrickUnfired, 8), new Object[]{ new ItemStack(VIPKilns.pkBlockBrickStack)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkItemBrickDry, 8), new Object[]{ new ItemStack(VIPKilns.pkBlockBrickStackDry)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Item.brick, 8), new Object[]{ new ItemStack(VIPKilns.pkBlockBrickStackCooked)});



		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkItemBrickDry, 8), new Object[]{new ItemStack(VIPKilns.pkBlockBrickYellow)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkItemBrickDry, 4), new Object[]{new ItemStack(VIPKilns.pkBlockBrickYellowSlab)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkItemBrickDry, 8), new Object[]{new ItemStack(VIPKilns.pkBlockBrickYellowLoose)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkItemBrickDry, 4), new Object[]{new ItemStack(VIPKilns.pkBlockBrickYellowLooseSlab)});

		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockBrickYellow), new Object[]{ new ItemStack(VIPKilns.pkBlockBrickYellowSlab), new ItemStack(VIPKilns.pkBlockBrickYellowSlab)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockBrickYellowLoose), new Object[]{ new ItemStack(VIPKilns.pkBlockBrickYellowLooseSlab), new ItemStack(VIPKilns.pkBlockBrickYellowLooseSlab)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockKiln), new Object[]{ new ItemStack(VIPKilns.pkBlockBrickYellowLooseSlab), new ItemStack(VIPKilns.pkBlockBrickYellowLooseSlab), new ItemStack(VIPKilns.pkBlockBrickYellowLooseSlab), new ItemStack(VIPKilns.pkBlockBrickYellowLooseSlab)});
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(VIPKilns.pkBlockKiln), new Object[]{new ItemStack(VIPKilns.pkBlockBrickYellowLoose), new ItemStack(VIPKilns.pkBlockBrickYellowLoose)});

	}
	private static void
	addSubblockRecipes(){
		FCRecipes.AddSubBlockRecipesOfType(VIPKilns.pkBlockBrickYellow, 0, VIPKilns.pkBlockBrickYellowSidingAndCorner , VIPKilns.pkBlockBrickYellowMouldingAndDecorative , true);

	}

	public static void
	addCharcoalRecipe(){
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(Block.wood.blockID, VIPKilns.pkBlockDropsCharcoal.blockID,1,0,1200);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(VIPKilns.pkBlockDropsCharcoal.blockID, VIPKilns.pkBlockBreech.blockID, 1, -5, 6500);
	}
	public static void
	addTandooriRecipes(){
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 0),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(FCBetterThanWolves.fcItemMuttonRaw.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 1),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(Item.beefRaw.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 2),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(Item.chickenRaw.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 3),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(Item.porkRaw.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 4),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(Item.fishRaw.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 5),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(FCBetterThanWolves.fcItemBeastLiverRaw.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 6),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(Item.rottenFlesh.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 7),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(Item.carrot.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 8),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(Item.potato.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 9),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(FCBetterThanWolves.fcItemRawMysteryMeat.itemID, 1,0)
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockTandoori, 1, 10),
		 	new Object[]{"SCS", "CMC", "CCC",
			'C', new ItemStack(Item.clay, 1),
			'S', new ItemStack(Item.silk, 1),
			'M', new ItemStack(FCBetterThanWolves.fcItemWolfRaw.itemID, 1,0)
		});

		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(VIPKilns.pkBlockTandooriCooked.blockID, Block.fire.blockID, 40, 10, 850);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(VIPKilns.pkBlockTandoori.blockID, VIPKilns.pkBlockTandooriCooked.blockID,50,10,450);

		for(int i=0;i<16;++i){
			VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(new ItemStack(VIPKilns.pkBlockTandoori, 1, i), 0xF, new ItemStack(VIPKilns.pkBlockTandooriCooked, 1, i), true, false, 450, 50, 10);
			FCCraftingManagerKiln.instance.addRecipe(new ItemStack[]{new ItemStack(VIPKilns.pkBlockTandooriCooked.blockID, 1, i)}, VIPKilns.pkBlockTandoori, i, (byte)3);
		}
	}
	public static void
	addKebabRecipes(){
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockDonner.blockID, 1, 12),
			new Object[]{ "CSC", "MAM", "BFB",
			'S', new ItemStack(Item.silk),
			'C', new ItemStack(Item.chickenCooked),
			'A', new ItemStack(FCBetterThanWolves.fcBlockAxle),
			'M', new ItemStack(FCBetterThanWolves.fcItemMuttonCooked),
			'B', new ItemStack(Item.beefCooked),
			'F', new ItemStack(Item.fishCooked)
		});
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(VIPKilns.pkBlockDonner.blockID, VIPKilns.pkBlockDonnerCooked.blockID, 40, 3,550);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe( VIPKilns.pkBlockDonnerCooked.blockID, Block.fire.blockID, 35, 3, 900);
		for(int i=0;i<16;++i){
			FCCraftingManagerKiln.instance.addRecipe(new ItemStack[] {new ItemStack(VIPKilns.pkBlockDonnerCooked.blockID, 1, i)}, VIPKilns.pkBlockDonner, i, (byte)3);
		}
	}
	public static void
	addCeramicRecipes(){

		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(new ItemStack(FCBetterThanWolves.fcUnfiredPottery), 0x0, new ItemStack(FCBetterThanWolves.fcVase), false, true, 700, 20,10);


		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(FCBetterThanWolves.fcCrucible.blockID, VIPKilns.pkBlockBreech.blockID, 20, 10, 1100);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(FCBetterThanWolves.fcPlanter.blockID, VIPKilns.pkBlockBreech.blockID, 20, 10, 1100);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(FCBetterThanWolves.fcVase.blockID, VIPKilns.pkBlockBreech.blockID, 20, 10, 1100);
	}
	private static void
	addHopperRecipes(){
		FCRecipes.addHopperFilteringRecipe( new ItemStack(FCBetterThanWolves.fcItemPileClay), new ItemStack(FCBetterThanWolves.fcItemPileClay), new ItemStack(VIPKilns.pkItemPotteryShards), new ItemStack(Item.bucketWater));
		FCRecipes.addHopperFilteringRecipe( new ItemStack(FCBetterThanWolves.fcItemPileClay), new ItemStack(FCBetterThanWolves.fcItemPileClay), new ItemStack(Item.clay), new ItemStack(Block.gravel));
	}
	public static void
	addDecoRecipes(){
		CraftingManager.getInstance().addRecipe(
			new ItemStack( VIPKilns.pkItemUnfiredBrickGold,2), new Object[]{ "CGC", "GCG", "CGC", 'C', new ItemStack(FCBetterThanWolves.fcItemPileClay), 'G', new ItemStack(Item.goldNugget)}
		);
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkItemUnfiredBrickIron,2), new Object[]{"CIC", "ICI", "CIC", 'C', new ItemStack(FCBetterThanWolves.fcItemPileClay), 'I', new ItemStack(FCBetterThanWolves.fcItemNuggetIron)}
		);
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkItemUnfiredBrickDiamond), new Object[]{" C ", "CDC", " C ", 'D', new ItemStack(Item.diamond), 'C', new ItemStack(FCBetterThanWolves.fcItemPileClay)}
		);

		CraftingManager.getInstance().addShapelessRecipe(
			new ItemStack(VIPKilns.pkBlockBrickGoldLoose), new Object[]{new ItemStack(VIPKilns.pkItemBrickGold),new ItemStack(VIPKilns.pkItemBrickGold),new ItemStack(VIPKilns.pkItemBrickGold),new ItemStack(VIPKilns.pkItemBrickGold),new ItemStack(VIPKilns.pkItemBrickGold),new ItemStack(VIPKilns.pkItemBrickGold),new ItemStack(VIPKilns.pkItemBrickGold),new ItemStack(VIPKilns.pkItemBrickGold)}
		);
		CraftingManager.getInstance().addShapelessRecipe(
			new ItemStack(VIPKilns.pkBlockBrickIronLoose), new Object[]{new ItemStack(VIPKilns.pkItemBrickIron),new ItemStack(VIPKilns.pkItemBrickIron),new ItemStack(VIPKilns.pkItemBrickIron),new ItemStack(VIPKilns.pkItemBrickIron),new ItemStack(VIPKilns.pkItemBrickIron),new ItemStack(VIPKilns.pkItemBrickIron),new ItemStack(VIPKilns.pkItemBrickIron),new ItemStack(VIPKilns.pkItemBrickIron)}
		);
		CraftingManager.getInstance().addShapelessRecipe(
			new ItemStack(VIPKilns.pkBlockBrickDiamondLoose), new Object[]{new ItemStack(VIPKilns.pkItemBrickDiamond),new ItemStack(VIPKilns.pkItemBrickDiamond),new ItemStack(VIPKilns.pkItemBrickDiamond),new ItemStack(VIPKilns.pkItemBrickDiamond),new ItemStack(VIPKilns.pkItemBrickDiamond),new ItemStack(VIPKilns.pkItemBrickDiamond),new ItemStack(VIPKilns.pkItemBrickDiamond),new ItemStack(VIPKilns.pkItemBrickDiamond)}
		);
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickYellow),
			new Object[]{ "SBS", "BCB", "SBS",
			'B', new ItemStack(VIPKilns.pkItemBrickDry),
			'C', new ItemStack(Item.clay),
			'S', new ItemStack(FCBetterThanWolves.fcItemStraw)
 
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickIron),
			new Object[]{ "SBS", "BCB", "SBS",
			'B', new ItemStack(VIPKilns.pkItemBrickIron),
			'C', new ItemStack(Item.clay),
			'S', new ItemStack(FCBetterThanWolves.fcItemStraw)
 
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickGold),
			new Object[]{ "SBS", "BCB", "SBS",
			'B', new ItemStack(VIPKilns.pkItemBrickGold),
			'C', new ItemStack(Item.clay),
			'S', new ItemStack(FCBetterThanWolves.fcItemStraw)
 
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickDiamond),
			new Object[]{ "SBS", "BCB", "SBS",
			'B', new ItemStack(VIPKilns.pkItemBrickDiamond),
			'C', new ItemStack(Item.clay),
			'S', new ItemStack(FCBetterThanWolves.fcItemStraw)
 
		});
		CraftingManager.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrick),
			new Object[]{ "SBS", "BCB", "SBS",
			'B', new ItemStack(Item.brick),
			'C', new ItemStack(Item.clay),
			'S', new ItemStack(FCBetterThanWolves.fcItemStraw)
 
		});
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockUnfiredBrickGold),
			new ItemStack(VIPKilns.pkBlockCookedBrickGold),
			true,
			800, 8, 10
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			
			new ItemStack(VIPKilns.pkBlockUnfiredBrickIron),
			new ItemStack(VIPKilns.pkBlockCookedBrickIron), 
			true,
			1500, 4, 25
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockUnfiredBrickDiamond),
			new ItemStack(VIPKilns.pkBlockCookedBrickDiamond), 
			true, 750, 3, 40
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockCookedBrickGold),
			new ItemStack(VIPKilns.pkBlockBreech), 
			true, 1400, 6, 15
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockCookedBrickIron),
			new ItemStack(VIPKilns.pkBlockBreech), 
			true, 2500 , 3, 40
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockCookedBrickDiamond),
			new ItemStack(VIPKilns.pkBlockBreech), 
			true, 1000, 2, 45
		);

		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickYellow),
			new ItemStack(VIPKilns.pkBlockAdobeBrickYellowCooked),
			true,
			500, 3, 3
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickIron),
			new ItemStack(VIPKilns.pkBlockAdobeBrickIronCooked),
			true,
			800, 3, 3
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickGold),
			new ItemStack(VIPKilns.pkBlockAdobeBrickGoldCooked),
			true,
			700, 5, 3
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickDiamond),
			new ItemStack(VIPKilns.pkBlockAdobeBrickDiamondCooked),
			true,
			600, 1, 3
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrick),
			new ItemStack(VIPKilns.pkBlockAdobeBrickCooked),
			true,
			650, 3, 3
		);

		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickCooked),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			1200, 8, 4
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickDiamondCooked),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			1200, 8, 4
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickGoldCooked),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			1200, 8, 4
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickIronCooked),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			1200, 8, 4
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockAdobeBrickYellowCooked),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			1200, 8, 4
		);


		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockBrickGold),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			21000, 5, 120
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockBrickIron),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			35000, 20, 90
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockBrickDiamond),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			9100, 1, 250
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockBrickGoldLoose),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			18000, 5, 90
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockBrickIronLoose),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			28000, 25, 75
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockBrickDiamondLoose),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			7000, 1, 200
		);
		CraftingManager.getInstance().addShapelessRecipe(
			new ItemStack(VIPKilns.pkBlockUnfiredBrickStackGold),
			new Object[] {
				new ItemStack(VIPKilns.pkItemUnfiredBrickGold),
				new ItemStack(VIPKilns.pkItemUnfiredBrickGold),
				new ItemStack(VIPKilns.pkItemUnfiredBrickGold),
				new ItemStack(VIPKilns.pkItemUnfiredBrickGold),
				new ItemStack(VIPKilns.pkItemUnfiredBrickGold),
				new ItemStack(VIPKilns.pkItemUnfiredBrickGold),
				new ItemStack(VIPKilns.pkItemUnfiredBrickGold),
				new ItemStack(VIPKilns.pkItemUnfiredBrickGold),
				new ItemStack(Item.silk)
			}
		);
		CraftingManager.getInstance().addShapelessRecipe(
			new ItemStack(VIPKilns.pkBlockUnfiredBrickStackIron),
			new Object[] {
				new ItemStack(VIPKilns.pkItemUnfiredBrickIron),
				new ItemStack(VIPKilns.pkItemUnfiredBrickIron),
				new ItemStack(VIPKilns.pkItemUnfiredBrickIron),
				new ItemStack(VIPKilns.pkItemUnfiredBrickIron),
				new ItemStack(VIPKilns.pkItemUnfiredBrickIron),
				new ItemStack(VIPKilns.pkItemUnfiredBrickIron),
				new ItemStack(VIPKilns.pkItemUnfiredBrickIron),
				new ItemStack(VIPKilns.pkItemUnfiredBrickIron),
				new ItemStack(Item.silk)
			}
		);
		CraftingManager.getInstance().addShapelessRecipe(
			new ItemStack(VIPKilns.pkBlockUnfiredBrickStackDiamond),
			new Object[] {
				new ItemStack(VIPKilns.pkItemUnfiredBrickDiamond),
				new ItemStack(VIPKilns.pkItemUnfiredBrickDiamond),
				new ItemStack(VIPKilns.pkItemUnfiredBrickDiamond),
				new ItemStack(VIPKilns.pkItemUnfiredBrickDiamond),
				new ItemStack(VIPKilns.pkItemUnfiredBrickDiamond),
				new ItemStack(VIPKilns.pkItemUnfiredBrickDiamond),
				new ItemStack(VIPKilns.pkItemUnfiredBrickDiamond),
				new ItemStack(VIPKilns.pkItemUnfiredBrickDiamond),
				new ItemStack(Item.silk)
			}
		);
		CraftingManager.getInstance().addShapelessRecipe(
			new ItemStack(VIPKilns.pkBlockCookedBrickStackGold),
			new Object[] {
				new ItemStack(VIPKilns.pkItemBrickGold),
				new ItemStack(VIPKilns.pkItemBrickGold),
				new ItemStack(VIPKilns.pkItemBrickGold),
				new ItemStack(VIPKilns.pkItemBrickGold),
				new ItemStack(VIPKilns.pkItemBrickGold),
				new ItemStack(VIPKilns.pkItemBrickGold),
				new ItemStack(VIPKilns.pkItemBrickGold),
				new ItemStack(VIPKilns.pkItemBrickGold),
				new ItemStack(Item.silk)
			}
		);
		CraftingManager.getInstance().addShapelessRecipe(
			new ItemStack(VIPKilns.pkBlockCookedBrickStackIron),
			new Object[] {
				new ItemStack(VIPKilns.pkItemBrickIron),
				new ItemStack(VIPKilns.pkItemBrickIron),
				new ItemStack(VIPKilns.pkItemBrickIron),
				new ItemStack(VIPKilns.pkItemBrickIron),
				new ItemStack(VIPKilns.pkItemBrickIron),
				new ItemStack(VIPKilns.pkItemBrickIron),
				new ItemStack(VIPKilns.pkItemBrickIron),
				new ItemStack(VIPKilns.pkItemBrickIron),
				new ItemStack(Item.silk)
			}
		);
		CraftingManager.getInstance().addShapelessRecipe(
			new ItemStack(VIPKilns.pkBlockCookedBrickStackDiamond),
			new Object[] {
				new ItemStack(VIPKilns.pkItemBrickDiamond),
				new ItemStack(VIPKilns.pkItemBrickDiamond),
				new ItemStack(VIPKilns.pkItemBrickDiamond),
				new ItemStack(VIPKilns.pkItemBrickDiamond),
				new ItemStack(VIPKilns.pkItemBrickDiamond),
				new ItemStack(VIPKilns.pkItemBrickDiamond),
				new ItemStack(VIPKilns.pkItemBrickDiamond),
				new ItemStack(VIPKilns.pkItemBrickDiamond),
				new ItemStack(Item.silk)
			}
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockUnfiredBrickStackGold),
			new ItemStack(VIPKilns.pkBlockCookedBrickStackGold),
			true,
			3800, 5, 20
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockCookedBrickStackGold),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			14000, 3, 25
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockUnfiredBrickStackIron),
			new ItemStack(VIPKilns.pkBlockCookedBrickStackIron),
			true,
			7500, 5, 20
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockCookedBrickStackIron),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			25000, 3, 25
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockUnfiredBrickStackDiamond),
			new ItemStack(VIPKilns.pkBlockCookedBrickStackDiamond),
			true,
			3300, 5, 20
		);
		VIPCraftingManagerPrimitiveKiln.getInstance().addRecipe(
			new ItemStack(VIPKilns.pkBlockCookedBrickStackDiamond),
			new ItemStack(VIPKilns.pkBlockBreech),
			true,
			8000, 3, 25
		);
		
	}
}

