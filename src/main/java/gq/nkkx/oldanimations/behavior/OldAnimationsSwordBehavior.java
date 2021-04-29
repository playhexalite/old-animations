package gq.nkkx.oldanimations.behavior;

import gq.nkkx.oldanimations.client.OldAnimationsClient;
import gq.nkkx.oldanimations.features.SwordBlockingFeature;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class OldAnimationsSwordBehavior implements IBehavior {

    public void injectUseAction(ItemStack item, CallbackInfoReturnable<UseAction> callbackInfo) {
        if (OldAnimationsClient.options().getSwordBlocking().isEnabled() && item.getItem() instanceof SwordItem) {
            callbackInfo.setReturnValue(UseAction.BLOCK);
        }
    }

    public void use(PlayerEntity player, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> callbackInfo) {
        if (SwordBlockingFeature.isEnabled()) {
            SwordBlockingFeature.LAZY.get().use(player, hand, callbackInfo);
        }
    }

}
