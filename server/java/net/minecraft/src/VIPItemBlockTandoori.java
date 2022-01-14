package net.minecraft.src;

public class VIPItemBlockTandoori extends ItemBlock {

	public VIPItemBlockTandoori(int itemid){
		super(itemid);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	@Override
	public int getMetadata(int damage){
		return damage;
	}

}
