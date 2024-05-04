package com.dolthhaven.bibliophile.core.mixin;

import com.dolthhaven.bibliophile.data.server.tags.BibliophileItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.ChiseledBookShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.extensions.IForgeBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IForgeBlock.class)
public class IForgeBlockMixin {
    @Inject(method = "getEnchantPowerBonus", at = @At("RETURN"), cancellable = true, remap = false)
    private void Bibliophile$ChiseledBookshelfEnchantingPower(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Float> cir) {
        if (level.getBlockEntity(pos) instanceof ChiseledBookShelfBlockEntity bookcase) {
            // Power from Chainsaw Man? Holyshit?
            float power = 0f;
            for (int i = 0; i < bookcase.getContainerSize(); i++) {
                ItemStack stack = bookcase.getItem(i);
                if (!stack.is(ItemTags.BOOKSHELF_BOOKS)) {
                    continue;
                }

                if (stack.is(BibliophileItemTags.MAGICAL_BOOKS)) {
                    power += 0.5f;
                    continue;
                }

                power += 1 / 3f;
            }
            cir.setReturnValue(power);
        }
    }
}
