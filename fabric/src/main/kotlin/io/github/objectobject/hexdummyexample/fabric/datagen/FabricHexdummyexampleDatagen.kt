package io.github.objectobject.hexdummyexample.fabric.datagen

import io.github.objectobject.hexdummyexample.datagen.HexdummyexampleActionTags
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object FabricHexdummyexampleDatagen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack = gen.createPack()

        pack.addProvider(::HexdummyexampleActionTags)
    }
}
