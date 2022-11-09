package jingy.jineric.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.WallBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableWallBlock extends WallBlock implements Oxidizable {
   private final Oxidizable.OxidationLevel oxidationLevel;

   public OxidizableWallBlock(Oxidizable.OxidationLevel oxidationLevel, AbstractBlock.Settings settings) {
      super(settings);
      this.oxidationLevel = oxidationLevel;
   }

   @Override
   public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
      this.tickDegradation(state, world, pos, random);
   }

   @Override
   public boolean hasRandomTicks(BlockState state) {
      return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
   }

   public OxidationLevel getDegradationLevel() {
      return this.oxidationLevel;
   }
}
