package me.tallonscze.miningdimension.item;

import me.tallonscze.miningdimension.Miningdimension;
import me.tallonscze.miningdimension.item.custom.PortalCatalysts;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Miningdimension.MODID);

    public static final RegistryObject<Item> PORTAL_STAFF = ITEMS.register("portalstaff", PortalCatalysts::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
