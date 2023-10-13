package krelox.fallingmeteors.item

import krelox.fallingmeteors.FallingMeteors
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.world.item.Tier
import net.minecraft.world.item.Tiers
import net.minecraft.world.item.crafting.Ingredient
import net.minecraftforge.common.ForgeTier
import net.minecraftforge.common.TierSortingRegistry

object FMTiers {
    val METEORITE: Tier = TierSortingRegistry.registerTier(
        ForgeTier(3, 900, 10F, 2F, 15, BlockTags.NEEDS_DIAMOND_TOOL) {
            Ingredient.of(FMItems.METEORITE_INGOT)
        },
        ResourceLocation(FallingMeteors.ID, "meteorite"),
        listOf(Tiers.IRON),
        listOf(Tiers.DIAMOND)
    )
    val FREZARITE: Tier = TierSortingRegistry.registerTier(
        ForgeTier(3, 225, 7F, 2F, 20, BlockTags.NEEDS_DIAMOND_TOOL) {
            Ingredient.of(FMItems.FROZEN_IRON)
        },
        ResourceLocation(FallingMeteors.ID, "frezarite"),
        listOf(Tiers.IRON),
        listOf(Tiers.DIAMOND)
    )
}