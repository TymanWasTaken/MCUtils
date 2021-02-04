package com.tyman.mcutils.mixin;

import com.tyman.mcutils.config.ItemConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ItemStack.class)
public abstract class MixinItemStack extends ItemStack {
    @Inject(method = "getTooltip", at = @At("HEAD"), cancellable = true)
    public void onGetTooltip(EntityPlayer playerIn, boolean advanced, CallbackInfoReturnable<List<String>> cir) {
        Item item = this.getItem();
        cir.setReturnValue(tooltip);
    }
}
