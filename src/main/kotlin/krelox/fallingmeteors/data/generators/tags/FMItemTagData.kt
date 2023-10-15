package krelox.fallingmeteors.data.generators.tags

import krelox.fallingmeteors.FMTags
import krelox.fallingmeteors.MODID
import krelox.fallingmeteors.item.FMItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.world.level.block.Block
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class FMItemTagData(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    blockTags: CompletableFuture<TagLookup<Block>>,
    existingFileHelper: ExistingFileHelper,
) : ItemTagsProvider(output, lookupProvider, blockTags, MODID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        FMItems.KREKNORITE_ARMOR.values.forEach { tag(FMTags.Items.KREKNORITE_ARMOR).add(it.get()) }
    }
}