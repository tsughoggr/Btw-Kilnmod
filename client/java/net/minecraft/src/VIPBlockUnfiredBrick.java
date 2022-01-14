package net.minecraft.src;

public class VIPBlockUnfiredBrick extends FCBlockCookedBrick{
	private int result;
	private Icon[] m_cookIcons;

	public
	VIPBlockUnfiredBrick(int id, int rid){
		super(id);
	}

	public void
	OnFinishedCooking(World var1, int var2, int var3, int var4){
		int var5 = var1.getBlockMetadata(var2, var3, var4) & 1;
		var1.setBlockAndMetadataWithNotify(var2, var3, var4, result, var5);
	}
	public void registerIcons(IconRegister var1)
	{
		super.registerIcons(var1);
		this.m_cookIcons = new Icon[7];

		for (int var2 = 0; var2 < 7; ++var2)
		{
			this.m_cookIcons[var2] = var1.registerIcon("fcOverlayUnfiredBrick_" + (var2 + 1));
		}
	}
	public void RenderBlockSecondPass(RenderBlocks var1, int var2, int var3, int var4, boolean var5)
	{
		if (var5)
		{
			IBlockAccess var6 = var1.blockAccess;
			int var7 = this.GetCookLevel(var6, var2, var3, var4);
			int var8 = var6.getBlockId(var2, var3 - 1, var4);

			if (var8 == FCBetterThanWolves.fcKiln.blockID)
			{
				int var9 = FCBetterThanWolves.fcKiln.GetCookCounter(var6, var2, var3 - 1, var4) / 2;

				if (var9 > var7)
				{
					var7 = var9;
				}
			}

			if (var7 > 0 && var7 <= 7)
			{
				this.RenderBlockWithTexture(var1, var2, var3, var4, this.m_cookIcons[var7 - 1]);
			}
		}
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
