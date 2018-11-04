package quaternary.superbalancedmodmultiblockfurnace2theempiresmeltsback;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileBalancedFurnace extends TileEntity implements IItemHandler {
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return true;
		} else return super.hasCapability(capability, facing);
	}
	
	@Nullable
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return (T) this;
		} else return super.getCapability(capability, facing);
	}
	
	@Override
	public int getSlots() {
		return 1;
	}
	
	@Nonnull
	@Override
	public ItemStack getStackInSlot(int slot) {
		return ItemStack.EMPTY;
	}
	
	@Nonnull
	@Override
	public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
		if(!simulate) {
			ItemStack smeltResult = FurnaceRecipes.instance().getSmeltingResult(stack).copy();
			smeltResult.setCount(smeltResult.getCount() * 3); //ORE TTRIPLAOIJDOASLDK
			
			EntityItem asd = new EntityItem(world, pos.getX() + .5, pos.getY() + 1.5, pos.getZ() + .5, smeltResult);
			asd.motionX = 0;
			asd.motionY = 0.5;
			asd.motionZ = 0;
			world.spawnEntity(asd);
		}
		return ItemStack.EMPTY;
	}
	
	@Nonnull
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		return ItemStack.EMPTY;
	}
	
	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}
}
