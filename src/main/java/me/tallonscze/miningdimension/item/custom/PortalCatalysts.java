package me.tallonscze.miningdimension.item.custom;

import me.tallonscze.miningdimension.block.ModBlocks;
import me.tallonscze.miningdimension.block.custom.PortalFrame;
import me.tallonscze.miningdimension.dimension.Dimension;
import me.tallonscze.miningdimension.item.MiningCreativeTab;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


public class PortalCatalysts extends Item{
    public PortalCatalysts() {
        super(new Properties()
                .tab(MiningCreativeTab.MINING_TAB)
                .stacksTo(1)
                .rarity(Rarity.RARE)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            if(context.getPlayer().level.dimension() == Dimension.MINING_KEY
                    || context.getPlayer().level.dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((PortalFrame) ModBlocks.MINING_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
