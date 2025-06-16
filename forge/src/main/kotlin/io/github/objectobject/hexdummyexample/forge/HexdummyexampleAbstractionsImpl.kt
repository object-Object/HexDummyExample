@file:JvmName("HexdummyexampleAbstractionsImpl")

package io.github.objectobject.hexdummyexample.forge

import io.github.objectobject.hexdummyexample.registry.HexdummyexampleRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HexdummyexampleRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
