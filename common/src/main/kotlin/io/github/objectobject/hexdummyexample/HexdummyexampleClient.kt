package io.github.objectobject.hexdummyexample

import io.github.objectobject.hexdummyexample.config.HexdummyexampleConfig
import io.github.objectobject.hexdummyexample.config.HexdummyexampleConfig.GlobalConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexdummyexampleClient {
    fun init() {
        HexdummyexampleConfig.initClient()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(GlobalConfig::class.java, parent).get()
    }
}
