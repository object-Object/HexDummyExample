package io.github.objectobject.hexdummyexample.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.objectobject.hexdummyexample.config.HexdummyexampleServerConfig
import io.github.objectobject.hexdummyexample.networking.msg.*

fun HexdummyexampleMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HexdummyexampleServerConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
