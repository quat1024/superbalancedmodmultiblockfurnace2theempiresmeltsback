package quaternary.superbalancedmodmultiblockfurnace2theempiresmeltsback;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack.MODID)
public class ASdmnbasd {
	@SubscribeEvent
	public static void models(ModelRegistryEvent e) {
		m(SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack.ITEM_BALANCED_FURNACE);
		m(SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack.BALANCED_SWORD);
		m(SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack.CLAY_LATTICE);
		m(SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack.EFFORT_STAR);
	}
	
	public static void m(Item i) {
		ModelResourceLocation asd = new ModelResourceLocation(i.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(i, 0, asd);
	}
}
