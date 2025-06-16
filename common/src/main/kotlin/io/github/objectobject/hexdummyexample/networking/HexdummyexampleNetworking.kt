package io.github.objectobject.hexdummyexample.networking

import dev.architectury.networking.NetworkChannel
import io.github.objectobject.hexdummyexample.Hexdummyexample
import io.github.objectobject.hexdummyexample.networking.msg.HexdummyexampleMessageCompanion

object HexdummyexampleNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Hexdummyexample.id("networking_channel"))

    fun init() {
        for (subclass in HexdummyexampleMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
