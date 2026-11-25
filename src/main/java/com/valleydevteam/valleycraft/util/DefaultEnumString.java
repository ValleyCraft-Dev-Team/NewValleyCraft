package com.valleydevteam.valleycraft.util;

import net.minecraft.util.StringRepresentable;

public interface DefaultEnumString extends StringRepresentable {
    @Override
    default String getSerializedName() {
        return ((Enum<?>)this).name();
    }
}
