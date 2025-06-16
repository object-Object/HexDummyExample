package io.github.objectobject.hexdummyexample.forge

import dev.architectury.platform.forge.EventBuses
import io.github.objectobject.hexdummyexample.Hexdummyexample
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Hexdummyexample.MODID)
class HexdummyexampleForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Hexdummyexample.MODID, this)
            addListener(ForgeHexdummyexampleClient::init)
            addListener(::gatherData)
        }
        Hexdummyexample.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            // TODO: add datagen providers here
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
