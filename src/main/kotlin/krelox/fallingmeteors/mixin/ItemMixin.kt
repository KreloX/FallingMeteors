package krelox.fallingmeteors.mixin

import krelox.fallingmeteors.item.EnchantedItemProperties
import net.minecraft.world.item.Item
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Unique
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

@Mixin(Item::class)
open class ItemMixin {
    @Unique
    private var enchantments = HashMap<Enchantment, Int>()

    @Inject(method = ["<init>"], at = [At("RETURN")])
    private fun constructorInject(properties: Properties, ci: CallbackInfo) {
        if (properties is EnchantedItemProperties) enchantments = properties.enchantments
    }

    @Inject(method = ["getDefaultInstance"], at = [At("RETURN")], cancellable = true)
    fun injectDefaultInstance(cir: CallbackInfoReturnable<ItemStack>) {
        val stack = cir.returnValue
        enchantments.forEach { (enchantment, level) -> stack.enchant(enchantment, level) }
        cir.returnValue = stack
    }
}