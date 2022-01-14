package net.minecraft.src;

import java.util.Random;

public class VIPBlockBrickDry extends FCBlockCookedBrick{

	private int drop;
	public VIPBlockBrickDry(int id, int did){
		super(id);
		drop = did;
	}
	public VIPBlockBrickDry(int id){
		super(id);
	}

	public void
	setDrop(int id){
		drop = id;
	}
	public int
	idDropped(int var1, Random var2, int var3){
		return drop;
	}
}
