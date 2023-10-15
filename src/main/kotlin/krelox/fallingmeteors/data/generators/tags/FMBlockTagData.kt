package krelox.fallingmeteors.data.generators.tags

import krelox.fallingmeteors.MODID
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class FMBlockTagData(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    existingFileHelper: ExistingFileHelper,
) : BlockTagsProvider(output, lookupProvider, MODID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {}
}