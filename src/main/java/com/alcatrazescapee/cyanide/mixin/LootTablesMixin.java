/*
 * Part of the Cyanide mod.
 * Licensed under MIT. See the project LICENSE.txt for details.
 */

package com.alcatrazescapee.cyanide.mixin;

import org.apache.logging.log4j.Logger;
import net.minecraft.world.level.storage.loot.LootTables;

import com.alcatrazescapee.cyanide.codec.MixinHooks;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LootTables.class)
public abstract class LootTablesMixin
{
    /**
     * Improve logging message, don't dump stacktrace
     */
    @Dynamic("Lambda method in LootTables#apply()")
    @Redirect(method = "*(Lnet/minecraft/server/packs/resources/ResourceManager;Lcom/google/common/collect/ImmutableMap$Builder;Lnet/minecraft/resources/ResourceLocation;Lcom/google/gson/JsonElement;)V", at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", remap = false), require = 0)
    private void simplifyLootTableErrors(Logger logger, String message, Object p0, Object p1)
    {
        MixinHooks.cleanLootTableError(logger, message, p0, p1);
    }
}
