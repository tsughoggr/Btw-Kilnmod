package net.minecraft.src;

import java.util.List;
import java.util.ArrayList;

public class VIPCraftingManagerBrickDry {
	private static final VIPCraftingManagerBrickDry instance = new VIPCraftingManagerBrickDry();
	private ArrayList<int[]> recipes = new ArrayList();


	private VIPCraftingManagerBrickDry() {
		addRecipe(VIPKilns.pkBlockBrickStack.blockID, VIPKilns.pkBlockBrickStackDry.blockID, 18000);
	}
	public static final VIPCraftingManagerBrickDry getInstance() {
		return instance;
	}
	public int[] findMatchingRecipe(int mat){
		int[] tmp;
		int i;

		for(i=0;i<this.recipes.size();++i){
			tmp = recipes.get(i);
			if(tmp[0] == mat ){
				return tmp;
			}
		}
		return null;

	}
	
	
	void addRecipe(int src, int dst, int time){
		int[] a = {src, dst, time};
		recipes.add(a);
	}
	
}

