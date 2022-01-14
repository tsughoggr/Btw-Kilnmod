package net.minecraft.src;

public class VIPBlockUnfiredBrickReplacement extends FCBlockUnfiredBrick{

	public
	VIPBlockUnfiredBrickReplacement(int id){
		super(id);
	}

	public void
	OnFinishedCooking(World var1, int var2, int var3, int var4){
		int var5 = var1.getBlockMetadata(var2, var3, var4) & 1;
		var1.setBlockAndMetadataWithNotify(var2, var3, var4, VIPKilns.pkBlockBrickDry.blockID, var5);
	}
}
