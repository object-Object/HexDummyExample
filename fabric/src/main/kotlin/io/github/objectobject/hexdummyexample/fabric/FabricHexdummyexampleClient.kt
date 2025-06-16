package io.github.objectobject.hexdummyexample.fabric

import io.github.objectobject.hexdummyexample.HexdummyexampleClient
import net.fabricmc.api.ClientModInitializer

object FabricHexdummyexampleClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexdummyexampleClient.init()
    }
}
