package me.tallonscze.miningdimension.block;

import me.tallonscze.miningdimension.Miningdimension;
import me.tallonscze.miningdimension.block.custom.PortalFrame;
import me.tallonscze.miningdimension.item.MiningCreativeTab;
import me.tallonscze.miningdimension.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Miningdimension.MODID);

    public static final RegistryObject<Block> PORTAL_FRAME = registerBlock("portalframe",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .destroyTime(5f)
                    .explosionResistance(3f)
                    .strength(6f).lightLevel((state) -> 14)
                    .requiresCorrectToolForDrops()), MiningCreativeTab.MINING_TAB);

    public static final RegistryObject<Block> TRUE_STONE = registerBlock("true_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .destroyTime(2f)

                    .requiresCorrectToolForDrops()), MiningCreativeTab.MINING_TAB);

    public static final RegistryObject<Block> GOLD_GRAVEL = registerBlock("gravel_gold",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                            ), MiningCreativeTab.MINING_TAB);

    public static final RegistryObject<Block> TRUE_STONE_BRICK = registerBlock("true_stone_brick",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .destroyTime(4f)
                    .requiresCorrectToolForDrops()), MiningCreativeTab.MINING_TAB);
    public static final RegistryObject<Block> TRUE_STONE_COBBLE = registerBlock("true_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .destroyTime(4f)
                    .requiresCorrectToolForDrops()), MiningCreativeTab.MINING_TAB);

    public static final RegistryObject<Block> COMPRESS_COPPER_BLOCK = registerBlock("compress_copper_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .destroyTime(50f)
                    .explosionResistance(2f)
                    .strength(50f)
                    .requiresCorrectToolForDrops()), MiningCreativeTab.MINING_TAB);
    public static final RegistryObject<Block> DOUBLE_COMPRESS_COPPER_BLOCK = registerBlock("double_compress_copper_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .destroyTime(70f)
                    .explosionResistance(2f)
                    .strength(70f)
                    .requiresCorrectToolForDrops()), MiningCreativeTab.MINING_TAB);

    public static final RegistryObject<Block> TRIPLE_COMPRESS_COPPER_BLOCK = registerBlock("triple_compress_copper_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .destroyTime(90f)
                    .explosionResistance(2f)
                    .strength(90f)
                    .requiresCorrectToolForDrops()), MiningCreativeTab.MINING_TAB);
    public static final RegistryObject<Block> COMPRESS_GLOWSTONE = registerBlock("compress_glowstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).lightLevel((state) -> 16).destroyTime(16f)), MiningCreativeTab.MINING_TAB);
    public static final RegistryObject<Block> DOUBLE_COMPRESS_GLOWSTONE = registerBlock("double_compress_glowstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).lightLevel((state) -> 18).destroyTime(20f)), MiningCreativeTab.MINING_TAB);
    public static final RegistryObject<Block> TRIPLE_COMPRESS_GLOWSTONE = registerBlock("triple_compress_glowstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).lightLevel((state) -> 20).destroyTime(24f)), MiningCreativeTab.MINING_TAB);

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).lightLevel((state) -> 20).destroyTime(24f)), MiningCreativeTab.MINING_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }



    public static final RegistryObject<Block> MINING_PORTAL = registerBlockWithoutBlockItem("mining_portal",
            PortalFrame::new);


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
