package me.tallonscze.miningdimension.dimension;

import me.tallonscze.miningdimension.Miningdimension;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class Dimension {
    public static final ResourceKey<Level> MINING_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(Miningdimension.MODID, "mining_dimension"));

    public static final ResourceKey<DimensionType> MINING_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, MINING_KEY.registry());

    public static void register() {
        System.out.println("Registring MiningDimension for " + Miningdimension.MODID);

    }
}
