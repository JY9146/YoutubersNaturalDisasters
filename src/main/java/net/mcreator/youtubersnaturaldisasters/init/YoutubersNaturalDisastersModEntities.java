
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.youtubersnaturaldisasters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.youtubersnaturaldisasters.entity.TechnobladeEntity;
import net.mcreator.youtubersnaturaldisasters.entity.SplashPotionOfGasProjectileEntity;
import net.mcreator.youtubersnaturaldisasters.entity.SinkholeEntityEntity;
import net.mcreator.youtubersnaturaldisasters.entity.MrCooshEntity;
import net.mcreator.youtubersnaturaldisasters.entity.MeteorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.InsaneFlameEntity;
import net.mcreator.youtubersnaturaldisasters.entity.GasPersonEntity;
import net.mcreator.youtubersnaturaldisasters.entity.EndOfWorldMeteorMeteorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.CragDynaEntity;
import net.mcreator.youtubersnaturaldisasters.entity.CavemanFilmsEntity;
import net.mcreator.youtubersnaturaldisasters.YoutubersNaturalDisastersMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class YoutubersNaturalDisastersModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, YoutubersNaturalDisastersMod.MODID);
	public static final RegistryObject<EntityType<TechnobladeEntity>> TECHNOBLADE = register("technoblade", EntityType.Builder.<TechnobladeEntity>of(TechnobladeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(80).setUpdateInterval(3).setCustomClientFactory(TechnobladeEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CragDynaEntity>> CRAG_DYNA = register("crag_dyna",
			EntityType.Builder.<CragDynaEntity>of(CragDynaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CragDynaEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GasPersonEntity>> GAS_PERSON = register("gas_person", EntityType.Builder.<GasPersonEntity>of(GasPersonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(GasPersonEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SplashPotionOfGasProjectileEntity>> SPLASH_POTION_OF_GAS_PROJECTILE = register("splash_potion_of_gas_projectile",
			EntityType.Builder.<SplashPotionOfGasProjectileEntity>of(SplashPotionOfGasProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(SplashPotionOfGasProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MeteorEntity>> METEOR = register("meteor",
			EntityType.Builder.<MeteorEntity>of(MeteorEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MeteorEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EndOfWorldMeteorMeteorEntity>> END_OF_WORLD_METEOR_METEOR = register("end_of_world_meteor_meteor",
			EntityType.Builder.<EndOfWorldMeteorMeteorEntity>of(EndOfWorldMeteorMeteorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(EndOfWorldMeteorMeteorEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CavemanFilmsEntity>> CAVEMAN_FILMS = register("caveman_films",
			EntityType.Builder.<CavemanFilmsEntity>of(CavemanFilmsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CavemanFilmsEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<InsaneFlameEntity>> INSANE_FLAME = register("insane_flame",
			EntityType.Builder.<InsaneFlameEntity>of(InsaneFlameEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InsaneFlameEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MrCooshEntity>> MR_COOSH = register("mr_coosh",
			EntityType.Builder.<MrCooshEntity>of(MrCooshEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MrCooshEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SinkholeEntityEntity>> SINKHOLE_ENTITY = register("sinkhole_entity", EntityType.Builder.<SinkholeEntityEntity>of(SinkholeEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SinkholeEntityEntity::new).fireImmune().sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TechnobladeEntity.init();
			CragDynaEntity.init();
			GasPersonEntity.init();
			MeteorEntity.init();
			EndOfWorldMeteorMeteorEntity.init();
			CavemanFilmsEntity.init();
			InsaneFlameEntity.init();
			MrCooshEntity.init();
			SinkholeEntityEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TECHNOBLADE.get(), TechnobladeEntity.createAttributes().build());
		event.put(CRAG_DYNA.get(), CragDynaEntity.createAttributes().build());
		event.put(GAS_PERSON.get(), GasPersonEntity.createAttributes().build());
		event.put(METEOR.get(), MeteorEntity.createAttributes().build());
		event.put(END_OF_WORLD_METEOR_METEOR.get(), EndOfWorldMeteorMeteorEntity.createAttributes().build());
		event.put(CAVEMAN_FILMS.get(), CavemanFilmsEntity.createAttributes().build());
		event.put(INSANE_FLAME.get(), InsaneFlameEntity.createAttributes().build());
		event.put(MR_COOSH.get(), MrCooshEntity.createAttributes().build());
		event.put(SINKHOLE_ENTITY.get(), SinkholeEntityEntity.createAttributes().build());
	}
}
