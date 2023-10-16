package krelox.fallingmeteors.data.generators

import krelox.fallingmeteors.MODID
import krelox.fallingmeteors.item.FMItems
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Item
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.registries.ForgeRegistries

class FMItemModelData(output: PackOutput, existingFileHelper: ExistingFileHelper) : ItemModelProvider(
    output, MODID, existingFileHelper
) {
    override fun registerModels() {
        item(FMItems.METEORITE_CHIPS, "materials/")
        item(FMItems.RED_METEORITE_GEM, "materials/")
        item(FMItems.FREZARITE_CRYSTAL, "materials/")
        item(FMItems.KREKNORITE_CHIP, "materials/")
        item(FMItems.METEORITE_INGOT, "materials/")
        item(FMItems.FROZEN_IRON, "materials/")
        item(FMItems.KREKNORITE_INGOT, "materials/")

        handheldItem(FMItems.METEORITE_SWORD, "weapons/")
        handheldItem(FMItems.FREZARITE_SWORD, "weapons/")
        handheldItem(FMItems.KREKNORITE_SWORD, "weapons/")

        handheldItem(FMItems.METEORITE_SHOVEL, "tools/")
        handheldItem(FMItems.METEORITE_PICKAXE, "tools/")
        handheldItem(FMItems.METEORITE_AXE, "tools/")
        handheldItem(FMItems.METEORITE_HOE, "tools/")
        handheldItem(FMItems.FREZARITE_SHOVEL, "tools/")
        handheldItem(FMItems.FREZARITE_PICKAXE, "tools/")
        handheldItem(FMItems.FREZARITE_AXE, "tools/")
        handheldItem(FMItems.FREZARITE_HOE, "tools/")

        FMItems.METEORITE_ARMOR.values.forEach { item(it.get(), "armor/") }
        item(FMItems.FREZARITE_HELMET, "armor/")
        item(FMItems.FREZARITE_CHESTPLATE, "armor/")
        item(FMItems.FREZARITE_LEGGINGS, "armor/")
        item(FMItems.FREZARITE_BOOTS, "armor/")
        FMItems.KREKNORITE_ARMOR.values.forEach { item(it.get(), "armor/") }
    }

    private fun itemName(item: Item): String {
        val location = ForgeRegistries.ITEMS.getKey(item)
        return if (location != null) {
            location.path
        } else {
            throw IllegalStateException("Unknown item: $item")
        }
    }

    private fun item(item: Item, location: String) {
        this.withExistingParent(itemName(item), mcLoc("item/generated"))
            .texture("layer0", modLoc("item/" + location + this.itemName(item)))
    }

    private fun handheldItem(item: Item, location: String) {
        this.withExistingParent(this.itemName(item), mcLoc("item/handheld"))
            .texture("layer0", modLoc("item/" + location + this.itemName(item)))
    }
}