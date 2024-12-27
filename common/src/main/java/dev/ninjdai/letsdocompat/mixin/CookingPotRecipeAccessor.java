package dev.ninjdai.letsdocompat.mixin;

import net.minecraft.world.item.ItemStack;
import net.satisfy.farm_and_charm.recipe.CookingPotRecipe;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CookingPotRecipe.class)
public interface CookingPotRecipeAccessor {
    @Accessor
    ItemStack getOutput();
}
