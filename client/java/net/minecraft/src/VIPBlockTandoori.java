package net.minecraft.src;

import java.util.Random;
import java.util.List;

public class VIPBlockTandoori extends Block {
	private Icon blockIcon;
	private FCModelBlock bmodel = new FCModelBlock();
	private int[] recipes;
	private String iconname;
	private boolean ckd;

	public VIPBlockTandoori(int id, String icn, Boolean cooked, int[] res){
		super(id, Material.circuits);
		recipes = res;
		iconname = icn;
		ckd = cooked;
		bmodel.AddBox(0.11D, 0D, 0.11D, 0.88D, 0.2D, 0.88D);
		bmodel.AddBox(0.22D, 0.2D, 0.22D, 0.77D, 0.25D, 0.77D);
		bmodel.AddBox(0.11D, 0.25D, 0.11D, 0.88D, 0.6D, 0.88D);
		bmodel.AddBox(0.22D, 0.6D, 0.22D,0.77D, 0.65D, 0.77D);
		bmodel.AddBox(0.11D, 0.65D, 0.11D, 0.88D, 0.7D, 0.88D);
		bmodel.AddBox(0.45D, 0.7D, 0.45D, 0.55D, 0.85D, 0.55D);
	}
	public void
	registerIcons(IconRegister reg){
		blockIcon = reg.registerIcon(iconname);
	}
	public void
	getSubBlocks(int id, CreativeTabs ct, List ret){
		for(int i =0;i<recipes.length;++i){
			ret.add(new ItemStack(id, 1, i));
		}
	}

	 /**
	  * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	  */
	 public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4)
	 {
		  return FCUtilsWorld.DoesBlockHaveLargeCenterHardpointToFacing(var1, var2, var3 - 1, var4, 1, true) && var1.getBlockId(var2, var3 - 1, var4) != Block.leaves.blockID;
	 }
	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}
	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
		return true;
	}
	public boolean RenderBlock(RenderBlocks var1, int var2, int var3, int var4){
		return this.bmodel.RenderAsBlockWithTexture(var1, this, var2, var3, var4, this.blockIcon);
	}
	public void RenderBlockAsItem(RenderBlocks var1, int var2, float var3){
		this.bmodel.RenderAsItemBlock(var1, this, var2);
	}
	public int
	quantityDropped(Random rn){
		return 1;
	}
	public int
	idDropped(int md, Random rn, int x){
		return recipes.length>md?recipes[md]:0;
	}

	public Icon getIcon(int a, int md){
		return blockIcon;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
		return AxisAlignedBB.getAABBPool().getAABB(0.11D, 0.0D, 0.11D, 0.88D, 0.7D, 0.88D);
	}
	public AxisAlignedBB GetBlockBoundsFromPoolBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
		return AxisAlignedBB.getAABBPool().getAABB(0.11D, 0.0D, 0.11D, 0.88D, 0.7D, 0.88D);
	}
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
		return AxisAlignedBB.getAABBPool().getAABB((double)var2 + 0.11D,(double)var3 + 0.0D,(double)var4 + 0.11D,(double)var2 + 0.88D,(double)var3 + 0.7D,(double)var4 + 0.88D);

	}
	 public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
	 {
		  if (!FCUtilsWorld.DoesBlockHaveLargeCenterHardpointToFacing(var1, var2, var3 - 1, var4, 1, true))
		  {
				this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
				var1.setBlockWithNotify(var2, var3, var4, 0);
		  }
	 }
	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int md, float fc, int ft){
		super.dropBlockAsItemWithChance(world, i, j, k, md, fc, ft);
		if(!world.isRemote && ckd){
			FCUtilsItem.EjectStackWithRandomOffset(world,i,j,k,new ItemStack(VIPKilns.pkItemPotteryShards, 6));
		}
	}

}
