package com.pandaismyname1.originclasseszoomerpatch;

import io.github.edwinmindcraft.apoli.api.component.IPowerContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;

public class Common {

    public static void handleTrade(MerchantOffer offer, Player tradingPlayer, HashMap<MerchantOffer, Float> merchantTradeIndicies, CallbackInfo ci) {
        var playerPowers = IPowerContainer.getPowers(tradingPlayer, Powers.INFINITE_TRADE_ZOOMPACK.get());
        playerPowers.forEach(power -> {
            if (power.get().getFactory().equals(Powers.INFINITE_TRADE_ZOOMPACK.get())) {
                var powerValue = IPowerContainer.modify(
                        tradingPlayer,
                        Powers.INFINITE_TRADE_ZOOMPACK.get(),
                        0,
                        cp -> cp.get().isActive(tradingPlayer)
                );
                if (merchantTradeIndicies.containsKey(offer)) {
                    merchantTradeIndicies.put(offer, merchantTradeIndicies.get(offer) + powerValue);
                } else {
                    merchantTradeIndicies.put(offer, powerValue);
                }
                if (merchantTradeIndicies.get(offer) >= 1) {
                    --offer.uses;
                    merchantTradeIndicies.put(offer, merchantTradeIndicies.get(offer) - 1);
                }
            }
        });
    }
}
