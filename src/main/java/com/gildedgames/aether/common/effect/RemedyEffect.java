package com.gildedgames.aether.common.effect;

import com.gildedgames.aether.common.registry.AetherEffects;
import com.gildedgames.aether.core.capability.interfaces.IAetherPlayer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class RemedyEffect extends Effect {
    private int effectDuration;

    public RemedyEffect() {
        super(EffectType.BENEFICIAL, 5031241);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;
            IAetherPlayer.get(player).ifPresent((aetherPlayer) -> {
                if (aetherPlayer.getRemedyMaximum() <= 0) {
                    aetherPlayer.setRemedyMaximum(this.effectDuration);
                }
                aetherPlayer.setRemedyTimer(this.effectDuration);
            });
        }
        if (livingEntity.hasEffect(AetherEffects.INEBRIATION.get())) {
            livingEntity.removeEffect(AetherEffects.INEBRIATION.get());
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        this.effectDuration = duration;
        return true;
    }
}
