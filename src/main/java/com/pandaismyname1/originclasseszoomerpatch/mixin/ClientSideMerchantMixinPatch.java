package com.pandaismyname1.originclasseszoomerpatch.mixin;

import com.pandaismyname1.originclasseszoomerpatch.Common;
import dev.limonblaze.originsclasses.OriginsClasses;
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

@OnlyIn(Dist.CLIENT)
@Mixin(ClientSideMerchant.class)
public abstract class ClientSideMerchantMixinPatch {

    @Shadow public abstract Player getTradingPlayer();

    private static HashMap<MerchantOffer, Float> merchantTradeIndicies = new HashMap<>();

    @Inject(method = "notifyTrade", at = @At(value = "TAIL"))
    private void originsClasses$infiniteTrade(MerchantOffer offer, CallbackInfo ci) {
        Common.handleTrade(offer, getTradingPlayer(), merchantTradeIndicies, ci);
    }

}
