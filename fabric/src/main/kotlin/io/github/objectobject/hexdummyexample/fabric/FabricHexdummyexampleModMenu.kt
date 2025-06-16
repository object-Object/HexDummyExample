package io.github.objectobject.hexdummyexample.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.objectobject.hexdummyexample.HexdummyexampleClient

object FabricHexdummyexampleModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexdummyexampleClient::getConfigScreen)
}
