package com.dolthhaven.bibliophile.data.server.tags;

import com.dolthhaven.bibliophile.core.Bibliophile;
import com.teamabnormals.blueprint.core.data.server.tags.BlueprintItemTagsProvider;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BibliophileItemTags {
    public static final TagKey<Item> MAGICAL_BOOKS = TagUtil.itemTag(Bibliophile.MOD_ID, "magical_books");

    public static class TagProvider extends BlueprintItemTagsProvider {
        public TagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> lookup, ExistingFileHelper helper) {
            super(Bibliophile.MOD_ID, output, provider, lookup, helper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            this.tag(MAGICAL_BOOKS).add(Items.ENCHANTED_BOOK)
                    .addOptional(new ResourceLocation("quark", "ancient_tome"));
        }

    }
}
