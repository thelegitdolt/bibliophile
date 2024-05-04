package com.dolthhaven.bibliophile.data.server.tags;

import com.dolthhaven.bibliophile.core.Bibliophile;
import com.teamabnormals.blueprint.core.data.server.tags.BlueprintBlockTagsProvider;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BibliophileBlockTags {
//    public static final TagKey<Block> AMONG_US = TagUtil.blockTag(Bibliophile.MOD_ID, "sus_impostor");
    public static class TagProvider extends BlueprintBlockTagsProvider {

        public TagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
            super(Bibliophile.MOD_ID, output, provider, helper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
        }
    }
}
