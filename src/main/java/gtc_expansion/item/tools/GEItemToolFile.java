package gtc_expansion.item.tools;

import gtc_expansion.GTCExpansion;
import gtc_expansion.material.GEMaterial;
import gtclassic.GTMod;
import gtclassic.color.GTColorItemInterface;
import gtclassic.material.GTMaterial;
import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.obj.ILayeredItemModel;
import ic2.core.platform.textures.obj.IStaticTexturedItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GEItemToolFile extends Item implements IStaticTexturedItem, GTColorItemInterface, ILayeredItemModel {

    GTMaterial material;

    public GEItemToolFile(GTMaterial mat, Item.ToolMaterial tmat) {
        this.maxStackSize = 1;
        this.material = mat;
        this.setMaxDamage(tmat.getMaxUses());
        setRegistryName(this.material.getName() + "_file");
        setUnlocalizedName(GTCExpansion.MODID + "." + this.material.getName() + "_file");
        setCreativeTab(GTMod.creativeTabGT);
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack copy = itemStack.copy();
        return copy.attemptDamageItem(1, itemRand, null) ? ItemStack.EMPTY : copy;
    }

    @Override
    public List<Integer> getValidVariants() {
        return Arrays.asList(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int meta) {
        return Ic2Icons.getTextures(GTCExpansion.MODID + "_materials")[18];
    }

    @Override
    public Color getColor(ItemStack stack, int index) {
        if (index == 0) {
            return GEMaterial.Wood.getColor();
        } else {
            return this.material.getColor();
        }
    }

    @Override
    public boolean isLayered(ItemStack var1) {
        return true;
    }

    @Override
    public int getLayers(ItemStack var1) {
        return 2;
    }

    @Override
    public TextureAtlasSprite getTexture(int var1, ItemStack var2) {
        return Ic2Icons.getTextures(GTCExpansion.MODID + "_materials")[18 + var1];
    }
}