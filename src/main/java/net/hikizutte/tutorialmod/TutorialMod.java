package net.hikizutte.tutorialmod;

import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.hikizutte.tutorialmod.block.ModBlocks;
import net.hikizutte.tutorialmod.block.entity.ModBlockEntities;
import net.hikizutte.tutorialmod.entity.ModEntities;
import net.hikizutte.tutorialmod.entity.custom.PorcupineEntity;
import net.hikizutte.tutorialmod.item.ModItems;
import net.hikizutte.tutorialmod.item.ModItemsGroups;
import net.hikizutte.tutorialmod.recipe.ModRecipes;
import net.hikizutte.tutorialmod.screen.ModScreenHandlers;
import net.hikizutte.tutorialmod.sound.ModSounds;
import net.hikizutte.tutorialmod.util.ModCustomTrades;
import net.hikizutte.tutorialmod.util.ModLootTableModifiers;
import net.hikizutte.tutorialmod.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemsGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModVillagers.registerVillagers();
		ModSounds.registerSounds();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE,200);
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
	}
}