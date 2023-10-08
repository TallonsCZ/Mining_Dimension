package me.tallonscze.miningdimension.item;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MiningCreativeTab {
    public static final CreativeModeTab MINING_TAB = new CreativeModeTab("mining_dimension") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PORTAL_STAFF.get());
        }
    };
}
