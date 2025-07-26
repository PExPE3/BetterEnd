package org.betterx.betterend.item;

import org.betterx.wover.complex.api.equipment.ArmorSlot;
import org.betterx.wover.item.api.ItemDefinition;
import org.betterx.wover.item.api.ItemRegistry;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class CrystaliteLeggings extends CrystaliteArmor {
    public static ItemDefinition<CrystaliteLeggings, ?> definition(ItemRegistry registry, String name) {
        return CrystaliteArmor.crystaliteArmorDefinition(
                registry, name, ArmorSlot.LEGGINGS_SLOT,
                CrystaliteLeggings::new
        ).addAttribute(
                Attributes.MAX_HEALTH,
                new AttributeModifier(
                        EndArmorItem.MAX_HEALTH_BOOST,
                        4.0,
                        AttributeModifier.Operation.ADD_VALUE
                ),
                EquipmentSlotGroup.LEGS
        );
    }

    public CrystaliteLeggings(ItemDefinition<?, ?> definition) {
        super(definition);
    }
}
