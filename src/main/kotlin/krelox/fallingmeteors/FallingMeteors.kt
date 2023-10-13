package krelox.fallingmeteors

import krelox.fallingmeteors.block.FMBlocks
import krelox.fallingmeteors.item.FMItems
import net.minecraft.client.Minecraft
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.CreativeModeTab
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import net.minecraftforge.registries.DeferredRegister
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.registerObject
import thedarkcolour.kotlinforforge.forge.runForDist

internal val LOGGER = LogManager.getLogger(FallingMeteors.ID)

@Mod(FallingMeteors.ID)
object FallingMeteors {
    const val ID = "fallingmeteors"
    private val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ID)

    @Suppress("unused")
    val FALLING_METEORS: CreativeModeTab by CREATIVE_MODE_TABS.registerObject("falling_meteors") {
        CreativeModeTab.builder()
            .icon { FMItems.METEORITE_BLOCK.defaultInstance }
            // TODO
            //.title()
            .displayItems { _, output -> FMItems.ITEMS.entries.forEach { output.accept(it.get().defaultInstance) } }
            .build()
    }

    init {
        FMBlocks.BLOCKS.register(MOD_BUS)
        FMItems.ITEMS.register(MOD_BUS)
        CREATIVE_MODE_TABS.register(MOD_BUS)

        val obj = runForDist(
            clientTarget = {
                MOD_BUS.addListener(::onClientSetup)
                Minecraft.getInstance()
            },
            serverTarget = {
                MOD_BUS.addListener(::onServerSetup)
                "test"
            })

        println(obj)
    }

    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }
}