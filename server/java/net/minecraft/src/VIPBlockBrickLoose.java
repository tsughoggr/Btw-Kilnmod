package net.minecraft.src;

public class VIPBlockBrickLoose extends FCBlockMortarReceiver
{
	private int mortarblock;

	public
	VIPBlockBrickLoose(int var1, int bid)
	{
		super(var1, Material.rock);
		/*Reference for Normal Brick*/
		/*
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		*/
		mortarblock = bid;
		this.SetPicksEffectiveOn();
		this.SetChiselsEffectiveOn();
		this.setStepSound(soundStoneFootstep);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public boolean
	OnMortarApplied(World var1, int var2, int var3, int var4)
	{
		var1.setBlockWithNotify(var2, var3, var4, mortarblock);
		return true;
	}
}
