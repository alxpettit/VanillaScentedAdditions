package xyz.achu.mods;
// TODO: fix break particles for Shock Absorber
// TODO: custom sounds for stepping on Shock Absorber

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.achu.mods.block.GratedMagmaBlock;
import xyz.achu.mods.block.GratedSoulSandBlock;
import xyz.achu.mods.block.ShockAbsorberBlock;

public class VanillaScentedAdditions implements ModInitializer {
	static String MODID = "vanillascented";
	public static SoundEvent SOUND_EVENT_LOWER_SHOCK_ABSORBER = createSound("lower_shock_absorber");
	public static SoundEvent SOUND_EVENT_RAISE_SHOCK_ABSORBER = createSound("raise_shock_absorber");

	public static final Block GRATED_MAGMA_BLOCK = new GratedMagmaBlock(
			FabricBlockSettings.of(Material.METAL, MaterialColor.NETHER)
					.hardness(4.0f)
					.sounds(BlockSoundGroup.LANTERN)
					.requiresTool()
					.luminance((state) -> 3)
					.postProcess((state, world, pos) -> true)
					.emissiveLighting((state, world, pos) -> true)
	);
	
	public static final Block GRATED_SOUL_SAND_BLOCK = new GratedSoulSandBlock(
			FabricBlockSettings.of(Material.METAL, MaterialColor.BROWN)
					.hardness(4.0f)
					.sounds(BlockSoundGroup.LANTERN)
					.requiresTool()
	);

	public static final Block SHOCK_ABSORBER_BLOCK = new ShockAbsorberBlock(
			FabricBlockSettings.of(Material.METAL, MaterialColor.GREEN)
					.hardness(4.0f)
					.sounds(BlockSoundGroup.WOOL)
					.requiresTool()
					.dynamicBounds()
	);

	// TODO: add firewater fluid :')
//	public static final FluidBlock  = new Registry.register(
//			Registry.FLUID, new Identifier("vanillascented", "firewater_fluid"), new FirewaterFluid.Still())
//			);

	@Override
	public void onInitialize() {
		createBlockAndItem("grated_magma_block", GRATED_MAGMA_BLOCK);
		createBlockAndItem("grated_soul_sand", GRATED_SOUL_SAND_BLOCK);
		createBlockAndItem("shock_absorber", SHOCK_ABSORBER_BLOCK);

		// TODO: add firewater fluid
	}

	<B extends Block> void createBlockAndItem(String path, B block) {
		Registry.register(Registry.BLOCK, new Identifier(MODID, path), block);
		Registry.register(Registry.ITEM, new Identifier(MODID, path),
				new BlockItem(block, new Item.Settings().group(ItemGroup.MISC)));
	}

	static SoundEvent createSound(String path) {
		return new SoundEvent(new Identifier(MODID + ":" + path));
	}
}
