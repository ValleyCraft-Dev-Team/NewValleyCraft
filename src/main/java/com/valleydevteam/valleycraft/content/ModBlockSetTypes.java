package com.valleydevteam.valleycraft.content;

import net.minecraft.world.level.block.state.properties.BlockSetType;

import static net.minecraft.world.level.block.state.properties.BlockSetType.register;

public interface ModBlockSetTypes {
    BlockSetType APPLEWOOD = register(new BlockSetType("vc_applewood"));
}
