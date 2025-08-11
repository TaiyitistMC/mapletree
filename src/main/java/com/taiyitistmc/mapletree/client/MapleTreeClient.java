package com.taiyitistmc.mapletree.client;

import com.taiyitistmc.mapletree.MapleTree;
import com.taiyitistmc.mapletree.common.block.MapleTreeLeavesBlock;
import com.taiyitistmc.mapletree.common.init.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = MapleTree.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = MapleTree.MODID, value = Dist.CLIENT)
public class MapleTreeClient {

    public MapleTreeClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerBlockClients(FMLClientSetupEvent event) {
        ModBlocks.BLOCKS.getEntries().forEach(blockDeferredHolder -> {
            if (blockDeferredHolder.get() instanceof MapleTreeLeavesBlock leavesBlock) {
                ItemBlockRenderTypes.setRenderLayer(leavesBlock, ItemBlockRenderTypes.renderCutout ? RenderType.cutoutMipped() : RenderType.solid());
            }else if (blockDeferredHolder.get().getDescriptionId().contains("sapling")) {
                ItemBlockRenderTypes.setRenderLayer(blockDeferredHolder.get(), RenderType.cutoutMipped());
            }
        });
    }

}
