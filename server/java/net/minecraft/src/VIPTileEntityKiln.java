package net.minecraft.src;

import java.util.*;
import java.util.stream.IntStream;

public class VIPTileEntityKiln extends TileEntity{


	int fuel;
	/* BID when last heated + Heat level*/
	/* If the cube is bigger than this it will just infinitely transfer heat out*/


	int radius;

	int ignition;

	int heat;

	int litid;
	int unlitid;

	int sumresist;
	int sumefficiency;

	int efficiency;

	int timer;
	Random rn = new Random();

	boolean validmb;

	public void
	setefficiency(int ef){
		efficiency = ef;
	}
	public int
	GetVisualFuelLevel(){
		return fuel; 
	}
	public boolean
	AttemptToLight(){
		if(fuel < 8)
			return false;
		ignite();
		return true;
	}
	public void
	addFuel(int bt){
		fuel += bt;
	}
	public void
	setlitid(int id){
		litid =id;
	}
	public void
	setunlitid(int id){
		unlitid = id;
	}
	public void
	setFuel(int fl){
		fuel = fl;
	}
	public void
	setIgnition(int in){
		ignition = in;
	}

	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		fuel = nbt.getInteger("fuel");
		ignition = nbt.getInteger("ignition");
		heat = nbt.getInteger("heat");
		litid = nbt.getInteger("litid");
		unlitid = nbt.getInteger("unlitid");
		efficiency = nbt.getInteger("efficiency");
		radius = nbt.getInteger("radius");
		sumefficiency = nbt.getInteger("sumefficiency");
		sumresist = nbt.getInteger("sumresist");
		validmb = false;
		rn = new Random();


	}
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setInteger("fuel", fuel);
		nbt.setInteger("heat", heat);
		nbt.setInteger("ignition", ignition);
		nbt.setInteger("unlitid", unlitid);
		nbt.setInteger("litid", litid);
		nbt.setInteger("efficiency", efficiency);
		nbt.setInteger("radius", radius);
		nbt.setInteger("sumefficiency", sumefficiency);
		nbt.setInteger("sumresist", sumresist);
	}

	public void
	debugFuel(){
		System.out.println(fuel);
	}
	public void
	debugHeat(){
		System.out.println(heat);
	}
	public void
	debugmb(){
		System.out.println( validmb + " rad " + radius);
	}
	public void
	setHeat(int ht){
		heat = ht;
	}
	public void
	ignite(){
		int md = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		worldObj.setBlockAndMetadataWithNotify(xCoord, yCoord, zCoord, litid, md);
		((VIPTileEntityKiln)worldObj.getBlockTileEntity(xCoord, yCoord, zCoord)).setFuel(fuel);
		((VIPTileEntityKiln)worldObj.getBlockTileEntity(xCoord, yCoord, zCoord)).setIgnition(1);
		((VIPTileEntityKiln)worldObj.getBlockTileEntity(xCoord, yCoord, zCoord)).setHeat(heat);


	}
	public void
	extinguish(){
		processrecipes();
		int md = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		worldObj.setBlockAndMetadataWithNotify(xCoord, yCoord, zCoord, unlitid, md);
		((VIPTileEntityKiln)worldObj.getBlockTileEntity(xCoord, yCoord, zCoord)).setFuel(fuel);
		((VIPTileEntityKiln)worldObj.getBlockTileEntity(xCoord, yCoord, zCoord)).setIgnition(0);
		((VIPTileEntityKiln)worldObj.getBlockTileEntity(xCoord, yCoord, zCoord)).setHeat(heat);


	}

	private void
	validatemb(){
		VIPRecipeKiln rec;
		int i,j,k,l, iv;
		sumresist = sumefficiency = 1; /*Negligibile and avoids DBZ*/
		for(iv=0,i=0; i<4 ;++i){
			for(j=-i;j<=i;++j){
				for(k=-i;k<=i;++k){
					for(l=-1;l<i;++l){
						int md = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
						rec = VIPCraftingManagerPrimitiveKiln.getInstance().findMatchingRecipe(worldObj.getBlockId(xCoord + j, yCoord + l, zCoord + k), md);
						if(rec == null){
							iv=1;
							break;
						}
						else   {
							sumresist += rec.res;
							sumefficiency += rec.eff;
						}
					}
				}
			}
			if(iv!=0){
				--i;
				break;
			}
		}
		if(i!=0){
			validmb = true;
			radius = i;
		}
	}
	public int
	getRadius(){
		return radius;
	}
	public int
	getCLH(){
		return (heat - ( (4 * heat) / sumresist)) + (int)((heat/sumresist) * Math.log(1 + Math.abs(efficiency * sumefficiency * heat) / sumresist)); 
	}
	private void
	processrecipes(){
		VIPRecipeKiln rec;
		int i;
		int[] ja;
		int[] ka;
		int[] la;

		int clh; /*Current Local Heat*/
		clh = (heat - ( (4 * heat) / sumresist)) + (int)((heat/sumresist) * Math.log(1 + Math.abs(efficiency * sumefficiency * heat) / sumresist));
		for(i=0;i<=radius;++i){

			ja = IntStream.rangeClosed(-i,i).toArray();
			ka = IntStream.rangeClosed(-i,i).toArray();
			la = IntStream.rangeClosed(-1,i).toArray();
			Collections.shuffle(Arrays.asList(ja));
			Collections.shuffle(Arrays.asList(ka));
			Collections.shuffle(Arrays.asList(la));
			for(int j : ja ){
				for(int k : ka){
					for(int l : la){
						int md = worldObj.getBlockMetadata(xCoord +j, yCoord +l, zCoord +k);
						rec = VIPCraftingManagerPrimitiveKiln.getInstance().findMatchingRecipe(worldObj.getBlockId(xCoord + j, yCoord + l, zCoord + k), md);
						if(rec != null){
							heat -= rec.processRecipe(worldObj, xCoord + j, yCoord + l , zCoord + k, md, clh);
						} 

					}
				}
			}
		}
		worldObj.setBlockMetadata(xCoord,yCoord,zCoord, ((heat / 800) > 15)?15:(heat/800));
	}
	public void
	updateEntity(){
		if(worldObj.isRemote)return;
		++timer;

		if((timer % 20 == 0 )){
			if(ignition != 0){
				fuel -= 20;
				if(validmb){
					heat += ((20 * efficiency)/100);
				}
				else {
					int x,y,z;
					x = xCoord + (rn.nextInt(5) - 2);
					y = yCoord + rn.nextInt(2);
					z = zCoord + (rn.nextInt(5) - 2);
					if(worldObj.getBlockId(x,y,z) == 0){
						worldObj.setBlock(x,y,z,Block.fire.blockID);
					}
				}
				if(timer%200 == 0){
					validatemb();
				}
				if(timer%2000 == 0){
					processrecipes();
				}
				if(fuel < 1){
					ignition = 0;
					extinguish();
				}
			} else {
				heat -= efficiency;
				if(heat < 0)
					heat = 0;
				if(fuel<0)
					fuel = 0;
				if(heat > 500){
					int x,y,z;
					x = xCoord + (rn.nextInt(5) - 2);
					y = yCoord + rn.nextInt(2);
					z = zCoord + (rn.nextInt(5) - 2);
					if(worldObj.getBlockId(x,y,z) == 0){
						worldObj.setBlock(x,y,z,Block.fire.blockID);
					}
					if((timer % 200) == 0){
						worldObj.setBlockMetadata(xCoord,yCoord,zCoord, ((heat / 800) > 15)?15:(heat/800));
					}
				}
			}

		}

	}
}
