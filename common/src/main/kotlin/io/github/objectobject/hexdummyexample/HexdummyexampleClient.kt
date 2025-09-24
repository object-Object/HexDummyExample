package io.github.objectobject.hexdummyexample

import io.github.objectobject.hexdummyexample.config.HexdummyexampleClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexdummyexampleClient {
    fun init() {
        HexdummyexampleClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(HexdummyexampleClientConfig.GlobalConfig::class.java, parent).get()
    }
}
