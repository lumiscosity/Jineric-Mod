package jingy.jineric.registry;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItems;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;

public class ColorProviders {

   public static void registerColorProviders() {
      ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
              world != null && pos != null
                      ? BiomeColors.getGrassColor(world, pos)
                      : GrassColors.getColor(0.5D, 1.0D), JinericBlocks.FULL_GRASS_BLOCK);


      ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
              world != null && pos != null
                      ? BiomeColors.getGrassColor(world, pos)
                      : GrassColors.getColor(0.5D, 1.0D), JinericBlocks.JUNGLE_LADDER);

      ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D)), JinericItems.FULL_GRASS_BLOCK);
      ColorProviderRegistry.ITEM.register((((stack, tintIndex) -> tintIndex > 0 ? -1 : GrassColors.getColor(0.5D, 1.0D))), JinericItems.JUNGLE_LADDER);
   }
}
