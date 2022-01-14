package net.minecraft.src;

public class VIPBlockKiln extends BlockContainer {

	private String texture;
	private String texture2;
	private Icon[] icons = new Icon[4];
	private Icon[] cookicons = new Icon[16];
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
	
	public void registerIcons(IconRegister var1)
	{
		this.blockIcon = var1.registerIcon(texture);
		icons[0] = var1.registerIcon(texture);
		icons[1] = var1.registerIcon(texture2);
		icons[2] = var1.registerIcon("fcBlockLogSmouldering");
		icons[3] = var1.registerIcon("fcOverlayLogEmbers");
		for(int i=0;i<16;++i){
			cookicons[i] = var1.registerIcon("fcOverlayCook_" + ((((i / 2) +1)>7 )?7:((i/2)+1)));
		}


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

	public boolean RenderBlock(RenderBlocks var1, int var2, int var3, int var4){
		FCModelBlock models[] = new FCModelBlock[4];
		FCModelBlock crackmdl = new FCModelBlock();
		int md = (var1.blockAccess.getBlockMetadata(var2, var3, var4) & 0xF) >> 2 ;
		models[0] = new FCModelBlock();
		models[1] = new FCModelBlock();
		models[2] = new FCModelBlock();
		models[3] = new FCModelBlock();
		models[0].AddBox(0D,0D,0D,1D,.5D,1D);
		models[1].AddBox(0D,.5D,0D, .33D, 1D,.33D);
		models[1].AddBox(.66D, .5D, 0D, 1D, 1D, .33D);
		models[1].AddBox(.66D, .5D, .66D, 1D, 1D, 1D);
		models[1].AddBox(0D, .5D, .66D, .33D, 1D, 1D);
		models[1].AddBox(0D, .75D, .33D, .25D, 1D, .66D);
		models[1].AddBox(.33D, .75D, 0D, .66D, 1D, .25D);
		models[1].AddBox(.75D, .75D, .33D, 1D, 1D, .66D);
		models[1].AddBox(.33D, .75D, .75D, .66D, 1D, 1D);
		models[2].AddBox(.35D, .50D, .35D, .64D, .75D + (0.05 * md), .64D);
		models[3].AddBox(.348D, .50D, .348D, .642D, .752D + (0.05 * md), .642D);
		crackmdl.AddBox(-.01D,-.01D,-.01D,1.01D,1.01D,1.01D); 
		models[0].RenderAsBlockWithTexture(var1, this, var2, var3, var4, icons[0]);
		models[1].RenderAsBlockWithTexture(var1, this, var2, var3, var4, icons[1]);
		models[2].RenderAsBlockWithTexture(var1, this, var2, var3, var4, icons[2]);
		if(this.ignited){
			models[3].RenderAsBlockWithTexture(var1, this, var2, var3, var4, icons[3]);
			crackmdl.RenderAsBlockWithTexture(var1, this, var2 , var3, var4, cookicons[md]);
			
		}

		return true;
	}
	public void RenderBlockAsItem(RenderBlocks var1, int var2, float var3){
		FCModelBlock models[] = new FCModelBlock[3];
		models[0] = new FCModelBlock();
		models[1] = new FCModelBlock();
		models[2] = new FCModelBlock();
		models[0].AddBox(0D,0D,0D,1D,.5D,1D);
		models[1].AddBox(0D,.5D,0D, .33D, 1D,.33D);
		models[1].AddBox(.66D, .5D, 0D, 1D, 1D, .33D);
		models[1].AddBox(.66D, .5D, .66D, 1D, 1D, 1D);
		models[1].AddBox(0D, .5D, .66D, .33D, 1D, 1D);
		models[1].AddBox(0D, .75D, .33D, .25D, 1D, .66D);
		models[1].AddBox(.33D, .75D, 0D, .66D, 1D, .25D);
		models[1].AddBox(.75D, .75D, .33D, 1D, 1D, .66D);
		models[1].AddBox(.33D, .75D, .75D, .66D, 1D, 1D);
		models[2].AddBox(.33D, .50D, .33D, .66D, .75D, .66D);

		models[0].RenderAsItemBlock(var1, this, var2);
		models[1].RenderAsItemBlock(var1, this, var2 );
		models[2].RenderAsItemBlock(var1, this, var2);

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
