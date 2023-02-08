package jingy.jineric.sound;

import jingy.jineric.base.JinericMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class JinericSoundEvents {

   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BREAK = register("block.soul_sandstone.break");
//   public static SoundEvent BLOCK_SOUL_SANDSTONE_FALL = register("block.soul_sandstone.fall");
//   public static SoundEvent BLOCK_SOUL_SANDSTONE_HIT = register("block.soul_sandstone.hit");
   public static SoundEvent BLOCK_SOUL_SANDSTONE_PLACE = register("block.soul_sandstone.place");
   public static SoundEvent BLOCK_SOUL_SANDSTONE_STEP = register("block.soul_sandstone.step");

   private static SoundEvent register(String name) {
      Identifier id = new Identifier(JinericMain.MOD_ID, name);
      return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
   }

   public static void init() {

   }
}
