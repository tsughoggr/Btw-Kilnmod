package net.minecraft.src;

public class VIPItemFoodDamageable extends FCItemFood {
	public VIPItemFoodDamageable(int id, int fv, float sat,boolean wolf, String in, boolean zomb, int mx){
		super(id, fv, sat, wolf, in, zomb);
		this.setMaxStackSize(1);
		this.setMaxDamage(mx);
	}
	public ItemStack onEaten(ItemStack is, World world, EntityPlayer player){
		int id = is.getItemDamage();
		if(++id > this.getMaxDamage()){
			--is.stackSize;
		} else {
			is.setItemDamage(id);
		}
		player.getFoodStats().addStats(this);
		world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(is, world, player);
		
		return is;
	}
}
