package net.minecraft.src;

import java.util.Random;

public class VIPBlockDropsCharcoal extends Block {
	private String[] iconnames = new String[2];
	public VIPBlockDropsCharcoal(int id, String top, String side){
		super(id, Material.wood);
		iconnames[0] = top;
		iconnames[1] = side;
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.SetShovelsEffectiveOn();
		setHardness(.8F);
		setResistance(.5F);
		SetFireProperties(FCEnumFlammability.EXPLOSIVES);
	}
	public int
	quantityDropped(Random rn){
		return 1;
	}
	public int
	idDropped(int x, Random rn, int md){
		return Item.coal.itemID;
	}
	public int
	damageDropped(int in){
		return 1;
	}

}
