package org.betterx.betterend.item.material;

import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.registry.EndItems;
import org.betterx.betterend.registry.EndTemplates;
import org.betterx.wover.complex.api.equipment.ArmorSlot;
import org.betterx.wover.complex.api.equipment.EquipmentSet;
import org.betterx.wover.complex.api.equipment.ToolSlot;
import org.betterx.wover.item.api.trait.ItemTraits;
import org.betterx.wover.recipe.api.RecipeBuilder;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import org.jetbrains.annotations.NotNull;

public class AeterniumSet extends EquipmentSet {
    public AeterniumSet() {
        super(BetterEnd.C, "aeternium", EndToolTier.AETERNIUM, EndArmorTier.AETERNIUM, Items.STICK);

        add(
                ToolSlot.PICKAXE_SLOT,
                ItemTraits.RECIPE_ITEM.with(
                        (key, item, context) -> {
                            RecipeBuilder.smithing(key.location(), item)
                                         .template(EndTemplates.LEATHER_HANDLE_ATTACHMENT)
                                         .base(EndItems.AETERNIUM_PICKAXE_HEAD)
                                         .addon(EndItems.LEATHER_WRAPPED_STICK)
                                         .build(context);
                        }
                )
        );
        add(ToolSlot.AXE_SLOT);
        add(ToolSlot.SHOVEL_SLOT);
        add(ToolSlot.HOE_SLOT);
        add(ToolSlot.SWORD_SLOT);
        add(ToolSlot.HAMMER_SLOT);

        add(ArmorSlot.HELMET_SLOT);
        add(ArmorSlot.CHESTPLATE_SLOT);
        add(ArmorSlot.LEGGINGS_SLOT);
        add(ArmorSlot.BOOTS_SLOT);
    }

    @Override
    public @NotNull Item.Properties commonToolProperties(Item.@NotNull Properties properties) {
        return super.commonToolProperties(properties).fireResistant();
    }

    public @NotNull Item pickaxe() {
        return this.get(ToolSlot.PICKAXE_SLOT);
    }

    public @NotNull Item axe() {
        return this.get(ToolSlot.AXE_SLOT);
    }
}
