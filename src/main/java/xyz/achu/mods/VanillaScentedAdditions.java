package xyz.achu.mods;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.gen.Accessor;
import xyz.achu.mods.block.GratedMagmaBlock;

public class VanillaScentedAdditions implements ModInitializer {
	public static final Block GRATED_MAGMA_BLOCK = new GratedMagmaBlock(
			FabricBlockSettings.of(Material.METAL, MaterialColor.NETHER)
					.hardness(4.0f)
					.sounds(BlockSoundGroup.LANTERN)
					.requiresTool()
					.luminance((state) -> {return 3;})
					.postProcess((state, world, pos) -> true)
					.emissiveLighting((state, world, pos) -> true)
	);

	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");
		Registry.register(Registry.BLOCK, new Identifier("vanillascented", "grated_magma_block"), GRATED_MAGMA_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("vanillascented", "grated_magma_block"), new BlockItem(GRATED_MAGMA_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
	}

}
