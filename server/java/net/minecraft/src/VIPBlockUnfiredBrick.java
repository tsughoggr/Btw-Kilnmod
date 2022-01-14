package net.minecraft.src;

public class VIPBlockUnfiredBrick extends FCBlockCookedBrick{
	private int result;
	public
	VIPBlockUnfiredBrick(int id, int rid){
		super(id);
	}

	public void
	OnFinishedCooking(World var1, int var2, int var3, int var4){
		int var5 = var1.getBlockMetadata(var2, var3, var4) & 1;
		var1.setBlockAndMetadataWithNotify(var2, var3, var4, result, var5);
	}


	public int GetCookLevel(IBlockAccess var1, int var2, int var3, int var4)
	{
		return this.GetCookLevel(var1.getBlockMetadata(var2, var3, var4));
	}

	public int GetCookLevel(int var1)
	{
		return var1 >> 1;
	}

}
