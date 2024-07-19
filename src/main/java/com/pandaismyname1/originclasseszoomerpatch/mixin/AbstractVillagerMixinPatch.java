package com.pandaismyname1.originclasseszoomerpatch.mixin;

import com.pandaismyname1.originclasseszoomerpatch.Common;
import com.pandaismyname1.originclasseszoomerpatch.Powers;
import dev.limonblaze.originsclasses.OriginsClasses;
import io.github.edwinmindcraft.apoli.api.component.IPowerContainer;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.ClientSideMerchant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;

@Mixin(AbstractVillager.class)
public class AbstractVillagerMixinPatch {

    @Shadow
    private Player tradingPlayer;

    private static HashMap<MerchantOffer, Float> merchantTradeIndicies = new HashMap<>();

    @Inject(method = "notifyTrade", at = @At("TAIL"))
    public void handleTrade(MerchantOffer offer, CallbackInfo ci) {
        Common.handleTrade(offer, tradingPlayer, merchantTradeIndicies, ci);
    }
}



