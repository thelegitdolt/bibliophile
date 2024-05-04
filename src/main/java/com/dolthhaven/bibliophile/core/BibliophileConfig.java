package com.dolthhaven.bibliophile.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class BibliophileConfig {
    public static class Common {
        public final ConfigValue<Boolean> removeXPScaling;
        public final ConfigValue<Integer> xpPerLevel;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("XP");

            builder.push("XP Scaling");
            removeXPScaling = builder.comment("If the levels required to advance each level should remain at a constant value").define("RemoveXPScaling", true);
            xpPerLevel = builder.comment("If RemoveXPScaling is true, the amount of XP it takes to level up").define("xpPerLevel", 35);
            builder.pop();

            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;


    static {
        Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}
