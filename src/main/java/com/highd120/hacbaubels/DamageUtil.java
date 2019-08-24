package com.highd120.hacbaubels;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import baubles.api.BaublesApi;
import defeatedcrow.hac.core.util.DCUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class DamageUtil {

	private static List<ItemStack> handlerToList(IItemHandler handler) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		for (int i = 0; i < handler.getSlots(); i++) {
			list.add(handler.getStackInSlot(i));
		}
		return list;
	}

	public static float getResistant(Entity entity, boolean isCold) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			IItemHandler handler = BaublesApi.getBaublesHandler(player);
			List<ItemStack> list = handlerToList(handler);
			List<ItemStack> list1 = handlerToList(handler).stream()
					.filter(item -> !DCUtil.isEmpty(item))
					.collect(Collectors.toList());
			double damage = handlerToList(handler).stream()
					.filter(item -> !DCUtil.isEmpty(item))
					.mapToDouble(item -> {
						return DCUtil.getItemResistantData(item, false);
					})
					.sum();
			return (float) damage;
		}
		return 0;
	}

}
