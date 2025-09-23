
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
import net.mcreator.youtubersnaturaldisasters.entity.YeahJaronEntity;
import net.mcreator.youtubersnaturaldisasters.entity.WinsweepEntity;
import net.mcreator.youtubersnaturaldisasters.entity.WildFireEntity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoV2ErupterEntity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoLavaV2Entity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoLAVAEntity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoHollowerrEntity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoGroundMesserV2Entity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoGroundMesserEntity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoGeneratorV2p2Entity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoGeneratorV2Entity;
import net.mcreator.youtubersnaturaldisasters.entity.VolcanoGeneratorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TubboEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TsunamiGeneratorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TimephoonEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TestOfSinkholeEntityEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TechnosPotionOfGasEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TechnosGasPersonEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TechnobladeEntity;
import net.mcreator.youtubersnaturaldisasters.entity.TalonMCEntity;
import net.mcreator.youtubersnaturaldisasters.entity.SquiddoEntity;
import net.mcreator.youtubersnaturaldisasters.entity.SplashPotionOfGasProjectileEntity;
import net.mcreator.youtubersnaturaldisasters.entity.SinkholeEntityEntity;
import net.mcreator.youtubersnaturaldisasters.entity.ReddoonsEntity;
import net.mcreator.youtubersnaturaldisasters.entity.RanbooEntity;
import net.mcreator.youtubersnaturaldisasters.entity.PiglinSpawnerEntity;
import net.mcreator.youtubersnaturaldisasters.entity.Ph1LzAEntity;
import net.mcreator.youtubersnaturaldisasters.entity.OrphanEntity;
import net.mcreator.youtubersnaturaldisasters.entity.MrCooshEntity;
import net.mcreator.youtubersnaturaldisasters.entity.MeteorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.MadPiglinEntity;
import net.mcreator.youtubersnaturaldisasters.entity.LavaBallShooterEntity;
import net.mcreator.youtubersnaturaldisasters.entity.LavaBallEntity;
import net.mcreator.youtubersnaturaldisasters.entity.KnarfyEntity;
import net.mcreator.youtubersnaturaldisasters.entity.JustKaboodleEntity;
import net.mcreator.youtubersnaturaldisasters.entity.InsaneFlameEntity;
import net.mcreator.youtubersnaturaldisasters.entity.ImasquidkidEntity;
import net.mcreator.youtubersnaturaldisasters.entity.GasPersonEntity;
import net.mcreator.youtubersnaturaldisasters.entity.GarrettTheCarrotEntity;
import net.mcreator.youtubersnaturaldisasters.entity.EndOfWorldMeteorMeteorEntity;
import net.mcreator.youtubersnaturaldisasters.entity.DapperMrTomEntity;
import net.mcreator.youtubersnaturaldisasters.entity.CragDynaEntity;
import net.mcreator.youtubersnaturaldisasters.entity.CosmicEntity;
import net.mcreator.youtubersnaturaldisasters.entity.CavemanFilmsEntity;
import net.mcreator.youtubersnaturaldisasters.entity.CammaganzaEntity;
import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV3Entity;
import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleV2Entity;
import net.mcreator.youtubersnaturaldisasters.entity.BlackHoleEntity;
import net.mcreator.youtubersnaturaldisasters.entity.BadBoyHaloEntity;
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
	public static final RegistryObject<EntityType<BlackHoleEntity>> BLACK_HOLE = register("black_hole", EntityType.Builder.<BlackHoleEntity>of(BlackHoleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(BlackHoleEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlackHoleV2Entity>> BLACK_HOLE_V_2 = register("black_hole_v_2", EntityType.Builder.<BlackHoleV2Entity>of(BlackHoleV2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlackHoleV2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlackHoleV3Entity>> BLACK_HOLE_V_3 = register("black_hole_v_3", EntityType.Builder.<BlackHoleV3Entity>of(BlackHoleV3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlackHoleV3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VolcanoGeneratorV2Entity>> VOLCANO_GENERATOR_V_2 = register("volcano_generator_v_2", EntityType.Builder.<VolcanoGeneratorV2Entity>of(VolcanoGeneratorV2Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VolcanoGeneratorV2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VolcanoLavaV2Entity>> VOLCANO_LAVA_V_2 = register("volcano_lava_v_2", EntityType.Builder.<VolcanoLavaV2Entity>of(VolcanoLavaV2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VolcanoLavaV2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VolcanoV2ErupterEntity>> VOLCANO_V_2_ERUPTER = register("volcano_v_2_erupter", EntityType.Builder.<VolcanoV2ErupterEntity>of(VolcanoV2ErupterEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VolcanoV2ErupterEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VolcanoGroundMesserV2Entity>> VOLCANO_GROUND_MESSER_V_2 = register("volcano_ground_messer_v_2",
			EntityType.Builder.<VolcanoGroundMesserV2Entity>of(VolcanoGroundMesserV2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(VolcanoGroundMesserV2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CammaganzaEntity>> CAMMAGANZA = register("cammaganza",
			EntityType.Builder.<CammaganzaEntity>of(CammaganzaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CammaganzaEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VolcanoGeneratorV2p2Entity>> VOLCANO_GENERATOR_V_2P_2 = register("volcano_generator_v_2p_2", EntityType.Builder.<VolcanoGeneratorV2p2Entity>of(VolcanoGeneratorV2p2Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VolcanoGeneratorV2p2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Ph1LzAEntity>> PH_1_LZ_A = register("ph_1_lz_a",
			EntityType.Builder.<Ph1LzAEntity>of(Ph1LzAEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Ph1LzAEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<YeahJaronEntity>> YEAH_JARON = register("yeah_jaron",
			EntityType.Builder.<YeahJaronEntity>of(YeahJaronEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YeahJaronEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ReddoonsEntity>> REDDOONS = register("reddoons",
			EntityType.Builder.<ReddoonsEntity>of(ReddoonsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ReddoonsEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TalonMCEntity>> TALON_MC = register("talon_mc",
			EntityType.Builder.<TalonMCEntity>of(TalonMCEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TalonMCEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<JustKaboodleEntity>> JUST_KABOODLE = register("just_kaboodle",
			EntityType.Builder.<JustKaboodleEntity>of(JustKaboodleEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(JustKaboodleEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WinsweepEntity>> WINSWEEP = register("winsweep",
			EntityType.Builder.<WinsweepEntity>of(WinsweepEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WinsweepEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TubboEntity>> TUBBO = register("tubbo",
			EntityType.Builder.<TubboEntity>of(TubboEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TubboEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ImasquidkidEntity>> IMASQUIDKID = register("imasquidkid",
			EntityType.Builder.<ImasquidkidEntity>of(ImasquidkidEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ImasquidkidEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BadBoyHaloEntity>> BAD_BOY_HALO = register("bad_boy_halo", EntityType.Builder.<BadBoyHaloEntity>of(BadBoyHaloEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(BadBoyHaloEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RanbooEntity>> RANBOO = register("ranboo",
			EntityType.Builder.<RanbooEntity>of(RanbooEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RanbooEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SquiddoEntity>> SQUIDDO = register("squiddo",
			EntityType.Builder.<SquiddoEntity>of(SquiddoEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SquiddoEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GarrettTheCarrotEntity>> GARRETT_THE_CARROT = register("garrett_the_carrot",
			EntityType.Builder.<GarrettTheCarrotEntity>of(GarrettTheCarrotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GarrettTheCarrotEntity::new)

					.sized(0.6f, 1.8f));

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
			BlackHoleEntity.init();
			BlackHoleV2Entity.init();
			BlackHoleV3Entity.init();
			VolcanoGeneratorV2Entity.init();
			VolcanoLavaV2Entity.init();
			VolcanoV2ErupterEntity.init();
			VolcanoGroundMesserV2Entity.init();
			CammaganzaEntity.init();
			VolcanoGeneratorV2p2Entity.init();
			Ph1LzAEntity.init();
			YeahJaronEntity.init();
			ReddoonsEntity.init();
			TalonMCEntity.init();
			JustKaboodleEntity.init();
			WinsweepEntity.init();
			TubboEntity.init();
			ImasquidkidEntity.init();
			BadBoyHaloEntity.init();
			RanbooEntity.init();
			SquiddoEntity.init();
			GarrettTheCarrotEntity.init();
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
		event.put(BLACK_HOLE.get(), BlackHoleEntity.createAttributes().build());
		event.put(BLACK_HOLE_V_2.get(), BlackHoleV2Entity.createAttributes().build());
		event.put(BLACK_HOLE_V_3.get(), BlackHoleV3Entity.createAttributes().build());
		event.put(VOLCANO_GENERATOR_V_2.get(), VolcanoGeneratorV2Entity.createAttributes().build());
		event.put(VOLCANO_LAVA_V_2.get(), VolcanoLavaV2Entity.createAttributes().build());
		event.put(VOLCANO_V_2_ERUPTER.get(), VolcanoV2ErupterEntity.createAttributes().build());
		event.put(VOLCANO_GROUND_MESSER_V_2.get(), VolcanoGroundMesserV2Entity.createAttributes().build());
		event.put(CAMMAGANZA.get(), CammaganzaEntity.createAttributes().build());
		event.put(VOLCANO_GENERATOR_V_2P_2.get(), VolcanoGeneratorV2p2Entity.createAttributes().build());
		event.put(PH_1_LZ_A.get(), Ph1LzAEntity.createAttributes().build());
		event.put(YEAH_JARON.get(), YeahJaronEntity.createAttributes().build());
		event.put(REDDOONS.get(), ReddoonsEntity.createAttributes().build());
		event.put(TALON_MC.get(), TalonMCEntity.createAttributes().build());
		event.put(JUST_KABOODLE.get(), JustKaboodleEntity.createAttributes().build());
		event.put(WINSWEEP.get(), WinsweepEntity.createAttributes().build());
		event.put(TUBBO.get(), TubboEntity.createAttributes().build());
		event.put(IMASQUIDKID.get(), ImasquidkidEntity.createAttributes().build());
		event.put(BAD_BOY_HALO.get(), BadBoyHaloEntity.createAttributes().build());
		event.put(RANBOO.get(), RanbooEntity.createAttributes().build());
		event.put(SQUIDDO.get(), SquiddoEntity.createAttributes().build());
		event.put(GARRETT_THE_CARROT.get(), GarrettTheCarrotEntity.createAttributes().build());
	}
}
