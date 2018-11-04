package quaternary.superbalancedmodmultiblockfurnace2theempiresmeltsback;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockBalancedFurnace extends Block {
	public BlockBalancedFurnace() {
		super(Material.ROCK);
		setHardness(3.5f);
		setSoundType(SoundType.STONE);
		setDefaultState(getDefaultState().withProperty(ACTIVE, false).withProperty(FACING, EnumFacing.NORTH));
	}
	
	public static final PropertyBool ACTIVE = PropertyBool.create("active");
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileBalancedFurnace();
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		boolean isActive = state.getValue(ACTIVE);
		
		int clayCount = 0;
		for(EnumFacing whichWay : EnumFacing.HORIZONTALS) {
			if(worldIn.getBlockState(pos.offset(whichWay)).getBlock() == Blocks.CLAY) {
				clayCount++;
			}
		}
		
		boolean shouldActive = clayCount >= 2;
		
		if(isActive != shouldActive) {
			worldIn.setBlockState(pos, state.withProperty(ACTIVE, shouldActive));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		boolean active = (meta & 4) != 0;
		EnumFacing whichWay = EnumFacing.byHorizontalIndex(meta & 4);
		return getDefaultState().withProperty(ACTIVE, active).withProperty(FACING, whichWay);
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex() | (state.getValue(ACTIVE) ? 4 : 0);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, ACTIVE, FACING);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("superbalancedmodmultiblockfurnace2theempiresmeltsback.asd"));
		tooltip.add(I18n.translateToLocal("superbalancedmodmultiblockfurnace2theempiresmeltsback.asd2"));
		tooltip.add(I18n.translateToLocal("superbalancedmodmultiblockfurnace2theempiresmeltsback.asd3"));
	}
}
