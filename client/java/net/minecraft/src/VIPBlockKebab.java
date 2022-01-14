package net.minecraft.src;

import java.util.Random;
import java.util.List;

public class VIPBlockKebab extends Block {
	private Icon[] iconArray = new Icon[3];
	private int cooked;
	public VIPBlockKebab(int id, int ckd){
		super(id, Material.circuits);
		cooked = ckd;
	}
	public Icon
	getIcon(int md, int b){
		return iconArray[2];
	}
	public void
	registerIcons(IconRegister reg){
		iconArray[0] = reg.registerIcon("wood");
		iconArray[1] = reg.registerIcon("pkBlockKebabInner");
		iconArray[2] = reg.registerIcon("pkBlockKebabOuter");
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
	public boolean RenderBlock(RenderBlocks var1, int var2, int var3, int var4){
		int meatstg = (var1.blockAccess.getBlockMetadata(var2, var3, var4) & 12) >> 2;
		int rot = var1.blockAccess.getBlockMetadata(var2, var3, var4) & 3;

		FCModelBlock models[] = new FCModelBlock[3];
		models[0] = new FCModelBlock();
		models[1] = new FCModelBlock();
		models[2] = new FCModelBlock();

		models[0].AddBox(0.45D, 0D, .45D, .55D, 1.0D, .55D);
		models[1].AddBox(0.4D, 0.05D, 0.4D, .45D, .95D, .6D);
		models[1].AddBox( .45D, .05D, .4D ,.6D ,.95D ,.45D );
		models[1].AddBox( .55D, .05D, .45D, .6D, .95D, .6D);
		models[1].AddBox(.45D, .05D, .55D, .6D, .95D, .6D);

		switch(rot){
			case 0:
			switch(meatstg){
				case 3:
					models[2].AddBox(0.3D, 0.05D, 0.4D, .4D, .95D, .6D);
				case 2:
					models[2].AddBox( .4D, .05D, .3D ,.6D ,.95D ,.4D );
				case 1:
					models[2].AddBox( .6D, .05D, .4D, .7D, .95D, .6D);
				case 0:
					models[2].AddBox(.4D, .05D, .6D, .6D, .95D, .7D);
			}
			break;
			case 1:
			switch(meatstg){
				case 3:
					models[2].AddBox(.4D, .05D, .6D, .6D, .95D, .7D);
				case 2:
					models[2].AddBox(0.3D, 0.05D, 0.4D, .4D, .95D, .6D);
				case 1:
					models[2].AddBox( .4D, .05D, .3D ,.6D ,.95D ,.4D );
				case 0:
					models[2].AddBox( .6D, .05D, .4D, .7D, .95D, .6D);
			}
			break;
			case 2:
			switch(meatstg){
				case 3:
					models[2].AddBox( .6D, .05D, .4D, .7D, .95D, .6D);
				case 2:
					models[2].AddBox(.4D, .05D, .6D, .6D, .95D, .7D);
				case 1:
					models[2].AddBox(0.3D, 0.05D, 0.4D, .4D, .95D, .6D);
				case 0:
					models[2].AddBox( .4D, .05D, .3D ,.6D ,.95D ,.4D );

			}
			break;
			default:
			switch(meatstg){
				case 3:
					models[2].AddBox( .4D, .05D, .3D ,.6D ,.95D ,.4D );
				case 2:
					models[2].AddBox( .6D, .05D, .4D, .7D, .95D, .6D);
				case 1:
					models[2].AddBox(.4D, .05D, .6D, .6D, .95D, .7D);
				case 0:
					models[2].AddBox(0.3D, 0.05D, 0.4D, .4D, .95D, .6D);

			}
	
		}


	

		models[0].RenderAsBlockWithTexture(var1, this, var2, var3, var4, this.iconArray[0]);
		models[1].RenderAsBlockWithTexture(var1, this, var2, var3, var4, this.iconArray[1]);
		models[2].RenderAsBlockWithTexture(var1, this, var2, var3, var4, (cooked == 1)?this.iconArray[2]:this.iconArray[1]);

		return true;
		

	}
	public void RenderBlockAsItem(RenderBlocks var1, int var2, float var3){
		FCModelBlock models[] = new FCModelBlock[3];
		models[0] = new FCModelBlock();
		models[1] = new FCModelBlock();
		models[2] = new FCModelBlock();
		models[0].AddBox(0.45D, 0D, .45D, .55D, 1.0D, .55D);
		models[1].AddBox(0.4D, 0.05D, 0.4D, .45D, .95D, .6D);
		models[1].AddBox( .45D, .05D, .4D ,.6D ,.95D ,.45D );
		models[1].AddBox( .55D, .05D, .45D, .6D, .95D, .6D);
		models[1].AddBox(.45D, .05D, .55D, .6D, .95D, .6D);
		models[2].AddBox(0.3D, 0.05D, 0.3D, .4D, .95D, .7D);
		models[2].AddBox( .4D, .05D, .3D ,.7D ,.95D ,.4D );
		models[2].AddBox( .6D, .05D, .4D, .7D, .95D, .7D);
		models[2].AddBox(.4D, .05D, .6D, .7D, .95D, .7D);

		models[0].RenderAsItemBlock(var1, this, var2);
		models[1].RenderAsItemBlock(var1, this, var2);
		models[2].RenderAsItemBlock(var1, this, var2);
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
