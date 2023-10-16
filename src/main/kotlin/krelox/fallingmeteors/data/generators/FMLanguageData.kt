package krelox.fallingmeteors.data.generators

import krelox.fallingmeteors.MODID
import krelox.fallingmeteors.data.resources.FMLanguage
import krelox.fallingmeteors.item.FMItems
import krelox.fallingmeteors.item.enchantment.FMEnchantments
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.LanguageProvider
import net.minecraftforge.registries.RegistryObject
import java.util.stream.Collectors

class FMLanguageData(output: PackOutput) : LanguageProvider(output, MODID, "en_us") {
    override fun addTranslations() {
        add(FMLanguage.FALLING_METEORS_TAB.string, "Falling Meteors")
        add(FMLanguage.SET_BONUS_TOOLTIP.string, "Set Bonus:")
        add(FMLanguage.FIRE_IMMUNITY_TOOLTIP.string, "Fire Immunity")

        add(FMEnchantments.COLD_TOUCH, "Cold Touch")
        add(FMEnchantments.MAGNETIZATION, "Magnetization")

        FMItems.ITEMS.entries.forEach { add(it.get(), formatName(it)) }
    }

    private fun formatName(registryObject: RegistryObject<*>): String {
        return registryObject.id.path.split('_').stream()
            .map { name -> name.replaceFirstChar { it.uppercase() } }
            .collect(Collectors.joining(" "))
    }
}