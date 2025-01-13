package io.github.jaydy0102

import io.papermc.paper.event.player.PrePlayerAttackEntityEvent
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random.Default.nextInt
import org.joml.Math.sin
import org.joml.Math.cos
import org.joml.Math.toRadians

class AttackListener : Listener {
    @EventHandler
    fun onAttackPlayer(event: PrePlayerAttackEntityEvent) {
        val entity = event.attacked
        val player = event.player
        val loc = entity.location.add(0.0, 1.0, 0.0)
        val x = loc.x
        val y = loc.y
        val z = loc.z
        val yaw = entity.yaw
        val radyaw = toRadians(entity.yaw)
        val item = event.player.inventory.itemInMainHand
        val meta = item.itemMeta

        if (item.type == Material.NETHERITE_SWORD) {
            if (item.itemMeta.hasCustomModelData()) {
                if (meta.customModelData == 1) {
                    player.addPotionEffect(PotionEffect(PotionEffectType.INSTANT_HEALTH, 20, 0, true, true))
                    if (entity.type == EntityType.ARMOR_STAND) {
                        return
                    } else if (entity is LivingEntity)
                    player.giveExp(1, true)
                }
                if (meta.customModelData == 3) {
                    if (nextInt(4) == 0) {
                        loc.world.spawnParticle(Particle.DRAGON_BREATH, loc, 50, 0.0, 1.0, 0.0, 0.0)
                        if (yaw < 90) {
                            val loc1 = Location(loc.world, x + 1.5 * sin(radyaw), y - 1, z - 1.5 * cos(radyaw), yaw, 0f)
                            player.teleport(loc1)
                        } else if (yaw < 180) {
                            val loc1 = Location(loc.world, x + 1.5 * cos(radyaw), y - 1, z + 1.5 * sin(radyaw), yaw, 0f)
                            player.teleport(loc1)
                        } else if (yaw < 270) {
                            val loc1 = Location(loc.world, x - 1.5 * cos(radyaw), y - 1, z + 1.5 * sin(radyaw), yaw, 0f)
                            player.teleport(loc1)
                        } else if (yaw <= 360) {
                            val loc1 = Location(loc.world, x - 1.5 * cos(radyaw), y - 1, z - 1.5 * sin(radyaw), yaw, 0f)
                            player.teleport(loc1)
                        }
                    }
                }
                if (meta.customModelData == 4) {
                    if (entity is Player) {
                        loc.world.spawnParticle(Particle.SMOKE, loc, 50, 0.0, 1.0, 0.0, 0.0)
                        entity.addPotionEffect(PotionEffect(PotionEffectType.WITHER, 50, 0, true, true))
                    }
                }
                if (meta.customModelData == 5) {
                    if (nextInt(1) == 0) {
                        if (entity is Player) {
                            entity.addPotionEffect(PotionEffect(PotionEffectType.MINING_FATIGUE, 90, 4, true, true))
                        }
                    }
                }
                if (meta.customModelData == 6) {
                    if (nextInt(4) == 0) {
                        if (entity is Player) {
                            entity.addPotionEffect(PotionEffect(PotionEffectType.LEVITATION, 30, 0, true, true))
                        }
                    }
                }
                if (meta.customModelData == 7) {
                    if (nextInt(4) == 0) {
                        if (entity is Player) {
                            entity.addPotionEffect(PotionEffect(PotionEffectType.POISON, 40, 0, true, true))
                        }
                    }
                }
                if (meta.customModelData == 8) {
                    if (nextInt(4) == 0) {
                        if (entity is Player) {
                            entity.addPotionEffect(PotionEffect(PotionEffectType.SLOWNESS, 40, 0, true, true))
                        }
                    }
                }
            }
        }
    }
}