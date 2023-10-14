package krelox.fallingmeteors.item

import krelox.fallingmeteors.FallingMeteors
import krelox.fallingmeteors.LOGGER
import net.minecraft.Util
import net.minecraft.world.item.*
import net.minecraft.world.item.ArmorItem.Type
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject
import java.util.*

object FMItems {
    init {
        LOGGER.info("Initializing items")
    }

    internal val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, FallingMeteors.ID)

    val METEORITE_CHIPS by registerItem("meteorite_chips")
    val RED_METEORITE_GEM by registerItem("red_meteorite_gem")
    val FREZARITE_CRYSTAL by registerItem("frezarite_crystal")
    val KREKNORITE_CHIPS by registerItem("kreknorite_chip")
    val METEORITE_INGOT by registerItem("meteorite_ingot")
    val FROZEN_IRON by registerItem("frozen_iron")
    val KREKNORITE_INGOT by registerItem("kreknorite_ingot")

    val METEORITE_ARMOR: Map<Type, ObjectHolderDelegate<Item>> = Util.make(EnumMap(Type::class.java)) { map ->
        Type.values().forEach { type ->
            map[type] = registerItem("meteorite_" + type.getName()) {
                ArmorItem(FMArmorMaterials.METEORITE, type, EnchantedItemProperties())
            }
        }
    }
    val METEORITE_SWORD by registerItem("meteorite_sword") {
        SwordItem(FMTiers.METEORITE, 3, -2.4f, EnchantedItemProperties())
    }
    val METEORITE_SHOVEL by registerItem("meteorite_shovel") {
        ShovelItem(FMTiers.METEORITE, 1.5f, -3.0f, EnchantedItemProperties())
    }
    val METEORITE_PICKAXE by registerItem("meteorite_pickaxe") {
        PickaxeItem(FMTiers.METEORITE, 1, -2.8f, EnchantedItemProperties())
    }
    val METEORITE_AXE by registerItem("meteorite_axe") {
        AxeItem(FMTiers.METEORITE, 7.0f, -3.2f, EnchantedItemProperties())
    }
    val METEORITE_HOE by registerItem("meteorite_hoe") {
        HoeItem(FMTiers.METEORITE, -1, -2.0f, EnchantedItemProperties())
    }

    val FREZARITE_HELMET by registerItem("frezarite_helmet") {
        ArmorItem(FMArmorMaterials.KREKNORITE, Type.HELMET, EnchantedItemProperties())
    }
    val FREZARITE_CHESTPLATE by registerItem("frezarite_chestplate") {
        ArmorItem(FMArmorMaterials.KREKNORITE, Type.CHESTPLATE, EnchantedItemProperties())
    }
    val FREZARITE_LEGGINGS by registerItem("frezarite_leggings") {
        ArmorItem(FMArmorMaterials.KREKNORITE, Type.LEGGINGS, EnchantedItemProperties())
    }
    val FREZARITE_BOOTS by registerItem("frezarite_boots") {
        ArmorItem(FMArmorMaterials.KREKNORITE, Type.BOOTS, EnchantedItemProperties())
    }
    val FREZARITE_SWORD by registerItem("frezarite_sword") {
        SwordItem(FMTiers.FREZARITE, 3, -2.4f, EnchantedItemProperties())
    }
    val FREZARITE_SHOVEL by registerItem("frezarite_shovel") {
        ShovelItem(FMTiers.FREZARITE, 1.5f, -3.0f, EnchantedItemProperties())
    }
    val FREZARITE_PICKAXE by registerItem("frezarite_pickaxe") {
        PickaxeItem(FMTiers.FREZARITE, 1, -2.8f, EnchantedItemProperties())
    }
    val FREZARITE_AXE by registerItem("frezarite_axe") {
        AxeItem(FMTiers.FREZARITE, 7.0f, -3.2f, EnchantedItemProperties())
    }
    val FREZARITE_HOE by registerItem("frezarite_hoe") {
        HoeItem(FMTiers.FREZARITE, -1, -2.0f, EnchantedItemProperties())
    }

    val KREKNORITE_ARMOR: Map<Type, ObjectHolderDelegate<Item>> = Util.make(EnumMap(Type::class.java)) { map ->
        Type.values().forEach { type ->
            map[type] = registerItem("kreknorite_" + type.getName()) {
                ArmorItem(FMArmorMaterials.KREKNORITE, type, EnchantedItemProperties())
            }
        }
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