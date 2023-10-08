package me.tallonscze.miningdimension.poi;

import com.google.common.collect.ImmutableSet;
import me.tallonscze.miningdimension.Miningdimension;
import me.tallonscze.miningdimension.block.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Miningdimension.MODID);

    public static final RegistryObject<PoiType> MINING_PORTAL =
            POI.register("mining_portal", () -> new PoiType(
                    ImmutableSet.copyOf(ModBlocks.MINING_PORTAL.get().getStateDefinition().getPossibleStates())
                    , 0, 1));

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
