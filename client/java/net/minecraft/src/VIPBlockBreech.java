package net.minecraft.src;

import java.util.Random;

public class VIPBlockBreech extends Block {
	public VIPBlockBreech(int bid){
		super(bid, Material.wood);
		SetShovelsEffectiveOn();
		setTickRandomly(true);
		this.setHardness(1.25F);
		this.setResistance(3.33F);
	}
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par5Entity.attackEntityFrom(DamageSource.inFire, 1);
	}
	public void RandomUpdateTick(World world, int i, int j, int k,Random rn){
		super.RandomUpdateTick(world,i,j,k,rn);
		if(!world.isRemote){
			EntitySmallFireball ent = (EntitySmallFireball)EntityList.createEntityOfType(EntitySmallFireball.class, world, (double) (i + rn.nextInt(2) - 1) , (double)( j + rn.nextInt(2) - 1), (double) (k + rn.nextInt(2) -1), rn.nextGaussian(), rn.nextGaussian(), rn.nextGaussian());
			world.spawnEntityInWorld(ent);
			if(rn.nextInt(100) > 60){
				world.setBlockAndMetadataWithNotify(i,j,k, Block.fire.blockID, 0);
			}
		}
	}
	public int
	idDropped(int md, Random rn, int x){
		return 0;
	}
}
