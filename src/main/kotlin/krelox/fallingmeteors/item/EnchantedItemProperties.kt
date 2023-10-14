package krelox.fallingmeteors.item

import net.minecraft.world.item.Item
import net.minecraft.world.item.enchantment.Enchantment

open class EnchantedItemProperties : Item.Properties() {
    var enchantments = HashMap<Enchantment, Int>()
        protected set

    fun enchantment(enchantment: Enchantment, level: Int): EnchantedItemProperties {
        enchantments[enchantment] = level
        return this
    }
}