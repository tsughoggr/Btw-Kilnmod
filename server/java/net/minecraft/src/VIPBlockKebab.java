package net.minecraft.src;

import java.util.Random;
import java.util.List;

public class VIPBlockKebab extends Block {
	private int cooked;
	public VIPBlockKebab(int id, int ckd){
		super(id, Material.circuits);
		cooked = ckd;
	}

	public void
	getSubBlocks(int id, CreativeTabs ct, List ret){
		for(int i =0;i<16;++i){
			ret.add(new ItemStack(id, 1, i));
		}
	}
	public boolean CanRotateOnTurntable(IBlockAccess ba, int i, int j, int k){
		return true;
	}
	public int
	RotateOnTurntable(World world, int x, int y, int z, boolean rev, int tcc){
		int md = world.getBlockMetadata(x,y,z);
		if(rev){
			world.setBlockMetadataWithNotify(x,y,z, (md & 12) | ((md & 3)-1) & 3);
		} else {
			world.setBlockMetadataWithNotify(x,y,z, (md & 12) | ((md&3)+1)&3);
		}
		return 0;
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

	 public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
	 {
		  if (!FCUtilsWorld.DoesBlockHaveLargeCenterHardpointToFacing(var1, var2, var3 - 1, var4, 1, true))
		  {
				this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
				var1.setBlockWithNotify(var2, var3, var4, 0);
		  }
	 }
	public int
	damageDropped(int md){
		return md;
	}
	public int
	idDropped(int md, Random rn, int x){
		int stg = (md&12) >> 2;
		return stg<3?this.blockID:FCBetterThanWolves.fcBlockAxle.blockID;
	}
	public int GetFacing(int md){
		return md &3;
	}
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
		return AxisAlignedBB.getAABBPool().getAABB(0.3D, 0.0D, 0.3D, 1D, 0.9D, 0.7D);
	}
	public AxisAlignedBB GetBlockBoundsFromPoolBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
		return AxisAlignedBB.getAABBPool().getAABB(0.3D, 0.0D, 0.3D, 1D, 0.9D, 0.7D);
	}
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
		return AxisAlignedBB.getAABBPool().getAABB((double)var2 + 0.3D,(double)var3 + 0.0D,(double)var4 + 0.3D,(double)var2 + 0.7D,(double)var3 + 1D,(double)var4 + 0.7D);

	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xOffset, float yOffset, float zOffset){
		if(cooked == 0) return false;
		if(world.isRemote)return true;
		int md = world.getBlockMetadata(x,y,z);
		int meatstg = (md&12)>>2;

		if(player.getHeldItem() != null && Item.itemsList[player.getHeldItem().itemID] instanceof ItemSword){
			FCUtilsItem.EjectStackWithRandomOffset(world,x,y,z,new ItemStack(VIPKilns.pkItemDonner, 3));
			player.getHeldItem().setItemDamage(player.getHeldItem().getItemDamage()+1);
			if(--meatstg < 0){
				FCUtilsItem.EjectStackWithRandomOffset(world,x,y,z,new ItemStack(FCBetterThanWolves.fcBlockAxle));
				world.setBlockToAir(x,y,z);
			} else {
				world.setBlockMetadataWithNotify(x,y,z, (meatstg<<2) | (md&3) );
			}

		}
		return true;
	}
}
