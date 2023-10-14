package krelox.fallingmeteors

import krelox.fallingmeteors.block.FMBlocks
import krelox.fallingmeteors.item.FMItems
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.CreativeModeTab
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.DeferredRegister
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.registerObject

internal const val MODID = "fallingmeteors"
internal val LOGGER = LogManager.getLogger(MODID)

@Mod(MODID)
object FallingMeteors {
    private val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID)

    @Suppress("unused")
    val FALLING_METEORS: CreativeModeTab by CREATIVE_MODE_TABS.registerObject("falling_meteors") {
        CreativeModeTab.builder()
            .icon { FMBlocks.METEORITE_BLOCK.asItem().defaultInstance }
            // TODO
            //.title()
            .displayItems { _, output -> FMItems.ITEMS.entries.forEach { output.accept(it.get().defaultInstance) } }
            .build()
    }

    init {
        FMBlocks.BLOCKS.register(MOD_BUS)
        FMItems.ITEMS.register(MOD_BUS)
        CREATIVE_MODE_TABS.register(MOD_BUS)
    }
}