package krelox.fallingmeteors.item

import net.minecraft.world.item.Item
import net.minecraft.world.item.enchantment.Enchantment

interface EnchantableItem {
    open class Properties : Item.Properties() {
        var enchantments = HashMap<Enchantment, Int>()
            protected set

        fun enchantment(enchantment: Enchantment, level: Int): Properties {
            enchantments[enchantment] = level
            return this
        }
    }
}