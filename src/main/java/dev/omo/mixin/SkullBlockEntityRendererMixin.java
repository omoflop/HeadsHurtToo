package dev.omo.mixin;

import dev.omo.HeadsHurtToo;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(SkullBlockEntityRenderer.class)
public abstract class SkullBlockEntityRendererMixin {
    @ModifyArgs(method = "renderSkull", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/SkullBlockEntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"))
    private static void headsHurtToo$replaceOverlay(Args args) {
        if (HeadsHurtToo.isRenderingHead) {
            HeadsHurtToo.isRenderingHead = false;
            args.set(3, HeadsHurtToo.headOverlay);
        }
    }
}
