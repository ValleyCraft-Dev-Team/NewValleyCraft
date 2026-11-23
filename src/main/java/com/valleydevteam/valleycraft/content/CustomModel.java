package com.valleydevteam.valleycraft.content;

/** Enum for {@link ModBlocks} to determine whether it uses custom model or Data-gen. */
public enum CustomModel {
    /** Both block and item will use data-gen */
    none,
    /** Block to use custom model and item use data-gen */
    block,
    /** Item to use custom model and block use data-gen */
    item,
    /** Both block and item will use custom model */
    both;

    public boolean block() {
        return this == both || this == block;
    }

    public boolean item() {
        return this == both || this == item;
    }
}
