package com.alcatrazescapee.cyanide.mixin.accessor;

import net.minecraft.world.level.biome.Biome;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

// Forge already ATs ClimateSettings
@Mixin(Biome.ClimateSettings.class)
public interface BiomeClimateSettingsAccessor
{
    @Invoker("<init>")
    static Biome.ClimateSettings cyanide$new(Biome.Precipitation precipitation, float temperature, Biome.TemperatureModifier temperatureModifier, float downfall)
    {
        throw new AssertionError();
    }

    @Accessor("precipitation")
    Biome.Precipitation cyanide$getPrecipitation();

    @Accessor("temperature")
    float cyanide$getTemperature();

    @Accessor("temperatureModifier")
    Biome.TemperatureModifier cyanide$getTemperatureModifier();

    @Accessor("downfall")
    float cyanide$getDownfall();
}
