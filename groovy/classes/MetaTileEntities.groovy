package classes

import gregtech.api.GTValues
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity
import gregtech.api.recipes.RecipeMap
import gregtech.api.recipes.RecipeMaps
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.PrimitiveRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.api.unification.material.Materials
import gregtech.api.util.GTUtility
import gregtech.client.renderer.ICubeRenderer
import gregtech.client.renderer.texture.Textures
import gregtech.common.blocks.BlockTurbineCasing
import gregtech.common.blocks.MetaBlocks
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch
import gregtech.common.metatileentities.storage.MetaTileEntityDrum
import net.minecraft.util.ResourceLocation
import org.jetbrains.annotations.NotNull
import gregtech.api.gui.GuiTextures
import gregtech.api.gui.widgets.ProgressWidget
import gregtech.core.sound.GTSoundEvents

import java.util.function.Function

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity

public class MetaTileEntities {
    public static SimpleMachineMetaTileEntity[] WEAPONS_FACTORY

    public static final RecipeMap<SimpleRecipeBuilder> WEAPONS_FACTORY_RECIPES = new RecipeMap<>("weapons_factory", 9, 1, 2, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER)

    public static void init() {
        WEAPONS_FACTORY = new SimpleMachineMetaTileEntity[GTValues.UV];
        registerSimpleMTE(WEAPONS_FACTORY, GTValues.UV, 15026, "weapons_factory", WEAPONS_FACTORY_RECIPES, Textures.ASSEMBLER_OVERLAY, true, GTUtility.defaultTankSizeFunction)
    }

    private static void registerSimpleMTE(SimpleMachineMetaTileEntity[] machines, int maxTier, int startId, String name, RecipeMap<?> map, ICubeRenderer texture, boolean hasFrontFacing, Function<Integer, Integer> tankScalingFunction) {
        for (int i = 0; i < maxTier; i++) {
            machines[i] = registerMetaTileEntity(startId + i, new SimpleMachineMetaTileEntity(itemId(String.format("%s.%s", name, GTValues.VN[i + 1].toLowerCase())), map, texture, i + 1, hasFrontFacing, tankScalingFunction))
        }
    }

    private static @NotNull ResourceLocation itemId(@NotNull String name) {
        return new ResourceLocation("gcp", name);
    }
}
