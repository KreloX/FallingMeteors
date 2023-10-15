package krelox.fallingmeteors.event.listeners

import krelox.fallingmeteors.MODID
import krelox.fallingmeteors.item.enchantment.FMEnchantments
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.item.enchantment.EnchantmentHelper
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import kotlin.math.sqrt

@EventBusSubscriber(modid = MODID)
object EntityListener {
    @SubscribeEvent
    fun livingTick(event: LivingTickEvent) {
        val entity = event.entity
        val level = entity.level()

        val magnetizationLevel = EnchantmentHelper.getEnchantmentLevel(FMEnchantments.MAGNETIZATION, entity)
        if (magnetizationLevel > 0) {
            val distance = 8 * magnetizationLevel
            val nearbyItems = level.getEntitiesOfClass(ItemEntity::class.java, entity.boundingBox.inflate(distance.toDouble()))

            for (i in nearbyItems.indices) {
                val xOffset = (entity.x - nearbyItems[i].x) / distance
                val yOffset = (entity.y + entity.eyeHeight - nearbyItems[i].y) / distance
                val zOffset = (entity.z - nearbyItems[i].z) / distance
                val distanceRatio = sqrt(xOffset * xOffset + yOffset * yOffset + zOffset * zOffset)
                var attractionFactor = 1.0 - distanceRatio

                if (attractionFactor > 0.0) {
                    attractionFactor *= attractionFactor
                    val xSpeed = nearbyItems[i].deltaMovement.x + xOffset / distanceRatio * attractionFactor * 0.1
                    val ySpeed = nearbyItems[i].deltaMovement.y + yOffset / distanceRatio * attractionFactor * 0.1
                    val zSpeed = nearbyItems[i].deltaMovement.z + zOffset / distanceRatio * attractionFactor * 0.1
                    nearbyItems[i].setDeltaMovement(xSpeed, ySpeed, zSpeed)
                }
            }
        }
    }
}