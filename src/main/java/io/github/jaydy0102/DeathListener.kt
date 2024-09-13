package io.github.jaydy0102

import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Warden
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.PlayerDeathEvent
import java.time.Duration
import kotlin.random.Random.Default.nextInt

class DeathListener : Listener {
    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {
        // REMOVE A LIFE
        val player = e.entity
        val banperiodstring = ConfigManager.banDurationString
        val banperiodlong = ConfigManager.banDurationLong
        val victimHearts = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)

        if (victimHearts!!.baseValue == 0.0) {
            player.ban("No more lives. Rejoin in $banperiodstring minutes to revive with 3 hearts.", Duration.ofMinutes(banperiodlong), null, true)
        }
        else victimHearts.baseValue -= 2.0

        // ADD A LIFE IF KILLER
        val killer = e.player.killer ?: return
        if (killer.uniqueId == player.uniqueId) return
        val killerHearts = killer.getAttribute(Attribute.GENERIC_MAX_HEALTH)
        if (killerHearts!!.baseValue < 60.0) {
            killerHearts.baseValue += 2.0
        }
    }
    @EventHandler
    fun onEntityDeath(event: EntityDeathEvent) {
        val entity = event.entity
        val loc = entity.location
        val item = Recipe.wardenHeartItemStack
        if (entity is Warden) {
            if (nextInt(3)==0) {
                loc.world.dropItem(loc, item)
            }
        }
    }
}