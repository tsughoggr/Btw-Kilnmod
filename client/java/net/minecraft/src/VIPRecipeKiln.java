package net.minecraft.src;

public class VIPRecipeKiln {
	public ItemStack input;
	public byte inptmdbm;
	public ItemStack output;
	public boolean outputblock;
	public boolean occmode;
	public int heat;
	public int res;
	public int eff;




	public 
	VIPRecipeKiln(ItemStack inpt, ItemStack outpt, boolean blockmode, int ht, int rs, int efc){
		input = inpt;
		output = outpt;
		outputblock = blockmode;
		occmode = false;
		heat = ht;
		res = rs;
		eff = efc;
	}
	public
	VIPRecipeKiln(ItemStack inpt, int imd, ItemStack outpt, boolean bmd, boolean omd, int ht, int rs, int efc){
		input = inpt;
		output = outpt;
		outputblock = bmd;
		inptmdbm = (byte)imd;
		occmode = omd;
		heat = ht;
		res = rs;
		eff = efc;
	}
	public boolean
	MatchRecipe(ItemStack is){
		return (is.itemID == input.itemID && (is.getItemDamage() & inptmdbm) == (input.getItemDamage() & inptmdbm));
	}

	public int
	processRecipe(World world, int x, int y, int z, int md, int clh){
		if(clh < heat)
			return 0;
		if(outputblock && !occmode){
			world.setBlockAndMetadataWithNotify(x,y,z,output.itemID, (output.getItemDamage() & inptmdbm) | (md & (~inptmdbm)) );
		} else if ( occmode){
			Block.blocksList[input.itemID].OnCookedByKiln(world, x, y, z);
		} else {
			FCUtilsItem.EjectStackWithRandomOffset(world,x,y,z, output);
		}



		return (heat / (((eff==0)?1:eff) * ((res ==0)?1:res)));
	}

}
