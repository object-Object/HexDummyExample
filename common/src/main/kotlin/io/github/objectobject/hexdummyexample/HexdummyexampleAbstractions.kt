@file:JvmName("HexdummyexampleAbstractions")

package io.github.objectobject.hexdummyexample

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.objectobject.hexdummyexample.registry.HexdummyexampleRegistrar

fun initRegistries(vararg registries: HexdummyexampleRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexdummyexampleRegistrar<T>) {
    throw AssertionError()
}
