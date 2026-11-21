package com.gildedgames.aether.common.item.accessories.miscellaneous;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.common.item.accessories.AccessoryItem;
import net.minecraft.util.ResourceLocation;

public class ShieldOfRepulsionItem extends AccessoryItem
{
    private static final ResourceLocation SHIELD_OF_REPULSION = new ResourceLocation(Aether.MODID, "textures/models/accessory/shield_of_repulsion/shield_of_repulsion_accessory.png");
    private static final ResourceLocation SHIELD_OF_REPULSION_INACTIVE = new ResourceLocation(Aether.MODID, "textures/models/accessory/shield_of_repulsion/shield_of_repulsion_inactive_accessory.png");

    public ShieldOfRepulsionItem(Properties properties) {
        super(properties);
    }

    public ResourceLocation getShieldOfRepulsionTexture() {
        return SHIELD_OF_REPULSION;
    }

    public ResourceLocation getShieldOfRepulsionInactiveTexture() {
        return SHIELD_OF_REPULSION_INACTIVE;
    }
}
