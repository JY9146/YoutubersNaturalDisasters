package net.mcreator.youtubersnaturaldisasters.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;

public class XrayPowersEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			net.minecraft.world.entity.Entity _ent = entity;
			if (_ent instanceof net.minecraft.world.entity.player.Player _player) {
				// ===== ORIGINAL PRESERVADO =====
				String _id = "";
				try {
					Object _blkIn = Blocks.DIAMOND_ORE;
					if (_blkIn instanceof net.minecraft.world.level.block.state.BlockState) {
						net.minecraft.world.level.block.Block _b = ((net.minecraft.world.level.block.state.BlockState) _blkIn).getBlock();
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey(_b);
						if (_rl != null)
							_id = _rl.toString();
					} else if (_blkIn instanceof net.minecraft.world.level.block.Block) {
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey((net.minecraft.world.level.block.Block) _blkIn);
						if (_rl != null)
							_id = _rl.toString();
					} else {
						_id = String.valueOf(_blkIn);
					}
				} catch (Throwable __ignore) {
				}
				if (_id == null)
					_id = "";
				_id = _id.trim();
				int _radius = (int) Math.max(1, 16);
				int _r = (int) Math.max(0, Math.min(255, 36));
				int _g = (int) Math.max(0, Math.min(255, 255));
				int _b = (int) Math.max(0, Math.min(255, 237));
				double _aIn = 1;
				int _a = (int) Math.max(0, Math.min(255, Math.round((float) (_aIn * 255.0))));
				int _argb = (_a << 24) | (_r << 16) | (_g << 8) | (_b);
				net.minecraft.world.level.LevelAccessor _lvlAcc = _player.level();
				long _now = (_lvlAcc instanceof net.minecraft.world.level.Level) ? ((net.minecraft.world.level.Level) _lvlAcc).getGameTime() : 0L;
				int _dur = (int) Math.max(0, 300);
				long _until = (_dur == 0) ? java.lang.Long.MAX_VALUE : (_now + _dur);
				// ===== CHAVES LEGADAS (inalteradas) =====
				_player.getPersistentData().putString("nx_xr_block", _id);
				_player.getPersistentData().putInt("nx_xr_radius", _radius);
				_player.getPersistentData().putInt("nx_xr_color", _argb);
				_player.getPersistentData().putLong("nx_xr_until", _until);
				// ===== NOVO: múltiplos "slots" no MESMO tick (até 8) =====
				long __lastTick = _player.getPersistentData().getLong("nx_xr_lasttick");
				if (__lastTick != _now) {
					_player.getPersistentData().putLong("nx_xr_lasttick", _now);
					_player.getPersistentData().putInt("nx_xr_count", 0);
				}
				int __idx = Math.max(0, _player.getPersistentData().getInt("nx_xr_count"));
				if (__idx < 8) {
					_player.getPersistentData().putString("nx_xr_block_" + __idx, _id);
					_player.getPersistentData().putInt("nx_xr_radius_" + __idx, _radius);
					_player.getPersistentData().putInt("nx_xr_color_" + __idx, _argb);
					_player.getPersistentData().putLong("nx_xr_until_" + __idx, _until);
					_player.getPersistentData().putInt("nx_xr_count", __idx + 1);
				}
				// ===== listener de render EXATAMENTE como o seu =====
				if (!_player.getPersistentData().getBoolean("nx_xr_listener")) {
					_player.getPersistentData().putBoolean("nx_xr_listener", true);
					if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
						new Object() {
							private java.util.UUID owner;
							private com.mojang.blaze3d.vertex.VertexBuffer vb = null;

							public void start(java.util.UUID id) {
								this.owner = id;
								net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
							}

							private void buildUnitBox() {
								if (vb != null)
									return;
								com.mojang.blaze3d.vertex.BufferBuilder bb = com.mojang.blaze3d.vertex.Tesselator.getInstance().getBuilder();
								bb.begin(com.mojang.blaze3d.vertex.VertexFormat.Mode.DEBUG_LINES, com.mojang.blaze3d.vertex.DefaultVertexFormat.POSITION_COLOR);
								int white = 0xFFFFFFFF;
								add(bb, 0, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 0, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 1, 1, white);
								vb = new com.mojang.blaze3d.vertex.VertexBuffer(com.mojang.blaze3d.vertex.VertexBuffer.Usage.STATIC);
								vb.bind();
								vb.upload(bb.end());
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
							}

							private void add(com.mojang.blaze3d.vertex.BufferBuilder bb, double x, double y, double z, int color) {
								bb.vertex(x, y, z).color(color).endVertex();
							}

							@net.minecraftforge.eventbus.api.SubscribeEvent
							public void onRender(net.minecraftforge.client.event.RenderLevelStageEvent event) {
								if (event.getStage() != net.minecraftforge.client.event.RenderLevelStageEvent.Stage.AFTER_PARTICLES)
									return;
								net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
								if (mc == null)
									return;
								net.minecraft.client.multiplayer.ClientLevel level = mc.level;
								net.minecraft.world.entity.player.Player p = mc.player;
								if (level == null || p == null)
									return;
								if (!p.getUUID().equals(this.owner))
									return;
								long now = level.getGameTime();
								// monta a lista a desenhar (slots do tick atual)
								java.util.ArrayList<String[]> _draw = new java.util.ArrayList<>();
								int c = Math.max(0, p.getPersistentData().getInt("nx_xr_count"));
								for (int i = 0; i < c && i < 8; i++) {
									String id = p.getPersistentData().getString("nx_xr_block_" + i);
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius_" + i));
									int col = p.getPersistentData().getInt("nx_xr_color_" + i);
									long unt = p.getPersistentData().getLong("nx_xr_until_" + i);
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								// fallback legado (se ninguém preencheu slots)
								if (_draw.isEmpty()) {
									String id = p.getPersistentData().getString("nx_xr_block");
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius"));
									int col = p.getPersistentData().getInt("nx_xr_color");
									long unt = p.getPersistentData().getLong("nx_xr_until");
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								if (_draw.isEmpty()) {
									p.getPersistentData().putBoolean("nx_xr_listener", false);
									net.minecraftforge.common.MinecraftForge.EVENT_BUS.unregister(this);
									return;
								}
								buildUnitBox();
								// desenha por cima das paredes
								com.mojang.blaze3d.systems.RenderSystem.disableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(false);
								com.mojang.blaze3d.systems.RenderSystem.enableBlend();
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.vertex.PoseStack ps = event.getPoseStack();
								org.joml.Matrix4f proj = event.getProjectionMatrix();
								net.minecraft.world.phys.Vec3 cam = mc.gameRenderer.getMainCamera().getPosition();
								int px = (int) Math.floor(p.getX());
								int py = (int) Math.floor(p.getY());
								int pz = (int) Math.floor(p.getZ());
								vb.bind();
								for (String[] e : _draw) {
									String id = e[0];
									int radius = Integer.parseInt(e[1]);
									// ==== FIX DO CRASH: aceitar ARGB negativo ====
									int argb = Integer.parseInt(e[2]); // (antes: parseUnsignedInt)
									// =============================================
									net.minecraft.resources.ResourceLocation rl = net.minecraft.resources.ResourceLocation.tryParse(id);
									if (rl == null)
										continue;
									net.minecraft.world.level.block.Block target = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getValue(rl);
									if (target == null)
										continue;
									int r = radius;
									for (int dy = -r; dy <= r; dy++)
										for (int dx = -r; dx <= r; dx++)
											for (int dz = -r; dz <= r; dz++) {
												net.minecraft.core.BlockPos bp = new net.minecraft.core.BlockPos(px + dx, py + dy, pz + dz);
												if (level.getBlockState(bp).getBlock() == target) {
													float tx = (float) (bp.getX() - cam.x);
													float ty = (float) (bp.getY() - cam.y);
													float tz = (float) (bp.getZ() - cam.z);
													com.mojang.blaze3d.systems.RenderSystem.setShaderColor(((argb >> 16) & 255) / 255.0F, ((argb >> 8) & 255) / 255.0F, (argb & 255) / 255.0F, ((argb >>> 24) & 255) / 255.0F);
													ps.pushPose();
													ps.translate(tx, ty, tz);
													vb.drawWithShader(ps.last().pose(), proj, net.minecraft.client.renderer.GameRenderer.getPositionColorShader());
													ps.popPose();
												}
											}
								}
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
								com.mojang.blaze3d.systems.RenderSystem.setShaderColor(1, 1, 1, 1);
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.systems.RenderSystem.enableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(true);
							}
						}.start(_player.getUUID());
					}
				}
			}
		}
		{
			net.minecraft.world.entity.Entity _ent = entity;
			if (_ent instanceof net.minecraft.world.entity.player.Player _player) {
				// ===== ORIGINAL PRESERVADO =====
				String _id = "";
				try {
					Object _blkIn = Blocks.DEEPSLATE_DIAMOND_ORE;
					if (_blkIn instanceof net.minecraft.world.level.block.state.BlockState) {
						net.minecraft.world.level.block.Block _b = ((net.minecraft.world.level.block.state.BlockState) _blkIn).getBlock();
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey(_b);
						if (_rl != null)
							_id = _rl.toString();
					} else if (_blkIn instanceof net.minecraft.world.level.block.Block) {
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey((net.minecraft.world.level.block.Block) _blkIn);
						if (_rl != null)
							_id = _rl.toString();
					} else {
						_id = String.valueOf(_blkIn);
					}
				} catch (Throwable __ignore) {
				}
				if (_id == null)
					_id = "";
				_id = _id.trim();
				int _radius = (int) Math.max(1, 16);
				int _r = (int) Math.max(0, Math.min(255, 31));
				int _g = (int) Math.max(0, Math.min(255, 196));
				int _b = (int) Math.max(0, Math.min(255, 183));
				double _aIn = 1;
				int _a = (int) Math.max(0, Math.min(255, Math.round((float) (_aIn * 255.0))));
				int _argb = (_a << 24) | (_r << 16) | (_g << 8) | (_b);
				net.minecraft.world.level.LevelAccessor _lvlAcc = _player.level();
				long _now = (_lvlAcc instanceof net.minecraft.world.level.Level) ? ((net.minecraft.world.level.Level) _lvlAcc).getGameTime() : 0L;
				int _dur = (int) Math.max(0, 300);
				long _until = (_dur == 0) ? java.lang.Long.MAX_VALUE : (_now + _dur);
				// ===== CHAVES LEGADAS (inalteradas) =====
				_player.getPersistentData().putString("nx_xr_block", _id);
				_player.getPersistentData().putInt("nx_xr_radius", _radius);
				_player.getPersistentData().putInt("nx_xr_color", _argb);
				_player.getPersistentData().putLong("nx_xr_until", _until);
				// ===== NOVO: múltiplos "slots" no MESMO tick (até 8) =====
				long __lastTick = _player.getPersistentData().getLong("nx_xr_lasttick");
				if (__lastTick != _now) {
					_player.getPersistentData().putLong("nx_xr_lasttick", _now);
					_player.getPersistentData().putInt("nx_xr_count", 0);
				}
				int __idx = Math.max(0, _player.getPersistentData().getInt("nx_xr_count"));
				if (__idx < 8) {
					_player.getPersistentData().putString("nx_xr_block_" + __idx, _id);
					_player.getPersistentData().putInt("nx_xr_radius_" + __idx, _radius);
					_player.getPersistentData().putInt("nx_xr_color_" + __idx, _argb);
					_player.getPersistentData().putLong("nx_xr_until_" + __idx, _until);
					_player.getPersistentData().putInt("nx_xr_count", __idx + 1);
				}
				// ===== listener de render EXATAMENTE como o seu =====
				if (!_player.getPersistentData().getBoolean("nx_xr_listener")) {
					_player.getPersistentData().putBoolean("nx_xr_listener", true);
					if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
						new Object() {
							private java.util.UUID owner;
							private com.mojang.blaze3d.vertex.VertexBuffer vb = null;

							public void start(java.util.UUID id) {
								this.owner = id;
								net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
							}

							private void buildUnitBox() {
								if (vb != null)
									return;
								com.mojang.blaze3d.vertex.BufferBuilder bb = com.mojang.blaze3d.vertex.Tesselator.getInstance().getBuilder();
								bb.begin(com.mojang.blaze3d.vertex.VertexFormat.Mode.DEBUG_LINES, com.mojang.blaze3d.vertex.DefaultVertexFormat.POSITION_COLOR);
								int white = 0xFFFFFFFF;
								add(bb, 0, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 0, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 1, 1, white);
								vb = new com.mojang.blaze3d.vertex.VertexBuffer(com.mojang.blaze3d.vertex.VertexBuffer.Usage.STATIC);
								vb.bind();
								vb.upload(bb.end());
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
							}

							private void add(com.mojang.blaze3d.vertex.BufferBuilder bb, double x, double y, double z, int color) {
								bb.vertex(x, y, z).color(color).endVertex();
							}

							@net.minecraftforge.eventbus.api.SubscribeEvent
							public void onRender(net.minecraftforge.client.event.RenderLevelStageEvent event) {
								if (event.getStage() != net.minecraftforge.client.event.RenderLevelStageEvent.Stage.AFTER_PARTICLES)
									return;
								net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
								if (mc == null)
									return;
								net.minecraft.client.multiplayer.ClientLevel level = mc.level;
								net.minecraft.world.entity.player.Player p = mc.player;
								if (level == null || p == null)
									return;
								if (!p.getUUID().equals(this.owner))
									return;
								long now = level.getGameTime();
								// monta a lista a desenhar (slots do tick atual)
								java.util.ArrayList<String[]> _draw = new java.util.ArrayList<>();
								int c = Math.max(0, p.getPersistentData().getInt("nx_xr_count"));
								for (int i = 0; i < c && i < 8; i++) {
									String id = p.getPersistentData().getString("nx_xr_block_" + i);
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius_" + i));
									int col = p.getPersistentData().getInt("nx_xr_color_" + i);
									long unt = p.getPersistentData().getLong("nx_xr_until_" + i);
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								// fallback legado (se ninguém preencheu slots)
								if (_draw.isEmpty()) {
									String id = p.getPersistentData().getString("nx_xr_block");
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius"));
									int col = p.getPersistentData().getInt("nx_xr_color");
									long unt = p.getPersistentData().getLong("nx_xr_until");
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								if (_draw.isEmpty()) {
									p.getPersistentData().putBoolean("nx_xr_listener", false);
									net.minecraftforge.common.MinecraftForge.EVENT_BUS.unregister(this);
									return;
								}
								buildUnitBox();
								// desenha por cima das paredes
								com.mojang.blaze3d.systems.RenderSystem.disableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(false);
								com.mojang.blaze3d.systems.RenderSystem.enableBlend();
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.vertex.PoseStack ps = event.getPoseStack();
								org.joml.Matrix4f proj = event.getProjectionMatrix();
								net.minecraft.world.phys.Vec3 cam = mc.gameRenderer.getMainCamera().getPosition();
								int px = (int) Math.floor(p.getX());
								int py = (int) Math.floor(p.getY());
								int pz = (int) Math.floor(p.getZ());
								vb.bind();
								for (String[] e : _draw) {
									String id = e[0];
									int radius = Integer.parseInt(e[1]);
									// ==== FIX DO CRASH: aceitar ARGB negativo ====
									int argb = Integer.parseInt(e[2]); // (antes: parseUnsignedInt)
									// =============================================
									net.minecraft.resources.ResourceLocation rl = net.minecraft.resources.ResourceLocation.tryParse(id);
									if (rl == null)
										continue;
									net.minecraft.world.level.block.Block target = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getValue(rl);
									if (target == null)
										continue;
									int r = radius;
									for (int dy = -r; dy <= r; dy++)
										for (int dx = -r; dx <= r; dx++)
											for (int dz = -r; dz <= r; dz++) {
												net.minecraft.core.BlockPos bp = new net.minecraft.core.BlockPos(px + dx, py + dy, pz + dz);
												if (level.getBlockState(bp).getBlock() == target) {
													float tx = (float) (bp.getX() - cam.x);
													float ty = (float) (bp.getY() - cam.y);
													float tz = (float) (bp.getZ() - cam.z);
													com.mojang.blaze3d.systems.RenderSystem.setShaderColor(((argb >> 16) & 255) / 255.0F, ((argb >> 8) & 255) / 255.0F, (argb & 255) / 255.0F, ((argb >>> 24) & 255) / 255.0F);
													ps.pushPose();
													ps.translate(tx, ty, tz);
													vb.drawWithShader(ps.last().pose(), proj, net.minecraft.client.renderer.GameRenderer.getPositionColorShader());
													ps.popPose();
												}
											}
								}
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
								com.mojang.blaze3d.systems.RenderSystem.setShaderColor(1, 1, 1, 1);
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.systems.RenderSystem.enableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(true);
							}
						}.start(_player.getUUID());
					}
				}
			}
		}
		{
			net.minecraft.world.entity.Entity _ent = entity;
			if (_ent instanceof net.minecraft.world.entity.player.Player _player) {
				// ===== ORIGINAL PRESERVADO =====
				String _id = "";
				try {
					Object _blkIn = Blocks.TNT;
					if (_blkIn instanceof net.minecraft.world.level.block.state.BlockState) {
						net.minecraft.world.level.block.Block _b = ((net.minecraft.world.level.block.state.BlockState) _blkIn).getBlock();
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey(_b);
						if (_rl != null)
							_id = _rl.toString();
					} else if (_blkIn instanceof net.minecraft.world.level.block.Block) {
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey((net.minecraft.world.level.block.Block) _blkIn);
						if (_rl != null)
							_id = _rl.toString();
					} else {
						_id = String.valueOf(_blkIn);
					}
				} catch (Throwable __ignore) {
				}
				if (_id == null)
					_id = "";
				_id = _id.trim();
				int _radius = (int) Math.max(1, 16);
				int _r = (int) Math.max(0, Math.min(255, 162));
				int _g = (int) Math.max(0, Math.min(255, 70));
				int _b = (int) Math.max(0, Math.min(255, 70));
				double _aIn = 1;
				int _a = (int) Math.max(0, Math.min(255, Math.round((float) (_aIn * 255.0))));
				int _argb = (_a << 24) | (_r << 16) | (_g << 8) | (_b);
				net.minecraft.world.level.LevelAccessor _lvlAcc = _player.level();
				long _now = (_lvlAcc instanceof net.minecraft.world.level.Level) ? ((net.minecraft.world.level.Level) _lvlAcc).getGameTime() : 0L;
				int _dur = (int) Math.max(0, 300);
				long _until = (_dur == 0) ? java.lang.Long.MAX_VALUE : (_now + _dur);
				// ===== CHAVES LEGADAS (inalteradas) =====
				_player.getPersistentData().putString("nx_xr_block", _id);
				_player.getPersistentData().putInt("nx_xr_radius", _radius);
				_player.getPersistentData().putInt("nx_xr_color", _argb);
				_player.getPersistentData().putLong("nx_xr_until", _until);
				// ===== NOVO: múltiplos "slots" no MESMO tick (até 8) =====
				long __lastTick = _player.getPersistentData().getLong("nx_xr_lasttick");
				if (__lastTick != _now) {
					_player.getPersistentData().putLong("nx_xr_lasttick", _now);
					_player.getPersistentData().putInt("nx_xr_count", 0);
				}
				int __idx = Math.max(0, _player.getPersistentData().getInt("nx_xr_count"));
				if (__idx < 8) {
					_player.getPersistentData().putString("nx_xr_block_" + __idx, _id);
					_player.getPersistentData().putInt("nx_xr_radius_" + __idx, _radius);
					_player.getPersistentData().putInt("nx_xr_color_" + __idx, _argb);
					_player.getPersistentData().putLong("nx_xr_until_" + __idx, _until);
					_player.getPersistentData().putInt("nx_xr_count", __idx + 1);
				}
				// ===== listener de render EXATAMENTE como o seu =====
				if (!_player.getPersistentData().getBoolean("nx_xr_listener")) {
					_player.getPersistentData().putBoolean("nx_xr_listener", true);
					if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
						new Object() {
							private java.util.UUID owner;
							private com.mojang.blaze3d.vertex.VertexBuffer vb = null;

							public void start(java.util.UUID id) {
								this.owner = id;
								net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
							}

							private void buildUnitBox() {
								if (vb != null)
									return;
								com.mojang.blaze3d.vertex.BufferBuilder bb = com.mojang.blaze3d.vertex.Tesselator.getInstance().getBuilder();
								bb.begin(com.mojang.blaze3d.vertex.VertexFormat.Mode.DEBUG_LINES, com.mojang.blaze3d.vertex.DefaultVertexFormat.POSITION_COLOR);
								int white = 0xFFFFFFFF;
								add(bb, 0, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 0, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 1, 1, white);
								vb = new com.mojang.blaze3d.vertex.VertexBuffer(com.mojang.blaze3d.vertex.VertexBuffer.Usage.STATIC);
								vb.bind();
								vb.upload(bb.end());
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
							}

							private void add(com.mojang.blaze3d.vertex.BufferBuilder bb, double x, double y, double z, int color) {
								bb.vertex(x, y, z).color(color).endVertex();
							}

							@net.minecraftforge.eventbus.api.SubscribeEvent
							public void onRender(net.minecraftforge.client.event.RenderLevelStageEvent event) {
								if (event.getStage() != net.minecraftforge.client.event.RenderLevelStageEvent.Stage.AFTER_PARTICLES)
									return;
								net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
								if (mc == null)
									return;
								net.minecraft.client.multiplayer.ClientLevel level = mc.level;
								net.minecraft.world.entity.player.Player p = mc.player;
								if (level == null || p == null)
									return;
								if (!p.getUUID().equals(this.owner))
									return;
								long now = level.getGameTime();
								// monta a lista a desenhar (slots do tick atual)
								java.util.ArrayList<String[]> _draw = new java.util.ArrayList<>();
								int c = Math.max(0, p.getPersistentData().getInt("nx_xr_count"));
								for (int i = 0; i < c && i < 8; i++) {
									String id = p.getPersistentData().getString("nx_xr_block_" + i);
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius_" + i));
									int col = p.getPersistentData().getInt("nx_xr_color_" + i);
									long unt = p.getPersistentData().getLong("nx_xr_until_" + i);
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								// fallback legado (se ninguém preencheu slots)
								if (_draw.isEmpty()) {
									String id = p.getPersistentData().getString("nx_xr_block");
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius"));
									int col = p.getPersistentData().getInt("nx_xr_color");
									long unt = p.getPersistentData().getLong("nx_xr_until");
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								if (_draw.isEmpty()) {
									p.getPersistentData().putBoolean("nx_xr_listener", false);
									net.minecraftforge.common.MinecraftForge.EVENT_BUS.unregister(this);
									return;
								}
								buildUnitBox();
								// desenha por cima das paredes
								com.mojang.blaze3d.systems.RenderSystem.disableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(false);
								com.mojang.blaze3d.systems.RenderSystem.enableBlend();
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.vertex.PoseStack ps = event.getPoseStack();
								org.joml.Matrix4f proj = event.getProjectionMatrix();
								net.minecraft.world.phys.Vec3 cam = mc.gameRenderer.getMainCamera().getPosition();
								int px = (int) Math.floor(p.getX());
								int py = (int) Math.floor(p.getY());
								int pz = (int) Math.floor(p.getZ());
								vb.bind();
								for (String[] e : _draw) {
									String id = e[0];
									int radius = Integer.parseInt(e[1]);
									// ==== FIX DO CRASH: aceitar ARGB negativo ====
									int argb = Integer.parseInt(e[2]); // (antes: parseUnsignedInt)
									// =============================================
									net.minecraft.resources.ResourceLocation rl = net.minecraft.resources.ResourceLocation.tryParse(id);
									if (rl == null)
										continue;
									net.minecraft.world.level.block.Block target = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getValue(rl);
									if (target == null)
										continue;
									int r = radius;
									for (int dy = -r; dy <= r; dy++)
										for (int dx = -r; dx <= r; dx++)
											for (int dz = -r; dz <= r; dz++) {
												net.minecraft.core.BlockPos bp = new net.minecraft.core.BlockPos(px + dx, py + dy, pz + dz);
												if (level.getBlockState(bp).getBlock() == target) {
													float tx = (float) (bp.getX() - cam.x);
													float ty = (float) (bp.getY() - cam.y);
													float tz = (float) (bp.getZ() - cam.z);
													com.mojang.blaze3d.systems.RenderSystem.setShaderColor(((argb >> 16) & 255) / 255.0F, ((argb >> 8) & 255) / 255.0F, (argb & 255) / 255.0F, ((argb >>> 24) & 255) / 255.0F);
													ps.pushPose();
													ps.translate(tx, ty, tz);
													vb.drawWithShader(ps.last().pose(), proj, net.minecraft.client.renderer.GameRenderer.getPositionColorShader());
													ps.popPose();
												}
											}
								}
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
								com.mojang.blaze3d.systems.RenderSystem.setShaderColor(1, 1, 1, 1);
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.systems.RenderSystem.enableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(true);
							}
						}.start(_player.getUUID());
					}
				}
			}
		}
		{
			net.minecraft.world.entity.Entity _ent = entity;
			if (_ent instanceof net.minecraft.world.entity.player.Player _player) {
				// ===== ORIGINAL PRESERVADO =====
				String _id = "";
				try {
					Object _blkIn = Blocks.ANCIENT_DEBRIS;
					if (_blkIn instanceof net.minecraft.world.level.block.state.BlockState) {
						net.minecraft.world.level.block.Block _b = ((net.minecraft.world.level.block.state.BlockState) _blkIn).getBlock();
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey(_b);
						if (_rl != null)
							_id = _rl.toString();
					} else if (_blkIn instanceof net.minecraft.world.level.block.Block) {
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey((net.minecraft.world.level.block.Block) _blkIn);
						if (_rl != null)
							_id = _rl.toString();
					} else {
						_id = String.valueOf(_blkIn);
					}
				} catch (Throwable __ignore) {
				}
				if (_id == null)
					_id = "";
				_id = _id.trim();
				int _radius = (int) Math.max(1, 16);
				int _r = (int) Math.max(0, Math.min(255, 53));
				int _g = (int) Math.max(0, Math.min(255, 2));
				int _b = (int) Math.max(0, Math.min(255, 2));
				double _aIn = 1;
				int _a = (int) Math.max(0, Math.min(255, Math.round((float) (_aIn * 255.0))));
				int _argb = (_a << 24) | (_r << 16) | (_g << 8) | (_b);
				net.minecraft.world.level.LevelAccessor _lvlAcc = _player.level();
				long _now = (_lvlAcc instanceof net.minecraft.world.level.Level) ? ((net.minecraft.world.level.Level) _lvlAcc).getGameTime() : 0L;
				int _dur = (int) Math.max(0, 300);
				long _until = (_dur == 0) ? java.lang.Long.MAX_VALUE : (_now + _dur);
				// ===== CHAVES LEGADAS (inalteradas) =====
				_player.getPersistentData().putString("nx_xr_block", _id);
				_player.getPersistentData().putInt("nx_xr_radius", _radius);
				_player.getPersistentData().putInt("nx_xr_color", _argb);
				_player.getPersistentData().putLong("nx_xr_until", _until);
				// ===== NOVO: múltiplos "slots" no MESMO tick (até 8) =====
				long __lastTick = _player.getPersistentData().getLong("nx_xr_lasttick");
				if (__lastTick != _now) {
					_player.getPersistentData().putLong("nx_xr_lasttick", _now);
					_player.getPersistentData().putInt("nx_xr_count", 0);
				}
				int __idx = Math.max(0, _player.getPersistentData().getInt("nx_xr_count"));
				if (__idx < 8) {
					_player.getPersistentData().putString("nx_xr_block_" + __idx, _id);
					_player.getPersistentData().putInt("nx_xr_radius_" + __idx, _radius);
					_player.getPersistentData().putInt("nx_xr_color_" + __idx, _argb);
					_player.getPersistentData().putLong("nx_xr_until_" + __idx, _until);
					_player.getPersistentData().putInt("nx_xr_count", __idx + 1);
				}
				// ===== listener de render EXATAMENTE como o seu =====
				if (!_player.getPersistentData().getBoolean("nx_xr_listener")) {
					_player.getPersistentData().putBoolean("nx_xr_listener", true);
					if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
						new Object() {
							private java.util.UUID owner;
							private com.mojang.blaze3d.vertex.VertexBuffer vb = null;

							public void start(java.util.UUID id) {
								this.owner = id;
								net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
							}

							private void buildUnitBox() {
								if (vb != null)
									return;
								com.mojang.blaze3d.vertex.BufferBuilder bb = com.mojang.blaze3d.vertex.Tesselator.getInstance().getBuilder();
								bb.begin(com.mojang.blaze3d.vertex.VertexFormat.Mode.DEBUG_LINES, com.mojang.blaze3d.vertex.DefaultVertexFormat.POSITION_COLOR);
								int white = 0xFFFFFFFF;
								add(bb, 0, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 0, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 1, 1, white);
								vb = new com.mojang.blaze3d.vertex.VertexBuffer(com.mojang.blaze3d.vertex.VertexBuffer.Usage.STATIC);
								vb.bind();
								vb.upload(bb.end());
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
							}

							private void add(com.mojang.blaze3d.vertex.BufferBuilder bb, double x, double y, double z, int color) {
								bb.vertex(x, y, z).color(color).endVertex();
							}

							@net.minecraftforge.eventbus.api.SubscribeEvent
							public void onRender(net.minecraftforge.client.event.RenderLevelStageEvent event) {
								if (event.getStage() != net.minecraftforge.client.event.RenderLevelStageEvent.Stage.AFTER_PARTICLES)
									return;
								net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
								if (mc == null)
									return;
								net.minecraft.client.multiplayer.ClientLevel level = mc.level;
								net.minecraft.world.entity.player.Player p = mc.player;
								if (level == null || p == null)
									return;
								if (!p.getUUID().equals(this.owner))
									return;
								long now = level.getGameTime();
								// monta a lista a desenhar (slots do tick atual)
								java.util.ArrayList<String[]> _draw = new java.util.ArrayList<>();
								int c = Math.max(0, p.getPersistentData().getInt("nx_xr_count"));
								for (int i = 0; i < c && i < 8; i++) {
									String id = p.getPersistentData().getString("nx_xr_block_" + i);
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius_" + i));
									int col = p.getPersistentData().getInt("nx_xr_color_" + i);
									long unt = p.getPersistentData().getLong("nx_xr_until_" + i);
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								// fallback legado (se ninguém preencheu slots)
								if (_draw.isEmpty()) {
									String id = p.getPersistentData().getString("nx_xr_block");
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius"));
									int col = p.getPersistentData().getInt("nx_xr_color");
									long unt = p.getPersistentData().getLong("nx_xr_until");
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								if (_draw.isEmpty()) {
									p.getPersistentData().putBoolean("nx_xr_listener", false);
									net.minecraftforge.common.MinecraftForge.EVENT_BUS.unregister(this);
									return;
								}
								buildUnitBox();
								// desenha por cima das paredes
								com.mojang.blaze3d.systems.RenderSystem.disableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(false);
								com.mojang.blaze3d.systems.RenderSystem.enableBlend();
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.vertex.PoseStack ps = event.getPoseStack();
								org.joml.Matrix4f proj = event.getProjectionMatrix();
								net.minecraft.world.phys.Vec3 cam = mc.gameRenderer.getMainCamera().getPosition();
								int px = (int) Math.floor(p.getX());
								int py = (int) Math.floor(p.getY());
								int pz = (int) Math.floor(p.getZ());
								vb.bind();
								for (String[] e : _draw) {
									String id = e[0];
									int radius = Integer.parseInt(e[1]);
									// ==== FIX DO CRASH: aceitar ARGB negativo ====
									int argb = Integer.parseInt(e[2]); // (antes: parseUnsignedInt)
									// =============================================
									net.minecraft.resources.ResourceLocation rl = net.minecraft.resources.ResourceLocation.tryParse(id);
									if (rl == null)
										continue;
									net.minecraft.world.level.block.Block target = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getValue(rl);
									if (target == null)
										continue;
									int r = radius;
									for (int dy = -r; dy <= r; dy++)
										for (int dx = -r; dx <= r; dx++)
											for (int dz = -r; dz <= r; dz++) {
												net.minecraft.core.BlockPos bp = new net.minecraft.core.BlockPos(px + dx, py + dy, pz + dz);
												if (level.getBlockState(bp).getBlock() == target) {
													float tx = (float) (bp.getX() - cam.x);
													float ty = (float) (bp.getY() - cam.y);
													float tz = (float) (bp.getZ() - cam.z);
													com.mojang.blaze3d.systems.RenderSystem.setShaderColor(((argb >> 16) & 255) / 255.0F, ((argb >> 8) & 255) / 255.0F, (argb & 255) / 255.0F, ((argb >>> 24) & 255) / 255.0F);
													ps.pushPose();
													ps.translate(tx, ty, tz);
													vb.drawWithShader(ps.last().pose(), proj, net.minecraft.client.renderer.GameRenderer.getPositionColorShader());
													ps.popPose();
												}
											}
								}
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
								com.mojang.blaze3d.systems.RenderSystem.setShaderColor(1, 1, 1, 1);
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.systems.RenderSystem.enableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(true);
							}
						}.start(_player.getUUID());
					}
				}
			}
		}
		{
			net.minecraft.world.entity.Entity _ent = entity;
			if (_ent instanceof net.minecraft.world.entity.player.Player _player) {
				// ===== ORIGINAL PRESERVADO =====
				String _id = "";
				try {
					Object _blkIn = Blocks.GOLD_ORE;
					if (_blkIn instanceof net.minecraft.world.level.block.state.BlockState) {
						net.minecraft.world.level.block.Block _b = ((net.minecraft.world.level.block.state.BlockState) _blkIn).getBlock();
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey(_b);
						if (_rl != null)
							_id = _rl.toString();
					} else if (_blkIn instanceof net.minecraft.world.level.block.Block) {
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey((net.minecraft.world.level.block.Block) _blkIn);
						if (_rl != null)
							_id = _rl.toString();
					} else {
						_id = String.valueOf(_blkIn);
					}
				} catch (Throwable __ignore) {
				}
				if (_id == null)
					_id = "";
				_id = _id.trim();
				int _radius = (int) Math.max(1, 16);
				int _r = (int) Math.max(0, Math.min(255, 172));
				int _g = (int) Math.max(0, Math.min(255, 170));
				int _b = (int) Math.max(0, Math.min(255, 75));
				double _aIn = 1;
				int _a = (int) Math.max(0, Math.min(255, Math.round((float) (_aIn * 255.0))));
				int _argb = (_a << 24) | (_r << 16) | (_g << 8) | (_b);
				net.minecraft.world.level.LevelAccessor _lvlAcc = _player.level();
				long _now = (_lvlAcc instanceof net.minecraft.world.level.Level) ? ((net.minecraft.world.level.Level) _lvlAcc).getGameTime() : 0L;
				int _dur = (int) Math.max(0, 300);
				long _until = (_dur == 0) ? java.lang.Long.MAX_VALUE : (_now + _dur);
				// ===== CHAVES LEGADAS (inalteradas) =====
				_player.getPersistentData().putString("nx_xr_block", _id);
				_player.getPersistentData().putInt("nx_xr_radius", _radius);
				_player.getPersistentData().putInt("nx_xr_color", _argb);
				_player.getPersistentData().putLong("nx_xr_until", _until);
				// ===== NOVO: múltiplos "slots" no MESMO tick (até 8) =====
				long __lastTick = _player.getPersistentData().getLong("nx_xr_lasttick");
				if (__lastTick != _now) {
					_player.getPersistentData().putLong("nx_xr_lasttick", _now);
					_player.getPersistentData().putInt("nx_xr_count", 0);
				}
				int __idx = Math.max(0, _player.getPersistentData().getInt("nx_xr_count"));
				if (__idx < 8) {
					_player.getPersistentData().putString("nx_xr_block_" + __idx, _id);
					_player.getPersistentData().putInt("nx_xr_radius_" + __idx, _radius);
					_player.getPersistentData().putInt("nx_xr_color_" + __idx, _argb);
					_player.getPersistentData().putLong("nx_xr_until_" + __idx, _until);
					_player.getPersistentData().putInt("nx_xr_count", __idx + 1);
				}
				// ===== listener de render EXATAMENTE como o seu =====
				if (!_player.getPersistentData().getBoolean("nx_xr_listener")) {
					_player.getPersistentData().putBoolean("nx_xr_listener", true);
					if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
						new Object() {
							private java.util.UUID owner;
							private com.mojang.blaze3d.vertex.VertexBuffer vb = null;

							public void start(java.util.UUID id) {
								this.owner = id;
								net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
							}

							private void buildUnitBox() {
								if (vb != null)
									return;
								com.mojang.blaze3d.vertex.BufferBuilder bb = com.mojang.blaze3d.vertex.Tesselator.getInstance().getBuilder();
								bb.begin(com.mojang.blaze3d.vertex.VertexFormat.Mode.DEBUG_LINES, com.mojang.blaze3d.vertex.DefaultVertexFormat.POSITION_COLOR);
								int white = 0xFFFFFFFF;
								add(bb, 0, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 0, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 1, 1, white);
								vb = new com.mojang.blaze3d.vertex.VertexBuffer(com.mojang.blaze3d.vertex.VertexBuffer.Usage.STATIC);
								vb.bind();
								vb.upload(bb.end());
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
							}

							private void add(com.mojang.blaze3d.vertex.BufferBuilder bb, double x, double y, double z, int color) {
								bb.vertex(x, y, z).color(color).endVertex();
							}

							@net.minecraftforge.eventbus.api.SubscribeEvent
							public void onRender(net.minecraftforge.client.event.RenderLevelStageEvent event) {
								if (event.getStage() != net.minecraftforge.client.event.RenderLevelStageEvent.Stage.AFTER_PARTICLES)
									return;
								net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
								if (mc == null)
									return;
								net.minecraft.client.multiplayer.ClientLevel level = mc.level;
								net.minecraft.world.entity.player.Player p = mc.player;
								if (level == null || p == null)
									return;
								if (!p.getUUID().equals(this.owner))
									return;
								long now = level.getGameTime();
								// monta a lista a desenhar (slots do tick atual)
								java.util.ArrayList<String[]> _draw = new java.util.ArrayList<>();
								int c = Math.max(0, p.getPersistentData().getInt("nx_xr_count"));
								for (int i = 0; i < c && i < 8; i++) {
									String id = p.getPersistentData().getString("nx_xr_block_" + i);
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius_" + i));
									int col = p.getPersistentData().getInt("nx_xr_color_" + i);
									long unt = p.getPersistentData().getLong("nx_xr_until_" + i);
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								// fallback legado (se ninguém preencheu slots)
								if (_draw.isEmpty()) {
									String id = p.getPersistentData().getString("nx_xr_block");
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius"));
									int col = p.getPersistentData().getInt("nx_xr_color");
									long unt = p.getPersistentData().getLong("nx_xr_until");
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								if (_draw.isEmpty()) {
									p.getPersistentData().putBoolean("nx_xr_listener", false);
									net.minecraftforge.common.MinecraftForge.EVENT_BUS.unregister(this);
									return;
								}
								buildUnitBox();
								// desenha por cima das paredes
								com.mojang.blaze3d.systems.RenderSystem.disableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(false);
								com.mojang.blaze3d.systems.RenderSystem.enableBlend();
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.vertex.PoseStack ps = event.getPoseStack();
								org.joml.Matrix4f proj = event.getProjectionMatrix();
								net.minecraft.world.phys.Vec3 cam = mc.gameRenderer.getMainCamera().getPosition();
								int px = (int) Math.floor(p.getX());
								int py = (int) Math.floor(p.getY());
								int pz = (int) Math.floor(p.getZ());
								vb.bind();
								for (String[] e : _draw) {
									String id = e[0];
									int radius = Integer.parseInt(e[1]);
									// ==== FIX DO CRASH: aceitar ARGB negativo ====
									int argb = Integer.parseInt(e[2]); // (antes: parseUnsignedInt)
									// =============================================
									net.minecraft.resources.ResourceLocation rl = net.minecraft.resources.ResourceLocation.tryParse(id);
									if (rl == null)
										continue;
									net.minecraft.world.level.block.Block target = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getValue(rl);
									if (target == null)
										continue;
									int r = radius;
									for (int dy = -r; dy <= r; dy++)
										for (int dx = -r; dx <= r; dx++)
											for (int dz = -r; dz <= r; dz++) {
												net.minecraft.core.BlockPos bp = new net.minecraft.core.BlockPos(px + dx, py + dy, pz + dz);
												if (level.getBlockState(bp).getBlock() == target) {
													float tx = (float) (bp.getX() - cam.x);
													float ty = (float) (bp.getY() - cam.y);
													float tz = (float) (bp.getZ() - cam.z);
													com.mojang.blaze3d.systems.RenderSystem.setShaderColor(((argb >> 16) & 255) / 255.0F, ((argb >> 8) & 255) / 255.0F, (argb & 255) / 255.0F, ((argb >>> 24) & 255) / 255.0F);
													ps.pushPose();
													ps.translate(tx, ty, tz);
													vb.drawWithShader(ps.last().pose(), proj, net.minecraft.client.renderer.GameRenderer.getPositionColorShader());
													ps.popPose();
												}
											}
								}
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
								com.mojang.blaze3d.systems.RenderSystem.setShaderColor(1, 1, 1, 1);
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.systems.RenderSystem.enableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(true);
							}
						}.start(_player.getUUID());
					}
				}
			}
		}
		{
			net.minecraft.world.entity.Entity _ent = entity;
			if (_ent instanceof net.minecraft.world.entity.player.Player _player) {
				// ===== ORIGINAL PRESERVADO =====
				String _id = "";
				try {
					Object _blkIn = Blocks.DEEPSLATE_GOLD_ORE;
					if (_blkIn instanceof net.minecraft.world.level.block.state.BlockState) {
						net.minecraft.world.level.block.Block _b = ((net.minecraft.world.level.block.state.BlockState) _blkIn).getBlock();
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey(_b);
						if (_rl != null)
							_id = _rl.toString();
					} else if (_blkIn instanceof net.minecraft.world.level.block.Block) {
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey((net.minecraft.world.level.block.Block) _blkIn);
						if (_rl != null)
							_id = _rl.toString();
					} else {
						_id = String.valueOf(_blkIn);
					}
				} catch (Throwable __ignore) {
				}
				if (_id == null)
					_id = "";
				_id = _id.trim();
				int _radius = (int) Math.max(1, 16);
				int _r = (int) Math.max(0, Math.min(255, 180));
				int _g = (int) Math.max(0, Math.min(255, 180));
				int _b = (int) Math.max(0, Math.min(255, 64));
				double _aIn = 1;
				int _a = (int) Math.max(0, Math.min(255, Math.round((float) (_aIn * 255.0))));
				int _argb = (_a << 24) | (_r << 16) | (_g << 8) | (_b);
				net.minecraft.world.level.LevelAccessor _lvlAcc = _player.level();
				long _now = (_lvlAcc instanceof net.minecraft.world.level.Level) ? ((net.minecraft.world.level.Level) _lvlAcc).getGameTime() : 0L;
				int _dur = (int) Math.max(0, 300);
				long _until = (_dur == 0) ? java.lang.Long.MAX_VALUE : (_now + _dur);
				// ===== CHAVES LEGADAS (inalteradas) =====
				_player.getPersistentData().putString("nx_xr_block", _id);
				_player.getPersistentData().putInt("nx_xr_radius", _radius);
				_player.getPersistentData().putInt("nx_xr_color", _argb);
				_player.getPersistentData().putLong("nx_xr_until", _until);
				// ===== NOVO: múltiplos "slots" no MESMO tick (até 8) =====
				long __lastTick = _player.getPersistentData().getLong("nx_xr_lasttick");
				if (__lastTick != _now) {
					_player.getPersistentData().putLong("nx_xr_lasttick", _now);
					_player.getPersistentData().putInt("nx_xr_count", 0);
				}
				int __idx = Math.max(0, _player.getPersistentData().getInt("nx_xr_count"));
				if (__idx < 8) {
					_player.getPersistentData().putString("nx_xr_block_" + __idx, _id);
					_player.getPersistentData().putInt("nx_xr_radius_" + __idx, _radius);
					_player.getPersistentData().putInt("nx_xr_color_" + __idx, _argb);
					_player.getPersistentData().putLong("nx_xr_until_" + __idx, _until);
					_player.getPersistentData().putInt("nx_xr_count", __idx + 1);
				}
				// ===== listener de render EXATAMENTE como o seu =====
				if (!_player.getPersistentData().getBoolean("nx_xr_listener")) {
					_player.getPersistentData().putBoolean("nx_xr_listener", true);
					if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
						new Object() {
							private java.util.UUID owner;
							private com.mojang.blaze3d.vertex.VertexBuffer vb = null;

							public void start(java.util.UUID id) {
								this.owner = id;
								net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
							}

							private void buildUnitBox() {
								if (vb != null)
									return;
								com.mojang.blaze3d.vertex.BufferBuilder bb = com.mojang.blaze3d.vertex.Tesselator.getInstance().getBuilder();
								bb.begin(com.mojang.blaze3d.vertex.VertexFormat.Mode.DEBUG_LINES, com.mojang.blaze3d.vertex.DefaultVertexFormat.POSITION_COLOR);
								int white = 0xFFFFFFFF;
								add(bb, 0, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 0, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 1, 1, white);
								vb = new com.mojang.blaze3d.vertex.VertexBuffer(com.mojang.blaze3d.vertex.VertexBuffer.Usage.STATIC);
								vb.bind();
								vb.upload(bb.end());
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
							}

							private void add(com.mojang.blaze3d.vertex.BufferBuilder bb, double x, double y, double z, int color) {
								bb.vertex(x, y, z).color(color).endVertex();
							}

							@net.minecraftforge.eventbus.api.SubscribeEvent
							public void onRender(net.minecraftforge.client.event.RenderLevelStageEvent event) {
								if (event.getStage() != net.minecraftforge.client.event.RenderLevelStageEvent.Stage.AFTER_PARTICLES)
									return;
								net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
								if (mc == null)
									return;
								net.minecraft.client.multiplayer.ClientLevel level = mc.level;
								net.minecraft.world.entity.player.Player p = mc.player;
								if (level == null || p == null)
									return;
								if (!p.getUUID().equals(this.owner))
									return;
								long now = level.getGameTime();
								// monta a lista a desenhar (slots do tick atual)
								java.util.ArrayList<String[]> _draw = new java.util.ArrayList<>();
								int c = Math.max(0, p.getPersistentData().getInt("nx_xr_count"));
								for (int i = 0; i < c && i < 8; i++) {
									String id = p.getPersistentData().getString("nx_xr_block_" + i);
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius_" + i));
									int col = p.getPersistentData().getInt("nx_xr_color_" + i);
									long unt = p.getPersistentData().getLong("nx_xr_until_" + i);
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								// fallback legado (se ninguém preencheu slots)
								if (_draw.isEmpty()) {
									String id = p.getPersistentData().getString("nx_xr_block");
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius"));
									int col = p.getPersistentData().getInt("nx_xr_color");
									long unt = p.getPersistentData().getLong("nx_xr_until");
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								if (_draw.isEmpty()) {
									p.getPersistentData().putBoolean("nx_xr_listener", false);
									net.minecraftforge.common.MinecraftForge.EVENT_BUS.unregister(this);
									return;
								}
								buildUnitBox();
								// desenha por cima das paredes
								com.mojang.blaze3d.systems.RenderSystem.disableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(false);
								com.mojang.blaze3d.systems.RenderSystem.enableBlend();
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.vertex.PoseStack ps = event.getPoseStack();
								org.joml.Matrix4f proj = event.getProjectionMatrix();
								net.minecraft.world.phys.Vec3 cam = mc.gameRenderer.getMainCamera().getPosition();
								int px = (int) Math.floor(p.getX());
								int py = (int) Math.floor(p.getY());
								int pz = (int) Math.floor(p.getZ());
								vb.bind();
								for (String[] e : _draw) {
									String id = e[0];
									int radius = Integer.parseInt(e[1]);
									// ==== FIX DO CRASH: aceitar ARGB negativo ====
									int argb = Integer.parseInt(e[2]); // (antes: parseUnsignedInt)
									// =============================================
									net.minecraft.resources.ResourceLocation rl = net.minecraft.resources.ResourceLocation.tryParse(id);
									if (rl == null)
										continue;
									net.minecraft.world.level.block.Block target = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getValue(rl);
									if (target == null)
										continue;
									int r = radius;
									for (int dy = -r; dy <= r; dy++)
										for (int dx = -r; dx <= r; dx++)
											for (int dz = -r; dz <= r; dz++) {
												net.minecraft.core.BlockPos bp = new net.minecraft.core.BlockPos(px + dx, py + dy, pz + dz);
												if (level.getBlockState(bp).getBlock() == target) {
													float tx = (float) (bp.getX() - cam.x);
													float ty = (float) (bp.getY() - cam.y);
													float tz = (float) (bp.getZ() - cam.z);
													com.mojang.blaze3d.systems.RenderSystem.setShaderColor(((argb >> 16) & 255) / 255.0F, ((argb >> 8) & 255) / 255.0F, (argb & 255) / 255.0F, ((argb >>> 24) & 255) / 255.0F);
													ps.pushPose();
													ps.translate(tx, ty, tz);
													vb.drawWithShader(ps.last().pose(), proj, net.minecraft.client.renderer.GameRenderer.getPositionColorShader());
													ps.popPose();
												}
											}
								}
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
								com.mojang.blaze3d.systems.RenderSystem.setShaderColor(1, 1, 1, 1);
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.systems.RenderSystem.enableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(true);
							}
						}.start(_player.getUUID());
					}
				}
			}
		}
		{
			net.minecraft.world.entity.Entity _ent = entity;
			if (_ent instanceof net.minecraft.world.entity.player.Player _player) {
				// ===== ORIGINAL PRESERVADO =====
				String _id = "";
				try {
					Object _blkIn = Blocks.IRON_ORE;
					if (_blkIn instanceof net.minecraft.world.level.block.state.BlockState) {
						net.minecraft.world.level.block.Block _b = ((net.minecraft.world.level.block.state.BlockState) _blkIn).getBlock();
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey(_b);
						if (_rl != null)
							_id = _rl.toString();
					} else if (_blkIn instanceof net.minecraft.world.level.block.Block) {
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey((net.minecraft.world.level.block.Block) _blkIn);
						if (_rl != null)
							_id = _rl.toString();
					} else {
						_id = String.valueOf(_blkIn);
					}
				} catch (Throwable __ignore) {
				}
				if (_id == null)
					_id = "";
				_id = _id.trim();
				int _radius = (int) Math.max(1, 16);
				int _r = (int) Math.max(0, Math.min(255, 185));
				int _g = (int) Math.max(0, Math.min(255, 186));
				int _b = (int) Math.max(0, Math.min(255, 189));
				double _aIn = 1;
				int _a = (int) Math.max(0, Math.min(255, Math.round((float) (_aIn * 255.0))));
				int _argb = (_a << 24) | (_r << 16) | (_g << 8) | (_b);
				net.minecraft.world.level.LevelAccessor _lvlAcc = _player.level();
				long _now = (_lvlAcc instanceof net.minecraft.world.level.Level) ? ((net.minecraft.world.level.Level) _lvlAcc).getGameTime() : 0L;
				int _dur = (int) Math.max(0, 300);
				long _until = (_dur == 0) ? java.lang.Long.MAX_VALUE : (_now + _dur);
				// ===== CHAVES LEGADAS (inalteradas) =====
				_player.getPersistentData().putString("nx_xr_block", _id);
				_player.getPersistentData().putInt("nx_xr_radius", _radius);
				_player.getPersistentData().putInt("nx_xr_color", _argb);
				_player.getPersistentData().putLong("nx_xr_until", _until);
				// ===== NOVO: múltiplos "slots" no MESMO tick (até 8) =====
				long __lastTick = _player.getPersistentData().getLong("nx_xr_lasttick");
				if (__lastTick != _now) {
					_player.getPersistentData().putLong("nx_xr_lasttick", _now);
					_player.getPersistentData().putInt("nx_xr_count", 0);
				}
				int __idx = Math.max(0, _player.getPersistentData().getInt("nx_xr_count"));
				if (__idx < 8) {
					_player.getPersistentData().putString("nx_xr_block_" + __idx, _id);
					_player.getPersistentData().putInt("nx_xr_radius_" + __idx, _radius);
					_player.getPersistentData().putInt("nx_xr_color_" + __idx, _argb);
					_player.getPersistentData().putLong("nx_xr_until_" + __idx, _until);
					_player.getPersistentData().putInt("nx_xr_count", __idx + 1);
				}
				// ===== listener de render EXATAMENTE como o seu =====
				if (!_player.getPersistentData().getBoolean("nx_xr_listener")) {
					_player.getPersistentData().putBoolean("nx_xr_listener", true);
					if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
						new Object() {
							private java.util.UUID owner;
							private com.mojang.blaze3d.vertex.VertexBuffer vb = null;

							public void start(java.util.UUID id) {
								this.owner = id;
								net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
							}

							private void buildUnitBox() {
								if (vb != null)
									return;
								com.mojang.blaze3d.vertex.BufferBuilder bb = com.mojang.blaze3d.vertex.Tesselator.getInstance().getBuilder();
								bb.begin(com.mojang.blaze3d.vertex.VertexFormat.Mode.DEBUG_LINES, com.mojang.blaze3d.vertex.DefaultVertexFormat.POSITION_COLOR);
								int white = 0xFFFFFFFF;
								add(bb, 0, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 0, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 1, 1, white);
								vb = new com.mojang.blaze3d.vertex.VertexBuffer(com.mojang.blaze3d.vertex.VertexBuffer.Usage.STATIC);
								vb.bind();
								vb.upload(bb.end());
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
							}

							private void add(com.mojang.blaze3d.vertex.BufferBuilder bb, double x, double y, double z, int color) {
								bb.vertex(x, y, z).color(color).endVertex();
							}

							@net.minecraftforge.eventbus.api.SubscribeEvent
							public void onRender(net.minecraftforge.client.event.RenderLevelStageEvent event) {
								if (event.getStage() != net.minecraftforge.client.event.RenderLevelStageEvent.Stage.AFTER_PARTICLES)
									return;
								net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
								if (mc == null)
									return;
								net.minecraft.client.multiplayer.ClientLevel level = mc.level;
								net.minecraft.world.entity.player.Player p = mc.player;
								if (level == null || p == null)
									return;
								if (!p.getUUID().equals(this.owner))
									return;
								long now = level.getGameTime();
								// monta a lista a desenhar (slots do tick atual)
								java.util.ArrayList<String[]> _draw = new java.util.ArrayList<>();
								int c = Math.max(0, p.getPersistentData().getInt("nx_xr_count"));
								for (int i = 0; i < c && i < 8; i++) {
									String id = p.getPersistentData().getString("nx_xr_block_" + i);
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius_" + i));
									int col = p.getPersistentData().getInt("nx_xr_color_" + i);
									long unt = p.getPersistentData().getLong("nx_xr_until_" + i);
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								// fallback legado (se ninguém preencheu slots)
								if (_draw.isEmpty()) {
									String id = p.getPersistentData().getString("nx_xr_block");
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius"));
									int col = p.getPersistentData().getInt("nx_xr_color");
									long unt = p.getPersistentData().getLong("nx_xr_until");
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								if (_draw.isEmpty()) {
									p.getPersistentData().putBoolean("nx_xr_listener", false);
									net.minecraftforge.common.MinecraftForge.EVENT_BUS.unregister(this);
									return;
								}
								buildUnitBox();
								// desenha por cima das paredes
								com.mojang.blaze3d.systems.RenderSystem.disableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(false);
								com.mojang.blaze3d.systems.RenderSystem.enableBlend();
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.vertex.PoseStack ps = event.getPoseStack();
								org.joml.Matrix4f proj = event.getProjectionMatrix();
								net.minecraft.world.phys.Vec3 cam = mc.gameRenderer.getMainCamera().getPosition();
								int px = (int) Math.floor(p.getX());
								int py = (int) Math.floor(p.getY());
								int pz = (int) Math.floor(p.getZ());
								vb.bind();
								for (String[] e : _draw) {
									String id = e[0];
									int radius = Integer.parseInt(e[1]);
									// ==== FIX DO CRASH: aceitar ARGB negativo ====
									int argb = Integer.parseInt(e[2]); // (antes: parseUnsignedInt)
									// =============================================
									net.minecraft.resources.ResourceLocation rl = net.minecraft.resources.ResourceLocation.tryParse(id);
									if (rl == null)
										continue;
									net.minecraft.world.level.block.Block target = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getValue(rl);
									if (target == null)
										continue;
									int r = radius;
									for (int dy = -r; dy <= r; dy++)
										for (int dx = -r; dx <= r; dx++)
											for (int dz = -r; dz <= r; dz++) {
												net.minecraft.core.BlockPos bp = new net.minecraft.core.BlockPos(px + dx, py + dy, pz + dz);
												if (level.getBlockState(bp).getBlock() == target) {
													float tx = (float) (bp.getX() - cam.x);
													float ty = (float) (bp.getY() - cam.y);
													float tz = (float) (bp.getZ() - cam.z);
													com.mojang.blaze3d.systems.RenderSystem.setShaderColor(((argb >> 16) & 255) / 255.0F, ((argb >> 8) & 255) / 255.0F, (argb & 255) / 255.0F, ((argb >>> 24) & 255) / 255.0F);
													ps.pushPose();
													ps.translate(tx, ty, tz);
													vb.drawWithShader(ps.last().pose(), proj, net.minecraft.client.renderer.GameRenderer.getPositionColorShader());
													ps.popPose();
												}
											}
								}
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
								com.mojang.blaze3d.systems.RenderSystem.setShaderColor(1, 1, 1, 1);
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.systems.RenderSystem.enableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(true);
							}
						}.start(_player.getUUID());
					}
				}
			}
		}
		{
			net.minecraft.world.entity.Entity _ent = entity;
			if (_ent instanceof net.minecraft.world.entity.player.Player _player) {
				// ===== ORIGINAL PRESERVADO =====
				String _id = "";
				try {
					Object _blkIn = Blocks.DEEPSLATE_IRON_ORE;
					if (_blkIn instanceof net.minecraft.world.level.block.state.BlockState) {
						net.minecraft.world.level.block.Block _b = ((net.minecraft.world.level.block.state.BlockState) _blkIn).getBlock();
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey(_b);
						if (_rl != null)
							_id = _rl.toString();
					} else if (_blkIn instanceof net.minecraft.world.level.block.Block) {
						net.minecraft.resources.ResourceLocation _rl = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey((net.minecraft.world.level.block.Block) _blkIn);
						if (_rl != null)
							_id = _rl.toString();
					} else {
						_id = String.valueOf(_blkIn);
					}
				} catch (Throwable __ignore) {
				}
				if (_id == null)
					_id = "";
				_id = _id.trim();
				int _radius = (int) Math.max(1, 16);
				int _r = (int) Math.max(0, Math.min(255, 137));
				int _g = (int) Math.max(0, Math.min(255, 139));
				int _b = (int) Math.max(0, Math.min(255, 140));
				double _aIn = 1;
				int _a = (int) Math.max(0, Math.min(255, Math.round((float) (_aIn * 255.0))));
				int _argb = (_a << 24) | (_r << 16) | (_g << 8) | (_b);
				net.minecraft.world.level.LevelAccessor _lvlAcc = _player.level();
				long _now = (_lvlAcc instanceof net.minecraft.world.level.Level) ? ((net.minecraft.world.level.Level) _lvlAcc).getGameTime() : 0L;
				int _dur = (int) Math.max(0, 300);
				long _until = (_dur == 0) ? java.lang.Long.MAX_VALUE : (_now + _dur);
				// ===== CHAVES LEGADAS (inalteradas) =====
				_player.getPersistentData().putString("nx_xr_block", _id);
				_player.getPersistentData().putInt("nx_xr_radius", _radius);
				_player.getPersistentData().putInt("nx_xr_color", _argb);
				_player.getPersistentData().putLong("nx_xr_until", _until);
				// ===== NOVO: múltiplos "slots" no MESMO tick (até 8) =====
				long __lastTick = _player.getPersistentData().getLong("nx_xr_lasttick");
				if (__lastTick != _now) {
					_player.getPersistentData().putLong("nx_xr_lasttick", _now);
					_player.getPersistentData().putInt("nx_xr_count", 0);
				}
				int __idx = Math.max(0, _player.getPersistentData().getInt("nx_xr_count"));
				if (__idx < 8) {
					_player.getPersistentData().putString("nx_xr_block_" + __idx, _id);
					_player.getPersistentData().putInt("nx_xr_radius_" + __idx, _radius);
					_player.getPersistentData().putInt("nx_xr_color_" + __idx, _argb);
					_player.getPersistentData().putLong("nx_xr_until_" + __idx, _until);
					_player.getPersistentData().putInt("nx_xr_count", __idx + 1);
				}
				// ===== listener de render EXATAMENTE como o seu =====
				if (!_player.getPersistentData().getBoolean("nx_xr_listener")) {
					_player.getPersistentData().putBoolean("nx_xr_listener", true);
					if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
						new Object() {
							private java.util.UUID owner;
							private com.mojang.blaze3d.vertex.VertexBuffer vb = null;

							public void start(java.util.UUID id) {
								this.owner = id;
								net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
							}

							private void buildUnitBox() {
								if (vb != null)
									return;
								com.mojang.blaze3d.vertex.BufferBuilder bb = com.mojang.blaze3d.vertex.Tesselator.getInstance().getBuilder();
								bb.begin(com.mojang.blaze3d.vertex.VertexFormat.Mode.DEBUG_LINES, com.mojang.blaze3d.vertex.DefaultVertexFormat.POSITION_COLOR);
								int white = 0xFFFFFFFF;
								add(bb, 0, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 1, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 1, white);
								add(bb, 0, 1, 0, white);
								add(bb, 0, 0, 0, white);
								add(bb, 0, 1, 0, white);
								add(bb, 1, 0, 0, white);
								add(bb, 1, 1, 0, white);
								add(bb, 1, 0, 1, white);
								add(bb, 1, 1, 1, white);
								add(bb, 0, 0, 1, white);
								add(bb, 0, 1, 1, white);
								vb = new com.mojang.blaze3d.vertex.VertexBuffer(com.mojang.blaze3d.vertex.VertexBuffer.Usage.STATIC);
								vb.bind();
								vb.upload(bb.end());
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
							}

							private void add(com.mojang.blaze3d.vertex.BufferBuilder bb, double x, double y, double z, int color) {
								bb.vertex(x, y, z).color(color).endVertex();
							}

							@net.minecraftforge.eventbus.api.SubscribeEvent
							public void onRender(net.minecraftforge.client.event.RenderLevelStageEvent event) {
								if (event.getStage() != net.minecraftforge.client.event.RenderLevelStageEvent.Stage.AFTER_PARTICLES)
									return;
								net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
								if (mc == null)
									return;
								net.minecraft.client.multiplayer.ClientLevel level = mc.level;
								net.minecraft.world.entity.player.Player p = mc.player;
								if (level == null || p == null)
									return;
								if (!p.getUUID().equals(this.owner))
									return;
								long now = level.getGameTime();
								// monta a lista a desenhar (slots do tick atual)
								java.util.ArrayList<String[]> _draw = new java.util.ArrayList<>();
								int c = Math.max(0, p.getPersistentData().getInt("nx_xr_count"));
								for (int i = 0; i < c && i < 8; i++) {
									String id = p.getPersistentData().getString("nx_xr_block_" + i);
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius_" + i));
									int col = p.getPersistentData().getInt("nx_xr_color_" + i);
									long unt = p.getPersistentData().getLong("nx_xr_until_" + i);
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								// fallback legado (se ninguém preencheu slots)
								if (_draw.isEmpty()) {
									String id = p.getPersistentData().getString("nx_xr_block");
									int rad = Math.max(1, p.getPersistentData().getInt("nx_xr_radius"));
									int col = p.getPersistentData().getInt("nx_xr_color");
									long unt = p.getPersistentData().getLong("nx_xr_until");
									if (id != null && !id.isEmpty() && unt > now)
										_draw.add(new String[]{id, String.valueOf(rad), String.valueOf(col)});
								}
								if (_draw.isEmpty()) {
									p.getPersistentData().putBoolean("nx_xr_listener", false);
									net.minecraftforge.common.MinecraftForge.EVENT_BUS.unregister(this);
									return;
								}
								buildUnitBox();
								// desenha por cima das paredes
								com.mojang.blaze3d.systems.RenderSystem.disableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(false);
								com.mojang.blaze3d.systems.RenderSystem.enableBlend();
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.vertex.PoseStack ps = event.getPoseStack();
								org.joml.Matrix4f proj = event.getProjectionMatrix();
								net.minecraft.world.phys.Vec3 cam = mc.gameRenderer.getMainCamera().getPosition();
								int px = (int) Math.floor(p.getX());
								int py = (int) Math.floor(p.getY());
								int pz = (int) Math.floor(p.getZ());
								vb.bind();
								for (String[] e : _draw) {
									String id = e[0];
									int radius = Integer.parseInt(e[1]);
									// ==== FIX DO CRASH: aceitar ARGB negativo ====
									int argb = Integer.parseInt(e[2]); // (antes: parseUnsignedInt)
									// =============================================
									net.minecraft.resources.ResourceLocation rl = net.minecraft.resources.ResourceLocation.tryParse(id);
									if (rl == null)
										continue;
									net.minecraft.world.level.block.Block target = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getValue(rl);
									if (target == null)
										continue;
									int r = radius;
									for (int dy = -r; dy <= r; dy++)
										for (int dx = -r; dx <= r; dx++)
											for (int dz = -r; dz <= r; dz++) {
												net.minecraft.core.BlockPos bp = new net.minecraft.core.BlockPos(px + dx, py + dy, pz + dz);
												if (level.getBlockState(bp).getBlock() == target) {
													float tx = (float) (bp.getX() - cam.x);
													float ty = (float) (bp.getY() - cam.y);
													float tz = (float) (bp.getZ() - cam.z);
													com.mojang.blaze3d.systems.RenderSystem.setShaderColor(((argb >> 16) & 255) / 255.0F, ((argb >> 8) & 255) / 255.0F, (argb & 255) / 255.0F, ((argb >>> 24) & 255) / 255.0F);
													ps.pushPose();
													ps.translate(tx, ty, tz);
													vb.drawWithShader(ps.last().pose(), proj, net.minecraft.client.renderer.GameRenderer.getPositionColorShader());
													ps.popPose();
												}
											}
								}
								com.mojang.blaze3d.vertex.VertexBuffer.unbind();
								com.mojang.blaze3d.systems.RenderSystem.setShaderColor(1, 1, 1, 1);
								com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
								com.mojang.blaze3d.systems.RenderSystem.enableDepthTest();
								com.mojang.blaze3d.systems.RenderSystem.depthMask(true);
							}
						}.start(_player.getUUID());
					}
				}
			}
		}
	}
}
