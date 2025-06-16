package io.github.objectobject.hexdummyexample.registry

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.castables.Action
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.HexRegistries
import at.petrak.hexcasting.common.lib.hex.HexActions
import io.github.objectobject.hexdummyexample.casting.actions.spells.OpCongratulate

object HexdummyexampleActions : HexdummyexampleRegistrar<ActionRegistryEntry>(
    HexRegistries.ACTION,
    { HexActions.REGISTRY },
) {
    val CONGRATULATE = make("congratulate", HexDir.WEST, "eed", OpCongratulate)

    private fun make(name: String, startDir: HexDir, signature: String, action: Action) =
        make(name, startDir, signature) { action }

    private fun make(name: String, startDir: HexDir, signature: String, getAction: () -> Action) = register(name) {
        ActionRegistryEntry(HexPattern.fromAngles(signature, startDir), getAction())
    }
}
