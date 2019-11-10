package gtc_expansion.util.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import gtc_expansion.recipes.GERecipeLists;
import gtc_expansion.tile.GETileAlloySmelter;
import gtclassic.util.crafttweaker.GTCraftTweakerActions;
import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Locale;

@ZenClass("mods.gtclassic.AlloySmelter")
@ZenRegister
public class GEAlloySmelterSupport {
    @ZenMethod
    public static void addRecipe(IItemStack output, IIngredient input1, IIngredient input2){
        GTCraftTweakerActions.apply(new AlloySmelterRecipeAction(GTCraftTweakerActions.of(input1), GTCraftTweakerActions.of(input2), CraftTweakerMC.getItemStack(output)));
    }

    private static final class AlloySmelterRecipeAction implements IAction {

        private final IRecipeInput input1;
        private final IRecipeInput input2;
        private final ItemStack output;

        AlloySmelterRecipeAction(IRecipeInput input1, IRecipeInput input2, ItemStack output) {
            this.input1 = input1;
            this.input2 = input2;
            this.output = output;
        }

        @Override
        public void apply() {
            GETileAlloySmelter.addRecipe(input1, input2, output);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Recipe[%s, %s -> %s] to %s", input1, input2, output, GERecipeLists.ALLOY_SMELTER_RECIPE_LIST);
        }
    }
}