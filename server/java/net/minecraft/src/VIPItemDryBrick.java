package net.minecraft.src;

public class VIPItemDryBrick extends FCItemPlacesAsBlock{
	private int packamnt;
	private int packreslt;

	public VIPItemDryBrick(int id, int pid, int md, String uln, int pa, int pbid){
		super(id, pid, md , uln);
		packamnt = pa;
		packreslt = pbid;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public boolean
	IsPistonPackable(ItemStack var1){
		return true;
	}
	public int 
	GetRequiredItemCountToPistonPack(ItemStack var1)
	{
		return packamnt;
	}

	public int 
	GetResultingBlockIDOnPistonPack(ItemStack var1)
	{
		return packreslt;
	}

}
