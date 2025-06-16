@file:JvmName("HexdummyexampleAbstractionsImpl")

package io.github.objectobject.hexdummyexample.fabric

import io.github.objectobject.hexdummyexample.registry.HexdummyexampleRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexdummyexampleRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
