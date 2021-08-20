package jingy.jineric.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.tag.BlockTags;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
	@Inject(at = @At("HEAD"), method = "isOnSoulSpeedBlock()Z", cancellable = true)
	protected void jineric$handleSoulSpeedForSlabsAndFences(CallbackInfoReturnable<Boolean> cir) {
		// check feet pos block
		if (((LivingEntity) ((Object) this)).world.getBlockState(((LivingEntity) ((Object) this)).getBlockPos()).isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
			cir.setReturnValue(true);
		}
		// check head pos block
		if (((LivingEntity) ((Object) this)).world.getBlockState(((LivingEntity) ((Object) this)).getBlockPos().add(0, 1, 0)).isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
			cir.setReturnValue(true);
		}
	}
}