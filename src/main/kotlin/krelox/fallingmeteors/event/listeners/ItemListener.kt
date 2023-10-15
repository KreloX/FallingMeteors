package krelox.fallingmeteors.event.listeners

import krelox.fallingmeteors.FMTags
import krelox.fallingmeteors.MODID
import krelox.fallingmeteors.data.resources.FMLanguage
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = MODID)
object ItemListener {
    @SubscribeEvent
    fun itemTooltip(event: ItemTooltipEvent) {
        val stack = event.itemStack
        val tooltip = event.toolTip

        val itemName: MutableComponent = Component.empty().append(stack.getHoverName()).withStyle(stack.rarity.styleModifier)

        if (stack.`is`(FMTags.Items.KREKNORITE_ARMOR)) {
            tooltip.add(tooltip.indexOf(itemName) + 1, FMLanguage.KREKNORITE_ARMOR_TOOLTIP)
        }
    }
}