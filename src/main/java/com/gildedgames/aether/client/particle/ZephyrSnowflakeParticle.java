package com.gildedgames.aether.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ZephyrSnowflakeParticle extends SpriteTexturedParticle {
    private final IAnimatedSprite sprites;

    public ZephyrSnowflakeParticle(ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, IAnimatedSprite sprites) {
        super(worldIn, x, y, z);
        this.gravity = 0.225F;
        this.xd = xSpeed + (Math.random() * 2.0D - 1.0D) * 0.05D;
        this.yd = ySpeed + (Math.random() * 2.0D - 1.0D) * 0.05D;
        this.zd = zSpeed + (Math.random() * 2.0D - 1.0D) * 0.05D;
        this.sprites = sprites;
        this.quadSize = 0.1F * (this.random.nextFloat() * this.random.nextFloat() * 1.0F + 1.0F);
        this.lifetime = (int) (16.0D / ((double) this.random.nextFloat() * 0.8D + 0.2D)) + 2;
        this.setSpriteFromAge(sprites);
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
        this.xd *= 0.95D;
        this.yd *= 0.9D;
        this.zd *= 0.95D;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite spriteSetIn) {
            this.spriteSet = spriteSetIn;
        }

        @Override
        public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ZephyrSnowflakeParticle particle = new ZephyrSnowflakeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
            particle.setColor(0.923F, 0.964F, 0.999F);
            return particle;
        }
    }
}
