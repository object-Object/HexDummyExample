package io.github.objectobject.hexdummyexample.networking.msg

import io.github.objectobject.hexdummyexample.config.HexdummyexampleConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: HexdummyexampleConfig.ServerConfig) : HexdummyexampleMessageS2C {
    companion object : HexdummyexampleMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = HexdummyexampleConfig.ServerConfig.decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
