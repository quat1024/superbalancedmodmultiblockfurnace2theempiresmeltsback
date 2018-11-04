package quaternary.superbalancedmodmultiblockfurnace2theempiresmeltsback;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBalancedSword extends ItemSword {
	public ItemBalancedSword() {
		super(SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack.BALANCEMATERIAL);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("superbalancedmodmultiblockfurnace2theempiresmeltsback.balanced_sword.tooltip"));
	}
}
