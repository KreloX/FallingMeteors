package krelox.fallingmeteors.item.enchantment

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.Equipable
import net.minecraft.world.item.TieredItem
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

class MagnetizationEnchantment(rarity: Rarity, applicableSlots: Array<out EquipmentSlot>) :
    Enchantment(rarity, EnchantmentCategory.create("gear") { it is Equipable || it is TieredItem }, applicableSlots) {

    override fun getMinCost(level: Int): Int {
        return 15 + (level - 1) * 6
    }

    override fun getMaxCost(level: Int): Int {
        return getMinCost(level) + 40
    }

    override fun getMaxLevel(): Int {
        return 4
    }
}