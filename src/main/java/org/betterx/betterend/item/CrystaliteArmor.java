package org.betterx.betterend.item;

import org.betterx.betterend.effects.EndStatusEffects;
import org.betterx.betterend.item.material.EndArmorTier;
import org.betterx.betterend.trait.item.EndArmorItemTraitBuilder;
import org.betterx.wover.complex.api.equipment.ArmorSlot;
import org.betterx.wover.item.api.ArmorItemDefinition;
import org.betterx.wover.item.api.ItemDefinition;
import org.betterx.wover.item.api.ItemRegistry;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CrystaliteArmor extends Item {
    protected static <I extends CrystaliteArmor> ItemDefinition<I, ?> crystaliteArmorDefinition(
            ItemRegistry registry,
            String name,
            ArmorSlot slot,
            ArmorItemDefinition.ItemFactory<I> factory
    ) {
        return registry.defineArmorItem(name, factory)
                       .addTrait(EndArmorItemTraitBuilder.BUILDER.with(slot, EndArmorTier.CRYSTALITE));
    }

    public final static MutableComponent CHEST_DESC;
    public final static MutableComponent BOOTS_DESC;

    public CrystaliteArmor(ItemDefinition<?, ?> definition) {
        super(definition.getProperties());
    }

    private static final EquipmentSlot[] SET_SLOTS = {
            EquipmentSlot.HEAD,
            EquipmentSlot.CHEST,
            EquipmentSlot.LEGS,
            EquipmentSlot.FEET
    };

    public static boolean hasFullSet(LivingEntity owner) {
        for (EquipmentSlot slot : SET_SLOTS) {
            ItemStack armorStack = owner.getItemBySlot(slot);
            if (!(armorStack.getItem() instanceof CrystaliteArmor)) {
                return false;
            }
        }
        return true;
    }

    public static void applySetEffect(LivingEntity owner) {
        if ((owner.tickCount & 63) == 0) {
            owner.addEffect(new MobEffectInstance(EndStatusEffects.CRYSTALITE_HEALTH_REGEN));
        }
    }

    static {
        Style descStyle = Style.EMPTY.applyFormats(ChatFormatting.DARK_AQUA, ChatFormatting.ITALIC);
        CHEST_DESC = Component.translatable("tooltip.armor.crystalite_chest");
        CHEST_DESC.setStyle(descStyle);
        BOOTS_DESC = Component.translatable("tooltip.armor.crystalite_boots");
        BOOTS_DESC.setStyle(descStyle);
    }
}
