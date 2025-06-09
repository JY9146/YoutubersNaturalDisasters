
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

import net.mcreator.youtubersnaturaldisasters.entity.Zachary95Entity;
import net.mcreator.youtubersnaturaldisasters.entity.WildFireEntity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoLAVAEntity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoHollowerrEntity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoGroundMesserEntity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoGeneratorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TsunamiGeneratorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TimephoonEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TestOfSinkholeEntityEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TechnosPotionOfGasEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TechnosGasPersonEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TechnobladeEntity;
import net.mcreator.youtubersnaturaldisasters.entity.SplashPotionOfGasProjectileEntity;
import net.mcreator.youtubersnaturaldisasters.entity.SinkholeEntityEntity;
import net.mcreator.youtubersnaturaldisasters.entity.PiglinSpawnerEntity;
import net.mcreator.youtubersnaturaldisasters.entity.OrphanEntity;
import net.mcreator.youtubersnaturaldisasters.entity.MrCooshEntity;
import net.mcreator.youtubersnaturaldisasters.entity.MeteorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.MadPiglinEntity;
import net.mcreator.youtubersnaturaldisasters.entity.LavaBallShooterEntity;
import net.mcreator.youtubersnaturaldisasters.entity.LavaBallEntity;
import net.mcreator.youtubersnaturaldisasters.entity.KnarfyEntity;
import net.mcreator.youtubersnaturaldisasters.entity.InsaneFlameEntity;
import net.mcreator.youtubersnaturaldisasters.entity.GasPersonEntity;
import net.mcreator.youtubersnaturaldisasters.entity.EndOfWorldMeteorMeteorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.DapperMrTomEntity;
import net.mcreator.youtubersnaturaldisasters.entity.CragDynaEntity;
import net.mcreator.youtubersnaturaldisasters.entity.CosmicEntity;
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
	public static final RegistryObject<EntityType<Zachary95Entity>> ZACHARY_95 = register("zachary_95",
			EntityType.Builder.<Zachary95Entity>of(Zachary95Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Zachary95Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CosmicEntity>> COSMIC = register("cosmic",
			EntityType.Builder.<CosmicEntity>of(CosmicEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CosmicEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DapperMrTomEntity>> DAPPER_MR_TOM = register("dapper_mr_tom",
			EntityType.Builder.<DapperMrTomEntity>of(DapperMrTomEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DapperMrTomEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TestOfSinkholeEntityEntity>> TEST_OF_SINKHOLE_ENTITY = register("test_of_sinkhole_entity", EntityType.Builder.<TestOfSinkholeEntityEntity>of(TestOfSinkholeEntityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TestOfSinkholeEntityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LavaBallEntity>> LAVA_BALL = register("lava_ball",
			EntityType.Builder.<LavaBallEntity>of(LavaBallEntity::new, MobCategory.MISC).setCustomClientFactory(LavaBallEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0f, 0f));
	public static final RegistryObject<EntityType<VolcanoGeneratorEntity>> VOLCANO_GENERATOR = register("volcano_generator", EntityType.Builder.<VolcanoGeneratorEntity>of(VolcanoGeneratorEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VolcanoGeneratorEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PiglinSpawnerEntity>> PIGLIN_SPAWNER = register("piglin_spawner",
			EntityType.Builder.<PiglinSpawnerEntity>of(PiglinSpawnerEntity::new, MobCategory.MISC).setCustomClientFactory(PiglinSpawnerEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MadPiglinEntity>> MAD_PIGLIN = register("mad_piglin",
			EntityType.Builder.<MadPiglinEntity>of(MadPiglinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MadPiglinEntity::new)

					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<OrphanEntity>> ORPHAN = register("orphan",
			EntityType.Builder.<OrphanEntity>of(OrphanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OrphanEntity::new).fireImmune().sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<TechnosPotionOfGasEntity>> TECHNOS_POTION_OF_GAS = register("technos_potion_of_gas", EntityType.Builder.<TechnosPotionOfGasEntity>of(TechnosPotionOfGasEntity::new, MobCategory.MISC)
			.setCustomClientFactory(TechnosPotionOfGasEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TechnosGasPersonEntity>> TECHNOS_GAS_PERSON = register("technos_gas_person", EntityType.Builder.<TechnosGasPersonEntity>of(TechnosGasPersonEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TechnosGasPersonEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KnarfyEntity>> KNARFY = register("knarfy",
			EntityType.Builder.<KnarfyEntity>of(KnarfyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KnarfyEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VolcanoHollowerrEntity>> VOLCANO_HOLLOWERR = register("volcano_hollowerr", EntityType.Builder.<VolcanoHollowerrEntity>of(VolcanoHollowerrEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VolcanoHollowerrEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LavaBallShooterEntity>> LAVA_BALL_SHOOTER = register("lava_ball_shooter", EntityType.Builder.<LavaBallShooterEntity>of(LavaBallShooterEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(300).setUpdateInterval(3).setCustomClientFactory(LavaBallShooterEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VolcanoLAVAEntity>> VOLCANO_LAVA = register("volcano_lava", EntityType.Builder.<VolcanoLAVAEntity>of(VolcanoLAVAEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VolcanoLAVAEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VolcanoGroundMesserEntity>> VOLCANO_GROUND_MESSER = register("volcano_ground_messer", EntityType.Builder.<VolcanoGroundMesserEntity>of(VolcanoGroundMesserEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VolcanoGroundMesserEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WildFireEntity>> WILD_FIRE = register("wild_fire",
			EntityType.Builder.<WildFireEntity>of(WildFireEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WildFireEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TsunamiGeneratorEntity>> TSUNAMI_GENERATOR = register("tsunami_generator", EntityType.Builder.<TsunamiGeneratorEntity>of(TsunamiGeneratorEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TsunamiGeneratorEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TimephoonEntity>> TIMEPHOON = register("timephoon", EntityType.Builder.<TimephoonEntity>of(TimephoonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(TimephoonEntity::new).fireImmune().sized(0.6f, 1.8f));

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
			Zachary95Entity.init();
			CosmicEntity.init();
			DapperMrTomEntity.init();
			TestOfSinkholeEntityEntity.init();
			VolcanoGeneratorEntity.init();
			MadPiglinEntity.init();
			OrphanEntity.init();
			TechnosGasPersonEntity.init();
			KnarfyEntity.init();
			VolcanoHollowerrEntity.init();
			LavaBallShooterEntity.init();
			VolcanoLAVAEntity.init();
			VolcanoGroundMesserEntity.init();
			WildFireEntity.init();
			TsunamiGeneratorEntity.init();
			TimephoonEntity.init();
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
		event.put(ZACHARY_95.get(), Zachary95Entity.createAttributes().build());
		event.put(COSMIC.get(), CosmicEntity.createAttributes().build());
		event.put(DAPPER_MR_TOM.get(), DapperMrTomEntity.createAttributes().build());
		event.put(TEST_OF_SINKHOLE_ENTITY.get(), TestOfSinkholeEntityEntity.createAttributes().build());
		event.put(VOLCANO_GENERATOR.get(), VolcanoGeneratorEntity.createAttributes().build());
		event.put(MAD_PIGLIN.get(), MadPiglinEntity.createAttributes().build());
		event.put(ORPHAN.get(), OrphanEntity.createAttributes().build());
		event.put(TECHNOS_GAS_PERSON.get(), TechnosGasPersonEntity.createAttributes().build());
		event.put(KNARFY.get(), KnarfyEntity.createAttributes().build());
		event.put(VOLCANO_HOLLOWERR.get(), VolcanoHollowerrEntity.createAttributes().build());
		event.put(LAVA_BALL_SHOOTER.get(), LavaBallShooterEntity.createAttributes().build());
		event.put(VOLCANO_LAVA.get(), VolcanoLAVAEntity.createAttributes().build());
		event.put(VOLCANO_GROUND_MESSER.get(), VolcanoGroundMesserEntity.createAttributes().build());
		event.put(WILD_FIRE.get(), WildFireEntity.createAttributes().build());
		event.put(TSUNAMI_GENERATOR.get(), TsunamiGeneratorEntity.createAttributes().build());
		event.put(TIMEPHOON.get(), TimephoonEntity.createAttributes().build());
	}
}
