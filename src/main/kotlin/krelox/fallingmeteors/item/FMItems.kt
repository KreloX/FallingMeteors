package krelox.fallingmeteors.item

import krelox.fallingmeteors.MODID
import krelox.fallingmeteors.item.enchantment.FMEnchantments
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
    internal val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID)

    val METEORITE_CHIPS by registerItem("meteorite_chips")
    val RED_METEORITE_GEM by registerItem("red_meteorite_gem")
    val FREZARITE_CRYSTAL by registerItem("frezarite_crystal")
    val KREKNORITE_CHIP by registerItem("kreknorite_chip")
    val METEORITE_INGOT by registerItem("meteorite_ingot")
    val FROZEN_IRON by registerItem("frozen_iron")
    val KREKNORITE_INGOT by registerItem("kreknorite_ingot")

    val METEORITE_SWORD by registerItem("meteorite_sword") {
        SwordItem(FMTiers.METEORITE, 3, -2.4f, EnchantedItemProperties().enchantment(FMEnchantments.MAGNETIZATION, 1))
    }
    val METEORITE_SHOVEL by registerItem("meteorite_shovel") {
        ShovelItem(
            FMTiers.METEORITE, 1.5f, -3.0f, EnchantedItemProperties().enchantment(FMEnchantments.MAGNETIZATION, 1)
        )
    }
    val METEORITE_PICKAXE by registerItem("meteorite_pickaxe") {
        PickaxeItem(FMTiers.METEORITE, 1, -2.8f, EnchantedItemProperties().enchantment(FMEnchantments.MAGNETIZATION, 1))
    }
    val METEORITE_AXE by registerItem("meteorite_axe") {
        AxeItem(FMTiers.METEORITE, 7.0f, -3.2f, EnchantedItemProperties().enchantment(FMEnchantments.MAGNETIZATION, 1))
    }
    val METEORITE_HOE by registerItem("meteorite_hoe") {
        HoeItem(FMTiers.METEORITE, -1, -2.0f, EnchantedItemProperties().enchantment(FMEnchantments.MAGNETIZATION, 1))
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

    val KREKNORITE_SWORD by registerItem("kreknorite_sword") {
        SwordItem(FMTiers.METEORITE, 5, -2.4f, EnchantedItemProperties().enchantment(Enchantments.FIRE_ASPECT, 2))
    }

    val METEORITE_ARMOR: Map<Type, ObjectHolderDelegate<Item>> = Util.make(EnumMap(Type::class.java)) { map ->
        Type.values().forEach { type ->
            map[type] = registerItem("meteorite_" + type.getName()) {
                ArmorItem(
                    FMArmorMaterials.METEORITE,
                    type,
                    EnchantedItemProperties().enchantment(FMEnchantments.MAGNETIZATION, 1)
                )
            }
        }
    }
    val FREZARITE_HELMET by registerItem("frezarite_helmet") {
        ArmorItem(
            FMArmorMaterials.FREZARITE, Type.HELMET, EnchantedItemProperties().enchantment(Enchantments.RESPIRATION, 3)
        )
    }
    val FREZARITE_CHESTPLATE by registerItem("frezarite_chestplate") {
        ArmorItem(
            FMArmorMaterials.FREZARITE,
            Type.CHESTPLATE,
            EnchantedItemProperties().enchantment(Enchantments.AQUA_AFFINITY, 1)
        )
    }
    val FREZARITE_LEGGINGS by registerItem("frezarite_leggings") {
        ArmorItem(
            FMArmorMaterials.FREZARITE,
            Type.LEGGINGS,
            EnchantedItemProperties().enchantment(FMEnchantments.COLD_TOUCH, 1)
        )
    }
    val FREZARITE_BOOTS by registerItem("frezarite_boots") {
        ArmorItem(
            FMArmorMaterials.FREZARITE, Type.BOOTS, EnchantedItemProperties().enchantment(FMEnchantments.COLD_TOUCH, 1)
        )
    }
    val KREKNORITE_ARMOR: Map<Type, ObjectHolderDelegate<Item>> = Util.make(EnumMap(Type::class.java)) { map ->
        Type.values().forEach { type ->
            map[type] = registerItem("kreknorite_" + type.getName()) {
                ArmorItem(
                    FMArmorMaterials.KREKNORITE,
                    type,
                    EnchantedItemProperties().enchantment(Enchantments.FIRE_PROTECTION, 4)
                )
            }
        }
    }

    private fun registerItem(name: String): ObjectHolderDelegate<Item> {
        return ITEMS.registerObject(name) { Item(Item.Properties()) }
    }

    internal fun registerItem(name: String, item: () -> Item): ObjectHolderDelegate<Item> {
        return ITEMS.registerObject(name, item)
    }
}