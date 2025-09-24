package io.github.objectobject.hexdummyexample

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.objectobject.hexdummyexample.config.HexdummyexampleServerConfig
import io.github.objectobject.hexdummyexample.networking.HexdummyexampleNetworking
import io.github.objectobject.hexdummyexample.registry.HexdummyexampleActions

object Hexdummyexample {
    const val MODID = "hexdummyexample"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HexdummyexampleServerConfig.init()
        initRegistries(
            HexdummyexampleActions,
        )
        HexdummyexampleNetworking.init()
    }

    fun initServer() {
        HexdummyexampleServerConfig.initServer()
    }
}
