package krelox.fallingmeteors.mixin

import krelox.fallingmeteors.FMTags
import krelox.fallingmeteors.item.enchantment.FMEnchantments
import net.minecraft.core.BlockPos
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(LivingEntity::class)
abstract class LivingEntityMixin(entityType: EntityType<*>, level: Level) : Entity(entityType, level) {
    @Override
    override fun fireImmune(): Boolean {
        val entity = this as LivingEntity
        if (armorCoverPercentage == 1.0f && entity.armorSlots.all { stack -> stack.`is`(FMTags.Items.KREKNORITE_ARMOR) }) {
            return true
        }
        return super.fireImmune()
    }

    @Inject(method = ["onChangedBlock"], at = [At("HEAD")])
    fun injectOnChangedBlock(pos: BlockPos, ci: CallbackInfo) {
        var coldTouchLevel = -1
        armorSlots.forEach { stack -> coldTouchLevel += stack.getEnchantmentLevel(FMEnchantments.COLD_TOUCH) }

        if (coldTouchLevel > -1 && !isInWater) {
            val icePos = blockPosition().below()
            if (isSprinting) {
                for (i in -coldTouchLevel..coldTouchLevel) {
                    for (j in -coldTouchLevel..coldTouchLevel) {
                        val icePos1 = BlockPos(icePos.x + i, icePos.y, icePos.z + j)
                        if (level().getBlockState(icePos1) == Blocks.WATER.defaultBlockState()) {
                            level().setBlockAndUpdate(icePos1, Blocks.ICE.defaultBlockState())
                        }
                    }
                }
            } else {
                if (level().getBlockState(icePos) == Blocks.WATER.defaultBlockState()) {
                    level().setBlockAndUpdate(icePos, Blocks.ICE.defaultBlockState())
                }
            }
        }
    }
}