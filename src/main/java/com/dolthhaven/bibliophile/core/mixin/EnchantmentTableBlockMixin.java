package com.dolthhaven.bibliophile.core.mixin;

import com.dolthhaven.bibliophile.data.server.tags.BibliophileItemTags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.EnchantmentTableBlock;
import net.minecraft.world.level.block.entity.ChiseledBookShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantmentTableBlock.class)
public class EnchantmentTableBlockMixin {
    @WrapOperation(method = "isValidBookShelf", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getEnchantPowerBonus(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;)F"))
    private static float Bibliophile$ChiseledBookshelfIsAlsoCorrectLol(BlockState self, LevelReader level, BlockPos pos, Operation<Float> original) {
        if (level.getBlockEntity(pos) instanceof ChiseledBookShelfBlockEntity bookcase) {
            float power = 0f;
            for (int i = 0; i < bookcase.getContainerSize(); i++) {
                ItemStack stack = bookcase.getItem(i);
                if (!stack.is(ItemTags.BOOKSHELF_BOOKS)) {
                    continue;
                }

                if (stack.is(BibliophileItemTags.MAGICAL_BOOKS)) {
                    power += 2f;
                    continue;
                }

                power += 1f;
            }
            return power;
        }
        else {
            return original.call(self, level, pos);
        }
    }
}
