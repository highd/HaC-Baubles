package com.highd120.hacbaubels;

import defeatedcrow.hac.api.damage.IMobHeatResistant;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CustomMobResistantRegister implements IMobHeatResistant {
	private IMobHeatResistant parent;

	public CustomMobResistantRegister(IMobHeatResistant parent) {
		this.parent = parent;
	}

	@Override
	public float getColdResistant(ResourceLocation name) {
		return parent.getColdResistant(name);
	}

	@Override
	public float getColdResistant(Entity entity) {
		float baublesResistant = DamageUtil.getResistant(entity, true);
		return parent.getColdResistant(entity) + baublesResistant;

	}

	@Override
	public float getHeatResistant(ResourceLocation name) {
		return parent.getHeatResistant(name);
	}

	@Override
	public float getHeatResistant(Entity entity) {
		float baublesResistant = DamageUtil.getResistant(entity, false);
		return parent.getHeatResistant(entity) + baublesResistant;
	}

	@Override
	public void registerEntityResistant(ResourceLocation name, float heat, float cold) {
		parent.registerEntityResistant(name, heat, cold);
	}

	@Override
	public void registerEntityResistant(Class<? extends Entity> entityClass, float heat, float cold) {
		parent.registerEntityResistant(entityClass, heat, cold);
	}

}
