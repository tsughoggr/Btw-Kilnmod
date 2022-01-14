package net.minecraft.src;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class VIPCraftingManagerPrimitiveKiln {
	private static final VIPCraftingManagerPrimitiveKiln instance = new VIPCraftingManagerPrimitiveKiln();
	private ArrayList<VIPRecipeKiln> recipes = new ArrayList();

	private VIPCraftingManagerPrimitiveKiln() {
		/* [2] and [3] form an equation H - (4 H / Σ[2]system) + (H/Σ[2]system) * Log( 1 + |Σ[3]system * kbe * H|/Σ[2]system)*/
		/*Where the heat is the total heat of the kiln and kbe is the kiln block's efficiency (10 for primitive kiln)*/
		/*and heat is incremented by (20 * sbe / 100) every 1 second */
		/* [4]: heat for transform 120 = 1 minute, when equation above satisified the transformation will occur*/



		addRecipe(FCBetterThanWolves.fcBlockUnfiredBrick.blockID, FCBetterThanWolves.fcBlockCookedBrick.blockID, 10, 5, 600);
		addRecipe(VIPKilns.pkBlockBrickDry.blockID, FCBetterThanWolves.fcBlockCookedBrick.blockID, 5, 15, 450);
		addRecipe(FCBetterThanWolves.fcBlockCookedBrick.blockID, VIPKilns.pkBlockBreech.blockID, 30, 1, 1100);
		addRecipe(VIPKilns.pkBlockBrickStack.blockID, VIPKilns.pkBlockBrickStackCooked.blockID, 50, 2, 3600, 2,1,0);
		addRecipe(VIPKilns.pkBlockBrickStackDry.blockID, VIPKilns.pkBlockBrickStackCooked.blockID, 30, 5, 3600, 2,0,0);
		addRecipe(VIPKilns.pkBlockBrickStackCooked.blockID, VIPKilns.pkBlockBreech.blockID, 25, 1, 8000);

		/*Refactoreies for the special blocks/ walls*/
		addRecipe(Block.stone.blockID, VIPKilns.pkBlockBreech.blockID, 20, -1, 6000);
		addRecipe(Block.grass.blockID, VIPKilns.pkBlockBreech.blockID, 80, 1, 3000);
		addRecipe(Block.cobblestone.blockID, VIPKilns.pkBlockBreech.blockID, 20, -1, 5500);
		addRecipe(Block.dirt.blockID, VIPKilns.pkBlockBreech.blockID, 80, 1, 3000);
		addRecipe(Block.obsidian.blockID, VIPKilns.pkBlockBreech.blockID, 5, -5, 12000);
		addRecipe(Block.brick.blockID, VIPKilns.pkBlockBreech.blockID, 1, 100, 12000);
		addRecipe(Block.netherBrick.blockID, VIPKilns.pkBlockBreech.blockID, 1, 100, 18000);
		addRecipe(Block.stoneBrick.blockID, VIPKilns.pkBlockBreech.blockID, 20, -1, 5400);
		addRecipe(FCBetterThanWolves.fcBlockBrickLoose.blockID, VIPKilns.pkBlockBreech.blockID, 1, 80, 10000);
		addRecipe(FCBetterThanWolves.fcBlockDirtLoose.blockID, VIPKilns.pkBlockBreech.blockID, 80, 1, 3000);
		addRecipe(FCBetterThanWolves.fcBlockCobblestoneLoose.blockID, VIPKilns.pkBlockBreech.blockID, 25, 1, 5000);
		addRecipe(FCBetterThanWolves.fcBlockNetherBrickLoose.blockID, VIPKilns.pkBlockBreech.blockID, 1, 80, 16000);

		addRecipe(VIPKilns.pkBlockBrickYellow.blockID, VIPKilns.pkBlockBreech.blockID, 5, 30, 4000);
		addRecipe(VIPKilns.pkBlockBrickYellowLoose.blockID, VIPKilns.pkBlockBreech.blockID, 10, 20, 3500);

		addRecipe(VIPKilns.pkBlockKiln.blockID, VIPKilns.pkBlockBreech.blockID, 5, 0, 8000);
		addRecipe(VIPKilns.pkBlockKilnLit.blockID, VIPKilns.pkBlockBreech.blockID, 5, 0, 8000);

		addRecipe(VIPKilns.pkBlockBreech.blockID, Block.fire.blockID, 1,1500, 40000);

	}
	public static final VIPCraftingManagerPrimitiveKiln getInstance() {
		return instance;
	}
	public void
	removeRecipe(ItemStack it){
		VIPRecipeKiln tmp;
		int i;
		for(i=0;i<this.recipes.size();++i){
			tmp = recipes.get(i);
			if(tmp.MatchRecipe(it)){
				this.recipes.remove(i);
			} 
		}
	}
	/*tmp[5] = mode, 0, set MD to existing 1,2: updating cookicon blocks (change MD) 3,4 MD dependent recipes (3 : output defined, 4 : input + output defined)*/
	public VIPRecipeKiln findMatchingRecipe(int mat, int md){
		VIPRecipeKiln tmp;
		int i;

		for(i=0;i<this.recipes.size();++i){
			tmp = recipes.get(i);
			if(tmp.MatchRecipe(new ItemStack(mat, 0, md))){
				return tmp;
			}
		}
		return null;

	}
	void addRecipe(ItemStack inpt, ItemStack outpt, boolean blockmode, int ht, int rs, int efc){
		VIPRecipeKiln rec = new VIPRecipeKiln(inpt, outpt, blockmode, ht, rs, efc);
		recipes.add(rec);
	}
	void addRecipe(ItemStack inpt, int imd, ItemStack outpt, boolean bmd, boolean omd, int ht, int rs, int efc){
		VIPRecipeKiln rec = new VIPRecipeKiln(inpt, imd, outpt, bmd, omd, ht, rs, efc);
		recipes.add(rec);
	}

	void addRecipe(int src, int dst, int rate, int eff, int heat, int doupdate, int md, int rmd){
		addRecipe(
			new ItemStack(src, 1, md),
			0,
			new ItemStack(dst, 1, rmd),
			true,
			false,
			heat,
			rate,
			eff
		);
	}
	void addRecipe(int src, int dst, int rate, int eff, int heat){
		addRecipe(src,dst,rate,eff,heat,0,0, 0);
	}
	public void
	debugRecipes(){
		for(VIPRecipeKiln tmp : recipes){
			System.out.println("RECIPE: " + tmp.input.itemID + " " + tmp.input.getItemDamage());
		}
	}

}

