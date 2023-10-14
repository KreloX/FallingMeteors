package krelox.fallingmeteors.item

import krelox.fallingmeteors.FallingMeteors
import krelox.fallingmeteors.LOGGER
import krelox.fallingmeteors.block.FMBlocks
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject

object FMItems {
    init {
        LOGGER.info("Initializing items")
    }

    internal val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, FallingMeteors.ID)

    val METEORITE_INGOT by registerItem("meteorite_ingot")
    val FROZEN_IRON by registerItem("frozen_iron")
    val KREKNORITE_INGOT by registerItem("kreknorite_ingot")

    val METEORITE_SWORD by registerItem("meteorite_sword") {
        SwordItem(FMTiers.METEORITE, 3, -2.4f, EnchantedItemProperties())
    }

    val FREZARITE_SWORD by registerItem("frezarite_sword") {
        SwordItem(FMTiers.FREZARITE, 3, -2.4f, EnchantedItemProperties())
    }

    val KREKNORITE_SWORD by registerItem("kreknorite_sword") {
        SwordItem(
            FMTiers.METEORITE, 5, -2.4f, EnchantedItemProperties().enchantment(Enchantments.FIRE_ASPECT, 2)
        )
    }

    // Block Items
    val METEORITE_BLOCK by registerItem("meteorite_block") { BlockItem(FMBlocks.METEORITE_BLOCK, Item.Properties()) }
    val METEORITE_ORE by registerItem("meteorite_ore") { BlockItem(FMBlocks.METEORITE_ORE, Item.Properties()) }

    private fun registerItem(name: String): ObjectHolderDelegate<Item> {
        return ITEMS.registerObject(name) { Item(Item.Properties()) }
    }

    private fun registerItem(name: String, item: () -> Item): ObjectHolderDelegate<Item> {
        return ITEMS.registerObject(name, item)
    }
}