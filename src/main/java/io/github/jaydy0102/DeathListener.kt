@file:Suppress("DEPRECATION")

package io.github.jaydy0102

import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import java.util.*

class DeathListener : Listener {
    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {
        // REMOVE A LIFE
        val player = e.entity
        val victimHearts = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)

        if (victimHearts!!.baseValue == 0.0) {
            Bukkit.getScheduler().runTaskLater(EdgarMain.instance, Runnable {
                player.banPlayer("No more lives. Rejoin in 8 hours to revive with 5 hearts.", Calendar.getInstance().apply { add(Calendar.MINUTE, ConfigManager.banDuration) }.time) }, 1)
        }
        else victimHearts.baseValue -= 2.0

        // ADD A LIFE IF KILLER
        val killer = e.player.killer ?: return
        if (killer.uniqueId == player.uniqueId) return
        val killerHearts = killer.getAttribute(Attribute.GENERIC_MAX_HEALTH)
        killerHearts!!.baseValue += 2.0
    }
}