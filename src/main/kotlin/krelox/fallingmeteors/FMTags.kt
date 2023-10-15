package krelox.fallingmeteors

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item

object FMTags {
    object Items {
        val KREKNORITE_ARMOR = tag("kreknorite_armor")

        fun tag(name: String): TagKey<Item> {
            return TagKey.create(Registries.ITEM, ResourceLocation(MODID, name))
        }
    }
}