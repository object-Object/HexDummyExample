package io.github.objectobject.hexdummyexample.forge

import dev.architectury.platform.forge.EventBuses
import io.github.objectobject.hexdummyexample.Hexdummyexample
import io.github.objectobject.hexdummyexample.forge.datagen.ForgeHexdummyexampleDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Hexdummyexample.MODID)
class ForgeHexdummyexample {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Hexdummyexample.MODID, this)
            addListener(ForgeHexdummyexampleClient::init)
            addListener(ForgeHexdummyexampleDatagen::init)
        }
        Hexdummyexample.init()
    }
}
