package net.grant.grantfirstmod;

import com.mojang.logging.LogUtils;
import net.grant.grantfirstmod.block.ModBlocks;
import net.grant.grantfirstmod.item.ModCreativeModeTab;
import net.grant.grantfirstmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GrantFirstMod.MOD_ID)
public class GrantFirstMod
{
    public static final String MOD_ID = "grantfirstmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    //Very Important Mod
    public GrantFirstMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code

    }
    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        //Extra tab entry for items in creative mode
        if(event.getTab() == ModCreativeModeTab.GRANTS_ITEMS) {
            event.accept(ModItems.KINGSWORD);
            event.accept(ModItems.SUNBLOCK);
        }

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
