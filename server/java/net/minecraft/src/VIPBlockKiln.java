package net.minecraft.src;

public class VIPBlockKiln extends BlockContainer {

	private String texture;
	private String texture2;
	public Boolean ignited;
	public int efficiency;

	private int litBid;
	private int unlitBid;
	private int maxfuel;
	public VIPBlockKiln(int id, String tex, String tex2, Boolean ign, int eff,int mfuel){
		super(id, Material.rock);
		texture = tex;
		texture2 = tex2;
		ignited = ign;
		if(ign)
			this.setLightValue(1F);
		else
			this.setLightValue(0F);
		efficiency = eff;
		maxfuel = mfuel;
		this.setHardness(1.25F);
		this.setResistance(3.33F);
	}
	

	public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
		return true;
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


	public void setLitBid(int n){
		litBid = n;
	}
	public void setUnlitBid(int n){
		unlitBid = n;
	}
	public int getLitBid(){
		return litBid;
	}
	public int getUnlitBid(){
		return unlitBid;
	}

	public boolean GetCanBeSetOnFireDirectly(IBlockAccess var1, int var2, int var3, int var4)
	{
		if (!this.ignited)
		{
			VIPTileEntityKiln var5 = (VIPTileEntityKiln)var1.getBlockTileEntity(var2, var3, var4);

			if (var5.GetVisualFuelLevel() > 0)
			{
				return true;
			}
		}

		return false;
	}

	public boolean SetOnFireDirectly(World var1, int var2, int var3, int var4)
	{
		if (!this.ignited)
		{
			VIPTileEntityKiln var5 = (VIPTileEntityKiln)var1.getBlockTileEntity(var2, var3, var4);

			if (var5.AttemptToLight())
			{
				var1.playSoundEffect((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "mob.ghast.fireball", 1.0F, var1.rand.nextFloat() * 0.4F + 0.8F);
				return true;
			}
		}

		return false;
	}
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 */
	public TileEntity createNewTileEntity(World var1)
	{
		VIPTileEntityKiln ret = new VIPTileEntityKiln();
		ret.setlitid(litBid);
		ret.setunlitid(unlitBid);
		ret.setefficiency(efficiency);
		return ret;
	}
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack) {

		if(this.ignited){
			par1World.setBlock(par2,par3,par4, this.getUnlitBid());
		}
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xOffset, float yOffset, float zOffset){
		if(!world.isRemote){
			VIPTileEntityKiln kiln = (VIPTileEntityKiln)world.getBlockTileEntity(x,y,z);
			ItemStack is = player.getHeldItem();
			if(kiln != null && is != null){
				if(is.getItem().GetFurnaceBurnTime(is.getItemDamage()) > 0 && kiln.GetVisualFuelLevel() < maxfuel){
					kiln.addFuel(is.getItem().GetFurnaceBurnTime(is.getItemDamage()));
					is.splitStack(1);
					return true;
				}
			}

		}
		return false;

	}
	 /**
	  * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	  */
	 public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4)
	 {
		  return FCUtilsWorld.DoesBlockHaveLargeCenterHardpointToFacing(var1, var2, var3 - 1, var4, 1, true) && var1.getBlockId(var2, var3 - 1, var4) != Block.leaves.blockID;
	 }

}
