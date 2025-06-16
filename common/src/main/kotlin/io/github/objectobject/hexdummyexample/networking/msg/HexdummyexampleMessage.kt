package io.github.objectobject.hexdummyexample.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.objectobject.hexdummyexample.Hexdummyexample
import io.github.objectobject.hexdummyexample.networking.HexdummyexampleNetworking
import io.github.objectobject.hexdummyexample.networking.handler.applyOnClient
import io.github.objectobject.hexdummyexample.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HexdummyexampleMessage

sealed interface HexdummyexampleMessageC2S : HexdummyexampleMessage {
    fun sendToServer() {
        HexdummyexampleNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HexdummyexampleMessageS2C : HexdummyexampleMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HexdummyexampleNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HexdummyexampleNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HexdummyexampleMessageCompanion<T : HexdummyexampleMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Hexdummyexample.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HexdummyexampleMessageC2S -> msg.applyOnServer(ctx)
                    else -> Hexdummyexample.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Hexdummyexample.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HexdummyexampleMessageS2C -> msg.applyOnClient(ctx)
                    else -> Hexdummyexample.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
