package net.minecraft.src;

public class VIPBlockBrickStack extends Block {
	private String iconname;
	private Icon bricktex;
	private Icon[] m_cookIcons;
	private int sourceitem;
	public VIPBlockBrickStack(int id, String in, int src){
		super(id, Material.circuits);
		iconname = in;
		sourceitem = src;
	}
	public void registerIcons(IconRegister var1)
	{
		this.m_cookIcons = new Icon[7];
		this.bricktex = var1.registerIcon(iconname);

		for (int var2 = 0; var2 < 7; ++var2)
		{
			this.m_cookIcons[var2] = var1.registerIcon("fcOverlayUnfiredBrick_" + (var2 + 1));
		}
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
	public boolean RenderBlock(RenderBlocks var1, int var2, int var3, int var4){
		FCModelBlock models[] = new FCModelBlock[1];
		int md = (var1.blockAccess.getBlockMetadata(var2, var3, var4) & 0xF) >> 2 ;

		models[0] = new FCModelBlock();
		models[0].AddBox(0.05D, 0.0D, 0.05D, 0.475D, 0.245D, 0.245D);
		models[0].AddBox(0.05D, 0.0D, 0.255D, 0.475D, 0.245D, 0.495D);
		models[0].AddBox(0.05D, 0.0D, 0.505D, 0.475D, 0.245D, 0.745D);
		models[0].AddBox(0.05D, 0.0D, 0.755D, 0.475D, 0.245D, 0.95D);

		models[0].AddBox(0.525D, 0.0D, 0.05D, 0.95D, 0.245D, 0.245D);
		models[0].AddBox(0.525D, 0.0D, 0.255D, 0.95D, 0.245D, 0.495D);
		models[0].AddBox(0.525D, 0.0D, 0.505D, 0.95D, 0.245D, 0.745D);
		models[0].AddBox(0.525D, 0.0D, 0.755D, 0.95D, 0.245D, 0.95D);
		switch(md){
			case 3:
				models[0].AddBox(0.05D, 0.75D, 0.05D, 0.245D, 0.995D, 0.475D);
				models[0].AddBox( 0.255D, 0.75D,0.05D, 0.495D,  0.995D,0.475D);
				models[0].AddBox(0.505D, 0.75D, 0.05D, 0.745D, 0.995D, 0.475D);
				models[0].AddBox(0.755D, 0.75D, 0.05D, 0.95D, 0.995D, 0.475D);
		
				models[0].AddBox(0.05D, 0.75D, 0.525D, 0.245D, 0.995D, 0.95D);
				models[0].AddBox( 0.255D, 0.75D,0.525D, 0.495D,  0.995D,0.95D);
				models[0].AddBox(0.505D, 0.75D, 0.525D, 0.745D, 0.995D, 0.95D);
				models[0].AddBox(0.755D, 0.75D, 0.525D, 0.95D, 0.995D, 0.95D);
			case 2:
				models[0].AddBox(0.05D, 0.5D, 0.05D, 0.475D, 0.745D, 0.245D);
				models[0].AddBox(0.05D, 0.5D, 0.255D, 0.475D, 0.745D, 0.495D);
				models[0].AddBox(0.05D, 0.5D, 0.505D, 0.475D, 0.745D, 0.745D);
				models[0].AddBox(0.05D, 0.5D, 0.755D, 0.475D, 0.745D, 0.95D);
		
				models[0].AddBox(0.525D, 0.5D, 0.05D, 0.95D, 0.745D, 0.245D);
				models[0].AddBox(0.525D, 0.5D, 0.255D, 0.95D, 0.745D, 0.495D);
				models[0].AddBox(0.525D, 0.5D, 0.505D, 0.95D, 0.745D, 0.745D);
				models[0].AddBox(0.525D, 0.5D, 0.755D, 0.95D, 0.745D, 0.95D);
			case 1:
				models[0].AddBox(0.05D, 0.25D, 0.05D, 0.245D, 0.495D, 0.475D);
				models[0].AddBox( 0.255D, 0.25D,0.05D, 0.495D,  0.495D,0.475D);
				models[0].AddBox(0.505D, 0.25D, 0.05D, 0.745D, 0.495D, 0.475D);
				models[0].AddBox(0.755D, 0.25D, 0.05D, 0.95D, 0.495D, 0.475D);
		
				models[0].AddBox(0.05D, 0.25D, 0.525D, 0.245D, 0.495D, 0.95D);
				models[0].AddBox( 0.255D, 0.25D,0.525D, 0.495D,  0.495D,0.95D);
				models[0].AddBox(0.505D, 0.25D, 0.525D, 0.745D, 0.495D, 0.95D);
				models[0].AddBox(0.755D, 0.25D, 0.525D, 0.95D, 0.495D, 0.95D);
			case 0:
				break;

		}
		models[0].RenderAsBlockWithTexture(var1, this, var2, var3, var4, bricktex);
 		return true;

	}
	public void RenderBlockAsItem(RenderBlocks var1, int var2, float var3){
		FCModelBlock models[] = new FCModelBlock[2];
		models[0] = new FCModelBlock();
		models[1] = new FCModelBlock();
		models[0].AddBox(0.05D, 0.0D, 0.05D, 0.45D, 0.245D, 0.245D);
		models[0].AddBox(0.05D, 0.0D, 0.255D, 0.45D, 0.245D, 0.495D);
		models[0].AddBox(0.05D, 0.0D, 0.505D, 0.45D, 0.245D, 0.745D);
		models[0].AddBox(0.05D, 0.0D, 0.755D, 0.45D, 0.245D, 0.95D);

		models[0].AddBox(0.55D, 0.0D, 0.05D, 0.95D, 0.245D, 0.245D);
		models[0].AddBox(0.55D, 0.0D, 0.255D, 0.95D, 0.245D, 0.495D);
		models[0].AddBox(0.55D, 0.0D, 0.505D, 0.95D, 0.245D, 0.745D);
		models[0].AddBox(0.55D, 0.0D, 0.755D, 0.95D, 0.245D, 0.95D);

		models[0].RenderAsItemBlock(var1, this, var2);
	}

	public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 var5, Vec3 var6){

		FCModelBlock models[] = new FCModelBlock[1];
		int md = (world.getBlockMetadata(x, y, z) & 0xF) >> 2 ;

		models[0] = new FCModelBlock();
		models[0].AddBox(0.05D, 0.0D, 0.05D, 0.475D, 0.245D, 0.245D);
		models[0].AddBox(0.05D, 0.0D, 0.255D, 0.475D, 0.245D, 0.495D);
		models[0].AddBox(0.05D, 0.0D, 0.505D, 0.475D, 0.245D, 0.745D);
		models[0].AddBox(0.05D, 0.0D, 0.755D, 0.475D, 0.245D, 0.95D);

		models[0].AddBox(0.525D, 0.0D, 0.05D, 0.95D, 0.245D, 0.245D);
		models[0].AddBox(0.525D, 0.0D, 0.255D, 0.95D, 0.245D, 0.495D);
		models[0].AddBox(0.525D, 0.0D, 0.505D, 0.95D, 0.245D, 0.745D);
		models[0].AddBox(0.525D, 0.0D, 0.755D, 0.95D, 0.245D, 0.95D);
		switch(md){
			case 3:
				models[0].AddBox(0.05D, 0.75D, 0.05D, 0.245D, 0.995D, 0.475D);
				models[0].AddBox( 0.255D, 0.75D,0.05D, 0.495D,  0.995D,0.475D);
				models[0].AddBox(0.505D, 0.75D, 0.05D, 0.745D, 0.995D, 0.475D);
				models[0].AddBox(0.755D, 0.75D, 0.05D, 0.95D, 0.995D, 0.475D);
		
				models[0].AddBox(0.05D, 0.75D, 0.525D, 0.245D, 0.995D, 0.95D);
				models[0].AddBox( 0.255D, 0.75D,0.525D, 0.495D,  0.995D,0.95D);
				models[0].AddBox(0.505D, 0.75D, 0.525D, 0.745D, 0.995D, 0.95D);
				models[0].AddBox(0.755D, 0.75D, 0.525D, 0.95D, 0.995D, 0.95D);
			case 2:
				models[0].AddBox(0.05D, 0.5D, 0.05D, 0.475D, 0.745D, 0.245D);
				models[0].AddBox(0.05D, 0.5D, 0.255D, 0.475D, 0.745D, 0.495D);
				models[0].AddBox(0.05D, 0.5D, 0.505D, 0.475D, 0.745D, 0.745D);
				models[0].AddBox(0.05D, 0.5D, 0.755D, 0.475D, 0.745D, 0.95D);
		
				models[0].AddBox(0.525D, 0.5D, 0.05D, 0.95D, 0.745D, 0.245D);
				models[0].AddBox(0.525D, 0.5D, 0.255D, 0.95D, 0.745D, 0.495D);
				models[0].AddBox(0.525D, 0.5D, 0.505D, 0.95D, 0.745D, 0.745D);
				models[0].AddBox(0.525D, 0.5D, 0.755D, 0.95D, 0.745D, 0.95D);
			case 1:
				models[0].AddBox(0.05D, 0.25D, 0.05D, 0.245D, 0.495D, 0.475D);
				models[0].AddBox( 0.255D, 0.25D,0.05D, 0.495D,  0.495D,0.475D);
				models[0].AddBox(0.505D, 0.25D, 0.05D, 0.745D, 0.495D, 0.475D);
				models[0].AddBox(0.755D, 0.25D, 0.05D, 0.95D, 0.495D, 0.475D);
		
				models[0].AddBox(0.05D, 0.25D, 0.525D, 0.245D, 0.495D, 0.95D);
				models[0].AddBox( 0.255D, 0.25D,0.525D, 0.495D,  0.495D,0.95D);
				models[0].AddBox(0.505D, 0.25D, 0.525D, 0.745D, 0.495D, 0.95D);
				models[0].AddBox(0.755D, 0.25D, 0.525D, 0.95D, 0.495D, 0.95D);
			case 0:
				break;

		}
		return models[0].CollisionRayTrace(world,x,y,z,var5,var6);

	
	}
	public Icon getIcon(int id, int md){
		return bricktex;
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var6, float var7, float var8, float var9){

		if (world.isRemote)return true;
		int mda = world.getBlockMetadata(x,y,z);
		int md = mda >> 2;

		if(player.getHeldItem() == null){
			FCUtilsItem.EjectStackWithRandomOffset(world,x,y,z,new ItemStack(sourceitem, 8, 0));
			if(md == 0)world.setBlock(x,y,z,0);
			else world.setBlockMetadata(x,y,z, (mda &3) | ((--md)<<2));
			return true;
		}
		if(md == 3) return false;

		if(player.getHeldItem() != null && player.getHeldItem().itemID == sourceitem && player.getHeldItem().stackSize >= 8){
			player.getHeldItem().splitStack(8);
			world.setBlockMetadata(x,y,z,(mda&3) | ((++md)<<2));

		}
		if(player.getHeldItem() != null && player.getHeldItem().itemID == this.blockID){
			player.getHeldItem().splitStack(1);
			world.setBlockMetadata(x,y,z,(mda&3) | ((++md)<<2));
  
		}
		return false;
	}
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World var1, int var2, int var3, int var4){
		int md = var1.getBlockMetadata(var2,var3,var4) >> 2;
		return AxisAlignedBB.getAABBPool().getAABB(0.0D, 0.0D, 0.0D ,1.0D,0.25D + (0.25D * md)  ,1.0D );

	}
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4){
		int md = var1.getBlockMetadata(var2,var3,var4) >> 2;
		return AxisAlignedBB.getAABBPool().getAABB((double)var2 + 0.0D, (double)var3 + 0.0D, (double)var4 + 0.0D ,(double)var2 + 1.0D,(double)var3 + 0.25D + (0.25D * md)  , (double)var4 + 1.0D );

	}
	public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
		return true;
	}
	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4)
	{
		return FCUtilsWorld.DoesBlockHaveLargeCenterHardpointToFacing(var1, var2, var3 - 1, var4, 1, true) && var1.getBlockId(var2, var3 - 1, var4) != Block.leaves.blockID;
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor blockID
	 */
	public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
	{
		if (!FCUtilsWorld.DoesBlockHaveLargeCenterHardpointToFacing(var1, var2, var3 - 1, var4, 1, true))
		{
			this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
			var1.setBlockWithNotify(var2, var3, var4, 0);
		}
	}

	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7){
		 if (!par1World.isRemote){
			int md = par5>>2;
			FCUtilsItem.EjectStackWithRandomOffset(par1World,par2,par3,par4,new ItemStack(sourceitem, 8 + (8 * md), 0));


		}
	}
	public void SetCookLevel(World world, int x, int y, int z, int md){
		int mda = world.getBlockMetadata(x,y,z);
		world.setBlockMetadataWithNotify(x,y,z,(mda & (3<<2))|(md&3));
	}
	public int GetCookLevel(World world, int x, int y, int z){
		return world.getBlockMetadata(x,y,z) &3;
	}
	public void RenderBlockSecondPass(RenderBlocks var1, int var2, int var3, int var4, boolean var5){
		if(var5){
			int md = var1.blockAccess.getBlockMetadata(var2, var3, var4) & 3;
			if(md > 0)
			this.RenderBlockWithTexture(var1, var2, var3, var4, this.m_cookIcons[((md - 1 ) * 2) + 1]);
		}
	}

}
