package krelox.fallingmeteors.data.resources

import krelox.fallingmeteors.MODID
import net.minecraft.ChatFormatting
import net.minecraft.Util
import net.minecraft.network.chat.CommonComponents
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.ComponentUtils
import net.minecraft.resources.ResourceLocation

object FMLanguage {
    val FALLING_METEORS_TAB: Component = Component.translatable("itemGroup.fallingmeteors")

    val SET_BONUS_TOOLTIP: Component = Component.translatable(Util.makeDescriptionId("item",
        ResourceLocation(MODID, "tooltip.set_bonus"))).withStyle(ChatFormatting.GRAY)
    val FIRE_IMMUNITY_TOOLTIP: Component = Component.translatable(Util.makeDescriptionId("item",
        ResourceLocation(MODID, "tooltip.fire_immunity"))).withStyle(ChatFormatting.GOLD)
    val KREKNORITE_ARMOR_TOOLTIP: Component = ComponentUtils.formatList(listOf(SET_BONUS_TOOLTIP, FIRE_IMMUNITY_TOOLTIP), CommonComponents.space())
}