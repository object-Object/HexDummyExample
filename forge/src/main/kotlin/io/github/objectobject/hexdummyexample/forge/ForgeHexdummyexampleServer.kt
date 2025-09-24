package io.github.objectobject.hexdummyexample.forge

import io.github.objectobject.hexdummyexample.Hexdummyexample
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeHexdummyexampleServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        Hexdummyexample.initServer()
    }
}
