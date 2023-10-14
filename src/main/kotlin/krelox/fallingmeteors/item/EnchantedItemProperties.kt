package krelox.fallingmeteors.item

import net.minecraft.world.item.Item
import net.minecraft.world.item.enchantment.Enchantment

open class EnchantedItemProperties : Item.Properties() {
    val enchantments = HashMap<Enchantment, Int>()

    fun enchantment(enchantment: Enchantment, level: Int): EnchantedItemProperties {
        enchantments[enchantment] = level
        return this
    }
}