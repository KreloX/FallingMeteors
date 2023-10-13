package krelox.fallingmeteors.item

import krelox.fallingmeteors.FallingMeteors
import net.minecraft.Util
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.crafting.Ingredient
import java.util.*

private val HEALTH_FUNCTION_FOR_TYPE = Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) {
    it[ArmorItem.Type.BOOTS] = 13
    it[ArmorItem.Type.LEGGINGS] = 15
    it[ArmorItem.Type.CHESTPLATE] = 16
    it[ArmorItem.Type.HELMET] = 11
}

enum class FMArmorMaterials(
    private val materialName: String,
    private val durabilityMultiplier: Int,
    private val protectionFunctionForType: EnumMap<ArmorItem.Type, Int>,
    private val enchantmentValue: Int,
    private val sound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    private val repairIngredient: Lazy<Ingredient>,
) : ArmorMaterial {
    METEORITE(
        "meteorite", 30, Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) {
            it[ArmorItem.Type.BOOTS] = 2
            it[ArmorItem.Type.LEGGINGS] = 5
            it[ArmorItem.Type.CHESTPLATE] = 6
            it[ArmorItem.Type.HELMET] = 2
        }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 0f, 0f,
        lazyOf(Ingredient.of(FMItems.METEORITE_INGOT))
    ),
    FREZARITE(
        "frezarite", 30, Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) {
            it[ArmorItem.Type.BOOTS] = 2
            it[ArmorItem.Type.LEGGINGS] = 5
            it[ArmorItem.Type.CHESTPLATE] = 6
            it[ArmorItem.Type.HELMET] = 2
        }, 15, SoundEvents.ARMOR_EQUIP_IRON, 0f, 0f,
        lazyOf(Ingredient.of(FMItems.FROZEN_IRON))
    ),
    KREKNORITE(
        "kreknorite", 30, Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) {
            it[ArmorItem.Type.BOOTS] = 2
            it[ArmorItem.Type.LEGGINGS] = 5
            it[ArmorItem.Type.CHESTPLATE] = 6
            it[ArmorItem.Type.HELMET] = 2
        }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 0f, 0f,
        lazyOf(Ingredient.of(FMItems.KREKNORITE_INGOT))
    );

    override fun getDurabilityForType(type: ArmorItem.Type): Int {
        return HEALTH_FUNCTION_FOR_TYPE[type]!! * durabilityMultiplier
    }

    override fun getDefenseForType(type: ArmorItem.Type): Int {
        return protectionFunctionForType[type]!!
    }

    override fun getEnchantmentValue(): Int {
        return enchantmentValue
    }

    override fun getEquipSound(): SoundEvent {
        return sound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.value
    }

    override fun getName(): String {
        return FallingMeteors.ID + ':' + materialName
    }

    override fun getToughness(): Float {
        return toughness
    }

    override fun getKnockbackResistance(): Float {
        return knockbackResistance
    }
}