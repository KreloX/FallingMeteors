package krelox.fallingmeteors.item.enchantment

import krelox.fallingmeteors.MODID
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegisterEvent

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
object FMEnchantments {
    val COLD_TOUCH = ColdTouchEnchantment(Enchantment.Rarity.VERY_RARE, arrayOf(EquipmentSlot.FEET, EquipmentSlot.LEGS))
    val MAGNETIZATION = MagnetizationEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values())

    @SubscribeEvent
    fun register(event: RegisterEvent) {
        event.register(ForgeRegistries.Keys.ENCHANTMENTS) { helper ->
            helper.register(ResourceLocation(MODID, "cold_touch"), COLD_TOUCH)
            helper.register(ResourceLocation(MODID, "magnetization"), MAGNETIZATION)
        }
    }
}