package hero.bane.mixin;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.border.WorldBorder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(WorldBorder.class)
public abstract class WorldBorder_ContainsRevertMixin {
	@Shadow
	public abstract double getBoundNorth();

	@Shadow
	public abstract double getBoundSouth();

	@Shadow
	public abstract double getBoundEast();

	@Shadow
	public abstract double getBoundWest();

	/**
	 * Reverts the check for the world border to 1.20
	 * @author HerobaneNair
	 * @reason So you can place blocks on the block the border intersects
	 */
	@Overwrite
	public boolean contains(BlockPos pos) {
		return (double)(pos.getX() + 1) > this.getBoundWest() && (double)pos.getX() < this.getBoundEast() && (double)(pos.getZ() + 1) > this.getBoundNorth() && (double)pos.getZ() < this.getBoundSouth();
	}

}
