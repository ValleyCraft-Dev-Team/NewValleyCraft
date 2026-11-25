package com.valleydevteam.valleycraft.content;

/** Enum for {@link ModBlocks} to determine whether it uses Custom Model or Data Generation. */
public enum ModelType {
    /** Both block and item will use data-gen but with manual input */
    manual,
    /** Both block and item will use data-gen */
    dataGen,
    /** Block to use custom model and item use data-gen */
    customBlock,
    /** Item to use custom model and block use data-gen */
    customItem,
    /** Both block and item will use custom model */
    bothCustom,
    cross,
    fullCube;

    public boolean autoGenBlock() {
        return this != manual && !customBlock();
    }

    public boolean autoGenItem() {
        return this != manual && !customItem();
    }

    public boolean dataGenBlock() {
        return !customBlock();
    }

    public boolean dataGenItem() {
        return !customItem();
    }

    public boolean customBlock() {
        return this == bothCustom || this == customBlock;
    }

    public boolean customItem() {
        return this == bothCustom || this == customItem;
    }
}
