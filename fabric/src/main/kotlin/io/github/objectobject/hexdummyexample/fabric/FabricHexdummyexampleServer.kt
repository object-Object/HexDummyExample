package io.github.objectobject.hexdummyexample.fabric

import io.github.objectobject.hexdummyexample.Hexdummyexample
import net.fabricmc.api.DedicatedServerModInitializer

object FabricHexdummyexampleServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        Hexdummyexample.initServer()
    }
}
