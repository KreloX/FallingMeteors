package krelox.fallingmeteors.item.enchantment

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.Equipable
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

class ColdTouchEnchantment(rarity: Rarity, applicableSlots: Array<out EquipmentSlot>) : Enchantment(
    rarity, EnchantmentCategory.create("gear") {
        it is Equipable && (it.equipmentSlot.equals(EquipmentSlot.FEET) || it.equipmentSlot.equals(EquipmentSlot.LEGS))
    }, applicableSlots
) {

    override fun getMinCost(level: Int): Int {
        return 15 + (level - 1) * 6
    }

    override fun getMaxCost(level: Int): Int {
        return getMinCost(level) + 45
    }

    override fun getMaxLevel(): Int {
        return 2
    }

    override fun checkCompatibility(other: Enchantment): Boolean {
        return super.checkCompatibility(other) && other != Enchantments.FROST_WALKER
    }
}