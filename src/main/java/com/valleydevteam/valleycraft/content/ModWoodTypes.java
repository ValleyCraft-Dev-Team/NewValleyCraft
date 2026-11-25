package com.valleydevteam.valleycraft.content;

import net.minecraft.world.level.block.state.properties.WoodType;

import static net.minecraft.world.level.block.state.properties.WoodType.register;

public interface ModWoodTypes {
    WoodType APPLEWOOD = register(new WoodType("applewood", ModBlockSetTypes.APPLEWOOD));
}
