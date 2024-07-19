package com.pandaismyname1.originclasseszoomerpatch;

import dev.limonblaze.originsclasses.OriginsClasses;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import io.github.edwinmindcraft.apoli.api.registry.ApoliRegistries;
import io.github.edwinmindcraft.apoli.common.power.ModifyValuePower;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Powers {
    public static final DeferredRegister<PowerFactory<?>> POWER_FACTORIES = DeferredRegister.create(ApoliRegistries.POWER_FACTORY_KEY, OriginClassesZoomerPatch.MODID);

    public static final RegistryObject<ModifyValuePower> INFINITE_TRADE_ZOOMPACK = POWER_FACTORIES.register("infinite_trade_zoom", ModifyValuePower::new);

}
