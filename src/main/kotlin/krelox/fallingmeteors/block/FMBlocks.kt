package krelox.fallingmeteors.block

import krelox.fallingmeteors.FallingMeteors
import krelox.fallingmeteors.LOGGER
import krelox.fallingmeteors.item.FMItems
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject

object FMBlocks {
    init {
        LOGGER.info("Initializing blocks")
    }

    internal val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, FallingMeteors.ID)

    private val METEORITE_PROPERTIES = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY)
        .requiresCorrectToolForDrops().strength(10F, 200F).sound(SoundType.NETHERITE_BLOCK)

    val METEORITE_BLOCK by registerBlock("meteorite_block") { Block(METEORITE_PROPERTIES.lightLevel { 7 }) }
    val METEORITE_ORE by registerBlock("meteorite_ore") { Block(METEORITE_PROPERTIES) }
    val FREZARITE_ORE by registerBlock("frezarite_ore") { Block(METEORITE_PROPERTIES) }
    val FREZARITE_BLOCK by registerBlock("frezarite_block") {
        Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                .strength(8.5F, 150F).sound(SoundType.METAL).lightLevel { 3 }
        )
    }
    val KREKNORITE_BLOCK by registerBlock("kreknorite_block") {
        Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                .strength(11F, 350F).sound(SoundType.NETHERITE_BLOCK).lightLevel { 11 }
        )
    }

    private fun registerBlock(name: String, block: () -> Block): ObjectHolderDelegate<Block> {
        val holder = BLOCKS.registerObject(name, block)
        FMItems.registerItem(name) { BlockItem(holder.get(), Item.Properties()) }
        return holder
    }
}