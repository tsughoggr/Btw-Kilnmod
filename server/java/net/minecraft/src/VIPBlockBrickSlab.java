package net.minecraft.src;

import java.util.Random;

public class VIPBlockBrickSlab extends FCBlockSlab
{
	private int combinedId;
	private int dropid;
	public VIPBlockBrickSlab(int var1, int cid)
	{
		super(var1, FCBetterThanWolves.fcMaterialMiscellaneous);

		this.SetPicksEffectiveOn(true);
		this.setStepSound(soundStoneFootstep);
		this.setCreativeTab(CreativeTabs.tabBlock);
		combinedId = cid;
		dropid = this.blockID;
 	}
	public void
	setdrop(int id){
		dropid = id;
	}
	public int idDropped(int g, Random r, int c){
		return dropid;
	}
	public boolean DoesBlockBreakSaw(World var1, int var2, int var3, int var4)
	{
		return false;
	}

	public int GetItemIDDroppedOnSaw(World var1, int var2, int var3, int var4)
	{
		return 0;
	}

	public int GetItemCountDroppedOnSaw(World var1, int var2, int var3, int var4)
	{
		return 4;
	}

	public int GetCombinedBlockID(int var1)
	{
		return combinedId;
	}
	/*Not packing for now, may change eventually*/
	public int GetCombinedMetadata(int var1)
	{
		return 0;
	}

	public boolean CanBePistonShoveled(World var1, int var2, int var3, int var4)
	{
		return false;
	}




}
