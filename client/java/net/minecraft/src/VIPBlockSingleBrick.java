package net.minecraft.src;

import java.util.Random;

public class VIPBlockSingleBrick extends FCBlockCookedBrick{
	public VIPBlockSingleBrick(int id){
		super(id);
	}
	public int
	idDropped(int md, Random rn, int ft){
		return this.blockID;
	}
	
}
