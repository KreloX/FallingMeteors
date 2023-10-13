package krelox.fallingmeteors.item

import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.Tier

class EnchantableSwordItem(
    tier: Tier,
    attackDamageModifier: Int,
    attackSpeedModifier: Float,
    private val properties: EnchantableItem.Properties,
) : SwordItem(tier, attackDamageModifier, attackSpeedModifier, properties), EnchantableItem {

    override fun getDefaultInstance(): ItemStack {
        val stack = super.getDefaultInstance()
        properties.enchantments.forEach { (enchantment, level) -> stack.enchant(enchantment, level) }
        return stack
    }
}