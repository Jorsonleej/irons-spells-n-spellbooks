package com.example.testmod.item;

import com.example.testmod.capabilities.scroll.data.ScrollData;
import com.example.testmod.capabilities.scroll.data.ScrollDataProvider;
import com.example.testmod.capabilities.spellbook.data.SpellBookData;
import com.example.testmod.capabilities.spellbook.data.SpellBookDataProvider;
import com.example.testmod.spells.SpellType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public abstract class AbstractScroll extends Item {

    protected SpellType spellType;
    protected int level;

    public AbstractScroll(SpellType spellType, int level, Rarity rarity) {
        super(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT).rarity(rarity));
        this.spellType = spellType;
        this.level = level;
    }

    protected void removeScrollAfterCast(Player player, ItemStack stack) {
        if (!player.isCreative())
            player.getInventory().removeItem(stack);
    }

    public ScrollData getScrollData(ItemStack stack) {
        return stack.getCapability(ScrollDataProvider.SCROLL_DATA).resolve().get();
    }
}