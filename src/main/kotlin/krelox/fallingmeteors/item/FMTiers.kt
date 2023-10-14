package krelox.fallingmeteors.item

import krelox.fallingmeteors.MODID
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.world.item.Tier
import net.minecraft.world.item.Tiers
import net.minecraft.world.item.crafting.Ingredient
import net.minecraftforge.common.ForgeTier
import net.minecraftforge.common.TierSortingRegistry

object FMTiers {
    val METEORITE: Tier = TierSortingRegistry.registerTier(
        ForgeTier(3, 900, 10f, 2f, 15, BlockTags.NEEDS_DIAMOND_TOOL) {
            Ingredient.of(FMItems.METEORITE_INGOT)
        },
        ResourceLocation(MODID, "meteorite"),
        listOf(Tiers.IRON),
        listOf(Tiers.DIAMOND)
    )
    val FREZARITE: Tier = TierSortingRegistry.registerTier(
        ForgeTier(3, 225, 7f, 2f, 20, BlockTags.NEEDS_DIAMOND_TOOL) {
            Ingredient.of(FMItems.FROZEN_IRON)
        },
        ResourceLocation(MODID, "frezarite"),
        listOf(Tiers.IRON),
        listOf(Tiers.DIAMOND)
    )
}