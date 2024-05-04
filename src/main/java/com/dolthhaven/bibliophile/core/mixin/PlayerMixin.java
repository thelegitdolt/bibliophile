package com.dolthhaven.bibliophile.core.mixin;

import com.dolthhaven.bibliophile.core.BibliophileConfig;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerMixin {
    @Inject(method = "getXpNeededForNextLevel", at = @At("HEAD"), cancellable = true)
    private void Bibliophile$ConstantXPPerLevel(CallbackInfoReturnable<Integer> cir) {
        if (BibliophileConfig.COMMON.removeXPScaling.get()) {
            cir.setReturnValue(BibliophileConfig.COMMON.xpPerLevel.get());
        }
    }
}
