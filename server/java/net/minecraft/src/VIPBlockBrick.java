package net.minecraft.src;

import java.util.Random;

public class VIPBlockBrick extends Block
{
	int did;
	public VIPBlockBrick(int var1)
	{
		super(var1, Material.rock);
		this.SetPicksEffectiveOn();
		did = this.blockID;
	}
	public void
	setdrop(int id){
		did = id;
	}
	public void
	OnBlockDestroyedWithImproperTool(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6)
	{
		this.dropBlockAsItem(var1, var3, var4, var5, var6, 0);
	}

	public boolean
	HasMortar(IBlockAccess var1, int var2, int var3, int var4)
	{
		return true;
	}
	public int
	idDropped(int v, Random r, int g){
		return did;
	}
}
