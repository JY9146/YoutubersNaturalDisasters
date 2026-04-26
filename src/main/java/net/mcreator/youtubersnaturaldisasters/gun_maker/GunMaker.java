package net.mcreator.youtubersnaturaldisasters.gun_maker;

import org.objectweb.asm.tree.analysis.Value;

import org.apache.logging.log4j.core.config.plugins.Plugin;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.HumanoidModel;

/**
 * Main is the core utility class for managing gun logic values in the Gun Maker plugin.
 * It was created be hacker_E303, the plugin author.
 * 
 * This class handles both item stack-specific values and entity-specific values, making it
 * versatile for different gun-related mechanics in the game.
 */
@Mod.EventBusSubscriber
public class GunMaker {
	// The plugin properties
	public static class Plugin {
		public static final String LOADER = "forge";

		public static final String ID = "gun_maker_plugin";
		public static final String NAME = "Gun Maker Plugin";
		public static final String AUTHOR = "hacker_E303";
		// Logger for logging errors
		public static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(NAME);
	}

	// The gun utils/tools
	public static class GunUtils {
		// Numeric values representing gun properties
		public static final Value LEVEL = new Value("gun_maker_00", Integer.class);
		public static final Value AMMO_NUMBER = new Value("gun_maker_01", Integer.class);
		public static final Value MAX_AMMO_NUMBER = new Value("gun_maker_02", Integer.class);
		public static final Value RECOVERY_TIME = new Value("gun_maker_03", Integer.class);
		public static final Value SHOOTED_ROUNDS = new Value("gun_maker_04", Integer.class);
		public static final Value ACCUMULATED_INACCURACY = new Value("gun_maker_05", Double.class);
		// Boolean values representing gun states
		public static final Value IS_AIMING = new Value("gun_maker_06", Boolean.class);
		public static final Value IS_SHOOTING = new Value("gun_maker_07", Boolean.class);
		public static final Value IS_RELOADING = new Value("gun_maker_08", Boolean.class);
		public static final Value SHOULD_SHOOT = new Value("gun_maker_09", Boolean.class);
		private static final TagKey<Item> GUNS = ItemTags.create(new ResourceLocation(Plugin.LOADER, "guns"));

		/**
		* Checks if provided ItemStack is a gun
		* 
		* @param stack The Entity to get the CompoundTag for
		* @return If the ItemStack is a gun
		*/
		public static boolean isGun(ItemStack stack) {
			return stack.is(GUNS);
		}

		/**
		* Sets a value on an ItemStack's persistent data store.
		* 
		* @param stack The ItemStack to set the value on
		* @param value The Value definition specifying the key and type
		* @param obj The value to set (must match the type specified by the Value definition)
		*/
		public static void setValue(ItemStack stack, Value value, Object obj) {
			setValue(getCompoundTag(stack), value, obj);
		}

		/**
		* Sets a value on an Entity's persistent data store.
		* 
		* @param entity The Entity to set the value on
		* @param value The Value definition specifying the key and type
		* @param obj The value to set (must match the type specified by the Value definition)
		*/
		public static void setValue(Entity entity, Value value, Object obj) {
			setValue(getCompoundTag(entity), value, obj);
		}

		/**
		* Gets a value from an ItemStack's persistent data store.
		* 
		* @param stack The ItemStack to get the value from
		* @param value The Value definition specifying the key and type
		* @return The value from the ItemStack's persistent data store
		*/
		public static Object getValue(ItemStack stack, Value value) {
			return getValue(getCompoundTag(stack), value);
		}

		/**
		* Gets a value from an Entity's persistent data store.
		* 
		* @param entity The Entity to get the value from
		* @param value The Value definition specifying the key and type
		* @return The value from the Entity's persistent data store
		*/
		public static Object getValue(Entity entity, Value value) {
			return getValue(getCompoundTag(entity), value);
		}

		/**
		* Internal helper method to set a value on a CompoundTag.
		* Handles type checking and conversion for supported data types.
		* 
		* @param tag The CompoundTag to set the value on
		* @param value The Value definition specifying the key and type
		* @param obj The value to set (must match the type specified by the Value definition)
		*/
		private static void setValue(CompoundTag tag, Value value, Object obj) {
			String name = value.getName();
			Class<?> type = value.getType();
			if (!name.isEmpty()) {
				if (type == Boolean.class && obj instanceof Boolean data)
					tag.putBoolean(name, data.booleanValue());
				else if (type == Integer.class && obj instanceof Number index)
					tag.putInt(name, index.intValue());
				else if (type == Double.class && obj instanceof Number index)
					tag.putDouble(name, index.doubleValue());
				else if (type == Float.class && obj instanceof Number index)
					tag.putFloat(name, index.floatValue());
				else
					printError(0);
			} else
				printError(0);
		}

		/**
		* Internal helper method to get a value from a CompoundTag.
		* Handles type checking and conversion for supported data types.
		* 
		* @param tag The CompoundTag to get the value from
		* @param value The Value definition specifying the key and type
		* @return The value from the CompoundTag, or null if an error occurs
		*/
		private static Object getValue(CompoundTag tag, Value value) {
			String name = value.getName();
			Class<?> type = value.getType();
			if (!name.isEmpty()) {
				if (type == Boolean.class)
					return tag.getBoolean(name);
				else if (type == Integer.class)
					return tag.getInt(name);
				else if (type == Double.class)
					return tag.getDouble(name);
				else if (type == Float.class)
					return tag.getFloat(name);
				else
					printError(0);
			}
			printError(0);
			return null;
		}

		/**
		* Gets or creates a persistent data tag for an ItemStack.
		* 
		* @param stack The ItemStack to get the CompoundTag for
		* @return The CompoundTag associated with the ItemStack
		*/
		private static CompoundTag getCompoundTag(ItemStack stack) {
			return stack.getOrCreateTag();
		}

		/**
		* Gets or creates a persistent data tag for an Entity.
		* 
		* @param entity The Entity to get the CompoundTag for
		* @return The CompoundTag associated with the Entity
		*/
		private static CompoundTag getCompoundTag(Entity entity) {
			return entity.getPersistentData();
		}
	}

	/**
	 * Value is an internal helper class that defines the structure of gun logic values.
	 * It encapsulates the name (key) and type information for each value stored in persistent data.
	 */
	private static class Value {
		private final String VALUE_NAME;
		private final Class<?> VALUE_TYPE;

		/**
		 * Creates a new Value definition.
		 * 
		 * @param valueName The name/key for the value (used in persistent data storage)
		 * @param valueType The Java type of the value
		 */
		public Value(String valueName, Class<?> valueType) {
			this.VALUE_NAME = valueName;
			this.VALUE_TYPE = valueType;
		}

		/**
		 * Gets the name/key of the value.
		 * 
		 * @return The name/key of the value
		 */
		public String getName() {
			if (!VALUE_NAME.isEmpty())
				return VALUE_NAME;
			printError(0);
			return "";
		}

		/**
		* Gets the Java type of the value.
		* 
		* @return The Java type of the value
		*/
		public Class<?> getType() {
			if (VALUE_TYPE != null)
				return VALUE_TYPE;
			printError(0);
			return null;
		}
	}

	/**
	 * Prints predefined error messages to the console.
	 * 
	 * @param index The error index to print (maps to predefined error messages)
	 */
	public static void printError(int index) {

		String errorType;
		String errorMessage;

		switch (index) {
			case 0 :
				errorType = "INVALID_VALUE";
				errorMessage = "The provided value is not mapped.";
				break;
			case 1 :
				errorType = "INVALID_PROCEDURE";
				errorMessage = "Gun definition procedure blocks need the 'Gun Definitions' global trigger!";
				break;
			default :
				errorType = "UNKNOWN_ERROR";
				errorMessage = "Index out of bounds! No right error message was found to send.";
				break;
		}
		String finalError = errorType + ": " + errorMessage;
		Plugin.LOGGER.error(finalError);
	}

	/**
	 * Events class contains all the event handlers for the Gun Maker plugin.
	 * These handlers manage various gun-related mechanics when specific game events occur.
	 */
	public static class Events {
		/**
		 * Handles render player events to change the player's arm pose when holding a gun.
		 * Sets the right arm pose to the bow and arrow pose, which looks appropriate for holding a gun.
		 * 
		 * @param event The RenderPlayerEvent.Pre containing rendering and player information
		 */
		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void onEventTriggered(RenderPlayerEvent.Pre event) {
			Entity entity = event.getEntity();
			ItemStack stack = ItemStack.EMPTY;
			if (entity instanceof LivingEntity living)
				stack = living.getMainHandItem();
			if (GunUtils.isGun(stack) && (boolean) GunUtils.getValue(stack, GunUtils.IS_AIMING)) {
				PlayerModel<?> model = (PlayerModel<?>) event.getRenderer().getModel();
				model.rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
			}
		}
	}
}
