package krelox.fallingmeteors

import krelox.fallingmeteors.block.FMBlocks
import krelox.fallingmeteors.data.generators.FMItemModelData
import krelox.fallingmeteors.data.generators.FMLanguageData
import krelox.fallingmeteors.data.generators.tags.FMBlockTagData
import krelox.fallingmeteors.data.generators.tags.FMItemTagData
import krelox.fallingmeteors.data.resources.FMLanguage
import krelox.fallingmeteors.item.FMItems
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.CreativeModeTab
import net.minecraftforge.data.event.GatherDataEvent
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
            .title(FMLanguage.FALLING_METEORS_TAB)
            .displayItems { _, output -> FMItems.ITEMS.entries.forEach { output.accept(it.get().defaultInstance) } }
            .build()
    }

    init {
        MOD_BUS.addListener(this::gatherData)

        FMBlocks.BLOCKS.register(MOD_BUS)
        FMItems.ITEMS.register(MOD_BUS)
        CREATIVE_MODE_TABS.register(MOD_BUS)
    }

    private fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val fileHelper = event.existingFileHelper
        val lookupProvider = event.lookupProvider
        val packOutput = generator.packOutput

        generator.addProvider(event.includeClient(), FMLanguageData(packOutput))
        generator.addProvider(event.includeClient(), FMItemModelData(packOutput, fileHelper))

        val blockTags = FMBlockTagData(packOutput, lookupProvider, fileHelper)
        generator.addProvider(event.includeServer(), blockTags)
        generator.addProvider(event.includeServer(), FMItemTagData(packOutput, lookupProvider, blockTags.contentsGetter(), fileHelper))
    }
}