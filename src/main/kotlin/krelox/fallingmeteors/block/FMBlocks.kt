package krelox.fallingmeteors.block

import krelox.fallingmeteors.FallingMeteors
import krelox.fallingmeteors.LOGGER
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object FMBlocks {
    init {
        LOGGER.info("Initializing blocks")
    }

    internal val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, FallingMeteors.ID)

    private val METEORITE_PROPERTIES = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY)
        .requiresCorrectToolForDrops().strength(10F, 200F).sound(SoundType.NETHERITE_BLOCK)

    val METEORITE_BLOCK by BLOCKS.registerObject("meteorite_block") { Block(METEORITE_PROPERTIES.lightLevel { 7 }) }
    val METEORITE_ORE by BLOCKS.registerObject("meteorite_ore") { Block(METEORITE_PROPERTIES) }
    val FREZARITE_ORE by BLOCKS.registerObject("frezarite_ore") { Block(METEORITE_PROPERTIES) }
}