package quaternary.superbalancedmodmultiblockfurnace2theempiresmeltsback;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(
				modid = SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack.MODID,
				name = SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack.NAME,
				version = SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack.VERSION
)
@Mod.EventBusSubscriber
public class SuperBalancedModMultiblockFurnace2TheEmpireSmeltsBack {
	public static final String MODID = "superbalancedmodmultiblockfurnace2theempiresmeltsback";
	public static final String NAME = "Super Balanced Mod Multiblock Furnace 2: The Empire Smelts Back";
	public static final String VERSION = "GRADLE:VERSION";
	
	public static final Item.ToolMaterial BALANCEMATERIAL = EnumHelper.addToolMaterial("balance", 9999, 6969, 1000, 1000, 1000);
	
	public static final CreativeTabs TAB = new CreativeTabs(MODID) {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ITEM_BALANCED_FURNACE);
		}
	};
	
	public static BlockBalancedFurnace BALANCED_FURNACE = null;
	
	public static ItemBlock ITEM_BALANCED_FURNACE = null;
	
	public static Item CLAY_LATTICE = null;
	public static Item EFFORT_STAR = null;
	public static Item BALANCED_SWORD = null;
	
	@SubscribeEvent
	public static void blocks(RegistryEvent.Register<Block> e) {
		IForgeRegistry<Block> reg = e.getRegistry();
		
		BALANCED_FURNACE = regBlock(new BlockBalancedFurnace(), "balanced_furnace", reg);
		
		GameRegistry.registerTileEntity(TileBalancedFurnace.class, new ResourceLocation(MODID, "balanced_furnace"));
	}
	
	@SubscribeEvent
	public static void items(RegistryEvent.Register<Item> e) {
		IForgeRegistry<Item> reg = e.getRegistry();
		
		ITEM_BALANCED_FURNACE = regItemBlock(new ItemBlock(BALANCED_FURNACE), reg);
		
		CLAY_LATTICE = regItem(new Item(), "clay_lattice", reg);
		EFFORT_STAR = regItem(new Item(), "effort_star", reg);
		BALANCED_SWORD = regItem(new ItemBalancedSword(), "balanced_sword", reg);
	}
	
	private static <T extends Block> T regBlock(T block, String name, IForgeRegistry<Block> reg) {
		block.setRegistryName(name);
		block.setTranslationKey(MODID + '.' + name);
		block.setCreativeTab(TAB);
		reg.register(block);
		return block;
	}
	
	private static <T extends Item> T regItem(T item, String name, IForgeRegistry<Item> reg) {
		item.setRegistryName(name);
		item.setTranslationKey(MODID + '.' + name);item.setCreativeTab(TAB);
		reg.register(item);
		return item;
	}
	
	private static <T extends ItemBlock> T regItemBlock(T itemBlock, IForgeRegistry<Item> reg) {
		itemBlock.setRegistryName(itemBlock.getBlock().getRegistryName());
		reg.register(itemBlock);itemBlock.setCreativeTab(TAB);
		return itemBlock;
	}
	
	@SubscribeEvent
	public static void damageEvent(LivingDamageEvent e) {
		if(e.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) e.getEntity();
			if(player.getHeldItemMainhand().getItem() instanceof ItemBalancedSword || player.getHeldItemOffhand().getItem() instanceof ItemBalancedSword) {
				e.setCanceled(true);
			}
		}
	}
}
