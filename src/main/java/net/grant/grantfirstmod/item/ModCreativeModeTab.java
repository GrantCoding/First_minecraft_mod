package net.grant.grantfirstmod.item;

import net.grant.grantfirstmod.GrantFirstMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GrantFirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab GRANTS_ITEMS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        GRANTS_ITEMS = event.registerCreativeModeTab(new ResourceLocation(GrantFirstMod.MOD_ID, "grants_items"),
                builder -> builder.icon(() -> new ItemStack(ModItems.KINGSWORD.get())).title(Component.literal("Grants Items")).build());
    }
}