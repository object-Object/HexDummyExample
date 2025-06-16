package io.github.objectobject.hexdummyexample.fabric

import io.github.objectobject.hexdummyexample.Hexdummyexample
import net.fabricmc.api.ModInitializer

object FabricHexdummyexample : ModInitializer {
    override fun onInitialize() {
        Hexdummyexample.init()
    }
}
