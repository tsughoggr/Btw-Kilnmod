package net.minecraft.src;

import java.util.Random;

public class VIPBlockDropsCharcoal extends Block {
	private String[] iconnames = new String[2];
	private Icon[] blockIcons = new Icon[2];
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
	public void
	registerIcons(IconRegister ir){
		blockIcons[0] = ir.registerIcon(iconnames[0]);
		blockIcons[1] = ir.registerIcon(iconnames[1]);
	}
	public Icon
	getIcon(int fc, int md){
		int var3 = md & 12;
		return var3 == 0 && (fc == 1 || fc == 0) ? blockIcons[0] : (var3 == 4 && (fc == 5 || fc == 4) ? blockIcons[0] : (var3 == 8 && (fc == 2 || fc == 3) ? blockIcons[0] : blockIcons[1]));
	}

}
