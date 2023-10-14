package krelox.fallingmeteors.item

import krelox.fallingmeteors.FallingMeteors
import net.minecraft.Util
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem.Type
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.crafting.Ingredient
import java.util.*

private val HEALTH_FUNCTION_FOR_TYPE = Util.make(EnumMap<Type, Int>(Type::class.java)) {
    it[Type.BOOTS] = 13
    it[Type.LEGGINGS] = 15
    it[Type.CHESTPLATE] = 16
    it[Type.HELMET] = 11
}

enum class FMArmorMaterials(
    private val materialName: String,
    private val durabilityMultiplier: Int,
    private val protectionFunctionForType: EnumMap<Type, Int>,
    private val enchantmentValue: Int,
    private val sound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    private val repairIngredient: Lazy<Ingredient>,
) : ArmorMaterial {
    METEORITE(
        "meteorite", 36, Util.make(EnumMap<Type, Int>(Type::class.java)) {
            it[Type.BOOTS] = 2
            it[Type.LEGGINGS] = 5
            it[Type.CHESTPLATE] = 7
            it[Type.HELMET] = 2
        }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 0f, 0f,
        lazyOf(Ingredient.of(FMItems.METEORITE_INGOT))
    ),
    FREZARITE(
        "frezarite", 7, Util.make(EnumMap<Type, Int>(Type::class.java)) {
            it[Type.BOOTS] = 1
            it[Type.LEGGINGS] = 3
            it[Type.CHESTPLATE] = 5
            it[Type.HELMET] = 2
        }, 20, SoundEvents.ARMOR_EQUIP_GOLD, 0f, 0f,
        lazyOf(Ingredient.of(FMItems.FROZEN_IRON))
    ),
    KREKNORITE(
        "kreknorite", 40, Util.make(EnumMap<Type, Int>(Type::class.java)) {
            it[Type.BOOTS] = 3
            it[Type.LEGGINGS] = 6
            it[Type.CHESTPLATE] = 8
            it[Type.HELMET] = 3
        }, 10, SoundEvents.ARMOR_EQUIP_NETHERITE, 0f, 0f,
        lazyOf(Ingredient.of(FMItems.KREKNORITE_INGOT))
    );

    override fun getDurabilityForType(type: Type): Int {
        return HEALTH_FUNCTION_FOR_TYPE[type]!! * durabilityMultiplier
    }

    override fun getDefenseForType(type: Type): Int {
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